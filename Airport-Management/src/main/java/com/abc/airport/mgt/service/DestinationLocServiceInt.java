package com.abc.airport.mgt.service;

import java.util.List;


import com.abc.airport.mgt.dto.DestinationLocDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;

public interface DestinationLocServiceInt {
	public long add(DestinationLocDTO dto) throws DuplicateRecordException;

	public void delete(DestinationLocDTO dto);

	public DestinationLocDTO findBypk(long pk);

	public DestinationLocDTO findByLogin(String login);

	public void update(DestinationLocDTO dto) throws DuplicateRecordException;

	public List<DestinationLocDTO> list();

	public List<DestinationLocDTO> list(int pageNo, int pageSize);

	public List<DestinationLocDTO> search(DestinationLocDTO dto);

	public List<DestinationLocDTO> search(DestinationLocDTO dto, int pageNo, int pageSize);

	DestinationLocDTO findByModelNumber(String modelNumber);

}
