
public class Producer implements Runnable {

    private Buffer buffer;
    private String name;

    public Producer(Buffer buffer, String name) {
        this.buffer = buffer;
        this.name = name;
    }


    @Override
    public void run() {

        while(buffer.isNotFull()) {
            try {
                buffer.setBuffer(name);
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
