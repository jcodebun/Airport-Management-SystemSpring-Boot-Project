package com.abc.airport.mgt.service;

import java.util.List;

import com.abc.airport.mgt.dto.AddHangerDTO;
import com.abc.airport.mgt.dto.WaypointsDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;

public interface WaypointsServiceInt {


	public long add(WaypointsDTO dto) throws DuplicateRecordException;

	public void delete(WaypointsDTO dto);

	public WaypointsDTO findBypk(long pk);

	public WaypointsDTO findByLogin(String login);

	public void update(WaypointsDTO dto) throws DuplicateRecordException;

	public List<WaypointsDTO> list();

	public List<WaypointsDTO> list(int pageNo, int pageSize);

	public List<WaypointsDTO> search(WaypointsDTO dto);

	public List<WaypointsDTO> search(WaypointsDTO dto, int pageNo, int pageSize);

	WaypointsDTO findByModelNumber(String modelNumber);
}
