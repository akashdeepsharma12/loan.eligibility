package com.trainee.loan.eligibility.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainee.loan.eligibility.config.LoanConfig;
import com.trainee.loan.eligibility.model.LoanEligibility;

import com.trainee.loan.eligibility.repository.LoanEligibilityRepository;

@Service
public class LoanEligibilityService {
	@Autowired
	private LoanEligibilityRepository loanEligibilityRepository;

	@Autowired
	private LoanConfig loanConfig;

	public String saveLoanEligibility(LoanEligibility loan) {

		try {

			boolean isLoanEligible = checkEligibility(loan);
			if (isLoanEligible) {
				loanEligibilityRepository.save(loan);
				return "Eligible For Loan";
			} else {

				loanEligibilityRepository.save(loan);
				return "Not Eligible for Loan";
			}

		} catch (Exception ex) {

		}
		return null;

	}

	private boolean checkEligibility(LoanEligibility loan) {

		if (loan == null) {
			return false;
		}

		double loanSalary = loan.getSalary();
		int loanCreditScore = loan.getCreditScore();
		boolean isEligible = (loanSalary > loanConfig.getLoanMinimumSalary())
				&& (loanCreditScore > loanConfig.getLoanMinimumCreditScore()
						&& loanCreditScore <= loanConfig.getLoanMaximumCreditScore());

		/*
		 * boolean eligibilityCheck = false; if (loan.getSalary() > 10000) {
		 * 
		 * if (loan.getCreditScore() > 600 && loan.getCreditScore() <= 680) {
		 * 
		 * } else if (loan.getCreditScore() > 680 && loan.getCreditScore() <= 750) {
		 * eligibilityCheck = true; } else if (loan.getCreditScore() > 751 &&
		 * loan.getCreditScore() <= 810) { eligibilityCheck = true; } else if
		 * (loan.getCreditScore() > 811 && loan.getCreditScore() <= 900) {
		 * eligibilityCheck = true; }
		 * 
		 * }
		 */
		loan.setEligibility(isEligible);
		return isEligible;
	}
}
