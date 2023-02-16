public class Volo {
	double prezzo;
	String classe;
	
	Volo(String classe){
		this.classe= classe;
	}
	
	void setPrezzo(String classe) {
		classe= classe.toLowerCase();
		if(classe.equals("prima"))
			prezzo=1000;
		else if(classe.equals("seconda"))
			prezzo= 600;
		else
			System.out.println("Seleziona una classe corretta!");
	}
}