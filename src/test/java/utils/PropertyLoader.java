package test.java.utils;

import java.util.ResourceBundle;

public class PropertyLoader {
    private static final ResourceBundle RES = ResourceBundle.getBundle("config");
    private static final ResourceBundle RES_SECURED = ResourceBundle.getBundle("secured_config");

    public static String loadProperty (String name){
        return RES.getString(name);
    }

    public static String loadSecuredProperty (String name) { return RES_SECURED.getString(name);}
}
