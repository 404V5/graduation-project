

package com.tool;

import java.io.UnsupportedEncodingException;

public class Chinese
{

    public Chinese()
    {
    }

    public static String toUnicode(String strvalue) throws UnsupportedEncodingException
    {
        if(strvalue == null)
            return null;
        strvalue = new String(strvalue.getBytes("GBK"), "ISO8859_1");
        return strvalue;
        
    }

    public static String StringtoSql(String str)
    {
        str = nullToString(str, "");
        try
        {
            str = str.trim().replace('\'', '\001');
        }
        catch(Exception e)
        {
            return "";
        }
        return str;
    }

    public static final String nullToString(String v, String toV)
    {
        if(v == null)
            v = toV;
        return v;
    }

    public static String toChinese(String strvalue) throws UnsupportedEncodingException
    {
        if(strvalue == null)
            return "";
        strvalue = new String(strvalue.getBytes("ISO8859_1"), "GBK");
        return strvalue;
    }

    public static String chinese(String a)
    {
        try {
			return new String(a.getBytes("ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
}
