package oop.a;

public class Animal {
    public void shout(){
        System.out.println("叫了一声,这是父类");
    }
   static class Dog extends Animal{
        @Override
        public void shout() {
            System.out.println("汪\n汪\n汪");
        }
        public void seeDoor(){
            System.out.println("好好看门");
        }
    }
  static class Cat extends Animal{
        @Override
        public void shout() {
            System.out.println("我们一起学猫叫，一起喵喵喵喵喵");
        }
    }
}
