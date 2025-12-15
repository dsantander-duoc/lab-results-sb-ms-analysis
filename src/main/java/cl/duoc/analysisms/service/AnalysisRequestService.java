package cl.duoc.analysisms.service;

import java.util.List;

import cl.duoc.analysisms.dto.AnalysisRequestDTO;
import cl.duoc.analysisms.dto.AnalysisRequestResponseDTO;

public interface AnalysisRequestService {
    AnalysisRequestResponseDTO createAnalysisRequest(AnalysisRequestDTO requestDTO);

    AnalysisRequestResponseDTO getAnalysisRequestById(Long id);

    List<AnalysisRequestResponseDTO> getAllAnalysisRequests();

    AnalysisRequestResponseDTO updateAnalysisRequest(Long id, AnalysisRequestDTO requestDTO);

    void deleteAnalysisRequest(Long id);

    List<AnalysisRequestResponseDTO> getAnalysisRequestsByPatientId(Long patientId);

    List<AnalysisRequestResponseDTO> getAnalysisRequestsByLaboratoryId(Long laboratoryId);

    List<AnalysisRequestResponseDTO> getAnalysisRequestsByDoctorUserId(Long doctorUserId);

}
