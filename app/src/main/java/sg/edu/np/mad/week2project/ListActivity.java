package sg.edu.np.mad.week2project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    ArrayList<User> userList = new ArrayList<>();
    final String title = "pre-populated rv";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(title, "Create!");

        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int name = random.nextInt(Integer.MAX_VALUE - 10000000) + 10000000;
            int desc = random.nextInt(Integer.MAX_VALUE - 10000000) + 10000000;
            User user = new User(String.valueOf(name), String.valueOf(desc), i, false);

            dbHandler.addUser(user);
        }

        androidx.recyclerview.widget.RecyclerView recyclerView = findViewById(R.id.recyclerView);
        UserAdapter userAdapter = new UserAdapter(dbHandler.getUsers());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(userAdapter);
    }
}