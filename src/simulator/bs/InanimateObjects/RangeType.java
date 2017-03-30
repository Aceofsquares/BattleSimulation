package simulator.bs.InanimateObjects;

public enum RangeType {
	CLOSE(1), SHORT(2), LONG(3), VERY_LONG(5);
	private final int range;

	RangeType(int range) {
		this.range = range;
	}

	public int getValue() {
		return range;
	}
}
