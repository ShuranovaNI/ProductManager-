package ru.netology.domain;
public class Product {
    protected int ID;
    protected String name;
    protected int price;


    public Product(int ID, String name, int price) {
        this.ID = ID;
        this.name = name;
        this.price = price;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
