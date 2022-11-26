import java.util.Stack;

import static java.lang.Math.pow;

public class IterativeHanoi {

    private Stack<Integer> start;
    private Stack<Integer> buff;
    private Stack<Integer> finish;

    int numberOfDiscs;

    public IterativeHanoi(Stack<Integer> start, Stack<Integer> buff, Stack<Integer> finish, int numberOfDiscs) {
        this.start = start;
        this.buff = buff;
        this.finish = finish;
        this.numberOfDiscs = numberOfDiscs;
    }

    private int calculateIteration (){
        return (int) pow(2,numberOfDiscs)-1;
    }

    private void checkDestination (){
        Stack<Integer> destination;
        if (numberOfDiscs % 2 == 0) {
            destination = buff;
            buff = finish;
            finish = destination;
        }
    }

    private void moveElement (Stack<Integer> source, Stack<Integer> target, String src, String trg){
        if (source.empty()){
            int el = target.pop();
            System.out.println(el + " c "+trg+" на "+src);
            source.push(el);
        } else if (target.empty()) {
            int el = source.pop();
            System.out.println(el + " c "+src+" на "+trg);
            target.push(el);
        } else {
            int elOne = source.pop();
            int elTwo = target.pop();
            if (elOne > elTwo){
                source.push(elOne);
                source.push(elTwo);
                System.out.println(elTwo + " c "+trg+" на "+src);
            } else {
                target.push(elTwo);
                target.push(elOne);
                System.out.println(elOne + " c "+src+" на "+trg);
            }
        }
    }

    public void transferAll (){
        int steps = calculateIteration();
        checkDestination();
        for (int i = 1; i <= steps; i++) {
            if (i%3 == 1){
                System.out.print("i = "+i+" переместили элемент ");
                moveElement(start,finish, "старт", "финиш");
            }
            if (i%3 == 2){
                System.out.print("i = "+i+" переместили элемент ");
                moveElement(start,buff,"старт","буфер");
            }
            if (i%3 == 0){
                System.out.print("i = "+i+" переместили элемент ");
                moveElement(buff,finish, "буфер", "финиш");
            }
        }
    }
}
