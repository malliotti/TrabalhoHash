package exemplos;

public class KeyNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 3795850112973739657L;

	public KeyNotFoundException() {
		super("Key not found.");
	}
	
	public KeyNotFoundException(String key) {
		super("Key '"+key+"' not found.");
	}
}
