package session;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//实现了HttpSessionBindiingListener接口的监听器，用来监听session属性，此属性不用注册
public class SessionBindingListener implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		String name = event.getName();//获取属性名
		Object value = event.getValue();//获取属性值
		System.out.println("绑定(bound)session属性，属性名是：" + name + "，属性值是：" + value);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		String name = event.getName();//获取属性名
		Object value = event.getValue();//获取属性值
		System.out.println("解绑(unbound)session属性，属性名是：" + name + "，属性值是：" + value);
	}

}
