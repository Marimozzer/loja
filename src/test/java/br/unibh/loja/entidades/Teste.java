package br.unibh.loja.entidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.Test;

public class Teste {

	@Test

	public void testCreateObject() {

		Cliente cl = new Cliente(3L, "Mariana", "marimozzer", "123", "adm", "12345321", "91919292", "abcd@efgh.com.br",
				new Date(), new Date());
		assertEquals(cl.getId(), new Long(3));
		assertEquals(cl.getNome(), "Mariana");
		assertEquals(cl.getLogin(), "marimozzer");
		assertEquals(cl.getSenha(), "123");
		assertEquals(cl.getPerfil(), "adm");
		assertEquals(cl.getCpf(), "12345321");
		assertEquals(cl.getTelefone(), "91919292");
		assertEquals(cl.getEmail(), "abcd@efgh.com.br");
		assertEquals(cl.getDataNascimento(), new Date());
		assertEquals(cl.getDataCadastro(), new Date());

		Categoria cat = new Categoria(1L, "Cozinha");
		assertEquals(cat.getId(), new Long(1));
		assertEquals(cat.getDescricao(), "Cozinha");

		Produto prod = new Produto(1L, "Panela eletrica", "Cozinha", cat, new BigDecimal(300.00), "Polishop");
		assertEquals(prod.getId(), new Long(1));
		assertEquals(prod.getNome(), "Panela eletrica");
		assertEquals(prod.getDescricao(), "Cozinha");
		assertEquals(prod.getPreco(), new BigDecimal(300.00));
		assertEquals(prod.getFabricante(), "Polishop");

	}

	@Test
	public void testCompareOnject() {
		Cliente c2 = new Cliente(1L, "Mariana", "marimozzer", "123", "adm", "12345321", "91919292", "abcd@efgh.com.br",
				new Date(), new Date());
		Cliente c3 = new Cliente(1L, "Mariane", "marimozzer", "123", "adm", "12345321", "91919292", "abcd@efgh.com.br",
				new Date(), new Date());
		assertNotEquals(c2, c3);

		Categoria cat1 = new Categoria(1L, "Cozinha");
		Categoria cat2 = new Categoria(2L, "Casa");
		assertNotEquals(cat1, cat2);

		Produto prod = new Produto(1L, "Panela eletrica", "Cozinha", cat1, new BigDecimal(300.00), "Polishop");
		Produto prod1 = new Produto(2L, "Panela eletrica", "Sala", cat2, new BigDecimal(300.00), "Polishop");
		assertNotEquals(prod, prod1);

	}

	@Test
	public void testGenerateHash() {
		Cliente c1 = new Cliente(1L, "Mariana", "marimozzer", "123", "adm", "12345321", "91919292", "abcd@efgh.com.br",
				new Date(), new Date());
		Cliente c2 = new Cliente(2L, "Mariani", "marimozzer", "124", "cliente", "12345321", "88888888",
				"abcd@efgh.com.br", new Date(), new Date());
		assertNotEquals(c1.hashCode(), c2.hashCode());

	}

	@Test
	public void testPrintObject() {
		Cliente c1 = new Cliente(1L, "Mariana", "marimozzer", "123", "adm", "12345321", "91919292", "abcd@efgh.com.br",
				new Date(), new Date());
		System.out.println(c1);

	}
}
