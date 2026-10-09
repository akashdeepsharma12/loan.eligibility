package com.trainee.loan.eligibility.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trainee.loan.eligibility.model.LoanEligibility;

import com.trainee.loan.eligibility.service.LoanEligibilityService;

@RestController
public class LoanEligibilityContoller {

	
	
	
	@Autowired
	private LoanEligibilityService loanEligibilityService;
	
	@PostMapping("/eligibility")
	public String checkLoanEligibility(@RequestBody LoanEligibility loanTwo) {
		String loanThree = loanEligibilityService.saveLoanEligibility(loanTwo);
		return loanThree;
	}
}
