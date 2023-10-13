import java.util.HashSet;

public class TraceBack {

    HashSet<HashSet<Integer>> res;
    private int a[];
    public HashSet<HashSet<Integer>> traceBack(int n, int k) {
//        please enter your code here...
        a = new int[n+1];
        res = new HashSet<HashSet<Integer>>();
        a[0] = k;
        Comb(n, k);
        return res;
    }

    public void Comb(int n, int k) {
        if(k <= 0 || k > n) {
            res.add(new HashSet<Integer>());
            return;
        }
        for(int i = n; i >= k; --i) {
            a[k] = i;
            if(k > 1) Comb(i-1, k-1);
            else {
                HashSet<Integer> tmp = new HashSet<Integer>();
                for(int j = a[0]; j > 0; j--) {
                    tmp.add(a[j]);
                }
                res.add(tmp);
            }
        }
    }

//    public static void main(String[] args) {
//        TraceBack traceBack = new TraceBack();
//        System.out.println(traceBack.traceBack(3, 0));
//    }

}
