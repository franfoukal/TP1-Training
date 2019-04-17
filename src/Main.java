import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        List<Thread> threadList = new ArrayList<>();
        Random randomP = new Random();

        for(int i = 0; i < randomP.nextInt(20); i++){
            threadList.add(new Thread(new Producer(buffer, "Productor " + i)));
            threadList.get(i).start();
        }


        Thread consumidor1 = new Thread(new Consumer(buffer, "Consumidor 1"));
        Thread consumidor2 = new Thread(new Consumer(buffer, "Consumidor 2"));

        consumidor1.start();
        consumidor2.start();


    }
}
