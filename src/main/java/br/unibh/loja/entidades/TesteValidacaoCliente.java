package br.unibh.loja.entidades;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import br.unibh.loja.entidades.Categoria;
import br.unibh.loja.entidades.Cliente;
import br.unibh.loja.entidades.Produto;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteValidacaoCliente {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		System.out.println("Inicializando validador...");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testeValidacaoCliente1() {
		Date dt = new Date(16 / 02 / 1997);
		Cliente cl = new Cliente(3L, "Mariana", "Mari", "marimozzer", "marimozzer", "12345678900", "333344444",
				"abcd@efgh.com.br", dt, dt);
		System.out.println(cl);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cl);
		for (ConstraintViolation<Cliente> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}

	@Test
	public void testeValidacaoCliente2() {
		Date dt = new Date(16 / 02 / 1997);
		Cliente cl = new Cliente(3L, "Mariana", "Mari", "marimozzer", "marimozzer", "12345678900", "33334444",
				"abcd@efgh.com.br", dt, dt);
		System.out.println(cl);
		Categoria cat = new Categoria(1L, "Elétrico");
		System.out.println(cat);
		Produto prod = new Produto(1L, "Celular", "Elétrico", cat, new BigDecimal(10.00), "Motorola");
		System.out.println(prod);
		Set<ConstraintViolation<Cliente>> constraintViolations = validator.validate(cl);
		for (ConstraintViolation<Cliente> c : constraintViolations) {
			System.out.println(" Erro de Validacao: " + c.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size());
	}

}
