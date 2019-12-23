package finansal.fbt;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;



public class sozluk_adapter extends BaseAdapter {
    public  veritabani vt;
    public Activity mactivity;
  private LayoutInflater minflater;
    private List<sozluk_veritipi> msozlukveri;

    public sozluk_adapter(Activity activity, List<sozluk_veritipi> sozlukveri) {
        minflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        msozlukveri=sozlukveri;
        vt = new veritabani(activity);
        mactivity=activity;



    }

    @Override
    public int getCount() {
        return msozlukveri.size();
    }

    @Override
    public Object getItem(int position) {
        return msozlukveri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Button btnkaydet;
        View satir;
        satir=minflater.inflate(R.layout.sozluk_satir,null);

        LinearLayout li = (LinearLayout) satir.findViewById(R.id.satir_linear);
        btnkaydet= (Button) satir.findViewById(R.id.btnkydet);
        final TextView tv_kelime= (TextView) satir.findViewById(R.id.tv_sozluk_kelime);
        final TextView tv_aciklama = (TextView) satir.findViewById(R.id.tv_sozluk_aciklama);
        sozluk_veritipi sv_nesne = msozlukveri.get(position);
        tv_kelime.setText(sv_nesne.getKelime());
        tv_aciklama.setText(sv_nesne.getAciklama());




        if(position%2 ==1) {

        li.setBackgroundResource(R.drawable.sozluk_back);
        }
        else {
            li.setBackgroundResource(R.drawable.sozluk_backiki);

        }
        btnkaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vt.veriekle(tv_aciklama.getText().toString(),tv_kelime.getText().toString());
                Toast.makeText(mactivity, "Kaydedildi", Toast.LENGTH_SHORT).show();
                btnkaydet.setBackgroundResource(R.drawable.okey);
                btnkaydet.setClickable(false);

            }
        });

        Boolean kontrol = vt.kontrol(tv_kelime.getText().toString());

        if(kontrol)
        {
            btnkaydet.setBackgroundResource(R.drawable.okey);
            btnkaydet.setClickable(false);
        }

        return satir;
    }
}
