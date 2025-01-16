package com.example.recode.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String player_name;
    @Enumerated(EnumType.STRING)
    private Tribe tribes;

    private int win;
    private int lose;

    @OneToMany(mappedBy = "player1", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Recode> recodes;

}
