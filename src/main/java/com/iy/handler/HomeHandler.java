package com.iy.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.iy.controller.CommandHandler;
import com.iy.dao.ProjectMapper;
import com.iy.dto.Project;
import com.iy.util.MySqlSessionFactory;

public class HomeHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		SqlSession session = null;
		try {
			session = MySqlSessionFactory.openSession();
			ProjectMapper dao = session.getMapper(ProjectMapper.class);
			
			List<Project> list = dao.selectByAllList();
			req.setAttribute("viewData", list);
			
			return "/WEB-INF/view/home.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
}