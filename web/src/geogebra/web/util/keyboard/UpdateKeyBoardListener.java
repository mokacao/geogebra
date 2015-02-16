package geogebra.web.util.keyboard;

import com.google.gwt.user.client.ui.Widget;

public interface UpdateKeyBoardListener {

	public abstract void updateKeyBoard(Widget textField);

	public abstract void showInputField();

	public abstract void showKeyBoard(boolean show, Widget textField);
}
