package trabalhoAG;

import java.util.HashMap;

public class Dados {

	HashMap<String, Double> cidades;
	String possiveis;
	int quantidade;

	/**
	 * construct 
	 */
	public Dados() {
		
		/* DEFININDO POPULAÇÃO E MATRIZ*/
		Cidade c1 = new Cidade("A");
		Cidade c2 = new Cidade("B");
		Cidade c3 = new Cidade("C");
		Cidade c4 = new Cidade("D");
		Cidade c5 = new Cidade("E");
		Cidade c6 = new Cidade("F");
		Cidade c7 = new Cidade("G");
		Cidade c8 = new Cidade("H");

		possiveis = c1.letra + c2.letra + c3.letra + c4.letra + c5.letra + c6.letra + c7.letra + c8.letra;

		quantidade = possiveis.length();

		cidades = new HashMap<String, Double>();
		
		// c1
		cidades.put(duasLetras(c1, c1), 0.0);
		cidades.put(duasLetras(c1, c2), 1.0);
		cidades.put(duasLetras(c1, c3), 2.0);
		cidades.put(duasLetras(c1, c4), 3.6);
		cidades.put(duasLetras(c1, c5), 2.1);
		cidades.put(duasLetras(c1, c6), 5.2);
		cidades.put(duasLetras(c1, c7), 7.0);
		cidades.put(duasLetras(c1, c8), 2.7);

		// c2
		cidades.put(duasLetras(c2, c2), 0.0);
		cidades.put(duasLetras(c2, c3), 2.0);
		cidades.put(duasLetras(c2, c4), 1.1);
		cidades.put(duasLetras(c2, c5), 5.7);
		cidades.put(duasLetras(c2, c6), 8.9);
		cidades.put(duasLetras(c2, c7), 4.5);
		cidades.put(duasLetras(c2, c8), 10.4);

		// c3
		cidades.put(duasLetras(c3, c3), 0.0);
		cidades.put(duasLetras(c3, c4), 6.8);
		cidades.put(duasLetras(c3, c5), 8.2);
		cidades.put(duasLetras(c3, c6), 3.1);
		cidades.put(duasLetras(c3, c7), 5.0);
		cidades.put(duasLetras(c3, c8), 3.9);

		// c4
		cidades.put(duasLetras(c4, c4), 0.0);
		cidades.put(duasLetras(c4, c5), 4.4);
		cidades.put(duasLetras(c4, c6), 1.2);
		cidades.put(duasLetras(c4, c7), 6.4);
		cidades.put(duasLetras(c4, c8), 9.3);

		// c5
		cidades.put(duasLetras(c5, c5), 0.0);
		cidades.put(duasLetras(c5, c6), 5.3);
		cidades.put(duasLetras(c5, c7), 1.2);
		cidades.put(duasLetras(c5, c8), 8.4);

		// c6
		cidades.put(duasLetras(c6, c6), 0.0);
		cidades.put(duasLetras(c6, c7), 4.8);
		cidades.put(duasLetras(c6, c8), 4.3);

		// c7
		cidades.put(duasLetras(c7, c7), 0.0);
		cidades.put(duasLetras(c7, c8), 4.8);

		// c8
		cidades.put(duasLetras(c8, c8), 0.0);

	}

	/**
	 * Concatena cidade a com b (gene)
	 */
	public String duasLetras(Cidade a, Cidade b) {
		return a.letra + b.letra;
	}

	/**
	 * Calcula distância entre cidades x e y
	 */
	public Double getDistancia(String chave) {
		Double t;
		if (cidades.containsKey(chave)) {
			t = cidades.get(chave);
			assert (t != null);
			return t;
		} else {
			String tmp = Utils.at(chave, 1) + Utils.at(chave, 0);
			t = cidades.get(tmp);
			assert (t != null);
			return t;
		}
	}
}
