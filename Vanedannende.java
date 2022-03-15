
class Vanedannende extends Legemiddel{
    int vaneStyrke;
    public String toString(){
        return  super.toString() + " Vanedannende styrke:" + this.hentVaneStyrke();
    } 
    Vanedannende(String navn, int pris, double virkestoff, int vaneStyrke) {
        super(navn, pris, virkestoff);
        this.vaneStyrke = vaneStyrke;

    }  
    public int hentVaneStyrke(){
        return this.vaneStyrke;
    }
}