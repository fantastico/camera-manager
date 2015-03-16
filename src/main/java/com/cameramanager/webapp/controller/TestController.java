package com.cameramanager.webapp.controller;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cameramanager.service.BindManager;


@Controller
@RequestMapping("/test2")
public class TestController {
	
	@Autowired
	@Qualifier("bindManager")
	private BindManager bindManager;

	
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String test(HttpServletRequest request, HttpServletResponse res) throws Exception {
    	ServletContext sc = request.getServletContext();
    	String result = "xxxxxxxxxx";
    	// result = sc.getServletNames().nextElement();
    	Servlet servlet = sc.getServlet("");
    	// sc.getServlet("");
        return result;
    }
}
