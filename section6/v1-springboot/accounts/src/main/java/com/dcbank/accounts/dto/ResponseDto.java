package com.dcbank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
public class ResponseDto {

    @Schema(
            description = "Status Code in the response", example = "201"
    )
    private String statusCode;

    @Schema(
            description = "Status Message in the response", example = "Request processed successfully"
    )
    private String statusMsg;
}
