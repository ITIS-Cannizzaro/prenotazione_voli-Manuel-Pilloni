import java.util.ArrayList;
public class Agente extends Persona{
	String partenza, destinazione, classe;
	double costo;
	int posti;
	double ConfPren(Prenotazione pren) {
		this.partenza= pren.partenza;
		this.destinazione= pren.destinazione;
		this.classe= pren.classe.toLowerCase();
		StoricoPren(pren);
		if(classe.equals("prima"))
			costo=1000+(int)(Math.random()*200);
		else if(classe.equals("seconda"))
			costo= 600+(int)(Math.random()*100);
		pren.costo= costo;
		return costo;
	}
	
	void StoricoPren(Prenotazione pren) {
		Prenotazione.storico.add(pren);
	}
	
	ArrayList<Prenotazione> getStorico(){
		return Prenotazione.storico;
	}
	
	public String toString() {
		double prezzoMedio= 0, prezzoMin= 0, prezzoMax= 0;
		String personaMin="", personaMax= "";
		for(int i= 0; i < Prenotazione.storico.size(); i++) {
			prezzoMedio += Prenotazione.storico.get(i).costo;
			
			if(Prenotazione.storico.get(i).costo < prezzoMin) {
				prezzoMin= Prenotazione.storico.get(i).costo;
				personaMin= Prenotazione.storico.get(i).nome + " " + Prenotazione.storico.get(i).cognome;
			}
			
			if(Prenotazione.storico.get(i).costo > prezzoMax) {
				prezzoMax= Prenotazione.storico.get(i).costo;
				personaMax= Prenotazione.storico.get(i).nome + " " + Prenotazione.storico.get(i).cognome;
			}
		}
		prezzoMedio= prezzoMedio/Prenotazione.storico.size();
		return "Prezzo medio: " + prezzoMedio + "\nNome cliente che ha spesi di meno: " + personaMin + "\nNome cliente che ha speso di piÃ¹: " + personaMax;
	}
	
	static Prenotazione[] combinazioniClienti(int posti) {
		String[] citta= {"Milano", "Roma", "Africo", "Parigi", "Barcellona", "Madrid", "Alberobello", "Foggia", "Hong Kong", "Tokyo", "Palermo", "Catanzaro", "New York", "Los Angels"};
		String[] classe= {"prima", "seconda"};
		Prenotazione uno= new Prenotazione(citta[(int)(Math.random()*citta.length)], citta[(int)(Math.random()*citta.length)], classe[(int)(Math.random()*classe.length)], posti);
		Prenotazione due= new Prenotazione(citta[(int)(Math.random()*citta.length)], citta[(int)(Math.random()*citta.length)], classe[(int)(Math.random()*classe.length)], posti);
		Prenotazione tre= new Prenotazione(citta[(int)(Math.random()*citta.length)], citta[(int)(Math.random()*citta.length)], classe[(int)(Math.random()*classe.length)], posti);
		Prenotazione[] combinazioni= {uno, due, tre};
		return combinazioni;
	}
}