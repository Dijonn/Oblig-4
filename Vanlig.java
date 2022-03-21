

class Vanlig extends Legemiddel{
    Vanlig(String navn, int pris, double virkestoff){
        super(navn, pris, virkestoff);
    }
    public String toString(){
        return super.toString();
    }

    public int prisAaBetale(){
        return this.pris;
    }

    public String hentType(){
        return "vanlig";
    }
}