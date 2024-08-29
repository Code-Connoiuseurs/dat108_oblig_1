package no.hvl.dat108;

import java.util.List;
import java.util.stream.IntStream;

public class Oppgave_3 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = List.of(new Ansatt("Walter", "White", Kjonn.MANN, "Laerer", 100_000_000),
				new Ansatt("Ned", "Flanders", Kjonn.MANN, "Selger", 290_000),
				new Ansatt("Ronny Brian", "Waghle", Kjonn.MANN, "Skytebas", 800_000),
				new Ansatt("Agnes", "MacGyver", Kjonn.KVINNE, "Sjefsagent", 1_000_000),
				new Ansatt("Barmfrid", "Hulgunnsen", Kjonn.KVINNE, "Barnevernspedagog", 595_000));
		// a)
		List<String> etternavn = ansatte.stream()
				.map(Ansatt::getEtternavn).toList();
		System.out.println("a) " + etternavn);

		// b)
		long antallKvinner = ansatte.stream()
				.filter(a -> a.getKjonn().equals(Kjonn.KVINNE))
				.count();
		System.out.println("b) " + antallKvinner);

		// c)
		double gjennomsnittslonnKvinner = ansatte.stream()
				.filter(a -> a.getKjonn().equals(Kjonn.KVINNE))
				.mapToDouble(Ansatt::getAarslonn)
				.average()
				.getAsDouble();
		System.out.println("c) " + gjennomsnittslonnKvinner);

		// d)
		ansatte.stream()
				.filter(a -> a.getStilling().toLowerCase().contains("sjef"))
				.forEach(a -> a.setAarslonn(a.getAarslonn() + (a.getAarslonn() * 7 / 100)));
		ansatte.stream().forEach(a -> System.out.println("d) " + a));
		
		// e) 
		System.out.println("e) " + ansatte.stream().anyMatch(a -> a.getAarslonn() > 800_000));		
		
		// f)
		ansatte.stream().forEach(a -> System.out.println("f) " + a));

		// g)
		int lavestLoenn = ansatte.stream().map(a -> a.getAarslonn()).min(Integer::compare).get();
		List<Ansatt> lavestLoennedeAnsatte = ansatte.stream().filter(a -> a.getAarslonn() <= lavestLoenn).toList();
		System.out.println("g) " + lavestLoennedeAnsatte);
		
		// h)
		System.out.println("h) " + IntStream.range(1, 1000).filter(i -> i % 3 == 0 || i % 5 == 0).sum());
	}

}
