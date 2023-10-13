//此oj需要手动引入工具类，直接用会报“编译或运行失败”，如需要用ArrayList，需要手动引入，
//如：import java.util.ArrayList;

//只测试了暴力求解和公式法，都是可以通过的，测试用例比较少，不用担心；
//常见的问题都给了注释，还遇到bug找群里的小伙伴交流一下。

import java.util.ArrayList;

public class Josephus {
    public static int lastRemaining(int n, int m) {//不要更改这里的static修饰符
        // 具体代码写这里
        // 另外因为语言级别的问题，菱形操作符里的具体类型全部要写上，不然可能也会报错；
        // 如：ArrayList<Integer> list = new ArrayList<Integer>(n);
        ArrayList<Integer> list = new ArrayList<Integer>(n);
        for(int i = 0; i < n; ++i) {
            list.add(i);
        }
        int Itr = 0;
        for(int i = 0; i < n-1; ++i) {
            Itr += m-1;
            Itr %= list.size();
            if(Itr == list.size()-1) {
                list.remove(Itr);
                Itr = 0;
            } else list.remove(Itr);

        }
        return list.get(0);//这里return自己的结果
    }
}

