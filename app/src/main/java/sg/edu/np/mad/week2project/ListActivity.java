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
    final String title = "List Activity"; // differentiate Main Activity from List Activity
    static ArrayList<User> userList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(title, "Create!");

        for (int i = 0; i < 20; i++) {
            String randomName = generateRandomName();
            String randomDescription = generateRandomDescription();
            boolean randomFollowed = generateRandomFollowedValue();

            User u = new User(randomName, randomDescription, randomFollowed);
            userList.add(u);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter userAdapter = new UserAdapter(ListActivity.this, userList);
        recyclerView.setAdapter(userAdapter);
    }

    private int randomInteger(){
        Random ran = new Random();
        int myRandomNumber = ran.nextInt();
        return myRandomNumber;
    }

    private String generateRandomName(){
        String name = "Name";
        Integer num = randomInteger();
        return name + num;
    }

    private String generateRandomDescription(){
        String desc = "Description ";
        Integer num = randomInteger();
        return desc + num;
    }

    private boolean generateRandomFollowedValue(){
        Random random = new Random();
        return random.nextBoolean();
    }
}