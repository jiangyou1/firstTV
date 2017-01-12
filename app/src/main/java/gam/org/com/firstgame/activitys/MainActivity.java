package gam.org.com.firstgame.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import gam.org.com.firstgame.R;
import gam.org.com.firstgame.control.BorderView;


public class MainActivity extends Activity implements View.OnClickListener {

    private LinearLayout main;
    private BorderView border;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BorderView border = new BorderView(this);
        border.setBackgroundResource(R.drawable.border_highlight);

        main = (LinearLayout) findViewById(R.id.main);
        border.attachTo(main);

        for (int i = 0; i < main.getChildCount(); i++) {
            main.getChildAt(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        if (v == main.getChildAt(0)) {
            Intent snakeIntent = new Intent(this, SnakeActivity.class);
            startActivity(snakeIntent);
        } else if (v == main.getChildAt(1)) {
            Intent connectIntent = new Intent(this, ConnectActivity.class);
            startActivity(connectIntent);
        } else if (v == main.getChildAt(2)) {
            Intent meIntent = new Intent(this, SnakeActivity.class);
            startActivity(meIntent);
        } else if (v == main.getChildAt(3)) {
            Intent helpIntent = new Intent(this, SnakeActivity.class);
            startActivity(helpIntent);
        }
    }
}
