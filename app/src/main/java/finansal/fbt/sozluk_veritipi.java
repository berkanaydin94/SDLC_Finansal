package finansal.fbt;



public class sozluk_veritipi {
    private String kelime;
    private String aciklama;

    public sozluk_veritipi(String aciklama, String kelime) {
        this.aciklama = aciklama;
        this.kelime = kelime;
    }



    public String getKelime() {
        return kelime;
    }

    public void setKelime(String kelime) {
        this.kelime = kelime;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}
