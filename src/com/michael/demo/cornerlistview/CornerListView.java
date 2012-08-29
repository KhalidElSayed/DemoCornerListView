package com.michael.demo.cornerlistview;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Corner effect ListView, some like the iPhone TableView 
 * 
 * 圆角矩形的ListView，类似iPhone的TableView
 * 
 * @author MichaelYe
 * @since 2012-8-29
 * 
 */
public class CornerListView extends ListView 
{

	public CornerListView(Context context) 
	{
		super(context);
		init();
	}

	public CornerListView(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		init();
	}
	
	public CornerListView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		init();
	}

	/**
	 * set the ListView white corner background
	 * 
	 * 设置整体的背景是白色圆角
	 * 
	 * */
	private void init()
	{
		this.setBackgroundResource(R.drawable.corner_list_bg);
	}

	/**
	 * intercept the touch event
	 * 
	 * 拦截触摸事件
	 * 
	 * */
	@Override
	public boolean onInterceptTouchEvent(MotionEvent event)
	{
		switch (event.getAction()) 
		{
		case MotionEvent.ACTION_DOWN:
			int x = (int) event.getX();
			int y = (int) event.getY();
			int itemPosition = pointToPosition(x, y);//Maps a point to a position in the list.
			int itemCount = getAdapter().getCount() - 1;
			if (itemPosition == AdapterView.INVALID_POSITION)
			{
				break;
			}
			else 
			{
				if (itemPosition == 0)//当第一个item被点击的是，需要判断下当前是否只有一条数据
				{
					if (itemPosition == itemCount) 
					{
						//只有一项 only one item
						setSelector(R.drawable.app_list_corner_single_item);
					} 
					else
					{
						//第一项 the first item
						setSelector(R.drawable.app_list_corner_first_item);
					}
				} 
				else if (itemPosition == itemCount)//最后一条数据被点击的时候 the last item
				{
					setSelector(R.drawable.app_list_corner_last_item);
				}
				else 
				{
					setSelector(R.drawable.app_list_corner_middle_item);
				}
			}

			break;
		case MotionEvent.ACTION_UP:
			break;
		}
		return super.onInterceptTouchEvent(event);
	}
}
