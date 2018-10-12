package Java_2.Lessons;

public class FirstMethod {

    static final int size = 10000000;
    float[] arr;
    long a;

    public void calculate() {
        arr = new float[size];
        for (int i = 0; i <size; i++){
            arr[i] = 1.0f;
        }
        a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        a = System.currentTimeMillis() - a;
        System.out.println("Время выполнения первого метода составило: " + a + " миллисекунд");
    }

}
