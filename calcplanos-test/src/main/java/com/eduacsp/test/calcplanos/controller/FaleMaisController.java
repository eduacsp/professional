package com.eduacsp.test.calcplanos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.eduacsp.test.calcplanos.model.Plano;
import com.eduacsp.test.calcplanos.repo.PlanoRepository;
import com.eduacsp.test.calcplanos.service.FaleMaisService;
import com.eduacsp.test.calcplanos.vo.ParamVo;
import com.eduacsp.test.calcplanos.vo.RetornoValoresVo;

@Controller
public class FaleMaisController {

	private static final Logger logger = LoggerFactory.getLogger(FaleMaisController.class);
	
	@Autowired
	private FaleMaisService faleMaisService;
	
	@Autowired
	private PlanoRepository planoRepository;


	@GetMapping("/")
	public String index(Model model) {

		List<Plano> listPlano = planoRepository.findAll(Sort.by("codigo").ascending());
		
		model.addAttribute("listPlano", listPlano);
		model.addAttribute("paramVo", new ParamVo());
		model.addAttribute("retornoValores", new RetornoValoresVo());
		
		return "index";
	}

	@PostMapping("/calcularPlanos")
	public String calcularPlanos(Model model,@ModelAttribute ParamVo paramVo) {
		
		//paramVo.setOrigem("011");
		//paramVo.setDestino("016");
		//paramVo.setTempo(60);
		//paramVo.setPlano("30");

		RetornoValoresVo retornoValoresVo = faleMaisService.calcularPlanos(paramVo);
		List<Plano> listPlano = planoRepository.findAll(Sort.by("codigo").ascending());
		
		model.addAttribute("listPlano", listPlano);
		model.addAttribute("retornoValores", retornoValoresVo);
		
		logger.info("retornoValoresVo.getListErros():"+retornoValoresVo.getListErros());
		
		if(retornoValoresVo.getListErros()!=null) {
			return "index";
		}else {
			return "resultado";
		}
	}

}
