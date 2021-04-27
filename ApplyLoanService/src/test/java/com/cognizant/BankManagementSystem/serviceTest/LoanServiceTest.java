package com.cognizant.BankManagementSystem.serviceTest;

import com.cognizant.BankManagementSystem.model.LoanModel;
import com.cognizant.BankManagementSystem.service.LoanService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoanServiceTest {
	
	LoanService loanService;
	
	LoanModel loanModel = new LoanModel(1221,"BYAKG1229M","Vehicle",600000,25000,11,3);
	LoanModel loanModelNotEligible = new LoanModel(1331,"KGAKG1233J","Home",6000000,25000,11,3);
	LoanModel loanModelFieldsEmpty = new LoanModel(1441,"KGAKG1233J","",400000,25000,10,4);
	
	String message="";

	@Given("I visit \\/applyloan endpoint")
	public void i_visit_apply_endpoint() {
		loanService = new LoanService();
	}

	@When("I enter loan details")
	public void i_enter_loan_details() {
		message = loanService.checkLoanEligible(loanModel);
	}
	
	@When("I enter loan details of non eligible customer")
	public void i_enter_loan_details_of_not_eligible_customer() {
		message = loanService.checkLoanEligible(loanModelNotEligible);
	}

	@When("I enter loan details with single or multiple empty fields")
	public void i_enter_loan_details_with_single_or_multiple_empty_fields() {
		message = loanService.checkLoanEligible(loanModelFieldsEmpty);
	}


	@Then("I get {string}")
	public void i_get(String string) {
		Assert.assertEquals(message, string);
	}	
	
}
