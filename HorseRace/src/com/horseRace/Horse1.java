package com.horseRace;

import java.util.UUID;

public class Horse1 extends HorseRace implements Runnable{
	public void reset() {
		h1.setValue(0);
		h1.repaint();
	}
	public void run() {
		for(int i=0;i<101;i++) {
			if(winner) {
				break;
			}
			h1.setValue(i);
			h1.repaint();
			if(i==100) {
				winnigHorse=1;
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
