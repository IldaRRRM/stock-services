package ru.pet.stockservice.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "user_profile", schema = "profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "balance")
    private Double balance;
    @Column(name = "age")
    private Integer age;
    @ManyToMany(targetEntity = UserPreference.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_preferences", schema = "profile",
            joinColumns = @JoinColumn(name = "user_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "preference_id"))
    private List<UserPreference> userPreferences = new ArrayList<>();
}