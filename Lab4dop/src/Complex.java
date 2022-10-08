public class Complex {

    private double Re;
    private double Im;

    public double getRe() {
        return Re;
    }

    public void setRe(double re) {
        Re = re;
    }

    public double getIm() {
        return Im;
    }

    public void setIm(double im) {
        if (im == 0)
            Im = 1;
        else
            Im = im;
    }

    public Complex() {
    }

    public Complex(double re, double im) {
        this.Re = re;
        this.setIm(im);
    }

    @Override
    public String toString() {
        String str = "";
        if (Im >= 0) {
            str = "z=" + Re + "+" + Im + "i";
        } else {
            str = "z=" + Re + "" + Im + "i";
        }
        return str;
    }

    public double abs() {
        return Math.sqrt(Re * Re + Im * Im);
    }

    public Complex[] absN(int n) {

        double absN = Math.pow(abs(), 1.0 / n);
        double argZ = 0;
        if (Re > 0 && Im >= 0) {
            argZ = Math.atan((Im / Re));
        } else if (Re < 0 && Im >= 0) {
            argZ = Math.PI - Math.atan(Im / Re);
        } else if (Re < 0 && Im < 0) {
            argZ = Math.PI + Math.atan(Im / Re);
        } else if (Re > 0 && Im < 0) {
            argZ = 2.0 * Math.PI - Math.atan(Im / Re);
        } else if (Re == 0 && Im > 0) {
            argZ = Math.PI / 2.0;
        } else if (Re == 0 && Im < 0) {
            argZ = 3.0 * Math.PI / 2.0;
        }
        Complex[] c = new Complex[n];
        for (int i = 0; i < n; i++) {
            double a1 = (argZ + 2 * n * i) / n;
            double re = absN * Math.cos(a1);
            double im = Math.sin(a1);
            c[i] = new Complex(re, im);
        }
        return c;
    }

    public Complex sum(Complex c) {
        return new Complex((this.getRe() + c.getRe()), (this.getIm() + c.getIm()));
    }

    public Complex min(Complex c) {
        return new Complex((this.getRe() - c.getRe()), (this.getIm() - c.getIm()));
    }

    public Complex prod(Complex d) {
        return new Complex((this.getRe() * d.getRe() - this.getIm() * d.getIm()), (this.getRe() * d.getIm() + this.getIm() * d.getRe()));
    }

    public Complex prod(double k) {
        return new Complex((k * (this.getRe())), (k * (this.getIm())));
    }

    public Complex div(Complex c) {
        return new Complex(((this.getRe() * c.getRe() + this.getIm() * c.getIm()) / (c.getRe() * c.getRe() + c.getIm() * c.getIm())), ((this.getIm() * c.getRe() - this.getRe() * c.getIm()) / (c.getRe() * c.getRe() + c.getIm() * c.getIm())));
    }

    public Complex inc() {
        return new Complex((this.getRe() + 1.0), (this.getIm() + 1.0));
    }


}
