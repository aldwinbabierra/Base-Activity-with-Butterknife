package com.ibayad.aldwin.baseactivitywithbk;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import butterknife.ButterKnife;

/**
 * Created and Coded by:
 * Aldwin and Josef
 * iBayad Online Ventures Inc.
 * (c) 2020
 */

@SuppressWarnings({"EmptyMethod", "unused"})
public abstract class BaseActivity extends AppCompatActivity {
	
	private String TAG = "";
	private Context context = null;
	private FragmentManager fragmentManager;
	@SuppressWarnings("FieldCanBeLocal")
	private FragmentTransaction fragmentTransaction;
	private Integer fragmentStackCount = 0;
	private Boolean isDestroyed = false;
	
	@NonNull
	protected abstract Integer layoutResource ();
	
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
	public void initViews () {
		//Initialize your views here
		//if not using ButterKnife
		//and/or using special initialization.
	}
	
	@CallSuper
	public void init () {
		//noinspection RedundantCast
		context = (Context) this;
		
		try {
			TAG = this.context.getClass().getSimpleName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			fragmentManager = getSupportFragmentManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			fragmentStackCount = fragmentManager.getBackStackEntryCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@CallSuper
	public void initListeners () {
		//Initialize your listeners here
	}
	
	public void loadFragment (@NonNull View target, BaseFragment fragment) {
		loadFragment(target, fragment, fragment.getMyTag(), null);
	}
	
	public void loadFragment (@NonNull View target, BaseFragment fragment, String tag) {
		loadFragment(target, fragment, tag, null);
	}
	
	public void loadFragment (@NonNull View target, BaseFragment fragment, CustomFragmentAnimation customFragmentAnimation) {
		loadFragment(target, fragment, fragment.getMyTag(), customFragmentAnimation);
	}
	
	public void loadFragment (@NonNull View target, BaseFragment fragment, String tag, CustomFragmentAnimation customFragmentAnimation) {
		try {
			this.fragmentTransaction = this.fragmentManager.beginTransaction();
			
			//Add animation if not null
			if (customFragmentAnimation != null) {
				if ((customFragmentAnimation.getEnter() != 0 && customFragmentAnimation.getExit() != 0)
							    && (customFragmentAnimation.getPopEnter() != 0 && customFragmentAnimation.getPopExit() != 0)) {
					this.fragmentTransaction.setCustomAnimations(customFragmentAnimation.getEnter(),
								customFragmentAnimation.getExit(),
								customFragmentAnimation.getPopEnter(),
								customFragmentAnimation.getPopExit());
				} else if (customFragmentAnimation.getEnter() != 0 && customFragmentAnimation.getExit() != 0) {
					this.fragmentTransaction.setCustomAnimations(customFragmentAnimation.getEnter(), customFragmentAnimation.getExit());
				}
			}
			
			this.fragmentTransaction.replace(target.getId(), fragment, tag);
			this.fragmentTransaction.addToBackStack(tag);
			this.fragmentTransaction.commit();
			
			Log.d(getMyTag(23), tag + " has been added to the stack!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Context getBaseActivity () {
		return this.context;
	}
	
	public FragmentManager getBaseFragmentManager () {
		return this.fragmentManager;
	}
	
	public Integer getFragmentStackCount () {
		return this.fragmentStackCount;
	}
	
	public String getMyTag () {
		return getMyTag(0);
	}
	
	public String getMyTag (Integer numOfChars) {
		try {
			return StringUtil.trimChars(this.TAG, numOfChars);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	@Override
	public void onBackPressed () {
		try {
			if (getFragmentStackCount() == 1) {
				super.onBackPressed();
			} else {
				this.fragmentManager.popBackStack();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onResume () {
		super.onResume();
		
		if (isDestroyed) {
			initViews();
			init();
			initListeners();
		}
	}
	
	@Override
	protected void onDestroy () {
		try {
			String delim = "";
			StringBuilder builder = new StringBuilder();
			for (Fragment fragment : this.fragmentManager.getFragments()) {
				builder.append(delim).append(fragment.getClass().getSimpleName());
				delim = ", ";
			}
			
			if (this.fragmentManager.popBackStackImmediate()) {
				Log.d(getMyTag(23), "Popped fragments from the stack: " + builder.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			isDestroyed = true;
			Log.d(getMyTag(23), "this activity is now destroyed.");
		}
		
		super.onDestroy();
	}
	
}