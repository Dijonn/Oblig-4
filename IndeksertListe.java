

public class IndeksertListe<T> extends Lenkeliste<T> {

    public void leggTil(int posisjon, T x){
        
        //må legge en på stoerrelse slik at man ikke keaster feil med en gang.
        if(posisjon > stoerrelse()+1 || posisjon < 0){
            throw new UgyldigListeindeks(-1);
        }

        Node nyNode = new Node(x); 
        
        //forste er null gir forste = nyNode
        if(forste == null){
            forste = nyNode;
        }
        
        
        else{
            int peker = 0;
            Node tmp = forste;

            while(tmp != null){
                peker++;
                if(peker == posisjon){
                    nyNode.neste = tmp.neste;
                    tmp.neste = nyNode;
                }

                else if(posisjon == 0 && forste != null){
                    nyNode.neste = tmp;
                    forste = nyNode;
                    break;
                }
                tmp = tmp.neste;
            }
        }
    }

    public void sett(int posisjon, T x){
        //må gjøre det slik med -1 siden listene begynner fra 0 
        if(posisjon > stoerrelse()-1 || posisjon < 0){
            throw new UgyldigListeindeks(-1);
        }
        fjern(posisjon);
        leggTil(posisjon, x);
    }
    
    public T hent(int posisjon){
        
        if(posisjon > stoerrelse() || posisjon < 0){
            throw new UgyldigListeindeks(-1);
        }

        int peker = 0;
        Node tmp = forste;

        while(tmp != null){
            
            //legger inn +1 siden listen igjen ikke 
            if(peker == posisjon){
                return tmp.hentData();
            }

            peker++;
            tmp = tmp.neste;
        }
        return null;
    }

    public T fjern(int posisjon){
        //legger inn -1 her siden vi starter på indeks 0 og ikke 1. 
        if(posisjon > stoerrelse()-1 || posisjon < 0){
            throw new UgyldigListeindeks(-1);
        }

        int peker = 0;
        Node tmp = forste;

        while(tmp != null){
            
            //gjoer denne sjekken for å se elementet før det vi skal fjerne
            //slik trenger vi ikke å bruke en forrige peker i nodene. 
            if(peker == posisjon-1){
                if(tmp.neste != null){
                    Node hjelp = tmp.neste;
                    tmp.neste = tmp.neste.neste;
                    return hjelp.hentData();
                }
            }

            //legger inn denne i tilfelle man skal fjerne det første elementet
            if(posisjon == 0){
                tmp = forste;
                forste.neste = forste;
                return tmp.hentData();
            }
            
            peker++;
            
            tmp = tmp.neste;
        }
        return null;
    }
}