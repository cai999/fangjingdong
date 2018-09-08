package kangxiaoling.bwie.com.fangjingdong.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import butterknife.BindView;
import kangxiaoling.bwie.com.fangjingdong.R;
import kangxiaoling.bwie.com.fangjingdong.adapter.SYAdapter;
import kangxiaoling.bwie.com.fangjingdong.contract.user.SYContract;
import kangxiaoling.bwie.com.fangjingdong.entity.user.SYBean;
import kangxiaoling.bwie.com.fangjingdong.presenter.SYPresenter;
import lianxibase1.bwie.com.base.base.mvp.BaseMvpFragment;
import lianxibase1.bwie.com.base.base.mvp.BasePresenter;

public class OneFragment extends BaseMvpFragment<SYContract.SYModel, SYContract.SYPresenter> implements SYContract.SYView {
   @BindView(R.id.shouye_rev)
    XRecyclerView shouye_rev;
    private int page = 1;
    private SYAdapter syAdapter;

    @Override
    protected int bindLayoutId() {
        return R.layout.onefragment_layout;
    }

    @Override
    protected void initData() {
        super.initData();
        shouye_rev.setLayoutManager(new LinearLayoutManager(getActivity()));
        shouye_rev.setLoadingMoreEnabled(true);
       shouye_rev.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                syAdapter.notifyDataSetChanged();
                shouye_rev.refreshComplete();
            }

           @Override
           public void onLoadMore() {
               page+=1;
               syAdapter.notifyDataSetChanged();
               shouye_rev.loadMoreComplete();
           }
       });
        presenter.slect();
    }
    @Override
    public BasePresenter initPresenter() {
        return new SYPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void success(SYBean syBean) {
        syAdapter = new SYAdapter(getActivity(), syBean.getData());
        shouye_rev.setAdapter(syAdapter);
    }

    @Override
    public void fail(String msg) {

    }
}
