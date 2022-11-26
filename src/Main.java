import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack<Integer> start = new Stack<>();
        Stack<Integer> buff = new Stack<>();
        Stack<Integer> finish = new Stack<>();

        start.push(5);
        start.push(4);
        start.push(3);
        start.push(2);
        start.push(1);


        System.out.println("start: " + start);
        System.out.println("Собрали элементы на старте и запускаем итеративное решение");
        IterativeHanoi iterativeHanoi = new IterativeHanoi(start, buff, finish, start.size());
        iterativeHanoi.transferAll();

        System.out.println("start: " + start);
        System.out.println("buff: " + buff);
        System.out.println("finish: " + finish);


        System.out.println("\nfinish: " + finish+"\nСобрали элементы на финише и перекладываем на старт рекурсивно");

        RecursiveHanoi recursiveHanoi = new RecursiveHanoi(finish,buff,start,finish.size());
        recursiveHanoi.transferAll();
        System.out.println("\nstart: " + start);
        System.out.println("buff: " + buff);
        System.out.println("finish: " + finish);
    }


}