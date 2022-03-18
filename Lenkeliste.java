import java.util.Iterator;
class Test{
    public static void main(String[] args) {
        Koe<String> ny = new Koe<>();
        ny.leggTil("Hans");
        ny.leggTil("Hans1");
        ny.leggTil("Hans2");
        ny.leggTil("Hans3");
        for (String x : ny) {
            System.out.println(x);
        }
    }
    
}
abstract class Lenkeliste <T> implements Liste<T> {


    public Iterator<T> iterator(){
        return new LenkelisteIterator();
    }

    class LenkelisteIterator implements Iterator<T>{
        Node ny = forste;

        @Override
        public boolean hasNext(){
            return ny != null;
        }

        @Override
        public T next(){
            if( hasNext()){
                Node midl = ny;
                ny = ny.neste;
                return midl.hentData();
            }
            return null;
        }

    } 

    



    public  Node forste;

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

    public T hentn(int posisjon){
        
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