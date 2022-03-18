
abstract class Legemiddel{
    final protected String navn;
    protected int pris;
    final protected double virkestoff;
    protected static int Id = 1;
    protected int egenId; 
    public String toString(){
        return "Navn:" + this.hentNavn() + "\npris:" + this.hentPris() + "\nVirkestoff:" + this.hentVirkestoff() + "\nId:" + this.hentId() + "\n";
    }

    Legemiddel(String navn, int pris, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        egenId = Id;
        Id++;
        
    }
    public int hentId(){
        return egenId;
    }
    public String hentNavn(){
        return this.navn;
    }
    public int hentPris(){
        return this.pris;
    }
    public double hentVirkestoff(){
        return this.virkestoff;
    }
    public void settNyPris(int pris){
        this.pris = pris;
    }
}
