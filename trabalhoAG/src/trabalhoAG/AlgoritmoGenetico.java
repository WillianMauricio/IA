package trabalhoAG;

public class AlgoritmoGenetico {
	public Individuo[] populacao;
	Dados dados;
	int quantidade = 10;
	int qnt_cidades = 8;

	/**
	 * construct
	 */
	
	public AlgoritmoGenetico() {
		populacao = new Individuo[quantidade];
		dados = new Dados();
		int i;
		for(i = 0; i < quantidade; i++){
			populacao[i] = new Individuo(qnt_cidades, dados);
		}
	}
	
	/**
	 * Retorna o Indivíduo mais apto 
	 */
	public Individuo getMaisApto(Individuo lst[]){
		return lst[getIndiceMaisApto(lst)];
		
	}
	
	/**
	 * Retorna o índice no array do Indivíduo mais apto
	 * @param lst
	 * @return
	 */
	public int getIndiceMaisApto(Individuo lst[]){
		Double menor = 0.0, aux;
		int local_menor = -1, i, len = lst.length;
		Individuo tmp;
		
		for(i=0; i<len; i++){
			tmp = lst[i];
			if(tmp == null)continue;
			if(!tmp.repeteLetra()){
				aux = tmp.getDistanciaPercurso(dados);
				if(local_menor == -1 || aux <  menor){
					local_menor = i;
					menor = aux;
				}
			}
		}
		assert local_menor != -1;
		
		return local_menor;
		
	}
	
	public Individuo[] torneio(){
		int qnt_torneio = 9;
		Individuo to_return[] = new Individuo[2];
		Individuo lst[] = new Individuo[qnt_torneio];
		
		int i;
		for(i=0; i<qnt_torneio; i++){
			lst[i] = populacao[Utils.rand(quantidade)];
		}
		
		int i1;
		i1 = getIndiceMaisApto(lst);
		to_return[0] = populacao[i1];
		lst[i1] = null;
		
		to_return[1] = getMaisApto(lst);
		
		return to_return;
		
	}
	
	/**
	 * Define a próxima geração da população
	 */
	public void getProximaGeracao(){
		Individuo proximaPopulacao[] = new Individuo[quantidade];
		int i;
		
		proximaPopulacao[0] = getMaisApto(populacao);
		
		for(i=1; i<quantidade; i++){
			proximaPopulacao[i] = new Individuo(torneio(), dados);
		}
		
		populacao = proximaPopulacao;
		
	}
}
