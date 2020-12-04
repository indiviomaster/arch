package ru.indivio.homecrm.entities;

public class CarDelivery extends DeliverMethod{
    public CarDelivery(){
        super();
    }
    @Override
    public void deliver(int cost) {
        System.out.println("cost" + cost);
        if(cost >2500){
            System.out.println("Доставка товара выполняется транспортом");
        }else {

            if(this.nextMethod!=null) {
                this.nextMethod.deliver(cost);
            }

        }

    }
}
