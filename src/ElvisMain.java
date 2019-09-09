import java.io.ObjectStreamConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

class Elvis implements Comparable<Elvis> {
    private static final Elvis[] e = new Elvis[3];
    public static final List<Elvis> f() {
        return  Collections.unmodifiableList(Arrays.asList(e));
    }
    private int ext;
    private Elvis() {
        System.out.println("ok");
    }

    public void func() {
        System.out.println("func");
    }

    @Override
    public int compareTo(Elvis o) {
        return ext - o.ext;
    }

    public void setExt(int ext) {
        this.ext = ext;
    }

    public int getExt() {
        return ext;
    }
}

class ElvisComparator implements Comparator<Elvis> {

    public static ElvisComparator INSTANCE = new ElvisComparator();
    private ElvisComparator() {}
    public static ElvisComparator getInstance() {
        return INSTANCE;
    }
    @Override
    public int compare(Elvis o1, Elvis o2) {
        return compareUtil(o1.getExt() - o2.getExt(), 0);
    }

    private int compareUtil(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 :1);
    }
}

class Super {
    public Super() {
        override();
    }
    public void override() {System.out.println(1);}
}

class Sub extends Super {
    private final Date date;
    public Sub() {
        date = new Date();
    }

    @Override
    public void override() {
        System.out.println(date);
    }

}

class Host {

    private static class StrLenCmp implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();

}

class Outer {

    private int i;

    public static class StaticInner {

    }

    public class Inner {
        public int a = i;
        public Outer fun() {
            return Outer.this;
        }
    }

    public void fun(int[] i, int a, int b) {
        assert i != null;
        assert a > 0;
        assert b < 0;
    }
}

enum Operation {
    PLUS("+"){
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-"){
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*"){
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/"){
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    abstract double apply(double x, double y);

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public int order() {
        return ordinal() + 1;
    }
}

public class ElvisMain {

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.fun(null, 1, -1);
        int[] i = {1, 2, 2, 4, 3};
        List<int[]> ints = Collections.singletonList(i);
        ints.toArray();
    }

}


