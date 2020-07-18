package demo02;
//线程创建三：实现callable接口

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 *
 */
public class TestCallable  implements Callable{
    private String url;  //网络图片地址
    private  String name;  //保存的文件名

    public TestCallable(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public Boolean call() {
        WebDownloadLoader webDownloadLoader=new  WebDownloadLoader();
        webDownloadLoader.downLoader(url,name);
        System.out.println("下载的文件名字为："+name);
        return  true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1=new TestCallable("http://39.101.184.136:8010/admin/dist/img/rand/5.jpg","F:\\多线程测试\\2.jpg");
        TestCallable t2=new TestCallable("http://39.101.184.136:8010/admin/dist/img/category/06.png","F:\\多线程测试\\4.jpg");
        TestCallable t3=new TestCallable("http://39.101.184.136:8010/admin/dist/img/category/02.png","F:\\多线程测试\\3.jpg");

        //创建执行服务
        ExecutorService service= Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1=service.submit(t1);
        Future<Boolean> r2=service.submit(t2);
        Future<Boolean> r3=service.submit(t3);

        //获取结果
        boolean rs1=r1.get();
        boolean rs2=r1.get();
        boolean rs3=r1.get();

        //关闭服务
        service.shutdown();
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
