package com.example.recode.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id", nullable = true)
    @JsonIgnore
    private Player player;

    @ManyToOne
    @JoinColumn(name = "Map_id", referencedColumnName = "id", nullable = true)
    @JsonIgnore
    private Map map;

}
