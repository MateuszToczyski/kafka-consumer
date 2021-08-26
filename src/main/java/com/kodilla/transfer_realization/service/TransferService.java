package com.kodilla.transfer_realization.service;

import com.kodilla.commons.TransferMessage;
import com.kodilla.transfer_realization.domain.Transfer;
import com.kodilla.transfer_realization.repository.TransferRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransferService {

    private static final String CREATED_TRANSFERS_TOPIC = "created-transfers";

    private final TransferRepository transferRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void createTransfer(TransferMessage message) {
        com.kodilla.commons.Transfer incomingTransfer = message.getTransfer();

        Transfer transfer = new Transfer();
        transfer.setRecipientAccount(incomingTransfer.getRecipientAccount());
        transfer.setSenderAccount(incomingTransfer.getSenderAccount());
        transfer.setTitle(incomingTransfer.getTitle());
        transfer.setAmount(incomingTransfer.getAmount());

        transferRepository.save(transfer);

        kafkaTemplate.send(CREATED_TRANSFERS_TOPIC, message);
    }
}
