import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Legesystem {

    public void lesFraFil(String fil) throws FileNotFoundException{
        File text = new File(fil);
        Scanner leser = new Scanner(fil);
        while(leser.hasNextLine()){
            while(leser.nextLine() != "# Legemidler (navn,type,pris,virkestoff,[styrke])"){
                if(leser.nextLine() != "# Pasienter (navn, fnr)"){
                    String navn = leser.next();
                    int foedselsnummer = leser.nextInt();
                    System.out.println(navn + foedselsnummer);
                }
            }
        }
    }
}
