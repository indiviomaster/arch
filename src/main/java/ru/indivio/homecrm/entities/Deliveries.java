package ru.indivio.homecrm.entities;

public class Deliveries {
    protected static DeliverMethod byCar = new CarDelivery();
    protected static DeliverMethod byFoot = new FootDelivery();
    protected static DeliverMethod deliveries;
    static{
        byCar.setNextMethod(byFoot);
        deliveries = byCar;
    }
    public static void deliver(int cost) {

        if (cost >0) {
            deliveries.deliver(cost);
        }
    }


}
