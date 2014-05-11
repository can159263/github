package cn.szboc.platform.component.xmlbean.spring;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.util.ValidationEventCollector;

/**
 * 线程安全的校验事件处理器
 */
public class ThreadSafeValidationEventHandler implements ValidationEventHandler {

	/**
	 * 用线程变量来实现线程并发的安全性
	 */
	private static ThreadLocal<ValidationEventCollector> validationEventCollectors = new ThreadLocal<ValidationEventCollector>() {
		@Override
		protected ValidationEventCollector initialValue() {
			return new ValidationEventCollector();
		}
	};

	@Override
	public boolean handleEvent(ValidationEvent event) {
		return validationEventCollectors.get().handleEvent(event);
	}

	public static ValidationEvent[] getEvents() {
		return validationEventCollectors.get().getEvents();
	}

	public static void reset() {
		validationEventCollectors.get().reset();
	}

	public static boolean hasEvents() {
		return validationEventCollectors.get().hasEvents();
	}

}
