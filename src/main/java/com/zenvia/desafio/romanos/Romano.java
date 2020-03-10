package com.zenvia.desafio.romanos;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.zenvia.desafio.romanos.conversao.TabelaConversaoEnum;

/**
 * 
 * @author juliano
 *
 */
public class Romano {

	private final String numero;

	public Romano(final String numero) {
		this.numero = numero;
		validaFormatoRomano();
	}
	
	public String getNumero() {
		return numero;
	}

	public Integer toArabico() {
		Integer nroArabico = 0;
		List<String> listaRomanosSubtracao = new ArrayList<String>();

		for (String itemRomanoDaTabela : TabelaConversaoEnum.getListaRomanos()) {
			if (this.numero.contains(itemRomanoDaTabela)) {
				int nroOcorrencias = StringUtils.countMatches(this.numero, itemRomanoDaTabela);
				nroArabico += calculaNroArabico(nroOcorrencias, itemRomanoDaTabela);

				if (TabelaConversaoEnum.isFormadoSubtracao(itemRomanoDaTabela)) {
					listaRomanosSubtracao.add(itemRomanoDaTabela);
				}

			} else {
				continue;
			}
		}
		nroArabico -= subtraiNroArabico(listaRomanosSubtracao);
		return nroArabico;
	}

	private Integer subtraiNroArabico(List<String> romanosSubtracao) {
		Integer nroArabico = 0;
		for (String romano : romanosSubtracao) {
			char[] subtrair = romano.toCharArray();
			for (int x = 0; x < subtrair.length; x++) {
				nroArabico += TabelaConversaoEnum.getValorArabico(Character.toString(subtrair[x]));
			}
		}
		return nroArabico;
	}

	private Integer calculaNroArabico(Integer nroOccurRomano, String nroRomanoDaTabela) {
		int nroArabico = 0;
		int vlrArabico = TabelaConversaoEnum.getValorArabico(nroRomanoDaTabela) * nroOccurRomano;
		nroArabico += vlrArabico;
		return nroArabico;
	}

	private void validaTamanhoRomano(String romano) {
		if (romano.isEmpty() || romano.length() > 14) {
			throw new IllegalArgumentException("Caracteres romanos suportados do 1 ao 3000. Máximo de caracteres: 14.");
		}
	}

	private void validaCaracteresValidos(String romano) {
		Pattern p = Pattern.compile("[MCDXLIV]");
		Matcher matcher = p.matcher(romano);

		int cont = 0;
		while (matcher.find()) {
			cont++;
		}

		if (cont != romano.length()) {
			throw new IllegalArgumentException("Caracteres permitidos: M, C, D, X, L, I e V");
		}
	}

	private void validaFormatoRomano() {
		validaTamanhoRomano(this.numero);
		validaCaracteresValidos(this.numero);
	}
}
