package com.cognizant.BankManagementSystem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import com.cognizant.BankManagementSystem.model.LoanModel;
import com.cognizant.BankManagementSystem.repository.LoanRepo;

@Service
public class LoanService {

	Logger logger = LoggerFactory.getLogger(LoanService.class);
	
	@Autowired
	private LoanRepo loanrepo;


	public String checkLoanEligible(LoanModel loandata) {
		logger.info("START: checkLoanEligible function in Service");
		String msg="";
		if((loandata.getMonthlyIncome()*12) < (loandata.getLoanAmount()/loandata.getDuration())) {
			msg = "WARNING: NOT ELIGIBLE FOR LOAN";
			logger.warn(msg);
			return msg;
		}
		else if(loandata.getLoanAmount()==0 || loandata.getMonthlyIncome()==0 || loandata.getLoanType()==null || loandata.getLoanType().isEmpty()) {
			msg = "WARNING: Please Enter All Fields";
			logger.warn(msg);
			return msg;
		}
		logger.info("END: checkLoanEligible function in Service");
		return "Loan Application submitted successfully!";
		
	}
	
	public String apply(LoanModel loandata) {
		logger.info("START: apply function in Service");
		String val = checkLoanEligible(loandata);
		if(val.contains("WARNING"))
				return val;
		loanrepo.save(loandata);
		logger.info("END: apply function in Service");
		return val;
	}

}
