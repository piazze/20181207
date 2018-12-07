package test1;

import java.io.File;

public class Test3 {
    public static void main(String[] args) {
        //test1();

        test2();
    }

    private static void test2() {
        File file = new File("F:/abc");
        if (file.exists()){
            boolean result = file.delete();
            System.out.println(result ? "删除目录成功！":"删除目录失败！");
        }
    }

    private static void test1() {
        File file = new File("F:/abc.txt");
        /*如果文件存在则删除*/
        if (file.exists()){
            boolean result = file.delete();
            System.out.println(result ? "删除文件成功":"删除文件失败");
        }
    }

}
