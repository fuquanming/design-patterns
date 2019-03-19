package com.fcc.design.pattern.singleton.crack;

import com.fcc.design.pattern.singleton.hungry.HungrySingleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author 傅泉明
 * @title: 反序列化破解单例，枚举除外
 * @projectName design-patterns
 * @description: 将已经持久化的字节码内容，转换为 IO 流；通过 IO 流的读取，进而将读取的内容转换为 Java 对象，
 * 在转换过程中会重新创建对象
 * @date 2019/3/19 11:38
 */
public class SerializationCrackSingleton {

    public static void main(String[] args) {
        // s1和s2是同一个实例
        HungrySingleton s1 = HungrySingleton.getInstance();
        HungrySingleton s2 = HungrySingleton.getInstance();
        System.out.println(s1 == s2);
        // 将s2写入磁盘
        ObjectOutputStream os = null;
        ObjectInputStream is = null;
        try {
            String fileName = "HungrySingleton.obj";
            os = new ObjectOutputStream(new FileOutputStream(fileName));
            os.writeObject(s2);
            os.flush();
            os.close();
            // 将s2读出
            is = new ObjectInputStream(new FileInputStream(fileName));
            s1  = (HungrySingleton) is.readObject();
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) os.close();
                if (is != null) is.close();
            } catch (Exception e) {e.printStackTrace();}
        }

    }

}
