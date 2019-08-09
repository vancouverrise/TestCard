package iks.market.testcard.Database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import iks.market.testcard.R;

public class DocumentActivity extends AppCompatActivity {

    Button test;
    String tempy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
          tempy = bundle.getString("DocumentNumber");
        }
        test = findViewById(R.id.button2);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DocumentActivity.this, tempy, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
