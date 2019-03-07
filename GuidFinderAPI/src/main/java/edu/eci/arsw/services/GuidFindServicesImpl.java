package edu.eci.arsw.services;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class GuidFindServicesImpl implements GuidFindServices{
	ArrayList<GuidFindResult> Buscados;
	public GuidFindServicesImpl() {
		Buscados=new ArrayList<GuidFindResult>();
	}
	public ArrayList<GuidFindResult> getBuscados(){
		return Buscados;
	}
	public void newSearch(UUID guid){
		GuidFindResult result=new GuidFindResult(guid);
		Buscados.add(result);
	}
}
