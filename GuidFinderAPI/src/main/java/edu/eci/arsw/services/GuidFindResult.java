package edu.eci.arsw.services;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import edu.eci.arsw.GuidFinderDesktop.GuidFinder;


public class GuidFindResult implements Serializable{
	String Fecha;
	UUID Guid;
	int Count;
	private String getActualDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		return dtf.format(LocalDateTime.now());
	}
	public GuidFindResult(UUID Guid) {
		Fecha=getActualDate();
		this.Guid=Guid;
		Count=GuidFinder.countGuids(Guid);
	}
	
}


