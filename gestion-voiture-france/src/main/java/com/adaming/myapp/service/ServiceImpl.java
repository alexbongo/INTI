package com.adaming.myapp.service;

import java.util.Random;

public class ServiceImpl implements IService{

	public String generateKey(int length) {
		// TODO Auto-generated method stub
		String data=new String("1256987465khgfjkqgaqcvILAGVBMvaymjoqt");
		int size = data.length();
		Random r = new Random();
		String result = new String();
		
		for (int x=0; x<length;x++) {
			result = result + data.charAt(r.nextInt(size));
		}
		return result;
	}

}
