package com.abc.airport.mgt.form;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import com.abc.airport.mgt.dto.BaseDTO;
import com.abc.airport.mgt.dto.HelpDTO;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class HelpForm extends BaseForm{

	@NotEmpty(message = "Issue is required")
	private String issue;
	@NotEmpty(message = "Description is required")
	private String description;
	//@NotEmpty(message = "Solution is required")
	private String ansQuery;
	
	private String userId;
	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		HelpDTO bean = new HelpDTO();
		bean.setId(id);
		bean.setIssue(issue);
		bean.setDescription(description);
		bean.setUserId(userId);
		bean.setAnsQuery(ansQuery);
		bean.setCreatedBy(createdBy);
		bean.setModifiedBy(modifiedBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		HelpDTO bean = (HelpDTO)bDto;
		id=bean.getId();
		issue = bean.getIssue();
		description = bean.getDescription();
		userId = bean.getUserId();
		ansQuery = bean.getAnsQuery();
		createdBy=bean.getCreatedBy();
		modifiedBy=bean.getModifiedBy();
		createdDateTime=bean.getCreatedDatetime();
		modifiedDateTime=bean.getModifiedDatetime();
	}

}
