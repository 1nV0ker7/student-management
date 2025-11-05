package com.sm.admissionservice.grpc;

import admission.AdmissionResponse;
import admission.AdmissionServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class AdmissionGrpcService extends AdmissionServiceGrpc.AdmissionServiceImplBase {
    private static final Logger log = LoggerFactory.getLogger(AdmissionGrpcService.class);

    @Override
    public void createAdmissionAccount(
            admission.AdmissionRequest admissionRequest,
            StreamObserver<AdmissionResponse> responseObserver) {
        log.info("createAdmissionAccount request received : {}", admissionRequest.toString());
        AdmissionResponse response = AdmissionResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
