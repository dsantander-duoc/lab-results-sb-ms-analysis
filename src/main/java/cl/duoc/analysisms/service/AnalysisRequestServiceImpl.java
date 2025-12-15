package cl.duoc.analysisms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cl.duoc.analysisms.dto.AnalysisRequestDTO;
import cl.duoc.analysisms.dto.AnalysisRequestResponseDTO;
import cl.duoc.analysisms.entities.AnalysisRequest;
import cl.duoc.analysisms.repository.AnalysisRequestRepository;
import cl.duoc.analysisms.repository.LaboratoryRepository;
import cl.duoc.analysisms.repository.PatientRepository;
import cl.duoc.analysisms.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnalysisRequestServiceImpl implements AnalysisRequestService {

        private final AnalysisRequestRepository analysisRequestRepository;
        private final LaboratoryRepository laboratoryRepository;
        private final UserRepository userRepository;
        private final PatientRepository patientRepository;

        @Override
        public AnalysisRequestResponseDTO createAnalysisRequest(AnalysisRequestDTO request) {
                AnalysisRequest analysisRequest = new AnalysisRequest();
                analysisRequest.setPatient(patientRepository.findById(request.getPatientId())
                                .orElseThrow(() -> new RuntimeException("Patient not found")));
                analysisRequest.setLaboratory(laboratoryRepository.findById(request.getLaboratoryId())
                                .orElseThrow(() -> new RuntimeException("Laboratory not found")));
                analysisRequest.setUser(userRepository.findById(request.getDoctorUserId())
                                .orElseThrow(() -> new RuntimeException("User not found")));
                analysisRequest.setRequestDate(LocalDate.now());
                analysisRequest.setRequestStatus("PENDIENTE");
                AnalysisRequest savedAnalysisRequest = analysisRequestRepository.save(analysisRequest);
                return AnalysisRequestResponseDTO.builder()
                                .analysisRequestId(savedAnalysisRequest.getId())
                                .patientRut(savedAnalysisRequest.getPatient().getRut())
                                .laboratoryName(savedAnalysisRequest.getLaboratory().getName())
                                .doctorName(savedAnalysisRequest.getUser().getName())
                                .requestDate(savedAnalysisRequest.getRequestDate())
                                .requestStatus(savedAnalysisRequest.getRequestStatus())
                                .build();
        }

        @Override
        public AnalysisRequestResponseDTO getAnalysisRequestById(Long id) {
                AnalysisRequest analysisRequest = analysisRequestRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Analysis request not found"));
                return AnalysisRequestResponseDTO.builder()
                                .analysisRequestId(analysisRequest.getId())
                                .patientRut(analysisRequest.getPatient().getRut())
                                .laboratoryName(analysisRequest.getLaboratory().getName())
                                .doctorName(analysisRequest.getUser().getName())
                                .requestDate(analysisRequest.getRequestDate())
                                .requestStatus(analysisRequest.getRequestStatus())
                                .build();
        }

        @Override
        public List<AnalysisRequestResponseDTO> getAllAnalysisRequests() {
                List<AnalysisRequest> analysisRequests = analysisRequestRepository.findAll();
                return analysisRequests.stream()
                                .map(analysisRequest -> AnalysisRequestResponseDTO.builder()
                                                .analysisRequestId(analysisRequest.getId())
                                                .patientRut(analysisRequest.getPatient().getRut())
                                                .laboratoryName(analysisRequest.getLaboratory().getName())
                                                .doctorName(analysisRequest.getUser().getName())
                                                .requestDate(analysisRequest.getRequestDate())
                                                .requestStatus(analysisRequest.getRequestStatus())
                                                .build())
                                .collect(Collectors.toList());
        }

        @Override
        public AnalysisRequestResponseDTO updateAnalysisRequest(Long id, AnalysisRequestDTO request) {
                AnalysisRequest analysisRequest = analysisRequestRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Analysis request not found"));
                if (analysisRequest.getRequestStatus().equals("FINALIZADO")) {
                        throw new RuntimeException("Analysis request already completed");
                }
                if (analysisRequest.getRequestStatus().equals("CANCELADO")) {
                        throw new RuntimeException("Analysis request already canceled");
                }
                analysisRequest.setPatient(patientRepository.findById(request.getPatientId())
                                .orElseThrow(() -> new RuntimeException("Patient not found")));
                analysisRequest.setLaboratory(laboratoryRepository.findById(request.getLaboratoryId())
                                .orElseThrow(() -> new RuntimeException("Laboratory not found")));
                analysisRequest.setUser(userRepository.findById(request.getDoctorUserId())
                                .orElseThrow(() -> new RuntimeException("User not found")));
                analysisRequest.setRequestDate(LocalDate.now());
                analysisRequest.setRequestStatus("PENDIENTE");
                AnalysisRequest savedAnalysisRequest = analysisRequestRepository.save(analysisRequest);
                return AnalysisRequestResponseDTO.builder()
                                .analysisRequestId(savedAnalysisRequest.getId())
                                .patientRut(savedAnalysisRequest.getPatient().getRut())
                                .laboratoryName(savedAnalysisRequest.getLaboratory().getName())
                                .doctorName(savedAnalysisRequest.getUser().getName())
                                .requestDate(savedAnalysisRequest.getRequestDate())
                                .requestStatus(savedAnalysisRequest.getRequestStatus())
                                .build();
        }

        @Override
        public void deleteAnalysisRequest(Long id) {
                AnalysisRequest analysisRequest = analysisRequestRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Analysis request not found"));
                analysisRequestRepository.delete(analysisRequest);
        }

        @Override
        public List<AnalysisRequestResponseDTO> getAnalysisRequestsByPatientId(Long patientId) {
                List<AnalysisRequest> analysisRequests = analysisRequestRepository.findByPatientId(patientId);
                return analysisRequests.stream()
                                .map(analysisRequest -> AnalysisRequestResponseDTO.builder()
                                                .analysisRequestId(analysisRequest.getId())
                                                .patientRut(analysisRequest.getPatient().getRut())
                                                .laboratoryName(analysisRequest.getLaboratory().getName())
                                                .doctorName(analysisRequest.getUser().getName())
                                                .requestDate(analysisRequest.getRequestDate())
                                                .requestStatus(analysisRequest.getRequestStatus())
                                                .build())
                                .collect(Collectors.toList());
        }

        @Override
        public List<AnalysisRequestResponseDTO> getAnalysisRequestsByLaboratoryId(Long laboratoryId) {
                List<AnalysisRequest> analysisRequests = analysisRequestRepository.findByLaboratoryId(laboratoryId);
                return analysisRequests.stream()
                                .map(analysisRequest -> AnalysisRequestResponseDTO.builder()
                                                .analysisRequestId(analysisRequest.getId())
                                                .patientRut(analysisRequest.getPatient().getRut())
                                                .laboratoryName(analysisRequest.getLaboratory().getName())
                                                .doctorName(analysisRequest.getUser().getName())
                                                .requestDate(analysisRequest.getRequestDate())
                                                .requestStatus(analysisRequest.getRequestStatus())
                                                .build())
                                .collect(Collectors.toList());
        }

        @Override
        public List<AnalysisRequestResponseDTO> getAnalysisRequestsByDoctorUserId(Long doctorUserId) {
                List<AnalysisRequest> analysisRequests = analysisRequestRepository.findByUserId(doctorUserId);
                return analysisRequests.stream()
                                .map(analysisRequest -> AnalysisRequestResponseDTO.builder()
                                                .analysisRequestId(analysisRequest.getId())
                                                .patientRut(analysisRequest.getPatient().getRut())
                                                .laboratoryName(analysisRequest.getLaboratory().getName())
                                                .doctorName(analysisRequest.getUser().getName())
                                                .requestDate(analysisRequest.getRequestDate())
                                                .requestStatus(analysisRequest.getRequestStatus())
                                                .build())
                                .collect(Collectors.toList());
        }
}