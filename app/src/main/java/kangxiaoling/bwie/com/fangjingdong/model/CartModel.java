package kangxiaoling.bwie.com.fangjingdong.model;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kangxiaoling.bwie.com.fangjingdong.api.FLApi;
import kangxiaoling.bwie.com.fangjingdong.common.Contants;
import kangxiaoling.bwie.com.fangjingdong.contract.user.CartContract;
import kangxiaoling.bwie.com.fangjingdong.contract.user.FLContract;
import kangxiaoling.bwie.com.fangjingdong.entity.user.CartBean;
import kangxiaoling.bwie.com.fangjingdong.entity.user.FLBean;
import lianxibase1.bwie.com.base.net.RetrofitUtils;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/04
 * Description:
 */
public class CartModel implements CartContract.CartModel {
    @Override
    public Observable<CartBean> feilei() {
        return RetrofitUtils.getInstance().createApi(Contants.BASE_RELEASE_URL, FLApi.class)
                .feilei().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
