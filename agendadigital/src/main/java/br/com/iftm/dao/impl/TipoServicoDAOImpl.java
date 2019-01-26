package br.com.iftm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.iftm.dao.TipoServicoDAO;
import br.com.iftm.entity.TipoServico;

@Repository
public class TipoServicoDAOImpl implements TipoServicoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.iftm.dao.TipoServicoDAO#create(br.com.iftm.entity.TipoServico)
	 */
	@Override
	public TipoServico create(TipoServico tipoServico) {

		sessionFactory.getCurrentSession().save(tipoServico);
		sessionFactory.getCurrentSession().flush();

		return tipoServico;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.iftm.dao.TipoServicoDAO#read()
	 */
	@Override
	public List<TipoServico> read() {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TipoServico.class);

		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.iftm.dao.TipoServicoDAO#readByName(java.lang.String)
	 */
	@Override
	public List<TipoServico> readByName(String nome) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TipoServico.class);

		criteria.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE).ignoreCase());

		return criteria.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.iftm.dao.TipoServicoDAO#update(br.com.iftm.entity.TipoServico)
	 */
	@Override
	public TipoServico update(TipoServico tipoServico) {

		sessionFactory.getCurrentSession().update(tipoServico);
		sessionFactory.getCurrentSession().flush();

		return tipoServico;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.iftm.dao.TipoServicoDAO#delete(java.lang.Integer)
	 */
	@Override
	public void delete(Integer id) {

		TipoServico tipoServico = new TipoServico();
		tipoServico.setCodigo(id);

		sessionFactory.getCurrentSession().delete(tipoServico);
	}
}
