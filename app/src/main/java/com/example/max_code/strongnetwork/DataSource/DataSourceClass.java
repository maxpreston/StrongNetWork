package com.example.max_code.strongnetwork.DataSource;

import android.os.Environment;
import android.util.Log;

import com.example.max_code.strongnetwork.Base.App;
import com.example.max_code.strongnetwork.bean.ImageEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * Created by max-code on 2016/9/4.
 */
public class DataSourceClass {
    private String TAG = "tag";
    private static String dbNAME = "test.db";
    private static DataSourceClass dataSourceClass;
    //获取一个datasouececlass实例
    public static DataSourceClass getDataSourceClass() {
        if(dataSourceClass==null){
            dataSourceClass = new DataSourceClass();
        }
        return dataSourceClass;
    }
    //创建数据位置

    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),dbNAME);
    //使用Gson序列化数据
    Gson gson = new Gson();
    //构造空构造
    public DataSourceClass() {
        super();
    }
    public List<ImageEntity> getImages(){
        try {//为读文件预留缓冲时间
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取reader对象
        try {
            Reader reader = new FileReader(file);
            return gson.fromJson(reader, new TypeToken<List<ImageEntity>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void setImages(List<ImageEntity> list){
        //将集合数据持久化
        String json = gson.toJson(list);
        try {
            if(file.exists()){//如果不存在数据存储文件则新建
                file.createNewFile();
            }
            Writer writer = new FileWriter(file);
            writer.write(json);
            //刷新
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG,"持久化数据失败，io异常");
        }

    }
    //删除持久化数据
    public void deleteFiles(){
        if(file.exists()){
            file.delete();
        }
    }
}
