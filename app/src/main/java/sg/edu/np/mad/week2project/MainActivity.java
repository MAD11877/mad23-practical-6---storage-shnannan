package sg.edu.np.mad.week2project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String title = "Main Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(title, "Create!");

        TextView UserID= findViewById(R.id.txtName);
        Intent intent= getIntent();
        User user = (User) intent.getSerializableExtra("selected_user");
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        if (user != null) {
            UserID.setText("Name" + user.getName());
            Log.v("User ID", String.valueOf(user.getId()));
            Button follow = findViewById(R.id.followBtn);
            if(user.followed == false){
                follow.setText("Follow");
            }
            else{
                follow.setText("Unfollow");
            }
            follow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(user.followed == false){
                        follow.setText("UnFollow");
                        user.followed=true;
                        dbHandler.updateUser(user);
                    }
                    else
                    {
                        user.followed=false;
                        follow.setText("Follow");
                        dbHandler.updateUser(user);
                    }
                }
            });
        }

    }
}