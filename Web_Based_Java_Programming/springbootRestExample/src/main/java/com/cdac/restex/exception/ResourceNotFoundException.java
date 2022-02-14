package com.cdac.restex.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private String resourceNameString;
	private String fieldNameString;
	private Object fieldValue;

	public ResourceNotFoundException(String resourceNameString, String fieldNameString, Object fieldValue) {
		super(String.format("%s not found with %s :'%s'", resourceNameString, fieldNameString, fieldValue));
		this.resourceNameString = resourceNameString;
		this.fieldNameString = fieldNameString;
		this.fieldValue = fieldValue;
	}

	public String getResourceNameString() {
		return resourceNameString;
	}

	public void setResourceNameString(String resourceNameString) {
		this.resourceNameString = resourceNameString;
	}

	public String getFieldNameString() {
		return fieldNameString;
	}

	public void setFieldNameString(String fieldNameString) {
		this.fieldNameString = fieldNameString;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}

}
