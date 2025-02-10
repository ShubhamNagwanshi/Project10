package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.OrderDTO;

public class OrderForm extends BaseForm {

	@Size(max = 20, message = "enter 20 charactor only")

	@NotEmpty(message = "Please enter productName")
     private String productName;

	@NotNull(message = "Please enter quantity")

	private Long quantity;

	@NotNull(message = "Please enter orderDate")
	private Date orderDate;

	private String customer;

	@NotNull(message = "Please enter customer")
	private Long customerId;

	
	
	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public Long getQuantity() {
		return quantity;
	}



	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}



	public Date getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public String getCustomer() {
		return customer;
	}



	public void setCustomer(String customer) {
		this.customer = customer;
	}



	public Long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}



	@Override
	public BaseDTO getDto() {
		OrderDTO dto = initDTO(new OrderDTO());

		dto.setProductName(productName);
		dto.setQuantity(quantity);
		dto.setOrderDate(orderDate);
		dto.setCustomer(customer);
		dto.setCustomerId(customerId);
		
		return dto;
	}
}