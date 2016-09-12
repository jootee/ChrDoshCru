package com.dosh.chrcrud.Ministers;

/**
 * Created by Dosh on 8/14/2016.
 */


/**
 * Created by Belal on 10/24/2015.
 */
public class Config {

    //Address of our scripts of the CRUD
    public static final String URL_ADD="http://192.168.70.2/chrcrud/ministers/addEmp.php";
    public static final String URL_GET_ALL = "http://192.168.70.2/chrcrud/ministers/getAllEmp.php";
    public static final String URL_GET_EMP = "http://192.168.70.2/chrcrud/ministers/getEmp.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.70.2/chrcrud/ministers/updateEmp.php";
    public static final String URL_DELETE_EMP = "http://192.168.70.2/chrcrud/ministers/deleteEmp.php?id=";

    //Keys that will be used to send the request to php scripts
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAME = "name";
    public static final String KEY_EMP_CONT = "cont";
    public static final String KEY_EMP_TIME = "time";
    public static final String KEY_EMP_DATE = "date";
    public static final String KEY_EMP_FORD = "ford";
    public static final String KEY_EMP_IMAGE = "image";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_CONT = "cont";
    public static final String TAG_TIME = "time";
    public static final String TAG_DATE = "date";
    public static final String TAG_FORD = "ford";
    public static final String TAG_IMAGE = "image";

    //employee id to pass with intent
    public static final String EMP_ID = "emp_id";
}