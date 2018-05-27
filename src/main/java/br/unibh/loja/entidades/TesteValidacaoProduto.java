package br.unibh.loja.entidades;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteValidacaoProduto {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		System.out.println("Inicializando validador...");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testeValidacaoProduto1() {
		Categoria cat = new Categoria(1L, "Casa");
		Produto prod = new Produto(1L, "Cozinha", "Casa", cat, new BigDecimal(10.00), "Panela");
		System.out.println(prod);
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(prod);
		for (ConstraintViolation<Produto> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testeValidacaoProduto2() {
		Categoria cat = new Categoria(1L, "Casa");
		Produto prod = new Produto(1L, "Cozinha@", "Casa", cat, new BigDecimal(10.00), "Panela");
		System.out.println(prod);
		Set<ConstraintViolation<Produto>> constraintViolations = validator.validate(prod);
		for (ConstraintViolation<Produto> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}

}
