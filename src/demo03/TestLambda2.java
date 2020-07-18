package demo03;

public class TestLambda2 {
    public static void main(String[] args) {

        Ilove ilove = (int a) ->{
                System.out.println("测试---->" + a);

            };

        //简化1，参数类型
        ilove = (a) ->{
            System.out.println("测试---->" + a);

        };

        //简化2，简化括号
        ilove = a ->{
            System.out.println("测试---->" + a);

        };

        //简化3.去掉花括号
        ilove = a -> System.out.println("测试---->" + a);
        ilove.love(7777);

        //总结：
        //lambda只能有一行代码的情况下才能简化成一行，如果是多行，就要用代码块包裹
        //前提是函数式接口
        //多个参数也可以去掉参数类型，要去掉，都去掉，必须加括号
        }

    }


interface Ilove{
    void love(int a);

}
