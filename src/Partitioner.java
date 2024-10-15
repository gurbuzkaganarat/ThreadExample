import java.util.ArrayList;
import java.util.List;

public class Partitioner {

    public static List<List<Integer>> partitionList(List<Integer> list , int partSize){

        List<List<Integer>> partitions= new ArrayList<>();
        for (int i = 0 ; i<list.size(); i+= partSize){
            partitions.add(new ArrayList<>(list.subList(i, Math.min(i + partSize, list.size()))));
        }
        return  partitions;
    }
}
