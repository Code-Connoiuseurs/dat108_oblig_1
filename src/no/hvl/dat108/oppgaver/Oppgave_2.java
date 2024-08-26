package no.hvl.dat108.oppgaver;

import java.util.List;
import java.util.function.Consumer;

import no.hvl.dat108.andre.Ansatt;
import no.hvl.dat108.andre.Kjonn;

public class Oppgave_2 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = List.of(
				new Ansatt("Bjarne", "Son", Kjonn.MANN, "Fiberlegger", 100_000),
				new Ansatt("Scum", "Masterson", Kjonn.MANN, "Scrum master", 100_000),
				new Ansatt("Dronning", "Sonja", Kjonn.KVINNE, "Sjef", 1_000_000),
				new Ansatt("Aurora", "Aksnes", Kjonn.KVINNE, "Synger", 400_000),
				new Ansatt("Olaug", "Bollestad", Kjonn.KVINNE, "Kristen", 666_666)
		);
		lonnsoppgjor(ansatte, a -> a.aarslonn += 1);
		skrivUt(ansatte);
	}
	
	public static void lonnsoppgjor(List<Ansatt> ansatte, Consumer<Ansatt> algo) {
		 for (Ansatt ansatt : ansatte) {
			 algo.accept(ansatt);
		 }
	}
	
	public static void skrivUt(List<Ansatt> ansatte) {
		for (Ansatt ansatt : ansatte) {
			System.out.println(ansatt.toString());
		}
	}
	
}
