package Java_2.Lessons;

public class ThreadedCalculation implements Runnable {

    Thread t;
    float[] arr;

   public ThreadedCalculation (String name, float [] arr) {
       this.arr = arr;
       t = new Thread(this, name);
       System.out.println(name + t);
       t.start();
   }

   public void run() {
       for (int i = 0; i < arr.length; i++) {
           arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
       }

   }
}
