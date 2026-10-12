package com.trainee.loan.eligibility.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.trainee.loan.eligibility.model.LoanEligibility;
import com.trainee.loan.eligibility.service.LoanEligibilityService;

@ExtendWith(MockitoExtension.class)
public class LoanEligibilityControllerTest {

	@InjectMocks
	private LoanEligibilityContoller loanEligibilityController;

	@Mock
	private LoanEligibilityService loanEligibilityService;

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
	void checkLoanEligibility() {

		when(loanEligibilityService.saveLoanEligibility(loan)).thenReturn("Eligible for loan");

		String loan1 = loanEligibilityController.checkLoanEligibility(loan);
		assertNotNull(loan1);
		assertEquals("Eligible for loan", loan1);

	}

}
