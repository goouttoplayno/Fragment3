package com.example.fragment3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Button button;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        editText = (EditText)findViewById(R.id.editText1);

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        final LeftFragment leftFragment = new LeftFragment();
        transaction.add(R.id.left, leftFragment, "left");
        transaction.commit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftFragment.getEditText(new LeftFragment.CallBack() {
                    @Override
                    public void getResult(String result) {
                        Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
    public void getEditTextFromMain(CallBackMain cbm){
        String s = editText.getText().toString();
        cbm.getResultMain(s);
    }
    public interface CallBackMain{
        public void getResultMain(String r);
    }
}
