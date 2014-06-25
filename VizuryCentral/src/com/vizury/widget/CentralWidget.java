package com.vizury.widget;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.client.ClientProtocolException;

import com.shakir.hellowidget.R;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

public class CentralWidget extends AppWidgetProvider{
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new MyTime(context, appWidgetManager), 1, 86400000);
	}
	
	public class MyTime extends TimerTask {
		RemoteViews remoteViews;
		AppWidgetManager appWidgetManager;
		ComponentName thisWidget;
		DateFormat format = SimpleDateFormat.getTimeInstance(SimpleDateFormat.MEDIUM, Locale.getDefault());
		VizuryCentral vc = new VizuryCentral();
		
		public MyTime(Context context, AppWidgetManager appWidgetManager) {
			this.appWidgetManager = appWidgetManager;
			remoteViews = new RemoteViews(context.getPackageName(), R.layout.main);
			thisWidget = new ComponentName(context, CentralWidget.class);
		}
		
		@Override
		public void run() {
			try {
				remoteViews.setTextViewText(R.id.widget_textview, vc.dataRetriever());
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			appWidgetManager.updateAppWidget(thisWidget, remoteViews);
		}		
		
	}
	
	
}