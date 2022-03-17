public class pasient {
    protected String navn;
    protected String foedselsnummmer;
    static protected int idteller; 
    protected int id;

    public pasient(String navn, String foedselsnummer){
        this.navn = navn;
        this.foedselsnummmer = foedselsnummer;
        idteller +=1;
        id = idteller;
    }

    public String toString(){
        return ("Navn: " + this.navn + "\n"+ "Foedselsnummer: " + this.foedselsnummmer + "\n" + "ID: " + this.id + "\n");
    }
}