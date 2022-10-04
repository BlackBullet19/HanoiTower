package iterationTowerOfHanoi;

import java.util.Stack;

public class HanoiIterationMain {
    public static void main(String[] args) {

        Stack<Integer> left = new Stack<>();
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> right = new Stack<>();

        left.push(5);
        left.push(4);
        left.push(3);
        left.push(2);
        left.push(1);

        left.forEach(el -> System.out.print(el + " "));

        int diskCount = 5;
        if (diskCount % 2 == 0) {
            play(diskCount, left, right, middle);
        } else {
            play(diskCount, left, middle, right);
        }

        System.out.println();
        System.out.println("You win! Congratulations!");
        right.forEach(el -> System.out.print(el + " "));
    }

    static void play(int n, Stack<Integer> from, Stack<Integer> helper, Stack<Integer> to) {
        int totalNumOfMoves = (int) (Math.pow(2, n) - 1);
        for (int i = 1; i <= totalNumOfMoves; i++) {
            if (i % 3 == 1)
                moveDisks(from, to);
            else if (i % 3 == 2)
                moveDisks(from, helper);
            else if (i % 3 == 0)
                moveDisks(helper, to);
        }
    }

    static void moveDisks(Stack<Integer> a, Stack<Integer> b) {
        if (a.empty()) {
            a.push(b.pop());
        } else if (b.empty()) {
            b.push(a.pop());
        } else if (a.peek() > b.peek()) {
            a.push(b.pop());
        } else if (b.peek() > a.peek()) {
            b.push(a.pop());
        }
    }
}
