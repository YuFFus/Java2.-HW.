package Java_2.Lessons;

public class SecondMethod {

    ThreadedCalculation t1, t2;
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr, a1, a2;
    long a;

    public void calculate() {
        arr = new float[size];
        a1 = new float[h];
        a2 = new float[h];
        for (int i = 0; i <size; i++){
            arr[i] = 1.0f;
        }
        a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        t1 = new ThreadedCalculation("Первый поток", a1);
        t2 = new ThreadedCalculation("Второй поток", a2);
        try {
            t1.t.join();
            t2.t.join();
        }
        catch (InterruptedException e) {
            System.out.println("Что-то пошло не так");
        }
        System.arraycopy(t1.arr, 0, arr, 0, h);
        System.arraycopy(t2.arr, 0, arr, h, h);
        a = System.currentTimeMillis() - a;
        System.out.println("Время выполнения второго метода составило: " + a + " миллисекунд");
    }
}
