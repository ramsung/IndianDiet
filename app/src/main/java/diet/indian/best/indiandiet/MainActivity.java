package diet.indian.best.indiandiet;

import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
//import com.google.firebase.auth.TwitterAuthProvider;
import com.google.android.gms.auth.api.Auth;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
//import com.twitter.sdk.android.core.Twitter;
//import com.twitter.sdk.android.core.TwitterApiClient;
//import com.twitter.sdk.android.core.TwitterAuthConfig;
//import com.twitter.sdk.android.core.TwitterConfig;
//import com.twitter.sdk.android.core.TwitterCore;
//import com.twitter.sdk.android.core.TwitterException;
//import com.twitter.sdk.android.core.TwitterSession;
//import com.twitter.sdk.android.core.identity.TwitterAuthClient;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.facebook.FacebookSdk;
//import com.facebook.appevents.AppEventsLogger;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;


public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
	private FirebaseAuth mAuth;
	private FirebaseAuth.AuthStateListener mAuthListener;
	SignInButton googleLogin;
	GoogleApiClient mGoogleApiClient;
	//TwitterLoginButton twitterlogin;
	FirebaseUser user;
	//static String CONSUMER_KEY = "TNZXRkBN9yej8n0icgWsnh8zX";
	//static String CONSUMER_SECRET = "IBebQWR3mcalHHkwBu4AUPTJG6pFMVeDgpHNCB7Si518PxiQH1";
	//TwitterAuthClient mTwitterAuthClient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectAll()
				.penaltyLog()
				.build());

		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectAll()
				.penaltyLog()
				.build());


		/*Twitter.initialize(this);
		final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
		loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
		final OkHttpClient customClient = new OkHttpClient.Builder()
				.addInterceptor(loggingInterceptor).build();

		final TwitterSession activeSession = TwitterCore.getInstance()
				.getSessionManager().getActiveSession();

		final TwitterApiClient customApiClient;
		if (activeSession != null) {
			customApiClient = new TwitterApiClient(activeSession, customClient);
			TwitterCore.getInstance().addApiClient(activeSession, customApiClient);
		} else {
			customApiClient = new TwitterApiClient(customClient);
			TwitterCore.getInstance().addGuestApiClient(customApiClient);
		}*/
		mAuth = FirebaseAuth.getInstance();
		GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
				.requestIdToken(getString(R.string.default_web_client_id))
				.requestEmail()
				.build();

		mGoogleApiClient = new GoogleApiClient.Builder(this)
				.enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
					@Override
					public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

					}
				} /* OnConnectionFailedListener */)
				.addApi(Auth.GOOGLE_SIGN_IN_API, gso)
				.build();

		googleLogin = (SignInButton) findViewById(R.id.sign_in_button);
		//twitterlogin = (TwitterLoginButton) findViewById(R.id.twt_login_button);

		googleLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				signIn();
			}
		});

		/*twitterlogin.setCallback(new Callback<TwitterSession>() {
			@Override
			public void success(Result<TwitterSession> result) {
				requestEmailAddress(getApplicationContext(), result.data);
			}

			@Override
			public void failure(TwitterException exception) {

			}
		});*/
	}

	public void signIn() {
		Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
		startActivityForResult(signInIntent, 1);
	}

	@Override
	public void onStart() {
		super.onStart();
		// Check if user is signed in (non-null) and update UI accordingly.


	}
	public void cardView(View view) {
		Intent q = new Intent(this, questionAcitivity.class);
		startActivity(q);
	}
	public void profView(View view) {
		Intent p = new Intent(this, profile.class);
		startActivity(p);
	}
	public void profedit(View view){
        Intent u = new Intent(this, profileedit.class);
        startActivity(u);

	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		// Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);

		/*if (requestCode == 1) {
			Log.e("test", String.valueOf(requestCode));
			GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

			handleSignInResult(result);
		} else if(requestCode == TwitterAuthConfig.DEFAULT_AUTH_REQUEST_CODE){
			twitterlogin.onActivityResult(requestCode, resultCode, data);
		}*/

		//twitterlogin.onActivityResult(requestCode, resultCode, data);
	}

	private void handleSignInResult(GoogleSignInResult result) {
		Log.d("Sign In", "handleSignInResult:" + result.isSuccess());
		if (result.isSuccess()) {
			// Signed in successfully, show authenticated UI.
			GoogleSignInAccount acct = result.getSignInAccount();
			Log.i("user Name", acct.getDisplayName());


			firebaseAuthWithGoogle(acct);


		} else {


		}
	}

	private void firebaseAuthWithGoogle(final GoogleSignInAccount acct) {
		Log.d("Sign in", "firebaseAuthWithGoogle:" + acct.getId());

		final AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
		mAuth.signInWithCredential(credential)
				.addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
					@Override
					public void onComplete(@NonNull Task<AuthResult> task) {
						Log.d("sign in", "signInWithCredential:onComplete:" + task.isSuccessful());
						//String pic = acct.getPhotoUrl().toString();
						//Toast.makeText(getApplicationContext(),pic,Toast.LENGTH_SHORT).show();
						// Picasso.with(getApplicationContext()).load(pic).into(profileImage);
						// If sign in fails, display a message to the user. If sign in succeeds
						// the auth state listener will be notified and logic to handle the
						// signed in user can be handled in the listener.
						if (task.isSuccessful()) {
							user = mAuth.getCurrentUser();


						}

						//userEmailId.setText(user.getEmail());
						if (!task.isSuccessful()) {
							Log.w("Sign in", "signInWithCredential", task.getException());

						}
						// ...
					}
				});
	}

	/*private static void requestEmailAddress(final Context context, TwitterSession session) {
		new TwitterAuthClient().requestEmail(session, new Callback<String>() {
			@Override
			public void success(Result<String> result) {
				Toast.makeText(context, result.data, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void failure(TwitterException exception) {
				Toast.makeText(context, exception.getMessage(), Toast.LENGTH_SHORT).show();
			}
		});
	}*/


	@Override
	public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

	}
	public void Home(View v){
		Intent home = new Intent(this,home.class);
		startActivity(home);
	}
}