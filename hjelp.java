class Test{
    public static void main(String[] args) {
        Koe<String> ny = new Koe<>(); 
        ny.leggTil("x");
        ny.leggTil("1");
        for(String x: ny){
            System.out.println(x);
        }
    }
}