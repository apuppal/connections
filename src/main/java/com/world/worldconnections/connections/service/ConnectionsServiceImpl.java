package com.world.worldconnections.connections.service;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import com.world.worldconnections.connections.model.ConnectionsResponse;
import com.world.worldconnections.connections.model.Forecast;
import com.world.worldconnections.connections.model.ForecastResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.util.*;


/**
 * @author anupkumarpuppala on 2019-02-18
 */
@Service
public class ConnectionsServiceImpl implements ConnectionsService {

    @Value("${connections.cities.file}")
    private String file;
    private Multimap<String, String> map = TreeMultimap.create();
    private ConnectionsResponse connectionsResponse = new ConnectionsResponse();
    private final String temperaturesAPI = "https://weather.cit.api.here.com/weather/1.0/report.json?product=forecast_hourly&name=";
    private final String temperaturesAPI1 = "&app_id=DemoAppId01082013GAL&app_code=AJKnXv84fjrb0KIHawS0Tg";



    @PostConstruct
    public void init() throws IOException {
        Resource resource = new ClassPathResource(file);
        InputStream resourceAsStream = resource.getInputStream();
        Scanner scanner = new Scanner(resourceAsStream);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split(",");
            map.put(split[0].trim(), split[1].trim());
        }
    }

    @Override
    public boolean isConnected(String city1, String city2) {

        return map.containsEntry(city1, city2) || map.containsEntry(city2, city1);

    }

    @Override
    public boolean addCities(String city1, String city2) {
        map.put(city1, city2);
        return true;
    }

    public ConnectionsResponse getTemperatures(int zip) {
        RestTemplate restTemplate = new RestTemplate();
        ForecastResponse response = restTemplate.getForObject(temperaturesAPI+zip+temperaturesAPI1, ForecastResponse.class);
        if(response != null){
        Forecast[] forecasts = response.getHourlyForecasts().getForecastLocation().getForecast();
        Calendar c = Calendar.getInstance();
        Date today = new Date();
        c.setTime(today);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        HashMap<String, Object> forecastTomorrow = new HashMap<>();
        ArrayList<Forecast> temperatures = new ArrayList<>();
        for (Forecast forecast : forecasts) {
            if (dayOfWeek + 1 == Integer.parseInt(forecast.getDayOfWeek())) {
                temperatures.add(forecast);
            }
        }
        temperatures.sort(Forecast.tempComparator);
        connectionsResponse.settemperatures(temperatures.get(1));
        Forecast tem = temperatures.get(1);
        String hour = tem.getLocalTime();
        forecastTomorrow.put("coolestHour", hour.substring(0, 2));
        forecastTomorrow.put("utcEquivalent", tem.getUtcTime());

        connectionsResponse.setHourlyForecasts(forecastTomorrow);}
        return connectionsResponse;
    }
    public String getCoolestHour(int zip) {
            ConnectionsResponse res = getTemperatures(zip);
            String resp = res.gettemperatures().getLocalTime();
            return resp.substring(0,2);

    }

}