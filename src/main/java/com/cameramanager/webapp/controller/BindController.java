package com.cameramanager.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cameramanager.model.Camera;
import com.cameramanager.service.CameraManager;


@Controller
@RequestMapping("/camera")
public class BindController {
	
	@Autowired
	@Qualifier("cameraManager")
	private CameraManager cameraManager;

	
    @RequestMapping(value = "/showCamera", method = RequestMethod.GET)
    public ModelAndView binding() throws Exception {
    	List<Camera> cameraList = cameraManager.findCamera();
        return new ModelAndView("cameraList").addObject(cameraList);
    }
    
    @RequestMapping(value = "/addCamera", method = RequestMethod.GET)
    public String addCamera(@ModelAttribute("bindCamera") Camera camera, BindingResult errors) throws Exception {
        return "addCamera";
    }
    
    @RequestMapping(value = "/bindCamera", method = RequestMethod.GET)
    public ModelAndView bindCamera(@ModelAttribute("bindCamera") Camera camera, BindingResult errors) throws Exception {
    	String apkId = camera.getApkId();
    	try{
    		cameraManager.bindCamera(apkId);
    	}catch(DataIntegrityViolationException ex){
    		errors.rejectValue("apkId", "errors.no.camera",
    				new Object[] { "apkId"}, "camera not registered");
    	}
    	List<Camera> cameraList = cameraManager.findCamera();
        return new ModelAndView("cameraList").addObject(cameraList);
    }
    
    @RequestMapping(value = "/deleteCamera", method = RequestMethod.GET)
    public ModelAndView deleteCamera(@RequestParam(value = "apkId", required = true) String apkId) throws Exception {
    	cameraManager.deleteCamera(apkId);
    	List<Camera> cameraList = cameraManager.findCamera();
        return new ModelAndView("cameraList").addObject(cameraList);
    }
    
    @RequestMapping(value = "/connectCamera", method = RequestMethod.GET)
    public ModelAndView connectCamera(@RequestParam(value = "apkId", required = true) String apkId) {
    	Camera camera = cameraManager.findCameraById(apkId);
        return new ModelAndView("play").addObject(camera);
    }
}
