package exemplos;

interface Probing {
	int probe(Object key, int hash, int j, int size);
}

class ChaveValor {
	public final String key;
	public final String value;
	public ChaveValor(String k, String v) {
		key = k;
		value = v;
	}
}

public class HashTable {
	
	private ChaveValor[] tabela = new ChaveValor[20];
	private Probing probe;

	public static void main(String[] args) {
		/*
		// linear: (i + j) % B
		HashTable hashTable = new HashTable(
			(k,h,j,B)-> {
				int h2;
				return (h2 = ((h+j)% B))>0?h2:-1*h2;
			});
		*/
		/*
		// quadratico: (h + 2**j) % B
		HashTable hashTable = new HashTable(
			(k,h,j,B)-> {
				int h2;
				return (h2 = (h+(1<<j))% B)>0?h2:-1*h2;
			});
		*/
		// double hash: (h1 + h2*j) % B
		HashTable hashTable = new HashTable(
			(Object k, int h, int j, int B) -> {
				int h2 = String.format("%s%d",k.toString(),h).hashCode();
				return (h2 = (h+h2*j)% B) > 0 ? h2 : -1*h2; 
			});

		hashTable.put("123","Rafael");
		hashTable.put("124","Ivonei");
		hashTable.put("125","Lucia");
		hashTable.put("126","Rafael");
		hashTable.put("191","Aline");
		hashTable.put("194","Guilherme");
		hashTable.put("197","Marcelo");
		
		String[] keys = {"123","124","125","126","191","194","197"};
		for (String k : keys) {
			String v = hashTable.get(k);
			System.out.println("Chave " + k + " - Valor: " + v);
		}
	}

	public HashTable(Probing probe) {
		this.probe = probe;
	}

	private String get(String key)
	{
		int hk = hash(key);
		for (int j = 0; j < tabela.length; j++) {
			int indice = probe.probe(key, hk, j, tabela.length);
			if (tabela[indice] == null) {
				throw new KeyNotFoundException(key);
			} else {
				if (key.equals(tabela[indice].key)) {
					System.out.println("Encontrado na posicao: " + indice);
					return tabela[indice].value;
				}
			}
		}
		throw new KeyNotFoundException(key);
	}

	private void put(String key, String value) {
		System.out.println("Inserindo: (" + key+","+value+")");
		int hk = hash(key);
		// probing linear
		for (int j = 0; j < tabela.length; j++) {
			int indice = probe.probe(key, hk, j, tabela.length);
			System.out.print("Tentando: " + indice + "... ");
			if (tabela[indice] == null) {
				System.out.println("ok.");
				tabela[indice] = new ChaveValor(key,value);
				break;
			} else {
				System.out.println("failed.");
			}
		}

	}

	private int hash(String key) {
		int h = 37;
		for (char c : key.toCharArray()) {
			h <<= (c & 0x0F);
			h ^= c;
		}
		return h;
	}

}
