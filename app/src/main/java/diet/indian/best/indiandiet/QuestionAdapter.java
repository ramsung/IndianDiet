package diet.indian.best.indiandiet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohan on 7/21/17.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.MyViewHolder> {

	private ArrayList<Questions> questions;


	public QuestionAdapter(ArrayList<Questions> questions) {
		this.questions = questions;

		Log.i("question",String.valueOf(questions.size()));
		for(Questions q : questions){
			Log.i("question",String.valueOf(q.getCustquest()));
		}
	}

	@Override
	public QuestionAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.question_layout, parent, false);
		RecyclerView.ViewHolder holder = new MyViewHolder(itemView);

		return (MyViewHolder) holder;
	}

	@Override
	public void onBindViewHolder(QuestionAdapter.MyViewHolder holder, int position) {
		Questions question = questions.get(position);
		holder.textQuestion.setText(question.getCustquest());
		holder.rb1.setText(question.getOptions().get(0));
		holder.rb2.setText(question.getOptions().get(1));
		holder.rb3.setText(question.getOptions().get(2));
		holder.rb4.setText(question.getOptions().get(3));
		holder.rb5.setText(question.getOptions().get(4));

	}

	@Override
	public int getItemCount() {
		return questions.size();
	}

	public class MyViewHolder extends RecyclerView.ViewHolder {
		public TextView textQuestion;
		public RadioButton rb1,rb2,rb3,rb4,rb5;
		public RadioGroup group;


		public MyViewHolder(View view) {
			super(view);
			textQuestion = (TextView) view.findViewById(R.id.questionss);
			group = (RadioGroup) view.findViewById(R.id.radiogroup);
			rb1 = (RadioButton)view.findViewById(R.id.rb1);
			rb2 = (RadioButton)view.findViewById(R.id.rb2);
			rb3 = (RadioButton)view.findViewById(R.id.rb3);
			rb4 = (RadioButton)view.findViewById(R.id.rb4);
			rb5 = (RadioButton)view.findViewById(R.id.rb5);
		}
	}


}
