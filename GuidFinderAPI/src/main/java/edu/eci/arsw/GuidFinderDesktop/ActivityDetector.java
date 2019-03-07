package edu.eci.arsw.GuidFinderDesktop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.ArrayList;
import java.util.Timer;

public class ActivityDetector extends Thread implements KeyListener{
	private ArrayList<CountSegment> threads;
	private boolean finished;
	public ActivityDetector(ArrayList<CountSegment> threads) {
		this.threads=threads;
		finished=false;
	}
	public void run() {
		
		while(!finished) {
			
			boolean alive=false;
			for(CountSegment cs:threads) {
				alive=alive || cs.isAlive();
			}
			if(!alive) {
				finished=true;
			}
		}
		
		
	}
	public void noActivity() {
		threads.notifyAll();
	}
	
		
	@Override
	public void keyPressed(KeyEvent e) {
		
		try {
			for(CountSegment cs:threads) {
				cs.pause();
			}
			
			Thread.sleep(10000);
			
			for(CountSegment cs:threads) {
				cs.Resume();
			}
			
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
}
