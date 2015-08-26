package com.goinitaly.spring.web.dto;

import java.io.Serializable;
import java.util.List;

public class BaseAjaxResponseDto implements Serializable
{

	private static final long serialVersionUID = -1445172589045235660L;
	private String operationMessage;
	private int operationStatusCode;
	private long totalObjectsNumber;
	private long returnedObjectNumber;
	private List<Object> payload;
	public String getOperationMessage()
	{
		return operationMessage;
	}
	public void setOperationMessage(String operationMessage)
	{
		this.operationMessage = operationMessage;
	}
	public int getOperationStatusCode()
	{
		return operationStatusCode;
	}
	public void setOperationStatusCode(int operationStatusCode)
	{
		this.operationStatusCode = operationStatusCode;
	}
	public long getTotalObjectsNumber()
	{
		return totalObjectsNumber;
	}
	public void setTotalObjectsNumber(long totalObjectsNumber)
	{
		this.totalObjectsNumber = totalObjectsNumber;
	}
	public long getReturnedObjectNumber()
	{
		return returnedObjectNumber;
	}
	public void setReturnedObjectNumber(long returnedObjectNumber)
	{
		this.returnedObjectNumber = returnedObjectNumber;
	}
	public List<Object> getPayload()
	{
		return payload;
	}
	public void setPayload(List<Object> payload)
	{
		this.payload = payload;
	}
	
}
