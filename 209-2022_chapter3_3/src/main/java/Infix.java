import java.util.Stack;

public class Infix {
    public float infix(String[] tokens) {
        // please enter your code here...
        Stack<Character> opStack = new Stack<Character>();//操作符栈
        Stack<Float> numStack = new Stack<Float>();//操作数栈
        String tmp;
        char op1, op2;
        float a, b;
        for(int i = 0; i < tokens.length; ++i) {
            tmp = tokens[i];
            if(tmp.matches("[0-9]+")) {
                numStack.push(Float.parseFloat(tmp));
            } else {
                op2 = tmp.charAt(0);
                if(opStack.empty()) opStack.push(op2);
                else if(op2 == ')') {
                    op1 = opStack.pop();
                    while(op1 != '(') {
                        b = numStack.pop();
                        a = numStack.pop();
                        numStack.push(Cul(op1, a, b));
                        op1 = opStack.pop();
                    }
                }
                else {
                    op1 = opStack.peek();
                    if(Priority(op1, op2)) opStack.push(op2);
                    else {
                        op1 = opStack.pop();
                        while(!Priority(op1, op2)) {
                            b = numStack.pop();
                            a = numStack.pop();
                            numStack.push(Cul(op1, a, b));
                            if(opStack.empty()) break;
                            else op1 = opStack.pop();
                            if(op1 == '(') {
                                opStack.push(op1);
                                break;
                            }
                        }
                        opStack.push(op2);
                    }
                }
            }
        }
        while(!opStack.empty()) {
            op2 = opStack.pop();
            b = numStack.pop();
            a = numStack.pop();
            numStack.push(Cul(op2, a, b));
        }
        return numStack.pop();
    }
    private boolean Priority(char op1, char op2) {
        if(op2 == '(' || op1 == '(') return true;
        if((op2 == '*' || op2 == '\\') && (op1 == '+' || op1 == '-' || op1 == '(')) return true;
        return false;
    }
    private float Cul(char op, float a, float b) {
        switch (op) {
            case '+':
                a = a+b;
                break;
            case '-':
                a = a-b;
                break;
            case '*':
                a = a*b;
                break;
            case '/':
                a = a/b;
        }
        return a;
    }
    public static void main(String args[]) {
        Infix infix = new Infix();
        String[] s = new String[]{"(", "1", "*", "2", "+", "2", "*", "3", ")"};
        System.out.println(infix.infix(s));
    }
}