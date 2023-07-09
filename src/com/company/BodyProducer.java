package com.company;

public class BodyProducer extends Thread{
    private Warehouse<Body> m_warehouse;

    BodyProducer(Warehouse<Body> warehouse)
    {
        m_warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((long) (Math.random() * 1000));
                m_warehouse.push(new Body());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
