package com.eduacsp.cv.facade;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.eduacsp.cv.dao.CvDao;

public interface Cvitae {

	ModelAndView getCv(CvDao cvDao,String idiom);
	
	void insertGuestLog(CvDao cvDao,HttpServletRequest request, String idiom);

}
