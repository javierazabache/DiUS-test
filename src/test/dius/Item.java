package test.dius;
import java.math.BigDecimal;


public class Item {

	private String productCode;
	
	private String name;
	
	private BigDecimal price;

	public Item(String productCode, String name, BigDecimal price) {
		this.productCode = productCode;
		this.name = name;
		this.price = price;
	}
	
	public String getProductCode() {
		return productCode;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productCode == null) ? 0 : productCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		return true;
	}

}
