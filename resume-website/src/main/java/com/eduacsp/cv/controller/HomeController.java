package com.eduacsp.cv.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eduacsp.cv.dao.CvDao;
import com.eduacsp.cv.facade.CvFacade;
import com.eduacsp.cv.facade.Cvitae;
import com.eduacsp.cv.helper.CvParam;

@Controller
public class HomeController{

	@Autowired
    private CvDao cvDao;
	
	private Cvitae cvFacade = CvFacade.getInstance();
	
	@RequestMapping("/")
	public ModelAndView index(@ModelAttribute(value="CvParam") CvParam cvParam,HttpServletRequest request){
		
		cvFacade.insertGuestLog(cvDao, request,cvParam.getIdiom());
		
		return cvFacade.getCv(cvDao,cvParam.getIdiom());
	}
	
	@RequestMapping(value="/idiom/{idiom}", method=RequestMethod.GET)
	public ModelAndView getIdiom(@PathVariable("idiom") String idiom,HttpServletRequest request){

		cvFacade.insertGuestLog(cvDao, request,idiom);
		
		return cvFacade.getCv(cvDao,idiom);
	}
	
	
/*	@RequestMapping(method = RequestMethod.GET, value = "includeTop")
	public String includeTop(Model model) {
	    return "util/include-top";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "includeBottom")
	public String includeBottom(Model model) {
	    return "util/include-bottom";
	}*/
	
	

	
}