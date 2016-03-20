package com.weibo.loadtest;

import java.util.Timer;

public class ParaLoader implements Runnable {
	
	public void run() {
		Timer timer = new Timer();
		timer.schedule(new Senddata(), 1000, 1000);
		
	}

}
