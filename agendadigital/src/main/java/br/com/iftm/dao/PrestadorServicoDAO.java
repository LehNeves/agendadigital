package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.controller.dto.FiltroPrestadoDTO;
import br.com.iftm.entity.PrestadorServico;

public interface PrestadorServicoDAO {

	PrestadorServico create(PrestadorServico prestadorServico);

	List<PrestadorServico> read();

	PrestadorServico update(PrestadorServico prestadorServico);

	void delete(Integer id);

	List<PrestadorServico> readByFiltros(FiltroPrestadoDTO filtroPrestadoDTO);
}