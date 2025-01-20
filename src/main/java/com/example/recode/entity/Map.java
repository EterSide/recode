package com.example.recode.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String map_name;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "map", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Recode> recodes;

    @OneToMany(mappedBy = "map", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Image> images;

    @PrePersist
    public void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

}
