package com.eduacsp.cv.facade;

import org.springframework.web.servlet.ModelAndView;

import com.eduacsp.cv.dao.CvDao;

public interface Cvitae {

	ModelAndView getCv(CvDao cvDao,String idiom);

}
