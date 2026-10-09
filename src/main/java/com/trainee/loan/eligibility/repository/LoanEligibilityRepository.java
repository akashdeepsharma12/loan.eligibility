package com.trainee.loan.eligibility.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainee.loan.eligibility.model.LoanEligibility;

@Repository
public interface LoanEligibilityRepository extends JpaRepository<LoanEligibility, Long> {

}
