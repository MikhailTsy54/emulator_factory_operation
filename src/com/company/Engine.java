package com.company;

public class Engine {
    private  static int id = 100;

    private  int m_id;

    public Engine()
    {
        m_id = id;
        id++;
    }
}
