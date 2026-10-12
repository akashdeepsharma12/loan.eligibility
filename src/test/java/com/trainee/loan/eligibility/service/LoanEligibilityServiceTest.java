package com.trainee.loan.eligibility.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.trainee.loan.eligibility.config.LoanConfig;
import com.trainee.loan.eligibility.model.LoanEligibility;
import com.trainee.loan.eligibility.repository.LoanEligibilityRepository;

@ExtendWith(MockitoExtension.class)
public class LoanEligibilityServiceTest {
	@InjectMocks
	private LoanEligibilityService loanEligibilityService;

	@Mock
	private LoanEligibilityRepository loanEligibilityRepository;

	@Mock
	private LoanConfig loanConfig;

	private LoanEligibility loan;

	@BeforeEach
	void setup() {
		loan = new LoanEligibility();
		loan.setId(1);
		loan.setName("Mani");
		loan.setSalary(15000);
		loan.setCreditScore(750);
	}

	@Test
	void saveLoanEligibility() {
		when(loanEligibilityRepository.save(loan)).thenReturn(loan);

		when(loanConfig.getLoanMinimumSalary()).thenReturn(10000.0);

		when(loanConfig.getLoanMinimumCreditScore()).thenReturn(680);

		when(loanConfig.getLoanMaximumCreditScore()).thenReturn(900);

		String test1 = loanEligibilityService.saveLoanEligibility(loan);
		
		assertNotNull(test1);
		assertEquals("Eligible For Loan", test1);

	}

}
