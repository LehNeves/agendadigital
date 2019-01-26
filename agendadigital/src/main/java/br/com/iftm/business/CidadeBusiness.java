package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entity.Cidade;
import br.com.iftm.enums.Estado;

public interface CidadeBusiness {

	Cidade create(Cidade cidade) throws BusinessException;

	List<Cidade> read() throws BusinessException;

	List<Cidade> readByEstado(Estado estado) throws BusinessException;

	Cidade update(Cidade cidade) throws BusinessException;

	void delete(Integer id) throws BusinessException;
}