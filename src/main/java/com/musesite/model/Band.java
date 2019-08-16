package com.musesite.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="band")
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "bands")
    private List<Album> albums;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Album> getAlbums() {
        return albums;
    }
    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
