package com.example.scrolldemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.icu.text.DisplayContext;
import android.os.Build;
import android.text.Layout;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class SquareUiActivity {
    public final int SELECT_EMPLOYMENT = 1;
    public final int SELECT_VOLUNTEER = 2;
    public final int SELECT_NURSING_HOME = 3;
    private LinearLayout showzone;
    private AppCompatActivity parentactivity;
    private ScrollView sqsv;
    private String[] em_c = new String[]{"阿里","腾讯","网易"};
    private String[] em_p = new String[]{"程序员","文员","人力"};
    private ArrayList<info_detail> info_cache;
    public SquareUiActivity(AppCompatActivity ac) {

        parentactivity = ac;
        sqsv = ac.findViewById(R.id.scroll_info);
        info_cache = new ArrayList<info_detail>();
        for(int i = 0;i < em_c.length;++i)
            info_cache.add(new info_detail(em_c[i],em_p[i]));
        init_SquareUi();
    }


    protected void init_SquareUi(){
        sqsv.removeAllViews();
    }
    protected void showSquareUi(){
        sqsv.addView(buildViewList());
    }

    protected LinearLayout buildViewList(){
        showzone = new LinearLayout(parentactivity);
        showzone.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
        showzone.setOrientation(LinearLayout.VERTICAL);
        showzone.setBackgroundColor(Color.LTGRAY);
        showzone.setPadding(2,2,2,2);

        for(int i = 0;i < info_cache.size();++i){
            LinearLayout tl = buildOne(info_cache.get(i));
            showzone.addView(tl);
        }
//        showzone.addView(buildOne());
        TextView ltv = new TextView(parentactivity);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER|Gravity.BOTTOM;
        ltv.setLayoutParams(lp);

        ltv.setGravity(Gravity.CENTER);
        ltv.setText(R.string.scrollbottom_text);
        showzone.addView(ltv);

        return showzone;
    }
    protected LinearLayout buildOne(info_detail in){
//  info_detail in
        LinearLayout ll = new LinearLayout(parentactivity);
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,250);
        ll.setLayoutParams(llp);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setPadding(2,2,2,2);
        ll.setBackgroundColor(Color.WHITE);

        LinearLayout line1 = new LinearLayout(parentactivity);
        LinearLayout line2 = new LinearLayout(parentactivity);
        line1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,3));
        line2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,2));
        line1.setOrientation(LinearLayout.HORIZONTAL);
        line2.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams tvlp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT,1);
        tvlp.gravity = Gravity.CENTER;
        TextView tv1 = new TextView(parentactivity);
        tv1.setLayoutParams(tvlp);
        tv1.setText(in.getPofession());
        tv1.setTextColor(Color.RED);
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextSize(24);

        TextView tv2 = new TextView(parentactivity);
        tv2.setLayoutParams(tvlp);
        tv2.setText(in.getMoney());
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextSize(24);

        TextView tv3 = new TextView(parentactivity);
        tv3.setLayoutParams(tvlp);
        tv3.setText(in.getCompany());
        tv3.setGravity(Gravity.CENTER);
        tv3.setTextSize(16);

        TextView tv4 = new TextView(parentactivity);
        tv4.setLayoutParams(tvlp);
        tv4.setText(in.getInfo());
        tv4.setGravity(Gravity.CENTER);
        tv4.setTextSize(16);

        line1.addView(tv1);
        line1.addView(tv2);
        line2.addView(tv3);
        line2.addView(tv4);

        ll.addView(line1);
        ll.addView(line2);
        return ll;
    }

}
class info_detail{
    protected String e_c;
    protected String e_p;
    protected String e_i;
    protected String e_m;
    public info_detail(String c,String p){
        e_c = c;
        e_p = p;
        e_i = c + "招" + p;
        e_m = "月薪 10k-15k";
    }
    public String getCompany(){
        return e_c;
    }
    public String getPofession(){
        return e_p;
    }
    public String getInfo(){
        return e_i;
    }
    public String getMoney(){
        return e_m;
    }
}