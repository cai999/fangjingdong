package kangxiaoling.bwie.com.fangjingdong.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kangxiaoling.bwie.com.fangjingdong.R;
import lianxibase1.bwie.com.base.base.mvp.BaseMvpFragment;

public class ThreeFragment extends BaseMvpFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.threefragment_layout, null);
        return view;
    }
}
