package com.miao.administrator.dbtest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2015/11/2.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static DBHelper instance;
    final public static String DATE_TITLEID = "Date_TitleID";
    final public static String TITLEID_CONTENT = "TitleID_Content";
    final public static String DB_NAME = "ZhihuDiaryLit.db";
    final private String CREATE_TABLE_DT = "create table " + DATE_TITLEID + " (Date , TitleID , primary key(Date , TitleID))";
    final private String CREATE_TABLE_TC = "create table " + TITLEID_CONTENT + " (TitleID primary key, Title , Content)";

    private DBHelper(Context context, String name,
                     int version) {
        super(context, name, null, version);
    }

    //-----------------------------------------------------------获取DBHelper实例---------------------------------
    private static DBHelper getInstance() {
        return getInstance(DB_NAME);
    }

    private static DBHelper getInstance(String name) {
        return getInstance(MyApplication.getInstance(), name);
    }

    private static DBHelper getInstance(Context context, String name) {
        return getInstance(context, name, 1);
    }

    private static DBHelper getInstance(Context context, String name,
                                        int version) {
        if (instance == null)
            instance = new DBHelper(context, name, version);
        return instance;
    }

    //---------------------------------------------------------------获取数据库-----------------------------------
    private static SQLiteDatabase getDatebase() {
        return getInstance().getWritableDatabase();
    }

    //---------------------------------------------------------------执行SQL语句-----------------------------------
    public static void execSQL(String SQL, String[] strs) {
        getDatebase().execSQL(SQL, strs);
    }

    public static void execSQL(String SQL) {
        getDatebase().execSQL(SQL);
    }

    //------------------------------------------------------------------查找------------------------------------------
    public static Cursor rawQuery(String SQL) {
        return getDatebase().rawQuery(SQL, null);
    }

    public static Cursor rawQuery(String SQL, String[] strs) {
        return getDatebase().rawQuery(SQL, strs);
    }

    //-----------------------------------------------------------------向表Date_TitleID插入数据---------------------------------------------
    public static void insertDT(String strDate, String strTitleID) {
        String strInsert = "insert into " + DATE_TITLEID + " values(? , ?)";
        try {
            execSQL(strInsert, new String[]{strDate, strTitleID});
        } catch (Exception e) {
        }
    }

    //-----------------------------------------------------------------向表TitledID_Content插入数据---------------------------------------------
    public static void insertTC(String strTitleID, String strTitle, String strContent) {
        String strInsert = "insert into " + TITLEID_CONTENT + " values(? , ? , ?)";
        try {
            execSQL(strInsert, new String[]{strTitleID, strTitle, strContent});
        } catch (Exception e) {
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_DT);
        db.execSQL(CREATE_TABLE_TC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
