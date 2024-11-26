package com.kav.CrudeApiService;

public class TestRunnable implements  Runnable{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10000; i++) {
                System.out.println(i);
            }
            this.wait(100);
            System.out.println("this is a new thread" + Thread.currentThread());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
