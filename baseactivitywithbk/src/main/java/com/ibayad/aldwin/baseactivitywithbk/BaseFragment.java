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

/**
 * Created and Coded by:
 * Aldwin and Josef
 * iBayad Online Ventures Inc.
 * (c) 2020
 */

@SuppressWarnings({"WeakerAccess", "EmptyMethod"})
public abstract class BaseFragment extends Fragment {
	
	private Unbinder unbinder;
	private Context context;
	private String TAG = "";
	
	@NonNull
	protected abstract Integer layoutResource ();
	
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
	public void initViews () {
	
	}
	
	@CallSuper
	public void init () {
		try {
			this.TAG = this.context.getClass().getSimpleName();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@CallSuper
	public void initListeners () {
	
	}
	
	@SuppressWarnings("unused")
	public Context getBaseActivity () {
		return this.context;
	}
	
	public String TAG () {
		return TAG(0);
	}
	
	public String TAG (Integer numOfChars) {
		try {
			return StringUtil.trimChars(this.TAG, numOfChars);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
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