import java.util.Iterator;

class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T>{

    @Override
    public void leggTil(T x) {
        //må legge en på stoerrelse slik at man ikke keaster feil med en gang.

        Node nyNode = new Node(x); 
        
        //forste er null gir forste = nyNode
        if(forste == null){
            forste = nyNode;
        }
        
        if(forste.hentData().compareTo(nyNode.hentData()) > 0 ){
            Node hjelp = forste;
            nyNode.neste = hjelp;
            forste = nyNode;
        }
        
        else{
            Node tmp = forste;

            while(tmp != null){    
                
                // -1 hvis elementet til venstre er mindre enn det til høyre.
                
                
                if(tmp.hentData().compareTo(nyNode.hentData()) > 0 || tmp.neste == null){
                    Node hjelp = tmp.neste;
                    tmp.neste = nyNode;
                    nyNode.neste = hjelp;
                    break;
                }

                else if(tmp.hentData().compareTo(nyNode.hentData()) == 0){
                    Node hjelp = tmp.neste;
                    nyNode.neste = hjelp;
                    tmp.neste = nyNode;
                    break;
                }
                tmp = tmp.neste;
                
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
}