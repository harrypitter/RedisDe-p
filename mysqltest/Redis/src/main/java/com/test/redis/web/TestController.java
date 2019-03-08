package com.test.redis.web;


import com.test.redis.domain.UserInfo;
import com.test.redis.service.UserInfoService;
import com.test.redis.service.RedisService;
import com.test.redis.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/test")
public class TestController {
	
	@Autowired
	private RedisService redisService;
	
	@Autowired  
    private UserInfoService userInfoService;

    @RequestMapping(value="/index")
    public String index(){
        return "hello world";
    }
    
    /**
     * 向redis存储值
     * @param key
     * @param value
     * @return
     * @throws Exception
     */
    @RequestMapping("/set/{key}/{value}")
    public String set(@PathVariable("key")String key, @PathVariable("value")String value) throws Exception{

        redisService.set(key, value);
        return "success";  
    }  
    
    /**
     * 获取redis中的值
     * @param key
     * @return
     */
    @RequestMapping("/get/{key}")
    public String get(@PathVariable("key")String key){
        try {
			return redisService.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";  
    }  
    
    /**
     * 获取数据库中的用户
     * @param id
     * @return
     */
    @RequestMapping("/getUser/{id}")  
    public String getUser(@PathVariable String id){
        try {
        	UserInfo user= userInfoService.findById(id);
			return JsonUtil.getJsonString(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";  
    }

    @GetMapping( "/getdata")
    public String getData()
    {
        System.out.println("info has been gotten");
        return "info got";
    }


    @RequestMapping(value = "/saveUser/{name}/{age}" , method = RequestMethod.POST)
    public String putUser(@PathVariable String name,@PathVariable int age){
        try {
            userInfoService.saveData(name,age);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static void main(String[] args) {
        Map<String,Object> keyMap= new HashMap<>();
        keyMap.put("id","编号");
        keyMap.put("name","名称");

        String [] cnCloumn={"编号","名称"};

        System.out.println(Arrays.asList(convertMap(keyMap, cnCloumn)));

    }

    public static String[] convertMap(Map<String,Object> keyMap,String [] dataList){

        for(int i=0;i<dataList.length;i++){

            for(Map.Entry<String, Object> m:keyMap.entrySet()){
                if(m.getValue().equals(dataList[i])){
                   dataList[i]=m.getKey();
                }
            }
        }

        return dataList;
    }


    public static String getName(String name,String add){
        return null;
    }

    public static void testGetClassName() {
        // 方法1：通过SecurityManager的保护方法getClassContext()
        String clazzName = new SecurityManager() {
            public String getClassName() {
                return getClassContext()[1].getName();
            }
        }.getClassName();
        System.out.println(clazzName);
        // 方法2：通过Throwable的方法getStackTrace()
        String clazzName2 = new Throwable().getStackTrace()[1].getClassName();
        System.out.println(clazzName2);
        // 方法3：通过分析匿名类名称()
        String clazzName3 = new Object() {
            public String getClassName() {
                String clazzName = this.getClass().getName();
                return clazzName.substring(0, clazzName.lastIndexOf('$'));
            }
        }.getClassName();
        System.out.println(clazzName3);
        //方法4：通过Thread的方法getStackTrace()
        String clazzName4 = Thread.currentThread().getStackTrace()[2].getClassName();
        System.out.println(clazzName4);
    }



}
