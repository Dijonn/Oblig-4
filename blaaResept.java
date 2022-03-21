

class blaaResept extends Resept{
    blaaResept( lege ansvarligLege, int Reit, Legemiddel legemiddel, pasient pasient){
        super( ansvarligLege, Reit, legemiddel, pasient);
        this.farge = "blaa";
    }
    public String toString(){
        return super.toString();
    }

    public String farge(){
        return "blaa";
    }

    public int prisAaBetale(){
        int pris = Legemiddel.hentPris();
        int prisRabatt = (int) (Math.ceil(pris/4));
        return prisRabatt;
    }
}
