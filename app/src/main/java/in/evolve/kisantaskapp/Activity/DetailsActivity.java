package in.evolve.kisantaskapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.evolve.kisantaskapp.R;

public class DetailsActivity extends AppCompatActivity {

    private TextView firstName;
    private TextView lastName;
    private TextView phone;
    private Button sendButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        firstName = (TextView) findViewById(R.id.first_name);
        lastName = (TextView) findViewById(R.id.last_name);
        phone = (TextView) findViewById(R.id.phone);
        sendButton = (Button) findViewById(R.id.send_message);


        firstName.setText("First Name : "+getIntent().getStringExtra("first"));
        lastName.setText("Last Name : "+getIntent().getStringExtra("last"));
        phone.setText("Phone : "+getIntent().getStringExtra("phone"));
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsActivity.this,ComposeMessageActivity.class);
                intent.putExtra("first",getIntent().getStringExtra("first"));
                intent.putExtra("last",getIntent().getStringExtra("last"));
                intent.putExtra("phone",getIntent().getStringExtra("phone"));
               startActivity(intent);
            }
        });
    }
}
