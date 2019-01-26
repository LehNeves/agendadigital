package br.com.iftm.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.iftm.controller.dto.FiltroPrestadoDTO;
import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entity.PrestadorServico;
import br.com.iftm.entity.TipoServico;

@Repository
public class PrestadorServicoDAOImpl implements PrestadorServicoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public PrestadorServico create(PrestadorServico prestadorServico) {

		sessionFactory.getCurrentSession().save(prestadorServico);
		sessionFactory.getCurrentSession().flush();

		return prestadorServico;
	}

	@Override
	public List<PrestadorServico> read() {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class);

		return criteria.list();
	}

	@Override
	public PrestadorServico update(PrestadorServico prestadorServico) {

		sessionFactory.getCurrentSession().update(prestadorServico);
		sessionFactory.getCurrentSession().flush();

		return prestadorServico;
	}

	@Override
	public void delete(Integer id) {

		PrestadorServico prestadorServico = sessionFactory.getCurrentSession().get(PrestadorServico.class, id);
		sessionFactory.getCurrentSession().delete(prestadorServico);
	}

	@Override
	public List<PrestadorServico> readByFiltros(FiltroPrestadoDTO filtroPrestadoDTO) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PrestadorServico.class);
		Criteria criteriaCidade = criteria.createCriteria("cidade");
		Criteria criteriaTiposServicos = criteria.createCriteria("tiposServicos");

		if (!StringUtils.isEmpty(filtroPrestadoDTO.getNome())) {

			criteria.add(Restrictions.like("nome", filtroPrestadoDTO.getNome(), MatchMode.ANYWHERE).ignoreCase());
		}

		if (filtroPrestadoDTO.getEstado() != null) {

			criteriaCidade.add(Restrictions.eq("estado", filtroPrestadoDTO.getEstado()));
		}

		if (filtroPrestadoDTO.getCidade() != null && filtroPrestadoDTO.getCidade().getCodigo() != null) {

			criteria.add(Restrictions.eq("cidade", filtroPrestadoDTO.getCidade()));
		}

		// TODO : Verificar erro.
		if (filtroPrestadoDTO.getTiposServicos() != null && !filtroPrestadoDTO.getTiposServicos().isEmpty()) {

			List<Integer> collect = filtroPrestadoDTO.getTiposServicos().stream().map(TipoServico::getCodigo)
					.collect(Collectors.toList());

			criteriaTiposServicos.add(Restrictions.in("codigo", collect));
		}

		return criteria.list();
	}
}
