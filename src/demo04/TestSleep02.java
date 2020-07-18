package demo04;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时
public class TestSleep02 {
    public static void main(String[] args) {
//        try {
//            tenDown();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //打印当前系统时间
        Date startTime=new Date(System.currentTimeMillis());//获取系统当前时间
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            startTime=new Date(System.currentTimeMillis());//更新当前时间
        }
    }



    public static void tenDown() throws InterruptedException {
            int num=10;
            while (true){
                Thread.sleep(1000);
                System.out.println(num--);
                if (num<=0){
                    break;
                }
            }
    }
}
