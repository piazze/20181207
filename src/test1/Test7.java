package test1;

import java.util.stream.IntStream;

public class Test7 {
    public static void main(String[] args) {
        int sum = sum(1,0);
        System.out.println(sum);

    }

    public static int sum(int num,int sum){
        System.out.println("第" + num + "次进入sum");
        if(num <= 5){
           sum += num;
           sum = sum(++num,sum);
        }
        System.err.println("第" + num + "次退出sum");
        return sum;
    }

}
