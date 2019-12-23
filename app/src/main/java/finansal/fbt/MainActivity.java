package finansal.fbt;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
public  Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Color.CYAN);
        toolbar.setTitle("Sdlc nedir");





        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft =fragmentManager.beginTransaction();
        sdlc_nedir sdlcN = new sdlc_nedir();
        ft.add(R.id.content_frame, sdlcN);
        ft.commit();

        toolbar.setTitle("Anasayfa");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager  fragmentManager = getFragmentManager();
        FragmentTransaction  ft =fragmentManager.beginTransaction();
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            toolbar.setTitle("Sdlc nedir");
            Toast.makeText(this, "SDLC Nedir Fragmenti", Toast.LENGTH_SHORT).show();
            sdlc_nedir sdlcN = new sdlc_nedir();
            ft.replace(R.id.content_frame, sdlcN);
            ft.commit();



        } else if (id == R.id.nav_gallery) {
            toolbar.setTitle("Sdlc Modelleri");
            Toast.makeText(this, "SDLC Modelleri Fragment", Toast.LENGTH_SHORT).show();
            sdlc_modeller sdlcM = new sdlc_modeller();
            ft.replace(R.id.content_frame, sdlcM);
            ft.commit();


        } else if (id == R.id.nav_slideshow) {
            toolbar.setTitle("BT SÖZLÜK");
            Toast.makeText(this, "bt_sozluk Fragment Çalıştı", Toast.LENGTH_SHORT).show();
          //  List<sozluk_veritipi> sozluk = new ArrayList<sozluk_veritipi>();
            //parametre olarak List verilebilir volley sorun çıkartırsa
            bt_fragment btf =new bt_fragment();
            ft.replace(R.id.content_frame,btf);
            ft.commit();


        }
        else if (id == R.id.barok) {
            toolbar.setTitle("Barok Modeli");
            Toast.makeText(this, "barok Fragment Çalıştı", Toast.LENGTH_SHORT).show();
            //  List<sozluk_veritipi> sozluk = new ArrayList<sozluk_veritipi>();
            //parametre olarak List verilebilir volley sorun çıkartırsa
            barok btf =new barok();
            ft.replace(R.id.content_frame,btf);
            ft.commit();
        }

        else if (id == R.id.waterfall) {
            toolbar.setTitle("Waterfall Modeli");
            Toast.makeText(this, "Waterfall Fragment Çalıştı", Toast.LENGTH_SHORT).show();
            //  List<sozluk_veritipi> sozluk = new ArrayList<sozluk_veritipi>();
            //parametre olarak List verilebilir volley sorun çıkartırsa
            waterfallModel wtf =new waterfallModel();
            ft.replace(R.id.content_frame,wtf);
            ft.commit();
        }
        else if (id == R.id.iterative) {
            toolbar.setTitle("iterative Modeli");
            Toast.makeText(this, "Waterfall Fragment Çalıştı", Toast.LENGTH_SHORT).show();
            //  List<sozluk_veritipi> sozluk = new ArrayList<sozluk_veritipi>();
            //parametre olarak List verilebilir volley sorun çıkartırsa
            iterativeModel itf =new iterativeModel();
            ft.replace(R.id.content_frame,itf);
            ft.commit();
        }
        else if (id == R.id.spiral) {
            toolbar.setTitle("iterative Modeli");
            Toast.makeText(this, "Waterfall Fragment Çalıştı", Toast.LENGTH_SHORT).show();
            //  List<sozluk_veritipi> sozluk = new ArrayList<sozluk_veritipi>();
            //parametre olarak List verilebilir volley sorun çıkartırsa
            spiralModel stf =new spiralModel();
            ft.replace(R.id.content_frame,stf);
            ft.commit();
        }
        else if (id == R.id.agile) {
            toolbar.setTitle("Agile Modeli");
            Toast.makeText(this, "Waterfall Fragment Çalıştı", Toast.LENGTH_SHORT).show();
            //  List<sozluk_veritipi> sozluk = new ArrayList<sozluk_veritipi>();
            //parametre olarak List verilebilir volley sorun çıkartırsa
            agileModel atf =new agileModel();
            ft.replace(R.id.content_frame,atf);
            ft.commit();
        }
        else if (id == R.id.kelimelerim) {
            toolbar.setTitle("Kelimelerim");
            Toast.makeText(this, "kelimelerim Fragment Çalıştı", Toast.LENGTH_SHORT).show();
            //  List<sozluk_veritipi> sozluk = new ArrayList<sozluk_veritipi>();
            //parametre olarak List verilebilir volley sorun çıkartırsa
            kaydedilen_kelime ktf =new kaydedilen_kelime();
            ft.replace(R.id.content_frame,ktf);
            ft.commit();


        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
