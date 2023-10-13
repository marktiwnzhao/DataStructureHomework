public class TowerOfHanoi {
    public void Hanoi(int n) {
        // please enter your code here...
        char a = 'A';
        char b = 'B';
        char c = 'C';
        MoveDisks(n, a, b, c);
    }

    public void MoveDisks(int n, char fromTower, char toTower, char auxTower) {
        if(n == 1) {
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
        } else {
            MoveDisks(n-1, fromTower, auxTower, toTower);
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            MoveDisks(n-1, auxTower, toTower, fromTower);
        }
    }

    public static void main(String[] arg) {
        TowerOfHanoi hanoi = new TowerOfHanoi();
        hanoi.Hanoi(2);
    }
}
