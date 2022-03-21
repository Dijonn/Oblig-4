import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Legesystem {

    static IndeksertListe<pasient> pasienter = new IndeksertListe<>();
    static IndeksertListe<Legemiddel> legemiddelListe = new IndeksertListe<>();
    static Prioritetskoe<lege> leger = new Prioritetskoe<>();
    static IndeksertListe<Resept> resept = new IndeksertListe<>();

    public void lesFraFil(String fil) throws FileNotFoundException{
        File text = new File(fil);
        Scanner leser = new Scanner(text);
        String linje;
    
        int hashtagTeller = 0;
        

        
        while(leser.hasNextLine()){   //gå gjennom alle linjene i filen 
            linje = leser.nextLine();
            hashtagTeller ++;
            
            while(! linje.contains("#") ){ // gå gjennom alle linjer knyttet til pasient
                
                String deler[] = linje.split(",");

                if(hashtagTeller == 2){
                    //lager ny pasient og legger til i pasientlenketliste
                    pasient p = new pasient(deler[0], deler[1]);
                    pasienter.leggTil(p);
                    
                }

                else if(hashtagTeller == 3){
                    //lager nytt legemiddel og legger dette i legemiddellenketliste;
                    String narkotisk = "narkotisk";
                    String vanlig = "vanlig";

                    if(deler[1].compareTo(narkotisk) == 0 ){ //hvis type er vanlig
                        Narkotisk ny = new Narkotisk(deler[0], Integer.parseInt(deler[2]), Double.parseDouble(deler[3]), Integer.parseInt(deler[4]));
                        legemiddelListe.leggTil(ny);
                    }
                    else if(deler[1].compareTo(vanlig) == 0 ){ //hvis type er vanlig
                        Vanlig ny = new Vanlig(deler[0],Integer.parseInt(deler[2]), Double.parseDouble(deler[3]));
                        legemiddelListe.leggTil(ny);
                    }
                    else{  //ett alternativ igjen, vanedannende. 
                        Vanedannende ny = new Vanedannende(deler[0],Integer.parseInt(deler[2]) , Double.parseDouble(deler[3]), Integer.parseInt(deler[4]));
                        legemiddelListe.leggTil(ny);
                    }

                }
                else if(hashtagTeller == 4){
                    //System.out.println("lege");
                    if(deler[1].compareTo("0") == 0){
                        lege nyLege = new lege(deler[0]);
                        leger.leggTil(nyLege);
                    }
                    else{
                        spesialist nySpes = new spesialist(deler[0], deler[1]);
                        leger.leggTil(nySpes);
                    }
                }
                else if(hashtagTeller == 5){
                    
                    //System.out.println("resept");
                    lege storLege = null;
                    for(lege x:leger){
                        if(deler[1].compareTo(x.hentNavn()) == 0){
                            storLege = x;
                        }
                    }

                    if(deler[3].compareTo("hvit") == 0 ){
                        try{
                            storLege.skrivHvitResept(legemiddelListe.hent(Integer.parseInt(deler[0])-1), pasienter.hent(Integer.parseInt(deler[2])-1), Integer.parseInt(deler[4]));
                        }
                        
                        catch (Exception UlovligUtskrift){
                            System.out.println("Ikke lov å skriv resept.\n");
                        }
                    }
                    
                    else if(deler[3].compareTo("blaa") == 0 ){
                        
                        try{
                            storLege.skrivBlaaResept(legemiddelListe.hent(Integer.parseInt(deler[0])-1), pasienter.hent(Integer.parseInt(deler[2])-1), Integer.parseInt(deler[4]));
                        }
                        
                        catch (Exception UlovligUtskrift){
                            System.out.println("Ikke lov å skriv resept.\n");
                        }
                        
                    }

                    else if(deler[3].compareTo("militaer") == 0 ){
                        try{
                            storLege.skrivMilResept(legemiddelListe.hent(Integer.parseInt(deler[0])-1), pasienter.hent(Integer.parseInt(deler[2])-1));
                        }
                        
                        catch (Exception UlovligUtskrift){
                            System.out.println("Ikke lov å skriv resept.\n");
                        }
                    }

                    else if(deler[3].compareTo("p") == 0 ){
                        try{
                            storLege.skrivPResept(legemiddelListe.hent(Integer.parseInt(deler[0])-1), pasienter.hent(Integer.parseInt(deler[2])-1), Integer.parseInt(deler[4]));
                        }
                        
                        catch (Exception UlovligUtskrift){
                            System.out.println("Ikke lov å skriv resept.\n");
                        }
                    }

                    else{System.out.println("Ulovlig input");}

                }
               

                if(leser.hasNextLine()){
                    linje = leser.nextLine();
                }

                else{
                    break;
                }

            }
        }
        for(pasient x: pasienter){
            System.out.println(x);
        }
        for(lege x : leger){
            System.out.println(x);
        }
       
        for(Legemiddel x : legemiddelListe){
            System.out.println(x);
        }
        for(Resept x: resept){
            System.out.println(x);
        }

        leser.close();

    }
    public static void main(String[] args) throws FileNotFoundException {
        Legesystem test = new Legesystem();
        test.lesFraFil("legedata.txt");
        
    }
}

