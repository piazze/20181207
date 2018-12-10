package test2;

import java.io.*;

public class Test3 {
    /**
     * 文件的剪切
     *
     * 1.源文件的路径
     * 2.目标文件的路径
     * 3.读取源文件中的内容
     * 4.将读取的内容写到目标文件中
     * 5.删除源文件
     * @param args
     */
    public static void main(String[] args) {
        File source = new File("E:/background.jpg");
        if (!source.exists()) return;   //如果文件不存在，则不能删除
        try {
            InputStream input = new FileInputStream(source);
            OutputStream output = new FileOutputStream("F:/background.jpg");

            byte[] bytes = new byte[1024];
            int len;
            while((len = input.read(bytes)) != -1){
                output.write(bytes,0,len); //读取数据，并写入到aaa.txt中
            }

            output.flush();//刷新缓存
            output.close();//关闭输出流
            input.close(); //关闭输入流

            //删除源文件
            source.delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
