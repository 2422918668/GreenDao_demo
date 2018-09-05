package com.example.greendao_demo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        btn_add.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_select.setOnClickListener(this);
        textView = findViewById(R.id.textview);
    }

    @Override
    public void onClick(View view) {
        StudentDao studentDao = App.getInstance().getDaoSession().getStudentDao();
        switch (view.getId()){
            case R.id.btn_add:
//                Toast.makeText(this, "haha", Toast.LENGTH_SHORT).show();
                for (int i = 1; i < 6; i++) {
                    Student student = new Student();
                    student.setName("哈哈" + i);
                    student.setAge(18+i);
                    studentDao.insert(student);
                }
                break;
            case R.id.btn_delete:
                studentDao.deleteAll();
                break;
            case R.id.btn_update:
                Student student = new Student();
                student.setId((long) 6);
                student.setName("五湖四海");
                student.setAge(54);
                studentDao.update(student);
                break;
            case R.id.btn_select:

                StringBuilder stringBuilder = new StringBuilder();
                List<Student> students = studentDao.loadAll();
                for (int i = 0; i < students.size(); i++) {
                    stringBuilder.append("主键是" + students.get(i).getId() + "姓名是" + students.get(i).getName() + "年龄是" + students.get(i).getAge() + "\n");
                }
                textView.setText(stringBuilder.toString());
                break;
        }
    }
}
