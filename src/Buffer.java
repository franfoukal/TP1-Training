import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

    private int maxSize;
    private Queue<Date> storage;
    private int descartedProducts;
    private int notDescartedProducts;
    private int consumedProducts;
    private int totalProduced;
    private boolean isNotFull;

    public Buffer() {
        this.maxSize = 10;
        this.descartedProducts = 0;
        this.notDescartedProducts = 0;
        this.consumedProducts = 0;
        this.storage=new LinkedList<>();
        this.isNotFull = true;
        this.totalProduced= 0;

    }

    //

    public synchronized void setBuffer(String name){

        totalProduced++;

        if(storage.size() == maxSize){
            descartedProducts++;
            System.out.println(name + "\t - Producido: " + notDescartedProducts + " Consumido: " + consumedProducts + " Descartado: " + descartedProducts);
            notifyAll();
            return;
        }
        storage.add(new Date());
        notDescartedProducts++;
        System.out.println(name + "\t - Producido: " + notDescartedProducts + " Consumido: " + consumedProducts + " Descartado: " + descartedProducts);
        notifyAll();
    }

    public synchronized void getBuffer(String name){

        while(storage.size() == 0){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            storage.poll();
            consumedProducts++;
            System.out.println(name + "\t - Producido: " + notDescartedProducts + " Consumido: " + consumedProducts + " Descartado: " + descartedProducts);
            //notify();
    }

    public boolean isNotFull() {
        isNotFull = totalProduced < 100;
        return isNotFull;
    }

    public int getStorageSize(){
        return storage.size();
    }


}
