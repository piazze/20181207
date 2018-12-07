package test1;

import java.io.File;
import java.util.stream.Stream;

public class Test5 {

    public static void main(String[] args) {
        File root = new File("F:\\abc");
        deleteFile(root);
        //delete(root);
    }

    /**
     * 递归删除
     * @param file
     */
    public static void deleteFile(File file){
        if (file.exists()){ //判断文件是否存在
            File[] files = file.listFiles();
            if (files != null && files.length > 0){
                Stream.of(files).parallel().forEach(t -> {
                    if (t.isFile()) t.delete();
                    else deleteFile(t);  //递归删除文件
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
                    if (f.isFile()) f.delete();  //删文件
                    else
                        delete(f);   //递归进入到File对象中尝试删子集文件及目录
                }
            }
            file.delete();
        }
    }
}
