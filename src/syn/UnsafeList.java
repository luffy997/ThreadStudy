package syn;

import java.util.ArrayList;
import java.util.List;

//线程不安全的集合--> ArrayList
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        for (int i = 0; i <10000; i++) {
            new Thread(()->{
                synchronized (list){    //添加锁 线程安全
                    list.add(Thread.currentThread().getName());

                }
            }).start();
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
