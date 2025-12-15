package cl.duoc.analysisms.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "result_details")
public class ResultDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_detail_id")
    private Long resultDetailId;

    @Column(name = "result_value")
    private String resultValue;

    @Column(name = "units")
    private String units;

    @Column(name = "technical_comments")
    private String technicalComments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "analysis_request_id", nullable = false)
    private AnalysisRequest analysisRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "analysis_type_id", nullable = false)
    private AnalysisType analysisType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}