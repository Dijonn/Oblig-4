import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class GUI extends Legesystem{

    
    //Printer ut hovedmenyen til brukergensesnittet
    public static void PrintHovedMeny(){
        System.out.println(
            "(S)krive ut en fullstendig oversikt over pasienter, leger, legemidler og resepter\n" +
            "(O)pprette og legge til nye elementer i systemet \n" +
            "(B)ruke en gitt resept fra listen til en pasient \n" +
            "(P)rint ut forskjellige former for statistikk \n" +
            "(L)age ny fil og skrive alle data til fil \n"+
            "(Q)uit");
    }
    
    
    //for å sjekke antall vanedannende resepter
    public static int skrivUtVanedannendeAntall(){

        int teller = 0;

        for(lege x : leger){
            Lenkeliste<Resept> reseptListe = x.hentResepter();
            for(Resept y: reseptListe){
                if(y.Legemiddel instanceof Vanedannende){
                    teller ++;
                }
            }
        }
        return teller;
    }

    public static int skrivUtNarkotiskAntall(){

        int teller = 0;

        for(lege x : leger){
            Lenkeliste<Resept> reseptListe = x.hentResepter();
            for(Resept y: reseptListe){
                if(y.Legemiddel instanceof Narkotisk){
                    teller ++;
                }
            }
        }
        return teller;
    }

    public static void skrivUtLegerMedNarkotiskResept(){
        
        for(lege x: leger){

            Lenkeliste<Resept> reseptListe = x.hentResepter();
            int antallNarkotiskeResepter = 0;
            boolean harNarkotiskResept = false;
            
            for(Resept y: reseptListe){

                if(y.Legemiddel instanceof Narkotisk){
                    antallNarkotiskeResepter++;
                    harNarkotiskResept = true;
                }
            }

            if(harNarkotiskResept){
                System.out.println("\n" + x.navn + " antall narkotiske resepter: " + antallNarkotiskeResepter);
            }

        }
    }

    public static void skrivTilFil() throws IOException{
        FileWriter skriver = new FileWriter("nyFil.txt");


                skriver.write("# Pasient (navn, fnr)\n");
                for(pasient x : pasienter){
                    skriver.write(x.navn + "," + x.foedselsnummmer + "\n");
                }

                skriver.write("# Legemiddel (navn,type,pris,virkestoff,[styrke])\n");
                for(Legemiddel x : legemiddelListe){
                    if(x instanceof Narkotisk){
                        skriver.write(x.navn + "," + x.hentType() + "," + x.pris + "," + x.virkestoff + "," + x.hentStyrke() + "\n");
                    }
                    else if(x instanceof Vanedannende){
                        skriver.write(x.navn + "," + x.hentType() + "," + x.pris + "," + x.virkestoff + "," + x.hentStyrke() + "\n");
                    }
                    else{
                        skriver.write(x.navn + "," + x.hentType() + "," + x.pris + "," + x.virkestoff + "\n");
                    }
                }


                skriver.write("# Leger (navn, kontrollid / 0 hvis vanlig lege)\n");
                    for(lege x : leger){
                        if(x instanceof spesialist){
                            skriver.write(x.navn + ", " + x.hentKontrollId() + "\n");
                        }
                        else{
                            skriver.write(x.navn+ "," + x.hentKontrollId() + "\n");
                        }
                    }

                skriver.write("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])\n");
                for(Resept x : resept){
                    if(x instanceof blaaResept){
                        skriver.write(x.Legemiddel.hentId() + "," + x.ansvarligLege.hentNavn() + "," + x.pasient.id + "," + x.farge + "," + x.reit + "\n");
                    }
                    else if(x instanceof hvitResept){
                        skriver.write(x.Legemiddel.hentId() + "," + x.ansvarligLege.hentNavn() + "," + x.pasient.id + "," + x.farge + "," + x.reit + "\n");
                    }
                    else if(x instanceof pResept){
                        skriver.write(x.Legemiddel.hentId() + "," + x.ansvarligLege.hentNavn() + "," + x.pasient.id + "," + x.farge + "," + x.reit + "\n");
                    }
                    else{
                        skriver.write(x.Legemiddel.hentId() + "," + x.ansvarligLege.hentNavn() + "," + x.pasient.id + "," + x.farge + "\n");
                    }
                }
                skriver.close();
            }
        
    

    //Metode som skriver ut pasiener som har narkotisk resept, og hvor mange de har, ikke komplett. 
    public static void skrivPasienterMedNarkotiskResept(){

        for(pasient p: pasienter){

            int antallNarkotiskeResepter = 0;
            boolean harNarkotiskResept = false;

            for(Resept y: resept){
                
                if(y.Legemiddel instanceof Narkotisk && y.pasient == p){
                    harNarkotiskResept = true;
                    antallNarkotiskeResepter ++;
                }
            }
            if(harNarkotiskResept){
                System.out.println("\n" + p.navn + " har " + antallNarkotiskeResepter + " narkotiske.");
            }
        }
    }
    


    //Printer ut submenyen til brukergensesnittet
    static void PrintSubMeny_DelO(){
        System.out.println("\nOensker du å opprette: \n"+ 
            "(L)ege \n" +
            "(P)asient \n"+
            "(R)esept \n"+
            "(LE)gemiddel \n"+
            "(Q)uit til hovedmeny");
            }

    // Sjekker om oppgitt lege, legemiddel og pasient er i listene. 
    public static boolean gyldighet(String lege, String legemiddel, String pasient){

        boolean gyldig = false; 
        
        for(lege x: leger){
            
            if(x.navn.toLowerCase().compareTo(lege.toLowerCase()) == 0){
                gyldig = true;
            }
        }

        for(Legemiddel x: legemiddelListe){
            
            if(x.navn.toLowerCase().compareTo(legemiddel.toLowerCase()) == 0){
                gyldig = true;
            }
        }
        
        for(pasient x: pasienter){
            
            if(x.navn.toLowerCase().compareTo(pasient.toLowerCase()) == 0){
                gyldig = true;
            }
        }

        return gyldig;
    }

    //henter ut lege som tilsvarer Stringen
    public static lege hentLege(String l){
        for (lege x : leger) {
            if(x.navn.compareTo(l)==0){
                return x;
            }
        }
        return null;
    }

    //Henter ut legemiddel som har samme navn som oppgitt string
    public static Legemiddel hentLegeMiddel(String l){
        for (Legemiddel x : legemiddelListe) {
            if(x.navn.compareTo(l)==0){
                return x;
            }
        }
        return null;
    }

    //Henter ut pasient som tilsvarer String oppgitt
    public static pasient hentPasient(String p){
        for (pasient x : pasienter) {
            if(x.navn.compareTo(p)==0){
                return x;
            }
        }
        return null;
    }


    public static void main(String[] args) {

        Legesystem test = new Legesystem();
        
        try {
            test.lesFraFil("legedata.txt");
        } 
        
        catch (Exception e) {
            System.out.println(" finner ikke fil ");
        }


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
                
                System.out.println("\nSkriver ut total oversikt. \n");
                
                System.out.println("Pasienter:\n");
                for(pasient x: pasienter){
                    System.out.println(x);
                }

                System.out.println("Leger:\n");
                for(lege x : leger){
                    System.out.println(x);
                }
               
                System.out.println("Legemidler:\n");
                for(Legemiddel x : legemiddelListe){
                    System.out.println(x);
                }

                System.out.println("Resepter:\n");
                for(Resept x: resept){
                    System.out.println(x);
                }
            }

            ////// Logikken for å quite interfacet
            else if(svar.toLowerCase().compareTo("q") == 0){
                System.out.println("Hade!");
                break;
            }

            // E4 E4 E4 E4 E4 E4
            ////// Logikken for å gå inn i submeny for å oprette og legge til nye elementer i systemet
            else if(svar.toLowerCase().compareTo("o") == 0){
                //ikke lagt inn funksjon
                System.out.println("Opprette og legge til nye elementer i systemet (deloppgave E4).");
                
                PrintSubMeny_DelO();
                while(svar != "Q"){

                    System.out.print("Skriv inn oensket kommando, submeny O: ");  // bare pynt
                    svar = input.next();


                    //LEGE LEGE LEGE LEGE LEGE
                    // Lager lege og legger til i liste
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
                    // Lager pasient og legger til i liste
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
                            "Skriv oensket kommando; resept: "

                        );
                        
                        //KAN DANNE ALLE DE FORSKJELLIGE RESEPTENE OG LEGGE TIL I RESEPTLISTEN
                        while( svar != "q"){
                            svar = input.next();
                            //Trenger denne linjen for at ikke første linje med input skal bli hoppet over
                            input.nextLine();
                            
                            // LAGER HVIT RESEPT OG LEGGER I LISTE
                            if(svar.toLowerCase().compareTo("h") == 0){
                                
                                // Ta inn nodvendig input
                                System.out.println("Lager hvit resept.");
                                System.out.print("Ansvarlig lege: ");
                                String lege = input.nextLine();
                                System.out.print("Legemiddel: ");
                                String legemiddel = input.nextLine();
                                System.out.print("Pasient: ");
                                String pasient = input.nextLine();
                                System.out.print("Reit: ");
                                String reit = input.nextLine();

                                try {
                                    if(gyldighet(lege, legemiddel, pasient)){
                                        Resept l = hentLege(lege).skrivHvitResept(hentLegeMiddel(legemiddel), hentPasient(pasient) , Integer.parseInt(reit));
                                        resept.leggTil(l);
                                        break;
                                    }
                                }

                                catch (Exception UlovligUtskrift) {
                                    System.out.println("\nulovlig resept, proev igjen");
                                    break;
                                }
                            } 

                            // LAGER BLÅ RESEPT OG LEGGER I LISTE
                            else if(svar.toLowerCase().compareTo("b") == 0){
                                
                                // Ta inn nodvendig input
                                System.out.println("Lager blaa resept.");
                                
                                System.out.print("Ansvarlig lege: ");
                                String lege = input.nextLine();
                                
                                System.out.print("Legemiddel: ");
                                String legemiddel = input.nextLine();
                                
                                System.out.print("Pasient: ");
                                String pasient = input.nextLine();
                                
                                System.out.print("Reit: ");
                                String reit = input.nextLine();
                            
                                try {
                                    if(gyldighet(lege, legemiddel, pasient)){
                                        Resept l = hentLege(lege).skrivBlaaResept(hentLegeMiddel(legemiddel), hentPasient(pasient) , Integer.parseInt(reit));
                                        resept.leggTil(l);
                                        break;
                                    }
                                }

                                catch (Exception UlovligUtskrift) {
                                    System.out.println("\nUlovlig resept, proev igjen");
                                    break;
                                }

                            }

                            // LAGER MILITAERRESEPT OG LEGGER DENNE I RESEPTLISTEN
                            else if(svar.toLowerCase().compareTo("m") == 0){
                                
                                // Ta inn nodvendig input
                                System.out.println("Lager militaer-resept.");
                                System.out.print("Ansvarlig lege: ");
                                String lege = input.nextLine();
                                
                                System.out.print("Legemiddel: ");
                                String legemiddel = input.nextLine();
                        
                                System.out.print("Pasient: ");
                                String pasient = input.nextLine();

                                try {
                                    if(gyldighet(lege, legemiddel, pasient)){
                                        Resept l = hentLege(lege).skrivMilResept(hentLegeMiddel(legemiddel), hentPasient(pasient));
                                        resept.leggTil(l);
                                        break;
                                    }
                                }

                                catch (Exception UlovligUtskrift) {
                                    System.out.println("\nulovlig resept, proev igjen");
                                    break;
                                }

                            }

                            // LAGER P RESEPT OG LEGGER TIL I LISTE
                            else if(svar.toLowerCase().compareTo("p") == 0){
                                
                                // Ta inn nodvendig input
                                System.out.println("Lager pResept.");
                                System.out.print("Ansvarlig lege: ");
                                String lege = input.nextLine();
                                System.out.print("Legemiddel: ");
                                String legemiddel = input.nextLine();
                                System.out.print("Pasient: ");
                                String pasient = input.nextLine();
                                System.out.print("Reit: ");
                                String reit = input.nextLine();
                                
                            
                                try {
                                    if(gyldighet(lege, legemiddel, pasient)){
                                        Resept l = hentLege(lege).skrivPResept(hentLegeMiddel(legemiddel), hentPasient(pasient) , Integer.parseInt(reit));
                                        resept.leggTil(l);
                                        break;
                                    }
                                }

                                catch (Exception UlovligUtskrift) {
                                    System.out.println("\nulovlig resept, proev igjen");
                                    break;
                                }
                            }

                            //Quit submenyen, gå opp ett hakk i menyskopet
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
                    // Lager legemiddel og legger til i liste
                    else if(svar.toLowerCase().compareTo("le") == 0){

                        System.out.print("(N)arkotsik, (V)anlig eller (VD)nedannende (Q)uit: ");
                        svar = input.next();

                        if(svar.toLowerCase().compareTo("n") == 0){
                            System.out.println("Lager nytt legemiddel");
                            System.out.print("\nNavn: ");
                            String svarNavn = input.nextLine();   // var next her tidligere ()
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
                            String svarNavn = input.nextLine();
                            System.out.print("\nPris: ");
                            int svarPris = input.nextInt();
                            System.out.print("\nVirkestoff: ");
                            double svarVirkestoff = input.nextDouble();
                            Vanlig nyVan = new Vanlig(svarNavn, svarPris, svarVirkestoff);
                            legemiddelListe.leggTil(nyVan);

                        }

                        else if(svar.toLowerCase().compareTo("vd") == 0){
                            
                            System.out.print("\nNavn: ");
                            String svarNavn = input.nextLine();
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

                    // quiter ut av submenyen og går til hovedmenyen
                    else if(svar.toLowerCase().compareTo("q") == 0){
                        PrintHovedMeny(); 
                        break;

                    }
                    
                    // Ikke gyldig input
                    else{
                        System.out.println("ulovlig input");
                        PrintSubMeny_DelO();
                    }
                }
            }
            
            
            ////// Logikken for å bruke en resept fra listen til en pasient
            // E5 E5 E5 E5 E5 - BRUK AV RESEPT
            else if(svar.toLowerCase().compareTo("b") == 0){

                //Skriver ut pasienter
                System.out.println("Hvilken pasient vil du se resepter for?");
                int teller = 0;
                for(pasient x : pasienter){
                    System.out.println(teller+": " + x.navn + "(fnr "+x.foedselsnummmer+")");
                    teller ++;
                }


                //Henter ønsket pasient ut i fra indeks gitt av teller.
                int svarPasient = input.nextInt();
                pasient pasientObjekt = resept.hent(svarPasient).pasient;

                System.out.println("Valgt pasient: " + pasientObjekt.navn + " (fnr "+pasientObjekt.foedselsnummmer+")");



                //Ny liste til for resepter til en spesifik pasient
                IndeksertListe<Resept> pasientensResepter = new IndeksertListe<>();


                // Iterer igjennom resept listen som tilhører pasienten.
                for(Resept r : resept){
                    if(r.pasient == pasientObjekt);
                    pasientensResepter.leggTil(r);
                }


                // Skriver ut resepter
                System.out.println("Hvilken resept vil du bruke?");
                int reseptTeller = 0;
                for(Resept x : pasientensResepter){
                    System.out.println(reseptTeller+": " + x.hentLegemiddel() + " (fnr " + x.hentReit()+")");
                    teller++;
                }


                //Velger resept ut ifra indeks fra teller og bruker metoden "bruk"
                int svarResept = input.nextInt();
                Resept reseptObjekt = resept.hent(svarResept);
                
                if(reseptObjekt.reit == 0){
                    System.out.println("Kunne ikke bruke resept. Ingen reit igjen.");
                    break;
                }
                
                
                else{
                    reseptObjekt.bruk();
                    System.out.println("Reit etter bruk: " + reseptObjekt.reit);
                    break;
                }
            }
            





            ////// Logikken for å printe ut forskjellige former for statistikk
            else if(svar.toLowerCase().compareTo("p") == 0) {
                
                        
                // Har ansvaret for å 
                while( svar != "q") {
                    
                    System.out.print(
                    "\n(V)anedannende legemiddelresepter\n"+
                    "(N)arkotiske legemiddelresepter\n"+
                    "(L)eger som har skrevet narkotiske legemidler\n"+
                    "(P)asienter med gyldig narkotisk resept\n"+
                    "(Q)uit submeny\n"+
                    "Skriv inn oensket kommando: "
                );
                    
                    svar = input.next();

                    if(svar.toLowerCase().compareTo("v") == 0){
                        System.out.println(skrivUtVanedannendeAntall());
                    }

                    else if(svar.toLowerCase().compareTo("n") == 0){
                        System.out.println(skrivUtNarkotiskAntall());
                    }

                    else if(svar.toLowerCase().compareTo("l")==0){
                        skrivUtLegerMedNarkotiskResept();
                    }

                    else if(svar.toLowerCase().compareTo("p") == 0){
                        skrivPasienterMedNarkotiskResept();
                    }

                    else if(svar.toLowerCase().compareTo("q") == 0){
                        System.out.println("Gaar til forrige meny\n");
                        break;
                    }

                    else{
                        System.out.println("Ulovlig input\n");
                    }
                    
                }
            }
            



            ///// Logikken for å skrive alle data til fil
            else if(svar.toLowerCase().compareTo("l") == 0){

                try {
                    skrivTilFil();
                } catch (IOException e) {
                    System.out.println("Ugyldig");
                }
            }
                

            ////// Logikken når det er ugyldig input
            else{
                System.out.println("ugyldig input");
                PrintHovedMeny();
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


