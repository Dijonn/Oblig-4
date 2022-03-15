import java.util.Iterator;

abstract class Lenkeliste <T> implements Liste<T> {

    public  Node forste;

    public  Iterator<T> Iterator(){
        LenkelisteIterator nyListe = new LenkelisteIterator();
        return nyListe; 
    }

    class LenkelisteIterator implements Iterator<T>{
        Node node = forste;
        public boolean hasNext(){
            return node.neste != null;
        }
        public T next(){
            if(node.neste != null){
                forste = node.neste;
                return node.neste.hentData();
            }
            return null;
        }
    }
    public class Node{

        Node neste = null;
        T data;
    

        Node(T x){
            data = x;
        }

        public T hentData(){
            if(data !=null){
                return data;
            }
            return null;
            
        }
    }

    

    public int stoerrelse(){
        //finner størrelsen til lenkeliste og stabel
        int teller = 0;
        Node tmp = forste;
        while(tmp != null){
            tmp = tmp.neste;  //midlertidig node blir neste node.
            teller++;
    
        }
        return teller;
    }

    public void leggTil(T x){
        Node nyNode = new Node(x);
        
        //forste er null gir ny=forste
        if(forste == null){
            forste = nyNode;
        }

        //hvis forste ikke er null må vi komme oss til slutten av listen
        //og sette neste variabelen til nest siste element til den nye noden. 
        else{
            Node tmp = forste;
            while(tmp.neste != null) {
                tmp = tmp.neste;
            }
            tmp.neste = nyNode;
        }
    }

    public T hent(){
        return forste.hentData();
    }

    public T fjern(){
        
        Node tmp = forste;
        if(forste != null){
            if(forste.neste != null){
                forste = forste.neste;
            }
            else{
                forste = null;
            }
            return tmp.hentData();
        }
        throw new UgyldigListeindeks(-1);
    }

    public String toString(){

        String svarstreng = "";
        Node tmp = forste;

        while(tmp !=  null){
            svarstreng += tmp.hentData();
            tmp = tmp.neste;
        }
        return svarstreng;
    }
}
