/*package com.example;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = WebServer.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        target = c.target(WebServer.BASE_URI);
    }

    @Test
    public void testGetIt() {
        String responseMsg = target.path("/").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }
    
    @After
    public void tearDown() throws Exception {
        server.shutdownNow();
    }

}
*/