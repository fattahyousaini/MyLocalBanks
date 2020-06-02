package sg.edu.rp.c346.id18016553.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS, tvOCBC, tvUOB;

    String bank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        bank ="";

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.englishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");

        if (v.getId() == tvDBS.getId()){
            bank = "DBS";
        } else if (v.getId() == tvOCBC.getId()){
            bank = "OCBC";
        } else if (v.getId() == tvUOB.getId()){
            bank = "UOB";
        } else {
            bank = "";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
            //code for action
            if (bank.equals("DBS")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            } else if (bank.equals("OCBC")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;
            } else if (bank.equals("UOB")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true;
            }
        } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
            if (bank.equals("DBS")) {
                long lDBS = Long.parseLong("18001111111");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + lDBS));
                startActivity(intentCall);
                return true;
            } else if (bank.equals("OCBC")) {
                long lOCBC = Long.parseLong("18003633333");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + lOCBC));
                startActivity(intentCall);
                return true;
            } else if (bank.equals("UOB")) {
                long lUOB = Long.parseLong("18002222121");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + lUOB));
                startActivity(intentCall);
                return true;
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}