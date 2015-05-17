package com.ronnymigue.persistence;

import com.ronnymigue.model.Actor;
import com.ronnymigue.process.ActorService;

public class ActorOcurrency extends Actor {

    public ActorOcurrency(String name, String born) {
        super(name, born);
        create();
    }

    private void create() {
        ActorService.save(this);
    }


}
