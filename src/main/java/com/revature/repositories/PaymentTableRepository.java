package com.revature.repositories;

import com.revature.models.PayementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTableRepository extends JpaRepository<PayementEntity,Integer> {

}
