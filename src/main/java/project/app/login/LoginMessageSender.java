package project.app.login;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import zebra.mail.AbstractMessageSender;

@SuppressWarnings("rawtypes")
public class LoginMessageSender extends AbstractMessageSender implements ApplicationListener {
	@Override
	public void onApplicationEvent(ApplicationEvent applicationEvent) {
	}
}