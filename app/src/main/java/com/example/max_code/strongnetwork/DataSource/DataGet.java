package com.example.max_code.strongnetwork.DataSource;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;

import com.example.max_code.strongnetwork.NetJSON.CssJSON;
import com.example.max_code.strongnetwork.api.NetWorkAPI;
import com.example.max_code.strongnetwork.bean.ImageEntity;
import com.example.max_code.strongnetwork.biz.ReverseJSONStr;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

/**
 * Created by max-code on 2016/9/4.
 */
public class DataGet {
    //最重要的类
    BehaviorSubject<List<ImageEntity>> bs;
    BehaviorSubject<CssJSON> sbs;
    BehaviorSubject<String> sbss;
    Subscription sb;
    private static DataGet dataGet;
    private static final int FROM_DISK = 0;
    private static final int FROM_CACHE = 1;
    private static final int FROM_NET = 2;
    @IntDef({FROM_DISK,FROM_CACHE,FROM_NET}) @interface DataSource{};
    private int DataSource;

    public DataGet() {
        super();
    }

    public static DataGet getDataGet() {
        if(dataGet==null){
            dataGet = new DataGet();
        }
        return dataGet;
    }
    //给街口设置数据源
    public void setDataSource(@DataSource int dataSource) {
        this.DataSource = dataSource;
    }
    public String getDATAResource(){
        String datasourceTEXT;
        switch (DataSource){
        case FROM_CACHE:{
            datasourceTEXT = "来源于内存";
        }break;
            case FROM_DISK :{
                datasourceTEXT = "来源于磁盘";
            }break;
            case FROM_NET :{
                datasourceTEXT = "来源于网络";
            }break;
            default: {
                datasourceTEXT="来源于网络";
            }break;
        }
        return datasourceTEXT;
    }
    public void LoadNetWork(String baseurl){
        NetWorkAPI.getNetWorkAPI().
                getNetJSON(baseurl).
                getGankBeauties(100,1).
                subscribeOn(Schedulers.io()).
                map(ReverseJSONStr.
                getReverseJSONStr()).
                doOnNext(new Action1<List<ImageEntity>>() {
            @Override
            public void call(List<ImageEntity> imageEntities) {
                DataSourceClass.getDataSourceClass().setImages(imageEntities);
            }
        }).subscribe(new Action1<List<ImageEntity>>() {
            @Override
            public void call(List<ImageEntity> imageEntities) {
                bs.onNext(imageEntities);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                //向下抛出异常
                 throwable.printStackTrace();
            }
        });
    }
    //即时获取数据
    public Subscription subscriptionData(@NonNull Observer<List<ImageEntity>> observe){
        if(bs==null){//bs中为空
            bs = BehaviorSubject.create();
            Observable.create(new Observable.OnSubscribe<List<ImageEntity>>() {
                @Override
                public void call(Subscriber<? super List<ImageEntity>> subscriber) {
                    List<ImageEntity> imglist = DataSourceClass.getDataSourceClass().getImages();
                    if(imglist==null){
                        setDataSource(FROM_NET);
                        LoadNetWork("http://gank.io/api/");
                    }else{
                        setDataSource(FROM_DISK);
                        subscriber.onNext(imglist);
                    }
                }
            }).subscribeOn(Schedulers.io()).subscribe(bs);
        }else{
            setDataSource(FROM_CACHE);
        }
        return bs.observeOn(AndroidSchedulers.mainThread()).subscribe(observe);
    }
    public void clearCache(){
        bs = null;
    }

    public void clearDISKAndCache(){
        bs = null;
        DataSourceClass.getDataSourceClass().deleteFiles();
    }

//    public Subscription getCSSSubscription(@NonNull Observer<CssJSON> observer){
//        if(sbs==null){
//            //创建behave对象
//            sbs = BehaviorSubject.create();
//            Observable.create(new Observable.OnSubscribe<CssJSON>() {
//                @Override
//                public void call(Subscriber<? super CssJSON> subscriber) {
//                    NetWorkAPI.getNetWorkAPI().getCssAPI().
//                            getCSSJSON("127068014","1","15").
//                            subscribeOn(Schedulers.io()).
////                            map(ReverseCssJSONStr.getCssJSONStr()).
//                            subscribe(new Action1<CssJSON>() {
//                                @Override
//                                public void call(CssJSON msgBeen) {
//                                    sbs.onNext(CssJSON);
//                                }
//                            }, new Action1<Throwable>() {
//                                @Override
//                                public void call(Throwable throwable) {
//                                    throwable.printStackTrace();
//                                }
//                            });
//                }
//            }).subscribeOn(Schedulers.io()).subscribe(sbs);
//        }
//        return sbs.observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
//    }
//    public Subscription getComminfos(@NonNull final Observer<String> observer){
//        if(sbss==null){
//            sbss = BehaviorSubject.create();
//            Observable.create(new Observable.OnSubscribe<MessageEntitys>() {
//                @Override
//                public void call(Subscriber<? super MessageEntitys> subscriber) {
//                    NetWorkAPI.getNetWorkAPI().
//                            getCommInfo().
//                            getCommInfo("127068014","1","15").
//                            subscribeOn(Schedulers.io()).
//                            subscribe(new Action1<MessageEntitys>() {
//                                @Override
//                                public void call(MessageEntitys s) {
//                                    sbss.onNext(s);
//                                }
//                            }, new Action1<Throwable>() {
//                                @Override
//                                public void call(Throwable throwable) {
//                                    throwable.printStackTrace();
//                                }
//                            });
//                }
//            }).subscribeOn(Schedulers.io()).subscribe(sbss);
//        }
//        return sbss.observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
//    }
}
