package com.courseapp.api.utilities;

import org.springframework.http.ResponseEntity;

public class BaseAppController {
	protected ResponseEntity<BaseResponse> toResponse(Object data) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setData(data);
		baseResponse.setStatusCode(200);
		baseResponse.setError(false);

		return ResponseEntity.ok(baseResponse);
	}

	protected ResponseEntity<BaseResponse> toResponse(Object data, int statusCode) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setData(data);
		baseResponse.setStatusCode(statusCode);
		baseResponse.setError(false);

		return ResponseEntity.ok(baseResponse);
	}

	protected ResponseEntity<BaseResponse> toResponse(Object data, String message) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setData(data);
		baseResponse.setStatusCode(200);
		baseResponse.setError(false);
		baseResponse.setMessage(message);

		return ResponseEntity.ok(baseResponse);
	}

	protected ResponseEntity<BaseResponse> toResponse(Object data, int statusCode, String message) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setData(data);
		baseResponse.setStatusCode(statusCode);
		baseResponse.setError(false);
		baseResponse.setMessage(message);

		return ResponseEntity.ok(baseResponse);
	}

	protected ResponseEntity<BaseResponse> toResponse(Exception exception) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(500);
		baseResponse.setError(true);
		baseResponse.setMessage(exception.getLocalizedMessage());

		return ResponseEntity.internalServerError().body(baseResponse);
	}

	protected ResponseEntity<BaseResponse> toResponse(Exception exception, int statusCode) {
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(statusCode);
		baseResponse.setError(true);
		baseResponse.setMessage(exception.getLocalizedMessage());

		return ResponseEntity.internalServerError().body(baseResponse);
	}
}