package edu.eci.arsw.GuidFinderDesktop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class GuidFinder {
	
	private static UUID[] guids; 
	private static ArrayList<CountSegment> threads;
	private static ActivityDetector ad;
	
	
	
	public GuidFinder() throws Exception {
		getGuids();
	}
	
	public static UUID[] getGuids() throws Exception 
	{
	
		if(guids==null){
			System.out.println("es nulo");
		FileInputStream fi;
		
			fi = new FileInputStream(new File("guids.eci"));
		
		ObjectInputStream oi = new ObjectInputStream(fi);

		
		guids= (UUID[]) oi.readObject();
	
		oi.close();
		fi.close();
		}
		return guids;
	}
	
	public static int countGuids(UUID guidToFind) 
	{
		try {
			getGuids();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		AtomicInteger counter=new AtomicInteger();
		int size=guids.length/4;
		
		int initial=0;
		CountSegment cs;
		threads=new ArrayList<CountSegment>();
		
		for (int i=0;i<4;i++) {
			if(i!=3)cs=new CountSegment(initial,initial+size,guidToFind,counter,guids);
			else cs=new CountSegment(initial,guids.length,guidToFind,counter,guids);
			threads.add(cs);
			initial+=size;
		}
		ad=new ActivityDetector(threads);
		ad.start();
		for(CountSegment cs1: threads) cs1.start();
		return counter.get();
		
	}


}
