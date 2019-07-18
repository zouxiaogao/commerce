package com.neusoft.commerce.common;

public class Result {
private Integer code;
private String message;
private Object data;

public Result() {
}

public Result(Object data) {
    this.data=data;
}

public Result(Integer code, String message) {
    super();
	this.code = code;
	this.message = message;
}
public Result(Integer code, String message, Object data) {
	this(code,message);
	this.data = data;
}
public Integer getCode() {
	return code;
}
public void setCode(Integer code) {
	this.code = code;
}
public String getmessage() {
	return message;
}
public void setmessage(String message) {
	this.message = message;
}
public Object getData() {
	return data;
}
public void setData(Object data) {
	this.data = data;
}

}
