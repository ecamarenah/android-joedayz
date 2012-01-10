package org.upc.socrates;

import org.upc.R;

import android.app.Activity;
import android.content.Intent;

public class Theme {
	public final static int THEME_DEFAULT = 0;
	public final static int THEME_AMADEUS = 1;

	private int theme;

	public Theme(int theme) {
		this.theme = theme;
	}

	/** Set the theme of the activity, according to the configuration. */
	public void onActivityCreateSetTheme(Activity activity) {
		switch (theme) {
		case THEME_DEFAULT:
			activity.setTheme(R.style.Theme_Default);
			break;
		case THEME_AMADEUS:
			activity.setTheme(R.style.Theme_Amadeus);
			break;
		}
	}

	/**
	 * Set the theme of the Activity, and restart it by creating a new Activity
	 * of the same type.
	 */
	public void changeToTheme(Activity activity, int theme) {
		this.theme = theme;
		activity.finish();
		activity.startActivity(new Intent(activity, activity.getClass()));
	}
}
