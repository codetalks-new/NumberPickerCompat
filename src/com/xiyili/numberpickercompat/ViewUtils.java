package com.xiyili.numberpickercompat;

import android.view.View;
import android.view.View.MeasureSpec;

public class ViewUtils {
	/**
	 * Indicates the view is pressed. States are used with
	 * {@link android.graphics.drawable.Drawable} to change the drawing of the
	 * view depending on its state.
	 *
	 * @see android.graphics.drawable.Drawable
	 * @see #getDrawableState()
	 * @hide
	 */
	protected static final int[] PRESSED_STATE_SET;
	static final int VIEW_STATE_PRESSED = 1 << 4;//binary:10000,hex:0x10,oct:16
	static {
		PRESSED_STATE_SET = new int[2];
		PRESSED_STATE_SET[0] = android.R.attr.state_pressed;
		PRESSED_STATE_SET[1] = VIEW_STATE_PRESSED;

	}

	/**
	 *  TAKEN FORM VIEW
	 * Utility to reconcile a desired size and state, with constraints imposed
	 * by a MeasureSpec.  Will take the desired size, unless a different size
	 * is imposed by the constraints.  The returned value is a compound integer,
	 * with the resolved size in the {@link #MEASURED_SIZE_MASK} bits and
	 * optionally the bit {@link #MEASURED_STATE_TOO_SMALL} set if the resulting
	 * size is smaller than the size the view wants to be.
	 *
	 * @param size How big the view wants to be
	 * @param measureSpec Constraints imposed by the parent
	 * @return Size information bit mask as defined by
	 * {@link #MEASURED_SIZE_MASK} and {@link #MEASURED_STATE_TOO_SMALL}.
	 */
	public static int resolveSizeAndState(int size, int measureSpec, int childMeasuredState) {
		int result = size;
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize =  MeasureSpec.getSize(measureSpec);
		switch (specMode) {
		case MeasureSpec.UNSPECIFIED:
			result = size;
			break;
		case MeasureSpec.AT_MOST:
			if (specSize < size) {
				result = specSize | View.MEASURED_STATE_TOO_SMALL;
			} else {
				result = size;
			}
			break;
		case MeasureSpec.EXACTLY:
			result = specSize;
			break;
		}
		return result | (childMeasuredState&View.MEASURED_STATE_MASK);
	}

	/**
	 * use by numberpicker ,cause numberpicker is taken from  framework,
	 * so we cant not use {@link View#PRESSED_STATE_SET} directly.
	 * hack it.
	 * @return
	 */
	public static int [] getPressedStateSet() {
		return PRESSED_STATE_SET;
	}

}
