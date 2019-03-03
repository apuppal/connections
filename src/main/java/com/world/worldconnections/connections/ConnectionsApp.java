package com.world.worldconnections.connections;

import com.world.worldconnections.connections.service.ConnectionsServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

/**
 * @author anupkumarpuppala on 2019-02-16
 */
@SpringBootApplication
public class ConnectionsApp {

    public static void main(String[] args)  {
        SpringApplication.run(ConnectionsApp.class, args);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Zip code to get the coolest hour for the tomorrow: ");
        int zip = sc.nextInt();
        ConnectionsServiceImpl service = new ConnectionsServiceImpl();
        System.out.println(service.getCoolestHour(zip)+"00 hrs");
    }

}