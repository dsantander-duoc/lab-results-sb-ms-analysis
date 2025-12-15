package cl.duoc.analysisms.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class AnalysisRequestResponseDTO {
    private Long analysisRequestId;
    private String patientRut;
    private String laboratoryName;
    private String doctorName;
    private LocalDate requestDate;
    private String requestStatus;

}
