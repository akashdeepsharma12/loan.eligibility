package com.trainee.loan.eligibility.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoanConfig {
	@Value("${loan.minimum.salary}")
	private double loanMinimumSalary;

	@Value("${loan.minimum.creditscore}")
	private int loanMinimumCreditScore;

	@Value("${loan.maximum.creditscore}")
	private int loanMaximumCreditScore;

	public double getLoanMinimumSalary() {
		return loanMinimumSalary;
	}

	public void setLoanMinimumSalary(double loanMinimumSalary) {
		this.loanMinimumSalary = loanMinimumSalary;
	}

	public int getLoanMinimumCreditScore() {
		return loanMinimumCreditScore;
	}

	public void setLoanMinimumCreditScore(int loanMinimumCreditScore) {
		this.loanMinimumCreditScore = loanMinimumCreditScore;
	}

	public int getLoanMaximumCreditScore() {
		return loanMaximumCreditScore;
	}

	public void setLoanMaximumCreditScore(int loanMaximumCreditScore) {
		this.loanMaximumCreditScore = loanMaximumCreditScore;
	}

}
