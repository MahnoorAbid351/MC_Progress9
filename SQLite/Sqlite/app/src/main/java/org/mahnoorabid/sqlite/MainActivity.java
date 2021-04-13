package org.mahnoorabid.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonAdd,buttonView;
    EditText editName,editAge;
    Switch switchIsActive;
    ListView listViewDetail;
ArrayAdapter<CustomerModel>arrayAdapter;
 DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd=findViewById(R.id.buttonAdd);
        buttonView=findViewById(R.id.buttonView);
        editName=findViewById(R.id.editTextName);
        editAge=findViewById(R.id.editTextAge);
        switchIsActive = findViewById(R.id.switch1);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            CustomerModel customerModel;
            @Override
            public void onClick(View view) {
customerModel=new CustomerModel(editName.getText().toString(),Integer.parseInt(editAge.getText().toString()),switchIsActive.isChecked(), 1);
                Toast.makeText(MainActivity.this, customerModel.toString(),Toast.LENGTH_LONG).show();
                //Toast.makeText(MainActivity.this, "Add Button Clicked",Toast.LENGTH_SHORT).show();

            }
        }
        );
        buttonView.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View view) {
                                             RefreshData();
                                         }
                                     }
        );
    }

    private void RefreshData() {
        dbHelper=new DBHelper(MainActivity.this);
        List<CustomerModel> allCustomers=dbHelper.getAllRecords();
        // Toast.makeText(MainActivity.this, "View Button Clicked",Toast.LENGTH_LONG).show();
        arrayAdapter=new ArrayAdapter<CustomerModel>(MainActivity.this,android.R.layout.simple_list_item_1);
        listViewDetail.setAdapter(arrayAdapter);
    }
}