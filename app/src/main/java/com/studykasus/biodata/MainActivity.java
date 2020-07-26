package com.studykasus.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText nama, tempatlahir, alamat, nohp, hobi, keinginan;
    Button tanggallahir, proses;
    TextView kalimatprofil;
    private int mTahun, mBulan, mHari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (EditText)findViewById(R.id.edt_nama);
        tempatlahir = (EditText)findViewById(R.id.edt_tempatlahir);
        alamat = (EditText)findViewById(R.id.edt_alamat);
        nohp = (EditText)findViewById(R.id.edt_nohp);
        hobi = (EditText)findViewById(R.id.edt_hobi);
        keinginan = (EditText)findViewById(R.id.edt_keinginan);

        tanggallahir = (Button)findViewById(R.id.btn_tanggallahir);
        proses = (Button)findViewById(R.id.btn_proses);

        kalimatprofil = (TextView)findViewById(R.id.txt_kalimatprofil);

        tanggallahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                mTahun = cal.get(Calendar.YEAR);
                mBulan = cal.get(Calendar.MONTH);
                mHari = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDateDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tanggallahir.setText(String.valueOf(dayOfMonth)+"-"+String.valueOf(month+1)+"-"+String.valueOf(year));
                    }
                },mTahun, mBulan, mHari);
                mDateDialog.setTitle("Pilih Tanggal Lahir");
                mDateDialog.show();
            }});
        proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kalimatprofil.setText("Nama : "+nama.getText().toString()+"\nTempat, Tanggal Lahir : "+tempatlahir.getText().toString()+tanggallahir.getText().toString()
                +"\nAlamat : "+alamat.getText().toString()+"\nNo HP : "+nohp.getText().toString()+"\nHobi : "+hobi.getText().toString()+"\nKeinginan : "+keinginan.getText().toString());
            }
        });
    }
}