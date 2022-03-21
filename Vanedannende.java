
class Vanedannende extends Legemiddel{
    int vaneStyrke;
    public String toString(){
        return  super.toString() + "Vanedannende styrke:" + this.hentStyrke() + "\n";
    } 
    Vanedannende(String navn, int pris, double virkestoff, int vaneStyrke) {
        super(navn, pris, virkestoff);
        this.vaneStyrke = vaneStyrke;

    }  
    public int hentStyrke(){
        return this.vaneStyrke;
    }

    public int prisAaBetale(){
        return this.pris;
    }

    public String hentType(){
        return "vanedannende";
    }
}