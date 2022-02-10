package com.HorseRace2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class HorseRace1 {
	JFrame frame;
	JProgressBar h1=new JProgressBar(0,100);
	JProgressBar h2=new JProgressBar(0,100);
	JProgressBar h3=new JProgressBar(0,100);
	JProgressBar h4=new JProgressBar(0,100);
	JProgressBar h5=new JProgressBar(0,100);
	
	JLabel msg=new JLabel("");
	static boolean runRaceButtonIsPressed=false;
	static boolean resetRaceButtonIsPressed=false;
	static int winningHorse=0;
	static boolean winner=false;
	
	public synchronized void finish(int i) {
		msg.setVisible(true);
		msg.setText("Horse: "+winningHorse+" win the race !");
		if(i==100) {
			winner=true;
			System.out.println("Horse: "+winningHorse+" win the race !");
		}
		frame.getContentPane().add(msg);
	}
	
	public HorseRace1() {
		initialize();
	}
	
	private void initialize() {
		frame =new JFrame();
		frame.setBounds(100,100,598,430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		h1.setStringPainted(true);
		h1.setForeground(Color.RED);
		h1.setBounds(150,129,259,14);
		frame.getContentPane().add(h1);
		
		h2.setStringPainted(true);
		h2.setForeground(Color.BLUE);
		h2.setBounds(150,159,259,14);
		frame.getContentPane().add(h2);	
	
		h3.setStringPainted(true);
		h3.setForeground(Color.ORANGE);
		h3.setBounds(150,189,259,14);
		frame.getContentPane().add(h3);
	
		h4.setStringPainted(true);
		h4.setForeground(Color.GREEN);
		h4.setBounds(150,219,259,14);
		frame.getContentPane().add(h4);

		h5.setStringPainted(true);
		h5.setForeground(Color.PINK);
		h5.setBounds(150,249,259,14);
		frame.getContentPane().add(h5);
	
		msg.setBounds(85,100,410,14);
		msg.setVisible(false);
		frame.getContentPane().add(msg);
	
		JButton btnStart=new JButton("start race");
		btnStart.setFont(new Font("Tahoma",Font.PLAIN,18));
		btnStart.addActionListener(new RunRace());
		btnStart.setBounds(50,287,155,40);
		frame.getContentPane().add(btnStart);
		
		JButton btnReset=new JButton("stop race");
		btnReset.setFont(new Font("Tahoma",Font.PLAIN,18));
		btnReset.addActionListener(new ResetRace());
		btnReset.setBounds(205,287,155,40);
		frame.getContentPane().add(btnReset);
		
		JButton btnQuit=new JButton("quit Race");
		btnQuit.setFont(new Font("Tahoma",Font.PLAIN,18));
		btnQuit.addActionListener(new QuitProgram());
		btnQuit.setBounds(360,287,155,40);
		frame.getContentPane().add(btnQuit);
		
	}
	
	class RunRace implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(!runRaceButtonIsPressed) {
				msg.setVisible(false);
				resetRaceButtonIsPressed=false;
				runRaceButtonIsPressed=true;
				
				H1 h1=new H1();
				Thread t1=new Thread(h1);
				t1.start();
				
				H2 h2=new H2();
				Thread t2=new Thread(h2);
				t2.start();
				
				H3 h3=new H3();
				Thread t3=new Thread(h3);
				t3.start();
				
				H4 h4=new H4();
				Thread t4=new Thread(h4);
				t4.start();
				
				H5 h5=new H5();
				Thread t5=new Thread(h5);
				t5.start();
				
			}
		}
	}
	
	class ResetRace implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(!resetRaceButtonIsPressed) {
				msg.setVisible(false);
				resetRaceButtonIsPressed=true;
				runRaceButtonIsPressed=false;
				winner=false;
				
				H1 h1=new H1();
				h1.reset();
				
				H2 h2=new H2();
				h2.reset();
				
				H3 h3=new H3();
				h3.reset();
				
				H4 h4=new H4();
				h4.reset();
				
				H5 h5=new H5();
				h5.reset();
			}
		}
	}
	class QuitProgram implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.exit(0);
			
		}
	}
	
	class H1 extends Thread {
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
					winningHorse=1;
					finish(i);
				}
				try {
					Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits())%60);
				} catch (InterruptedException itr) {
					// TODO: handle exception
					itr.printStackTrace();
				}
			}
		}
	}
	
	class H2 extends Thread {
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
					winningHorse=2;
					finish(i);
				}
				try {
					Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits())%60);
				} catch (InterruptedException itr) {
					// TODO: handle exception
					itr.printStackTrace();
				}
			}
		}
	}
	
	class H3 extends Thread {
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
					winningHorse=3;
					finish(i);
				}
				try {
					Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits())%60);
				} catch (InterruptedException itr) {
					// TODO: handle exception
					itr.printStackTrace();
				}
			}
		}
	}
	
	class H4 extends Thread {
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
					winningHorse=4;
					finish(i);
				}
				try {
					Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits())%60);
				} catch (InterruptedException itr) {
					// TODO: handle exception
					itr.printStackTrace();
				}
			}
		}
	}
	
	class H5 extends Thread {
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
					winningHorse=5;
					finish(i);
				}
				try {
					Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits())%60);
				} catch (InterruptedException itr) {
					// TODO: handle exception
					itr.printStackTrace();
				}
			}
		}
	}
	
	
}
