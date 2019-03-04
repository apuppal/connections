package com.world.worldconnections.connections.service;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;
import com.world.worldconnections.connections.model.ConnectionsResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author anupkumarpuppala on 2019-03-03
 */
@RunWith(PowerMockRunner.class)
public class ConnectionsServiceImplTest {

    public ConnectionsServiceImplTest(){
        file = "/cities.txt";
    }

/*    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(ConnectionsServiceImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/

    @InjectMocks
    ConnectionsServiceImpl connectionsService;

    @Mock
    ConnectionsResponse connectionsResponse;
    @Value("${connections.cities.file}")
    private String file;
    private String c1 = "New York";
    private String c2 = "Philadelphia";
    private String c3 = "Boston";
    private int zip = 63017;
    private String coolest = "";

    @Before
    public void setUp(){
        Resource resource = new ClassPathResource(file);
        Multimap<String, String> map = TreeMultimap.create();
        ConnectionsResponse response;

    }
    @Test(expected = Exception.class)
    public void init() throws IOException {

        connectionsService.init();
    }

    @Test
    public void isConnected() {

        assertFalse("expected to fail as cant initialize map i.e false", connectionsService.isConnected(c1, c2));
    }

    @Test
    public void addCities() {
        assertTrue("adding into map", connectionsService.addCities(c1, c3));
    }

    @Test
    public void getTemperatures() {
        assertEquals("get temperatures ", connectionsResponse,connectionsService.getTemperatures(zip) );
    }

    @Test(expected = Exception.class)
    public void getCoolestHour() {
        assertEquals("get coolest hour in string",coolest, connectionsService.getCoolestHour(43123) );
    }
}
