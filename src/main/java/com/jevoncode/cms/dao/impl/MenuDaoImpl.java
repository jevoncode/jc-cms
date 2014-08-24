package com.jevoncode.cms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jevoncode.cms.dao.MenuDao;
import com.jevoncode.cms.domain.Menu;

@Repository
public class MenuDaoImpl implements MenuDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Menu> getThemAll() {
		String sql = "select * from jc_mu";
		List<Menu> menus = jdbcTemplate.query(sql, new RowMapper<Menu>() {
			public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
				Menu menu = new Menu();
				menu.setId(rs.getLong("id"));
				menu.setName(rs.getString("name"));
				menu.setUrl(rs.getString("url"));
				menu.setParentId(rs.getLong("parent_id"));
				menu.setCreatedDate(new Date(rs.getTimestamp("created_date").getTime()));
				menu.setLastUpdatedDate(new Date(rs.getTimestamp("last_updated_date").getTime()));
				return menu;
			}
		});
		return menus;
	}

	public void insertOne(Menu menu) {
		String sql = "insert into jc_menu(name,url,parent_id, created_date,last_updated_date) values (?,?,?,now(),now())";
		jdbcTemplate.update(sql, menu.getName(), menu.getUrl(), menu.getParentId());
	}

}
