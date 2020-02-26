package com.geekbrains.java.lesson07;

public class TestingClass {



    public TestingClass() {

    }
    @BeforeSuite
    public static void methodStart(){
        System.out.println("We start method with tests");
    }
  @AfterSuite
    public static void methodEnd(){
        System.out.println("We finished our tests!");
    }

    @Test(priority = 3)
    public static void test01(){
        System.out.println("priority:3");
    }
 @Test(priority = 7)
    public static void test02(){
        System.out.println("priority:7");
    }
@Test(priority = 6)
    public static void test03(){
        System.out.println("priority:6");
    }
@Test(priority = 2)
    public static void test04(){
        System.out.println("priority:2 test04");
    }
    @Test(priority = 2)
    public static void test05(){
        System.out.println("priority:2 test05");
    }
    @Test(priority = 2)
    public static void test06(){
        System.out.println("priority:2 test06");
    }




}
