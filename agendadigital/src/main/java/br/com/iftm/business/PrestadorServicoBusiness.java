package br.com.iftm.business;

import java.util.List;

import br.com.iftm.controller.dto.FiltroPrestadoDTO;
import br.com.iftm.entity.PrestadorServico;

public interface PrestadorServicoBusiness {

	PrestadorServico create(PrestadorServico prestadorServico) throws BusinessException;

	List<PrestadorServico> read() throws BusinessException;

	PrestadorServico update(PrestadorServico prestadorServico) throws BusinessException;

	void delete(Integer id) throws BusinessException;

	List<PrestadorServico> readByFiltros(FiltroPrestadoDTO filtroPrestadoDTO) throws BusinessException;
}