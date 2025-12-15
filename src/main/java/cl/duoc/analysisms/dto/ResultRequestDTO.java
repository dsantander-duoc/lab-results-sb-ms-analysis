package cl.duoc.analysisms.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class ResultRequestDTO {
    private Long resultDetailId;
    private Long analysisRequestId;
    private Long analysisTypeId;
    private String resultValue;
    private String units;
    private String comments;
    private Long technicianUserId;
}
