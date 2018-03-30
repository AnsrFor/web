package session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name=event.getName();   // ��ȡ������
		Object value=event.getValue();   // ��ȡ����ֵ
		System.out.println("��ӣ�add��session�����ˣ��������ǣ�"+name+";����ֵ�ǣ�"+value);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		String name=event.getName();   // ��ȡ������
		Object value=event.getValue();   // ��ȡ����ֵ
		System.out.println("�Ƴ�session(remove)�����ˣ��������ǣ�"+name+";����ֵ�ǣ�"+value);
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name=event.getName();   // ��ȡ������
		Object value=event.getValue();   // ��ȡ����ֵ
		System.out.println("�滻session(replace)�����ˣ��������ǣ�"+name+";����ֵ�ǣ�"+value);
		
	}

}
