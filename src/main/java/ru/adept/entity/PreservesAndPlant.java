package ru.adept.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@Table(name = "preserves_plant")
public class PreservesAndPlant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_plant", nullable = false)
    Plant plant;

    @ManyToOne
    @JoinColumn(name = "id_preserve", nullable = false)
    Preserve preserve;

}
