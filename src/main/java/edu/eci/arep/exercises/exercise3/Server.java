package edu.eci.arep.exercises.exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Servidor Encendido");
        } catch (IOException e) {
            System.err.println("El puerto " + port + "está ocupado.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
        	System.out.println("accept");
            clientSocket = serverSocket.accept();
            System.out.println("accepted");
        } catch (IOException e) {
            System.err.println("Conexión rechazada");
            System.exit(1);
        }
        System.out.println("Mensaje: 1");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        System.out.println("Mensaje: 2");
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("Mensaje: 3");
        String inputLine;
        String outputLine;
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.equals("salir")) break;
            System.out.println("Mensaje:" + inputLine);
            double inputValue = Double.parseDouble(inputLine);
            outputLine = "Respuesta: " + (inputValue * inputValue);
            out.println(outputLine);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

}
