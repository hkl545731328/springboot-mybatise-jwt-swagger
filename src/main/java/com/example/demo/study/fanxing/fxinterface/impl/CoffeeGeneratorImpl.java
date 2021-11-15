package com.example.demo.study.fanxing.fxinterface.impl;

import com.example.demo.study.fanxing.fxinterface.Generator;
import com.example.demo.study.fanxing.fxinterface.entity.Americano;
import com.example.demo.study.fanxing.fxinterface.entity.Cappuccino;
import com.example.demo.study.fanxing.fxinterface.entity.Coffee;
import com.example.demo.study.fanxing.fxinterface.entity.Latte;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGeneratorImpl implements Generator<Coffee> ,Iterable<Coffee>{

    private Class[] types = {Latte.class, Cappuccino.class, Americano.class};

    private static Random rand = new Random(47);


    @Override
    public Coffee next(Integer index) {
        try {
            return (Coffee) types[index].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterator<Coffee> iterator() {
        return null;
    }

}
