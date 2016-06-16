package com.example.poojavenkatran.simpletodoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected static final String EXTRA_MESSAGE = "com.example.poojavenkatran.simpletodoapp.MESSAGE";
    ArrayList<String> listItems;
    ArrayAdapter<String> listAdapter;
    ListView lv;
    Button addButton;
    EditText editText;
    int editPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateArrayItems();
        lv = (ListView) findViewById(R.id.lvItems);
        lv.setAdapter(listAdapter);

        editText = (EditText) findViewById(R.id.etEditText);
        addButton = (Button) findViewById(R.id.buttonAddItem);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAdapter.add(editText.getText().toString());
                editText.setText("");
                writeItems();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listItems.remove(position);
                writeItems();
                listAdapter.notifyDataSetChanged();
                return true;
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), EditActivity.class);
                String message = listAdapter.getItem(position);
                intent.putExtra(EXTRA_MESSAGE, message);
                editPosition = position;
                startActivityForResult(intent, 0);
            }
        });

    }

    protected void populateArrayItems(){

        readItems();
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
    }

    private void readItems(){
        File filesDir = getFilesDir();
        File file = new File(filesDir, "todo.txt");
        try {
            listItems = new ArrayList<String>(FileUtils.readLines(file));
        }catch (IOException exception){
            System.out.println("Exception : " + exception.toString());
            exception.printStackTrace();
        }

    }

    protected void writeItems(){
        File filesDir = getFilesDir();
        File file = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(file, listItems);
        }catch (IOException exception){
            System.out.println("Exception : " + exception.toString());
            exception.printStackTrace();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        listItems.set(editPosition, EditActivity.MESSAGE);
        writeItems();
        listAdapter.notifyDataSetChanged();
    }
}
