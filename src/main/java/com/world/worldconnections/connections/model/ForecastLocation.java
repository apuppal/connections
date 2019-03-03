package com.world.worldconnections.connections.model;

import java.util.Arrays;

/**
 * @author anupkumarpuppala on 2019-03-02
 */
public class ForecastLocation
{
    private Forecast[] forecast;

    public Forecast[] getForecast ()
    {
        return forecast;
    }

    public void setForecast (Forecast[] forecast)
    {
        this.forecast = forecast;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [forecast = "+ Arrays.toString(forecast) +"]";
    }
}
