import java.util.Scanner;
public class GUI extends Legesystem{
    
    public static void PrintHovedMeny(){
        System.out.println(
                "(S)krive ut en fullstendig oversikt over pasienter, leger, legemidler og resepter\n" +
                "(O)pprette og legge til nye elementer i systemet \n" +
                "(B)ruke en gitt resept fra listen til en pasient \n" +
                "(P)rint ut forskjellige former for statistikk \n" +
                "(L)age ny fil og skrive alle data til fil \n"+
                "(Q)uit");
    }

    public static void main(String[] args) {

        String svar = "";
        Scanner input = new Scanner(System.in);
        
        PrintHovedMeny();
    
        while(svar != "q" ){
            
            //Logikken for scanner og input
            System.out.print("Skriv inn oensket kommando: ");  // bare pynt
            svar = input.next();
            System.out.print("Dette skjedde: ");  //bare pynt


            /////// Skriv ut overskrift
            if(svar.toLowerCase().compareTo("s") == 0){
                
                System.out.println("Skrive ut en fullstendig oversikt over pasienter, leger, legemidler og resepter (deloppgave E3).");
            }

            ////// Logikken for å quite interfacet
            else if(svar.toLowerCase().compareTo("q") == 0){
                System.out.println("Hade!");
                break;
            }

            ////// Logikken for å gå inn i submeny for å oprette og legge til nye elementer i systemet
            else if(svar.toLowerCase().compareTo("o") == 0){
                //ikke lagt inn funksjon
                System.out.println("Opprette og legge til nye elementer i systemet (deloppgave E4).");
                System.out.println("Oensker du å opprette: \n"+ 
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
                            System.out.println("Ugyldig");
                            break;
                        }
                    }

                    else if(svar.toLowerCase().compareTo("p") == 0){

                    }

                    else if(svar.toLowerCase().compareTo("r") == 0){

                    }

                    else if(svar.toLowerCase().compareTo("le") == 0){

                    }

                    else if(svar.toLowerCase().compareTo("q") == 0){
                        System.out.println("taper"); 
                        PrintHovedMeny(); 
                        break;

                    }
                    else{System.out.println("ulovlig input");}
                }
            }
            
            
            ////// Logikken for å bruke en resept fra listen til en pasient
            else if(svar.toLowerCase().compareTo("b") == 0){
                //ikke lagt inn funksjon
                System.out.println("Bruke en gitt resept fra listen til en pasient (deloppgave E5).");
            }
            
            ////// Logikken for å printe ut forskjellige former for statistikk
            else if(svar.toLowerCase().compareTo("p") == 0){
                //ikke lagt inn funksjon
                System.out.println("Print ut forskjellige former for statistikk (deloppgave E6).");
            }
            
            ///// Logikken for å skrive alle data til fil
            else if(svar.toLowerCase().compareTo("l") == 0){
                //ikke lagt inn funksjon
                System.out.println("Skrive alle data til fil (deloppgave E7).");
            }

            ////// Logikken når det er ugyldig input
            else{
                System.out.println("ugyldig input");
            }

            // Denne er her for å gi mellomrom mellom hver iterering av while-loopen. 
            System.out.println("\n");
        }
        input.close();
    }   
}

