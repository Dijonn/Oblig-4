

class MilitaerResept extends hvitResept{
    MilitaerResept( lege ansvarligLege, Legemiddel legemiddel, pasient pasient){
        super(ansvarligLege, 3, legemiddel, pasient);
        this.Pris = 0;
    }
    public String toString(){
        return super.toString();
    }
}
