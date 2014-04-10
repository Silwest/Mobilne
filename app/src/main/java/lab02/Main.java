package lab02;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication2.app.R;

import lab01.Preferencje;
import lab02.database.AddTask;
import lab02.database.Tasks;
import lab02.database.taskSQL;

/**
 * Created by Silwest on 4/9/2014.
 */
public class Main extends ListActivity implements View.OnClickListener {

    private taskSQL database_handler;
//    private Button go_to_entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database_handler = new taskSQL(this);

        setListAdapter(new ListAdapter(this, database_handler.getEntries()));

//        go_to_entry = (Button) findViewById(R.id.lab02_go_to_entry);
//        go_to_entry.setOnClickListener(this);

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
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case R.id.action_settings:
                startActivity(new Intent(this, Preferencje.class));
                this.finish();
                return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
//        if(go_to_entry.isPressed()){
//            Intent intent = new Intent(this, lab02.database.AddTask.class);
//            startActivity(intent);
//        }
    }
}
