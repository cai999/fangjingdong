package kangxiaoling.bwie.com.fangjingdong.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import kangxiaoling.bwie.com.fangjingdong.R;
import kangxiaoling.bwie.com.fangjingdong.entity.user.SYBean;

/**
 * Created by ll on 2018/9/7.
 */

class MiaoAdapter extends RecyclerView.Adapter<MiaoAdapter.MiaoViewHolder>{
    private Context context;
    private SYBean.DataBean data;
    private final List<SYBean.DataBean.MiaoshaBean.ListBean> list;

    public MiaoAdapter(Context context, SYBean.DataBean data) {
        this.context = context;
        this.data = data;
        list = data.getMiaosha().getList();
    }

    @Override
    public MiaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.miao_layout, parent, false);
        return new MiaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MiaoViewHolder holder, int position) {
        holder.miao_text.setText(list.get(position).getTitle());
        Uri uri = Uri.parse(list.get(position).getImages().split("\\|")[0]);
        holder.miao_img.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MiaoViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView miao_img;
        private TextView miao_text;

        public MiaoViewHolder(View itemView) {
            super(itemView);
            miao_img = (SimpleDraweeView) itemView.findViewById(R.id.miao_img);
           miao_text = (TextView) itemView.findViewById(R.id.miao_text);
        }
    }
}
