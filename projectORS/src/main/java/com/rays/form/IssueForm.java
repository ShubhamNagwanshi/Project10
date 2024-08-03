package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.IssueDTO;

public class IssueForm extends BaseForm{
	
	@NotNull(message = "Date is required")
	private Date openDate;
	
	@NotEmpty(message = "Title is required")
	private String title;
	
	@NotEmpty(message = "Description is required")
	private String description;
	
	@NotEmpty(message = "AssignTo is required")
	private String assignTo;
	
	@NotEmpty(message = "Status is required")
	private String status;
	
	
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public BaseDTO getDto() {
		
		IssueDTO dto = initDTO(new IssueDTO());
		
		dto.setOpenDate(openDate);
		dto.setTitle(title);
		dto.setDescription(description);
		dto.setAssignTo(assignTo);
		dto.setStatus(status);
		
		return dto;
	}

}
