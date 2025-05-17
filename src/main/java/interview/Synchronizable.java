package interview;

public class Synchronizable {

  public synchronized void m1() {
    System.out.println(Thread.currentThread().getName() + " m1");
  }

  public synchronized void m2() {
    System.out.println(Thread.currentThread().getName() + " m2");
  }

  public static void main(String[] args) {
    Synchronizable s1 = new Synchronizable();
    Synchronizable s2 = new Synchronizable();

    // Two different objects. so both can execute in any order
    new Thread(s2::m1).start();
    new Thread(s1::m1).start();

    // same object :: always sync output
    new Thread(s1::m1).start();
    new Thread(s1::m2).start();
  }
}
