package com.acazia.travelreview.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    @Size(max = 100)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;

//    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "travelplace_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties("travelplace")
    private TravelPlace travelPlace;

//    @JsonManagedReference
    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties("comment")
    private Collection<CommentReply> commentReplies;

    public Comment() {
    }

    public Comment(Long id) {
        this.id = id;
    }

    public Comment(Long id, @NotBlank @Size(max = 100) String content, User user, TravelPlace travelPlace, Collection<CommentReply> commentReplies) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.travelPlace = travelPlace;
        this.commentReplies = commentReplies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TravelPlace getTravelPlace() {
        return travelPlace;
    }

    public void setTravelPlace(TravelPlace travelPlace) {
        this.travelPlace = travelPlace;
    }

    public Collection<CommentReply> getCommentReplies() {
        return commentReplies;
    }

    public void setCommentReplies(Collection<CommentReply> commentReplies) {
        this.commentReplies = commentReplies;
    }
}
