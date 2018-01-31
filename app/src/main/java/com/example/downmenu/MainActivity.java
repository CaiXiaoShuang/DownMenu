package com.example.downmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.caixiaoshuangmenu.DropDownMenu;
import com.example.caixiaoshuangmenu.interfaces.OnFilterDoneListener;
import com.example.downmenu.entity.FilterUrl;
import com.example.downmenu.fragmentSample.FilterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnFilterDoneListener, View.OnClickListener {

    @BindView(R.id.dropDownMenu)
    DropDownMenu dropDownMenu;
    @BindView(R.id.mFilterContentView)
    TextView mFilterContentView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFilterDropDownView();

        mFilterContentView.setOnClickListener(this);
    }

    private void initFilterDropDownView() {
        String[] titleList = new String[] { "第一个", "第二个", "第三个", "第四个" };
        dropDownMenu.setMenuAdapter(new DropMenuAdapter(this, titleList, this));
    }

    @Override public void onFilterDone(int position, String positionTitle, String urlValue) {
        if (position != 3) {
            dropDownMenu.setPositionIndicatorText(FilterUrl.instance().position, FilterUrl.instance().positionTitle);
        }

        dropDownMenu.close();
        mFilterContentView.setText(FilterUrl.instance().toString());
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        FilterUrl.instance().clear();
    }

    @Override public void onClick(View view) {
        startActivity(new Intent(this, FilterActivity.class));
    }

}
