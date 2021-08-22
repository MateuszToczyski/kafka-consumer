package com.kodilla.transfer_realization.repository;

import com.kodilla.transfer_realization.domain.Transfer;
import org.springframework.data.repository.CrudRepository;

public interface TransferRepository extends CrudRepository<Transfer, Long> {
}
