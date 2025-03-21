package mz.demo.kafka.controller;


import lombok.RequiredArgsConstructor;
import mz.demo.kafka.dto.ErrorMessage;
import mz.demo.kafka.dto.PaymentDTO;
import mz.demo.kafka.service.DefaultPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private DefaultPaymentService paymentService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody PaymentDTO paymentDto){

        String paymentId;
        try {
            paymentId = paymentService.create(paymentDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage(new Date(), e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentId);
    }
}
