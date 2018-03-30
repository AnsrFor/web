package application;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
@WebListener
//��Servlet�����Է�Χ���м���
public class ContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		String attrName = event.getName();//��ȡ������
		Object attrValue = event.getValue();//��ȡ����ֵ
		System.out.println("�������(add)�ˣ�������Ϊ:" + attrName + "������ֵΪ��" + attrValue);
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		String attrName = event.getName();//��ȡ������
		Object attrValue = event.getValue();//��ȡ����ֵ
		System.out.println("�����滻(replace)�ˣ�������Ϊ:" + attrName + "������ֵΪ��" + attrValue);
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		String attrName = event.getName();//��ȡ������
		Object attrValue = event.getValue();//��ȡ����ֵ
		System.out.println("�����Ƴ�(remove)�ˣ�������Ϊ:" + attrName + "������ֵΪ��" + attrValue);
	}
}
