import java.util.*;

public class KStacks {
    public static int maximizeScore(List<Stack<Integer>> S, int x) {
        int c=0;
        int sum=0;
        Stack<Integer> store= new Stack<>();
        PriorityQueue<Stack<Integer>> pq = new PriorityQueue<>(Comparator.comparing(Stack<Integer>::peek));
        if(x==0){
            return 0;
        }
        for (int i = 0; i <S.size() ; i++) {
            pq.add(S.get(i));
        }
        while(sum<x){
            store=pq.poll();
            sum+=store.pop();
            if(!store.isEmpty()){
                pq.add(store);
            }
            c++;
        }
        if(sum>x) {
            c--;
        }
        return c;
    }
    // Convenient class (you can but don't need to use it.)
    static class StackBuilder<T> {
        private Stack<T> stk;
        public StackBuilder() { this.stk = new Stack<>(); }

        public StackBuilder<T> push(T elt) {
            stk.push(elt);
            return this;
        }
        public Stack<T> build() { return stk; }
    }
    // To use the StackBuilder, you write, for example,
    //    new StackBuilder<Integer>().push(6).push(3).push(1).build()
    //  This will make a stack and push these elements into the stack in that order.
    //  The build() command at the end returns the final stack.
    public static void main(String[] args) {
        List<Stack<Integer>> stacks = Arrays.asList(
                new StackBuilder<Integer>().push(6).push(3).push(1).build(),  // stack [6, 3, 1] (1 is the top)
                new StackBuilder<Integer>().push(9).push(5).push(2).push(1).build(), // stack [9, 5, 2, 1] (1 is the top)
                new StackBuilder<Integer>().push(4).push(1).build() // stack [4, 1] (1 is the top)
        );
        int expcted = 5;
        int result = maximizeScore(stacks, 9);
        System.out.println("Verdict: "+ (expcted == result));
    }
}
