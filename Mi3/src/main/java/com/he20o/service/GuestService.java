package com.he20o.service;

import java.util.List;

import com.he20o.domain.GuestVO;

public interface GuestService {
	public List<GuestVO> getList();
	public GuestVO read(long bno);
	public void del(long bno);

}
