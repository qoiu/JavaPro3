package com.geekbrains.java.lesson01;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Arrays;

/*
 Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
Написать метод, который преобразует массив в ArrayList;
Задача:
Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
Для хранения фруктов внутри коробки можно использовать ArrayList;
Сделать метод getWeight(), который высчитывает вес коробки. Задать вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false
в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается,
а в другую перекидываются объекты, которые были в первой;
Не забываем про метод добавления фрукта в коробку.
  */
public class dz_01 {
    public static void main(String[] args){
        String[] arr1 ={"Apple","Orange","Banana","Mango"};
        Integer[] arr2={1,2,3,4,5};
        Object[] arr3={1,"assa","assaasasa2",3,5,10,"asas"};
        replaceItems(arr1,1,3);
        replaceItems(arr2,0,2);
        replaceItems(arr3,0,1);
        ArrayList arr=toArrayList(arr3);
        System.out.println(arr.toString());
        //Box'ы
        Apple ap=new Apple();
        Orange or=new Orange();
        Box<Apple> boxWithApple=new Box<>("Red");
        Box<Orange> boxWithOrange=new Box<>("Blue");
        Box<Apple> anotherAppleBox=new Box<>("green");
        for(int i=0;i<21;i++){
            boxWithApple.put(new Apple());
            if(i<14)boxWithOrange.put(new Orange());
        }
        System.out.println(boxWithApple.getWeight());
        System.out.println(boxWithOrange.getWeight());
        System.out.println(boxWithApple.compare(boxWithOrange));
        boxWithApple.dropTo(anotherAppleBox);
        System.out.println(anotherAppleBox.getWeight());
        System.out.println(boxWithApple.getWeight());
}
    private static <T> void replaceItems(T[] obj, int re1, int re2){
        T temp;
        temp=obj[re1];
        obj[re1]=obj[re2];
        obj[re2]=temp;
    }
    private static <T> ArrayList toArrayList(T[] array){
        return new ArrayList<T>(Arrays.asList(array));
    }
}
