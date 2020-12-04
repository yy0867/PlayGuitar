//make "pair" utility from C++ to Java class
public class pair<F extends Number, S extends Number> implements Comparable<pair<F, S>> {
    public pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    @Override //sort base
    public int compareTo(pair<F, S> p) {
        return p.first.intValue() - first.intValue();
    }

    //public because user can easily access
    public F first;
    public S second;
}
