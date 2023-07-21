package Listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;


public class C02ServletContextAttrListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
//		속성 추가시 감지하여 동작
		System.out.println("C02ServletContextAttrListener's attributeAdded");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
//		속성 제거시 감지하여 동작
		System.out.println("C02ServletContextAttrListener's attributeRemoved");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
//		속성 변경시 감지하여 동작
		System.out.println("C02ServletContextAttrListener's attributeReplaced");
	}
	
}
