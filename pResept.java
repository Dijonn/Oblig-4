

class pResept extends hvitResept{
    pResept( lege ansvarligLege, int reit, Legemiddel legemiddel, pasient pasient){
        super(ansvarligLege, reit, legemiddel, pasient);   
        if(legemiddel.hentPris() -108 > 0){
            this.Pris =legemiddel.hentPris() -108;
        } else{
            this.Pris = 0;
        }
    }
    public String toString(){
        return super.toString();
    }
}