package kangxiaoling.bwie.com.fangjingdong.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder>{
    private Context context;
    private SYBean.DataBean data;
    private final List<SYBean.DataBean.FenleiBean> class_feilei;
    private OnItemClickListener onItemClickListener;

    public ClassAdapter(Context context, SYBean.DataBean data) {
        this.context = context;
        this.data = data;
        class_feilei = data.getFenlei();
    }

    @Override
    public ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.class_feilei_layout, parent, false);
        return new ClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClassViewHolder holder, final int position) {
           holder.fei_text.setText(class_feilei.get(position).getName());
        Uri uri = Uri.parse(class_feilei.get(position).getIcon());
         holder.fei_img.setImageURI(uri);
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
        return class_feilei.size();
    }

    public class ClassViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView fei_img;
        private TextView fei_text;

        public ClassViewHolder(View itemView) {
            super(itemView);
            fei_img = (SimpleDraweeView) itemView.findViewById(R.id.fei_img);
            fei_text = (TextView) itemView.findViewById(R.id.fei_text);
        }
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
