package com.resourceloader.interfaces;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

public interface ResourceLoader {
	public abstract String getStringById(Context context,int stringid);
	public abstract String getStringId(Context context);
	
	public abstract Drawable getImageDrawableById(Context context,int imageid);
	public abstract Drawable getImageDrawable(Context context);
	
	
	public abstract View getViewById(Context context,int viewid);
	public abstract View getView(Context context);
}
