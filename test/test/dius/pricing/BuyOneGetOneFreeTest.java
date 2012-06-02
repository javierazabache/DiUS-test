package test.dius.pricing;

import test.dius.Item;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;


public class BuyOneGetOneFreeTest {

	@Test
	public void test() {
		Item nf3 = new Item("NF3", "Nike Frees", new BigDecimal("99.99"));
		BuyOneGetOneFree rule = new BuyOneGetOneFree();
		assertEquals(new BigDecimal("0.00"), rule.applyTo(nf3, 0));
		assertEquals(new BigDecimal("99.99"), rule.applyTo(nf3, 1));
		assertEquals(new BigDecimal("99.99"), rule.applyTo(nf3, 2));
		assertEquals(new BigDecimal("199.98"), rule.applyTo(nf3, 3));
	}

}
