package com.geekbrains.java.lesson01;

import java.util.ArrayList;

public class Box<F extends Fruit> {
   private ArrayList<F> arr;
   private String color;

    public Box(String color) {
        this.color=color;
        arr=new ArrayList<F>();
    }
    public void put(F fruit){
        arr.add(fruit);
    }
    public float getWeight() {
        float weight=0.0f;
        for(F i:arr){
            weight+=i.getWeight();
        }
        return weight;
    }
    public boolean compare(Box box){
        return this.getWeight()-box.getWeight()<0.00001f;
    }
    public void dropTo(Box<F> box){
        for(F b:arr){
            box.put(b);
        }
        arr.clear();
    }
}
