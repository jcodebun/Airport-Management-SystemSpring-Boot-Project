package com.abc.airport.mgt.service;

import java.util.List;

import com.abc.airport.mgt.dto.AddHangerDTO;

import com.abc.airport.mgt.exception.DuplicateRecordException;

public interface AddHangerServiceInt {

	public long add(AddHangerDTO dto) throws DuplicateRecordException;

	public void delete(AddHangerDTO dto);

	public AddHangerDTO findBypk(long pk);

	public AddHangerDTO findByLogin(String login);

	public void update(AddHangerDTO dto) throws DuplicateRecordException;

	public List<AddHangerDTO> list();

	public List<AddHangerDTO> list(int pageNo, int pageSize);

	public List<AddHangerDTO> search(AddHangerDTO dto);

	public List<AddHangerDTO> search(AddHangerDTO dto, int pageNo, int pageSize);

	AddHangerDTO findByModelNumber(String modelNumber);
}
