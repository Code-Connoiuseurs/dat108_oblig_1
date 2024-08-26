package no.hvl.dat108.oppgaver;

import java.lang.foreign.Linker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import no.hvl.dat108.andre.Ansatt;
import no.hvl.dat108.andre.Kjonn;

public class Oppgave_3 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = List.of(
			new Ansatt("Bjarne", "Son", Kjonn.Mann, "Fiberlegger", 1_000),
			new Ansatt("Bjarne", "Son", Kjonn.Mann, "Junior utvikler", 100_000),
			new Ansatt("Bjarne", "Son", Kjonn.KVINNE, "Sjef", 1_000_000),
			new Ansatt("Bjarne", "Son", Kjonn.KVINNE, "Fiberlegger", 400_000),
			new Ansatt("Olaug", "Bollestad", Kjonn.KVINNE, "Kristen", 666_666)
		);
		// a)
		List<String> etternavn = ansatte.stream().map(t -> t.etternavn).toList();
		System.out.println("a) Etternavn: " + etternavn);
		
		// b)
		long antallKvinner = ansatte.stream().filter(t -> t.kjonn == Kjonn.KVINNE).count();
		System.out.println("b) Antall kvinner: " + antallKvinner);
		
		// c)
		int totalLonn = ansatte.stream().map(t -> t.aarslonn).reduce(0, (a,b) -> a+b);
		double gjennomsnittligLonn = (double) totalLonn / ansatte.size();
		System.out.println("c) Gjennomsnittlig lønn" + gjennomsnittligLonn);
		
		// d)
		ansatte.stream().forEach(t -> {
			if (t.stilling.toLowerCase().contains("sjef")) {
				t.aarslonn *= 1.07;
			}
		});
		System.out.println("d) Alle ansatte: ");
		Oppgave_2.skrivUt(ansatte);
		
		// e)
		boolean noenOver800_000 = ansatte.stream().anyMatch(t -> t.aarslonn > 800_000);
		System.out.println("e) Noen tjener over 800_000: " + noenOver800_000);
		
		// f)
		System.out.println("f) Alle ansatte: ");
		ansatte.stream().forEach(t -> System.out.println(t.toString()));
		
		// g)
		System.out.println("g) Ansatte med lavest lønn: ");
		Ansatt minstLonnet = ansatte.stream().min((o1, o2) -> Integer.compare(o1.aarslonn, o2.aarslonn)).orElse(null);
		System.out.println(minstLonnet != null ? minstLonnet.toString() : "Ingen ansatt");
		
		// h)
		List<Integer> tall = new ArrayList<Integer>();
		for (int i=1;i<=1000;i++) {
			tall.add(i);
		}
		
		Predicate<Integer> deleligMed3 = t -> t % 3 == 0;
		Predicate<Integer> deleligMed5 = t -> t % 5 == 0;
		
		int sum = tall.stream().filter(deleligMed3.or(deleligMed5)).reduce(0, Integer::sum);
		System.out.println("h) Sum av tall mellom 1-1000 delelig på 3 eller 5: " + sum);
	}
	
}
