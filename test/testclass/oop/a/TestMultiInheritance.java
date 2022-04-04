package oop.a;

public class TestMultiInheritance {
    public static void main(String[] args) {
        C c = new CImpl01( );
        c.testC();
        c.testA();
        c.testB();
        User v =new User();
        v.setMan(true);
        v.printUserinfo();
    }
    interface A{
        void testA();
    }
    interface B{
        void testB();
    }
    interface C extends A,B{
        void testC();
    }
     public static class CImpl01 implements C{
        @Override
        public void testA() {
            System.out.println("CImpl01.testA");
        }

        @Override
        public void testB() {
            System.out.println("CImpl01.testB");
        }

        @Override
        public void testC() {
            System.out.println("CImpl01.testC");
        }
    }
}
