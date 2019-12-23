package finansal.fbt;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class bt_fragment extends Fragment {

    public List<sozluk_veritipi> sozluk = new ArrayList<sozluk_veritipi>();
    public ListView lv_sozluk;
    public sozluk_adapter sozluk_adapter;
    public ProgressDialog pd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.sozluk_fragment,container,false);
        lv_sozluk= (ListView) v.findViewById(R.id.lv_sozluk);
        sozluk_adapter =new sozluk_adapter(getActivity(),sozluk);
        pd=new ProgressDialog(getActivity());
        pd.setTitle("Yükleniyor");
        pd.setCancelable(true);
        pd.show();

        //-----------Gorev Kaydetme Post İşlemleri-----------------

        RequestQueue requestQueue= Volley.newRequestQueue(getActivity().getApplicationContext());
        String url ="http://bekirbedir.com/fbtsozluk.php";
        StringRequest stringRequest =new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            try {


                JSONArray listArray = new JSONArray(response);
                //jSON OBJESİNDEN EKİP İSİMLİ LİSTE OLAN JSON ELEMANINI ÇEKİYORUZ


                for (int i = 0; i < listArray.length(); i++) {
                    // liste.add(listArray.getString(i).toString());
                    JSONObject obje = listArray.getJSONObject(i);
                    String kelime = obje.getString("kelime").toString();
                    String aciklama = obje.getString("aciklama").toString();
                    String ekleyen = obje.getString("ekleyen").toString();

                  sozluk.add(new sozluk_veritipi(kelime,aciklama));
                    sozluk_adapter.notifyDataSetChanged();

                    //  progressDialog.dismiss();
                }
                pd.dismiss();
            }
            catch (JSONException ex){
                Toast.makeText(getActivity(), "Yeniden Deneyin", Toast.LENGTH_SHORT).show();
            };
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    }
    ){
        @Override
        protected Map<String,String> getParams(){
            Map<String,String> params = new HashMap<String, String>();
            params.put("sozluk","1");
            return params;
        }
    };
    requestQueue.add(stringRequest);


        lv_sozluk.setAdapter(sozluk_adapter);
        //-----------Gorev Kaydetme Post İşlemleri-----------------



        return v;
    }
}
