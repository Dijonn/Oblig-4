class UlovligUtskrift extends Exception { 
    UlovligUtskrift (lege l, Legemiddel lm) {
         super("Legen "+l.hentNavn()+" har ikke lov til aa skrive ut "+lm.hentNavn()); 
        } 
    }