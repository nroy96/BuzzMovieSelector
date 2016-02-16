package application.buzzmovieselector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import Model.User;
import Model.UserManager;

public class RegisterActivity extends AppCompatActivity {
    public static DatabaseHelper dbHelper;
    private static UserManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_register);
        manager = new UserManager(this);
    }

    public void onClickRegister(View view) {

        EditText n = (EditText) findViewById(R.id.nameText);
        Spinner m = (Spinner) findViewById(R.id.majorSpinner);
        EditText em = (EditText) findViewById(R.id.emailText);
        EditText un = (EditText) findViewById(R.id.usernameText);
        EditText p = (EditText) findViewById(R.id.passwordText);

        String name = n.getText().toString();
        String major = m.getSelectedItem().toString();
        String email = em.getText().toString();
        String userName = un.getText().toString();
        String password = p.getText().toString();
        boolean sucess;

        sucess = manager.addUser(name, password, email, userName,major,false, false);
        CharSequence text = "";

        if (sucess) {
            text = "Registration Sucessful";
            sucess = true;
        } else {
            text = "Failed Try again";
        }

        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        toast.show();
        if(sucess) {
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(this, WelcomeScreen.class);
        startActivity(intent);
    }

    public void onClickClear(View view) {
        EditText n = (EditText) findViewById(R.id.nameText);
        Spinner m = (Spinner) findViewById(R.id.majorSpinner);
        EditText em = (EditText) findViewById(R.id.emailText);
        EditText un = (EditText) findViewById(R.id.usernameText);
        EditText p = (EditText) findViewById(R.id.passwordText);
        n.setText("");
        m.setSelection(0);
        em.setText("");
        un.setText("");
        p.setText("");
    }
}
