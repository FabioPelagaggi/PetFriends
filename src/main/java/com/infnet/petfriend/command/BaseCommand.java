package com.infnet.petfriend.command;

public abstract class BaseCommand {
    private final String id;

    public BaseCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
