package edu.eci.arsw.controllers;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.services.GuidFindServices;
import edu.eci.arsw.services.TemporalGUID;

import org.springframework.web.bind.annotation.*;


@RestController
@Service

public class GuiFinderAPIController {
	@Autowired
	GuidFindServices gfs;
	
	public GuidFindServices getGfs() {
		return gfs;
	}
	public void setGfs(GuidFindServices gfs) {
		this.gfs=gfs;
	}
	@RequestMapping(value = "/guid", method =RequestMethod.GET)
	public ResponseEntity<?> getPetitionsHandler(){
	    try {
	        return new ResponseEntity<>(gfs.getBuscados(),HttpStatus.OK);
	    } catch (Exception ex) {
	        Logger.getLogger(GuiFinderAPIController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error guids not found",HttpStatus.NOT_FOUND);
	    }   
	}
	@RequestMapping(value = "/guid",  method =RequestMethod.POST)
	public ResponseEntity<?> postPetitionsHandler(@RequestBody TemporalGUID temp){
	    try {
	    	gfs.newSearch(temp.getMyuid());
	    	return new ResponseEntity<>(HttpStatus.CREATED);
	    } catch (Exception ex) {
	        Logger.getLogger(GuiFinderAPIController.class.getName()).log(Level.SEVERE, null, ex);
	        return new ResponseEntity<>("Error "+ex.getMessage(),HttpStatus.FORBIDDEN);  
	    }   
	}
	
	
	
}
