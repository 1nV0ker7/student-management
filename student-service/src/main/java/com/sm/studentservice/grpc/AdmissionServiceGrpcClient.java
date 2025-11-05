package com.sm.studentservice.grpc;

import admission.AdmissionRequest;
import admission.AdmissionResponse;
import admission.AdmissionServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdmissionServiceGrpcClient {
    private static final Logger log = LoggerFactory.getLogger(AdmissionServiceGrpcClient.class);
    private final AdmissionServiceGrpc.AdmissionServiceBlockingStub blockingStub;

    public AdmissionServiceGrpcClient(
            @Value("${admission.service.address:localhost}") String serverAddress,
            @Value("${admission.service.grpc.port:9001}") int serverPort
    ) {
        log.info("Connecting to Admission Service GRPC at {}: {}", serverAddress, serverPort);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, serverPort).usePlaintext().build();

        blockingStub = AdmissionServiceGrpc.newBlockingStub(channel);
    }

    public AdmissionResponse createAdmissionAccount(String studentId, String name, String email) {
        AdmissionRequest request = AdmissionRequest.newBuilder().
                setStudentId(studentId).
                setName(name).
                setEmail(email).
                build();

        AdmissionResponse response = blockingStub.createAdmissionAccount(request);
        log.info("Received response via GRPC : {}", response);
        return response;
    }
}
