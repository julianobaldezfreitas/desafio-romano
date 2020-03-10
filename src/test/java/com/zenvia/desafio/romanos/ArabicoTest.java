package com.zenvia.desafio.romanos;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.zenvia.desafio.romanos.conversao.TabelaConversaoEnum;

public class ArabicoTest {

	@Test(expected = IllegalArgumentException.class)
	public void arabicoValorZeroTest() {
		new Arabico(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void arabicoValorMenorZeroTest() {
		new Arabico(-90);
	}

	@Test(expected = IllegalArgumentException.class)
	public void arabicoValorMaiorPermitidoTest() {
		new Arabico(3001);
	}

	@Test
	public void validaConstrutorTest() {
		Arabico arabico = new Arabico(2428);
		assertEquals(arabico.getNumero(), Integer.valueOf(2428));
	}

	@Test
	public void conversaoParaRomanoSubtracaoTest() {
		List<Integer> arabicosSubtracao = TabelaConversaoEnum.getListaArabicosFormadoSubtracao();
		for (Integer arabico : arabicosSubtracao) {
			Arabico a = new Arabico(arabico);
			assertEquals(TabelaConversaoEnum.getValorRomano(a.getNumero()), a.toRomano());
		}
	}

	@Test
	public void conversaoParaRomanoTabelaTest() {
		List<Integer> arabicosDaTabela = TabelaConversaoEnum.getListaArabicos();
		for (Integer arabico : arabicosDaTabela) {
			Arabico a = new Arabico(arabico);
			assertEquals(TabelaConversaoEnum.getValorRomano(a.getNumero()), a.toRomano());
		}
	}
}
