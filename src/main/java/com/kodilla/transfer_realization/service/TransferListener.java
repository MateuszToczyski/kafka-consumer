package com.kodilla.transfer_realization.service;

import com.kodilla.commons.TransferMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransferListener {

    private final TransferService transferService;

    @KafkaListener(topics = "transfers")
    public void consume(@Payload TransferMessage message) {
        transferService.createTransfer(message);
    }

}
