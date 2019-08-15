	package com.musesite.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.musesite.dao.MusicianService;
import com.musesite.model.Musician;

@RestController
public class MusicianController {
	@Autowired
	MusicianService musicianService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/musician")
	public ResponseEntity<String> addMusician(@RequestBody Musician musician) {
		musicianService.saveData(musician);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/musician")
	Iterable<Musician> getMusicians() {
		return musicianService.getAllMusicians();
	}
}
