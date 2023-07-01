package sg.edu.np.mad.week2project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class UserViewHolder extends RecyclerView.ViewHolder{
    TextView txt;
    TextView description;
    ImageView img;

    ArrayList<User> userData;

    public UserViewHolder(View itemView, ArrayList<User> user_list, int viewType) {
        super(itemView);
        this.userData = user_list;
        txt = itemView.findViewById(R.id.textView5);
        description = itemView.findViewById(R.id.textView6);
        img = itemView.findViewById(R.id.imageView2);

        // Set additional properties for the special layout
        if (viewType == 1) {
            ImageView specialImageView = itemView.findViewById(R.id.imageView);
            // Set properties for the special ImageView
            // (occupy width of the screen, 1:1 width-to-height ratio, etc.)
            specialImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialog(userData);
                }
            });
        }

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog(userData);
            }
        });

    }
    private void showAlertDialog(ArrayList<User> user_list) {
        AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
        User selectedUser = user_list.get(getAdapterPosition());
        builder.setTitle("Profile");
        builder.setMessage("Name: " + selectedUser.getName());
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    User selectedUser = userData.get(getAdapterPosition());
                    Intent profileIntent = new Intent(itemView.getContext(), MainActivity.class);
                    profileIntent.putExtra("selected_user", selectedUser);
                    itemView.getContext().startActivity(profileIntent);
                }
            }
        });
        builder.setNegativeButton("Close", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
