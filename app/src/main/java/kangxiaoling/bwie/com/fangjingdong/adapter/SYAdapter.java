package kangxiaoling.bwie.com.fangjingdong.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import kangxiaoling.bwie.com.fangjingdong.R;
import kangxiaoling.bwie.com.fangjingdong.entity.user.SYBean;

/**
 * Created by ll on 2018/9/6.
 */

public class SYAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private SYBean.DataBean data;
    private int one = 0;
    private int two = 1;
    private int tree = 2;
    private int four =3;
    private int  five=4;
    private List<String> list;

    public SYAdapter(Context context, SYBean.DataBean data) {
        this.context = context;
        this.data = data;
        list = new ArrayList<>();
        for (int i = 0; i < data.getBanner().size(); i++) {
            list.add(data.getBanner().get(i).getIcon());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return one;
        } else if (position == 1) {
            return two;
        }else if (position==2){
            return tree;
        }else if (position==3){
            return four;
        }
        return five;
    }

    @Override
    public long getItemId(int position) {
        return 5;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == one) {
            View view = LayoutInflater.from(context).inflate(R.layout.banner_layout, parent, false);
            return new BannerViewHolder(view);
        } else if (viewType == two) {
            View view = LayoutInflater.from(context).inflate(R.layout.calss_layout, parent, false);
            return new ClassHolder(view);
        }else if (viewType == tree){
            View view = LayoutInflater.from(context).inflate(R.layout.paoma_layout, parent, false);
            return new PaoMaViewHolder(view);
        } else if (viewType == four) {
            View view = LayoutInflater.from(context).inflate(R.layout.miaosha_layout, parent, false);
            return new MiaoshaViewHolder(view);
        } else if(viewType==five){
            View view = LayoutInflater.from(context).inflate(R.layout.tuijian_layout, parent, false);
            return new TuijianViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof BannerViewHolder) {
            ((BannerViewHolder) holder).banner.setImages(list)
                    .setImageLoader(new bannerGlide())
                    .start();
        }
        if (holder instanceof ClassHolder) {
            ClassAdapter classAdapter = new ClassAdapter(context, data);
            ((ClassHolder) holder).class_rev.setAdapter(classAdapter);
            classAdapter.setOnItemClickListener(new ClassAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    Toast.makeText(context,"dianjile",Toast.LENGTH_SHORT).show();
                }
            });
        }
        if (holder instanceof MiaoshaViewHolder) {
            ((MiaoshaViewHolder) holder).miao_name.setText(data.getMiaosha().getName());
            MiaoAdapter miaoAdapter = new MiaoAdapter(context, data);
            ((MiaoshaViewHolder) holder).miao_rev.setAdapter(miaoAdapter);
        }
        if (holder instanceof TuijianViewHolder) {
            ((TuijianViewHolder) holder).tui_name.setText(data.getTuijian().getName());
            TuiAdapter tuiAdapter = new TuiAdapter(context, data);
            ((TuijianViewHolder) holder).tui_rev.setAdapter(tuiAdapter);
        }
        if (holder instanceof PaoMaViewHolder){
            List<String> info = new ArrayList<>();
           /* info.add("1. 大家好，我是孙福生。");
            info.add("2. 欢迎大家关注我哦！");
            info.add("3. GitHub帐号：sfsheng0322");
            info.add("4. 新浪微博：孙福生微博");
            info.add("5. 个人博客：sunfusheng.com");
            info.add("6. 微信公众号：孙福生");*/
            for (int i = 0; i < data.getMiaosha().getList().size(); i++) {
                info.add( data.getMiaosha().getList().get(i).getTitle());
            }
            ((PaoMaViewHolder) holder).marqueeView.startWithList(info);
            ((PaoMaViewHolder) holder).marqueeView.startWithList(info, R.anim.anim_bottom_in, R.anim.anim_top_out);
            /*((PaoMaViewHolder) holder).marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
                @Override
                public void onItemClick(int position, TextView textView) {
                    Toast.makeText(context, textView.getText() + "", Toast.LENGTH_SHORT).show();
                }
            });*/
        }
    }
    class bannerGlide extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageView);
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    private class BannerViewHolder extends RecyclerView.ViewHolder {
        private Banner banner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);
        }
    }

    private class ClassHolder extends RecyclerView.ViewHolder {
        private RecyclerView class_rev;

        public ClassHolder(View itemView) {
            super(itemView);
            class_rev = (RecyclerView) itemView.findViewById(R.id.class_rev);
            class_rev.setLayoutManager(new GridLayoutManager(context, 10));
        }
    }

    private class MiaoshaViewHolder extends RecyclerView.ViewHolder {

        private TextView miao_name;
        private RecyclerView miao_rev;

        public MiaoshaViewHolder(View itemView) {
            super(itemView);
            miao_name = (TextView) itemView.findViewById(R.id.miao_name);
            miao_rev = (RecyclerView) itemView.findViewById(R.id.miao_rev);
            miao_rev.setLayoutManager(new GridLayoutManager(context, 2));
        }
    }

    private class TuijianViewHolder extends RecyclerView.ViewHolder {

        private TextView tui_name;
        private RecyclerView tui_rev;

        public TuijianViewHolder(View itemView) {
            super(itemView);
           tui_name = (TextView) itemView.findViewById(R.id.tui_name);
            tui_rev = (RecyclerView) itemView.findViewById(R.id.tui_rev);
            tui_rev.setLayoutManager(new GridLayoutManager(context, 2));
        }
    }

    private class PaoMaViewHolder extends RecyclerView.ViewHolder {

        private MarqueeView marqueeView;

        public PaoMaViewHolder(View itemView) {
            super(itemView);
            marqueeView = (MarqueeView) itemView.findViewById(R.id.marqueeView);
        }
    }

}
