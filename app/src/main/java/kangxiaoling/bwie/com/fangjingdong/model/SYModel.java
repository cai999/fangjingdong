package kangxiaoling.bwie.com.fangjingdong.model;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kangxiaoling.bwie.com.fangjingdong.api.SYApi;
import kangxiaoling.bwie.com.fangjingdong.common.Contants;
import kangxiaoling.bwie.com.fangjingdong.contract.user.SYContract;
import kangxiaoling.bwie.com.fangjingdong.entity.user.SYBean;
import lianxibase1.bwie.com.base.net.RetrofitUtils;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/04
 * Description:
 */
public class SYModel implements SYContract.SYModel {
    @Override
    public Observable<SYBean> slect() {
        return RetrofitUtils.getInstance().createApi(Contants.BASE_RELEASE_URL, SYApi.class)
                .shouye().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
