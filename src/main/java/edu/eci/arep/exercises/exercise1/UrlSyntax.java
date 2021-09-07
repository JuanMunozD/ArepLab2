package edu.eci.arep.exercises.exercise1;

import java.net.URL;


public class UrlSyntax {

    public static void main(String[] args) {
    	
    	try {
            URL url = new URL("https://www.youtube.com/watch?v=5qap5aO4i9A&ab_channel=LofiGirl#yt_01");
            System.out.format("Protocol: %s \n",url.getProtocol());
            System.out.format("Authority: %s \n",url.getAuthority());
            System.out.format("Host: %s \n", url.getHost());
            System.out.format("Port: %s \n", url.getPort());
            System.out.format("Path: %s \n", url.getPath());
            System.out.format("Query: %s \n", url.getQuery());
            System.out.format("File: %s \n", url.getFile());
            System.out.format("Ref: %s \n", url.getRef());
    	}catch(Exception e) {
    		System.out.format("URL no valida - error : %s", e.getMessage());
    	}

    }
}
