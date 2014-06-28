package com.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

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
	public boolean update(VO vo){
		BoardVO bVO = (BoardVO)vo; 
		
		if(isPassCorrect(bVO)){
			// 1. 내용 수정
			String sql = "UPDATE board SET b_content ='" + bVO.getContent() +"' "
					+ "WHERE b_id = "+bVO.getId();
			jdbcTemplate.execute(sql);
			
			// 2. 수정한 시간 삽입
			String sql2 = "INSERT INTO board_updated(b_id, u_updated_time) "
					+"VALUES( '"+ bVO.getId()+"', now() )";
			jdbcTemplate.execute(sql2);
			return true;
		}
		return false;
	}

	public boolean isPassCorrect(BoardVO bVO){
		String sql = "SELECT * FROM board WHERE b_id="+bVO.getId()+" AND b_pass ='"+bVO.getPass()+"'";
		SqlRowSet rowSet =  jdbcTemplate.queryForRowSet(sql);
		return rowSet.next();
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
//				bVO.setPass(rs.getString("b_pass"));
				return bVO;
			}
		};
		return jdbcTemplate.query(sql, mapper);
	}





}
