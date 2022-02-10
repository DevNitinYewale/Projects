package com.horseRace;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;




public class HorseRace {
	public JFrame frame;
	JProgressBar h1=new JProgressBar(0,100);
	JProgressBar h2=new JProgressBar(0,100);
	JProgressBar h3=new JProgressBar(0,100);
	JProgressBar h4=new JProgressBar(0,100);
	JProgressBar h5=new JProgressBar(0,100);
	
	JLabel msg=new JLabel("");
	
	static boolean runRaceButtonIsPressed=false;
	static boolean resetRaceButtonIsPressed=false;
	static int winnigHorse=0;
	static boolean winner=false;
	
	public synchronized void finish(int i) {
		msg.setVisible(true);
		msg.setText("Horse: "+winnigHorse+" win the race !");
		if(i==100) {
			winner=true;
			System.out.println("Horse: "+winnigHorse+" win the race !");
			
		}
		frame.getContentPane().add(msg);
	}
	
	public HorseRace() {
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
		h2.setForeground(Color.RED);
		h2.setBounds(150,159,259,14);
		frame.getContentPane().add(h2);	
	
		h3.setStringPainted(true);
		h3.setForeground(Color.RED);
		h3.setBounds(150,189,259,14);
		frame.getContentPane().add(h3);
	
		h4.setStringPainted(true);
		h4.setForeground(Color.RED);
		h4.setBounds(150,219,259,14);
		frame.getContentPane().add(h4);

		h5.setStringPainted(true);
		h5.setForeground(Color.RED);
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
	
	
	class RunRace implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if(!runRaceButtonIsPressed) {
				msg.setVisible(false);
				resetRaceButtonIsPressed=false;
				runRaceButtonIsPressed=true;
				
				Horse1 h1=new Horse1();
				Thread t1=new Thread(h1);
				t1.start();
				
				Horse2 h2=new Horse2();
				Thread t2=new Thread(h2);
				t2.start();
				
				Horse3 h3=new Horse3();
				Thread t3=new Thread(h3);
				t3.start();
				
				Horse4 h4=new Horse4();
				Thread t4=new Thread(h4);
				t4.start();
				
				Horse5 h5=new Horse5();
				Thread t5=new Thread(h5);
				t5.start();
			}
		}
	}
	
	class ResetRace implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(!resetRaceButtonIsPressed) {
				msg.setVisible(false);
				resetRaceButtonIsPressed=true;
				runRaceButtonIsPressed=false;
				winner=false;
				
				Horse1 h1=new Horse1();
				//Thread t1=new Thread(h1);
				h1.reset();
				
				Horse2 h2=new Horse2();
				//Thread t2=new Thread(h2);
				h2.reset();
				
				Horse3 h3=new Horse3();
				//Thread t3=new Thread(h3);
				h3.reset();
				
				Horse4 h4=new Horse4();
				//Thread t4=new Thread(h4);
				h4.reset();
				
				Horse5 h5=new Horse5();
				//Thread t5=new Thread(h5);
				h5.reset();
				
			}
		}
		
	}
	
	class QuitProgram implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	}
}
