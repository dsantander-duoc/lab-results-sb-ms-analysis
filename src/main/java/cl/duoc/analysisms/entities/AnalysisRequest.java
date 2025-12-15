package cl.duoc.analysisms.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "analysis_requests")
public class AnalysisRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analysis_request_id")
    private Long id;

    @CreationTimestamp
    @Column(name = "request_date", nullable = false)
    private LocalDate requestDate;

    @Column(name = "request_status", nullable = false)
    private String requestStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "laboratory_id", nullable = false)
    private Laboratory laboratory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToMany(mappedBy = "analysisRequest", cascade = CascadeType.ALL)
    private List<ResultDetail> details;
}