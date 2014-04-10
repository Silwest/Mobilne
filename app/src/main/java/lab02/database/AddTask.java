package lab02.database;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication2.app.R;

/**
 * Created by Silwest on 09.04.14.
 */
public class AddTask extends Activity implements View.OnClickListener{
    private EditText entry_text;
    private Button button_add_new;
    private Button button_back;

    private taskSQL database_handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab02_add_entry);

        database_handler = new taskSQL(this);
        entry_text = (EditText) findViewById(R.id.lab02_new_entry_text);
        button_add_new = (Button)findViewById(R.id.lab02_button_add_new);
        button_back = (Button) findViewById(R.id.lab02_button_back);

        button_add_new.setOnClickListener(this);
        button_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if(button_add_new.isPressed()){
            String new_entry_text = entry_text.getText().toString();
            entry_text.setText("");

            database_handler.addEntry(new_entry_text);

            Toast.makeText(getApplicationContext(), "Zdanie dodane!", Toast.LENGTH_SHORT).show();
        }
        else if(button_back.isPressed()){
            Intent intent = new Intent(this, lab02.Main.class);

            startActivity(intent);
            this.finish();
            database_handler.closeDataBase();
        }
    }
}
