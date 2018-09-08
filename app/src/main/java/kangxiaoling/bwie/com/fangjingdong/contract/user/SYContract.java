package kangxiaoling.bwie.com.fangjingdong.contract.user;


import io.reactivex.Observable;
import kangxiaoling.bwie.com.fangjingdong.entity.user.SYBean;
import lianxibase1.bwie.com.base.base.mvp.BasePresenter;
import lianxibase1.bwie.com.base.base.mvp.IBaseModel;
import lianxibase1.bwie.com.base.base.mvp.IBaseView;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/04
 * Description:
 */
public interface SYContract {
     abstract class SYPresenter extends BasePresenter<SYModel,SYView> {
         public abstract void slect();
        @Override
         public SYModel getmModel() {
             return new kangxiaoling.bwie.com.fangjingdong.model.SYModel();
         }
     }

    /**
     * model层接口
     */
    interface SYModel extends IBaseModel {
        Observable<SYBean> slect();
    }

    /**
     * view层接口
     */
    interface SYView extends IBaseView {
        void success(SYBean syBean);
        void fail(String msg);
    }
}
