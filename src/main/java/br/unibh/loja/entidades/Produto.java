package br.unibh.loja.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = " tb_produto ", uniqueConstraints = { @UniqueConstraint(columnNames = { "nome" }) })
@NamedQueries({ @NamedQuery(name = "Produto.findByName", query = "select o from Produto o where o.nome like :nome") })
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 100, nullable = false)
	@NotEmpty
	@Size(min = 3, max = 100)
	@Pattern(regexp = "[A-z�-�.� ' ]*", message = "Caracteres permitidos: letras, espa�os, ponto e aspas simples")
	private String nome;
	@Column(length = 4000, nullable = false)
	@NotEmpty
	@Pattern(regexp = "[A-z�-�.� ' - / ]*", message = "Caracteres permitidos: letras, espa�os, ponto, tra�o, barra e aspas simples")
	private String descricao;
	@Column
	@NotEmpty
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	@Column(scale = 2, precision = 12, nullable = false)
	@DecimalMin(value = "0", message = "Valor n�o pode ser menor que 0,00")
	@NotEmpty
	private BigDecimal preco;
	@Column(length = 100, nullable = false)
	@NotEmpty
	@Size(min = 3, max = 100)
	@Pattern(regexp = "[A-z�-�.� ' ]*", message = "Caracteres permitidos: letras, espa�os, ponto e aspas simples")
	private String fabricante;
	@Version
	private Long version;

	public Produto(Long id, String nome, String descricao, Categoria categoria, BigDecimal preco, String fabricante) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.preco = preco;
		this.fabricante = fabricante;
	}

	public Produto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", categoria=" + categoria
				+ ", preco=" + preco + ", fabricante=" + fabricante + "]";
	}

}
