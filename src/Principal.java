import java.io.FileNotFoundException;

public class Principal {

	public static void main(String[] args) {
		try {
			(new Principal()).executar();
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo nao encontrado.");
			System.err.println(e.getMessage());
		}
	}

	private void executar() throws FileNotFoundException {
		validarRotas();
	}

	private void validarRotas() throws FileNotFoundException {
		Analise<Rotas> analise = new AnaliseRotas();
		LerArquivo<Rotas> ler = new LerArquivo<>("routes.txt", analise);
		ler.skipLine(); // Pula a primeira linha do arquivo
		while (ler.hasNext()) {
			Rotas rota = ler.readObject();
			System.out.println(rota);
		}
		ler.close();
	}

}
