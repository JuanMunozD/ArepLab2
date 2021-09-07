package edu.eci.arep.persistence;

import edu.eci.arep.nanospark.components.NanoSparkException;

public interface PersistenceService {

    String getGreeting(String name) throws NanoSparkException;
}
