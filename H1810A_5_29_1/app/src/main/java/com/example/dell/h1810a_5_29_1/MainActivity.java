package com.example.dell.h1810a_5_29_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dell.h1810a_5_29_1.adapter.MainAdapter;
import com.example.dell.h1810a_5_29_1.bean.GrilBean;
import com.example.dell.h1810a_5_29_1.presenter.Presenter;
import com.example.dell.h1810a_5_29_1.view.IView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView {

    private RecyclerView mRel;
    private ArrayList<GrilBean.ResultsBean> mList;
    private MainAdapter mMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Presenter presenter = new Presenter(this);
        presenter.getIPresenter();
    }

    private void initView() {
        mRel = (RecyclerView) findViewById(R.id.rel);
        mRel.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();
        mMainAdapter = new MainAdapter(this, mList);
        mRel.setAdapter(mMainAdapter);
    }

    @Override
    public void getIViewYes(GrilBean grilBean) {
        List<GrilBean.ResultsBean> results = grilBean.getResults();
        mList.addAll(results);
        mMainAdapter.setList(mList);
        mMainAdapter.notifyDataSetChanged();
    }

    private static final String TAG = "MainActivity";
    @Override
    public void getIViewNo(String string) {
        Log.d(TAG, "getIViewNo: string"+string);
    }
}
