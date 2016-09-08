package com.example.max_code.strongnetwork.Static;

/**
 * Created by max-code on 2016/9/4.
 */
public class StaticVarClass {
    public static final String baseUrl = "http://gank.io/api/";
    public static StaticVarClass staticVarClass;

    public static StaticVarClass getStaticVarClass() {
        if(staticVarClass==null){
            staticVarClass = new StaticVarClass();
        }
        return staticVarClass;
    }
}
