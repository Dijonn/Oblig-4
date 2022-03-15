//Klasse lege som sammenligner og holder data om leger

class lege implements Comparable<lege>{
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
    
    public int compareTo(lege x){
        return x.hentNavn().compareTo(this.navn);
    }
}


