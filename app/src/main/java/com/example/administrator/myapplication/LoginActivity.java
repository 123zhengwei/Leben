package com.example.administrator.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.checkBox1)
    CheckBox checkBox1;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.activity_main)
    RelativeLayout activity_main;
    private SQLiteDatabase w;
    private SQLiteDatabase r;
    private Mysqlist mys;
    private List<St> mdata;
    private String userTel;
    private String userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mys = new Mysqlist(this, "user.db3", null, 1);//使用halper创建数据库
        r=mys.getReadableDatabase();
        w=mys.getWritableDatabase();
        mdata=new ArrayList<St>();
        Cursor query = r.rawQuery("select * from users", null);
        while(query.moveToNext()){
            int index1 = query.getColumnIndex("userTel");
            int index2 = query.getColumnIndex("userPass");
            userTel = query.getString(index1);
            userPass = query.getString(index2);
            mdata.add(new St(0, userTel, userPass));
        }
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if(isChecked){
                    //如果选中，显示密码
                    editText2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    //否则隐藏密码
                    editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });
    }

    @OnClick({R.id.button, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                String tel = editText.getText().toString().trim();
                String pass = editText2.getText().toString().trim();
                if (tel.equals(userTel)&&pass.equals(userPass)){

                    Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    this.finish();//销毁
                }else{
                    Toast.makeText(this,"账号与密码输入不正确",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button2:
                Intent intent1 = new Intent(this, RegisterActivity.class);
                startActivity(intent1);
                this.finish();//销毁
                break;

        }
    }

}