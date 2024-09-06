package no.hvl.dat108.oppgaver;

import java.util.Collection;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import no.hvl.dat108.andre.Ansatt;
import no.hvl.dat108.andre.Kjonn;

public class Oppgave_3 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = List.of(
			new Ansatt("Bjarne", "Son", Kjonn.MANN, "Fiberlegger", 100_000),
			new Ansatt("Scum", "Masterson", Kjonn.MANN, "Scrum master", 100_000),
			new Ansatt("Dronning", "Sonja", Kjonn.KVINNE, "Sjef", 1_000_000),
			new Ansatt("Aurora", "Aksnes", Kjonn.KVINNE, "Synger", 400_000),
			new Ansatt("Olaug", "Bollestad", Kjonn.KVINNE, "Kristen", 666_666)
		);
		
		// a)
		List<String> etternavn = ansatte.stream().map(t -> t.etternavn).toList();
		System.out.println("a) Etternavn: " + etternavn);
		
		// b)
		long antallKvinner = ansatte.stream().filter(t -> t.kjonn == Kjonn.KVINNE).count();
		System.out.println("b) Antall kvinner: " + antallKvinner);
		
		// c)
		int totalLonn = ansatte.stream().map(t -> t.aarslonn).reduce(0, Integer::sum);
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
		ansatte.stream().forEach(System.out::println);
		
		// g)
		System.out.println("g) Ansatte med lavest lønn: ");
		Ansatt minstLonnet = ansatte.stream().min((o1, o2) -> Integer.compare(o1.aarslonn, o2.aarslonn)).orElseThrow();
		List<Ansatt> minstLønnede = ansatte.stream().filter(t -> t.aarslonn == minstLonnet.aarslonn).toList();
		System.out.println(minstLønnede);
		
		// h)
		IntStream tallStroem = IntStream.rangeClosed(1, 1000);
		
		IntPredicate deleligMed3 = t -> t % 3 == 0;
		IntPredicate deleligMed5 = t -> t % 5 == 0;
		
		int sum = tallStroem.filter(deleligMed3.or(deleligMed5)).sum();
		System.out.println("h) Sum av tall mellom 1-1000 delelig på 3 eller 5: " + sum);
	}
}
