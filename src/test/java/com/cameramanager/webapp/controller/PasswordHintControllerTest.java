package com.cameramanager.webapp.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.subethamail.wiser.Wiser;

import com.cameramanager.webapp.controller.BaseFormController;
import com.cameramanager.webapp.controller.PasswordHintController;

public class PasswordHintControllerTest extends BaseControllerTestCase {
    @Autowired
    private PasswordHintController c = null;

    @Test
    public void testExecute() throws Exception {
        MockHttpServletRequest request = newGet("/passwordHint.html");
        request.addParameter("username", "user");

       // start SMTP Server
        Wiser wiser = new Wiser();
        wiser.setPort(getSmtpPort());
        wiser.start();
        
        c.handleRequest(request);
        
        // verify an account information e-mail was sent
        wiser.stop();
        assertTrue(wiser.getMessages().size() == 1);
        
        // verify that success messages are in the session
        assertNotNull(request.getSession().getAttribute(BaseFormController.MESSAGES_KEY));
    }
}
