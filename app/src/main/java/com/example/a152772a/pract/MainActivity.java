package com.example.a152772a.pract;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String em;
    String em2;
    String add;
    String inf;
    boolean yes;
    boolean no;
    String animal;

    Button save;
    EditText email;
    EditText address;
    EditText info;
    ListView listt;
    EditText email2;

    Menu myMenu;


    ArrayAdapter<CharSequence>arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        save = (Button) findViewById(R.id.save);
        email = (EditText) findViewById(R.id.emailId);
        address = (EditText) findViewById(R.id.address);
        info = (EditText) findViewById(R.id.info);
        email2 = (EditText) findViewById(R.id.email2);


        em = email.getText().toString();
        em2 = email2.getText().toString();

        add = address.getText().toString();

        yes = ((RadioButton) findViewById(R.id.Ryes)).isSelected();
        no = ((RadioButton) findViewById(R.id.Rno)).isSelected();

        listt = (ListView) findViewById(R.id.list);

        arr = ArrayAdapter.createFromResource(this, R.array.lis, android.R.layout.simple_spinner_dropdown_item);
        listt.setAdapter(arr);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dis = "Location is at:" + "address" + "\n" + "Other info " + "info" + "\n" + "Email: " + "email" + "@" + em2 + "\n" + "Yes radiobutton is selected:" + yes + "\n" + "No radiobutton is selected:" + no + "\n" +
                        "Type of animal:" + animal;

                displayToast(dis);

            }
        });


        listt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                displayToast(listt.getItemAtPosition(position).toString());
                animal = listt.getItemAtPosition(position).toString();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       super.onCreateOptionsMenu(menu);
        this.myMenu = menu;
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.quit){
            finish();
        }else if(item.getItemId()==R.id.option){
           email.setText("santaclaus");
            email2.setText("northpole.com");

        }
        return true;
    }

    private void displayToast(String s){

        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }
}
