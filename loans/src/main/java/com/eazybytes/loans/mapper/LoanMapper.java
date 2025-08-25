package com.eazybytes.loans.mapper;

import com.eazybytes.loans.dto.LoanDto;
import com.eazybytes.loans.entity.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    LoanMapper INSTANCE = Mappers.getMapper( LoanMapper.class );

    LoanDto loansToLoansDto(Loan loan);
    Loan loansDtoToLoans(LoanDto loanDto);
    void updateLoansDtoToLoans(LoanDto loanDto, @MappingTarget Loan loan);
}
