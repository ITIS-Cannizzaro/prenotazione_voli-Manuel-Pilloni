import java.util.ArrayList;
public class Prenotazione {
	static ArrayList<Prenotazione> storico= new ArrayList();
	String partenza, destinazione, classe, nome, cognome;
	double costo;
	int posti;
	public Prenotazione(String nome, String cognome, String partenza, String destinazione, String classe) {
		this.nome= nome;
		this.cognome= cognome;
		this.partenza= partenza;
		this.destinazione= destinazione;
		this.classe= classe;
	}
	
	public Prenotazione(String partenza, String destinazione, String classe, int posti) {
		this.partenza= partenza;
		this.destinazione= destinazione;
		this.classe= classe;
		this.posti= posti;
	}
	
	public String toString() {
		return "Partenza: " + partenza + "\nDestinazione: " + "\nClasse: " + classe;
	}
}