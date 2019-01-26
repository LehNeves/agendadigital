package br.com.iftm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.iftm.enums.Estado;

@Entity
@Table(name = "TB_CIDADE", uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_CIDADE", columnNames = { "NOM_CIDADE", "SIG_ESTADO" }) })
@SequenceGenerator(name = "SQ_CIDADE", sequenceName = "SQ_CIDADE", initialValue = 1, allocationSize = 1)
public class Cidade {

	@Id
	@Column(name = "COD_CIDADE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CIDADE")
	private Integer codigo;

	@Column(name = "NOM_CIDADE", length = 100, nullable = false)
	private String nome;

	@Column(name = "SIG_ESTADO", length = 2, nullable = false)
	@Enumerated(EnumType.STRING)
	private Estado estado;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
