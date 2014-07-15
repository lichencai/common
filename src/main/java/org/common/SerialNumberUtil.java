package org.common;

import java.util.UUID;

public class SerialNumberUtil {
	
    //全局流水号变量
	static int serialnum=0;
	
	//获取流水号
	public static String getSerialNumber(){
		/*//最终返回的流水号字符串
		String serialNumber=null;
		
		//1获取机器名
		String machineName = null;
		try {
			machineName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			machineName = "unknownhost";
		} 
		
		
		//2获取进程ID
		RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String runtimeID = runtime.getName().substring(0, runtime.getName().indexOf("@"));
        
		//3获取当前时分秒
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        String time = sdf.format(date);
        
		//4流水号
        //如果全局变量大于999，变量归零
        if(serialnum > 999){
        	serialnum = 0;
        }
        String s="00"+serialnum;
        String realSerialnum = s.substring(s.length()-3, 3);
 
        //流水号组成：机器名+进程ID+当前时分秒+补零后的流水号
		serialNumber = machineName + runtimeID + time + realSerialnum;
		//此方法每被调用一次，全局变量自加1
		serialnum++;
		return serialNumber;*/
        return UUID.randomUUID().toString().replace("-", "");
	}

    //add by liangweiming, 多线程并发不会返回相同值
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
