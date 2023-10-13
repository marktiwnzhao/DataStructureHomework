public class PolynList {

    //多项式相加
    public Node add(Node link1, Node link2) {
        // please enter your code here...
        Node res = new Node();
        Node p = res;
        Node pa = link1.next;
        Node pb = link2.next;
        while(pa != null && pb != null) {
            if(pa.exp == pb.exp) {
                pa.coef += pb.coef;
                pb = pb.next;
                if(pa.coef == 0) pa = pa.next;
                else {
                    p.next = pa;
                    pa = pa.next;
                    p = p.next;
                }
            } else if(pa.exp < pb.exp) {
                p.next = pa;
                pa = pa.next;
                p = p.next;
            } else {
                p.next = pb;
                pb = pb.next;
                p = p.next;
            }
        }
        if(pa == null) p.next = pb;
        else p.next = pa;
        return res.next;
    }
}
