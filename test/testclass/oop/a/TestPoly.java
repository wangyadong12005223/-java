package oop.a;

import org.jetbrains.annotations.NotNull;

//测试多态
public class TestPoly {
    public static void main(String[] args) {
        animalCry(new Animal.Dog());
        animalCry(new Animal.Cat());
        // animalCry(new Animal.Animal())
    }

    static void animalCry(@NotNull Animal a) {
        System.out.println("Testpolym.animalCry");
        a.shout();//可以出现多态
    }
}
