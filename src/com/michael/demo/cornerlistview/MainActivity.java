package com.michael.demo.cornerlistview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

/**
 * This Demo shows how to make a Corner ListView just like the iPhone TableView
 * 
 * 这个demo展示了如何制作一个类似iPhone的TableView控件
 * 
 * @author MichaelYe
 * @since 2012-8-29
 * */
public class MainActivity extends Activity 
{

	CornerListView cornerListView;
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        cornerListView = (CornerListView)findViewById(R.id.list);
        cornerListView.setAdapter(new SimpleAdapter(MainActivity.this, getData(), 
        		android.R.layout.simple_list_item_1, new String[]{"KEY"}, new int[]{android.R.id.text1}));
    }

    /**
     * DataSource
     * 
     * 数据源
     * 
     * 
     * */
    public List<HashMap<String, String>> getData()
    {
    	List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
    	HashMap<String, String> map0 = new HashMap<String, String>();
    	HashMap<String, String> map1 = new HashMap<String, String>();
    	HashMap<String, String> map2 = new HashMap<String, String>();
    	HashMap<String, String> map3 = new HashMap<String, String>();
    	HashMap<String, String> map4 = new HashMap<String, String>();
    	map0.put("KEY", "0");
    	map1.put("KEY", "1");
    	map2.put("KEY", "2");
    	map3.put("KEY", "3");
    	map4.put("KEY", "4");
    	dataList.add(map0);
    	dataList.add(map1);
    	dataList.add(map2);
    	dataList.add(map3);
    	dataList.add(map4);
    	return dataList;
    }
    
}
