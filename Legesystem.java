import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Legesystem {

    public void lesFraFil(String fil) throws FileNotFoundException{
        File text = new File(fil);
        Scanner leser = new Scanner(text);
        String linje;
        int hashtagTeller = 0;
        
        while(leser.hasNextLine()){   //gå gjennom alle linjene i filen 
            linje = leser.nextLine();
            hashtagTeller ++;
            
            while(! linje.contains("#") ){ // gå gjennom alle linjer knyttet til pasient
                
                if(hashtagTeller == 2){
                    //System.out.println("pasienter");
                    
                }
                else if(hashtagTeller == 3){
                    //System.out.println("legemidler");
                }
                else if(hashtagTeller == 4){
                    //System.out.println("lege");
                }
                else if(hashtagTeller == 5){
                    //System.out.println("resept");
                }
                

                if(leser.hasNextLine()){
                    linje = leser.nextLine();
                    String deler[] = linje.split(",");

                }

                else{
                    break;
                }

            }
        }
        leser.close();
        
    }
    public static void main(String[] args) throws FileNotFoundException {
        Legesystem test = new Legesystem();
        test.lesFraFil("legedata.txt");
    }
}
