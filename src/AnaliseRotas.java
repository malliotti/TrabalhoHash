import java.util.Scanner;

public class AnaliseRotas implements Analise<Rotas> {
	@Override
	public Rotas analise(String dados) {
		Scanner leitura = new Scanner(dados);
		leitura.useDelimiter(",");
		String id = leitura.next();
		leitura.next(); // agency_id
		String shortName = leitura.next();
		String longName = leitura.next();
		leitura.next(); // desc
		int type = leitura.nextInt();
		leitura.next(); // url
		String route_color = leitura.next(); // color
		leitura.next(); // color
		leitura.close();
		return new Rotas(id, shortName, longName, type, route_color);
	}

}
