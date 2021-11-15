package com.example.demo.study.fanxing.fxinterface;

import com.example.demo.study.fanxing.fxinterface.entity.Coffee;
import com.example.demo.study.fanxing.fxinterface.impl.CoffeeGeneratorImpl;

public class InterfaceMain {
    public static void main(String[] args) {
        Generator generator = new CoffeeGeneratorImpl();
        Coffee coffee = (Coffee)generator.next(1);
        System.out.println(coffee.toString());;
    }

}
