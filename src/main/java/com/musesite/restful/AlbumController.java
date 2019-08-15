package com.musesite.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.musesite.dao.AlbumService;
import com.musesite.model.Album;

@RestController
public class AlbumController {
	@Autowired
	AlbumService albumService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path="/album")
	public ResponseEntity<String> addAlbum(@RequestBody Album album) {
		albumService.saveAlbum(album);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/album")
	Iterable<Album> getAlbums() {
		return albumService.getAllAlbums();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(path="/album/{id}")
	ResponseEntity<String> updateAlbum(@RequestBody Album album, @PathVariable Long id) {
		albumService.updateAlbum(album, id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
