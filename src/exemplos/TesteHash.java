package exemplos;
import java.util.HashMap;
import java.util.HashSet;

class Chave {
	@Override
	public int hashCode() {
		return 0;
		
	}
	@Override
	public boolean equals(Object o) {
		return  false;
	}
}

public class TesteHash {
	public static void main(String[] args) {
		new HashMap<>();

		new HashSet<>();
	}
}
