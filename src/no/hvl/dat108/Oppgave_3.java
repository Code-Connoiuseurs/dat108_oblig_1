package no.hvl.dat108;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import no.hvl.dat108.Ansatt.Kjonn;
import no.hvl.dat108.Ansatt;

public class Oppgave_3 {

	public static void main(String[] args) {
		List<Ansatt> ansattListe = List.of(
				new Ansatt("Abel","Gabel", Kjonn.MANN, "iskrem man", 50000),
				new Ansatt("Snubble","Dubble", Kjonn.MANN, "trappe tester", 20000),
				new Ansatt("Grace","Queen", Kjonn.KVINNE, "sjef", 135000),
				new Ansatt("Gobble","Gobble", Kjonn.MANN, "smaks tester", 40000),
				new Ansatt("Elizabeth","Olsen", Kjonn.KVINNE, "kjendis", 140703)
				);
			
		// a)
		List<String> etternavnListe = ansattListe.stream().map(p -> p.etternavn).toList();
			System.out.println("Liste av ansatte ved etternavn " + etternavnListe);
				
			
		// b)
		long antallKvinner = ansattListe.stream().filter(p -> p.getKjonn() == Kjonn.KVINNE).count();
			System.out.println("antall kvinner i listen : " + antallKvinner);
				
		// c) 
		double kvinneTotalLonn = ansattListe.stream().filter(p -> p.getKjonn() == Kjonn.KVINNE).mapToInt(Ansatt::getAarsLonn).sum();
		double gjennomSnittLonn = kvinneTotalLonn / antallKvinner;
			System.out.println("Gjennomsnitts lønn til kvinner : " + gjennomSnittLonn + "\n");
				
		// d)
		ansattListe.stream().forEach(p -> {
			if(p.stilling.contains("sjef")) {
				p.aarsLonn *= 1.07;
			}
		});
		Oppgave_2.skrivUtAlle(ansattListe);
			
		// e)
		boolean ansattOverLonn = ansattListe.stream().anyMatch(p -> p.getAarsLonn() > 800_000);
			System.out.println("\nTrue hvis noen har mer enn 800k års lønn : " + ansattOverLonn);
				
		// f)
		System.out.println();
			ansattListe.stream().forEach(System.out::println);	
			
		// g)
		Optional<Ansatt> minsteLonn = ansattListe.stream().min(Comparator.comparingInt(Ansatt::getAarsLonn));
			minsteLonn.ifPresent(a -> System.out.println("\narbeider med minst lønn : " + a));
				
		// h)
		int sum = IntStream.range(1, 1000).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
			System.out.println("\nSum av heltall 1 til 1000 som kan deles på 3 eller 5 = " + sum);
			
	}
}
