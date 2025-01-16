package com.example.recode.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Recode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean result;

    @ManyToOne
    @JoinColumn(name = "player1_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "player2_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Player player2;

    @ManyToOne
    @JoinColumn(name = "Map_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Map map;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private User user;
}
