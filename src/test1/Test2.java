package test1;

import java.io.File;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * 创建文件
     */
    private static void test1() {
        File file = new File("F:/abc.txt");
        //创建文件时通常结合if判断
        if (!file.exists()) {
            try {
                boolean result = file.createNewFile();//创建文件
                System.out.println(result ? "创建文件成功！" : "创建文件失败！");
            } catch (IOException e) {
                System.out.println("哦噢，程序出问题了！");
            }
        }
    }

    public static void test2() {
        File file = new File("F:/abc");
        if (!file.exists()) {
            //创建目录
            boolean result = file.mkdir();//创建目录
            System.out.println(result ? "创建目录成功！" : "创建目录失败！");
        }
    }
}
