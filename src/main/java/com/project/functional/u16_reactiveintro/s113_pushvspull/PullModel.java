package com.project.functional.u16_reactiveintro.s113_pushvspull;

public class PullModel {

    // Request/Response model
    // In the pull based model, the client requests information from a server
    // ... and waits for the response. This is commonly seen in synchronous
    // ... operations.
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Sending request to server...");
        String response = sendRequest("Hello, server!");
        System.out.println("Received response: " + response);
    }

    public static String sendRequest(String request) throws InterruptedException {
        // Here, we're just simulating a server response
        // In a real scenario, this method would communicate with a server.
        System.out.println("Server received request: " + request);
        Thread.sleep(1000); // Imitating a server by ensuring a latency
        return "Response from server to '" + request + "'";
    }



}
