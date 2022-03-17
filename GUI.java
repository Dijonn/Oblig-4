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
        System.out.println("\nOensker du å opprette: \n"+ 
            "(L)ege \n" +
            "(P)asient \n"+
            "(R)esept \n"+
            "(LE)gemiddel \n"+
            "(Q)uit til hovedmeny");
            }


    public static boolean gyldighet(String lege, String legemiddel, String pasient){
        
        boolean gyldig = false; 
        
        for(lege x: leger){
            
            if(x.navn.compareTo(lege) == 0){
                gyldig = true;
            }
        }

        for(Legemiddel x: legemiddelListe){
            
            if(x.navn.compareTo(legemiddel) == 0){
                gyldig = true;
            }
        }
        
        for(pasient x: pasienter){
            
            if(x.navn.compareTo(pasient) == 0){
                gyldig = true;
            }
        }

        return gyldig;
    }

    public static void main(String[] args) {

        String svar = "";
        Scanner input = new Scanner(System.in);
        
        PrintHovedMeny();
    
        while(svar != "q" ){
            
            //Logikken for scanner og input
            System.out.print("Skriv inn oensket kommando, hovedmeny: ");  // bare pynt
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

                    System.out.print("Skriv inn oensket kommando, submeny O: ");  // bare pynt
                    svar = input.next();


                    //LEGE LEGE LEGE LEGE LEGE

                    if(svar.toLowerCase().compareTo("l") == 0){
                        System.out.print("(S)pesialist eller (V)anlig: ");
                        svar = input.next();
                        if(svar.toLowerCase().compareTo("s") == 0){
                            System.out.println("Lager spesialist");
                            System.out.print("\nOppgi navn: ");
                            String svar1 = input.next(); 
                            System.out.print("\nOppgi kontrollid: ");
                            String svar2 = input.next();
                            spesialist nySpes = new spesialist(svar1, svar2);
                            leger.leggTil(nySpes);
                        }
                        
                        else if(svar.toLowerCase().compareTo("v") == 0){
                            System.out.println("Lager vanlig lege");
                            System.out.print("\nOppgi navn: ");
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

                    
                    //// PASIENT PASIENT PASIENT PASIENT 

                    else if(svar.toLowerCase().compareTo("p") == 0){
                        System.out.print("\nLager ny pasient");
                        System.out.print("\nOppgi navn: ");
                        String svar1 = input.next(); 
                        System.out.println("\nOppgi foedselsnummer: ");
                        String svar2 = input.next();
                        pasient nyPas = new pasient(svar1, svar2);
                        pasienter.leggTil(nyPas);
                    }


                    // RESEPT RESEPT RESEPT RESEPT
                    //Logikken for å legge til et resept til legsystem, med skrivResept() metoden. 

                    else if(svar.toLowerCase().compareTo("r") == 0){
                        
                        System.out.print(
                            "\n(H)vit resept\n"+
                            "(B)laa resept\n"+
                            "(M)ilitaer resept\n"+
                            "(P) resept\n"+
                            "(Q) gå til forrige meny\n"+
                            "Skriv oensket kommando, resept"

                        );
                        
                        while( svar != "q"){
                            svar = input.next();
                            
                            if(svar.toLowerCase().compareTo("h") == 0){
                                
                                // Ta inn nodvendig input
                                boolean gyldig = false;
                                System.out.println("Lager hvit resept.");
                                System.out.print("Ansvarlig lege: ");
                                String lege = input.next();
                                System.out.print("Legemiddel: ");
                                String legemiddel = input.next();
                                System.out.print("Pasient: ");
                                String pasient = input.next();
                                System.out.print("Reit: ");
                                String reit = input.next();
                                
                            
                                if(gyldighet(lege, legemiddel, pasient)){
                                    System.out.println("hei");
                                    //hvitResept nyHvit = new hvitResept(lege, Integer.parseInt(reit), legemiddel, pasient)
                                    break;
                                }

                                else{
                                    System.out.println("false");
                                    break;
                                }
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
                                PrintSubMeny_DelO();
                                break;
                            }

                            else{
                                System.out.println("ugyldig input\n");
                            }
                        }


                    }


                    // LEGEMIDDEL LEGEMIDDEL LEGEMIDDEL LEGEMIDDEL

                    else if(svar.toLowerCase().compareTo("le") == 0){

                        System.out.println("(N)arkotsik, (V)anlig eller (VD)nedannende: ");
                        svar = input.next();

                        if(svar.toLowerCase().compareTo("n") == 0){
                            System.out.println("Lager nytt legemiddel");
                            System.out.print("\nNavn: ");
                            String svarNavn = input.next();
                            System.out.print("\nPris: ");
                            int svarPris = input.nextInt();
                            System.out.print("\nVirkestoff: ");
                            double svarVirkestoff = input.nextDouble();
                            System.out.print("\nNarkotisk styrke: ");
                            int svarNarkStyrke = input.nextInt();
                            Narkotisk nyNark = new Narkotisk(svarNavn, svarPris, svarVirkestoff, svarNarkStyrke);
                            legemiddelListe.leggTil(nyNark);
                        }

                        else if(svar.toLowerCase().compareTo("v") == 0){
                            
                            System.out.print("\nNavn: ");
                            String svarNavn = input.next();
                            System.out.print("\nPris: ");
                            int svarPris = input.nextInt();
                            System.out.print("\nVirkestoff: ");
                            double svarVirkestoff = input.nextDouble();
                            Vanlig nyVan = new Vanlig(svarNavn, svarPris, svarVirkestoff);
                            legemiddelListe.leggTil(nyVan);
                        }

                        else if(svar.toLowerCase().compareTo("vd") == 0){
                            
                            System.out.print("\nNavn: ");
                            String svarNavn = input.next();
                            System.out.print("\nPris: ");
                            int svarPris = input.nextInt();
                            System.out.print("\nVirkestoff: ");
                            double svarVirkestoff = input.nextDouble();
                            System.out.print("\nVaneStyrke: ");
                            int vaneStyrke = input.nextInt();
                            Vanedannende nyVaneD = new Vanedannende(svarNavn, svarPris, svarVirkestoff, vaneStyrke);
                            legemiddelListe.leggTil(nyVaneD);
                        }

                            else{System.out.println("Ugyldig"); break;}
                        }

                    else if(svar.toLowerCase().compareTo("q") == 0){
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
        for(Resept x : resept){
            System.out.println(x);
        }
    }   
}

