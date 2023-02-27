package dk.tec.customizedlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Goose> geese = new ArrayList<Goose>();
        geese.add(new Goose("Hans Gås", "En dejlig gås", R.drawable.geese01));
        geese.add(new Goose("Gås Robin", "Der skal gås på bordet", R.drawable.geese02));
        geese.add(new Goose("Grå And", "Det er ingen gås", R.drawable.geese03));
        geese.add(new Goose("Grå Gås", "Smager usandsynlig godt", R.drawable.geese04));
        geese.add(new Goose("Cananda Gås", "Den smager slet ikkd så værst", R.drawable.geese05));
        geese.add(new Goose("Dansk vadehavsgås", "Med våde svømmefødder", R.drawable.geese06));
        geese.add(new Goose("Sur Gås ", "Nu med gæslinger", R.drawable.geese07));

        GooseAdapter adapter = new GooseAdapter(geese, this);
        ListView lstGoose = findViewById(R.id.lstGeese);
        lstGoose.setAdapter(adapter);
    }
}