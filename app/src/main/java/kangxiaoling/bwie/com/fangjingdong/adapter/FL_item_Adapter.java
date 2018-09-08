package kangxiaoling.bwie.com.fangjingdong.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import kangxiaoling.bwie.com.fangjingdong.R;
import kangxiaoling.bwie.com.fangjingdong.entity.user.FL_item_Bean;

/**
 * Created by ll on 2018/9/7.
 */

public class FL_item_Adapter extends RecyclerView.Adapter<FL_item_Adapter.FL_item_ViewHolder> {
    private Context context;
    private List<FL_item_Bean.DataBean> data;

    public FL_item_Adapter(Context context, List<FL_item_Bean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public FL_item_Adapter.FL_item_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fl_item_layout, parent, false);
        return new FL_item_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FL_item_Adapter.FL_item_ViewHolder holder, int position) {
       holder.fl_item_text.setText(data.get(position).getName());
        ProductAdapter productAdapter = new ProductAdapter(context, data.get(position).getList());
        holder.fl_item_rev.setAdapter(productAdapter);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class FL_item_ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView fl_item_rev;
        private TextView fl_item_text;

        public FL_item_ViewHolder(View itemView) {
            super(itemView);
            fl_item_rev = (RecyclerView) itemView.findViewById(R.id.fl_item_rev);
            fl_item_text = (TextView) itemView.findViewById(R.id.fl_item_text);
            fl_item_rev.setLayoutManager(new GridLayoutManager(context,3));
        }
    }
}
