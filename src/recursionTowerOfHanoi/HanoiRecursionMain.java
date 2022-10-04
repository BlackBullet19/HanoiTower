package recursionTowerOfHanoi;

import java.util.Stack;

public class HanoiRecursionMain {

    public static void main(String[] args) {


        Stack<Integer> left = new Stack<>();
        Stack<Integer> middle = new Stack<>();
        Stack<Integer> right = new Stack<>();

        left.push(5);
        left.push(4);
        left.push(3);
        left.push(2);
        left.push(1);
        int diskCount = 5;

        left.forEach(el -> System.out.print(el + " "));
        play(diskCount,left, right, middle);
        System.out.println();
        System.out.println("You win! Congratulations!");
        right.forEach(el -> System.out.print(el + " "));
    }

    static void play(int n, Stack<Integer> from, Stack<Integer> to, Stack<Integer> helper) {

        if(n==1){
            to.add(from.pop());
            return;
        }
        play(n-1, from, helper, to);
        to.add(from.pop());
        play(n-1, helper, to, from);
    }

}
