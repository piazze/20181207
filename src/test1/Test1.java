package test1;

import java.io.File;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) {
        //创建File文件对象
        File file = new File("F:/武林.txt");

        File dir = new File("F:/testDir");

        String s = File.separator; //获取路径分隔符
        System.out.println("当前操作系统中的路径分隔符：" + s);
        System.out.println("file是否存在：" + file.exists());
        System.out.println("dir是否存在：" + dir.exists());


        /*
        判断File的对象是文件还是目录通过
        isFile()        是否文件
        isDirectory()   是否文件夹
        * */
        System.out.println("file是否文件： " + file.isFile());
        System.out.println("dir是否目录：" + dir.isDirectory());

        System.out.println("文件名：" + file.getName());
        if (!dir.exists()) { //如果dir不存在，则创建
            try {
                boolean result = dir.createNewFile();  //创建文件
                System.out.println(result ? "创建成功" : "创建失败");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
