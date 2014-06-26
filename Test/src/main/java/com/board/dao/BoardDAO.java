package com.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.board.BoardVO;
import com.board.VO;

public class BoardDAO extends DAOimpl {

	@Override
	public void add(VO vo) {
		BoardVO bVO = (BoardVO)vo; 
		//,,
		String sql = "INSERT INTO board(b_email, b_content, b_time, b_pass) "
				+ "VALUES("+ 
				"'"+	bVO.getEmail()	+"',"+
				"'"+	bVO.getContent() + "', "+
				"now() ,"+
				"'"+	bVO.getPass() + "'"+
			")";
		jdbcTemplate.execute(sql);
	}

	@Override
	public void update(int id, String content) {
		String sql = "UPDATE board SET b_content =" + content
				+ "WHERE b_id = "+id;
		jdbcTemplate.execute(sql);
	}
	

	@Override
	public List<VO> searchAll() {
		String sql = "select * from board";
		// RowMapper는 ResultSet의 레코드와 객체를 매핑시키는 역할을 한다.
		RowMapper mapper = new RowMapper(){
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException{
				BoardVO bVO = new BoardVO();
				bVO.setId(rs.getInt("b_id"));
				bVO.setEmail(rs.getString("b_email"));
				bVO.setContent(rs.getString("b_content"));
				bVO.setTime(rs.getString("b_time"));
				bVO.setPass(rs.getString("b_pass"));
				return bVO;
			}
		};
		return jdbcTemplate.query(sql, mapper);
	}





}
