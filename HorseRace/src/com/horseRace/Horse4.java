package com.horseRace;

import java.util.UUID;

public class Horse4 extends HorseRace implements Runnable{
	public void reset() {
		h4.setValue(0);
		h4.repaint();
	}
	public void run() {
		for(int i=0;i<101;i++) {
			if(winner) {
				break;
			}
			h4.setValue(i);
			h4.repaint();
			if(i==100) {
				winnigHorse=4;
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
