package king.chengwu.com.tvtest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        test();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        PackageManager packageManager = getPackageManager();
//        Intent intent = new Intent();
//        intent = packageManager.getLaunchIntentForPackage("com.ktcp.video");
//        if (intent == null) {
//            Toast.makeText(this, "未安装云视听极光", Toast.LENGTH_LONG).show();
//        } else {
//            startActivity(intent);
//            finish();
//        }
    }

    private void test() {
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerView.Adapter<Holder>() {
            @NonNull
            @Override
            public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return new Holder(LayoutInflater.from(MainActivity.this)
                        .inflate(R.layout.transfer_bg_view, viewGroup, false));
            }

            @Override
            public void onBindViewHolder(@NonNull Holder holder, int i) {
                holder.tv.setText("第" + i + "个TextView");
                if (i == 3) {
                    holder.view.setVisibility(View.VISIBLE);
                } else {
                    holder.view.setVisibility(View.GONE);
                }
            }

            @Override
            public int getItemCount() {
                return 10;
            }
        });
    }

    class Holder extends RecyclerView.ViewHolder {
        private View view;
        private TextView tv;

        public Holder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.transparent_tv);
            view = itemView.findViewById(R.id.transparent_view);
        }
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
