package com.pizzabakerz.juzbot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Message extends RecyclerView.Adapter<Message.Loader> {

    ArrayList<String> messageText;
    Context context;

    public Message(Context context, ArrayList<String> messageText) {
        this.context = context;
        this.messageText = messageText;
    }

    @Override
    public Loader onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        if (messageText.size()%2==0){
        //inflating element
             v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_message, parent, false);
        }else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_messgae, parent, false);
        }



        // set the view's size, margins, paddings and layout parameters
        Loader vh = new Loader(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(Loader holder, final int position) {

        if(messageText.size()%2==0){
            // set the data in items
            holder.usermsg.setText(messageText.get(position));
        }else {
            holder.botmsg.setText(messageText.get(position));
        }

        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, messageText.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return messageText.size();
    }

    public class Loader extends RecyclerView.ViewHolder {
        TextView usermsg,botmsg;

        public Loader(View itemView) {
            super(itemView);

            botmsg = (TextView)itemView.findViewById(R.id.bot_message_body);
            // get the reference of item view's
            usermsg = (TextView) itemView.findViewById(R.id.message_body);

        }
    }
}
