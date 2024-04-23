package com.project.functional.u16_reactiveintro.s113_pushvspull;

public class PushModel {

    // In the push-based model, instead of waiting for a response,
    // ... the client provides a callback function that gets called
    // ... when the operation completes. This is common in asynchronous
    // ... operations.

    public static void main(String[] args) {
        Server server = new Server();
        System.out.println("Sending asynchronous request to server...");
        server.processRequest("Hello, server!", new Callback() {
            @Override
            public void onCompletion(String response) {
                System.out.println("Received response: " + response);
            }
        });
    }

}

interface Callback {
    void onCompletion(String response);
}

class Server {
    // Simulates processing a request and calling the callback with response
    public void processRequest(String request, Callback callback) {
        System.out.println("Server received asynchronous request: " + request);
        // Simulate some processing time
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.onCompletion("Response from server to '" + request + "'");
    }
}
