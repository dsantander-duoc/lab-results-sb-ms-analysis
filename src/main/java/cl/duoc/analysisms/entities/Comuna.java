package cl.duoc.analysisms.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comunas")
public class Comuna {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "comuna")
    private String nombre;
}