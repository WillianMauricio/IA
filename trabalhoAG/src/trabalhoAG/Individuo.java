package trabalhoAG;

public class Individuo {
	
	public String genes[];
	int len_genes;
	
	/**
	 * construct
	 */
	public Individuo(int len, Dados dados) {

		genes = new String[len];
		len_genes = len;
		int i, max = len;
		
		int max_randomico = dados.quantidade;
		String tmp;
		for(i=0; i<max; i++){
			tmp = Utils.at(dados.possiveis, Utils.rand(max_randomico));
			while(Utils.contain(genes, tmp)){
				tmp = Utils.at(dados.possiveis, Utils.rand(max_randomico));
			}
			genes[i] = tmp;
		}
	}
	
	public Individuo(Individuo lst[], Dados dados) {
		Individuo pai = lst[0];
		Individuo mae = lst[1];
		assert pai.genes.length == mae.genes.length;
		len_genes = pai.len_genes;
		genes = realizaCruzamento(pai, mae);
		realizaMutacao(dados);
	}
	
	/**
	 * Retorna distância total do percurso
	 */
	
	public Double getDistanciaPercurso(Dados dados){
		int i, max = len_genes - 1;
		Double count = 0.0;
		String chave_nome;
		for(i=0; i<max; i++){
			chave_nome = genes[i] + genes[i+1];
			count += dados.getDistancia(chave_nome);
		}
		return count;
	}
	
	/**
	 * Verifica se repeta a letra
	 */
	public boolean repeteLetra(){
		int i,j;
		String tmp;
		for(i=0; i<len_genes; i++){
			tmp = genes[i];
			for(j=i+1; j<len_genes; j++){
				if(genes[j].equals(tmp))
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Realiza a mutação 
	 */
	public void realizaMutacao(Dados dados){
		int local1 = Utils.rand(len_genes);
		int local2 = Utils.rand(len_genes);
		while(local2 == local1){
			local2 = Utils.rand(len_genes);
		}
		String tmp = genes[local1];
		genes[local1] = genes[local2];
		genes[local2] = tmp;
	}
	
	/**
	 * Realiza o cruzamento (crossover) entre dois indivíduos
	 */
	private String[] realizaCruzamento(Individuo a, Individuo b){
		String lst[] = new String[a.len_genes];
		int i, max = lst.length;
		
		int contPai = 2;
		String tmp;
		int j;
		for( i = 0; i < max;  i += 2){
			if(contPai % 2 == 0){
				tmp = a.genes[i];
				j = i;
				while(Utils.contain(lst, tmp)){
					tmp = b.genes[j];
					if(j + 1 < max){
						j++;
					} else {
						j = 0;
					}
					
				}

				lst[i] = tmp;
				tmp = a.genes[i + 1];
				j = i + 1;
				while(Utils.contain(lst, tmp)){
					tmp = b.genes[j];
					if(j + 1 < max){
						j++;
					} else {
						j = 0;
					}
					
				}
				lst[i + 1] = tmp;
				
			} else {
				tmp = b.genes[i];
				j = i;
				while(Utils.contain(lst, tmp)){
					tmp = a.genes[j];
					if(j + 1 < max){
						j++;
					} else {
						j = 0;
					}
				}
				lst[i] = tmp;
				
				tmp = b.genes[i + 1];
				j = i + 1;
				while(Utils.contain(lst, tmp)){
					tmp = a.genes[j];
					if(j + 1 < max){
						j++;
					} else {
						j = 0;
					}
				}
				lst[i + 1] = tmp;
			}
			contPai++;
			
		}
		return lst;
	}
}
