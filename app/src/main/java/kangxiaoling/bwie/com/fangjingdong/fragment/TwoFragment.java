package kangxiaoling.bwie.com.fangjingdong.fragment;

import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import kangxiaoling.bwie.com.fangjingdong.R;
import kangxiaoling.bwie.com.fangjingdong.adapter.FL_item_Adapter;
import kangxiaoling.bwie.com.fangjingdong.adapter.ZhuAdapter;
import kangxiaoling.bwie.com.fangjingdong.common.Contants;
import kangxiaoling.bwie.com.fangjingdong.contract.user.FLContract;
import kangxiaoling.bwie.com.fangjingdong.entity.user.FLBean;
import kangxiaoling.bwie.com.fangjingdong.entity.user.FL_item_Bean;
import kangxiaoling.bwie.com.fangjingdong.presenter.FLPresenter;
import kangxiaoling.bwie.com.fangjingdong.utils.OkHttpUtils;
import kangxiaoling.bwie.com.fangjingdong.utils.RequestCollBack;
import lianxibase1.bwie.com.base.base.mvp.BaseMvpFragment;
import lianxibase1.bwie.com.base.base.mvp.BasePresenter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TwoFragment extends BaseMvpFragment<FLContract.FLModel,FLContract.FLPresenter> implements FLContract.FLView{
    @BindView(R.id.zhu_rev)
    RecyclerView zhu_rev;
    @BindView(R.id.zi_rev)
    RecyclerView zi_rev;
    @BindView(R.id.zi_text)
    TextView zi_text;
    private int id = 1;
    private Handler handler = new Handler();
    @Override
    protected void initData() {
        super.initData();
        zhu_rev.setLayoutManager(new LinearLayoutManager(getActivity()));
        zi_rev.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.fenlei();
        initItem();
    }

    private void initItem() {
        HashMap<String,String> prams = new HashMap<>();
        prams.put("cid",id+"");

        OkHttpUtils.getInstance().postData(Contants.BASE_RELEASE_URL+"product/getProductCatagory", prams, new RequestCollBack() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
             if(200==response.code()){
                 String string = response.body().string();
                 Log.i("dddd",string);
                 preaJson(string);
             }
            }
        });
    }

    private void preaJson(String string) {
        Gson gson = new Gson();
        FL_item_Bean fl_item_bean = gson.fromJson(string, FL_item_Bean.class);
        final List<FL_item_Bean.DataBean> data = fl_item_bean.getData();
        handler.post(new Runnable() {
            @Override
            public void run() {
                FL_item_Adapter fl_item_adapter = new FL_item_Adapter(getActivity(), data);
                zi_rev.setAdapter(fl_item_adapter);
            }
        });
    }

    @Override
    public BasePresenter initPresenter() {
        return new FLPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
    @Override
    public void success(final FLBean flBean) {

        ZhuAdapter zhuAdapter = new ZhuAdapter(getActivity(), flBean.getData());
        zhu_rev.setAdapter(zhuAdapter);
        zhuAdapter.setOnItemClickListener(new ZhuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
               id=flBean.getData().get(position).getCid();
                zi_text.setText(flBean.getData().get(position).getName());
                initItem();
            }
        });
    }

    @Override
    public void fail(String msg) {
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.twofragment_layout;
    }
}
