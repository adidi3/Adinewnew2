package com.example.adipe.adinewnew2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnCreateContextMenuListener {
        TextView tv1;
        Intent q;
        ListView lv;
        int x, bdik;
        double f, d;
        int a;
        double b;
        double s;
        double c;
        String[] listv1 = new String[20];


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            lv = (ListView) findViewById(R.id.lv);
            tv1 = (TextView) findViewById(R.id.tv1);

            if (getIntent() != null) {
                q = getIntent();
                bdik = q.getExtras().getInt("hesh/hand", 10);
                b = q.getExtras().getDouble("eivar", 9.1);
                d = q.getExtras().getDouble("hefomac", 9.0);
                listv1[0] = Double.toString(b);
                if (bdik == 1) {
                    for (int i = 1; i < 20; i++) {
                        listv1[i] = Double.toString(Double.parseDouble(listv1[i - 1]) + d);
                    }

                } else {
                    for (int i = 1; i < 20; i++) {
                        listv1[i] = Double.toString(Double.parseDouble(listv1[i - 1]) * d);
                    }
                }


                lv.setOnItemClickListener(this);
                lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
                ArrayAdapter adp = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, listv1);
                lv.setAdapter(adp);
            }
        }


        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            adapterView.setOnCreateContextMenuListener(this);
            x = i + 1;
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

            menu.setHeaderTitle("data");
            menu.add("n");
            menu.add("sum");
            super.onCreateContextMenu(menu, v, menuInfo);

        }

        @Override
        public boolean onContextItemSelected(MenuItem item) {
            String st1 = item.getTitle().toString();
            if (st1.equals("sum")) {
                if (bdik == 0) {
                    if (d == 1) {
                        s = b * x;
                    } else {
                        s = ((b * ((Math.pow(d, x)) - 1)) / (d - 1));
                    }
                    return true;
                }
                if (bdik == 1) {
                    s = ((x * ((2 * b) + d * (x - 1))) / 2);}
                    tv1.setText(Double.toString(s));
                    return true;
                }
                if (st1.equals("n")) {
                    tv1.setText(Integer.toString(x));
                    return true;
                }
                return super.onContextItemSelected(item); }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main,menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            String st2=item.getTitle().toString();
            if (st2.equals("cred"))
                Toast.makeText(this, "Adi Eisenberg", Toast.LENGTH_SHORT).show();

            return super.onOptionsItemSelected(item);
        }

    public void backk(View view) {
            Intent r=new Intent(this, MainActivity.class);
            startActivity(r);
    }
}




