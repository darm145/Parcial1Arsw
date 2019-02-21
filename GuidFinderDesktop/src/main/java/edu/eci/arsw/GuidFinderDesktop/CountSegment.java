package edu.eci.arsw.GuidFinderDesktop;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class CountSegment extends Thread{
	private int initial,fin;
	private UUID toFind;
	private AtomicInteger counter;
	private UUID[] guids;
	private boolean paused;
	public CountSegment(int initial,int fin,UUID tofind,AtomicInteger counter,UUID[] guids) {
		this.initial=initial;
		this.fin=fin;
		this.toFind=tofind;
		this.counter=counter;
		this.guids=guids;
		paused=false;
	}
	public void run() {
		for(int i=initial;i<fin;i++) {
			if (paused) {
				try {
					synchronized(this) {
						wait();
					}
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				
			}
			if(guids[i].equals(toFind)) {
				counter.incrementAndGet();
			}
		}
	}
	public void Resume() {
		paused=false;
		synchronized(this) {
			this.notify();
		}
	}
	public void pause() {
		paused=true;
	}
	

}
