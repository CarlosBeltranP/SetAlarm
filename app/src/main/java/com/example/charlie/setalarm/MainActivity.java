package com.example.charlie.setalarm;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSetAlarm = ((Button) findViewById(R.id.btnSetAlarm));
        btnSetAlarm.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        setAlarm();
                    }
                });

        ImageButton btnClear = ((ImageButton) findViewById(R.id.btnLimpiar));
        btnClear.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Limpiar();
                    }
                });
    }

    private void setAlarm() {

        Intent intent=null, chooser=null;

        EditText h =(EditText)findViewById(R.id.hora);
        EditText m =(EditText)findViewById(R.id.minuto);
        EditText d =(EditText)findViewById(R.id.des);

        intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, d.getText().toString())
                .putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(h.getText().toString()) )
                .putExtra(AlarmClock.EXTRA_MINUTES,Integer.parseInt(m.getText().toString()) );
        chooser=Intent.createChooser(intent, "Poner Alarma");

        if(intent.resolveActivity(getPackageManager())!=null);
        startActivity(chooser);
    }

    private void Limpiar() {

        EditText h =(EditText)findViewById(R.id.hora);
        EditText m =(EditText)findViewById(R.id.minuto);
        EditText d =(EditText)findViewById(R.id.des);

        h.setText("");
        m.setText("");
        d.setText("");
    }

}

