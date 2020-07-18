package demo05;
//死锁：多个线程互相抱着对方需要的资源，然后形成僵持
public class DeadLock {
    public static void main(String[] args) {
        MakeUp g1=new MakeUp(0,"灰姑凉");
        MakeUp g2=new MakeUp(1,"白雪公主");

        g1.start();
        g2.start();
    }
}


//口红
class LipStick{

}

//镜子
class  Mirror{

}

class MakeUp extends Thread{

    //需要资源只要一份，用static来保证只有一份
    static LipStick lipStick=new LipStick();
    static Mirror mirror=new Mirror();

    int choice;//选择
    String girlName;//使用化妆品的人

    MakeUp(int choice,String girlName){
        this.choice=choice;
        this.girlName=girlName;

    }

    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //化妆，互相持有对方的锁，需要拿到对方的资源
    //不要一个进程加两把锁，防止死锁
    private  void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipStick) { //活得口红的锁
                System.out.println(Thread.currentThread().getName() + "获得口红的锁");
                    Thread.sleep(1000);

                } synchronized (mirror) { //一秒钟后想获得镜子
                System.out.println(Thread.currentThread().getName() + "获得镜子的锁");
            }
        } else {
            synchronized (mirror) { //活得口红的锁
                System.out.println(Thread.currentThread().getName() + "获得镜子的锁");
                    Thread.sleep(1000);
                }
            synchronized (lipStick) { //一秒钟后想获得镜子
                System.out.println(Thread.currentThread().getName() + "获得口红的锁");
            }
        }
    }
}