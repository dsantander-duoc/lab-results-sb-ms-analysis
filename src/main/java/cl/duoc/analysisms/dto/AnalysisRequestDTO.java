package cl.duoc.analysisms.dto;

import lombok.Data;

@Data
public class AnalysisRequestDTO {
    private Long patientId;
    private Long laboratoryId;
    private Long doctorUserId;
}