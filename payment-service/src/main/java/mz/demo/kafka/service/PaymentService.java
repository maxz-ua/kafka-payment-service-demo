package mz.demo.kafka.service;

import mz.demo.kafka.dto.PaymentDTO;

import java.util.concurrent.ExecutionException;

public interface PaymentService {
    String create(PaymentDTO paymentDto) throws ExecutionException, InterruptedException;
}
