


class hvitResept extends Resept{
    protected int Id;
    hvitResept(lege ansvarligLege, int Reit, Legemiddel legemiddel, pasient pasient){
        super(ansvarligLege, Reit, legemiddel, pasient);
        this.farge = "hvit";
        
    }
    public String toString(){
        return super.toString();
    }
}
