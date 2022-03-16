//Klasse lege som sammenligner og holder data om leger

class lege implements Comparable<lege> {
    String navn;
    lege(String navn) {
        this.navn = navn;
    }
    public String toString() {
        return navn;
    }
    
    public String hentNavn() {
        return navn;
    }

    public int compareTo(lege x){
        return x.hentNavn().compareTo(this.navn);
    }

    IndeksertListe<Resept> utskrevneResepter = new IndeksertListe<>();

    public void skrivUtResepter() {
        for(Resept x: utskrevneResepter) {
            System.out.println(x);
        }
    }

    public hvitResept skrivHvitResept (Legemiddel legemiddel, pasient pasient, int reit)throws UlovligUtskrift{
        if(legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        }
        hvitResept hvit = new hvitResept(this, reit, legemiddel, pasient);
        utskrevneResepter.leggTil(hvit);
        return hvit;
    }

    public MilitaerResept skrivMilResept (Legemiddel legemiddel, pasient pasient) throws UlovligUtskrift {
        if(legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        }
        MilitaerResept mil = new MilitaerResept(this, legemiddel, pasient);
        utskrevneResepter.leggTil(mil);
        return mil;
    }
    public pResept skrivPResept (Legemiddel legemiddel, pasient pasient, int reit) throws UlovligUtskrift {
        if(legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        }
        pResept p = new pResept(this, reit, legemiddel, pasient);
        utskrevneResepter.leggTil(p);
        return p;
    }
    public blaaResept skrivBlaaResept (Legemiddel legemiddel, pasient pasient, int reit) throws UlovligUtskrift{
        if(legemiddel instanceof Narkotisk && !(this instanceof spesialist)){
            throw new UlovligUtskrift(this, legemiddel);
        }
        blaaResept blaa = new blaaResept(this, reit, legemiddel, pasient);
        utskrevneResepter.leggTil(blaa);
        return blaa;
    }

    public static void main(String[] args) throws UlovligUtskrift {
        lege hans = new lege("Hans");
        Vanedannende oxy = new Vanedannende("Oxy", 100, 300, 10);
        pasient dion = new pasient("Dion", "91082");
        spesialist nico = new spesialist("Nico", "09990");
        Narkotisk cola = new Narkotisk("Cola", 1200, 10, 10);
        nico.skrivBlaaResept(cola, dion, 3);
        hans.skrivMilResept(oxy, dion);
        hans.skrivHvitResept(oxy, dion, 3);
        hans.skrivUtResepter();
        nico.skrivUtResepter();
        }
    }



