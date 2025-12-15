package cl.duoc.analysisms.dto;

import lombok.Data;

@Data
public class ResultDTO {
    private Long requestId;
    private Long analysisTypeId;
    private String resultValue;
    private String units;
    private String comments;
    private Long technicianUserId;
}