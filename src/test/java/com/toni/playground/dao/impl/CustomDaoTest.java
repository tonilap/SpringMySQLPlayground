package com.toni.playground.dao.impl;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.toni.playground.dao.CustomDao;
import com.toni.playground.dto.CustomDTO;
import com.toni.playground.utils.SqlLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml" })
public class CustomDaoTest {
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Resource
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
	
	@Resource
	CustomDao customDao;
	
	@Before
	public void setUp(){
		initDatabase();
	}
	
	@Test
	public void testSaveNewCustom() throws Exception {
		final String name = "custom_test";
		CustomDTO custom = new CustomDTO();
		custom.setName(name);
		CustomDTO newCustom = customDao.save(custom);
		assertEquals(name, newCustom.getName());
	}
	
	private void initDatabase() {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        jdbcTemplate.update(SqlLoader.load("drop_custom.sql"), params);
        jdbcTemplate.update(SqlLoader.load("create_custom.sql"), params);
	}
}
