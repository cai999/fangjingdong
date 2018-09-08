package kangxiaoling.bwie.com.fangjingdong.contract.user;


import io.reactivex.Observable;
import kangxiaoling.bwie.com.fangjingdong.entity.user.CartBean;
import kangxiaoling.bwie.com.fangjingdong.entity.user.FLBean;
import lianxibase1.bwie.com.base.base.mvp.BasePresenter;
import lianxibase1.bwie.com.base.base.mvp.IBaseModel;
import lianxibase1.bwie.com.base.base.mvp.IBaseView;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/04
 * Description:
 */
public interface CartContract {
     abstract class CartPresenter extends BasePresenter<CartModel,CartView> {
         public abstract void cart();

         @Override
         public CartModel getmModel() {
             return new kangxiaoling.bwie.com.fangjingdong.model.CartModel();
         }
     }

    /**
     * model层接口
     */
    interface CartModel extends IBaseModel {
        Observable<FLBean> feilei();
    }

    /**
     * view层接口
     */
    interface CartView extends IBaseView {
        void success(CartBean cartBean);
        void fail(String msg);
    }
}
