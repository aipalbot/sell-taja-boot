package com.aipalbot.sell.taja.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.aipalbot.sell.taja.services.ConcurrentThreadService;

public class SellRunnable implements Runnable{

	@Autowired
	ConcurrentThreadService concurrentService;
	
	private String data;
	
	@Override
	public void run() {	
		data = concurrentService.getAccounts();
	}

}
