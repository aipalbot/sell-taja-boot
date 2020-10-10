package com.aipalbot.sell.taja.services;

import com.aipalbot.taja.models.Item;
import com.aipalbot.taja.models.LambdaResponse;

public interface GenericSellService<E> {
	
	public  E processSell(Item item);
	
	public <T> LambdaResponse getData(T request);
	
	public <K,J> E save(K item, J card); 
	
	public <K> E save(K item); 
	
	public  <X> X[] calculate(X[] x);
	
	
}
