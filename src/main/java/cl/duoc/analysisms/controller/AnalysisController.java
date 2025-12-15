package cl.duoc.analysisms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.analysisms.dto.AnalysisRequestDTO;
import cl.duoc.analysisms.dto.AnalysisRequestResponseDTO;
import cl.duoc.analysisms.service.AnalysisRequestService;

@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisRequestService analysisRequestService;

    @PostMapping("/request")
    public ResponseEntity<AnalysisRequestResponseDTO> createRequest(@RequestBody AnalysisRequestDTO requestDTO) {
        AnalysisRequestResponseDTO newRequest = analysisRequestService.createAnalysisRequest(requestDTO);
        return ResponseEntity.ok(newRequest);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<AnalysisRequestResponseDTO>> getAnalysisRequestsByPatientId(
            @PathVariable Long patientId) {
        List<AnalysisRequestResponseDTO> analysisRequests = analysisRequestService
                .getAnalysisRequestsByPatientId(patientId);
        return ResponseEntity.ok(analysisRequests);
    }

    @GetMapping("/laboratory/{laboratoryId}")
    public ResponseEntity<List<AnalysisRequestResponseDTO>> getAnalysisRequestsByLaboratoryId(
            @PathVariable Long laboratoryId) {
        List<AnalysisRequestResponseDTO> analysisRequests = analysisRequestService
                .getAnalysisRequestsByLaboratoryId(laboratoryId);
        return ResponseEntity.ok(analysisRequests);
    }

    @GetMapping("/doctor/{doctorUserId}")
    public ResponseEntity<List<AnalysisRequestResponseDTO>> getAnalysisRequestsByDoctorUserId(
            @PathVariable Long doctorUserId) {
        List<AnalysisRequestResponseDTO> analysisRequests = analysisRequestService
                .getAnalysisRequestsByDoctorUserId(doctorUserId);
        return ResponseEntity.ok(analysisRequests);
    }

    @GetMapping("/{analysisRequestId}")
    public ResponseEntity<AnalysisRequestResponseDTO> getAnalysisRequestById(@PathVariable Long analysisRequestId) {
        AnalysisRequestResponseDTO analysisRequest = analysisRequestService.getAnalysisRequestById(analysisRequestId);
        return ResponseEntity.ok(analysisRequest);
    }

    @PutMapping("/{analysisRequestId}")
    public ResponseEntity<AnalysisRequestResponseDTO> updateAnalysisRequest(@PathVariable Long analysisRequestId,
            @RequestBody AnalysisRequestDTO requestDTO) {
        AnalysisRequestResponseDTO updatedAnalysisRequest = analysisRequestService
                .updateAnalysisRequest(analysisRequestId, requestDTO);
        return ResponseEntity.ok(updatedAnalysisRequest);
    }

    @DeleteMapping("/{analysisRequestId}")
    public ResponseEntity<Void> deleteAnalysisRequest(@PathVariable Long analysisRequestId) {
        analysisRequestService.deleteAnalysisRequest(analysisRequestId);
        return ResponseEntity.noContent().build();
    }
}