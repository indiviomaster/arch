package ru.indivio.homecrm.entities;

public class DecoMessage extends Message {


    public DecoMessage(String text) {
        super(text);
    }

    @Override
    public String show() {
        String decoratedString;
        System.out.println("**********");
        decoratedString = "*******Decorated:".concat(super.show()).concat("***************");
        return decoratedString;
    }
}
