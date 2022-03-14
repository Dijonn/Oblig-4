class Stabel<T> extends Lenkeliste<T> {
    @Override
    public void leggTil(T x){
        Node ny = new Node(x);
        if(forste != null){
            ny.neste = forste;
            forste = ny; 
            return;
        }
        forste = ny;
    }
}
