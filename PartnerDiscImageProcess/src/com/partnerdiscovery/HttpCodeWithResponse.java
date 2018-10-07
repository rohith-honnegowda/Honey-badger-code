package com.partnerdiscovery;

// A Simple POJO to carry more data in the response
public class HttpCodeWithResponse {
	public int responseCode;
	public String response;
	
	public HttpCodeWithResponse(int httpcode, String response) {
		this.responseCode = httpcode;
		this.response = response;
	}
}
