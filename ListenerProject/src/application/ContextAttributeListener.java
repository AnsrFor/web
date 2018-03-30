package application;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
@WebListener
//对Servlet的属性范围进行监听
public class ContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		String attrName = event.getName();//获取属性名
		Object attrValue = event.getValue();//获取属性值
		System.out.println("属性添加(add)了，属性名为:" + attrName + "，属性值为：" + attrValue);
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		String attrName = event.getName();//获取属性名
		Object attrValue = event.getValue();//获取属性值
		System.out.println("属性替换(replace)了，属性名为:" + attrName + "，属性值为：" + attrValue);
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		String attrName = event.getName();//获取属性名
		Object attrValue = event.getValue();//获取属性值
		System.out.println("属性移除(remove)了，属性名为:" + attrName + "，属性值为：" + attrValue);
	}
}
