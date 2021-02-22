package sample.controllers;

public class Payments {
    private String name;
    private String card;
    private String cash;
    private String id;

     Payments(String name, String card, String cash, String id) {
        this.name = name;
        this.card = card;
        this.cash = cash;
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
