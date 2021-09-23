package com.sxmaps.my.utils;

import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*****************************************************************************
 * 字符串处理工具类
 *
 * @author : 刘泽
 * @crtDate: 2013-06-03
 ****************************************************************************/

public class StringUtil {

    /**
     * Map对象返回字符对象
     *
     * @param map
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Object getObjectFromMap(Map map, String key) {
        Object value = map.get(key);
        if (value != null && (value instanceof Object[])) {
            Object[] array = (Object[]) value;
            if (array != null && array.length > 0) {
                value = array[0];
            }
        }
        return value;
    }

    /**
     * 获取字符串
     *
     * @param map
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String getStringFromMap(Map map, String key) {
        Object value = getObjectFromMap(map, key);
        if (value == null)
            return null;
        if (value instanceof String) {
            return (String) value;
        }
        return value.toString();
    }

    /**
     * 将一个字符串的首字母转成大写
     *
     * @param str
     * @return String 转换后字符串
     */
    public static String getBigStr(String str) {
        String s = "";
        s = str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
        return s;
    }

    public static String getExpressionString(String temp) {
        try {
            temp = temp.replace(']', '[');

            StringBuilder sb = new StringBuilder();

            boolean append = true;
            do {
                int index = temp.indexOf("[");
                if (append) {
                    sb.append(temp.substring(0, index));
                    append = false;
                } else {
                    append = true;
                }

                temp = temp.substring(index + 1);
            } while (temp.contains("["));

            sb.append(temp);

            temp = sb.toString();
            temp = temp.replace("||", "或");
            temp = temp.replace("&&", "且");

            return temp;
        } catch (Exception ex) {
            ex.printStackTrace();
            return temp;
        }
    }

    /**
     * 强制类型字符转换
     *
     * @param param
     * @return
     */
    public static String convertUTF(String param) {
        if (param != null && !"".equals(param.trim())) {
            try {
                param = new String(param.getBytes("iso-8859-1"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return param;
    }

    /**
     * 判断字符串是否为数字
     *
     * @param key
     * @return
     */
    public static boolean convertNum(String key) {
        boolean flag = false;
        try {
            Long.parseLong(key);
            flag = true;
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 截取4位小数
     *
     * @param value
     * @return
     */
    public static float sbstringFloat(float value) {
        try {
            String temp = String.valueOf(value);
            int index = temp.indexOf(".");
            String strLen = temp.substring(index, temp.length());
            if (strLen.length() > 5) {
                temp = temp.substring(0, index + 5);
            }
            return Float.parseFloat(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 截取文件后缀名
     *
     * @param filename
     * @return
     */
    public static String get(String filename) {
        int index = filename.lastIndexOf(".");
        if (index < 0 || index == filename.length() - 1)
            return "";
        else
            return filename.substring(index + 1);
    }

    /**
     * 一次性获取文件内的内容
     *
     * @param file
     * @return
     */
    public static String getFileResult(File file) {
        String result = "";
        try {
            int bufSize = 1024;
            byte[] bs = new byte[bufSize];
            ByteBuffer byteBuf = ByteBuffer.allocate(1024);
            FileChannel channel = new RandomAccessFile(file, "r").getChannel();
            while (channel.read(byteBuf) != -1) {
                int size = byteBuf.position();
                byteBuf.rewind();
                byteBuf.get(bs);
                result = new String(bs, 0, size);
                byteBuf.clear();
            }
            channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 字符过滤
     *
     * @param str
     * @return
     */
    public static String htmlEncode(String str) {
        return str.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll(
                "\"", "&quot;");
    }

    /**
     * 替换所有括号
     *
     * @param keyword
     * @return
     */
    public static String kuohaoEncode(String keyword) {
        return keyword.replaceAll("\\(", "").replaceAll("\\)", "");
    }

    /**
     * 日期装换为int类型 时间:2012-01-01 分割符号:-
     *
     * @param time
     * @return
     */
    public static int timeToInteger(String time) {
        String[] split = time.split("-");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    /**
     * 拼接字符串
     *
     * @return
     */

    public static String spliceStr(String content, String replaceCode, Object... objects) {
        String[] strArray = content.split(replaceCode);
        StringBuffer buff = new StringBuffer();
        if (objects != null && objects.length > 0) {
            for (int i = 0; i < objects.length; i++) {
                buff.append(strArray[i]);
                buff.append(objects[i]);
            }
            buff.append(strArray[strArray.length - 1]);
        }
        return buff.toString();
    }


    /**
     * 获取图片路径中的图片名称
     *
     * @param strs String ss="http://192.168.0.103:8080/uploadFile/avatar/9013070216562503250.jpg，http://192.168.0.103:8080/uploadFile/avatar/2013070216562503150.jpg";
     * @return List<String> oldImageNameList
     */
    public static List<String> getImageNameByReg(String strs) {
        List<String> oldImageNameList = new ArrayList<String>();
        if (!StringUtils.isBlank(strs)) {
            String delimiters = "\\s+|,\\s*|\\，\\s*";
            String[] names = strs.split(delimiters);
            if (names != null) {
                for (int i = 0; i < names.length; i++) {
                    String name = names[i].substring(names[i].lastIndexOf("/") + 1, names[i].length());
                    oldImageNameList.add(name);
                }
            }
        }
        return oldImageNameList;
    }

    /**
     * 字符串替换，将 source 中的 oldString 全部换成 newString
     *
     * @param source    源字符串
     * @param oldString 老的字符串
     * @param newString 新的字符串
     * @return 替换后的字符串 用于输入的表单字符串转化成HTML格式的文本
     */
    public static String Replace(String source, String oldString,
                                 String newString) {
        StringBuffer output = new StringBuffer();
        int lengthOfSource = source.length(); // 源字符串长度
        int lengthOfOld = oldString.length(); // 老字符串长度
        int posStart = 0; // 开始搜索位置
        int pos; // 搜索到老字符串的位置

        while ((pos = source.indexOf(oldString, posStart)) >= 0) {
            output.append(source.substring(posStart, pos));
            output.append(newString);
            posStart = pos + lengthOfOld;
        }
        if (posStart < lengthOfSource) {
            output.append(source.substring(posStart));
        }
        return output.toString();
    }


    /**
     * 对页面中的标题或需要定长显示的字符串进行格式化，使其适合于在给定的长度内显示， 长度超过时，显示为"ssssss..."
     */
    public static String htmlTitleFilter(String srcTitle, int outputLength) {
        String result = srcTitle;
        try {
            while (result.getBytes().length > outputLength) {
                result = result.substring(0, result.length() - 1);
            }
            if (srcTitle.length() > result.length())
                result = result + "...";
        } catch (Exception e) {
        }
        return result;
    }


    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param d     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static float round(double d, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(d));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).floatValue();
    }


    /**
     * @param args void
     * @Title: main
     * @Description: TODO(测试工具类)
     */

    public static void main(String[] args) {


    }
}
