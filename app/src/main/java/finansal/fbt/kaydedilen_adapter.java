package finansal.fbt;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;



public class kaydedilen_adapter extends BaseAdapter {
    public Activity mactivity;
    private LayoutInflater minflater;
    private List<sozluk_veritipi> msozluk;
    public kaydedilen_adapter(Activity activity, List<sozluk_veritipi> sozlukveri) {
        minflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        msozluk=sozlukveri;
        mactivity=activity;
    }

    @Override
    public int getCount() {
        return msozluk.size();
    }

    @Override
    public Object getItem(int position) {
        return msozluk.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View satir;
        satir=minflater.inflate(R.layout.kaydedilen_satir,null);
        TextView tv_kelime= (TextView) satir.findViewById(R.id.save_k);
        TextView tv_aciklama = (TextView) satir.findViewById(R.id.save_acik);
        sozluk_veritipi sv_nesne = msozluk.get(position);
        tv_kelime.setText(sv_nesne.getKelime());
        tv_aciklama.setText(sv_nesne.getAciklama());


        return satir;
    }
}
