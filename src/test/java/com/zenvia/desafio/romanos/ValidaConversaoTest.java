package com.zenvia.desafio.romanos;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class ValidaConversaoTest {

	private static List<String> linhasDoArquivo = new ArrayList<String>();

	@BeforeClass
	public static void setUp() throws IOException, Exception {

		/**
		 * Lista de conversão extraído de: https://fazaconta.com/calculadora-romanos.htm
		 * Arquivo com a conversão de 1 até 3000.
		 */
		URL url = ValidaConversaoTest.class.getResource("../../../../numeros_romanos.txt");
		Path pathFile = Paths.get(url.toURI());
		linhasDoArquivo = Files.readAllLines(pathFile, StandardCharsets.UTF_8);
	}

	/**
	 * Valida conversões dos valores de 1 até 3000.
	 */
	@Test
	public void validaCorrecaoConversaoTest() {

		for (String linha : linhasDoArquivo) {

			String[] algarismos = linha.split(",");

			Arabico arabico = new Arabico(Integer.valueOf(algarismos[0]));
			Romano romano = new Romano(algarismos[1]);
			
			// arabico para romano
			assertEquals(algarismos[1], arabico.toRomano());

			// romano para arabico
			assertEquals(Integer.valueOf(algarismos[0]), romano.toArabico());
		}
	}
}
