package com.example.danner.testjson;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    final static String myLogs = "myLogs";
    ListView mListView;
    Spinner mSpinnerCourse;
    Spinner mSpinnerGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(myLogs, "onCreate starts");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);
        mSpinnerCourse = (Spinner) findViewById(R.id.spinnerCourse);
        mSpinnerGroup = (Spinner) findViewById(R.id.spinnerGroup);

        AsyncHandleGroupNameJSON mAsyncHandleGroupNameJSON = new AsyncHandleGroupNameJSON();
        mAsyncHandleGroupNameJSON.execute(this);

        mSpinnerCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                AsyncHandleGroupNameJSON mAsyncHandleGroupNameJSON = new AsyncHandleGroupNameJSON();
                mAsyncHandleGroupNameJSON.execute(MainActivity.this);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        Log.d(myLogs, "onCreate finish, mListView: " + mListView);
    }

    @Override
    protected void onResume() {

        Log.d(myLogs, "onResume starts");

        super.onResume();

        //     Log.d(myLogs, "mAsyncHandleJSON.execute starts");

        //     mAsyncHandleJSON.execute(this);

        Log.d(myLogs, "onResume finish");

    }

    @Override
    protected void onStart() {

        Log.d(myLogs, "onStart starts");

        super.onStart();

        //      Log.d(myLogs, "mAsyncHandleJSON.execute starts");

//        mAsyncHandleJSON.execute(this);

        Log.d(myLogs, "onStart finish");

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
        if (id == R.id.action_news) {

            Log.d(myLogs, "mAsyncHandleNewsJSON.execute starts");

            AsyncHandleNewsJSON mAsyncHandleNewsJSON = new AsyncHandleNewsJSON();
            mAsyncHandleNewsJSON.execute(this);

            return true;
        }

        if (id == R.id.action_shed) {

            Log.d(myLogs, "mAsyncHandleShedJSON.execute starts");

            AsyncHandleShedJSON mAsyncHandleShedJSON = new AsyncHandleShedJSON();
            mAsyncHandleShedJSON.execute(this);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class VKListView extends ListView {
        public VKListView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            TextView urlImgContextTextView = (TextView) findViewById(R.id.imgContext);
            TextView idSourceTextView = (TextView) findViewById(R.id.imgTitle);
            ImageView mImageTitle = (ImageView) findViewById(R.id.imageTitle);

            String idSource = idSourceTextView.getText().toString();

            switch (idSource) {
                // Новости СФУ
                case "-52332777":

                    break;
                // ПРОФКОМ СФУ
                case "-411321":

                    break;
                // Отдел молодежных проектов СФУ
                case "-28014875":

                    break;
                // Музей занимательных наук СФУ
                case "-60118784":

                    break;
                case " ":
                    mImageTitle.setImageResource(R.drawable.ic_piinformer);
                    break;
                default:

                    break;
            }


        }
    }
}
