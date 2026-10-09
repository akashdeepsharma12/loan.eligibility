package com.trainee.loan.eligibility.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loaneligibility")
public class LoanEligibility {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private double salary;
	@Column(name = "creditscore")
	private int creditScore;
	private boolean eligibility;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public boolean getEligibility() {
		return eligibility;
	}

	public void setEligibility(boolean eligibility) {
		this.eligibility = eligibility;
	}

	public LoanEligibility() {

	}

	public LoanEligibility(long id, String name, double salary, int creditScore, boolean eligibility) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.creditScore = creditScore;
		this.eligibility = eligibility;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(creditScore), Boolean.valueOf(eligibility), Long.valueOf(id), name,
				Double.valueOf(salary));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanEligibility other = (LoanEligibility) obj;
		return creditScore == other.creditScore && eligibility == other.eligibility && id == other.id
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	@Override
	public String toString() {
		return "LoanEligibility [id=" + id + ", name=" + name + ", salary=" + salary + ", creditScore=" + creditScore
				+ ", eligibility=" + eligibility + "]";
	}

}