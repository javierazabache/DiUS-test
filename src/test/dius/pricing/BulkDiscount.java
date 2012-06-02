package test.dius.pricing;

import test.dius.Item;

import java.math.BigDecimal;


public class BulkDiscount implements PricingRule {

	private BigDecimal discount;
	
	private int minQuantity;
	
	public BulkDiscount(BigDecimal discount, int minQuantity) {
		this.discount = discount;
		this.minQuantity = minQuantity;
	}
	
	@Override
	public BigDecimal applyTo(Item item, int quantity) {
		BigDecimal price = quantity < minQuantity ? item.getPrice() : item.getPrice().subtract(discount);
		return price.multiply(BigDecimal.valueOf(quantity));
	}

}
