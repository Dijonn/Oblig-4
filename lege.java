
class lege implements Comperable<Lege>{
    String navn;
    lege(String navn){
        this.navn = navn;
    }
    public String toString(){
        return "Navn: " + navn;
    }
    
    public String hentNavn(){
        return navn;
    }
    
    public int compareTo(Lege x){
        return x.hentNavn().compareTo(this.navn);
    }
}
