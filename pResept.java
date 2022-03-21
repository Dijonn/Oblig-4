

class pResept extends hvitResept{
    pResept( lege ansvarligLege, int reit, Legemiddel legemiddel, pasient pasient){
        super(ansvarligLege, reit, legemiddel, pasient);   
        
    }
    public String toString(){
        return super.toString();
    }

    public String farge(){
        return "p";
    }

    public int prisAaBetale(){
        if(Legemiddel.hentPris() -108 > 0){
            this.Pris =Legemiddel.hentPris() -108;
        } else{
            this.Pris = 0;
        }
        return this.Pris;
    }
}