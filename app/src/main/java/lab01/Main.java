package lab01;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication2.app.R;

/**
 * Created by Silwest on 4/8/2014.
 */
public class Main extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab01);
        Button lab01_button_info = (Button)findViewById(R.id.lab01_button_info);
        lab01_button_info.setOnClickListener(this);
        Button lab01_button_new_game = (Button)findViewById(R.id.lab01_button_new_game);
        lab01_button_new_game.setOnClickListener(this);
        Button lab01_button_finish = (Button)findViewById(R.id.lab01_button_exit);
        lab01_button_finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.lab01_button_info:
                intent = new Intent(this, info.class);
                startActivity(intent);
                break;
            case R.id.lab01_button_new_game:
                openDialogNewGame();
                break;
            case R.id.lab01_button_exit:
                finish();
                break;
        }
    }

    private void openDialogNewGame() {
        new AlertDialog.Builder(this).setTitle(R.string.new_game_title).setItems(R.array.level,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startGame(i);
                    }
                }
                ).show();
    }

    private void startGame(int i) {
        Toast.makeText(this, "Uruchomiłes grę z opcja: "+ Integer.toString(i), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater wypelniacz = getMenuInflater();
        wypelniacz.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case R.id.action_settings:
                startActivity(new Intent(this, Preferencje.class));
                return true;
        }
        return false;
    }
}
