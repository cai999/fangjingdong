package kangxiaoling.bwie.com.fangjingdong.presenter;



import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kangxiaoling.bwie.com.fangjingdong.contract.user.FLContract;
import kangxiaoling.bwie.com.fangjingdong.contract.user.SYContract;
import kangxiaoling.bwie.com.fangjingdong.entity.user.FLBean;
import kangxiaoling.bwie.com.fangjingdong.entity.user.SYBean;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/04
 * Description:
 */
public class FLPresenter extends FLContract.FLPresenter {

    @Override
    public void fenlei() {
        mModel.feilei().subscribe(new Consumer<FLBean>() {
            @Override
            public void accept(FLBean flBean) throws Exception {
              mView.success(flBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
               mView.fail("请求失败");
            }
        });
    }
}
