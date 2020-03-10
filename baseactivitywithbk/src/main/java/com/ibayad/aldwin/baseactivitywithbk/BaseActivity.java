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

@SuppressWarnings({"WeakerAccess", "EmptyMethod", "unused"})
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
	protected void initViews () {
	
	}
	
	@CallSuper
	protected void init () {
		try {
			//noinspection RedundantCast
			context = (Context) this;
			TAG = StringUtil.trimChars(this.context.getClass().getSimpleName(), 23);
			fragmentManager = this.getSupportFragmentManager();
			fragmentStackCount = fragmentManager.getBackStackEntryCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@CallSuper
	protected void initListeners () {
	
	}
	
	protected void loadFragment (@NonNull View target, BaseFragment fragment) {
		loadFragment(target, fragment, fragment.TAG(), null);
	}
	
	protected void loadFragment (@NonNull View target, BaseFragment fragment, String tag) {
		loadFragment(target, fragment, tag, null);
	}
	
	protected void loadFragment (@NonNull View target, BaseFragment fragment, CustomFragmentAnimation customFragmentAnimation) {
		loadFragment(target, fragment, fragment.TAG(), customFragmentAnimation);
	}
	
	protected void loadFragment (@NonNull View target, BaseFragment fragment, String tag, CustomFragmentAnimation customFragmentAnimation) {
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
	}
	
	protected Context getBaseActivity () {
		return this.context;
	}
	
	protected FragmentManager getBaseFragmentManager () {
		return this.fragmentManager;
	}
	
	protected Integer getFragmentStackCount () {
		return this.fragmentStackCount;
	}
	
	protected String TAG () {
		return this.TAG;
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
				Log.d(this.TAG, "Popped fragments from the stack: " + builder.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			isDestroyed = true;
		}
		
		super.onDestroy();
	}
	
}