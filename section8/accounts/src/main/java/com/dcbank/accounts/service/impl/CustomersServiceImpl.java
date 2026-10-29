package com.dcbank.accounts.service.impl;

import com.dcbank.accounts.dto.AccountsDto;
import com.dcbank.accounts.dto.CardsDto;
import com.dcbank.accounts.dto.CustomerDetailsDto;
import com.dcbank.accounts.dto.LoansDto;
import com.dcbank.accounts.entity.Accounts;
import com.dcbank.accounts.entity.Customer;
import com.dcbank.accounts.exception.ResourceNotFoundException;
import com.dcbank.accounts.mapper.AccountsMapper;
import com.dcbank.accounts.mapper.CustomerMapper;
import com.dcbank.accounts.repository.AccountsRepository;
import com.dcbank.accounts.repository.CustomerRepository;
import com.dcbank.accounts.service.ICustomersService;
import com.dcbank.accounts.service.client.CardsClient;
import com.dcbank.accounts.service.client.LoansClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl extends ICustomersService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsClient cardsClient;
    private LoansClient loansClient;


    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}
