package com.example.projetcle;

public class Utilisateur {

    private int id;

    private String pseudo;

    private String mdp;

    private String Droit;

    public Utilisateur(int lid,String lepseudo, String lemdp,String leDroit){
        this.id = lid;
        this.pseudo = lepseudo;
        this.mdp = lemdp;
        this.Droit = leDroit;
    }

    public int getId(){
        return id;
    }
    public String getPseudo(){
        return pseudo;
    }
    public String getMdp(){
        return mdp;
    }
    public String getDroit(){
        return Droit;
    }

    public void setId(int lid){
        this.id = lid;
    }
    public void setPseudo(String lepseudo){
        this.pseudo = lepseudo;
    }
    public void setMdp(String lemdp){
        this.mdp = lemdp;
    }
    public void setDroit(String leDroit){
        this.Droit = leDroit;
    }

}

