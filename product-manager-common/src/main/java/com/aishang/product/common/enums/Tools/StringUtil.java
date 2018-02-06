package com.aishang.product.common.enums.Tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    /**
     * 将List转化为指定字符串分割的长字符串
     *
     * @param rs
     * @param split
     * @return
     */
    public static String list2String(List rs, String split) {
        if (rs == null || rs.size() <= 0) {
            return null;
        }
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < rs.size(); i++) {
            temp.append(rs.get(i));
            temp.append(split);
        }
        StringBuffer result = new StringBuffer(temp.substring(0, temp.length()
                - split.length()));
        return result.toString();
    }

    /**
     * 将NULL转为""
     *
     * @param obj
     * @return
     */
    public static Object getStrValue(Object obj) {
        if (obj != null) {
            return obj;
        } else {
            return "";
        }

    }

    /**
     * @param
     * @return
     */
    public static String replaceXmlStr(String str) {
        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(str);
        String afterXml = m.replaceAll("");
        return afterXml;
    }

    /**
     * 方法描述：把Object转化为字符串
     *
     * @param
     * @param str
     * @param
     * @return
     * @return String
     */
    public static String objToString(Object str) {
        if (null == str) {
            return "";
        } else {
            return String.valueOf(str);
        }
    }

    /**
     * 字符串为空
     *
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
        return !isNotEmpty(s);
    }

    /**
     * 字符串不为空
     *
     * @param s
     * @return
     */
    public static boolean isNotEmpty(String s) {
        return s != null && s.length() > 0;
    }

    /**
     * 改变编码
     *
     * @param s
     * @param charsetName
     * @return
     */
    public static String changeEncoding(String s, String charsetName) {
        try {
            s = new String(s.getBytes("iso-8859-1"), charsetName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 将Date类型转成String串型
     *
     * @param date
     *            日期类型,pattern 指日志类型样式
     * @return
     */
    public static String dateToString(Date date, String pattern) {

        if (date == null) {
            return "";
        }
        try {
            SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
            sfDate.setLenient(false);
            return sfDate.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将带有逗号","的字符串转化为integer数组
     *
     * @param str
     * @return
     */
    public static Integer[] getIntegerArrayByStr(String str) {
        String[] strs = str.split(",");
        Integer[] ints = new Integer[strs.length];
        for (int i = 0; i < strs.length; i++) {
            ints[i] = Integer.parseInt(strs[i]);
        }
        return ints;
    }

    /**
     * 将数组转换逗号分割的字符串 Description: ModifyHistory:
     */
    public static String getStrByObjectArray(Object[] ids) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ids.length; i++) {
            if (i == (ids.length - 1))
                sb.append(ids[0].toString());
            else {
                sb.append(ids[0].toString() + ",");
            }
        }
        return sb.toString();
    }

    /**
     * 将带有逗号","的字符串转化为StringList
     *
     * @param str
     * @return
     */
    public static List<String> splitStrToList(String str) {
        String[] strs = str.split(",");
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            list.add(strs[i]);
        }
        return list;
    }

    /**
     * 将字符流转换为字符串
     *
     * @param is
     * @return
     */
    public static String getStrByStream(InputStream is) {
        String encoding = "UTF-8";
        StringBuffer str = new StringBuffer();
        try {
            BufferedInputStream in = new BufferedInputStream(is);
            byte[] buffer = new byte[1024];
            int i = 0;
            do {
                i = in.read(buffer);
                if (i > 0)
                    str.append(new String(buffer, 0, i, encoding));
            } while (i == 1024);
            return str.toString();
        } catch (Exception e) {
            throw new RuntimeException("字符串转换错误", e);
        }
    }

    /**
     * 将一个字符串的首字母改为大写或者小写
     *
     * @param srcString
     *            源字符串
     * @param flag
     *            大小写标识，ture小写，false大些
     * @return 改写后的新字符串
     */
    public static String toLowerCaseInitial(String srcString, boolean flag) {
        StringBuilder sb = new StringBuilder();
        if (flag) {
            sb.append(Character.toLowerCase(srcString.charAt(0)));
        } else {
            sb.append(Character.toUpperCase(srcString.charAt(0)));
        }
        sb.append(srcString.substring(1));
        return sb.toString();
    }

    /**
     * 格式化文件路径，将其中不规范的分隔转换为标准的分隔符,并且去掉末尾的"/"符号。
     *
     * @param path
     *            文件路径
     * @return 格式化后的文件路径
     */
    public static String formatPath(String path) {
        String reg0 = "\\\\＋";
        String reg = "\\\\＋|/＋";
        String temp = path.trim().replaceAll(reg0, "/");
        temp = temp.replaceAll(reg, "/");
        if (temp.endsWith("/")) {
            temp = temp.substring(0, temp.length() - 1);
        }
        if (System.getProperty("file.separator").equals("\\")) {
            temp = temp.replace('/', '\\');
        }
        return temp;
    }

    /**
     * 格式化文件路径，将其中不规范的分隔转换为标准的分隔符,并且去掉末尾的"/"符号(适用于FTP远程文件路径或者Web资源的相对路径)。
     *
     * @param path
     *            文件路径
     * @return 格式化后的文件路径
     */
    public static String formatPath4Ftp(String path) {
        String reg0 = "\\\\＋";
        String reg = "\\\\＋|/＋";
        String temp = path.trim().replaceAll(reg0, "/");
        temp = temp.replaceAll(reg, "/");
        if (temp.endsWith("/")) {
            temp = temp.substring(0, temp.length() - 1);
        }
        return temp;
    }

    /**
     * 获取文件父路径
     *
     * @param path
     *            文件路径
     * @return 文件父路径
     */
    public static String getParentPath(String path) {
        return new File(path).getParent();
    }

    /**
     * 获取相对路径
     *
     * @param fullPath
     *            全路径
     * @param rootPath
     *            根路径
     * @return 相对根路径的相对路径
     */
    public static String getRelativeRootPath(String fullPath, String rootPath) {
        String relativeRootPath = null;
        String _fullPath = formatPath(fullPath);
        String _rootPath = formatPath(rootPath);

        if (_fullPath.startsWith(_rootPath)) {
            relativeRootPath = fullPath.substring(_rootPath.length());
        } else {
            throw new RuntimeException("要处理的两个字符串没有包含关系，处理失败！");
        }
        if (relativeRootPath == null)
            return null;
        else
            return formatPath(relativeRootPath);
    }

    /**
     * 获取当前系统换行符
     *
     * @return 系统换行符
     */
    public static String getSystemLineSeparator() {
        return System.getProperty("line.separator");
    }

    /**
     * 将字符串的首字母转为小写
     *
     * @param resStr
     *            源字符串
     * @return 首字母转为小写后的字符串
     */
    public static String firstToLowerCase(String resStr) {
        if (resStr == null) {
            return null;
        } else if ("".equals(resStr.trim())) {
            return "";
        } else {
            StringBuffer sb = new StringBuffer();
            Character c = resStr.charAt(0);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c))
                    c = Character.toLowerCase(c);
                sb.append(resStr);
                sb.setCharAt(0, c);
                return sb.toString();
            }
        }
        return resStr;
    }

    /**
     * 将字符串的首字母转为大写
     *
     * @param resStr
     *            源字符串
     * @return 首字母转为大写后的字符串
     */
    public static String firstToUpperCase(String resStr) {
        if (resStr == null) {
            return null;
        } else if ("".equals(resStr.trim())) {
            return "";
        } else {
            StringBuffer sb = new StringBuffer();
            Character c = resStr.charAt(0);
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c))
                    c = Character.toUpperCase(c);
                sb.append(resStr);
                sb.setCharAt(0, c);
                return sb.toString();
            }
        }
        return resStr;
    }
    /**
     * 比较两个版本号的大小
     * @param version1 版本号1
     * @param version2 版本号2
     * @return version1 > version2 : 1  version1 = version2 :0 version1 < version2 :-1
     */
    public static int compareVersion(String version1,String version2){
        int index = 0;
        if (isEmpty(version1)&& !isEmpty(version2)) {
            index = -1;
        }else if (isEmpty(version2) && !isEmpty(version1)) {
            index = 1;
        }else if (!isEmpty(version2) && !isEmpty(version1)) {
            if (version1.length() - version2.length() >= 0) {
                for (int i = 0; i < version1.length(); i++) {
                    if (i < version2.length()) {
                        int tempInt = version1.charAt(i) - version2.charAt(i);
                        if (tempInt > 0) {
                            index = 1;
                            break;
                        }else if (tempInt < 0) {
                            index = -1;
                            break;
                        }
                    }
                }
            }
        }
        return index;
    }


    public static String replaceChinese(String str){
        String  string = str.replaceAll("(\\s[\u4E00-\u9FA5]+)", "");
        return string.trim();
    }


    private static String subStrForMath(String str){
        String string="";
        for (int i = 0; i < str.length(); i++){
            String str0="";
            if (str.substring(i, i + 1).matches("[u4e00-u9fa5]+")){
                System.out.println();
            }else{
                str0 = str.substring(i, i + 1) +"";
            }
            string +=str0;
        }
        return string;
    }




    /**
     * 格式化 联通 电信月数
     * @param input [0-1) , [1-3) , [3-6)，[6-12)，[12-24)，[24-36)，[36+)
     * @return 0 ,3 ,6,12,24,36,100
     */
    public static int month(String input){

        int i=0;
        if(isNotEmpty(input)){
            if(input.indexOf("[0-1)")!=-1){
                i=1;
            }else if(input.indexOf("[1-3)")!=-1){
                i=3;
            }else if(input.indexOf("[3-6)")!=-1){
                i=6;
            }else if(input.indexOf("[6-12)")!=-1){
                i=12;
            }else if(input.indexOf("[12-24)")!=-1){
                i=24;
            }else if(input.indexOf("[24-36)")!=-1){
                i=36;
            }else if(input.indexOf("[36+)")!=-1){
                i=100;
            }else{
                i=0;
            }
        }else{
            i=0;
        }
        return i;
    }

    /**
     * 带数组的Map集合转Map集合
     * @param requestParams
     * @return
     */
    public static Map<String,String> toMap(Map requestParams){
        Map<String,String> params = new HashMap<String,String>();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
            params.put(name, valueStr);
            System.out.println("name="+name+";value= "+valueStr);
        }
        return params;
    }
}
