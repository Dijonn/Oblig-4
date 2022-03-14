public class Pasient {
    protected String navn;
    protected String foedselsnummmer;
    static protected int idteller; 
    protected int id;

    public Pasient(String navn, String foedselsnummer){
        this.navn = navn;
        this.foedselsnummmer = foedselsnummer;
        idteller +=1;
        id = idteller;
    }
}
