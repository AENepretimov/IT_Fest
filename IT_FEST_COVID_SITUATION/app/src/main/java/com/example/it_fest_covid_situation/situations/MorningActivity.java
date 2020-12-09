package com.example.it_fest_covid_situation.situations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.it_fest_covid_situation.timer.ImageTimer;
import com.example.it_fest_covid_situation.R;
import com.example.it_fest_covid_situation.RegisterActivity;
import com.example.it_fest_covid_situation.model.Player;

public class MorningActivity extends AppCompatActivity {

    private Player player;
    private TextView tv_point;
    private AppCompatButton btn_left, btn_right;
    private ImageView iv_player;
    private TextView tv_text;

    private ImageTimer imageTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);

        player = (Player) (getIntent().getSerializableExtra(RegisterActivity.MSG_NAME));

        tv_point = findViewById(R.id.tv_point);
        tv_point.setText("Угроза заражения : " + player.getPoint().toString() + "%");

        iv_player = findViewById(R.id.iv_player);
        tv_text = findViewById(R.id.tv_story);
        String str = String.format(getString(R.string.morning), player.getName());
        if (player.isSex()) {
            imageTimer = new ImageTimer(iv_player, R.drawable.ic_man1, tv_text, str);
        }else{
            imageTimer = new ImageTimer(iv_player, R.drawable.ic_woman1, tv_text, str);
        }

        imageTimer.start();


        btn_left = findViewById(R.id.btn_left);
        btn_right = findViewById(R.id.btn_right);

        btnClick(btn_left, NeighborActivity.class, false);
        btnClick(btn_right, NeighborActivity.class, true);
    }

    public void btnClick(AppCompatButton btn, Class<NeighborActivity> c, boolean isMask){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), c);
                player.setMask(isMask);
                if (view.getId() == R.id.btn_left){
                    player.addPoint(25);
                }
                intent.putExtra(RegisterActivity.MSG_NAME, player);
                startActivity(intent);
                finish();
            }
        });
    }
}