package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ProjectDTO;
import com.rays.dto.UserDTO;

public class ProjectForm extends BaseForm{
	
	@NotEmpty(message = "Name is required")
	private String name;
	
	@NotEmpty(message = "Category is required")
	private String category;
	
	@NotNull(message = "Date is required")
	private Date openDate;
	
	@NotEmpty(message = "Version is required")
	private String version;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	

	@Override
	public BaseDTO getDto() {
		
		ProjectDTO dto = initDTO(new ProjectDTO());
		
		dto.setName(name);
		dto.setCategory(category);
		dto.setVersion(version);
		dto.setOpenDate(openDate);

		return dto;
	}
}
