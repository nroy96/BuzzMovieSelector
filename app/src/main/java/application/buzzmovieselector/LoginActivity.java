package application.buzzmovieselector;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import Model.UserManager;

public class LoginActivity extends AppCompatActivity {

    private static UserManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        manager = new UserManager(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        //how are you?
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickLogin(View view) {

        EditText name = (EditText) findViewById(R.id.nameText);
        EditText pass = (EditText) findViewById(R.id.passwordText);
        String userName = String.valueOf(name.getText());
        String passwordEntered = String.valueOf(pass.getText());
        boolean login = manager.handleLoginRequest(userName, passwordEntered);
        CharSequence text;

        if(login) {
            text = "Loging Sucessful";
            Intent intent = new Intent(this, UserProfileActivity.class);
            intent.putExtra("username", userName);
            startActivity(intent);
        } else {
            text = "Username and Password did not match";
        }
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void onClickRegister(View view) {

    }

   public void onClickBack(View view) {
       Intent intent = new Intent(this, WelcomeScreen.class);
       startActivity(intent);
   }
}
