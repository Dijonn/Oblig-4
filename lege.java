//Klasse lege som sammenligner og holder data om leger

class lege implements Comparable<lege> {
    String navn;
    lege(String navn) {
        this.navn = navn;
    }
    public String toString() {
        return "Navn: " + navn;
    }
    
    public String hentNavn() {
        return navn;
    }

    public int compareTo(lege x){
        return x.hentNavn().compareTo(this.navn);
    }

    IndeksertListe<Resept> utskrevneResepter = new IndeksertListe<>();

    public void skrivUtResepter() {
        for(Resept x: utskrevneResepter) {
            System.out.println(x + " her er reseptene til legen");
            System.out.println("er dette leggtil eller settinn?????");
        }
    }
}


