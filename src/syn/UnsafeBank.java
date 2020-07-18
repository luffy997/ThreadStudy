package syn;
//不安全的取钱
//两个人去银行取钱，账户
public class UnsafeBank {
    public static void main(String[] args) {
        //账户
        Account account=new Account(100,"结婚基金");

        Drawing you =new Drawing(account,50,"你");
        Drawing girlFriend =new Drawing(account,100,"girlFriend");

        you.start();
        girlFriend.start();
    }
}

//账户
class Account{
    int money; //余额
    String name;//账户名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
class Drawing extends Thread{
    Account account; //账户
    //取了多少钱
    int drawMoney;
    //现在手里有多少钱
    int nowMoney;

    public Drawing(Account account,int drawMoney,String name){
        super(name);
    this.account=account;
    this.drawMoney=drawMoney;

    }

    //取钱
    // synchronized默认锁this

    @Override
    public  void run() {

        //锁的对象是变化的量。需要增删改的对象   而不是锁bank
        synchronized (account){
            //判断账户有不有钱
            if (account.money -drawMoney <0 ){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不出来");
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额=余额-你取的钱
            account.money=account.money-drawMoney;
            //你手里的钱
            nowMoney =nowMoney + drawMoney;

            System.out.println(account.name+"余额为："+account.money);
            //Thread.currentThread()=this.getName()
            System.out.println(this.getName()+"手里的钱："+nowMoney);
        }
        }

}