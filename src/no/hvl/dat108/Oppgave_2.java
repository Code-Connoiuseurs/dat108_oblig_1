package no.hvl.dat108;

import java.util.List;
import java.util.function.Function;

public class Oppgave_2 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = List.of(new Ansatt("Walter", "White", Kjonn.MANN, "Laerer", 100_000_000),
				new Ansatt("Ned", "Flanders", Kjonn.MANN, "Selger", 290_000),
				new Ansatt("Ronny Brian", "Waghle", Kjonn.MANN, "Skytebas", 800_000),
				new Ansatt("Agnes", "MacGyver", Kjonn.KVINNE, "Agent", 1_000_000),
				new Ansatt("Barmfrid", "Hulgunnsen", Kjonn.KVINNE, "Barnevernspedagog", 595_000));

		System.out.println("i. Et fast kronetillegg:");
		lonnsoppgjor(ansatte, a -> a.getAarslonn() + 15000);
		skrivUt(ansatte);

		System.out.println("ii. Et fast prosenttillegg:");
		lonnsoppgjor(ansatte, a -> a.getAarslonn() + (a.getAarslonn() * 10 / 100));
		skrivUt(ansatte);

		System.out.println("iii. Et fast kronetillegg hvis du har lav loenn ( < 400 000 )");
		lonnsoppgjor(ansatte, a -> a.getAarslonn() < 500_000 ? a.getAarslonn() + 20_000 : a.getAarslonn());
		skrivUt(ansatte);

		System.out.println("iv. Et fast prosenttillegg hvis du er mann:");
		lonnsoppgjor(ansatte,
				a -> a.getKjonn().equals(Kjonn.MANN) ? a.getAarslonn() + a.getAarslonn() * 10 / 100 : a.getAarslonn());
		skrivUt(ansatte);
	}

	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> f) {
		for (Ansatt a : ansatte) {
			a.setAarslonn(f.apply(a));
		}
	}

	public static void skrivUt(List<Ansatt> ansatte) {
		for (Ansatt a : ansatte) {
			System.out.println(a.toString());
		}
	}
}
