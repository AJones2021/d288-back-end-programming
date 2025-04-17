package com.d288.anna.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="divisions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division")
    private String division_name;


    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;


    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "Country_id", nullable = false, insertable = false,  updatable = false)
    private Country country;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Customer> customer = new HashSet<>();


    @Column(name = "Country_id")
    private Long country_id;

    public void setCountry(Country country) 	{
        setCountry_id(country.getID());
        this.country = country;}
}


