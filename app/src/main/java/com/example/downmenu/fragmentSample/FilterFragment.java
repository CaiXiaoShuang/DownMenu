package com.example.downmenu.fragmentSample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.caixiaoshuangmenu.DropDownMenu;
import com.example.caixiaoshuangmenu.interfaces.OnFilterDoneListener;
import com.example.downmenu.DropMenuAdapter;
import com.example.downmenu.R;
import com.example.downmenu.entity.FilterUrl;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FilterFragment extends Fragment implements OnFilterDoneListener {

    @BindView(R.id.dropDownMenu)
    DropDownMenu dropDownMenu;
    @BindView(R.id.mFilterContentView)
    TextView mFilterContentView;

    @Nullable
    @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFilterDropDownView();
    }

    private void initFilterDropDownView() {
        String[] titleList = new String[] { "第一个", "第二个", "第三个", "第四个" };
        dropDownMenu.setMenuAdapter(new DropMenuAdapter(getContext(), titleList, this));
    }

    @Override public void onFilterDone(int position, String positionTitle, String urlValue) {
        if (position != 3) {
            dropDownMenu.setPositionIndicatorText(FilterUrl.instance().position, FilterUrl.instance().positionTitle);
        }

        dropDownMenu.close();
        mFilterContentView.setText(FilterUrl.instance()
                                           .toString());
    }

    @Override public void onDestroy() {
        super.onDestroy();
        FilterUrl.instance()
                .clear();
    }
}
