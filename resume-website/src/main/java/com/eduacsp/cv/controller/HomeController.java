package com.eduacsp.cv.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eduacsp.cv.dao.CvDao;
import com.eduacsp.cv.facade.CvFacade;
import com.eduacsp.cv.facade.Cvitae;
import com.eduacsp.cv.helper.CvParam;
import com.eduacsp.cv.helper.CvVo;

@Controller
public class HomeController{

	@Autowired
    private CvDao cvDao;
	
	private Cvitae cvFacade = CvFacade.getInstance();
	
	@RequestMapping("/")
	public ModelAndView index(@ModelAttribute(value="CvParam") CvParam cvParam){
			
		ModelAndView modelAndView = new ModelAndView("home");
			
		CvVo cvVo = cvFacade.getCv(cvDao,cvParam.getIdiom());
		
		modelAndView.addObject("cv",cvVo);
		
		modelAndView.addObject("expireDate",cvVo.getExpireDate());

		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "includeTop")
	public String includeTop(Model model) {
	    return "util/include-top";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "includeBottom")
	public String includeBottom(Model model) {
	    return "util/include-bottom";
	}
	
	

	
}