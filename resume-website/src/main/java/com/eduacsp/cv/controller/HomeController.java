package com.eduacsp.cv.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eduacsp.cv.helper.CvParam;
import com.eduacsp.cv.helper.CvReturn;
import com.eduacsp.cv.modelo.Cv;
import com.eduacsp.cv.modelo.EnumIdiom;
import com.eduacsp.cv.modelo.Guest;
import com.eduacsp.cv.modelo.Person;
import com.eduacsp.cv.service.CvService;

@Controller
public class HomeController {


	/*	@Autowired
	private CvRepository cvRepository;*/

	//@Autowired
	//private CvRepository cvDao;

	@Autowired
	@Qualifier("cvService")
	private CvService cvService;


	//private CvService cvFacade = CvServiceImpl.getInstance();

	@RequestMapping("/")
	public String index(Model model,@ModelAttribute(value="CvParam") CvParam cvParam,HttpServletRequest request){
		CvReturn cvReturn = cvService.getCv(cvParam.getIdiom(),request);
		
		model.addAttribute("cv",cvReturn.getCvVo());
		model.addAttribute("expireDate",cvReturn.getCvVo().getExpireDate());
		model.addAttribute("locale",cvReturn.getEnumIdiom().getValue());

		return "index";
	}

	@RequestMapping(value="/idiom/{idiom}", method=RequestMethod.GET)
	public String getIdiom(Model model,@PathVariable("idiom") String idiom,HttpServletRequest request){
		CvReturn cvReturn = cvService.getCv(idiom,request);

		model.addAttribute("cv",cvReturn.getCvVo());
		model.addAttribute("expireDate",cvReturn.getCvVo().getExpireDate());
		model.addAttribute("locale",cvReturn.getEnumIdiom().getValue());

		return "index";
	}



/*	@SuppressWarnings("unchecked")
	private CvReturn getCvController(String idiom, HttpServletRequest request) {
		Guest guest = null;
		CvReturn cvReturn = null;
		List<Cv> listaCv = null;
		List<Person> listaPerson = null;
		//EnumIdiom enumIdiom = cvFacade.getIdiom(LocaleContextHolder.getLocale(),idiom);
		
	//	CvService cvFacade = new CvServiceImpl();
		
		//CvDao cvDao = new CvDao();

		//guest = cvFacade.insertGuestLog(request,idiom);
		//cvDao.insertGuestLog(guest);

		//listaCv = cvDao.listarCv(enumIdiom);
		//listaPerson = cvDao.listarPerson();
		
		//System.out.println("cvDao:"+cvDao);

		//cvReturn = cvFacade.getCv(listaCv,listaPerson,idiom);

		return cvReturn;
	}*/



	/*	@RequestMapping("convidado")
	public String convidado(Model model){
		System.out.println("convidado");
		return "index2";
	}*/


}
