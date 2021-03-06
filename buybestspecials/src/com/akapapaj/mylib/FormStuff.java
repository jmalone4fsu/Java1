package com.akapapaj.mylib;
/*
 *  Author: Joseph Malone akaPapaJ
 *  Class:  Java 1 - Week 2
 *  Instructor: Josh Donlan
 *  Date: November 1, 2012
 */
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class FormStuff {
	public static LinearLayout enterTextWithButton(Context context, String hint, String buttonText) {
		LinearLayout ll = new LinearLayout(context);
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		ll.setLayoutParams(lp);
		
		EditText et = new EditText(context);
		lp = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.0f);
		et.setHint(hint);
		et.setLayoutParams(lp);
		et.setId(1);
		
		Button b = new Button(context);
		b.setText(buttonText);
		et.setId(2);
		b.setTag(et);
		
		
		ll.addView(et);
		ll.addView(b);
		
		return ll;
	}
}
