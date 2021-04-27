package com.cognizant.BankManagementSystem;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "loan.feature",
plugin = { "json:target/Destination/CucumberApplyLoanReportJSON.json",
"junit:target/Destination/CucumberApplyLoanReportXML.xml" })
public class TestRunnerApplyLoan {

}
