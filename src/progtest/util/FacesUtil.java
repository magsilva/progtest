package progtest.util;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

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
		FacesMessage message = getMessage(key, severity);
		FacesContext.getCurrentInstance().addMessage(clientId, message);
	}

	private static FacesMessage getMessage(String key,
			FacesMessage.Severity severity) {
		FacesMessage message = new FacesMessage(BundleUtil.getString(
				Constants.BUNDLE_MESSAGES, key));
		message.setSeverity(severity);
		return message;
	}

	public static Locale getLocale() {
		return FacesContext.getCurrentInstance().getViewRoot().getLocale();
	}

}
