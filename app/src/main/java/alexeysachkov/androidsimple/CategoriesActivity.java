package alexeysachkov.androidsimple;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class CategoriesActivity extends AppCompatActivity {

    Cursor categoriesCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ListView listView = (ListView) findViewById(R.id.categories_list_view);
        categoriesCursor = getContentResolver().query(CategoriesContentProvider.CATEGORIES_URI, null, null, null, null);

        String[] from = { Category.CATEGORY_NAME_COLUMN };
        int[] to = { R.id.category_name };
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_item_category, categoriesCursor, from, to);

        listView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        categoriesCursor.close();
    }

    public void fab_addCategory_Click(View view) {
        //@todo: create intent for adding categories and open it here
    }
}
