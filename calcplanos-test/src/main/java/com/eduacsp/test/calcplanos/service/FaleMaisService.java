package com.eduacsp.test.calcplanos.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduacsp.test.calcplanos.model.Plano;
import com.eduacsp.test.calcplanos.model.Preco;
import com.eduacsp.test.calcplanos.repo.PlanoRepository;
import com.eduacsp.test.calcplanos.repo.PrecoRepository;
import com.eduacsp.test.calcplanos.vo.ParamVo;
import com.eduacsp.test.calcplanos.vo.RetornoValoresVo;

@Service
public class FaleMaisService {

	private static final Logger logger = LoggerFactory.getLogger(FaleMaisService.class);

	@Autowired
	private PrecoRepository precoRepository;

	@Autowired
	private PlanoRepository planoRepository;

	public RetornoValoresVo calcularPlanos(ParamVo paramVo) {
		logger.info(paramVo.toString());

		BigDecimal comFaleMais = null;
		BigDecimal semFaleMais = null;
		Plano plano = new Plano();
		Preco preco = new Preco();
		RetornoValoresVo retornoValoresVo = new RetornoValoresVo();
		List<String> listErros = validar(paramVo);

		if(listErros == null) {
			List<Preco> listPreco = precoRepository.findByOrigemAndDestino(paramVo.getOrigem(),paramVo.getDestino());

			List<Plano> listPlano = planoRepository.findByCodigo(Integer.valueOf(paramVo.getPlano()));

			if(listPlano!=null && listPlano.size()>0) {
				plano = listPlano.get(0);
			}
			if(listPreco!=null && listPreco.size()>0) {
				preco = listPreco.get(0);
			}

			//if(paramVo.getTempo()>plano.getCodigo()) {//com fale mais
			if(preco!=null && preco.getValorMin()!=null) {

				if(paramVo.getTempo()>plano.getCodigo()) {
					comFaleMais = preco.getValorMin().multiply(new BigDecimal(Math.abs(plano.getCodigo() - paramVo.getTempo()))).multiply(new BigDecimal(1.1));
					comFaleMais = comFaleMais.setScale(2, BigDecimal.ROUND_HALF_EVEN);
				}
				semFaleMais = preco.getValorMin().multiply(new BigDecimal(paramVo.getTempo()));
				semFaleMais = semFaleMais.setScale(2, BigDecimal.ROUND_HALF_EVEN);

			}

			retornoValoresVo.setOrigem(paramVo.getOrigem());
			retornoValoresVo.setDestino(paramVo.getDestino());
			retornoValoresVo.setTempo(paramVo.getTempo());
			retornoValoresVo.setPlano(plano.getNome());
			retornoValoresVo.setComFaleMais(comFaleMais);
			retornoValoresVo.setSemFaleMais(semFaleMais);
		}

		retornoValoresVo.setListErros(listErros);

		return retornoValoresVo;
	}

	private List<String> validar(ParamVo paramVo) {
		List<String> listErros = new ArrayList<String>();
		boolean retorno = false;
		
		if(paramVo.getOrigem()==null || "".equals(paramVo.getOrigem())) {
			listErros.add("Por favor inserir a origem!");
			retorno = true;
		}
		if(paramVo.getDestino()==null || "".equals(paramVo.getDestino())) {
			listErros.add("Por favor inserir a destino!");
			retorno = true;
		}
		if(paramVo.getPlano()==null || "0".equals(paramVo.getPlano())) {
			listErros.add("Por favor selecionar um plano!");
			retorno = true;
		}
		if(paramVo.getTempo()==null || paramVo.getTempo() <= 0) {
			listErros.add("Por favor inserir um tempo!");
			retorno = true;
		}
		if(!retorno) {
			listErros = null;
		}
		
		return listErros;
	}




}
