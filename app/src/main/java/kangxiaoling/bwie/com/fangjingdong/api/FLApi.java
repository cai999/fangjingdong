package kangxiaoling.bwie.com.fangjingdong.api;


import io.reactivex.Observable;
import kangxiaoling.bwie.com.fangjingdong.entity.user.FLBean;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ll on 2018/9/7.
 */

public interface FLApi {
    @POST("product/getCatagory")
    Observable<FLBean> feilei();
}
