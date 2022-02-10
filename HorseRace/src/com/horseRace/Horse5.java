package com.horseRace;

import java.util.UUID;

public class Horse5 extends HorseRace implements Runnable {
	public void reset() {
		h5.setValue(0);
		h5.repaint();
	}
	public void run() {
		for(int i=0;i<101;i++) {
			if(winner) {
				break;
			}
			h5.setValue(i);
			h5.repaint();
			if(i==100) {
				winnigHorse=5;
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
