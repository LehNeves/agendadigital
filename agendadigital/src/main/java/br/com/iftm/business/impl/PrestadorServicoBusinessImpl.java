package br.com.iftm.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.iftm.business.BusinessException;
import br.com.iftm.business.PrestadorServicoBusiness;
import br.com.iftm.controller.dto.FiltroPrestadoDTO;
import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entity.PrestadorServico;
import br.com.iftm.entity.Telefone;
import br.com.iftm.entity.TipoServico;

@Service
@Transactional
public class PrestadorServicoBusinessImpl implements PrestadorServicoBusiness {

	@Autowired
	private PrestadorServicoDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrestadorServico create(PrestadorServico prestadorServico) throws BusinessException {

		if (StringUtils.isEmpty(prestadorServico.getNome())) {
			throw new BusinessException("Nome Requerido!");
		}

		if (prestadorServico.getCidade() == null || prestadorServico.getCidade().getCodigo() == null) {
			throw new BusinessException("Cidade Requerido!");
		}

		if (prestadorServico.getTipoLogradouro() == null) {
			throw new BusinessException("Tipo Logradouro Requerido!");
		}

		if (StringUtils.isEmpty(prestadorServico.getLogradouro())) {
			throw new BusinessException("Logradouro Requerido!");
		}

		if (prestadorServico.getNumero() == null) {
			throw new BusinessException("Numero Requerido!");
		}

		if (StringUtils.isEmpty(prestadorServico.getBairro())) {
			throw new BusinessException("Bairro Requerido!");
		}

		if (prestadorServico.getTelefones() == null || prestadorServico.getTelefones().isEmpty()) {
			throw new BusinessException("Pelo menos um Telefone é Requerido!");
		}

		for (Telefone telefone : prestadorServico.getTelefones()) {

			if (telefone.getDdd() == null) {
				throw new BusinessException("DDD Requerido!");
			}

			if (telefone.getNumero() == null) {
				throw new BusinessException("Numero Telefone Requerido!");
			}

			telefone.setPrestadorServico(prestadorServico);
		}

		if (prestadorServico.getTiposServicos() == null || prestadorServico.getTiposServicos().isEmpty()) {
			throw new BusinessException("Pelo menos um Tipo de Serviço é Requerido!");
		}

		for (TipoServico tipoServico : prestadorServico.getTiposServicos()) {

			if (tipoServico.getCodigo() == null) {
				throw new BusinessException("Código Tipo Serviço Requerido!");
			}
		}

		return dao.create(prestadorServico);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PrestadorServico> read() throws BusinessException {

		return dao.read();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public PrestadorServico update(PrestadorServico prestadorServico) throws BusinessException {

		if (StringUtils.isEmpty(prestadorServico.getNome())) {
			throw new BusinessException("Nome Requerido!");
		}

		if (prestadorServico.getCidade() == null || prestadorServico.getCidade().getCodigo() == null) {
			throw new BusinessException("Cidade Requerido!");
		}

		if (prestadorServico.getTipoLogradouro() == null) {
			throw new BusinessException("Tipo Logradouro Requerido!");
		}

		if (StringUtils.isEmpty(prestadorServico.getLogradouro())) {
			throw new BusinessException("Logradouro Requerido!");
		}

		if (prestadorServico.getNumero() == null) {
			throw new BusinessException("Numero Requerido!");
		}

		if (StringUtils.isEmpty(prestadorServico.getBairro())) {
			throw new BusinessException("Bairro Requerido!");
		}

		if (prestadorServico.getTelefones() == null || prestadorServico.getTelefones().isEmpty()) {
			throw new BusinessException("Pelo menos um Telefone é Requerido!");
		}

		for (Telefone telefone : prestadorServico.getTelefones()) {

			if (telefone.getDdd() == null) {
				throw new BusinessException("DDD Requerido!");
			}

			if (telefone.getNumero() == null) {
				throw new BusinessException("Numero Telefone Requerido!");
			}

			telefone.setPrestadorServico(prestadorServico);
		}

		if (prestadorServico.getTiposServicos() == null || prestadorServico.getTiposServicos().isEmpty()) {
			throw new BusinessException("Pelo menos um Tipo de Serviço é Requerido!");
		}

		for (TipoServico tipoServico : prestadorServico.getTiposServicos()) {

			if (tipoServico.getCodigo() == null) {
				throw new BusinessException("Código Tipo Serviço Requerido!");
			}
		}

		return dao.update(prestadorServico);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer id) throws BusinessException {
		if (id == null) {

			throw new BusinessException("Código Requerido!");
		}

		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PrestadorServico> readByFiltros(FiltroPrestadoDTO filtroPrestadoDTO) throws BusinessException {
		return dao.readByFiltros(filtroPrestadoDTO);
	}
}
