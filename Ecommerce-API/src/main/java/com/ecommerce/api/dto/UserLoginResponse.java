package com.ecommerce.api.dto;

public class UserLoginResponse extends BaseResponse{

	
	private String token;

    public UserLoginResponse() {
        super();
    }

    public UserLoginResponse(String status, String message, String token) {
        super(status, message);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
	
}
