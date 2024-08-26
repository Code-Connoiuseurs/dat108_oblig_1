package no.hvl.dat108;

import java.util.List;
import java.util.function.Function;

import no.hvl.dat108.Ansatt.Kjonn;

public class Oppgave_2 {

	public static void main(String[] args) {
		
		List<Ansatt> ansattListe = List.of(
				new Ansatt("Abel","Gabel", Kjonn.MANN, "Iskrem man", 50000),
				new Ansatt("Snubble","Dubble", Kjonn.MANN, "trappe tester", 20000),
				new Ansatt("Grace","Queen", Kjonn.KVINNE, "sjef", 100000),
				new Ansatt("Gobble","Gobble", Kjonn.MANN, "smaks tester", 40000)
				);
				
	Function<Ansatt, Integer> tillegg = ansatt -> ansatt.getAarslonn() + 2000;
	
	Function<Ansatt, Integer> prosentTillegg = ansatt -> (int) (ansatt.getAarslonn() * 1.05);
	
	Function<Ansatt, Integer> lavLonnTillegg = ansatt -> ansatt.getAarslonn() + (ansatt.getAarslonn() < 30000 ? 6500 : 0);
	
	Function<Ansatt, Integer> prosetTilleggMann = ansatt -> (int) (ansatt.getAarslonn() * 1.1);
	
	lonnsoppgjor(ansattListe, tillegg);
		System.out.println("etter tillegg");
	skrivUtAlle(ansattListe);
	
	System.out.println();
	
	lonnsoppgjor(ansattListe, prosentTillegg);
		System.out.println("etter prosent tillegg");
	skrivUtAlle(ansattListe);
	
	System.out.println();
	
	lonnsoppgjor(ansattListe, lavLonnTillegg);
		System.out.println("etter lav lønn tillegg");
	skrivUtAlle(ansattListe);
	
	System.out.println();
	
	lonnsoppgjor(ansattListe, prosetTilleggMann);
		System.out.println("etter prosent tillegg til menn");
	skrivUtAlle(ansattListe);
	}
	
	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> beregnNyLonn) {
		for(Ansatt ansatt : ansatte) {
			int nyLonn = beregnNyLonn.apply(ansatt);
			ansatt.setAarslonn(nyLonn);
		}
	}
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		for(Ansatt ansatt : ansatte) {
			System.out.println(ansatt);
		}
	}
}

