package com.world.worldconnections.connections.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author anupkumarpuppala on 2019-02-16
 */

public class ConnectionsResponse implements Serializable, Cloneable {

    @ApiModelProperty(value = "hourlyForecasts", required = true)
    private
    HashMap<String, Object> hourlyForecasts = new HashMap<>();

    public Forecast gettemperatures() {
        return temperatures;
    }

    public void settemperatures(Forecast temperatures) {
        this.temperatures = temperatures;
    }

    @ApiModelProperty(value = "temperatures", required = true)
    private Forecast temperatures ;

    public HashMap<String, Object> getHourlyForecasts() {
        return hourlyForecasts;
    }

    public void setHourlyForecasts(HashMap<String, Object> hourlyForecasts) {
        this.hourlyForecasts = hourlyForecasts;
    }



}
