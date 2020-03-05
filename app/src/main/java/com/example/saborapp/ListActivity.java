package com.example.saborapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    String mTitle[] = {"Android", "iPhone", "Windows", "Blackberry", "Linux"};
    String mDescription[] = {"Android Description", "iPhone Description", "Windows Description", "Blackberry Description", "Linux Description"};
    int images[] = {R.mipmap.ic_launcher1_foreground, R.mipmap.ic_launcher_foreground, R.mipmap.ic_launcher4_foreground, R.mipmap.ic_launcher2_foreground, R.mipmap.ic_launcher3_foreground};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        if (position == 0)
            Toast.makeText(ListActivity.this, "Android Description", Toast.LENGTH_SHORT).show();
        if (position == 1)
            Toast.makeText(ListActivity.this, "iPhone Description", Toast.LENGTH_SHORT).show();
        if (position == 2)
            Toast.makeText(ListActivity.this, "Windows Description", Toast.LENGTH_SHORT).show();
        if (position == 3)
            Toast.makeText(ListActivity.this, "Blackberry Description", Toast.LENGTH_SHORT).show();
        if (position == 4)
            Toast.makeText(ListActivity.this, "Linux Description", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(ListActivity.this, DeviceDetailActivity.class);
        startActivity(intent);
    }


    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }

    public void onClick(View v) {

    }
}