package org.geogebra.web.full.gui.browser;

import org.geogebra.common.main.App;
import org.geogebra.web.shared.SignInButton;

public class MebisSignInButton extends SignInButton {
	
	public MebisSignInButton(App app) {
		super(app, 0, null);
	}

	@Override
	public void login() {
		if (!nativeLogin()) {
			super.login();
		}
	}

	private native boolean nativeLogin() /*-{
		if ($wnd.parent && $wnd.parent.login) {
			$wnd.parent.login();
			return true;
		}
		return false;
	}-*/;

}
