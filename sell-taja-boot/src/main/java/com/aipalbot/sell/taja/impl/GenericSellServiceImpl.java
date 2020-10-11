package com.aipalbot.sell.taja.impl;

import java.util.ArrayList;
import java.util.List;

import com.aipalbot.sell.taja.models.CheckingAccount;
import com.aipalbot.sell.taja.models.SavingAccount;
import com.aipalbot.sell.taja.services.GenericSellService;
import com.aipalbot.taja.models.Item;
import com.aipalbot.taja.models.LambdaResponse;

public class GenericSellServiceImpl<E> implements GenericSellService<E> {


	
	@Override
	public E processSell(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> LambdaResponse getData(T request) {
		
		
		
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K, J> E save(K item, J card) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <K> E save(K item) {
		List<K> data = new ArrayList<>();
		data.add(item);
		
		
		E e =null;
		
		return e;
	}

	
	@Override
	public <X> X[] calculate(X[] xArray) {

		for(X x: xArray) {			
			if(x instanceof SavingAccount) {
				SavingAccount saving = (SavingAccount) x;
				saving.setCallOfAccount("A1000");
			}else if (x instanceof CheckingAccount) {
				CheckingAccount saving = (CheckingAccount) x;
				saving.setAccountProcess("Execute");
			}
			
			
			
		}

		return xArray;
	}


	

}
