package test1;

import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test6 {
    public static void main(String[] args) {
        //记录开始时间
        long begin = System.currentTimeMillis();
        File root = new File("F:/abc");
        if (!root.exists()) root.mkdir();
        initData(root);  //初始化数据
        System.out.println("初始化数据完成");

        //deleteStream(root);//删除数据,测试数据50000笔，串行：27.7秒，并行：16.7秒，for循环：29.9秒
        //deleteParallelStream(root);
        delete(root);

        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    /**
     * 生成10000个随机的文件及目录
     * @param root
     */
    private static void initData(File root) {
        for (int i = 0;i < 50000;i++){
            File file = new File(root, String.valueOf(i));
            int ran = (int)(Math.random() * 2);
            if (ran == 0) {
                try {
                    file.createNewFile();  //创建文件
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else file.mkdir();  //创建目录
        }
    }

    public static void deleteStream(File file){
        if (file.exists()){ //判断文件是否存在
            File[] files = file.listFiles();
            if (files != null && files.length > 0){
                Stream.of(files).forEach(t -> {
                    if (t.isFile()) t.delete();
                    else deleteStream(t);  //递归删除文件
                });
            }
            file.delete();
        }
    }

    public static void deleteParallelStream(File file){
        if (file.exists()){ //判断文件是否存在
            File[] files = file.listFiles();
            if (files != null && files.length > 0){
                Stream.of(files).parallel().forEach(t -> {
                    if (t.isFile()) t.delete();
                    else deleteParallelStream(t);  //递归删除文件
                });
            }
            file.delete();
        }
    }

    public static void delete(File file){
        if (file.exists()){
            File[] files = file.listFiles(); //包含文件及目录
            if (file != null && files.length > 0){
                for (File f : files) {
                    //如果是文件，则直接删除，如果是目录则需要递归删除
                    if
                        (f.isFile()) f.delete();  //删文件
                    else
                        delete(f);   //递归进入到File对象中尝试删子集文件及目录
                }
            }
            file.delete();
        }
    }
}
