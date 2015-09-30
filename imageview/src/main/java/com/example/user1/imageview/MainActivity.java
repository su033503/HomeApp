package com.example.user1.imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1,text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoAni, rdoLux, rdoKtl;
    Button btnOk;
    ImageView imgChp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("발렌타인챔프 일러스트 보기");

        text1=(TextView)findViewById(R.id.Text1);
        chkAgree=(CheckBox)findViewById(R.id.ChkAgree);

        text2=(TextView)findViewById(R.id.Text2);
        rGroup1=(RadioGroup)findViewById(R.id.Rgroup1);
        rdoAni=(RadioButton)findViewById(R.id.RdoAni);
        rdoLux=(RadioButton)findViewById(R.id.RdoLux);
        rdoKtl=(RadioButton)findViewById(R.id.RdoKtl);

        btnOk=(Button)findViewById(R.id.BtnOk);
        imgChp=(ImageView)findViewById(R.id.ImgChp);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if(chkAgree.isChecked()==true) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    btnOk.setVisibility(android.view.View.VISIBLE);
                    imgChp.setVisibility(android.view.View.VISIBLE);
                }
                else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    btnOk.setVisibility(android.view.View.INVISIBLE);
                    imgChp.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                switch(rGroup1.getCheckedRadioButtonId()) {
                    case R.id.RdoAni:
                        imgChp.setImageResource(R.drawable.ani);
                        break;
                    case R.id.RdoLux:
                        imgChp.setImageResource(R.drawable.lux);
                        break;
                    case R.id.RdoKtl:
                        imgChp.setImageResource(R.drawable.ktl);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "챔프 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
