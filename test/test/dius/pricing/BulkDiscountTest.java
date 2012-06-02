package test.dius.pricing;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import test.dius.Item;

public class BulkDiscountTest {

	@Test
	public void test() {
		Item vff = new Item("VFF", "Vibram Five Fingers", new BigDecimal(
				"200.00"));
		BulkDiscount rule = new BulkDiscount(new BigDecimal("25.00"), 3);
		assertEquals(new BigDecimal("0.00"), rule.applyTo(vff, 0));
		assertEquals(new BigDecimal("400.00"), rule.applyTo(vff, 2));
		assertEquals(new BigDecimal("525.00"), rule.applyTo(vff, 3));
		assertEquals(new BigDecimal("700.00"), rule.applyTo(vff, 4));
	}

}
