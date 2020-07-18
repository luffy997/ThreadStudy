package senior;

import com.sun.corba.se.impl.orbutil.closure.Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//回顾总结线程的创建
public class ThreadNew {
    public static void main(String[] args) {

        new MyThread01().start();

        new Thread(new MyThread02()).start();

        FutureTask<Integer> futureTask=new FutureTask<Integer>(new MyThread03());
        new Thread(futureTask).start();

        try {
            Integer integer=futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

//1.继承Thread类
class MyThread01 extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread01");
    }
}

//2.实现Runnable 接口
class MyThread02 implements Runnable{

    @Override
    public void run() {
        System.out.println("MyThread02");
    }
}

//3.实现Callable接口
class MyThread03 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("MyThread03");
        return 100;
    }
}