package com.example.fragment3;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LeftFragment extends Fragment {
    EditText editText;
    Button button;
    Context context;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, null);
        editText = (EditText)view.findViewById(R.id.fleditText1);
        button = (Button)view.findViewById(R.id.flbutton1);
        final MainActivity ma = (MainActivity)getActivity();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ma.getEditTextFromMain(new MainActivity.CallBackMain() {
                    @Override
                    public void getResultMain(String r) {
                        Toast.makeText(getActivity(), r, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public void getEditText(CallBack callBack){
        String msg = editText.getText().toString();
        callBack.getResult(msg);
    }

    public interface CallBack{
        public void getResult(String result);
    }
}
