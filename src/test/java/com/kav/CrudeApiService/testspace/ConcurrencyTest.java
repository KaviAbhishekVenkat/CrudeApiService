package com.kav.CrudeApiService.testspace;

import org.junit.jupiter.api.Test;

public class ConcurrencyTest {


    @Test
    void testConn() throws InterruptedException {
        Thread a  = new ThreadA();
        a.isDaemon();
        a.start();
        Thread.sleep(1000000);
    }
}
