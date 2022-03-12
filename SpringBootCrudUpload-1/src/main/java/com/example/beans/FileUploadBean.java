package com.example.beans;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.boot.autoconfigure.domain.EntityScan;
@Entity
@EntityScan
@Table(name = "FileUpload")
public class FileUploadBean {
    @Column(name="Id")
	private Long id;
	@Column(name="Name")
	private String name;
	@Column(name="Photo" ,nullable=true,length=64)
	private String photo;
	@Column(name="Video",nullable=true,length=64)
	private String video;
	@Column(name="Document",nullable=true,length=64)
	private String document;
	public FileUploadBean() {
		System.out.println(" Iam Printing in constructor");
	}
	
	public FileUploadBean(Long id, String name, String photo, String video,String document) {
		super();
		System.out.println("para constructor");
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.video= video;
	    this.document=document;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}


	@Transient
	public String DetailsImage;
	public String getDetailsImage() {
		return DetailsImage;
	}

	public void setDetailsImage(String detailsImage) {
		DetailsImage = detailsImage;
	}


		
}
