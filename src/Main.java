import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

         List<Integer> oddNumbers = new ArrayList<>();
         List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i<= 10000; i++){
            numbers.add(i);
        }

        System.out.println("Liste basarıyla olusturuldu" + numbers.size() + " eleman var");

        List<List<Integer>> partitionedList = Partitioner.partitionList(numbers,2500);

        Thread t1 = new Thread(new NumberThreads(partitionedList.get(0) , oddNumbers,evenNumbers));
        Thread t2 = new Thread(new NumberThreads(partitionedList.get(1) , oddNumbers,evenNumbers));
        Thread t3 = new Thread(new NumberThreads(partitionedList.get(2) , oddNumbers,evenNumbers));
        Thread t4 = new Thread(new NumberThreads(partitionedList.get(3) , oddNumbers,evenNumbers));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("Tek Sayılar: " + oddNumbers.size());
        System.out.println("Çift Sayılar: " + evenNumbers.size());








    }
}