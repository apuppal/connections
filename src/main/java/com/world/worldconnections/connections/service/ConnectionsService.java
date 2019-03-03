package com.world.worldconnections.connections.service;

/**
 * @author anupkumarpuppala on 2019-02-18
 */
public interface ConnectionsService {
     boolean isConnected(String city1, String city2);
     boolean addCities(String city1, String city2);
}
