package edu.eci.arep.httpserver;

import java.io.IOException;
import java.io.OutputStream;


public interface HttpServer {

    void startServer() throws IOException;

    void getStaticFiles(String endpoint);

    void getResource(String fullPath);

    void getImage(String fullPath);

    void printErrorMessage(int statusCode, String message, String statusName);

    OutputStream getOut();

    void setOut(OutputStream out);
}
