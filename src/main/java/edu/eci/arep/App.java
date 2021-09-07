package edu.eci.arep;

import edu.eci.arep.httpserver.HttpServer;
import edu.eci.arep.httpserver.HttpServerImpl;

import java.io.IOException;


public class App {

    public static void main(String[] args) {
        HttpServer httpServer = new HttpServerImpl();
        try {
            httpServer.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
