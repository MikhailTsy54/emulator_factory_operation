package com.company;

public class Body {
    private  static int id = 0;

    private  int m_id;

    public Body()
    {
        m_id = id;
        id++;
    }
}
