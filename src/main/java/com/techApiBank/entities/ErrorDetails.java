package com.techApiBank.entities;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty; 

import io.swagger.annotations.ApiModel; 

@ApiModel(description = "Error responses Model")
public class ErrorDetails {
	
	@ApiModelProperty(notes="Current Time error response", name="timestamp", required=true, value="10/04/2020")
    private Date timestamp;
	
	@ApiModelProperty(notes="Message error response", name="status", required=true, value="Error message")
    private String message;
	
	@ApiModelProperty(notes="Details error response", name="message", required=true, value="INVALID FIELD") 
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
         super();
         this.timestamp = timestamp;
         this.message = message;
         this.details = details;
    }

    public Date getTimestamp() {
         return timestamp;
    }

    public String getMessage() {
         return message;
    }

    public String getDetails() {
         return details;
    }

}