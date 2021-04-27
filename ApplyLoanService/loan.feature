Feature: Apply Loan

  Scenario: Loan Application is successful
    Given I visit /applyloan endpoint
    When I enter loan details
    Then I get "Loan Application submitted successfully!"

  Scenario: Loan Application is unsuccessful
    Given I visit /applyloan endpoint
    When I enter loan details of non eligible customer
    Then I get "WARNING: NOT ELIGIBLE FOR LOAN"
    
   Scenario: Loan Application cannot be processed
    Given I visit /applyloan endpoint
    When I enter loan details with single or multiple empty fields
    Then I get "WARNING: Please Enter All Fields"
