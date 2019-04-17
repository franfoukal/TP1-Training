

public class Consumer implements Runnable{

    private Buffer buffer;
    private String name;

    public Consumer(Buffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }


    @Override
    public void run() {
        while (buffer.isNotFull() || buffer.getStorageSize()>0){
            try {
                buffer.getBuffer(name);
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
