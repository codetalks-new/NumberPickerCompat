package com.xiyili.numberpickercompat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

/**
 * @hide
 */
public class CustomEditText extends EditText {

	public CustomEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void onEditorAction(int actionCode) {
		super.onEditorAction(actionCode);
		if (actionCode == EditorInfo.IME_ACTION_DONE) {
			clearFocus();
		}
	}
}