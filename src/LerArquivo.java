import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LerArquivo<T> {

	private Scanner arquivo;
	private Analise<T> analise;

	public LerArquivo(String filename, Analise<T> analise) throws FileNotFoundException {
		this.arquivo = new Scanner(new BufferedReader(new FileReader(filename)));
		this.analise = analise;
		// arquivo.useDelimiter("[;\\r\\n]+");
	}

	public boolean hasNext() {
		return arquivo.hasNext();
	}

	public void skipLine() {
		arquivo.nextLine();
	}

	public T readObject() {
		return analise.analise(arquivo.nextLine());
	}

	public void close() {
		arquivo.close();
	}
}
