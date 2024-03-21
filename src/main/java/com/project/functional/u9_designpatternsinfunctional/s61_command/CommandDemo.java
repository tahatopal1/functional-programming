package com.project.functional.u9_designpatternsinfunctional.s61_command;

public class CommandDemo {

    // A way to encapsulate a request as an object, parameterize clients
    // ... with different requests and perform corresponding operations

    public static void main(String[] args) {
        ACAutomationRemote remote = new ACAutomationRemote();

        remote.setCommand(AC::turnOn);
        remote.buttonPressed();

        remote.setCommand(AC::decTemp);
        remote.buttonPressed();
    }
}
