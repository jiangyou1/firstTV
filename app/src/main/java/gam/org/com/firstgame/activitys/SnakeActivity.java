package gam.org.com.firstgame.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import gam.org.com.firstgame.R;
import gam.org.com.firstgame.snake.SnakeView;

public class SnakeActivity extends Activity {

    private SnakeView mSnakeView;
    public static final int UP = KeyEvent.KEYCODE_DPAD_UP;
    public static final int LEFT = KeyEvent.KEYCODE_DPAD_LEFT;
    public static final int RIGHT = KeyEvent.KEYCODE_DPAD_RIGHT;
    public static final int DOWN = KeyEvent.KEYCODE_DPAD_DOWN;

    private static String ICICLE_KEY = "snake-view";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake);

        mSnakeView = (SnakeView) findViewById(R.id.snake);
        mSnakeView.setTextView((TextView) findViewById(R.id.text));

        if (savedInstanceState == null) {
            mSnakeView.setMode(SnakeView.READY);
        } else {
            Bundle map = savedInstanceState.getBundle(ICICLE_KEY);
            if (map != null) {
                mSnakeView.restoreState(map);
            } else {
                mSnakeView.setMode(SnakeView.PAUSE);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Pause the game along with the activity
        mSnakeView.setMode(SnakeView.PAUSE);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Store the game state
        outState.putBundle(ICICLE_KEY, mSnakeView.saveState());
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        mSnakeView.onKeyDown(keyCode, event);
//        return super.onKeyDown(keyCode, event);
//    }
}
