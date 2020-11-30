//make "pair" utility in c++ to java
package PlayGuitar;

public class pair<F, S> {
    public pair(F f, S s) {
        first = f;
        second = s;
    }

    //it will be public because
    //user can easily access to those vars
    public F first;
    public S second;
}
