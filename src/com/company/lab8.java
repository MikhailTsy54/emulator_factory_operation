package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lab8 extends JFrame implements ActionListener {
    public static int body_warehouse_limit = 10;
    public static int engine_warehouse_limit = 10;
    public static int accessory_warehouse_limit = 10;
    public static int car_warehouse_limit = 10;


    public static Timer timer;
    public static View view;

    public static Warehouse<Body> body_warehouse = new Warehouse<Body>(body_warehouse_limit);
    public static Warehouse <Engine>  engine_warehouse = new Warehouse<Engine>(engine_warehouse_limit);
    public static Warehouse <Accessory> accessory_warehouse = new Warehouse<Accessory>(accessory_warehouse_limit);
    public static Warehouse <Car> car_warehouse = new Warehouse<Car>(car_warehouse_limit);

    public static CarProducer car_producer = new CarProducer(
            body_warehouse,
            engine_warehouse,
            accessory_warehouse,
            car_warehouse);
    public static BodyProducer body_producer = new BodyProducer(body_warehouse);
    public static EngineProducer engine_producer = new EngineProducer(engine_warehouse);
    public static AccessoryProducer accessory_producer = new AccessoryProducer(accessory_warehouse);
    public static Dealer dealer = new Dealer(car_warehouse);

    public static void main(String[] args)
    {
        lab8 main = new lab8();
    }

    lab8()
    {
        view = new View();
        timer = new Timer(30,this);
        timer.start();
        setTitle("Machine Factory");
        setSize(800, 400);
        add(view);
        view.repaint();
        view.revalidate();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        engine_producer.start();
        body_producer.start();
        accessory_producer.start();
        car_producer.start();
        dealer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        validate();
        repaint();
    }


class View extends JPanel{
    @Override
    public void paint(Graphics g) {
        Draw(g);
    }

    private void Draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Consolas", Font.BOLD, 10);
        g2.setFont(font);

        g2.setColor(new Color(100, 0, 100));
        g2.setStroke(new BasicStroke(3));


        g2.fillRect(50,62,50,25);
        g2.fillRect(50,162,50,25);
        g2.fillRect(50,262,50,25);
        g2.fillRect(450,162,50,25);
        g2.fillRect(650,162,50,25);

        g2.setColor(new Color(100, 100, 100));
        g2.drawLine(100, 75, 450, 175);
        g2.drawLine(100, 175, 450, 175);
        g2.drawLine(100, 275, 450, 175);
        g2.drawLine(500, 175, 650, 175);

        g2.drawString("Body storage",50,40);
        g2.drawString("Warehouse quantity: " + body_warehouse.size(),50,50);
        g2.drawString("Max: " + body_warehouse_limit ,50,60);

        g2.drawString("Engine Warehouse",50,140);
        g2.drawString("Warehouse quantity: " + engine_warehouse.size(),50,150);
        g2.drawString("Max: " + engine_warehouse_limit,50,160);

        g2.drawString("Accessories warehouse",50,240);
        g2.drawString("Warehouse quantity: " + accessory_warehouse.size(),50,250);
        g2.drawString("Max: " + accessory_warehouse_limit,50,260);

        g2.drawString("Factory",450,145);
        g2.drawString("Warehouse quantity: " + car_warehouse.size(),450,155);

        g2.drawString("Dealer",650,145);
        g2.drawString("Sold: " + dealer.sold(),650,155);
    }
}
}