import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        
        do{
            menu();
            opcao = entrada.nextInt();
            
            switch(opcao){
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
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);

	}
	
    public static void menu(){
    	System.out.println("\t===============");
    	System.out.println("\tRotas de Onibus");
        System.out.println("\t===============");
        System.out.println("0. Fim");
        System.out.println("1. Inclui");
        System.out.println("2. Altera");
        System.out.println("3. Exclui");
        System.out.println("4. Consulta");
        System.out.println("5. Lista Completa");
        System.out.println("Opcao:");
    }
    
    public static void exit(){
    	System.out.println();
    	System.out.println("Sistema encerrado0");
        System.exit(1);
    }
    
    public static void inclui(){
    	System.out.println();
        System.out.println("Você entrou no método Inclui.");
    }
    
    public static void altera(){
    	System.out.println();
        System.out.println("Você entrou no método Altera.");
    }
    
    public static void exclui(){
    	System.out.println();
        System.out.println("Você entrou no método Exclui.");
    }
    
    public static void consulta(){
    	System.out.println();
        System.out.println("Você entrou no método Consulta.");
    }
    public static void completa(){
    	try {	
    		System.out.println();
    		(new Principal()).executar();
    		System.out.println();
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
		ler.skipLine(); // Pula a primeira linha do arquivo.
		while (ler.hasNext()) {
			Rotas rota = ler.readObject();
			System.out.println(rota);
		}
		ler.close();
	}

}
