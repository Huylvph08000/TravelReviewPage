package com.acazia.travelreview.models;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "image_table")
public class ImageModel {
    public ImageModel() {
        super();
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private TravelPlace travelPlace;

    @Column(name = "picByte",length = 1000)
    private byte[] picByte;

    public ImageModel(Long id, String name, String type, TravelPlace travelPlace, byte[] picByte) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.travelPlace = travelPlace;
        this.picByte = picByte;
    }

    public ImageModel(String originalFilename, String contentType, byte[] compressBytes) {
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TravelPlace getTravelPlace() {
        return travelPlace;
    }

    public void setTravelPlace(TravelPlace travelPlace) {
        this.travelPlace = travelPlace;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}

