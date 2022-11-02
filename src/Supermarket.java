import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
public class Supermarket {
    private ArrayList<Queue<String>> arrayCasse = new ArrayList<>(5);

    public Supermarket() {
        arrayCasse.add(new ArrayDeque<>(5));
    }

    public ArrayList<Queue<String>> getArrayCasse() {
        return arrayCasse;
    }

    public void pushPerson(String person){
        Queue<String> minQueue = arrayCasse.get(0);

        for (Queue<String> strings : arrayCasse) {
            if (minQueue.size() > strings.size()){
                minQueue = strings;
            }
        }

        if (minQueue.size() >= 5) {
            System.out.println("Позовите Галю. Создана новая очередь " + arrayCasse.size());
            arrayCasse.add(new ArrayDeque<>(5));
            System.out.println(person + " добавлен в очередь номер " + (arrayCasse.size()-1));
            arrayCasse.get(arrayCasse.size()-1).add(person);
        } else {
            System.out.println(person + " добавлен в очередь номер " + arrayCasse.indexOf(minQueue));
            minQueue.add(person);
        }
    }

    public void popPerson(){
        String person;
        int randomQueueNum;

        randomQueueNum = ThreadLocalRandom.current().nextInt(0, arrayCasse.size());
        person = arrayCasse.get(randomQueueNum).poll();

        if (person != null) {
            System.out.println(person + " обслужен");
        }else {
            System.out.println("Очередь " + randomQueueNum + " пустая.");
        }
    }
}
