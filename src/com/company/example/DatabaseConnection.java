package com.company.example;

public class DatabaseConnection {


    //@DatabaseUsername
    private String username;

    //@DatabasePassword
    private String databasePassword;

    protected String databasePassword1;
    public String fileLocation;

    @Run
    public void connect() {
        System.out.println("connect");
        System.out.println("connecting ...");
        System.out.println("username:" + username);
        System.out.println("password:" + databasePassword);
    }

    private void start(String param) {
        System.out.println("start");

        System.out.println("connecting ...");
        System.out.println("username:" + username);
        System.out.println("password:" + databasePassword);
    }

    @Run
    protected void run() {
        System.out.println("run");

        System.out.println("connecting ...");
        System.out.println("username:" + username);
        System.out.println("password:" + databasePassword);
    }

    @Run
    void запустить() {
        System.out.println("запустить");

    }
}
