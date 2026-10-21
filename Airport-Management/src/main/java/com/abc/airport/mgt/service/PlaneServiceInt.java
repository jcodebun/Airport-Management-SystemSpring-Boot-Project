package com.abc.airport.mgt.service;

import java.util.List;

import com.abc.airport.mgt.dto.PlaneDTO;
import com.abc.airport.mgt.dto.UserDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;

public interface PlaneServiceInt {

	public long add(PlaneDTO dto) throws DuplicateRecordException;

	public void delete(PlaneDTO dto);

	public PlaneDTO findBypk(long pk);

	public PlaneDTO findByLogin(String login);

	public void update(PlaneDTO dto) throws DuplicateRecordException;

	public List<PlaneDTO> list();

	public List<PlaneDTO> list(int pageNo, int pageSize);

	public List<PlaneDTO> search(PlaneDTO dto);

	public List<PlaneDTO> search(PlaneDTO dto, int pageNo, int pageSize);

	PlaneDTO findByModelNumber(String modelNumber);
}
