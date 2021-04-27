package com.cognizant.BankManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.BankManagementSystem.model.LoanModel;
import com.cognizant.BankManagementSystem.repository.LoanRepo;
import com.cognizant.BankManagementSystem.service.LoanService;

@RestController
@RequestMapping("/applyloan")
public class LoanController {

	Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	@Autowired
	private LoanRepo loanrepo;
	
	@Autowired
	private LoanService loanService;

	@PostMapping
	public String saveLoanApplication(@RequestBody LoanModel loandata) {
		logger.info("START: saveLoanApplication Function");
		String msg = loanService.apply(loandata);
		logger.info("END: saveLoanApplication Function: "+msg);
		return msg;
	}


	@GetMapping
	public List<LoanModel> getAllLoanApplications() {
		logger.info("START: getAllLoanApplication Function");
		List<LoanModel> list = new ArrayList<LoanModel>();
		for(LoanModel model : loanrepo.findAll()){
			list.add(model);
		}
		return list;
	}
}
