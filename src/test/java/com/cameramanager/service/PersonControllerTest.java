package com.cameramanager.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.cameramanager.webapp.controller.BaseControllerTestCase;
import com.cameramanager.webapp.controller.PersonController;

public class PersonControllerTest extends BaseControllerTestCase {
    @Autowired
    private PersonController controller;
 
    @Test
    public void testHandleRequest() throws Exception {
        ModelAndView mav = controller.handleRequest();
        ModelMap m = mav.getModelMap();
        assertNotNull(m.get("personList"));
        assertTrue(((List) m.get("personList")).size() > 0);
    }
}