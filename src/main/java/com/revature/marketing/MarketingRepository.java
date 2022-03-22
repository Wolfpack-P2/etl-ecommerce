package com.revature.marketing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketingRepository extends JpaRepository<Marketing,Integer> {
}
