package demo02;
//静态代理模式总结
//真实对象和代理对象都要实现一个接口
//代理对象要代理真实角色

//好处
  //代理对象可以做很多真实对象做不了的事情
  //真实对象专注做自己的事情

import javax.xml.ws.WebEndpoint;

public class StacticProxy {
    public static void main(String[] args) {
        You you=new You(); //你要结婚
        new Thread(  ()-> System.out.println("Alen")).start();

        new WeddingCompany(new You()).HappyMarry();
        WeddingCompany weddingCompany=new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }

}
interface Marry{

    void HappyMarry();

}

//真实角色
class You implements Marry{


    @Override
    public void HappyMarry() {
        System.out.println("想屁吃呢");

    }
}

//代理角色
class WeddingCompany implements Marry{

    //代理 ---> 真实目标角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();  //真实对象
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {

        System.out.println("结婚之前，部署现场");
    }
}
