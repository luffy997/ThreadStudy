package demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class TestThread02  extends  Thread{
    private String url;  //网络图片地址
    private  String name;  //保存的文件名

    public TestThread02(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public void run() {
        WebDownloadLoader webDownloadLoader=new WebDownloadLoader();
        webDownloadLoader.downLoader(url,name);
        System.out.println("下载的文件名字为："+name);

    }

    public static void main(String[] args) {
        TestThread02 t1=new TestThread02("http://39.101.184.136:8010/admin/dist/img/rand/5.jpg","F:\\多线程测试\\2.jpg");
        TestThread02 t2=new TestThread02("http://39.101.184.136:8010/admin/dist/img/category/06.png","F:\\多线程测试\\4.jpg");
        TestThread02 t3=new TestThread02("http://39.101.184.136:8010/admin/dist/img/category/02.png","F:\\多线程测试\\3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }

}
//下载器
class  WebDownloadLoader{
    //下载方法
    public void downLoader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出错");
        }
    }

}