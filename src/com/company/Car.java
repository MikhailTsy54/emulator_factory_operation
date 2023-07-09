package com.company;


public class Car {
    private static int id = 300;

    private int m_id;
    private Body m_body;
    private Engine m_engine;
    private Accessory m_accessory;

    public Car(Body body, Engine engine, Accessory accessory)
    {
        m_accessory = accessory;
        m_body = body;
        m_engine = engine;
        m_id = id;
        id++;
    }
}
