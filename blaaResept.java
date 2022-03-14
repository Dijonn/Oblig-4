

class blaaResept extends Resept{
    blaaResept( lege ansvarligLege, int Reit, Legemiddel legemiddel, pasient pasient){
        super( ansvarligLege, Reit, legemiddel, pasient);
        this.Pris = (int) Math.ceil(legemiddel.hentPris()*0.25);
        this.farge = "blaa";
    }
    public String toString(){
        return super.toString();
    }
}
