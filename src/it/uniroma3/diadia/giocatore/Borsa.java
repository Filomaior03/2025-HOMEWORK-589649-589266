package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (attrezzo == null)
			return false;
		
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		
		if (this.numeroAttrezzi==10)
			return false;
		
		int i = 0;
		for(Attrezzo posizione : this.attrezzi) {
			if(posizione == null) {
				this.attrezzi[i] = attrezzo;
				break;
			}
			i++;
		}
		this.numeroAttrezzi++;
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		
		for(Attrezzo attrezzo : this.attrezzi)
			if (attrezzo != null)
				if (attrezzo.getNome().equals(nomeAttrezzo))
					a = attrezzo;
		
//		for (int i= 0; i<this.numeroAttrezzi; i++)
//			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
//				a = attrezzi[i];
		return a;
	}


	public int getPeso() {
		int peso = 0;
		
		for(Attrezzo attrezzo : this.attrezzi)
			if (attrezzo != null)
				peso += attrezzo.getPeso();
				
//		for (int i= 0; i<this.numeroAttrezzi; i++)
//			peso += this.attrezzi[i].getPeso();
		
		
		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		
		if (nomeAttrezzo == "")
			return a;
		
		int i = 0;
		for(Attrezzo attrezzo : this.attrezzi) {
			if (attrezzo != null) {
				if (nomeAttrezzo.equals(attrezzo.getNome())) {
					a = attrezzo;
					this.attrezzi[i] = null;
					this.numeroAttrezzi--;
				}
			}
			i++;
		}
		return a;
	}

	public String toString() {
		StringBuilder s = new StringBuilder(); if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			
			for(Attrezzo attrezzo : this.attrezzi)
				if (attrezzo != null)
					s.append(attrezzo.toString() + " ");
			
//			for (int i= 0; i<this.numeroAttrezzi; i++)
//				s.append(attrezzi[i].toString()+" ");

		} else
			s.append("Borsa vuota");
		return s.toString();
	}
}

