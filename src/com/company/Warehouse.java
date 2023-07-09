package com.company;

import java.util.LinkedList;

public class Warehouse<T> {
    private LinkedList<T> queue = new LinkedList<>();
    private int m_limit = 0;

    Warehouse(int limit)
    {
        m_limit = limit;
    }

    public synchronized void push(T value)
    {
        while (queue.size() == m_limit)
        {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }

        }
        queue.addLast(value);
        notify();
    }

    public synchronized T pull()
    {
        while (queue.size() == 0)
        {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        T tmp = queue.removeFirst();
        notify();
        return tmp;
    }

    public int size()
    {
        return queue.size();
    }

    public int limit()
    {
        return m_limit;
    }

    public synchronized boolean pushable()
    {
        return queue.size() < m_limit;
    }

    public synchronized boolean pullable()
    {
        return queue.size() > 0;
    }
}
