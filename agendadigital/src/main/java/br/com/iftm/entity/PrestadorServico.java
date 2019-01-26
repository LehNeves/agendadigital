package br.com.iftm.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.iftm.enums.TipoLogradouro;

@Entity
@Table(name = "TB_PRESTADOR_SERVICO")
@SequenceGenerator(name = "SQ_PRESTADOR_SERVICO", sequenceName = "SQ_PRESTADOR_SERVICO", initialValue = 1, allocationSize = 1)
public class PrestadorServico {

	@Id()
	@Column(name = "COD_PRESTADOR_SERVICO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRESTADOR_SERVICO")
	private Integer codigo;

	@Column(name = "NOM_PRESTADOR_SERVICO", length = 100, nullable = false)
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Cidade.class)
	@JoinColumn(name = "COD_CIDADE", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_TB_PRESTADOR_SERV_TB_CIDADE"))
	private Cidade cidade;

	@Column(name = "NOM_BAIRRO", length = 50, nullable = false)
	private String bairro;

	@Column(name = "NUM_CEP", length = 10, nullable = true)
	private String cep;

	@Column(name = "TIP_LOGRADOURO", length = 10, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoLogradouro tipoLogradouro;

	@Column(name = "DES_LOGRADROURO", length = 100, nullable = false)
	private String logradouro;

	@Column(name = "DES_COMPLEMENTO", length = 200, nullable = true)
	private String complemento;

	@Column(name = "NUMERO", nullable = false)
	private Integer numero;

	@Column(name = "DES_EMAIL", length = 80, nullable = true)
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "prestadorServico", orphanRemoval = true, targetEntity = Telefone.class)
	private Set<Telefone> telefones;

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, targetEntity = TipoServico.class)
	@JoinTable(name = "RL_SERVICO_CREDENCIADO", joinColumns = {
			@JoinColumn(name = "COD_PRESTADOR_SERVICO") }, inverseJoinColumns = {
					@JoinColumn(name = "COD_TIPO_SERVICO") })
	private Set<TipoServico> tiposServicos;

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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Set<TipoServico> getTiposServicos() {
		return tiposServicos;
	}

	public void setTiposServicos(Set<TipoServico> tiposServicos) {
		this.tiposServicos = tiposServicos;
	}
}
