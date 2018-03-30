package session;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

//ʵ����HttpSessionBindiingListener�ӿڵļ���������������session���ԣ������Բ���ע��
public class SessionBindingListener implements HttpSessionBindingListener {

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		String name = event.getName();//��ȡ������
		Object value = event.getValue();//��ȡ����ֵ
		System.out.println("��(bound)session���ԣ��������ǣ�" + name + "������ֵ�ǣ�" + value);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		String name = event.getName();//��ȡ������
		Object value = event.getValue();//��ȡ����ֵ
		System.out.println("���(unbound)session���ԣ��������ǣ�" + name + "������ֵ�ǣ�" + value);
	}

}
