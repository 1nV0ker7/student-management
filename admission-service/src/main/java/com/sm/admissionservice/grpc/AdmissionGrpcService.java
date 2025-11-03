package com.sm.admissionservice.grpc;

import admission.AdmissionResponse;
import admission.AdmissionServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class AdmissionGrpcService extends AdmissionServiceGrpc.AdmissionServiceImplBase {
    @Override
    public void createAdmissionAccount(
            admission.AdmissionRequest admissionRequest,
            StreamObserver<AdmissionResponse> responseObserver) {

        


    }


}
