package com.zenvia.desafio.romanos;

import static java.lang.String.join;
import static java.util.Collections.nCopies;

import com.zenvia.desafio.romanos.conversao.TabelaConversaoEnum;

/**
 * 
 * @author juliano
 *
 */
public class Arabico {

	private final Integer numero;

	public Arabico(final Integer numero) {
		if (numero <= 0 || numero > 3000) {
			throw new IllegalArgumentException("São permitidos números maiores que zero e até 3000.");
		}
		this.numero = numero;
	}

	public String toRomano() {
		Integer nroArabico = Integer.valueOf(this.numero);
		StringBuilder resultado = new StringBuilder();
		for (Integer itemArabicoDaTabela : TabelaConversaoEnum.getListaArabicos()) {
			String valorRomano = TabelaConversaoEnum.getValorRomano(itemArabicoDaTabela);
			int parteInteira = nroArabico / itemArabicoDaTabela;
			if (parteInteira > 0) {
				nroArabico -= itemArabicoDaTabela * parteInteira;
				resultado.append(join("", nCopies(parteInteira, valorRomano)));
			}
		}
		return resultado.toString();
	}

	public Integer getNumero() {
		return numero;
	}
}
