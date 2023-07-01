package sg.edu.np.mad.week2project;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> userData;

    public UserAdapter (Context context, ArrayList<User> input){
        userData = input;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;

        if(viewType == 7) {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.recycler_view_item2,
                    parent,
                    false
            );
        } else {
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.recycler_view_item,
                    parent,
                    false
            );
        }
        return new UserViewHolder(item);
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.parseInt(userData.get(position).name.substring(userData.get(position).name.length()-1));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, @SuppressLint("RecyclerView") int position) {
        User user = userData.get(position);
        holder.txt.setText(user.name);
        holder.desc.setText(user.description);


        holder.image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("Debug", "Image clicked");

                new AlertDialog.Builder(holder.image.getContext())
                        .setTitle("Profile")
                        .setMessage(user.name)
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent viewProfile = new Intent(holder.image.getContext(), MainActivity.class);
                                viewProfile.putExtra("id", position);
                                holder.image.getContext().startActivity(viewProfile);
                            }
                        })
                        .setNegativeButton("Close", null)
                        .show();
            }
        });
    }


    public int getItemCount(){
        return userData.size();
    }
}
