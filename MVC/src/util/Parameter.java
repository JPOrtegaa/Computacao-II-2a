package util;

public class Parameter {
	public enum Operation {EQUAL, LIKE};

	private String name;
	private String value;
	private Operation operation;

	public Parameter( String name, String value ) {
		this(name,value,Operation.LIKE);
	}

	public Parameter( String name, String value,
			Operation operation ) {
		this.name  = name;
		this.value = value;
		this.operation = operation;
	}

	public String getName() {
		return this.name;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public Operation getOperation() {
		return this.operation;
	}
}
