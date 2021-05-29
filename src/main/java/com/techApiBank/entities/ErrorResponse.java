package com.techApiBank.entities;
  
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Api Error responses")
public class ErrorResponse{
   
	@ApiModelProperty(notes="CODE error response", name="code", required=true, value="200")
	private int code;

	@ApiModelProperty(notes="STATUS error response", name="status", required=true, value="SUCCESS")
	private String status;

	@ApiModelProperty(notes="MESSAGE error response", name="message", required=true, value="INVALID FIELD") 
	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	 
}

