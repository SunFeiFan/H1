package com.example.dell.h1810a_5_29_1.presenter;

import com.example.dell.h1810a_5_29_1.bean.GrilBean;
import com.example.dell.h1810a_5_29_1.callback.CallBack;
import com.example.dell.h1810a_5_29_1.model.IModel;
import com.example.dell.h1810a_5_29_1.model.Model;
import com.example.dell.h1810a_5_29_1.view.IView;

public class Presenter implements IPresenter{

    IModel mIModel;
    IView mIView;

    public Presenter( IView IView) {
        mIModel = new Model();
        mIView = IView;
    }


    @Override
    public void getIPresenter() {
        mIModel.getIModelData(new CallBack() {
            @Override
            public void getCallBackYes(GrilBean grilBean) {
                mIView.getIViewYes(grilBean);
            }

            @Override
            public void getCallBackNo(String string) {
                mIView.getIViewNo(string);
            }
        });
    }
}
