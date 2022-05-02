package utilsModelClass;

import com.google.gson.annotations.SerializedName;

public class Depreciation {

	@SerializedName("year")
	private Integer year;
	@SerializedName("rate")
	private Integer rate;
	
	@SerializedName("price")
	private Integer price;

	public Integer getYear() {
	return year;
	}

	public void setYear(Integer year) {
	this.year = year;
	}

	public Integer getRate() {
	return rate;
	}

	public void setRate(Integer rate) {
	this.rate = rate;
	}

	public Integer getPrice() {
	return price;
	}

	public void setPrice(Integer price) {
	this.price = price;
	}

	}
