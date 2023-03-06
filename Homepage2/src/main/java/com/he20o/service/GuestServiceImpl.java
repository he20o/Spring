package com.he20o.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.he20o.domain.GuestVO;
import com.he20o.mapper.GuestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
//@AllArgsConstructor
public class GuestServiceImpl implements GuestService{
	
	@Setter(onMethod_=@Autowired)
	private GuestMapper mapper;
	
	@Override
	public List<GuestVO> getList(){
		log.info("비즈니스 계층========");
		return mapper.getList();
	}

}
