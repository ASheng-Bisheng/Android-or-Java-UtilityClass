package cn.whzwl.xbs.utilityclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.whzwl.xbs.utilityclass.adapter.StringAdapter;
import cn.whzwl.xbs.utilityclass.utils.DateUtils;
import cn.whzwl.xbs.utilityclass.utils.MD5;
import cn.whzwl.xbs.utilityclass.utils.ToastUtils;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        List<String> strings = new ArrayList<>();
        strings.add(DateUtils.getTime() + "");
        strings.add(DateUtils.getCurrentDate() + "");
        strings.add(DateUtils.getCurrentYear() + "");
        strings.add(DateUtils.getCurrentMonth() + "");
        strings.add(DateUtils.getCurrentDay() + "");
        strings.add(DateUtils.getCurrentTime() + "");
        strings.add(MD5.MD51(DateUtils.getCurrentDate()));
        StringAdapter stringAdapter = new StringAdapter(strings, R.layout.item_str);
        rv.setAdapter(stringAdapter);
        stringAdapter.setOnItemClickListener(new StringAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Object o) {
                ToastUtils.showShort(o + "");
            }
        });
        stringAdapter.setOnLongClickListener(new StringAdapter.LongClickListener() {
            @Override
            public void onItemLongClick(int position, Object o) {
                ToastUtils.showShort("我长按了" + o);
            }
        });
    }
}
