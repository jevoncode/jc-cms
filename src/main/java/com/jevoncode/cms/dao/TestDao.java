package com.jevoncode.cms.dao;

import com.jevoncode.cms.domain.Test;

public interface TestDao {
	public void add(Test test);
	public void delete(Test test);
	public void modify(Test test);
	public Test getTestById(Long id);
}
