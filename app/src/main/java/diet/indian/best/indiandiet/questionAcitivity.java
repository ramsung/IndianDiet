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
		ArrayList<String> q3 = new ArrayList<>();
		ArrayList<String> q4 = new ArrayList<>();
		ArrayList<String> q5 = new ArrayList<>();
		ArrayList<String> q6 = new ArrayList<>();
		ArrayList<String> q7 = new ArrayList<>();
		ArrayList<String> q8 = new ArrayList<>();
		ArrayList<String> q9 = new ArrayList<>();
		ArrayList<String> q10 = new ArrayList<>();
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
		q1.add("Everyday");
		q1.add("5-6 days a week");
		q1.add("3-4 days a week");
		q1.add("1-2 days a week");
		q1.add("Never");

		q2.add("1/day");
		q2.add("2-3/day");
		q2.add("4 or more/day");
		q2.add("Never");

		q3.add("1/day");
		q3.add("2-3/day");
		q3.add("4 or more/day");
		q3.add("Never");

		q4.add("1/day");
		q4.add("2-3/day");
		q4.add("4 or more/day");
		q4.add("Never");

		q5.add("Below 100ml/day");
		q5.add("100-300ml/day");
		q5.add("400ml or more/day");
		q5.add("Never");

		q6.add("Below 30 min");
		q6.add("30 min-1 hour");
		q6.add("1 hour-2 hour");
		q6.add("Never");

		q7.add("Once a Day");
		q7.add("2-3 days a Week");
		q7.add("4-5 days a Week");
		q7.add("Never");

		q8.add("Once a Day");
		q8.add("2-3 days a Week");
		q8.add("4-5 days a Week");
		q8.add("Rarely");
		q8.add("Never");

		q9.add("Yes");
		q9.add("No");

		q10.add("Yes");
		q10.add("No");


		Questions one = new Questions("How many days of the week do you eat breakfast?",q1);
		Questions two = new Questions("How many portions of coffee do you drink each day?",q2);
		Questions three = new Questions("How many portions of tea do you drink each day?",q3);
		Questions four = new Questions("Do you Smoke?",q4);
		Questions five = new Questions("Do you consume Alcohol?",q5);
		Questions six = new Questions("How much do you exercise each day?",q6);
		Questions seven = new Questions("Do you eat Non-Vegetarian foods?",q7);
		Questions eight = new Questions("Do you eat Fruits?",q8);
		Questions nine = new Questions("Are you diagnosed with Diabetes?",q9);
		Questions ten = new Questions("Are you diagnosed with Kidney Stone?",q10);

		questionList.add(one);
		questionList.add(two);
		questionList.add(three);
		questionList.add(four);
		questionList.add(five);
		questionList.add(six);
		questionList.add(seven);
		questionList.add(eight);
		questionList.add(nine);
		questionList.add(ten);
		adapter = new QuestionAdapter(questionList,getApplicationContext());
		recyclerView = (RecyclerView) findViewById(R.id.container);
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
}
