package com.jevoncode.cms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jevoncode.cms.dao.TestDao;
import com.jevoncode.cms.domain.Test;

@Repository
public class TestDaoImpl implements TestDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void add(Test test) {
		this.jdbcTemplate.update("insert into test(content, created_date,last_updated_date) values (?,now(),now())", test.getContent());
	}

	public void delete(Test test) {
		this.jdbcTemplate.update("delete from test where id = ?", test.getId());
	}

	public void modify(Test test) {
		this.jdbcTemplate.update("update test set content = ?,last_updated_date=now() where id = ?", test.getContent(), test.getId());
	}

	public Test getTestById(Long id) {
		Test result = this.jdbcTemplate.queryForObject("select id,content,created_date,last_updated_date from test where id = ?", new Object[] { id }, new RowMapper<Test>() {
			public Test mapRow(ResultSet rs, int rowNum) throws SQLException {
				Test test = new Test();
				test.setId(rs.getLong("id"));
				test.setContent(rs.getString("content"));
				test.setCreatedDate(new Date(rs.getTimestamp("created_date").getTime()));
				test.setLastUpdatedDate(new Date(rs.getTimestamp("last_updated_date").getTime()));
				return test;
			}
		});
		return result;
	}

}
