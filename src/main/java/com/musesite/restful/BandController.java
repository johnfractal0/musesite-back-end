package com.musesite.restful;

import com.musesite.dao.BandService;
import com.musesite.model.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BandController {
    @Autowired
    BandService bandService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path="/band")
    public ResponseEntity<String> addBand(@RequestBody Band band) {
        bandService.saveBand(band);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path="/band")
    Iterable<Band> getBands() {
        return bandService.getAllBands();
    }
}
