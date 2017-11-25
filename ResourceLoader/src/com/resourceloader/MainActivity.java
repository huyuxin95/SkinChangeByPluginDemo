package com.resourceloader;

import java.io.File;

import com.resourceloader.interfaces.ResourceLoader;

import dalvik.system.DexClassLoader;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
	private Button btn_1;
	private Button btn_2;
	private Button btn_3;
	private Button btn_4;
	private TextView tx_text;
	private ImageView iv_image;
	private LinearLayout view_add;
	private DexClassLoader dexClassLoader;
	private String dexPath;
	private String optPath;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_1=(Button) this.findViewById(R.id.btn_1);
		btn_2=(Button) this.findViewById(R.id.btn_2);
		btn_3=(Button) this.findViewById(R.id.btn_3);
		btn_4=(Button) this.findViewById(R.id.btn_4);
		tx_text=(TextView) this.findViewById(R.id.tx_text);
		iv_image=(ImageView) this.findViewById(R.id.iv_image);
		view_add=(LinearLayout) this.findViewById(R.id.view_add);
		
		btn_1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				LoadContent_One();
			}
		});
		
		btn_2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				LoadContent_Two();
			}
		});
		
		btn_3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				LoadContent_Three();
			}
		});
		
		btn_4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				LoadContent_Four();
			}
		});
	}
	
	private void LoadContent_One(){
		dexPath=Environment.getExternalStorageDirectory()+File.separator+"ResourceOne.apk";
		optPath=getDir("dex", Context.MODE_WORLD_WRITEABLE).getAbsolutePath();
		dexClassLoader=new DexClassLoader(dexPath, optPath, null, this.getClassLoader());
		loadResource(dexPath);
		
		try {
			ResourceLoader newInstance = (ResourceLoader)dexClassLoader.loadClass("com.resource.ResourceLoaderImpl").newInstance();
			String string = newInstance.getStringId(MainActivity.this);
			Drawable imageDrawable = newInstance.getImageDrawable(MainActivity.this);
			View view = newInstance.getView(MainActivity.this);
			
			tx_text.setText(string);
			iv_image.setBackground(imageDrawable);
			view_add.removeAllViews();
			view_add.addView(view);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	private void LoadContent_Two(){
		dexPath=Environment.getExternalStorageDirectory()+File.separator+"ResourceTwo.apk";
		optPath=getDir("dex", Context.MODE_WORLD_WRITEABLE).getAbsolutePath();
		dexClassLoader=new DexClassLoader(dexPath, optPath, null, this.getClassLoader());
		loadResource(dexPath);

		try {
			ResourceLoader newInstance = (ResourceLoader)dexClassLoader.loadClass("com.resource.ResourceLoaderImpl").newInstance();
			String string = newInstance.getStringId(MainActivity.this);
			Drawable imageDrawable = newInstance.getImageDrawable(MainActivity.this);
			View view = newInstance.getView(MainActivity.this);
			
			tx_text.setText(string);
			iv_image.setBackground(imageDrawable);
			view_add.removeAllViews();
			view_add.addView(view);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	private void LoadContent_Three(){
		dexPath=Environment.getExternalStorageDirectory()+File.separator+"ResourceOne.apk";
		optPath=getDir("dex", Context.MODE_WORLD_WRITEABLE).getAbsolutePath();
		dexClassLoader=new DexClassLoader(dexPath, optPath, null, this.getClassLoader());
		loadResource(dexPath);
		try {
			ResourceLoader newInstance = (ResourceLoader)dexClassLoader.loadClass("com.resource.ResourceLoaderImpl").newInstance();
			String string = newInstance.getStringById(MainActivity.this, R.string.dynamic_string);
			Drawable imageDrawable = newInstance.getImageDrawableById(MainActivity.this, R.drawable.power_off);
			View view = newInstance.getViewById(MainActivity.this, R.layout.dynamic_view);	
			
			tx_text.setText(string);
			iv_image.setBackground(imageDrawable);
			view_add.removeAllViews();
			view_add.addView(view);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	private void LoadContent_Four(){
		dexPath=Environment.getExternalStorageDirectory()+File.separator+"ResourceTwo.apk";
		optPath=getDir("dex", Context.MODE_WORLD_WRITEABLE).getAbsolutePath();
		dexClassLoader=new DexClassLoader(dexPath, optPath, null, this.getClassLoader());
		loadResource(dexPath);
		
		try {
			ResourceLoader newInstance = (ResourceLoader)dexClassLoader.loadClass("com.resource.ResourceLoaderImpl").newInstance();
			String string = newInstance.getStringById(MainActivity.this, R.string.dynamic_string);
			Drawable imageDrawable = newInstance.getImageDrawableById(MainActivity.this, R.drawable.power_off);
			View view = newInstance.getViewById(MainActivity.this, R.layout.dynamic_view);	
			
			tx_text.setText(string);
			iv_image.setBackground(imageDrawable);
			view_add.removeAllViews();
			view_add.addView(view);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
}
