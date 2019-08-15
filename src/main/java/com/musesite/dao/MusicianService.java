package com.musesite.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musesite.model.Musician;

@Service
public class MusicianService {
	@Autowired
	private MusicianRepository musicianRepository;
	
	public void saveData(Musician musician) {
		this.musicianRepository.save(musician);
	}
	
	public List<Musician> getAllMusicians() {
		return this.musicianRepository.findMusicians();
	}
	
	@PostConstruct
	private void init() {}
}
