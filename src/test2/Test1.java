package test2;

import java.io.*;

public class Test1 {
    /**
     * 通过字节输入流读取文件
     * @param args
     */
    public static void main(String[] args) {
        /*
        * FileInputStream构造方法有两种
        *           FileInputStream(File file)
        *           FileInputStream(String path)
        * 都会抛出FileNotFoundException   文件未找到的异常
        *
        * */
        //test1("F:/abc.txt");
        test2("F:/武林.txt");
    }

    /**
     * 通过字节输入流，每次读取一个字节到内存中
     * @param path
     */
    private static void test1(String path) {
        try {
            //InputStream input = new FileInputStream(path);
            InputStream input = new FileInputStream(new File(path));

            int i = 0;
            while ((i = input.read()) != -1){ //每次只读取一个字节
                char c = (char) i;
                System.out.println(c);
            }

            //关闭流
            input.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test2(String path){
        //InputStream input = new FileInputStream(path);
        try {
            InputStream input = new FileInputStream(new File(path));

            byte[] bytes = new byte[1024]; //每次读取1024个字节到byte数组中

            //int length = input.read(bytes);
            //System.out.println("读了多少个字节：" + length);

            int length;
            while ( (length = input.read(bytes)) != -1 ){
                String str = new String(bytes,0,length);
                System.out.println(str);
            }

            //关闭流
            input.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
