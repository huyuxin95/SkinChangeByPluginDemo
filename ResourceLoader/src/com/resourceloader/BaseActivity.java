package com.resourceloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;


public class BaseActivity extends Activity {
	private AssetManager assetManager;
	private Resources resources;
	private Theme newTheme;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	//获取插件资源
	protected void loadResource(String dexPath){
		try {
		//通过反射,将插件的资源注入到宿主中去
		assetManager=AssetManager.class.newInstance();
		Method method = assetManager.getClass().getMethod("addAssetPath", String.class);
		method.invoke(assetManager, dexPath);
		
		Resources supres=super.getResources();
		
		resources=new Resources(assetManager, supres.getDisplayMetrics(),supres.getConfiguration());
		newTheme = resources.newTheme();
		newTheme.setTo(super.getTheme());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public AssetManager getAssets() {
		return assetManager==null?super.getAssets():assetManager;
	}
	
	@Override
	public Resources getResources() {
		return  resources==null? super.getResources():resources;
	}
	
	
	@Override
	public Theme getTheme() {
		// TODO Auto-generated method stub
		return newTheme==null?super.getTheme():newTheme;
	}
	

}
