package com.musesite.restful;

import com.musesite.dao.AlbumRepository;
import com.musesite.dao.BandRepository;
import com.musesite.model.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.MissingResourceException;

@RestController
public class AlbumBandController {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private BandRepository bandRepository;

    @Transactional
    @PostMapping("/album/{albumId}/band/{bandId}")
    public List<Band> associate(@PathVariable Long albumId, @PathVariable Long bandId) {
        Band band = this.bandRepository.findById(bandId).orElseThrow(() -> new MissingResourceException("Band", "Band"
                , bandId.toString()));

        return this.albumRepository.findById(albumId).map((album) -> {
            album.getBands().add(band);
            return this.albumRepository.save(album).getBands();
        }).orElseThrow(() -> new MissingResourceException("Album", "Album", albumId.toString()));
    }
}
