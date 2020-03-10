package com.ibayad.aldwin.baseactivitywithbk;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

@SuppressWarnings({"WeakerAccess", "EmptyMethod"})
public abstract class BaseFragment extends Fragment {

	private Unbinder unbinder;
	private Context context;
	private String TAG = "";
	
	@NonNull
	protected abstract Integer layoutResource();
	
	@Nullable
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(layoutResource(), container, false);
		unbinder = ButterKnife.bind(this, view);
		
		initViews();
		init();
		initListeners();
		
		return view;
	}
	
	@CallSuper
	protected void initViews() {
	
	}
	
	@CallSuper
	protected void init() {
		try {
			this.TAG = StringUtil.trimChars(this.context.getClass().getSimpleName(), 23);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@CallSuper
	protected void initListeners() {
	
	}
	
	@SuppressWarnings("unused")
	protected Context getBaseActivity() {
		return this.context;
	}
	
	protected String TAG() {
		return this.TAG;
	}
	
	@Override
	public void onAttach (@NonNull Context context) {
		super.onAttach(context);
		this.context = context;
	}
	
	@Override
	public void onDetach () {
		super.onDetach();
		this.context = null;
	}
	
	@Override
	public void onDestroyView () {
		super.onDestroyView();
		if (unbinder != null) {
			try {
				unbinder.unbind();
			} catch (Exception ignore) {
				//optional to ignore catch here
				unbinder = null;
			}
		}
	}
	
}