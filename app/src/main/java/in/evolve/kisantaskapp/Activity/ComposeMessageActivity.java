package in.evolve.kisantaskapp.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Random;

import in.evolve.kisantaskapp.Db.DbHelper;
import in.evolve.kisantaskapp.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ComposeMessageActivity extends AppCompatActivity {


    private TextView otp;
    private Button send_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose_message);

        otp = (TextView) findViewById(R.id.random_otp);
        send_otp = (Button) findViewById(R.id.send_otp);
        Random rnd = new Random();
        final int gen_otp = 100000 + rnd.nextInt(900000);
        otp.setText(""+gen_otp);


        final ProgressDialog progressDialog = new ProgressDialog(ComposeMessageActivity.this);
        progressDialog.setMessage("Sending otp");


        send_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog.show();
                Long tsLong = System.currentTimeMillis()/1000;
                final String ts = tsLong.toString();

                String url = "https://rest.nexmo.com/sms/json";

                 final MediaType JSON
                        = MediaType.parse("application/json; charset=utf-8");
                JSONObject dataJSON = new JSONObject();

                try{
                    dataJSON.put("api_key","e7c36c44");
                    dataJSON.put("api_secret","Z3e5h8F1NE8XNwSX");
                    dataJSON.put("to",getIntent().getStringExtra("phone").substring(1));
                    dataJSON.put("from","NEXMO");
                    dataJSON.put("text","Hi ! The Otp is "+gen_otp);
                }catch (JSONException e){
                    e.printStackTrace();
                }

                RequestBody body = RequestBody.create(JSON, dataJSON.toString());

                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();

                OkHttpClient httpClient = new OkHttpClient();
                httpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {


                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.cancel();
                                Toast.makeText(ComposeMessageActivity.this,"Not able to send otp",Toast.LENGTH_LONG).show();

                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.cancel();
                                Toast.makeText(ComposeMessageActivity.this,"otp  sent successfully",Toast.LENGTH_LONG).show();
                                DbHelper dbHelper = new DbHelper(ComposeMessageActivity.this);
                                dbHelper.addEntryToDb(ts,getIntent().getStringExtra("first")+" "+getIntent().getStringExtra("last"),""+gen_otp);
                                Intent intent = new Intent(ComposeMessageActivity.this,MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                            }
                        });


                    }
                });


            }
        });
    }
}
