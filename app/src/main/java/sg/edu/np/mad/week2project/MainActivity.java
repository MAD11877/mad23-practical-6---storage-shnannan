package sg.edu.np.mad.week2project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String title = "Main Activity"; // show that this is Main Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(title, "Create!");

        // find username & desc and throw over to activity_main text views
        TextView UserName= findViewById(R.id.txtName);
        TextView UserDesc = findViewById(R.id.txtDescription);
        Intent intent= getIntent();
        User user = (User) intent.getSerializableExtra("selected_user");
        // create a new db handler to reference
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        if (user != null) {
            UserName.setText(user.getName());
            UserDesc.setText(user.getDescription());
            Log.v("User ID", String.valueOf(user.getId()));

            Button follow = findViewById(R.id.followBtn);
            if(!user.followed){
                follow.setText("Follow");
            }
            else{
                follow.setText("Unfollow");
            }
            follow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!user.followed){
                        // show toast message and update user in db handler
                        follow.setText("Unfollow");
                        user.setFollowed(true);
                        dbHandler.updateUser(user);
                        Toast.makeText(MainActivity.this, "User followed", Toast.LENGTH_SHORT).show();
                    } else {
                        // show toast message and update user in db handler
                        user.setFollowed(false);
                        follow.setText("Follow");
                        dbHandler.updateUser(user);
                        Toast.makeText(MainActivity.this, "User unfollowed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}