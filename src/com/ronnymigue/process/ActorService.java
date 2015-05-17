package com.ronnymigue.process;

import com.ronnymigue.Neo4jPersistence;
import com.ronnymigue.persistence.ActorOcurrency;

import java.io.IOException;

public class ActorService {

    public static void save(ActorOcurrency actor) {
        try {
            String query = "{\n \"query\": \"MERGE (n:Person {name: '" + actor.getName() + "', born: '" + actor.getBorn() + "'});\"\n}";
            Neo4jPersistence.query(query);
        } catch (IOException e) {
            throw new RuntimeException("Error saving in database");
        }
    }
}
