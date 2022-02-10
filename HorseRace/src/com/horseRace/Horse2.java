package com.horseRace;

import java.util.UUID;

public class Horse2 extends HorseRace implements Runnable{
	public void reset() {
		h2.setValue(0);
		h2.repaint();
	}
	public void run() {
		for(int i=0;i<101;i++) {
			if(winner) {
				break;
			}
			h2.setValue(i);
			h2.repaint();
			if(i==100) {
				winnigHorse=2;
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
