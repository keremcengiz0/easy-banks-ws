package com.eazybytes.accounts.services;

import com.eazybytes.accounts.dto.CustomerDto;

public interface IAccountsService {
    void createAccount(CustomerDto customerDto);
    CustomerDto getAccountByMobileNumber(String mobileNumber);
    boolean updateAccountDetails(CustomerDto customerDto);
    boolean deleteAccount(String mobileNumber);
}
