package com.astar.smin.asimpleweather;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    ViewPager pager;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        WeatherAdaapter adapter = new WeatherAdaapter();
        pager.setAdapter(adapter);



    }//onCreate End

    class WeatherAdaapter extends PagerAdapter{
        //String[] urls = {"https://m.naver.com","https://www.google.com"};

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LinearLayout layout = new LinearLayout(getApplicationContext());
            layout.setOrientation(LinearLayout.VERTICAL);

            /* 페이저 내 웹뷰 생성*/
            webView = new WebView(getApplicationContext());
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);


            /* 웹뷰주소 업로드*/
            webView.loadUrl("https://m.search.naver.com/search.naver?query=%EB%82%A0%EC%94%A8&where=m&sm=mtp_hty");
            //webView.loadUrl(urls[position]);

            /*레이아웃에 웹뷰를 뷰로 추가*/
            layout.addView(webView);
            /*컨테이너에 뷰를 레이아웃으로 추가*/
            container.addView(layout);

            return layout;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

    }//Weather Class



/*
    class MyAdapter extends PagerAdapter {
        String[] names = {"사과","딸기","바나나","복숭아"};

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LinearLayout layout = new LinearLayout(getApplicationContext());
            layout.setOrientation(LinearLayout.VERTICAL);

            TextView view = new TextView(getApplicationContext());
            view.setText(names[position]);
            view.setTextSize(40.0f);


            layout.addView(view);

            container.addView(layout);

            return layout;
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(0);
        }
    }*/


}//Main Class

























