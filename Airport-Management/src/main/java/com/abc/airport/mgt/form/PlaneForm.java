package com.abc.airport.mgt.form;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.abc.airport.mgt.dto.BaseDTO;
import com.abc.airport.mgt.dto.PlaneDTO;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class PlaneForm extends BaseForm {
	
	@NotEmpty(message = "Model Number is required")
	private String modelNumber;
	@NotEmpty(message = "Purchase Date is required")
	private String purchaseDate;
	@NotEmpty(message = "Last Service date is required")
	private String lastServiceDate;
	@Min(value = 1, message = "Price is required")
	private long price;
	
	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		PlaneDTO bean = new PlaneDTO();
		bean.setId(id);
		bean.setPrice(price);
		bean.setModelNumber(modelNumber);
		bean.setPurchaseDate(purchaseDate);
		bean.setLastServiceDate(lastServiceDate);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		PlaneDTO bean = (PlaneDTO)bDto;
		id = bean.getId();
		price = bean.getPrice();
		System.out.println("model "+modelNumber);
		modelNumber = bean.getModelNumber();		
		purchaseDate = bean.getPurchaseDate();
		lastServiceDate = bean.getLastServiceDate();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
