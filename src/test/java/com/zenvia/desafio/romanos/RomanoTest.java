package com.zenvia.desafio.romanos;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.zenvia.desafio.romanos.conversao.TabelaConversaoEnum;

public class RomanoTest {

	@Test
	public void validaConstrutorTest() {
		Romano romano = new Romano("I");

		assertEquals(romano.getNumero(), "I");

		/*
		 * assertEquals("", romano.getUnidade()); assertEquals("", romano.getDezena());
		 * assertEquals("", romano.getCentena()); assertEquals("", romano.getMilhar());
		 */
	}

	@Test
	public void conversaoParaArabicoSubtracaoTest() {
		List<String> romanoFormadoSubtracao = TabelaConversaoEnum.getListaRomanosFormadoSubtracao();	
		for (String romano : romanoFormadoSubtracao) {
			Romano r = new Romano(romano);
			assertEquals(TabelaConversaoEnum.getValorArabico(romano), r.toArabico());
		}
	}

	@Test
	public void conversaoParaArabicoTabelaTest() {
		List<String> romanosDaTabela = TabelaConversaoEnum.getListaRomanos();
		for (String romano : romanosDaTabela) {
			Romano r = new Romano(romano);
			assertEquals(TabelaConversaoEnum.getValorArabico(romano), r.toArabico());
		}
	}
	
	@Test
	public void validaTamanhoInvalidoCaracteresTest() {
		//maior número romano (tamanho de caracteres) de 1 até 3000: MMDCCCLXXXVIII
		Romano r = new Romano("MMDCCCLXXXVIII");
		assertEquals(r.getNumero(), "MMDCCCLXXXVIII" );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validaTamanhoValidoCaracteresTest() {
		new Romano("MMDCCCLXXXVIIII");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validaConstrutroCaracterVazioTest() {
		new Romano("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void validaConstrutroCaracterPermitidosTest() {
		new Romano("XVP");
	}
}
