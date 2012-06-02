package test.dius;

import test.dius.pricing.PricingRule;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class Checkout {

	private Map<Item, Integer> basket = new HashMap<>();

	private Map<Item, PricingRule> pricingRules;
	
	public Checkout(Map<Item, PricingRule> pricingRules) {
		this.pricingRules = pricingRules;
	}
	
	public void scan(Item item) {
		basket.put(item, basket.containsKey(item) ? basket.get(item) + 1 : 1);
	}
	
	public BigDecimal total() {
		BigDecimal total = BigDecimal.ZERO;
		for (Map.Entry<Item, Integer> entry : basket.entrySet()) {
			Item item = entry.getKey();
			int quantity = entry.getValue();
			if (pricingRules.containsKey(item)) {
				total = total.add(pricingRules.get(item).applyTo(item, quantity));
			} else {
				total = total.add(item.getPrice().multiply(BigDecimal.valueOf(quantity)));
			}
		}
		return total;
	}
}