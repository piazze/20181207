package test2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test2 {
    /**
     * 将数据写入文件
     * @param args
     */
    public static void main(String[] args) {
        try {
            //将数据写到abc.txt中，并且末尾追加
            OutputStream out = new FileOutputStream("F:/abc.txt",true);

            String str = "你好呀，我们今天开始学习java IO";
            byte[] bytes = str.getBytes();//将字符串转换为byte类型的数组

            //每次写一个字节
            /*for (byte aByte : bytes) {
                out.write(aByte);
            }*/

            out.write(bytes); //直接写一个数组

            out.flush(); //刷新缓存
            out.close(); //关闭输出流

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
