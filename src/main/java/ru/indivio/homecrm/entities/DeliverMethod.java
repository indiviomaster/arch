package ru.indivio.homecrm.entities;

public abstract class DeliverMethod {
    protected DeliverMethod nextMethod;
    public void setNextMethod(DeliverMethod deliverMethod){
        this.nextMethod=nextMethod;
    }
    public abstract void deliver(int cost);
}
