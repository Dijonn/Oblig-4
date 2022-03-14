

abstract class Resept{
    protected static int reseptId = 1;
    lege ansvarligLege;
    int reit;
    Legemiddel Legemiddel;
    String farge;
    int Pris;
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
    public String toString(Resept resept){
        return "ReseptID:" + this.hentReseptId(resept) + " Ansvarlig lege:" + this.hentAnsvarligLege() + " PasientID:" + this.hentPasientId() + " Reit:" + this.hentReit();
    }
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
    public int prisAaBetale(){
        return this.Pris;
    }
    public String toString(){
        return "Ansvarlig lege: " + ansvarligLege + " Reit:" + reit + " Legemiddel:" + Legemiddel.hentNavn() + " Id resept:" +Id_resept + " Id pasient:" + pasient + " Pris:" + Pris;    }
}


