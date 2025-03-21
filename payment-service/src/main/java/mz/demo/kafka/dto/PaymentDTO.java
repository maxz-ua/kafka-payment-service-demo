package mz.demo.kafka.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentDTO {
    private BigDecimal sum;
    private String createdAt;
    private String orderId;
    private String userId;
}
