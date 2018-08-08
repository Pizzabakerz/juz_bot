package com.pizzabakerz.juzbot;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandActivity extends AppCompatActivity {
    RecyclerView messageview;
    ImageButton send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);
        //hiding action bar......
        getSupportActionBar().hide();

        send = findViewById(R.id.sendbutton);
        messageview =  findViewById(R.id.messageview);

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        messageview.setLayoutManager(llm);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting user text
                EditText userquery = (EditText)findViewById(R.id.userquery);

                //making mesage as array
                ArrayList<String> messages = new ArrayList<String>();
                messages.add(userquery.getText().toString());

                //creating constructor for message class and passing message as array
                Message message =  new Message(getApplicationContext(),messages);
                messageview.setAdapter(message);

                userquery.setText("");
            }
        });

    }
}

