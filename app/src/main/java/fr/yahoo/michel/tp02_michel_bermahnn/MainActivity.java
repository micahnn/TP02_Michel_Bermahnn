package fr.yahoo.michel.tp02_michel_bermahnn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int COMPUTE_CODE;
    private EditText editTextNb1;
    private EditText editTextNb2;
    private Button buttonCompute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    /**
     * Methods that allow to retrieve the instance of views in the layout
     */
    private void initViews() {
        editTextNb1 = findViewById(R.id.nb1);
        editTextNb2 = findViewById(R.id.nb2);
        buttonCompute = findViewById(R.id.compute);


        editTextNb1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ((s.toString().equals(""))){
                editTextNb1.setError("Champ obligatoire");
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        editTextNb2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    editTextNb2.setError("Champ obligatoire");
                    buttonCompute.setEnabled(false);
                } else {
                    buttonCompute.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });



        // Intercept click on the compute button
        buttonCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textNb1 = editTextNb1.getText().toString();
                String textNb2 = editTextNb2.getText().toString();

                    Intent intent = new Intent(MainActivity.this, ComputeActivity.class);
                    intent.putExtra("nb1", textNb1);
                    intent.putExtra("nb2", textNb2);
                    startActivityForResult(intent, COMPUTE_CODE);
            }

        });

    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == COMPUTE_CODE && data != null) {
                int result = data.getIntExtra("result", -1);
                Toast.makeText(this, "Result is " + result, Toast.LENGTH_SHORT).show();
            }
        }

    }
}
