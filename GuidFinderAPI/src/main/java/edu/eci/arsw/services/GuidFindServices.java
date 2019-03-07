package edu.eci.arsw.services;

import java.util.ArrayList;
import java.util.UUID;

public interface GuidFindServices {
	public ArrayList<GuidFindResult> getBuscados();
	
	public void newSearch(UUID guid);

}
