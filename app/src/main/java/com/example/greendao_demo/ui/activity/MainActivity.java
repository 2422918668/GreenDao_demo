package com.example.greendao_demo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.greendao_demo.R;
import com.example.greendao_demo.data.App;
import com.example.greendao_demo.data.beans.User;
import com.example.greendao_demo.data.database.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_add;
    private Button btn_delete;
    private Button btn_update;
    private Button btn_select;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_delete = findViewById(R.id.btn_delete);
        btn_update = findViewById(R.id.btn_update);
        btn_select = findViewById(R.id.btn_select);
        textView = findViewById(R.id.tv_showdata);
        btn_add.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_select.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        UserDao userDao = App.getInstance().getDaoSession().getUserDao();
        switch (view.getId()) {
            case R.id.btn_add:
                for (int i = 0; i < 3; i++) {
                    User user = new User();
                    user.setName("赵老" + i);
                    userDao.insert(user);
                }
                break;
            case R.id.btn_delete:
                userDao.deleteAll();
                break;
            case R.id.btn_update:
                User user1 = new User();
                user1.setId((long) 1);
                user1.setName("哈哈");
                user1.setAge(25);
                userDao.update(user1);
                break;
            case R.id.btn_select:
                StringBuilder stringBuilder = new StringBuilder();
                List<User> userList = userDao.loadAll();
                for (int i = 0; i < userList.size(); i++) {
                    User user = userList.get(i);
                    stringBuilder.append("姓名是" + user.getName() + "-----"+"年龄是" + user.getAge() + " - - - - " + "id 是" + user.getId() + "\n");
                }
                textView.setText(stringBuilder.toString());
                break;
        }
    }
}
