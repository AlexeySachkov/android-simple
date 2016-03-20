package alexeysachkov.androidsimple;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getContentResolver();
    }

    public void goto_habr_handler(View view) {
        Intent goto_habr_Intent = new Intent();
        goto_habr_Intent.setAction(Intent.ACTION_VIEW);
        goto_habr_Intent.setData(Uri.parse("https://habrahabr.ru"));

        startActivity(goto_habr_Intent);
    }

    public void launch_todolist_handler(View view) {

    }
}
