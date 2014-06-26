package com.board.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class DAOimpl implements DAO{
	private DataSource dataSource;
	protected JdbcTemplate jdbcTemplate;

	public DataSource getDataSource(){
		return dataSource;
	}                  
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
