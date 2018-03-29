/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author FLEXICSSS
 */
public class ProfilSportif {
    
    private int codePs;
    private String taille;
    private String hanche;
    private String cuisse;
    private String bras;
    private String poitrine;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.codePs;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProfilSportif other = (ProfilSportif) obj;
        if (this.codePs != other.codePs) {
            return false;
        }
        return true;
    }

    public ProfilSportif() {
    }
    

    /**
     * 
     * @param codePs
     * @param taille
     * @param hanche
     * @param cuisse
     * @param bras
     * @param poitrine 
     */
    public ProfilSportif(int codePs, String taille, String hanche, String cuisse, String bras, String poitrine) {
        this.codePs = codePs;
        this.taille = taille;
        this.hanche = hanche;
        this.cuisse = cuisse;
        this.bras = bras;
        this.poitrine = poitrine;
    }

    public ProfilSportif(String taille, String hanche, String cuisse, String bras, String poitrine) {
        this.taille = taille;
        this.hanche = hanche;
        this.cuisse = cuisse;
        this.bras = bras;
        this.poitrine = poitrine;
    }
    
    

    public int getCodePs() {
        return codePs;
    }

    public void setCodePs(int codePs) {
        this.codePs = codePs;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getHanche() {
        return hanche;
    }

    public void setHanche(String hanche) {
        this.hanche = hanche;
    }

    public String getCuisse() {
        return cuisse;
    }

    public void setCuisse(String cuisse) {
        this.cuisse = cuisse;
    }

    public String getBras() {
        return bras;
    }

    public void setBras(String bras) {
        this.bras = bras;
    }

    public String getPoitrine() {
        return poitrine;
    }

    public void setPoitrine(String poitrine) {
        this.poitrine = poitrine;
    }
    
    
    
}
