import java.util.Scanner;
public class GUI extends Legesystem{
    public static void main(String[] args) {

        String svar = "";
        Scanner input = new Scanner(System.in);
                
        while(svar != "q" ){
            
            System.out.println(
                "(S)krive ut en fullstendig oversikt over pasienter, leger, legemidler og resepter\n" +
                "(O)pprette og legge til nye elementer i systemet \n" +
                "(B)ruke en gitt resept fra listen til en pasient \n" +
                "(P)rint ut forskjellige former for statistikk \n" +
                "(L)age ny fil og skrive alle data til fil \n"+
                "(Q)uit");

            System.out.print("Skriv inn oensket kommando: ");  // bare pynt
            svar = input.next();
            System.out.print("Dette skjedde: ");  //bare pynt


            if(svar.toLowerCase().compareTo("s") == 0){
                //ikke lagt inn funksjons
                System.out.println("Skrive ut en fullstendig oversikt over pasienter, leger, legemidler og resepter (deloppgave E3).");
            }

            else if(svar.toLowerCase().compareTo("q") == 0){
                System.out.println("Hade!");
                break;
            }

            else if(svar.toLowerCase().compareTo("o") == 0){
                //ikke lagt inn funksjon
                System.out.println("Opprette og legge til nye elementer i systemet (deloppgave E4).");
                System.out.println("Ønsker du å opprette: \n"+ 
                "(L)ege \n" +
                "(P)asient \n"+
                "(R)esept \n"+
                "(LE)gemiddel \n"+
                "(Q)uit til hovedmeny");

                while(svar != "Q"){

                    System.out.print("Skriv inn oensket kommando: ");  // bare pynt
                    svar = input.next();

                    if(svar.toLowerCase().compareTo("l") == 0){
                        System.out.print("(S)pesialist eller (V)anlig: ");
                        svar = input.next();
                        if(svar.toLowerCase().compareTo("s") == 0){
                            System.out.println("Oppgi navn;");
                            String svar1 = input.next(); 
                            System.out.println("Oppgi kontrollid");
                            String svar2 = input.next();
                            spesialist nySpes = new spesialist(svar1, svar2);
                            leger.leggTil(nySpes);
                        }
                        else if(svar.toLowerCase().compareTo("v") == 0){
                            System.out.println("Oppgi navn;");
                            String svar1 = input.next();
                            lege nyLege = new lege(svar1);
                            leger.leggTil(nyLege);
                        }

                        else{
                            System.out.println("Ugyldig"); break;
                        }
                    }

                    else if(svar.toLowerCase().compareTo("p") == 0){

                    }

                    else if(svar.toLowerCase().compareTo("r") == 0){

                    }

                    else if(svar.toLowerCase().compareTo("le") == 0){

                    }

                    else if(svar.toLowerCase().compareTo("q") == 0){
                        System.out.println("taper"); break;

                    }
                    else{System.out.println("ulovlig input");}
                }
            }
            
            else if(svar.toLowerCase().compareTo("b") == 0){
                //ikke lagt inn funksjon
                System.out.println("Bruke en gitt resept fra listen til en pasient (deloppgave E5).");
            }
            
            else if(svar.toLowerCase().compareTo("p") == 0){
                //ikke lagt inn funksjon
                System.out.println("Print ut forskjellige former for statistikk (deloppgave E6).");
            }
            
            else if(svar.toLowerCase().compareTo("l") == 0){
                //ikke lagt inn funksjon
                System.out.println("Skrive alle data til fil (deloppgave E7).");
            }

            else{
                System.out.println("ugyldig input");
            }
            System.out.println("\n");
        }
        input.close();
        for(lege x:leger){
            System.out.println(x);
        }
    }   
}
