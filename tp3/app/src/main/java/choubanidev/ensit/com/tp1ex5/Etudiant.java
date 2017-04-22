package choubanidev.ensit.com.tp1ex5;



public class Etudiant {
    private String option;
    private  String nom;
    private  String email;
    private int abs;
    private String avatar;


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNom() {
        return nom;
    }

    public String getOption() {

        return option;
    }

    public String getEmail() {
        return email;
    }

    public int getAbs() {
        return abs;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAbs(int abs) {
        this.abs = abs;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public    Etudiant(String option, String nom, String email, int abs, String avatar)
    {
        this.nom=nom;
        this.email=email;
        this.abs=abs;
        this.option=option;
        this.avatar=avatar;
    }
}
