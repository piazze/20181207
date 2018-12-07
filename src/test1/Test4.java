package test1;

import java.io.File;
import java.util.stream.Stream;

public class Test4 {
    public static void main(String[] args) {
        //获取当前目录下所有的文件及目录
        File file = new File("F:\\java30");
        if (file.exists()) {
            /*File[] files = file.listFiles();//获取子级目录及文件
            for (File f : files) {
                System.out.println(f.getName() + "\t" + (f.isDirectory() ? "<DIR>":""));
            }*/
            Stream.of(file.listFiles())
                    .forEach(t ->
                          System.out.println(t.getName() + "\t" + (t.isDirectory() ? "<DIR>" : ""))
                    );
        }
    }
}
