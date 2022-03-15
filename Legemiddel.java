
abstract class Legemiddel{
    final protected String navn;
    protected int pris;
    final protected double virkestoff;
    protected static int Id = 1;
    int egenId; 
    public String toString(){
        return "navn:" + this.hentNavn() + " pris:" + this.hentPris() + " virkestoff:" + this.hentVirkestoff() + " id:" + this.hentId();
    }

    Legemiddel(String navn, int pris, double virkestoff){
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;
        egenId = Id;
        Id++;
    }
    public int hentId(){
        return Id;
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
