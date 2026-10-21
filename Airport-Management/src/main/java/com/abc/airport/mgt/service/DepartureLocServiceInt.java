package com.abc.airport.mgt.service;

import java.util.List;

import com.abc.airport.mgt.dto.DepartureLocDTO;

import com.abc.airport.mgt.exception.DuplicateRecordException;

public interface DepartureLocServiceInt {

	public long add(DepartureLocDTO dto) throws DuplicateRecordException;

	public void delete(DepartureLocDTO dto);

	public DepartureLocDTO findBypk(long pk);

	public DepartureLocDTO findByLogin(String login);

	public void update(DepartureLocDTO dto) throws DuplicateRecordException;

	public List<DepartureLocDTO> list();

	public List<DepartureLocDTO> list(int pageNo, int pageSize);

	public List<DepartureLocDTO> search(DepartureLocDTO dto);

	public List<DepartureLocDTO> search(DepartureLocDTO dto, int pageNo, int pageSize);

	DepartureLocDTO findByModelNumber(String modelNumber);
}
