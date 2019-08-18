package com.musesite.restful;

import com.musesite.dao.AlbumRepository;
import com.musesite.dao.BandRepository;
import com.musesite.model.Album;
import com.musesite.model.Band;
import java.util.MissingResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumBandController {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private BandRepository bandRepository;

    @Transactional //FIXME: move to service layer
    @PostMapping("/album/{albumId}/band/{bandId}") //FIXME: POST or PUT? What HTTP status should be returned?
    public Association associate(@PathVariable Long albumId, @PathVariable Long bandId) {
        Band band = bandRepository.findById(bandId).orElseThrow(() -> new MissingResourceException("Band", "Band"
                , bandId.toString()));

        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new MissingResourceException("Album", "Album", albumId.toString()));

        album.getBands().add(band);
//        albumRepository.save(album); <--- This save is redundant
        return new Association(album.getId(), band.getId());
    }
}
