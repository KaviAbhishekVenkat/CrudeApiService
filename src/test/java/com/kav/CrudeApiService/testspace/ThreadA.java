package com.kav.CrudeApiService.testspace;

public class ThreadA extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10000; i++) {
            try {
                System.out.println(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
