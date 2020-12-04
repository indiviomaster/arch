package ru.indivio.homecrm.entities;

public class FootDelivery extends DeliverMethod {
    public FootDelivery(){
        super();
    }

    @Override
    public void deliver(int cost) {
        System.out.println("cost" + cost);
        if(cost< 2500){
            System.out.println("Доставка товара выполняется курьером");
        }else {

            if(this.nextMethod!=null) {
                    this.nextMethod.deliver(cost);
                }

            }
        }


}
