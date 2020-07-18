package demo01;

//创建线程方式，1.继承Thread类，重写run()方法，调用start()开启线程
//总结：线程开启，不一定立即执行，由CPU调度
public class TestThread01 extends Thread {

    @Override
    public void run() {
        //run 方法 线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码-----" + i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程

        //创建一个线程对象 调用start()  开启线程
        TestThread01 testThread=new TestThread01();
        testThread.start();  //多线程，主线程和子线程交替执行
        //testThread.run();  //只有主线程一条执行路径


        for (int i = 0; i < 200; i++) {
            System.out.println("我在看学习多线程-----" + i);
        }
    }
}