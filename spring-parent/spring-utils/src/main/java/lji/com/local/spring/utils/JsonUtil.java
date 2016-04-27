package lji.com.local.spring.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.alibaba.fastjson.JSON;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**Json/Object互转工具.
 * @author: hanmeng
 * @since: 2015年6月10日 上午10:51:04
 * @history:
 */
@SuppressWarnings("deprecation")
public class JsonUtil {

    static ObjectMapper objectMapper = new ObjectMapper();
    
    static {
    	objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

    /**将list类型数据转换成JSON格式数据(注：BigDecimal类型如果为null的话 转换为json会默认为0).
    * @param ob 要转换的对象
    * @return String
    * @create: 2015年6月11日 下午2:38:18 hanmeng
    * @history:
    */
    public static String list2json(Object ob) {
        return JSONArray.fromObject(ob).toString();
    }

    /**将object类型数据转换成JSON格式数据（注：字段为null时不做转换） 
     * @param ob 要转换的对象
     * @return String
     * @create: 2016年2月22日 下午12:12:28 hanmeng
     * @history: 
     */
    public static String obj2Json(Object ob) {
        return JSON.toJSONString(ob);
    }

    /**将json格式数据转换成指定格式的list（第一种方法）.
     * @param json json格式数据
     * @param Ob 转换对象
     * @return List<?>
     * @create: 2015年6月11日 下午2:28:14 hanmeng
     * @history:
     */
    public static List<?> json2List(String json, Class<?> Ob) {
        JSONArray jsonarray = JSONArray.fromObject(json);
		List<?> list = (List<?>) JSONArray.toList(jsonarray, Ob);
        return list;
    }

    /**将json格式数据转换成指定格式的list（第二种方法）.
     * @param json json格式数据
     * @param Ob 转换对象
     * @return List<?>
     * @create: 2015年6月11日 下午2:28:14 hanmeng
     * @history:
     */
    public static List<?> json2List2(String json, Class<?> Ob) {
        JSONArray jsonarray = JSONArray.fromObject(json);
        List<?> list = (List<?>) JSONArray.toCollection(jsonarray, Ob);
        return list;
    }

    /**将json格式数据转换成指定对象（第一种方法）.
     * @param json json格式数据
     * @param Ob 指定对象
     * @return Object
     * @create: 2015年6月11日 下午2:40:45 hanmeng
     * @history:
     */
    public static Object json2Object(String json, Class<?> Ob) {
        JSONObject jsonObject = JSONObject.fromObject(json);
        return JSONObject.toBean(jsonObject, Ob);
    }

    /**将object类型数据转换成JSON格式数据（第一种方法）.
     * @param ob 要转换的对象
     * @return String
     * @create: 2015年6月11日 下午2:38:18 hanmeng
     * @history:
     */
    public static String Object2json(Object ob) {
        return JSONObject.fromObject(ob).toString();
    }

    /**将json格式数据转换成指定的对象(第二种方法),注意：使用JsonToOb()方法转object，再转json时 只能用ObToJson()方法,不能用本类中的其他方法.
     * @param json json格式数据
     * @param Ob 转换对象
     * @return Object
     * @create: 2015年6月11日 下午2:30:44 hanmeng
     * @history:
     */
    public static Object JsonToOb(String json, Class<?> Ob) {
        Object tar = null;
        try {
            tar = objectMapper.readValue(json, Ob);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tar;
    }

    /**将对象转换成json格式数据（第二种方法）注意：使用ObToJson()方法转json，再转object时 只能用JsonToOb()方法,不能用本类中的其他方法.
     * @param ob 对象
     * @return String
     * @create: 2015年6月11日 下午2:31:31 hanmeng
     * @history:
     */
    public static String ObToJson(Object ob) {
        String str = null;
        try {
            str = objectMapper.writeValueAsString(ob);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    
    /**
     * 将json转化为list
     * @auther lji
     * @date 2016年3月3日下午5:35:56
     * @param str
     * @param clazz
     * @return
     */
    public static <T> List<T> jsonToList(String str, Class<T> clazz) {
    	com.alibaba.fastjson.JSONArray array = com.alibaba.fastjson.JSONArray.parseArray(str);
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < array.size(); i++) {
			com.alibaba.fastjson.JSONObject jsonObject = array.getJSONObject(i);
			list.add(com.alibaba.fastjson.JSONObject.parseObject(jsonObject.toString(), clazz));
		}
		return list;
	}

}
