package hunter;

import animal.Deer;

public class Hunter extends Deer{
    public void hunt() {
        mav();
    }

    public static void main(String[] args) {
        Hunter deer = new Hunter();
        deer.mav();
    }

    protected void mav() {

    }
}

class Manag {
    public void acd() {
        Deer d = new Hunter();
        ((Hunter) d).mav();
    }
}