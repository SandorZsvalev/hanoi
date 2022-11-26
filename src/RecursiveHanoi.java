import java.util.Stack;

public class RecursiveHanoi {

    private Stack<Integer> start;
    private Stack<Integer> buff;
    private Stack<Integer> finish;

    int numberOfDiscs;

    public RecursiveHanoi (Stack<Integer> start, Stack<Integer> buff, Stack<Integer> finish, int numberOfDiscs) {
        this.start = start;
        this.buff = buff;
        this.finish = finish;
        this.numberOfDiscs = numberOfDiscs;
    }

    public void transferAll(){
        hanoiTowerRecursive(numberOfDiscs,start,finish,buff);
    }

    private void hanoiTowerRecursive(int n, Stack<Integer> start, Stack<Integer> finish, Stack<Integer> buff){
        if (n == 0){
            return;
        }
        hanoiTowerRecursive(n-1,start,buff,finish);
        moveElement(start,finish);
        hanoiTowerRecursive(n-1,buff,finish,start);
    }

    private void moveElement(Stack<Integer> source, Stack<Integer> target){
        int el = source.pop();
        target.push(el);
    }

}
