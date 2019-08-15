package com.musesite.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musesite.model.Album;

@Service
public class AlbumService {
	@Autowired
	private AlbumRepository albumRepository;
	
	public void saveAlbum(Album album) {
		this.albumRepository.save(album);
	}
	
	public List<Album> getAllAlbums() {
		return this.albumRepository.findAlbums();
	}
	
	public void updateAlbum(Album album, Long id) {
		Album albumToUpdate = albumRepository.findAlbumById(id);
		if(album.getDuration() != null) {
			albumToUpdate.setDuration(album.getDuration());
		}
		if(album.getTitle() != null) {
			albumToUpdate.setTitle(album.getTitle());
		}
		if(album.getDateOfRelease() != null) {
			albumToUpdate.setDateOfRelease(album.getDateOfRelease());
		}
		if(album.getCoverPath() != null) {
			albumToUpdate.setCoverPath(album.getCoverPath());
		}
		this.albumRepository.save(albumToUpdate);
	}
	
	@PostConstruct
	private void init() {}
}
