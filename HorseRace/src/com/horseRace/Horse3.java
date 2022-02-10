package com.horseRace;

import java.util.UUID;

public class Horse3 extends HorseRace implements Runnable{
	public void reset() {
		h3.setValue(0);
		h3.repaint();
	}
	public void run() {
		for(int i=0;i<101;i++) {
			if(winner) {
				break;
			}
			h3.setValue(i);
			h3.repaint();
			if(i==100) {
				winnigHorse=3;
				finish(i);
			}
			try {
				Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits())%60);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
