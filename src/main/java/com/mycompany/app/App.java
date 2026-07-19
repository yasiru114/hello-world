package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        String appName = System.getProperty("app.name");
        String appVersion = System.getProperty("app.version");
        System.out.println("App Name: " + appName);
        System.out.println("App Version: " + appVersion);
    }
}