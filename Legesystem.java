import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Legesystem {

    IndeksertListe<pasient> pasienter = new IndeksertListe<>();
    IndeksertListe<Legemiddel> legemiddel = new IndeksertListe<>();
    IndeksertListe<lege> lege = new IndeksertListe<>();
    IndeksertListe<Resept> resept = new IndeksertListe<>();

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
                    String vanedannende = "vanedannende";

                    if(deler[1].compareTo(narkotisk) == 0 ){ //hvis type er vanlig
                        Narkotisk ny = new Narkotisk(deler[0], Integer.parseInt(deler[2]), Integer.parseInt(deler[3]), Integer.parseInt(deler[4]));
                        legemiddel.leggTil(ny);
                    }
                    else if(deler[1].compareTo(vanlig) == 0 ){ //hvis type er vanlig
                        
                    }
                    else{  //ett alternativ igjen, vanedannende. 
                        
                    }

                }
                else if(hashtagTeller == 4){
                    //System.out.println("lege");
                }
                else if(hashtagTeller == 5){
                    //System.out.println("resept");
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
        leser.close();

    }
    public static void main(String[] args) throws FileNotFoundException {
        Legesystem test = new Legesystem();
        test.lesFraFil("legedata.txt");
        
    }
}
