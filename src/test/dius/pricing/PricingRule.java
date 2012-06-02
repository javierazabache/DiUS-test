package test.dius.pricing;

import test.dius.Item;

import java.math.BigDecimal;

public interface PricingRule {

	BigDecimal applyTo(Item item, int quantity);
	
}
