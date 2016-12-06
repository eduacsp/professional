package com.eduacsp.cv.facade;

import com.eduacsp.cv.dao.CvDao;
import com.eduacsp.cv.helper.CvVo;
import com.eduacsp.cv.modelo.EnumIdiom;

public interface Cvitae {

	CvVo getCv(CvDao cvDao,EnumIdiom idiom);
	
}
