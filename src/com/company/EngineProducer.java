
package com.company;
public class EngineProducer extends Thread{
    private Warehouse<Engine> m_warehouse;

    EngineProducer(Warehouse<Engine> warehouse)
    {
        m_warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((long) (Math.random() * 3000));
                m_warehouse.push(new Engine());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
