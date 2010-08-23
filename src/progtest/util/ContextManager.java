package progtest.util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ContextManager {

	public static void setRequest(String label, Object object) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap()
				.put(label, object);
	}

	public static Object getRequest(String label) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestMap().get(label);
	}

	public static Object removeRequest(String label) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRequestMap().remove(label);
	}

	public static void setSession(String label, Object object) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put(label, object);
	}

	public static Object getSession(String label) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(label);
	}

	public static void removeSession(String label) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove(label);
	}

	public static void setApplication(String label, Object object) {
		FacesContext.getCurrentInstance().getExternalContext()
				.getApplicationMap().put(label, object);
	}

	public static Object getApplication(String label) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getApplicationMap().get(label);
	}

	public static Object removeApplication(FacesContext context, String label) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getApplicationMap().remove(label);
	}

	public static void addMessage(String key, FacesMessage.Severity severity) {
		addMessage(null, key, severity);
	}

	public static void addMessage(String clientId, String key,
			FacesMessage.Severity severity) {
		FacesMessage message = getFacesMessage(key, severity);
		FacesContext.getCurrentInstance().addMessage(clientId, message);
	}

	private static FacesMessage getFacesMessage(String key,
			FacesMessage.Severity severity) {
		
		String text;
		
		try {
			ResourceBundle bundle = ResourceBundle.getBundle(
					Constants.RESOURCE_BUNDLE, FacesContext
							.getCurrentInstance().getViewRoot().getLocale());
			text = bundle.getString(key);
		} catch (Exception e) {
			e.printStackTrace();
			text = key;
		}
		
		FacesMessage message = new FacesMessage(text);
		message.setSeverity(severity);
		
		return message;
		
	}

}
