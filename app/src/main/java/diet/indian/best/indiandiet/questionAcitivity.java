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
		ArrayList<String> q11 = new ArrayList<>();
        ArrayList<String> q12 = new ArrayList<>();
        ArrayList<String> q13 = new ArrayList<>();
        ArrayList<String> q14 = new ArrayList<>();
        ArrayList<String> q15 = new ArrayList<>();
        ArrayList<String> q16 = new ArrayList<>();
        ArrayList<String> q17 = new ArrayList<>();
        ArrayList<String> q18 = new ArrayList<>();
        ArrayList<String> q19 = new ArrayList<>();
        ArrayList<String> q20 = new ArrayList<>();

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

		q11.add("Once a Day");
		q11.add("2-3 days a Week");
		q11.add("4-5 days a Week");
		q11.add("Rarely");
		q11.add("Never");

        q12.add("Yes");
        q12.add("No");

        q13.add("less than 1 litre /day");
        q13.add("2-3 litres /day");
        q13.add("4-5 litres /day");
        q13.add("more than 5 litres /day");

        q14.add("Sitting all day- Stressful");
        q14.add("Sitting all day- Relaxing");
        q14.add("Standing all day- Stressful");
        q14.add("Standing all day- Relaxing");
        q14.add("More into Physical activity");

        q15.add("5-6 hours a day");
        q15.add("7-8 hours a day");
        q15.add("9-10 hours a day");
        q15.add("11-12 hours a day");
        q15.add("More than 12 hours a day");

        q16.add("Yes");
        q16.add("No");

        q17.add("Yes");
        q17.add("No");

        q18.add("Very Rare");
        q18.add("Daily");
        q18.add("Sometimes");

        q19.add("Older for my age");
        q19.add("Younger for my age");
        q19.add("Too much Wrinkles for my age");

        q20.add("I feel Energetic all day");
        q20.add("I become tired very often");
        q20.add("I get tired sometimes");


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
		Questions eleven = new Questions("Do you drink cola/soft/energy/fizzy/soda drinks?",q11);
        Questions twelve = new Questions("Do you get 8 hours sleep each night?",q12);
        Questions thirteen = new Questions("How much litres of Water do you drink?",q13);
        Questions fourteen = new Questions("What kind of Profession are you into?",q14);
        Questions fifteen = new Questions("How much Hours do you work?",q15);
        Questions sixteen = new Questions("Are you Married?",q16);
        Questions seventeen = new Questions("Do you have Excessive Tummy?",q17);
        Questions eighteen = new Questions("How much direct sunlight on your skin are you exposed to in an average week?",q18);
        Questions nineteen = new Questions("How does your skin look?",q19);
        Questions twenty = new Questions("How are your Energy level?",q20);

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
		questionList.add(eleven);
        questionList.add(twelve);
        questionList.add(thirteen);
        questionList.add(fourteen);
        questionList.add(fifteen);
        questionList.add(sixteen);
        questionList.add(seventeen);
        questionList.add(eighteen);
        questionList.add(nineteen);
        questionList.add(twenty);

		adapter = new QuestionAdapter(questionList,getApplicationContext());
		recyclerView = (RecyclerView) findViewById(R.id.container);
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
	}
}
