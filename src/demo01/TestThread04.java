package demo01;

//多个线程同时操作一个对象
//买火车票的例子

//发现：多个线程操作同一个资源，线程不安全，数据紊乱
public class TestThread04 implements Runnable {

    //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {

            if (ticketNums <= 0) {
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了第" + ticketNums-- + "票");
        }
    }

    public static void main(String[] args) {
        TestThread04 ticket=new TestThread04();

        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛").start();
    }
}
