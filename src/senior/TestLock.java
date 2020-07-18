package senior;

import java.util.concurrent.locks.ReentrantLock;

//测试lock锁
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2=new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable{

    int tickNums = 10;

    //定义lock锁
    private ReentrantLock reentrantLock=new ReentrantLock();


    @Override
    public void run() {
        while (true){

            try{
                reentrantLock.lock(); //加锁
                if (tickNums >0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tickNums--);
                }else {
                    break;
                }
            }finally {
                //解锁
                reentrantLock.unlock();
            }

        }
    }
}