package com.examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Account implements Callable<String> {

	public String call() throws Exception {
		// TODO Auto-generated method stub
		//Thread.currentThread().sleep(1000);
		return Thread.currentThread().getName();
	}
	
}


public class CallableExample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool(5);

		List<Future<String>> list = new ArrayList<>();
		
		for(int i=0; i<5; i++) {
		Future<String> future = service.submit(new Account());
		list.add(future);
		}

		for(Future<String> future: list) {
			System.out.println(future.get());
		}
		
		
		
	}

}
