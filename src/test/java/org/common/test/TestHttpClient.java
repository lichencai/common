package org.common.test;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestHttpClient {
	
	//超时间隔  
    private static int connectTimeOut = 60000;  
    //让connectionmanager管理httpclientconnection时是否关闭连接  
    private static boolean alwaysClose = false;  
    //返回数据编码格式  
    private String encoding = "UTF-8";  
      
    public String doRequest(String url,Map postData,Map header,String encoding) throws Exception{
    	return null;
    }
    
    
	public static void main(String[] args) throws Exception, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
            HttpGet httpget = new HttpGet("http://www.cnblogs.com/loveyakamoz/archive/2011/07/21/2112804.html");

            System.out.println("Executing request " + httpget.getRequestLine());

            // Create a custom response handler
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
        } finally {
            httpclient.close();
        }
	}
}
