package com.dcbank.accounts.service;

import com.dcbank.accounts.dto.CustomerDetailsDto;

public abstract class ICustomersService {
    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    public abstract CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
