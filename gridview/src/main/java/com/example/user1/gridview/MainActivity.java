package com.example.user1.gridview;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView)findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }
    public class MyGridAdapter extends BaseAdapter {
        Context context;
        Integer[] posterID = {R.drawable.mov1,R.drawable.mov2,R.drawable.mov3,R.drawable.mov4,R.drawable.mov5,R.drawable.mov6,
                R.drawable.mov7,R.drawable.mov8,R.drawable.mov9,R.drawable.mov10,R.drawable.mov1,R.drawable.mov2,R.drawable.mov3,R.drawable.mov4,R.drawable.mov5,R.drawable.mov6,
                R.drawable.mov7,R.drawable.mov8,R.drawable.mov9,R.drawable.mov10,R.drawable.mov1,R.drawable.mov2,R.drawable.mov3,R.drawable.mov4,R.drawable.mov5,R.drawable.mov6,
                R.drawable.mov7,R.drawable.mov8,R.drawable.mov9,R.drawable.mov10,R.drawable.mov1,R.drawable.mov2,R.drawable.mov3,R.drawable.mov4,R.drawable.mov5,R.drawable.mov6,
                R.drawable.mov7,R.drawable.mov8,R.drawable.mov9,R.drawable.mov10};
        String [] posterName = {"신세계","해리포터와 불의 잔","스타트랙","호빗","혼스","화차","친절한 금자씨","짝패","타짜","월드 오브 워크래프트"
        ,"신세계","해리포터와 불의 잔","스타트랙","호빗","혼스","화차","친절한 금자씨","짝패","타짜","월드 오브 워크래프트","신세계"
                ,"해리포터와 불의 잔","스타트랙","호빗","혼스","화차","친절한 금자씨","짝패","타짜","월드 오브 워크래프트","신세계"
                ,"해리포터와 불의 잔","스타트랙","호빗","혼스","화차","친절한 금자씨","짝패","타짜","월드 오브 워크래프트"};
        public MyGridAdapter (Context c) {
            context = c;
        }
        public int getCount(){
            return posterID.length;
        }
        public Object getItem(int arg0) {
            return null;
        }
        public long getItemId(int arg0) {
            return 0;
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.dialog, null);;
            convertView.setLayoutParams(new GridView.LayoutParams(200, 300));
            ImageView ivPoster = (ImageView) convertView.findViewById(R.id.ivPoster);
            ivPoster.setImageResource(posterID[position]);
            TextView tvPoster = (TextView) convertView.findViewById(R.id.tvPoster);
            tvPoster.setText(posterName[position]);
            convertView.setPadding(5, 5, 5, 5);

            final int pos = position;
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    TextView tvPoster = (TextView) dialogView.findViewById(R.id.tvPoster);
                    tvPoster.setText(posterName[pos]);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(posterName[pos]);
                    dlg.setIcon(R.drawable.ic_media_video_poster);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });
            return convertView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
