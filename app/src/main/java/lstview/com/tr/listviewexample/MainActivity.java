package lstview.com.tr.listviewexample;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class MainActivity extends AppCompatActivity {
    private String[] yiyecekler =
            {"pizzalar", "Burgerler", "Sandviçler", "Salatalar","Izgaralar",
                    "Çorbalar", "Tostlar", "Kahvaltılar", "Ara Sıcaklar", "Diyet Ürünleri", "Makarnalar",
                    "Gözlemeler", "Kızartmalar", "Suşiler", "Çin Yemekleri", "Dürümler",
                    "Sulu Yemekler", "Sebzeler", "Kebaplar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView liste=(ListView) findViewById(R.id.ListView);
        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, yiyecekler);
        liste.setAdapter(veriAdaptoru);
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder diyalog=
                        new AlertDialog.Builder(MainActivity.this);
                diyalog.setMessage(yiyecekler[position]).setCancelable(false).setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                    diyalog.create().show();
            }
        });
    }
}
