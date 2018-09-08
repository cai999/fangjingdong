package kangxiaoling.bwie.com.fangjingdong.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import kangxiaoling.bwie.com.fangjingdong.R;
import kangxiaoling.bwie.com.fangjingdong.activiity.Priduct_List_Activity;
import kangxiaoling.bwie.com.fangjingdong.entity.user.FL_item_Bean;

/**
 * Created by ll on 2018/9/7.
 */

class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    private Context context;
    private List<FL_item_Bean.DataBean.ListBean> list;

    public ProductAdapter(Context context, List<FL_item_Bean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_layout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, final int position) {
     holder.product_text.setText(list.get(position).getName());
        Uri uri = Uri.parse(list.get(position).getIcon());
        holder.product_img.setImageURI(uri);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Priduct_List_Activity.class);
                intent.putExtra("pscid",list.get(position).getPscid());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView product_text;
        private SimpleDraweeView product_img;

        public ProductViewHolder(View itemView) {
            super(itemView);
            product_text = (TextView) itemView.findViewById(R.id.product_text);
            product_img = (SimpleDraweeView) itemView.findViewById(R.id.product_img);
        }
    }
}
