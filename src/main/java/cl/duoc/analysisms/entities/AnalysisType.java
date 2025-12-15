package cl.duoc.analysisms.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "analysis_types")
public class AnalysisType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analysis_type_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;
}