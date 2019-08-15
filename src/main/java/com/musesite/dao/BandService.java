package com.musesite.dao;

import com.musesite.model.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BandService {
    @Autowired
    private BandRepository bandRepository;

    public void saveBand(Band band) {
        this.bandRepository.save(band);
    }

    public List<Band> getAllBands() {
        return this.bandRepository.findBands();
    }

    public void updateBand(Band band, Long id) {
        Band bandToUpdate = bandRepository.findBandById(id);
        if(band.getName() != null) {
            bandToUpdate.setName(band.getName());
        }
        if(band.getAlbums() != null) {
            bandToUpdate.setAlbums(band.getAlbums());
        }
        this.bandRepository.save(bandToUpdate);
    }

    @PostConstruct
    private void init() {}
}
