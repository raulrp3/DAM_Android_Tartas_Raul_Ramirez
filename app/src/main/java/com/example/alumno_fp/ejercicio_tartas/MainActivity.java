package com.example.alumno_fp.ejercicio_tartas;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputName,inputSurname,inputAge,inputSex,inputOther;
    private TextInputLayout inputLayoutName,inputLayoutSurname,inputLayoutAge,inputLayoutSex,inputLayoutOther;
    private CheckBox checkOther;
    private Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
        hideOther();
        checkOther.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    inputOther.setVisibility(View.VISIBLE);
                    inputLayoutOther.setVisibility(View.VISIBLE);
                }else{
                    hideOther();
                }
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }
    private void initUI(){
        inputLayoutName = findViewById(R.id.input_layout_name);
        inputLayoutSurname = findViewById(R.id.input_layout_surname);
        inputLayoutAge = findViewById(R.id.input_layout_age);
        inputLayoutSex = findViewById(R.id.input_layout_sex);
        inputLayoutOther = findViewById(R.id.input_layout_other);
        inputName = findViewById(R.id.edit_text_name);
        inputSurname = findViewById(R.id.edit_text_surname);
        inputAge = findViewById(R.id.edit_text_age);
        inputSex = findViewById(R.id.edit_layout_sex);
        inputOther = findViewById(R.id.edit_text_other);
        checkOther = findViewById(R.id.check_other);
        buttonLogin = findViewById(R.id.button_login);
    }
    private void hideOther(){
        if (inputOther.getVisibility() == View.VISIBLE && inputLayoutOther.getVisibility() == View.VISIBLE){
            inputOther.setVisibility(View.INVISIBLE);
            inputLayoutOther.setVisibility(View.INVISIBLE);
        }
    }
    private void submitForm(){
        if (!validate()){
            Toast.makeText(getApplicationContext(),"¡No puedes dejar campos sin rellenar!",Toast.LENGTH_SHORT).show();
        }else{
            if (!validateAge()){
                Toast.makeText(getApplicationContext(),"¡No puedes ser menor de edad!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"¡Te has logeado correctamente!",Toast.LENGTH_SHORT).show();
            }
        }
    }
    private boolean validate(){
        String name = inputName.getText().toString().trim();
        String surname = inputSurname.getText().toString().trim();
        String age = inputAge.getText().toString().trim();
        String sex = inputSex.getText().toString().trim();
        String other = inputOther.getText().toString().trim();
        boolean isValid;
        if (checkOther.isChecked()){
            if (name.isEmpty() || surname.isEmpty() || age.isEmpty() || sex.isEmpty() || other.isEmpty()){
                isValid = false;
            }else{
                isValid = true;
            }
        }else{
            if (name.isEmpty() || surname.isEmpty() || age.isEmpty() || sex.isEmpty()){
                isValid = false;
            }else{
                isValid = true;
            }
        }
        return  isValid;
    }
    private boolean validateAge(){
        int age = Integer.parseInt(inputAge.getText().toString().trim());
        boolean isValid = true;
        if (age < 18){
            isValid = false;
        }
        return  isValid;
    }
}
