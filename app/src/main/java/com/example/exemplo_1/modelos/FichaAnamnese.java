package com.example.exemplo_1.modelos;

public class FichaAnamnese implements Cloneable{

    private int id_Ficha;
    private String oquevoceestasentindo;
    private String comocomecou;
    private String foirepentinoougradual;
    private String quaissintomasvoceestasentindo;

    public FichaAnamnese(){}

    public FichaAnamnese(int id_Ficha,String oquevoceestasentindo,String comocomecou,
                        String foirepentinoougradual,String quaissintomasvoceestasentindo){
        this.id_Ficha = id_Ficha;
        this.oquevoceestasentindo = oquevoceestasentindo;
        this.comocomecou = comocomecou;
        this.foirepentinoougradual = foirepentinoougradual;
        this.quaissintomasvoceestasentindo = quaissintomasvoceestasentindo;}

    public FichaAnamnese(String oquevoceestasentindo, String comocomecou, String foirepentinoougradual, String quaissintomasvoceestasentindo) {
        this.oquevoceestasentindo = oquevoceestasentindo;
        this.comocomecou = comocomecou;
        this.foirepentinoougradual = foirepentinoougradual;
        this.quaissintomasvoceestasentindo = quaissintomasvoceestasentindo;
    }

    public FichaAnamnese(FichaAnamnese fa) {
        this.id_Ficha = fa.id_Ficha;
        this.oquevoceestasentindo = fa.oquevoceestasentindo;
        this.comocomecou = fa.comocomecou;
        this.foirepentinoougradual = fa.foirepentinoougradual;
        this.quaissintomasvoceestasentindo = fa.quaissintomasvoceestasentindo;
    }


    public int getId_Ficha() {
        return this.id_Ficha;
    }

    public void setId_Ficha(int id_Ficha) {
        this.id_Ficha = id_Ficha;
    }

    public String getOquevoceestasentindo() {
        return this.oquevoceestasentindo;
    }

    public void setOquevoceestasentindo(String oquevoceestasentindo) {
        this.oquevoceestasentindo = oquevoceestasentindo;
    }

    public String getComocomecou() {
        return this.comocomecou;
    }

    public void setComocomecou(String comocomecou) {
        this.comocomecou = comocomecou;
    }

    public String getFoirepentinoougradual() {
        return this.foirepentinoougradual;
    }

    public void setFoirepentinoougradual(String foirepentinoougradual) {
        this.foirepentinoougradual = foirepentinoougradual;
    }

    public String getQuaissintomasvoceestasentindo() {
        return this.quaissintomasvoceestasentindo;
    }

    public void setQuaissintomasvoceestasentindo(String quaissintomasvoceestasentindo) {
        this.quaissintomasvoceestasentindo = quaissintomasvoceestasentindo;
    }

    @Override
    public Object clone(){
        FichaAnamnese clone = new FichaAnamnese(this);
        return clone;
    }
}
