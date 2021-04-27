package com.cognizant.BankManagementSystem.repository;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.BankManagementSystem.model.LoanModel;

public interface LoanRepo extends DatastoreRepository<LoanModel, Long>{

}
