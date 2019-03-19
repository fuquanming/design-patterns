package com.fcc.design.pattern.prototype;

import java.io.*;
import java.util.Date;

/**
 * @author 傅泉明
 * @title: SerializationBook
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/19 15:29
 */
public class SerializationBook extends Book implements Cloneable,Serializable {

    // 深度克隆，通过序列化内存生成对象
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    public Object  deepClone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        SerializationBook obj = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(this);
            os.flush();

            bis = new ByteArrayInputStream(bos.toByteArray());
            is = new ObjectInputStream(bis);
            obj = (SerializationBook)is.readObject();
            obj.setCreateDate(new Date(this.getCreateDate().getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) bos.close();
                if (os != null) os.close();
                if (bis != null) bis.close();
                if (is != null) is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }
}
