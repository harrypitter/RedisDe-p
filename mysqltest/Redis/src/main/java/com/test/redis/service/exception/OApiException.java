package com.test.redis.service.exception;

public class OApiException extends Exception {

	public OApiException(int errCode, String errMsg) {
		super("error code: " + errCode + ", error message: " + errMsg);
	}
}
