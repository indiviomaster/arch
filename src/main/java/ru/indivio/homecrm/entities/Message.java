package ru.indivio.homecrm.entities;

public class Message implements Msg  {
    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    String text;

    @Override
    public String show() {
        return "simple msg: ".concat(this.getText());
    }
}
