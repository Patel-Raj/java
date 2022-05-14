package animal;

enum AB {
    man(20),hat(10);
    private int coder;
    AB(int a) {
        coder = a;
    }

    int getCoder() {
        return coder;
    }
}
public class Deer {
    public static void main(String[] args) {
        AB ab;
        for(AB a : AB.values()) {
            System.out.println(a + " " + a.getCoder());
        }
    }

    protected void mav(){}
}
