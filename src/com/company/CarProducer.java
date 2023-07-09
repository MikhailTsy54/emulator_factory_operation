package com.company;

public class CarProducer extends Thread{
    private Warehouse<Body> m_body_warehouse;
    private Warehouse<Engine> m_engine_warehouse;
    private Warehouse<Accessory> m_accessory_warehouse;
    private Warehouse<Car> m_car_warehouse;

    CarProducer(
            Warehouse<Body> body_warehouse,
            Warehouse<Engine> engine_warehouse,
            Warehouse<Accessory> accessory_warehouse,
            Warehouse<Car> car_warehouse)
    {
        m_body_warehouse = body_warehouse;
        m_engine_warehouse = engine_warehouse;
        m_accessory_warehouse = accessory_warehouse;
        m_car_warehouse = car_warehouse;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((long) (Math.random() * 3000));
                m_car_warehouse.push(new Car(
                        m_body_warehouse.pull(),
                        m_engine_warehouse.pull(),
                        m_accessory_warehouse.pull()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
