package com.eazybytes.loans.services;

import com.eazybytes.loans.dto.LoanDto;

public interface ILoanService {
    void createLoan(String mobileNumber);

    LoanDto getLoan(String mobileNumber);

    boolean updateLoan(LoanDto loanDto);

    boolean deleteLoan(String mobileNumber);
}
