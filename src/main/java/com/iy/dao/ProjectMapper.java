package com.iy.dao;

import java.sql.SQLException;
import java.util.List;

import com.iy.dto.Project;

public interface ProjectMapper {
	public List<Project> selectByAllList() throws SQLException;
}