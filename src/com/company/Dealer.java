package com.company;

public class Dealer extends Thread{
    private Warehouse<Car> m_warehouse;
    private int sold = 0;

    Dealer(Warehouse<Car> warehouse)
    {
        m_warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((long) (Math.random() * 5000));
                m_warehouse.pull();
                sold++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int sold()
    {
        return sold;
    }
}
