package com.resource;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;

import com.resourceloader.interfaces.ResourceLoader;

public class ResourceLoaderImpl implements ResourceLoader{

	@Override
	public Drawable getImageDrawable(Context context) {
		return context.getResources().getDrawable(R.drawable.power_off);
	}

	@Override
	public Drawable getImageDrawableById(Context context, int drawableid) {
		return context.getResources().getDrawable(drawableid);
	}

	@Override
	public String getStringById(Context context, int stringid) {
		return context.getResources().getString(stringid);
	}

	@Override
	public String getStringId(Context context) {
		return context.getResources().getString(R.string.dynamic_string);
	}

	@Override
	public View getView(Context context) {
		return LayoutInflater.from(context).inflate(R.layout.dynamic_view, null);
	}

	@Override
	public View getViewById(Context context, int viewid) {
		return LayoutInflater.from(context).inflate(viewid, null);
	}

}
