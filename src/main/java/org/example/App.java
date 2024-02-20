package org.example;


public class App {
    public static void main(String[] args )  {

        //checking the interaction with the database

        Interact_database interact_database = new Interact_database();

        interact_database.getBalance(3012L);
        interact_database.putMoney(3012L, 2500L);
        interact_database.getBalance(3012L);

        interact_database.takeMoney(3012L, 1000L);
        interact_database.getBalance(3012L);
    }
}
