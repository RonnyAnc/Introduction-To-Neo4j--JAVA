package com.ronnymigue;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Neo4jPersistence {

    public static void query(String query) throws IOException {
        HttpPost post = new HttpPost("http://localhost:7474/db/data/cypher");
        configureHeader(encode_logging("neo4j:123456"), post);
        post.setEntity(new StringEntity(query));
        CloseableHttpResponse execute = HttpClientBuilder.create().build().execute(post);
        printResponse(execute);

    }

    private static void configureHeader(String encoding, HttpPost post) {
        post.addHeader("Authorization", "Basic " + encoding);
        post.setHeader("Content-type", "application/json");
    }

    private static void printResponse(CloseableHttpResponse execute) throws IOException {
        InputStream inputStream = execute.getEntity().getContent();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) System.out.println(line);
    }

    private static String encode_logging(String logging) {
        return java.util.Base64.getEncoder().encodeToString(logging.getBytes());
    }


}
