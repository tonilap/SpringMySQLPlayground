package com.toni.playground.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.toni.playground.dao.CustomDao;
import com.toni.playground.dao.exception.AlreadyExistsDAOException;
import com.toni.playground.dao.exception.CreateDAOException;
import com.toni.playground.dto.CustomDTO;

public class CustomDaoImpl implements CustomDao {

	protected JdbcTemplate jdbcTemplate;

	@Resource
	public void setDatasource(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public CustomDTO save(CustomDTO custom) throws AlreadyExistsDAOException, CreateDAOException {
		final String query = "insert into custom (name) values (?)";
		final KeyHolder keyHolder = new GeneratedKeyHolder();
		final String name = custom.getName();

		try{
			jdbcTemplate.update(
				new PreparedStatementCreator() {
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement pst = con.prepareStatement(query, new String[] {"id"});
						pst.setString(1, name);
						return pst;
					}
				},
				keyHolder);
		} catch(DataAccessException e){
			if(e instanceof DuplicateKeyException) {
				throw new AlreadyExistsDAOException(e.getMostSpecificCause().getMessage());
			}
			throw new CreateDAOException(e.getMostSpecificCause().getMessage());
		}
				
		custom.setId((Long)keyHolder.getKey());
		return custom;
	}

	@Override
	public void update(CustomDTO instance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CustomDTO instance) {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomDTO findById(Serializable id) {
		return null;
	}

	@Override
	public List<CustomDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
