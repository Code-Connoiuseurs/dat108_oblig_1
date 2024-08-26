package no.hvl.dat108.oppgaver;

import java.util.List;
import java.util.function.Consumer;

import no.hvl.dat108.andre.Ansatt;
import no.hvl.dat108.andre.Kjonn;

public class Oppgave_2 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = List.of(
			new Ansatt("Bjarne", "Son", Kjonn.Mann, "Fiberlegger", 3),
			new Ansatt("Bjarne", "Son", Kjonn.Mann, "Fiberlegger", 3),
			new Ansatt("Bjarne", "Son", Kjonn.Mann, "Fiberlegger", 3),
			new Ansatt("Bjarne", "Son", Kjonn.Mann, "Fiberlegger", 3),
			new Ansatt("Bjarne", "Son", Kjonn.Mann, "Fiberlegger", 3)
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
