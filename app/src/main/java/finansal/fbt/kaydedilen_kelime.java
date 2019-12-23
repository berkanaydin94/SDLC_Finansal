package finansal.fbt;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class kaydedilen_kelime extends Fragment {

    public veritabani veritabani;

    ListView lv;
    public List<sozluk_veritipi> veriler = new ArrayList<sozluk_veritipi>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.kaydedilen_fra, container, false);
        veritabani = new veritabani(getActivity());
        Button ekle = (Button) v.findViewById(R.id.kaydedilen_ekle);
        final EditText tv_kelime= (EditText) v.findViewById(R.id.tv_kaydet_k);
        final EditText tv_aciklama= (EditText) v.findViewById(R.id.tv_kaydet_a);
        lv = (ListView) v.findViewById(R.id.kaydedilenlv);
        veriler = veritabani.verilistele();
       final  kaydedilen_adapter adapter = new kaydedilen_adapter(getActivity(), veriler);
        // ArrayAdapter<String>adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,android.R.id.text1,veri);
        lv.setAdapter(adapter);

        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veritabani.veriekle(tv_aciklama.getText().toString(),tv_kelime.getText().toString());
                veriler.add(new sozluk_veritipi(tv_aciklama.getText().toString(),tv_kelime.getText().toString()));
                adapter.notifyDataSetChanged();
            }
        });


        return v;

    }
}
