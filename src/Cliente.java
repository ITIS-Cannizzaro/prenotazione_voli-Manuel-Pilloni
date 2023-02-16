import java.util.Scanner;
public class Cliente extends Persona{
	Scanner in= new Scanner(System.in);
	Scanner input= new Scanner(System.in);
	String nome, cognome;
	
	public Cliente(String nome, String cognome) {
		this.nome= nome;
		this.cognome= cognome;
	}
	
	void Pren(Agente agente, int posti) {
		Prenotazione[] combinazioni= Agente.combinazioniClienti(posti);
		System.out.println("I possibli viaggi da poter prenotare sono: \nPRIMO VIAGGIO\n" + combinazioni[0].toString() + "\nSECONDO VIAGGIO\n" + combinazioni[1].toString() + "\nTERZO VIAGGIO\n" + combinazioni[2].toString());
		System.out.println("Scegli da 1 a 3, quanti viaggi vuoi prenotare: ");
		int cont= in.nextInt();
		switch(cont) {
			case 1:
				System.out.println("Quale viaggio vuoi scegliere? 1, 2 o 3: ");
				int temp= in.nextInt();
				temp -= 1;
				Prenotazione pren= combinazioni[temp];
				agente.ConfPren(pren);
				break;
			case 2:
				int[] temp2= new int[2];
				System.out.println("Quale viaggio vuoi scegliere? 1, 2 o 3: ");
				temp2[0]= in.nextInt();
				System.out.println("Quale viaggio vuoi scegliere? 1, 2 o 3: ");
				temp2[1]= in.nextInt();
				temp2[0] -= 1;
				temp2[1] -= 1;
				Prenotazione pren2= combinazioni[temp2[0]];
				Prenotazione pren3= combinazioni[temp2[1]];
				agente.ConfPren(pren2);
				agente.ConfPren(pren3);
				break;
			case 3:
				int[] temp3= new int[3];
				System.out.println("Quale viaggio vuoi scegliere? 1, 2 o 3: ");
				temp3[0]= in.nextInt();
				System.out.println("Quale viaggio vuoi scegliere? 1, 2 o 3: ");
				temp3[1]= in.nextInt();
				System.out.println("Quale viaggio vuoi scegliere? 1, 2 o 3: ");
				temp3[2]= in.nextInt();
				temp3[0] -= 1;
				temp3[1] -= 1;
				temp3[2] -= 1;
				Prenotazione pren4= combinazioni[temp3[0]];
				Prenotazione pren5= combinazioni[temp3[1]];
				Prenotazione pren6= combinazioni[temp3[2]];
				agente.ConfPren(pren4);
				agente.ConfPren(pren5);
				agente.ConfPren(pren6);
				break;
		}
	}
	
	void disdPren() {
		System.out.println("Inserisci il nome della prenotazione che vuoi disdire: ");
		String nome= input.nextLine();
		nome= nome.toLowerCase();
		System.out.println("Inserisci il cognome della prenotazione che vuoi disdire: ");
		String cognome= input.nextLine();
		cognome= cognome.toLowerCase();
		System.out.println("Se l'operazione andrà a buon fine verrà scritto successivamente. Se non dovesse accadere hai inserito dati errati!");
		for(int i= 0; i < Prenotazione.storico.size(); i++) {
			if(nome.equals(Prenotazione.storico.get(i).nome) && cognome.equals(Prenotazione.storico.get(i).cognome)) {
				Prenotazione.storico.remove(i);
				System.out.println("Prenotazione rimossa con successo!");
				break;
			}else
				continue;
		}
	}
}