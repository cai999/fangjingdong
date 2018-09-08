package kangxiaoling.bwie.com.fangjingdong.presenter;



import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.Subject;
import kangxiaoling.bwie.com.fangjingdong.contract.user.SYContract;
import kangxiaoling.bwie.com.fangjingdong.entity.user.SYBean;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/04
 * Description:
 */
public class SYPresenter extends SYContract.SYPresenter {
    @Override
    public void slect() {
        mModel.slect().subscribe(new Consumer<SYBean>() {
            @Override
            public void accept(SYBean syBean) throws Exception {
                mView.success(syBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mView.fail("网络有问题，请稍后再试");
            }
        });
    }
}
