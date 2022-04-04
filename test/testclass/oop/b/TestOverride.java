package oop.b;

public class TestOverride {
    public static void main(String[] args) {
    Car c=new Car();
    c.run();
    c.getVehicle();
    }
}
    class Vehicle {
        public void run() {
            System.out.println("跑~~~~");
        }

        public  Vehicle getVehicle() {
            System.out.println("给你一个交通工具！");
            return null;
             }
    }
        class Car extends Vehicle{
            @Override
            public void run() {
                System.out.println("eng  eng eng ~~~~");
            }
            public  Car getVehicle(){
                System.out.println("超级飞侠");
                return null;
            }
        }
        class Horse extends Vehicle{
            @Override
            public void run() {
                System.out.println("da da da~~~");
            }
        }



