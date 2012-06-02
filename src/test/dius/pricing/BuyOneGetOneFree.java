package test.dius.pricing;

import test.dius.Item;

import java.math.BigDecimal;

public class BuyOneGetOneFree implements PricingRule {
	
	@Override
	public BigDecimal applyTo(Item item, int quantity) {
		BigDecimal price = item.getPrice();
		return price.multiply(BigDecimal.valueOf(quantity / 2)).add(price.multiply(BigDecimal.valueOf(quantity % 2)));
	}
}
