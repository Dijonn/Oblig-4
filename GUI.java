import java.util.Scanner;
public class GUI {
    public static void main(String[] args) {
        
        System.out.println(
            "(S)krive ut en fullstendig oversikt over pasienter, leger, legemidler og resepter\n" +
            "(O)pprette og legge til nye elementer i systemet \n" +
            "(B)ruke en gitt resept fra listen til en pasient \n" +
            "(P)rint ut forskjellige former for statistikk \n" +
            "(L)age ny fil og skrive alle data til fil ");
        System.out.print("Skriv inn oensket kommando: ");

        Scanner input = new Scanner(System.in);
        String svar = input.next();

        if(svar.toLowerCase().compareTo("s") == 0){
            //ikke lagt inn funksjons
            System.out.println("Skrive ut en fullstendig oversikt over pasienter, leger, legemidler og resepter (deloppgave E3).");
        }

        else if(svar.toLowerCase().compareTo("o") == 0){
            //ikke lagt inn funksjon
            System.out.println("Opprette og legge til nye elementer i systemet (deloppgave E4).");
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
    }
    

    
}
