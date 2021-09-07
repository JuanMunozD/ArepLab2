package edu.eci.arep.persistence;

import edu.eci.arep.nanospark.components.NanoSparkException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class PersistenceServiceImpl implements PersistenceService {

    private final String firebaseURL = "https://firebasestorage.googleapis.com/v0/b/ejemploxd-2f8bf.appspot.com/o/hello.json?alt=media";

    @Override
    public String getGreeting(String name) throws NanoSparkException {
        String greeting;
        try {
            URL url = new URL(firebaseURL);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            greeting = bufferedReader.readLine();
        } catch (IOException e) {
            throw new NanoSparkException("Error de Conexion A Firebase");
        }
        greeting = greeting.replace("\"", "");
        System.out.println(greeting);
        return greeting + " " + name;
    }
}
