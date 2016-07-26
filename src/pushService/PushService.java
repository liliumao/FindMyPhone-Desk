package pushService;

import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Sender;



public class PushService {
	public void sendMessage(String username, String IMEI) throws Exception {
		Constants.useOfficial();
	    Sender sender = new Sender("hSe1ky+Rvbjec2zg7J7exQ==");
		
	    if(username.equals(""))
	    	username = "测试";
	    
	    String PACKAGENAME = "com.ufotosoft.findmyphone";
	    String messagePayload = "找手机";
	    String title = "找手机";
	    String description = "请把手机交给" + username;
	    Message message = new Message.Builder()
	    		.title(title)
	            .description(description).payload(messagePayload)
	            .restrictedPackageName(PACKAGENAME)
	            .passThrough(0) //消息使用通知栏方式
	            .notifyType(1)
	            .build();
	    sender.sendToAlias(message, IMEI, 0); //根据alias，发送消息到指定设备上，不重试。
	}
	
}
