package com.ibayad.aldwin.baseactivitywithbk;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;

/**
 * Created and Coded by:
 * Aldwin and Josef
 * iBayad Online Ventures Inc.
 * (c) 2020
 */

@SuppressWarnings({"WeakerAccess", "unused"})
public class CustomFragmentAnimation {

	@AnimatorRes
	@AnimRes
	private Integer enter;
	@AnimatorRes
	@AnimRes
	private Integer exit;
	@AnimatorRes
	@AnimRes
	private Integer popEnter;
	@AnimatorRes
	@AnimRes
	private Integer popExit;
	
	public CustomFragmentAnimation (Integer enter, Integer exit) {
		this.enter = enter;
		this.exit = exit;
	}
	
	public CustomFragmentAnimation (Integer enter, Integer exit, Integer popEnter, Integer popExit) {
		this.enter = enter;
		this.exit = exit;
		this.popEnter = popEnter;
		this.popExit = popExit;
	}
	
	public Integer getEnter () {
		return enter;
	}
	
	public void setEnter (Integer enter) {
		this.enter = enter;
	}
	
	public Integer getExit () {
		return exit;
	}
	
	public void setExit (Integer exit) {
		this.exit = exit;
	}
	
	public Integer getPopEnter () {
		return popEnter;
	}
	
	public void setPopEnter (Integer popEnter) {
		this.popEnter = popEnter;
	}
	
	public Integer getPopExit () {
		return popExit;
	}
	
	public void setPopExit (Integer popExit) {
		this.popExit = popExit;
	}
	
}