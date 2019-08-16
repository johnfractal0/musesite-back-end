package com.musesite.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="album")
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="title")
	private String title;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Band> bands;
	@ManyToMany(targetEntity = Musician.class, mappedBy = "albums")
	private List<Musician> musicians;
	@Embedded
	@Column(name="duration")
	private Duration duration;
	@Column(name="dateofrelease")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="CET")
	private Date dateOfRelease;
	@Column(name="coverpath")
	private String coverPath;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Duration getDuration() {
		return duration;
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
	public Date getDateOfRelease() {
		return dateOfRelease;
	}
	public void setDateOfRelease(Date dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}
	public String getCoverPath() {
		return coverPath;
	}
	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}
	public List<Band> getBands() {
		return bands;
	}
	public void setBands(List<Band> bands) {
		this.bands = bands;
	}
	public List<Musician> getMusicians() {
		return musicians;
	}
	public void setMusicians(List<Musician> musicians) {
		this.musicians = musicians;
	}
}
