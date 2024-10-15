import java.util.List;

public class NumberThreads  implements Runnable {

    private List<Integer> listToProcess;
    private List<Integer> oddNumbers;
    private List<Integer> evenNumbers;

    public NumberThreads(List<Integer> listToProcess, List<Integer> oddNumbers, List<Integer> evenNumbers) {
        this.listToProcess = listToProcess;
        this.oddNumbers = oddNumbers;
        this.evenNumbers = evenNumbers;
    }
@Override
    public void run() {

            for (int num : listToProcess){
                if(num % 2 == 0){
                    addEvenNumber(num);
                }
                else {
                    addOddNumber(num);
                }
            }
    }

    private synchronized void addOddNumber(int num){
        oddNumbers.add(num);
    }

    private  synchronized  void addEvenNumber(int num){
        evenNumbers.add(num);
    }

    public List<Integer> getListToProcess() {
        return listToProcess;
    }

    public List<Integer> getOddNumbers() {
        return oddNumbers;
    }

    public List<Integer> getEvenNumbers() {
        return evenNumbers;
    }
}
