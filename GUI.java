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

    static void PrintSubMeny_DelO(){
        System.out.println("Oensker du å opprette: \n"+ 
            "(L)ege \n" +
            "(P)asient \n"+
            "(R)esept \n"+
            "(LE)gemiddel \n"+
            "(Q)uit til hovedmeny");
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
                
                PrintSubMeny_DelO();
                while(svar != "Q"){

                    System.out.print("Skriv inn oensket kommando: ");  // bare pynt
                    svar = input.next();


                    //LEGE LEGE LEGE LEGE LEGE 
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
                            PrintSubMeny_DelO();
                            break;
                        }
                    }

                    //// ny undermeny
                    else if(svar.toLowerCase().compareTo("p") == 0){
                        System.out.println("Pasient: \n");
                        System.out.println("Oppgi navn;");
                        String svar1 = input.next(); 
                        System.out.println("Oppgi foedselsnummer");
                        String svar2 = input.next();
                        pasient nyPas = new pasient(svar1, svar2);
                        pasienter.leggTil(nyPas);
                    }


                    // RESEPT RESEPT RESEPT RESEPT
                    //Logikken for å legge til et resept til legsystem, med skrivResept() metoden. 
                    else if(svar.toLowerCase().compareTo("r") == 0){
                        
                        System.out.println(
                            "(H)vit resept\n"+
                            "(B)laa resept\n"+
                            "(M)ilitaer resept\n"+
                            "(P) resept\n"+
                            "(Q) gå til forrige meny"
                        );
                        while( svar != "q"){
                            svar = input.next();
                            
                            if(svar.toLowerCase().compareTo("h") == 0){
                                // lag hvit resept
                            }

                            else if(svar.toLowerCase().compareTo("b") == 0){
                                // lag blaa resept
                            }

                            else if(svar.toLowerCase().compareTo("m") == 0){
                                // lag militaer resept
                            }

                            else if(svar.toLowerCase().compareTo("p") == 0){
                                // lag p-resept
                            }

                            else if(svar.toLowerCase().compareTo("q") == 0){
                                
                                break;
                            }

                            else{
                                System.out.println("ugyldig input\n");
                            }
                        }


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

