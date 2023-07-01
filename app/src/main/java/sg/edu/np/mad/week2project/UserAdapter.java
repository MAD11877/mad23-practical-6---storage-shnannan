package sg.edu.np.mad.week2project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    ArrayList<User> userData;
    public UserAdapter(ArrayList<User> input){
        this.userData = input;
    }

    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item;
        if (viewType == 1) {
            item = inflater.inflate(R.layout.recycler_view_item2, parent, false);
        } else {
            item = inflater.inflate(R.layout.recycler_view_item, parent, false);
        }
        return new UserViewHolder(item, userData, viewType);
    }



    public void onBindViewHolder(UserViewHolder Holder, int position){
        User user_details = userData.get(position);
        Holder.txt.setText(user_details.getName());
        Holder.description.setText(user_details.getDescription());

    }
    public int getItemCount(){
        return userData.size();
    }
    @Override
    public int getItemViewType(int position) {
        String name = userData.get(position).getName();
        // Get the last digit of the name
        int lastDigit = Integer.parseInt(name.substring(name.length() - 1));

        // Check if the last digit is 7
        if (lastDigit == 7) {
            return 1; // Unique view type for names ending in 7
        } else {
            return 0; // Default view type for other names
        }
    }
}
