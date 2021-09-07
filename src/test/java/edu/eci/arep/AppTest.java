package edu.eci.arep;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import static org.junit.Assert.*;


/**
 * Unit Tests For The App.
 */
public class AppTest {

    private final String basicUrl = "http://localhost:4444";

    @BeforeClass
    public static void setup() {
        new Thread(() -> App.main(null)).start();
    }

    @Test
    public void shouldFindTheHTMLFile() {
        try {
            URL url = new URL(basicUrl + "/index.html");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = bufferedReader.readLine();
            assertTrue(inputLine.contains("<!DOCTYPE html>"));
        } catch (IOException e) {
            fail("No debió fallar al realizar la conexión con esa URL");
        }
    }

    @Test
    public void shouldFindTheJSFile() {
        try {
            URL url = new URL(basicUrl + "/app.js");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = bufferedReader.readLine();
            assertTrue(inputLine.contains("document.getElementById(\"button\")"));
        } catch (IOException e) {
            fail("No debió fallar al realizar la conexión con esa URL");
        }
    }

    @Test
    public void shouldNotFindTheFile() {
        URL url = null;
        try {
            url = new URL(basicUrl + "/hola.html");
        } catch (MalformedURLException e) {
            fail("No debió fallar al crear la URL");
        }
        try {
            new BufferedReader(new InputStreamReader(url.openStream()));
            fail("Debió fallar al realizar la conexión con esa URL");
        } catch (IOException e) {
            assertEquals(basicUrl + "/hola.html", e.getMessage());
        }
    }

    @Test
    public void shouldFindTheNanoSparkEndpoint() {
        String value = "Daniel";
        try {
            URL url = new URL(basicUrl + "/Apps/hello?value=" + value);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine = bufferedReader.readLine();
            assertEquals("Hola " + value, inputLine);
        } catch (IOException e) {
            fail("No debió fallar al realizar la conexión con esa URL");
        }
    }

    @Test
    public void shouldFailWithAnIncompleteNanoSparkEndpoint() {
        URL url = null;
        try {
            url = new URL(basicUrl + "/Apps/hello");
        } catch (MalformedURLException e) {
            fail("No debió fallar al crear la URL");
        }
        try {
            new BufferedReader(new InputStreamReader(url.openStream()));
            fail("Debió fallar al realizar la conexión con esa URL");
        } catch (IOException e) {
            assertEquals("Server returned HTTP response code: 409 for URL: " + basicUrl + "/Apps/hello", e.getMessage());
        }
    }
}
