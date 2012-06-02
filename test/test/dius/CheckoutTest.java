package test.dius;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import test.dius.pricing.BulkDiscount;
import test.dius.pricing.BuyOneGetOneFree;
import test.dius.pricing.PricingRule;

public class CheckoutTest {

	Item nf3 = new Item("NF3", "Nike Frees", new BigDecimal("99.99"));
	Item vff = new Item("VFF", "Vibram Five Fingers", new BigDecimal("200.00"));
	Item min = new Item("MIN", "Minimus 10", new BigDecimal("155.59"));

	Checkout co;
	
	@Before
	public void setUp() {
		Map<Item, PricingRule> pricingRules = new HashMap<>();
		pricingRules.put(nf3, new BuyOneGetOneFree());
		pricingRules.put(vff, new BulkDiscount(new BigDecimal("25.00"), 3));
		
		co = new Checkout(pricingRules);
	}
	
	@Test
	public void testOne() {
		co.scan(nf3);
		co.scan(vff);
		co.scan(nf3);
		co.scan(nf3);
		co.scan(min);
		assertEquals(new BigDecimal("555.57"), co.total());
	}		
	
	@Test
	public void testTwo() {
		co.scan(nf3);
		co.scan(nf3);
		assertEquals(new BigDecimal("99.99"), co.total());
	}		

	@Test
	public void testThree() {
		co.scan(vff);
		co.scan(vff);
		co.scan(nf3);
		co.scan(vff);
		assertEquals(new BigDecimal("624.99"), co.total());
	}

}
