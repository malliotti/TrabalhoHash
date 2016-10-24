import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Principal {

	static HashMap<String, Rotas> rotas = new HashMap<>();
	static LinkedList<Rotas> rotasLinked = new LinkedList<>();
	public static Scanner entrada;
	public static Rotas r1;
	public static Rotas r2;

	public Principal() throws Exception {
		Analise<Rotas> analise = new AnaliseRotas();
		LerArquivo<Rotas> ler = new LerArquivo<>("routes.txt", analise);
		ler.skipLine(); // Pula a primeira linha do arquivo.
		while (ler.hasNext()) {
			Rotas rota = ler.readObject();
			rotas.put(rota.getRoute_id(), rota);
			rotasLinked.add(rota);
		}
		ler.close();
	}

	public static void main(String[] args) throws Exception {
		new Principal();

		int opcao;
		entrada = new Scanner(System.in);
		do {
			menu();
			opcao = entrada.nextInt();

			switch (opcao) {
			case 0:
				exit();
				break;

			case 1:
				inclui();
				break;

			case 2:
				altera();
				break;

			case 3:
				exclui();
				break;

			case 4:
				consulta();
				break;
			case 5:
				completa();
				break;

			default:
				System.out.println("Op��o inv�lida.");
			}
		} while (opcao != 0);

	}

	public static void menu() {
		System.out.println("\t===============");
		System.out.println("\tRotas de Onibus");
		System.out.println("\t===============");
		System.out.println("0. Fim");
		System.out.println("1. Inclui");
		System.out.println("2. Altera");
		System.out.println("3. Exclui");
		System.out.println("4. Consulta");
		System.out.println("5. Lista Completa");
		System.out.print("Opcao: ");
	}

	public static void exit() {
		System.out.println();
		System.out.println("Sistema encerrado");
		System.exit(1);
	}

	public static void inclui() {
		System.out.println();
		System.out.println("Inclusao");
	}

	public static void altera() {
		System.out.println();
		System.out.println("Alteracao.");
	}

	public static void exclui() {
		System.out.println();
		System.out.println("Exclusao");
	}

	public static void consulta() {
		entrada = new Scanner(System.in);
		System.out.print("Informe o id que deseja pesquisar: ");
		String valor = entrada.next();

		Rotas rota = new Rotas(valor, "", "", 0, "");

		double l1 = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			r1 = rotas.get(rota);
		}

		double l2 = System.currentTimeMillis();

		double l3 = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			int indice = rotasLinked.indexOf(rota);
			if (indice >= 0) {
				r2 = rotasLinked.get(indice);
			}
		}
		double l4 = System.currentTimeMillis();
		System.out.println();
		System.out.println("Hash demorou " + ((l2 - l1) / 1000) + " segundos para pesquisar");
		System.out.println("Linked demorou " + ((l4 - l3) / 1000) + " segundos para pesquisar");
		System.out.println();
	}

	public static void printlinked() {
		for (int i = 0; i < rotasLinked.size(); i++) {
			System.out.println(rotasLinked.get(i));
		}
	}

	public static void printahash() {
		for (Rotas r : rotas.values()) {
			System.out.println(r);
		}
	}

	public static void completa() throws Exception {
		System.out.println();
		double l1 = System.currentTimeMillis();
		printahash();
		double l2 = System.currentTimeMillis();

		double l3 = System.currentTimeMillis();
		printlinked();
		double l4 = System.currentTimeMillis();

		System.out.println();
		System.out.println("Hash demorou  : " + ((l2 - l1) / 1000) + " segundos ");
		System.out.println("Linked demorou: " + ((l4 - l3) / 1000) + " segundos ");
		System.out.println();
	}

	@SuppressWarnings("unused")
	private void executar() throws FileNotFoundException {
		validarRotas();
	}

	private void validarRotas() throws FileNotFoundException {
		Analise<Rotas> analise = new AnaliseRotas();
		LerArquivo<Rotas> ler = new LerArquivo<>("routes.txt", analise);
		ler.skipLine(); // Pula a primeira linha do arquivo.
		while (ler.hasNext()) {
			Rotas rota = ler.readObject();
			System.out.println(rota);
		}
		ler.close();
	}

}
