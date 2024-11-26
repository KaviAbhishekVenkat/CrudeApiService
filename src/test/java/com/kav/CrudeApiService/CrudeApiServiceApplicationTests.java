package com.kav.CrudeApiService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//@SpringBootTest
class CrudeApiServiceApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	void threadTet(){
		TestThread a = new TestThread();
		a.start();
		a.run();
	}


	@Test
	void runnableTest() throws InterruptedException {
		ExecutorService e= Executors.newFixedThreadPool(11);
		ExecutorService e2= Executors.newFixedThreadPool(11);
		for(int a = 0; a < 10; a++) {
			e.submit(new TestRunnable());
			e2.submit(new TestRunnable());
		}
notify();
		e.awaitTermination(100000000L, TimeUnit.MILLISECONDS);
		e2.awaitTermination(100000000L, TimeUnit.MILLISECONDS);
		e.shutdown();
		e2.shutdown();

		List a = new ArrayList<>();
		a.iterator();
		Map h  = new HashMap<>();

	}

}
