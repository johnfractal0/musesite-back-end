package com.musesite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.musesite.model.Album;

public interface AlbumRepository extends JpaRepository<Album,Long> {
	@Query(value = "SELECT * FROM album", nativeQuery = true)
	List<Album> findAlbums();
	
	@Query(value = "Select * from album where id = ?1", nativeQuery = true)
	Album findAlbumById(Long id);
	
	Album save(Album persisted);
}
