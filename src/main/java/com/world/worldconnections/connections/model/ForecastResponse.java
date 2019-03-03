package com.world.worldconnections.connections.model;

import java.util.HashMap;

/**
 * @author anupkumarpuppala on 2019-03-02
 */
public class ForecastResponse {

    private HourlyForecasts hourlyForecasts;

    public HourlyForecasts getHourlyForecasts ()
    {
        return hourlyForecasts;
    }

    public void setHourlyForecasts (HourlyForecasts hourlyForecasts)
    {
        this.hourlyForecasts = hourlyForecasts;
    }

    public HashMap<String, Object> getSome() {
        return some;
    }

    public void setSome(HashMap<String, Object> some) {
        this.some = some;
    }

    private HashMap<String, Object> some = new HashMap<>();


    @Override
    public String toString()
    {
        return "ClassPojo [hourlyForecasts = "+hourlyForecasts+"]";
    }
}
