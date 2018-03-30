package session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name=event.getName();   // 获取属性名
		Object value=event.getValue();   // 获取属性值
		System.out.println("添加（add）session属性了，属性名是："+name+";属性值是："+value);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name=event.getName();   // 获取属性名
		Object value=event.getValue();   // 获取属性值
		System.out.println("移除session(remove)属性了，属性名是："+name+";属性值是："+value);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name=event.getName();   // 获取属性名
		Object value=event.getValue();   // 获取属性值
		System.out.println("替换session(replace)属性了，属性名是："+name+";属性值是："+value);
		
	}

}
