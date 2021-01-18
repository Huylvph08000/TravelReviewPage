package com.acazia.travelreview.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int star;
//    @ManyToOne
//    private User user;
//    @OneToMany
//    private Collection<TravelPlace> travelPlace;
}
