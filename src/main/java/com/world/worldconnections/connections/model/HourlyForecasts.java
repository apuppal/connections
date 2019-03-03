package com.world.worldconnections.connections.model;

/**
 * @author anupkumarpuppala on 2019-03-02
 */
public class HourlyForecasts
{
    private ForecastLocation forecastLocation;

    public ForecastLocation getForecastLocation ()
    {
        return forecastLocation;
    }

    public void setForecastLocation (ForecastLocation forecastLocation)
    {
        this.forecastLocation = forecastLocation;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [forecastLocation = "+forecastLocation+"]";
    }
}

