package com.acazia.travelreview.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "travelplace")
public class TravelPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    private String description;
    private String shortDescription;
    private String country;
    private String province;
    private String address;
    private int liked;
    private int rate;
    private String fileName;
//    @ManyToOne
//    @JoinColumn(name = "image_id")
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private ImageModel image;
    @OneToMany(mappedBy = "travelPlace", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties("travelPlace")
    private Collection<ImageModel> images;

    private LocalDate timeCreated = LocalDate.now();

//    @JsonManagedReference
    @OneToMany(mappedBy = "travelPlace", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties("travelPlace")
    private Collection<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;

    public TravelPlace() {
    }

    public TravelPlace(Long id, @NotBlank String name, String description, String shortDescription, String country, String province, String address, int liked, int rate, String fileName, Collection<ImageModel> images, LocalDate timeCreated, Collection<Comment> comments, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.shortDescription = shortDescription;
        this.country = country;
        this.province = province;
        this.address = address;
        this.liked = liked;
        this.rate = rate;
        this.fileName = fileName;
        this.images = images;
        this.timeCreated = timeCreated;
        this.comments = comments;
        this.user = user;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Collection<ImageModel> getImages() {
        return images;
    }

    public void setImages(Collection<ImageModel> images) {
        this.images = images;
    }

    public LocalDate getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDate timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
