package com.dcbank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @NotEmpty(message = "AccountNumber can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digit")
    @Schema(
            description = "Account Number of DC Bank account", example = "1234567"
    )
    private Long accountNumber;

    @Schema(
            description = "Account Type of DC Bank account", example = "Savings"
    )
    @NotEmpty(message = "AccountType can not be null or empty")
    private String accountType;

    @NotEmpty(message = "BranchAddress can not be null or empty")
    @Schema(
            description = "DC Bank branch address", example = "123 Pune"
    )
    private String branchAddress;
}
