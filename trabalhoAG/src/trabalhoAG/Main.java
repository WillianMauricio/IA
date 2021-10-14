package trabalhoAG;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		AlgoritmoGenetico ag = new AlgoritmoGenetico();
		Individuo individuo;
		int epocas = 0;
		
		while(true){
			individuo = ag.getMaisApto(ag.populacao);
			ag.getProximaGeracao();
			epocas++;
			if(epocas == 50) break;
			
		}
		
		DecimalFormat df = new DecimalFormat("#,###.00");
		
		System.out.println(df.format(individuo.getDistanciaPercurso(ag.dados)));
		System.out.println(Utils.juntaIteracao(individuo.genes, " "));
		
	}

}
