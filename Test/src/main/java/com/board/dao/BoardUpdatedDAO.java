package com.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.board.BoardVO;
import com.board.VO;

public class BoardUpdatedDAO extends DAOimpl {

	@Override
	public void add(VO vo) {
		BoardVO bVO = (BoardVO)vo;
		String sql = "insert into board(b_email,b_content,b_time,b_pass) values("+
				"'"+ 	bVO.getEmail() + "',"+
				"'"+	bVO.getContent() + "',"+
				"'"+	bVO.getTime() + "',"+
				"'"+	bVO.getPass() + "'"+
			")";
		jdbcTemplate.execute(sql);
	}

	@Override
	public VO getEmp(String name) {
		String sql = "select * from board where name = ?";
		// RowMapper는 ResultSet의 레코드와 객체를 매핑시키는 역할을 한다.
		RowMapper mapper = new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
				BoardVO bVO = new BoardVO();
				bVO.setEmail(rs.getString("b_email"));
				bVO.setContent(rs.getString("b_content"));
				bVO.setTime(rs.getString("b_time"));
				bVO.setPass(rs.getString("b_pass"));
				return bVO;
			}
		};
		// 입력 받은 name을 queryForObject 실행 인자로 사용하기 위해 Object[]로 변경.
		Object[] args = {name};
		return jdbcTemplate.queryForObject(sql, args, mapper);
	}

	@Override
	public List<VO> searchAll() {
		String sql = "select * from board";
		// RowMapper는 ResultSet의 레코드와 객체를 매핑시키는 역할을 한다.
		RowMapper mapper = new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
				BoardVO bVO = new BoardVO();
				bVO.setEmail(rs.getString("b_email"));
				bVO.setContent(rs.getString("b_content"));
				bVO.setTime(rs.getString("b_time"));
				bVO.setPass(rs.getString("b_pass"));
				return bVO;
			}
		};
		return jdbcTemplate.query(sql, mapper);
	}

	@Override
	public void update(int id, String content) {
		// TODO Auto-generated method stub
		
	}

}
