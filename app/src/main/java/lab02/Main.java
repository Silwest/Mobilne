package lab02;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication2.app.R;

import lab02.database.AddTask;
import lab02.database.Tasks;
import lab02.database.taskSQL;

/**
 * Created by Silwest on 4/9/2014.
 */
public class Main extends ListActivity {

    private taskSQL database_handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database_handler = new taskSQL(this);

        setListAdapter(new ListAdapter(this, database_handler.getEntries()));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Tasks entry = (Tasks)getListAdapter().getItem(position);

        database_handler.deleteEntry(entry.getID());

        setListAdapter(new ListAdapter(this, database_handler.getEntries()));

        Toast.makeText(getApplicationContext(), "Zadanie zostło usunięte", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, AddTask.class);
        startActivity(intent);
        this.finish();
        database_handler.closeDataBase();

        return super.onOptionsItemSelected(item);
    }
}
