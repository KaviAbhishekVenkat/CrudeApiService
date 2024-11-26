package com.kav.CrudeApiService;

public class TestThread extends Thread {

    public void run (){
        System.out.println("THis is  thread " + this.getThreadGroup() + " "+ Thread.currentThread());
    }
}
