

public class spesialist extends lege implements godkjenningsFritak {
    String kontrollId;
    spesialist(String navn, String kontrollId){
        super(navn);
        this.kontrollId = kontrollId;
    }

    @Override
    public String hentKontrollId() {
        return this.kontrollId;
    }

    public String toString(){
        return this.navn + "; KontrollId:" + this.kontrollId;
    }
}   
