package no.hvl.dat108;

import oppgave2.Ansatt.Kjonn;

public class Ansatt {

	public enum Kjonn {
		MANN, KVINNE
	}
	
	public String fornavn;
	public String etternavn;
	public Kjonn kjonn;
	public String stilling;
	public int aarsLonn;
	
	public Ansatt(String fornavn, String etternavn, Kjonn kjonn, String stilling, int aarsLonn) {
		super();
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
		this.stilling = stilling;
		this.aarsLonn = aarsLonn;
	}

	public String getFornavn() {
		return fornavn;
	}
	
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	
	public String getEtternavn() {
		return etternavn;
	}
	
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	
	public Kjonn getKjonn() {
		return kjonn;
	}
	
	public void setKjonn(Kjonn kjonn) {
		this.kjonn = kjonn;
	}
	
	public String getStilling() {
		return stilling;
	}
	
	public void setStilling(String stilling) {
		this.stilling = stilling;
	}
	
	public int getAarsLonn() {
		return aarsLonn;
	}
	
	public void setAarsLonn(int aarslonn) {
		this.aarsLonn = aarslonn;
	}

	@Override
	public String toString() {
		return "Ansatt [fornavn = " + fornavn + ", etternavn = " + etternavn + ", kjonn = " + kjonn + ", stilling = " + stilling
				+ ", aarslonn = " + aarsLonn + "]";
	}
}
