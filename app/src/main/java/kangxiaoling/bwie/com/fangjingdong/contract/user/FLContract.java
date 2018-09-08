package kangxiaoling.bwie.com.fangjingdong.contract.user;


import io.reactivex.Observable;
import kangxiaoling.bwie.com.fangjingdong.entity.user.FLBean;
import kangxiaoling.bwie.com.fangjingdong.entity.user.SYBean;
import kangxiaoling.bwie.com.fangjingdong.model.FLModel;
import lianxibase1.bwie.com.base.base.mvp.BasePresenter;
import lianxibase1.bwie.com.base.base.mvp.IBaseModel;
import lianxibase1.bwie.com.base.base.mvp.IBaseView;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/04
 * Description:
 */
public interface FLContract {
     abstract class FLPresenter extends BasePresenter<FLModel,FLView> {
         public abstract void fenlei();

         @Override
         public FLModel getmModel() {
             return new kangxiaoling.bwie.com.fangjingdong.model.FLModel();
         }
     }

    /**
     * model层接口
     */
    interface FLModel extends IBaseModel {
        Observable<FLBean> feilei();
    }

    /**
     * view层接口
     */
    interface FLView extends IBaseView {
        void success(FLBean flBean);
        void fail(String msg);
    }
}
