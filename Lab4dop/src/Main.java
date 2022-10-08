public class Main {
    public static void main(String[] args) {
        Complex a = new Complex(5, 6);
        Complex b = new Complex(0, 0);
        Complex c = new Complex(-1, -1);
        Complex d = new Complex(-1, -1);
        System.out.println(a.toString() + " Abs= " + a.abs() + "\n" + b.toString() + " Abs= " + b.abs() + "\n" + c.toString() + " Abs= " + c.abs() + "\n" + d.toString() + " Abs= " + d.abs());
        System.out.println("***The result***");
        Complex[] fullResult = new Complex[3];
        Complex act1 = b.prod(d);
        Complex act2 = b.sum(c);
        Complex act3 = act2.div(a);
        Complex[] act4 = a.absN(fullResult.length);
        Complex[] act5 = new Complex[fullResult.length];
        for (int i = 0; i < act4.length; i++) {
            act5[i] = act4[i].min(act3);
            fullResult[i] = act5[i].sum(act1);
            System.out.println(fullResult[i]);
            System.out.println("Abs= " + fullResult[i].abs());
            System.out.println("Inc= " + fullResult[i].inc());
        }

    }
}

