package com.he20o.mapper;

import java.util.List;

import com.he20o.domain.GuestVO;

public interface GuestMapper {
	public List<GuestVO> getList();
	public GuestVO read(long bno);
	public void del(long bno);
	public void write(GuestVO gvo);

}
