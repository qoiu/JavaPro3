package com.geekbrains.java.lesson04;

public class TestThread implements Runnable {
    private String newLetter;

    public TestThread(String newLetter) {
        this.newLetter = newLetter;
    }

    @Override
    public void run() {
            try{
                for(int i=0;i<5;i++){
                    System.out.print(newLetter);
                    Thread.sleep(100);
                }

        } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
