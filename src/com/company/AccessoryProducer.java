package com.company;

public class AccessoryProducer extends Thread{
    private Warehouse<Accessory> m_warehouse;

    AccessoryProducer(Warehouse<Accessory> warehouse)
    {
        m_warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((long) (Math.random() * 3000));
                m_warehouse.push(new Accessory());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
