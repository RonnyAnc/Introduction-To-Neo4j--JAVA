package com.ronnymigue.application;

import com.ronnymigue.model.Actor;
import com.ronnymigue.persistence.ActorOcurrency;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        Actor nacho = new ActorOcurrency("Nacho", "1992");
    }
}

