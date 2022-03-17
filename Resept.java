

abstract class Resept{
    protected static int reseptId = 1;
    lege ansvarligLege;
    int reit;
    Legemiddel Legemiddel;
    int Pris;
    String farge;
    int Id_resept;
    pasient pasient;
    
    
    Resept( lege ansvarligLege, int reit, Legemiddel Legemiddel, pasient pasient){
        this.ansvarligLege = ansvarligLege;
        this.reit = reit;
        this.Legemiddel = Legemiddel;
        this.Id_resept = reseptId;
        this.pasient = pasient;
        reseptId++;
    }
    public int hentReseptId(Resept resept){
        return resept.Id_resept;
    }
    public lege hentAnsvarligLege(){
        return this.ansvarligLege;
    }
    public pasient hentPasientId(){
        return this.pasient;
    }
    public int hentReit(){
        return this.reit;
    }
    public String hentLegemiddel(){
        return Legemiddel.navn;
    }
    /* public String toString(Resept resept){
        return "ReseptID:" + this.hentReseptId(resept) + "\n Ansvarlig lege:" + this.hentAnsvarligLege() + "\n PasientID:" + this.hentPasientId() + "\n Reit:" + this.hentReit();
    } */
    public boolean bruk(){
        if(this.reit>1){
            this.reit -=1;
            return true;
        }
        return false;
    }
    public String farge(){
        return this.farge;
    }  
    abstract public int prisAaBetale();

    public String toString(){
        return "Ansvarlig lege: " + ansvarligLege + "\nReit:" + reit + "\nLegemiddel:" + this.hentLegemiddel() + "\nId resept:" +Id_resept + "\nId pasient:" + this.pasient.id + "\nPris:" + this.prisAaBetale() + "\n";   }
}


