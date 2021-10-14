package trabalhoAG;

import java.util.Random;

public class Utils {
	/**
	 * Gera número aleatório 0 a 100
	 */
	public static Integer rand0100(){
		return rand(101);
	}
	
	/**
	 * Gera número aleatório 0 a "?"
	 */
	public static int rand(int v){
		Random r = new Random();
		return r.nextInt(v);
	}
	
	/**
	 * Converte inteiro para binário
	 */
	public static String int_to_bin(int valor){
		String tmp = Integer.toBinaryString(valor);
		int numero_bits = 8;
		
		String colocar = "0";
		String somador = "";
		int qnt = numero_bits - tmp.length();
		for(int i=0; i<qnt; i++){
			somador += colocar;
		}
		
		return somador + tmp;
	}
	
	public static <T> String  juntaIteracao(T lst[], String st){
		int i, max = lst.length;
		String aux = "";
		for(i=0; i<max; i++){
			aux += lst[i].toString();
			if(i+1 < max){
				aux += st;
			}
		}
		return aux;
	}
	
	/**
	 * Verifica se String está contida no array
	 */
	public static <T> boolean  contain(T lst[], T st){
		int i, max = lst.length;
		T aux;
		for(i=0; i<max; i++){
			aux = lst[i];
			if(aux != null && aux.equals(st)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Considera que os elementos do array são string em binário
	 */
	public static int[] lst_str_to_int(String lst[]){
		int max = lst.length;
		
		int lst_int[] = new int[max];
		
		for(int i=0 ; i<max; i++){
			lst_int[i] = Integer.parseInt(lst[i], 2);
		}
		
		return lst_int;
	}
	
	public static String at(String str, int index){
		return str.substring(index, index+1);
	}
}
