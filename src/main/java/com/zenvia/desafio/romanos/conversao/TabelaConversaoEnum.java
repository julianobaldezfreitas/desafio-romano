package com.zenvia.desafio.romanos.conversao;

import java.util.ArrayList;
import java.util.List;

/**
 * Tabela de conversão entre algarismos arábicos
 * e romanos.
 * 
 * Possui os elementos necessários para realizar a conversão:
 * 
 * <li>representação em arábico</li>
 * <li>representação em romano</li>
 * <li>indicação se o romano é formado por subtração</li>
 * 
 * @author juliano
 *
 */
public enum TabelaConversaoEnum {
	MIL(1000, "M", false),
	NOVECENTOS(900, "CM", true),
	QUINHETOS(500, "D", false),
	QUATROCENTOS(400, "CD", true),
	CEM(100, "C", false),
	NOVENTA(90, "XC", true),
	CINQUENTA(50, "L", false),
	QUARENTA(40, "XL", true),
	DEZ(10, "X", false),
	NOVE(9, "IX", true),
	CINCO(5, "V", false),
	QUATRO(4, "IV", true),
	UM(1, "I", false);

	private Integer arabico;
	private String romano;
	private boolean isSubtracao;

	private TabelaConversaoEnum(final Integer arabico, final String romano, final boolean isSubtracao) {
		this.romano = romano;
		this.arabico = arabico;
		this.isSubtracao = isSubtracao;
	}


	/**
	 * Retorna o valor arábico de um número romano pertencente 
	 * a tabela de conversão.
	 * 
	 * Exemplo: X -> 10
	 * 
	 * @param romano
	 * @return número arábico correspondente. 
	 * null caso não tenha conversão na tabela.
	 */
	public static Integer getValorArabico(String romano) {
		for (TabelaConversaoEnum e : values()) {
			if (e.romano.equals(romano)) {
				return e.arabico;
			}
		}
		return null;
	}
	
	/**
	 * Retorna o valor romano de um número arábico pertencente 
	 * a tabela de conversão.
	 * 
	 * Exemplo: 5 -> V
	 * 
	 * @param arabico
	 * @return  número romano correspondente. 
	 * null caso não tenha conversão na tabela.
	 */
	public static String getValorRomano(Integer arabico) {
		for (TabelaConversaoEnum e : values()) {
			if (e.arabico.equals(arabico)) {
				return e.romano;
			}
		}
		return null;
	}

	/**
	 * Retorna uma lista com todos os algarismos arábicos
	 * da tabela de conversão.
	 * 
	 * @return lista de números arábicos da tabela de conversão.
	 */
	public static List<Integer> getListaArabicos() {
		List<Integer> algarismosArabicos = new ArrayList<Integer>();
		for (TabelaConversaoEnum e : values()) {
			algarismosArabicos.add(e.arabico);
		}
		return algarismosArabicos;
	}

	/**
	 * Retorna uma lista com todos os algarismos romanos
	 * da tabela de conversão.
	 * 
	 * @return lista de números romanos da tabela de conversão.
	 */
	public static List<String> getListaRomanos() {
		List<String> algarismosArabicos = new ArrayList<String>();
		for (TabelaConversaoEnum e : values()) {
			algarismosArabicos.add(e.romano);
		}
		return algarismosArabicos;
	}
	
	/**
	 * Retorna se um algarismo romano é formado por subtração
	 * conforme tabela de conversão.
	 * 
	 * @param romano
	 * @return verdadeiro se é formado por subtracao, caso contrário retorna falso.
	 */
	public static Boolean isFormadoSubtracao(String romano) {
		for (TabelaConversaoEnum e : values()) {
			if (e.romano.equals(romano)) {
				return e.isSubtracao;
			}
		}
		return false;
	}
	
	/**
	 * Retornar a lista de números arábicos da tabela que são
	 * formados por subtração quando representados em algarismos
	 * romanos.
	 * 
	 * @return lista de números arábicos.
	 */
	public static List<Integer> getListaArabicosFormadoSubtracao() {
		List<Integer> algarismosArabicos = new ArrayList<Integer>();
		for (TabelaConversaoEnum e : values()) {
			if(e.isSubtracao) {
				algarismosArabicos.add(e.arabico);	
			}
		}
		return algarismosArabicos;
	}
	
	/**
	 * Retornar a lista de números romanos da tabela que são
	 * formados por subtração.
	 * 
	 * @return lista de números romanos.
	 */
	public static List<String> getListaRomanosFormadoSubtracao() {
		List<String> algarismosArabicos = new ArrayList<String>();
		for (TabelaConversaoEnum e : values()) {
			if(e.isSubtracao) {
				algarismosArabicos.add(e.romano);	
			}
		}
		return algarismosArabicos;
	}
}
