//不可变的复数类，注意equals和hashcode的写法
public final class Complex {

    private final double re;
    private final double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex add(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }

    //此处省略相加以外的其他方法


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Complex)) {
            return false;
        }

        Complex c = (Complex)obj;
        return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

//    private int hashDouble(double val) {
//        long longBits = Double.doubleToLongBits(val);
//        return (int) (longBits ^ (longBits >>> 32));
//    }

    @Override
    public String toString() {
        return "(" + re + "," + im + ")";
    }

}
