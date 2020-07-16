package test;

public enum Currency {
	
	CNY(100D,1),HKD(118D,2),USD(15D,3),EUR(13D,4);
	
	private double ratio;
	private int index;
	private int originalValue;
	
	private Currency(double ratio, int index) {
		this.ratio = ratio;
		this.index = index;
	}
	public  double getRatio(int index) {
		for(Currency c:Currency.values()) {
			if(c.getIndex()==index) {
				return c.ratio;
			}
		}
		return 0;
	}
	
	public double getRatio() {
		return ratio;
	}
	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getOriginalValue() {
		return originalValue;
	}
	public void setOriginalValue(int originalValue) {
		this.originalValue = originalValue;
	}
	
	public double getValue() {
		return 100D/getRatio()*originalValue;
	}
	
	
}
