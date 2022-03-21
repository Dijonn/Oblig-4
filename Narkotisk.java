

class Narkotisk extends Legemiddel{
    int narkotiskStyrke; 
    Narkotisk(String navn, int pris, double virkestoff, int narkotiskStyrke) {
        super(navn, pris, virkestoff);
        this.narkotiskStyrke = narkotiskStyrke;
    }
    
    public String toString(){
        return super.toString() + "Narkotisk styrke:" + this.hentStyrke() + "\n";
    }
    public int hentStyrke(){
        return this.narkotiskStyrke;
    }

    public String hentType(){
        return "narkotisk";
    }

    public int prisAaBetale(){
        return this.pris;
    }
}