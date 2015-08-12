import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HttpURLConnectionDemo {

	private static String cookie = "";
	
	public static void main(String[] args) {
		login();
		//kq();
		kq2();
	}
	
	private static void login() {
		try {
			String pathUrl = "http://192.168.50.50/json?action=LOGIN_BY_USER_ACTION&USERNAME=tangya&PASSWORD=123456";
			String params = "action=LOGIN_BY_USER_ACTION&USERNAME=tangya&PASSWORD=123456";
			// 建立连接
			URL url = new URL(pathUrl);
			HttpURLConnection httpConn = (HttpURLConnection) url
					.openConnection();

			// //设置连接属性
			httpConn.setDoOutput(true);// 使用 URL 连接进行输出
			httpConn.setDoInput(true);// 使用 URL 连接进行输入
			httpConn.setUseCaches(false);// 忽略缓存
			httpConn.setRequestMethod("POST");// 设置URL请求方法

			// 设置请求属性
			// 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致
			httpConn.setRequestProperty("User-Agent", 
					URLEncoder.encode("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:39.0) Gecko/20100101 Firefox/39.0", "utf-8"));
			httpConn.setRequestProperty("Accept", URLEncoder.encode("application/json, text/javascript, */*", "utf-8"));
			httpConn.setRequestProperty("Accept-Language", URLEncoder.encode("zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3", "utf-8"));
			httpConn.setRequestProperty("Accept-Encoding", URLEncoder.encode("gzip, deflate", "utf-8"));// 维持长连接
			httpConn.setRequestProperty("X-Requested-With", URLEncoder.encode("XMLHttpRequest", "utf-8"));
			httpConn.setRequestProperty("Referer", URLEncoder.encode("0", "utf-8"));
			httpConn.setRequestProperty("Content-Length", URLEncoder.encode("http://192.168.50.50/", "utf-8"));
			httpConn.setRequestProperty("Content-Type", URLEncoder.encode("text/plain; charset=UTF-8", "utf-8"));
			httpConn.setRequestProperty("Cookie", URLEncoder.encode("name=tangya; password=123456;", "utf-8"));
			httpConn.setRequestProperty("Connection", URLEncoder.encode("keep-alive", "utf-8"));
			httpConn.setRequestProperty("Pragma", URLEncoder.encode("no-cache", "utf-8"));
			httpConn.setRequestProperty("Cache-Control", URLEncoder.encode("no-cache", "utf-8"));
			
			httpConn.connect();
			
//			OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());
//            writer.write(params);
//            writer.flush();
			
			// 获得响应状态
			int responseCode = httpConn.getResponseCode();
			if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
				// 当正确响应时处理数据
				StringBuffer sb = new StringBuffer();
				String readLine;
				BufferedReader responseReader;
				// 处理响应流，必须与服务器响应流输出的编码一致
				responseReader = new BufferedReader(new InputStreamReader(
						httpConn.getInputStream(), "UTF-8"));
				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine).append("\n");
				}
				
		        String sessionId = "";  
		        String cookieVal = "";  
		        String key = null;  
		        //取cookie  
		        for(int i = 1; (key = httpConn.getHeaderFieldKey(i)) != null; i++){  
		            if(key.equalsIgnoreCase("set-cookie")){  
		                cookieVal = httpConn.getHeaderField(i);  
		                cookieVal = cookieVal.substring(0, cookieVal.indexOf(";"));  
		                sessionId = sessionId + cookieVal + ";";  
		            }  
		        }
		        String str2 = cookieVal;
		        cookie = sessionId;
				//writer.close();
				responseReader.close();
				//tv.setText(sb.toString());
				System.out.println(sb.toString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static void kq() {
		try {
			String pathUrl = "http://192.168.50.50/json?action=ADD_TBL_KQ_RECORD_ACTION&FLAG=4&name=tangya&password=123456";
			//String params = "name=tangya&password=123456&" + cookie + "&FLAG=4";
			// 建立连接
			URL url = new URL(pathUrl);
			HttpURLConnection httpConn = (HttpURLConnection) url
					.openConnection();

			// //设置连接属性
			httpConn.setDoOutput(true);// 使用 URL 连接进行输出
			httpConn.setDoInput(true);// 使用 URL 连接进行输入
//			httpConn.setUseCaches(false);// 忽略缓存
			httpConn.setRequestMethod("POST");// 设置URL请求方法

			// 设置请求属性
			// 获得数据字节数据，请求数据流的编码，必须和下面服务器端处理请求流的编码一致
//			httpConn.setRequestProperty("Host", URLEncoder.encode("192.168.50.50", "utf-8"));
//			httpConn.setRequestProperty("User-Agent", 
//					URLEncoder.encode("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:39.0) Gecko/20100101 Firefox/39.0", "utf-8"));
//			httpConn.setRequestProperty("Accept", URLEncoder.encode("application/json, text/javascript, */*", "utf-8"));
//			httpConn.setRequestProperty("Accept-Language", URLEncoder.encode("zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3", "utf-8"));
//			httpConn.setRequestProperty("Accept-Encoding", URLEncoder.encode("gzip, deflate", "utf-8"));
//			httpConn.setRequestProperty("X-Requested-With", URLEncoder.encode("XMLHttpRequest", "utf-8"));
//			httpConn.setRequestProperty("Referer", URLEncoder.encode("0", "utf-8"));
//			httpConn.setRequestProperty("Content-Length", URLEncoder.encode("http://192.168.50.50/mainFrame.html", "utf-8"));
//			httpConn.setRequestProperty("Content-Type", URLEncoder.encode("application/x-www-form-urlencoded; charset=UTF-8", "utf-8"));
//			httpConn.setRequestProperty("Cookie", URLEncoder.encode("name=tangya; password=123456; " + cookie, "utf-8"));
//			httpConn.setRequestProperty("Connection", URLEncoder.encode("keep-alive", "utf-8"));
//			httpConn.setRequestProperty("Pragma", URLEncoder.encode("no-cache", "utf-8"));
//			httpConn.setRequestProperty("Cache-Control", URLEncoder.encode("no-cache", "utf-8"));
//			httpConn.connect();
			
//			OutputStream writer = httpConn.getOutputStream();
//            writer.write(URLEncoder.encode(params, "utf-8").getBytes());
//            writer.flush();
			
//	        DataOutputStream out = new DataOutputStream(httpConn
//	                .getOutputStream());
//	        out.writeBytes(URLEncoder.encode(params, "utf-8"));
//
//	        out.flush();
//	        out.close(); 
			
			// 获得响应状态
			int responseCode = httpConn.getResponseCode();
			if (HttpURLConnection.HTTP_OK == responseCode) {// 连接成功
				// 当正确响应时处理数据
				StringBuffer sb = new StringBuffer();
				String readLine;
				BufferedReader responseReader;
				// 处理响应流，必须与服务器响应流输出的编码一致
				responseReader = new BufferedReader(new InputStreamReader(
						httpConn.getInputStream(), "UTF-8"));
				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine).append("\n");
				}
				//writer.close();
				responseReader.close();
				//tv.setText(sb.toString());
				System.out.println(sb.toString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static void kq2() {
		try {
			String pathUrl = "http://192.168.50.50/json?action=ADD_TBL_KQ_RECORD_ACTION";
	        HttpPost httpPost = new HttpPost(pathUrl);
	        httpPost.setHeader("Cookie", cookie);
	        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
	        nvps.add(new BasicNameValuePair("action", "ADD_TBL_KQ_RECORD_ACTION"));
	        //nvps.add(new BasicNameValuePair("cookie", cookie));
	        nvps.add(new BasicNameValuePair("FLAG", "4"));
	        nvps.add(new BasicNameValuePair("name", "tangya"));
	        nvps.add(new BasicNameValuePair("password", "123456"));
	        httpPost.setEntity(new UrlEncodedFormEntity(nvps,"utf-8"));  
			HttpResponse response = HttpClients.createDefault().execute(
					httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				String result = EntityUtils.toString(response.getEntity());
				System.out.println(result);
			}
//	        List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
//	        nvps.add(new BasicNameValuePair("username", "vip"));  
//	        nvps.add(new BasicNameValuePair("password", "secret"));  
//	        httpPost.setEntity(new UrlEncodedFormEntity(nvps));  
//	        httpclient.execute(httpPost);  
//	        httpclient.getConnectionManager().shutdown();  
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
