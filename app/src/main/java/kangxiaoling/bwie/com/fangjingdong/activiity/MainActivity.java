package kangxiaoling.bwie.com.fangjingdong.activiity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kangxiaoling.bwie.com.fangjingdong.R;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.img)
    ImageView img;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,Tab_barActivity.class));
                finish();
            }
        },3000);
    }
}
