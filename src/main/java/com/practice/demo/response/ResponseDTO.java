package com.practice.demo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@ApiModel(description = "Generic Response Model for APIs")
public class ResponseDTO<T> {

    @ApiModelProperty(notes = "HTTP Status of the response")
    private String status;

    @ApiModelProperty(notes = "HTTP Status Code of the response")
    @Getter(lazy = true)
    private final int statusCode = buildStatusCode();

    @ApiModelProperty(notes = "Error Message if occurs")
    private String error;

    @Builder.Default
    @ApiModelProperty(notes = "Message for the response")
    private String message = "Success!";

    @ApiModelProperty(notes = "Response Body containing data")
    private T body;

    private int buildStatusCode() {
        return Integer.parseInt(this.status.split(" ")[0]);
    }
}
