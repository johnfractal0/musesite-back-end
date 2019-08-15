package com.musesite.dao;


import com.musesite.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BandRepository extends JpaRepository<Band,Long> {
    @Query(value = "SELECT * FROM band", nativeQuery = true)
    List<Band> findBands();

    @Query(value = "Select * from band where id = ?1", nativeQuery = true)
    Band findBandById(Long id);

    Band save(Band persisted);
}
