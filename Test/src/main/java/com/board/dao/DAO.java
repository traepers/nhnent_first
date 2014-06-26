package com.board.dao;

import java.util.List;

import com.board.VO;

public interface DAO {
	// insert 수행
	public void add(VO vo);
	// update 수행
	public void update(int id, String content);
	// 전체 데이터 조회
	public List<VO> searchAll();
}
