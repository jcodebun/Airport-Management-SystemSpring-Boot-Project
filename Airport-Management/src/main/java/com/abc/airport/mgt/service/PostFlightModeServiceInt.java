package com.abc.airport.mgt.service;

import java.util.List;

import com.abc.airport.mgt.dto.PostFlightModeDTO;
import com.abc.airport.mgt.exception.DuplicateRecordException;

public interface PostFlightModeServiceInt {

public long add(PostFlightModeDTO dto) throws DuplicateRecordException;
	
	public void delete(PostFlightModeDTO dto);
	
	public PostFlightModeDTO findBypk(long pk);
	
	public PostFlightModeDTO findByName(String name);
	
	public void update(PostFlightModeDTO dto);
	
	public List<PostFlightModeDTO> list();
	
	public List<PostFlightModeDTO>list(int pageNo,int pageSize);
	
	public List<PostFlightModeDTO> search(PostFlightModeDTO dto);
	
	public List<PostFlightModeDTO> search(PostFlightModeDTO dto,int pageNo,int pageSize);
	
	public void deleteById(long id);
}
