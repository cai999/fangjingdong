package kangxiaoling.bwie.com.fangjingdong.api;

import io.reactivex.Observable;
import kangxiaoling.bwie.com.fangjingdong.entity.user.SYBean;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * Created by ll on 2018/9/5.
 */

public interface SYApi {
    @GET("home/getHome")
    Observable<SYBean> shouye();
}
