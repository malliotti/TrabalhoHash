
public class RobinHoodHash {


	public  void insere (String key, String value){
		String entrada;
		
		String i;
		if (tabela.cheia()){
			rehash();
			String h = hash(key);
			entrada = HashEntry(key, value, h);
			i = mod(h & 0x7ffffff, tabela.length);
		}
	while (! livre(tabela[i]))
	if (entrada.probe < tabela[i].probe){
		swap(entrada, tabela[i]);		
	}else{
		++ entrada.probe;
		i = mod(i + 1, tabela.length);
		tabela.set(i, entrada);
	}
	}// Fim do public void insere.
	
	private void rehash() {
		// TODO Auto-generated method stub
		
	}

	public void consulta(String key) -> value{
	    h = hash(key);
	    	    i = mod(h & 0x7ffffff, tabela.length);
	    	    probe = 0;
	    	    while (! livre(tabela)) and (probe <= tabela[i].probe);
	    	        if (tabela[i].hash == h) and (tabela[i].key == key);
	    	        {
	    	        	return tabela[i].value;
	   	    	        i = mod(i + 1, tabela.length);
	   	    	        probe = probe + 1;
	    	        }
	    	        
	    	   return NULL;
	}//Fim do public void consulta
	
	public void remove(String key, Object elemento){
	    elemento = localiza_elemento(key);
	    	    if (valid(elemento)){
	    	    	elemento.removido = true;
	    	    }
	    	        
	}



}
