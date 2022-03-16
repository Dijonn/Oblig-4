import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Legesystem {

    public void lesFraFil(String fil) throws FileNotFoundException{
        File text = new File(fil);
        Scanner leser = new Scanner(fil);
        String linje;
        while(leser.hasNextLine()){
            while(leser.nextLine() != "# Legemidler (navn,type,pris,virkestoff,[styrke])"){
                if(leser.nextLine() != "# Pasienter (navn, fnr)"){
                    linje = leser.nextLine();
                    String deler[] = linje.split(",");
                    String navn = deler[0];
                    int foedselsnummer = Integer.parseInt(deler[1]);
                    System.out.println(navn + foedselsnummer);
                }
            }
        }
        leser.close();
    }
}
