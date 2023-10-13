//此oj需要手动引入工具类，直接用会报“编译或运行失败”，如需要用ArrayList，需要手动引入，
//如：import java.util.ArrayList;

public class BinTree {
    private char element;
    BinTree left, right;

    public BinTree() {
    }

    BinTree(char element, BinTree left, BinTree right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    /**
     * 使用递归方法，根据先序遍历和中序遍历结果，创建一棵二叉树
     * @param pres 先序遍历字符数组
     * @param ins 中序遍历字符数组
     * @Example
     *      BinTree root = BinTree.CreateBT("ABDCEGFHI", "DBAEGCHFI");
     */
    public static BinTree CreateBT(char[] pres, char[] ins){
        // please enter your code here...
        int inpos;
        BinTree temp;
        char[] prestemp, instemp;

        if(pres.length == 0) return null;
        else {
            temp = new BinTree();
            temp.element = pres[0];
            inpos = 0;
            while(ins[inpos] != temp.element) ++inpos;

            prestemp = String.copyValueOf(pres, 1, inpos).toCharArray();
            instemp = String.copyValueOf(ins, 0, inpos).toCharArray();
            temp.left = CreateBT(prestemp, instemp);

            prestemp = String.valueOf(pres).substring(inpos+1).toCharArray();
            instemp = String.valueOf(ins).substring(inpos+1).toCharArray();
            temp.right = CreateBT(prestemp, instemp);

            return temp;
        }
    }

    /**
     * 使用递归方法，先序遍历二叉树
     * @param root  当前树
     * @return  遍历后的序列
     * @Example
     *      BinTree.PreOrderTraversal(root)
     */
    public static StringBuilder PreOrderTraversal(BinTree root) {
        // please enter your code here...
        return root.preOrder(root, new StringBuilder());
    }

    private StringBuilder preOrder(BinTree root, StringBuilder stringBuilder) {
        if(root != null) {
            stringBuilder.append(root.element);
            preOrder(root.left, stringBuilder);
            preOrder(root.right, stringBuilder);
        }
        return stringBuilder;
    }
    /**
     * 使用递归方法，中序遍历二叉树
     * @param root  当前树
     * @return  遍历后的序列
     * @Example
     *      BinTree.InOrderTraversal(root)
     */
    public static StringBuilder InOrderTraversal(BinTree root) {
        // please enter your code here...
        return root.inOrder(root, new StringBuilder());
    }

    private StringBuilder inOrder(BinTree root, StringBuilder stringBuilder) {
        if(root != null) {
            inOrder(root.left, stringBuilder);
            stringBuilder.append(root.element);
            inOrder(root.right, stringBuilder);
        }
        return stringBuilder;
    }
    /**
     * 使用递归方法，后序遍历二叉树
     * @param root  当前树
     * @return  遍历后的序列
     * @Example
     *      BinTree.PostOrderTraversal(root)
     */
    public static StringBuilder PostOrderTraversal(BinTree root) {
        // please enter your code here...
        return root.postOrder(root, new StringBuilder());
    }

    private StringBuilder postOrder(BinTree root, StringBuilder stringBuilder) {
        if(root != null) {
            postOrder(root.left, stringBuilder);
            postOrder(root.right, stringBuilder);
            stringBuilder.append(root.element);
        }
        return stringBuilder;
    }

}