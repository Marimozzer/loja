package br.unibh.loja.entidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.Test;

public class Teste {

	@Test

	public void testCreateObject() {

		Cliente cl = new Cliente(1L, "Mariana", "marimozzer", "123", "adm", "12345321", "91919292", "abcd@efgh.com.br",
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

	}

}
