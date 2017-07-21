package diet.indian.best.indiandiet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;

public class questionAcitivity extends AppCompatActivity {
	QuestionAdapter adapter;
	ArrayList<Questions> questionList;
	RecyclerView recyclerView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question_acitivity);
		questionList = new ArrayList<>();
		ArrayList<String> q1 = new ArrayList<>();
		ArrayList<String> q2 = new ArrayList<>();
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
		q1.add("option1");
		q1.add("option2");
		q1.add("option3");
		q1.add("option4");

		q2.add("option1");
		q2.add("option2");
		q2.add("option3");

		Questions first = new Questions("Whats Your name?",q1);
		Questions second = new Questions("Whats Your age?",q2);

		questionList.add(first);
		questionList.add(second);
		adapter = new QuestionAdapter(questionList,getApplicationContext());
		recyclerView = (RecyclerView) findViewById(R.id.container);
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
}
