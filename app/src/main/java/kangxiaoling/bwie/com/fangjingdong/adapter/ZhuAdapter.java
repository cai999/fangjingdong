package kangxiaoling.bwie.com.fangjingdong.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import kangxiaoling.bwie.com.fangjingdong.R;
import kangxiaoling.bwie.com.fangjingdong.entity.user.FLBean;

/**
 * Created by ll on 2018/9/7.
 */

public class ZhuAdapter extends RecyclerView.Adapter<ZhuAdapter.ZhuViewHolder> {
    private Context context;
    private List<FLBean.DataBean> data;
    private OnItemClickListener onItemClickListener;

    public ZhuAdapter(Context context, List<FLBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ZhuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.zhu_layout, parent, false);
        return new ZhuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ZhuViewHolder holder, final int position) {
        holder.zhu_name.setText(data.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null){
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ZhuViewHolder extends RecyclerView.ViewHolder {
        private TextView zhu_name;
        public ZhuViewHolder(View itemView) {
            super(itemView);
            zhu_name = (TextView) itemView.findViewById(R.id.zhu_name);
        }
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
