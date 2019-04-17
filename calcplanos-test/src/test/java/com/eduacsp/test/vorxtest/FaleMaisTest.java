package com.eduacsp.test.vorxtest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.eduacsp.test.calcplanos.config.Application;
import com.eduacsp.test.calcplanos.service.FaleMaisService;
import com.eduacsp.test.calcplanos.vo.ParamVo;
import com.eduacsp.test.calcplanos.vo.RetornoValoresVo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class FaleMaisTest {

	private static final Logger logger = LoggerFactory.getLogger(FaleMaisTest.class);

	@Autowired
	private FaleMaisService faleMaisService;

	@Test
	public void testarComRetornoOK() {
		logger.info("testarComRetornoOK");
		
		ParamVo paramVo = new ParamVo();
		paramVo.setOrigem("011");
		paramVo.setDestino("016");
		paramVo.setTempo(20);
		paramVo.setPlano("30");

		RetornoValoresVo retorno = faleMaisService.calcularPlanos(paramVo);

		assertThat(retorno.getListErros()).isNull();
	}
	
	@Test
	public void testarSemFaleMaisNuloOK() {
		logger.info("testarSemFaleMaisNuloOK");
		
		ParamVo paramVo = new ParamVo();
		paramVo.setOrigem("018");
		paramVo.setDestino("017");
		paramVo.setTempo(100);
		paramVo.setPlano("30");

		RetornoValoresVo retorno = faleMaisService.calcularPlanos(paramVo);

		assertThat(retorno.getSemFaleMais()).isNull();
	}
	
	@Test
	public void testarComFaleMaisNuloOK() {
		logger.info("testarComFaleMaisNuloOK");
		
		ParamVo paramVo = new ParamVo();
		paramVo.setOrigem("011");
		paramVo.setDestino("016");
		paramVo.setTempo(20);
		paramVo.setPlano("30");

		RetornoValoresVo retorno = faleMaisService.calcularPlanos(paramVo);

		assertThat(retorno.getComFaleMais()).isNull();
	}


	@Test
	public void testarFaltaOrigemErro() {
		logger.info("testarFaltaOrigemErro");
		
		ParamVo paramVo = new ParamVo();
		paramVo.setDestino("016");
		paramVo.setTempo(20);
		paramVo.setPlano("30");

		RetornoValoresVo retorno = faleMaisService.calcularPlanos(paramVo);
		
		assertThat(retorno.getListErros()).isNotNull();
	}
	
	@Test
	public void testarFaltaDestinoErro() {
		logger.info("testarFaltaDestinoErro");
		
		ParamVo paramVo = new ParamVo();
		paramVo.setOrigem("011");
		paramVo.setTempo(20);
		paramVo.setPlano("30");

		RetornoValoresVo retorno = faleMaisService.calcularPlanos(paramVo);
		
		assertThat(retorno.getListErros()).isNotNull();
	}
	
	@Test
	public void testarFaltaTempoErro() {
		logger.info("testarFaltaTempoErro");
		
		ParamVo paramVo = new ParamVo();
		paramVo.setOrigem("011");
		paramVo.setDestino("016");
		paramVo.setPlano("30");

		RetornoValoresVo retorno = faleMaisService.calcularPlanos(paramVo);
		
		assertThat(retorno.getListErros()).isNotNull();
	}
	
	@Test
	public void testarFaltaPlanoErro() {
		logger.info("testarFaltaPlanoErro");
		
		ParamVo paramVo = new ParamVo();
		paramVo.setOrigem("011");
		paramVo.setDestino("016");
		paramVo.setTempo(20);

		RetornoValoresVo retorno = faleMaisService.calcularPlanos(paramVo);
		
		assertThat(retorno.getListErros()).isNotNull();
	}

}
