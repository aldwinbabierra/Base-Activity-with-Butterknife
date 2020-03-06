package com.ibayad.aldwin.baseactivitywithbk;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
	
	private String TAG = "";
	private Context context = null;
	
	@NonNull
	protected abstract int layoutResource ();
	
	@Override
	protected void onCreate (@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutResource());
		ButterKnife.bind(this);
		
		initViews();
		init();
		initListeners();
	}
	
	@CallSuper
	protected void initViews () {
	
	}
	
	@CallSuper
	protected void init () {
		try {
			context = (Context) this;
			TAG = StringUtil.trimChars(context.getClass().getSimpleName(), 23);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@CallSuper
	protected void initListeners () {
	
	}
	
	protected Context getBaseActivity() {
		return context;
	}
	
	protected String TAG() {
		return TAG;
	}
	
}