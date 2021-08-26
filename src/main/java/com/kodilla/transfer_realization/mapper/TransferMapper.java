package com.kodilla.transfer_realization.mapper;

import com.kodilla.transfer_realization.domain.Transfer;
import com.kodilla.transfer_realization.dto.TransferDto;
import org.springframework.stereotype.Component;

@Component
public class TransferMapper {

    public Transfer toTransfer(TransferDto dto) {
        return new Transfer(dto.getId(), dto.getRecipientAccount(), dto.getSenderAccount(), dto.getTitle(),
                dto.getAmount());
    }

    public TransferDto toTransferDto(Transfer transfer) {
        return new TransferDto(transfer.getId(), transfer.getRecipientAccount(), transfer.getSenderAccount(),
                transfer.getTitle(), transfer.getAmount());
    }
}
