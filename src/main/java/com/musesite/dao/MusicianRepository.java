package com.musesite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.musesite.model.Musician;

public interface MusicianRepository extends JpaRepository<Musician,Long> {
	@Query(value = "SELECT * FROM musician", nativeQuery = true)
	List<Musician> findMusicians();
	
	Musician save(Musician persisted);
}
