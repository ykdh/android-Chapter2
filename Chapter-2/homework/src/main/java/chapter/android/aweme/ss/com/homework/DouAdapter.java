package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class DouAdapter extends RecyclerView.Adapter<DouAdapter.NumberViewHolder> {

    private static final String TAG = "DouAdapter";
    private Context context;
    private List<Message>messages;

    public DouAdapter(Context context,List<Message> messages){
        this.context=context;
        this.messages=messages;
    }


    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final NumberViewHolder numberViewHolder, int position) {

        final Message message=messages.get(position);

        numberViewHolder.title.setText(message.getTitle());
        numberViewHolder.time.setText(message.getTime());
        numberViewHolder.description.setText(message.getDescription());
        if(message.isOfficial()){
            numberViewHolder.official.setVisibility(View.VISIBLE);
        }else {
            numberViewHolder.official.setVisibility(View.INVISIBLE);
        }
        switch(message.getIcon()){
            case "TYPE_ROBOT":
                numberViewHolder.avatar.setImageResource(R.drawable.session_robot);
                break;
            case "TYPE_GAME":
                numberViewHolder.avatar.setImageResource(R.drawable.icon_micro_game_comment);
                break;
            case "TYPE_SYSTEM":
                numberViewHolder.avatar.setImageResource(R.drawable.session_system_notice);
                break;
            case "TYPE_STRANGER":
                numberViewHolder.avatar.setImageResource(R.drawable.session_stranger);
                break;
            case "TYPE_USER":
                numberViewHolder.avatar.setImageResource(R.drawable.icon_girl);
                break;
            default:
                break;
        }

        numberViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //是第几个item
                int itemPosition=numberViewHolder.getAdapterPosition();

                //传递数据
                Intent intent=new Intent();
                intent=new Intent(context,ChatActivity.class);
                intent.putExtra("extra_data",String.valueOf(itemPosition+1));
                intent.putExtra("extra_data1",message.getTitle());

                //打开新界面
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder  {

        private final TextView title;
        private final TextView description;
        private final TextView time;
        private final ImageView avatar;
        private final ImageView official;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.tv_title);
            description=(TextView)itemView.findViewById(R.id.tv_description);
            time=(TextView)itemView.findViewById(R.id.tv_time);
            official=(ImageView)itemView.findViewById(R.id.robot_notice);
            avatar=(CircleImageView)itemView.findViewById(R.id.iv_avatar);
        }
    }
}
