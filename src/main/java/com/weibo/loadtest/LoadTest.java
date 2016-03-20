package com.weibo.loadtest;

public class LoadTest {

	public static void main(String[] args) {
		
		int count = args.length>1?Integer.parseInt(args[0]):10;
		for(int i = 0 ; i< count; i++){
			Thread thread = new Thread(new ParaLoader());
			thread.start(); 
		}
		
	}

}


