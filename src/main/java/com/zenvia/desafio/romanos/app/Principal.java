package com.zenvia.desafio.romanos.app;

import com.zenvia.desafio.romanos.Arabico;
import com.zenvia.desafio.romanos.Romano;

public class Principal {

	public static void main(String[] args) {

		Arabico a = new Arabico(2428);
		System.out.println(a.toRomano());
		
		Romano r = new Romano("MMCDXXVIII");
		System.out.println(r.toArabico());	
	}
}
