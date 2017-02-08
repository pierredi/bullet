import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by osboxes on 06/02/17.
 */
abstract public class TirMissile {

    private List<Bullet> balles = new ArrayList<Bullet>();

    private double direction;
    private double angle;
    private int posX;
    private int posY;
    private int nbBalles;
    private boolean rotation;
    private int frequence;
    private int compteur=0;
    private double spin = 10 ;
    private double maxSpin=15;
    private double minSpin=1;
    private boolean wave;
    private Color colorShoot=Color.black;


    public void init(int posx, int posy, int nbBalles, double angle, int frequence, int direction,
                     boolean rotation, double minSpin, double maxSpin) {
        this.setPosX(posx);
        this.setPosY(posy);
        this.setAngle(angle);
        this.setNbBalles(nbBalles);
        this.setFrequence(frequence);
        this.setDirection(direction);
        this.setRotation(rotation);
        this.setCompteur(0);
        this.setMinSpin(minSpin);
        this.setMaxSpin(maxSpin);
        this.setWave(false);
    }

    public void init(int posx, int posy, int nbBalles, double angle, int frequence, int direction,
                     boolean rotation, double minSpin, double maxSpin, boolean wave) {
        this.setPosX(posx);
        this.setPosY(posy);
        this.setAngle(angle);
        this.setNbBalles(nbBalles);
        this.setFrequence(frequence);
        this.setDirection(direction-angle/2);
        this.setRotation(rotation);
        this.setCompteur(0);
        this.setMinSpin(minSpin);
        this.setMaxSpin(maxSpin);
        this.setWave(wave);
    }

    public void ajoutBalles(){
        double angleBase = 0.0d;
        if(nbBalles>1){
            angleBase = angle / (nbBalles-1);
        }

        for (int cpt = 0; cpt<nbBalles; cpt++){
            Bullet proj = new Bullet(this.posX,this.posY,4, direction - angle/2 + cpt * angleBase);
            balles.add(proj);
        }
    }

    public boolean isAlive(Bullet balle){
        boolean result = true;
        if (balle.getPosx() <= 10 || balle.getPosx() >= 790 || balle.getPosy() <= 10 || balle.getPosy() >= 590){
            result = false;
        }
        return result;
    }

    public void affichage(Graphics g){
        for (Bullet projectile : this.getBalles()) {
            projectile.affichage(g, isWave(), getColorShoot());
        }
        this.update();
    }

    public void update(){
        compteur++;
        Iterator<Bullet> iter = getBalles().iterator();
        while(iter.hasNext()){
            Bullet courant = iter.next();
            courant.update();
            if (!isAlive(courant)){
                iter.remove();
            }
        }
        if(compteur%getFrequence()==0){
           ajoutBalles();
        }
    }

    public List<Bullet> getBalles() {
        return balles;
    }

    public void setBalles(List<Bullet> balles) {
        this.balles = balles;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getNbBalles() {
        return nbBalles;
    }

    public void setNbBalles(int nbBalles) {
        this.nbBalles = nbBalles;
    }

    public boolean isRotation() {
        return rotation;
    }

    public void setRotation(boolean rotation) {
        this.rotation = rotation;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }

    public double getSpin() {
        return spin;
    }

    public void setSpin(double spin) {
        this.spin = spin;
    }
    public double getMaxSpin() {
        return maxSpin;
    }

    public void setMaxSpin(double maxSpin) {
        this.maxSpin = maxSpin;
    }

    public double getMinSpin() {
        return minSpin;
    }

    public void setMinSpin(double minSpin) {
        this.minSpin = minSpin;
    }

    public boolean isWave() {
        return wave;
    }

    public void setWave(boolean wave) {
        this.wave = wave;
    }

    public Color getColorShoot() {
        return colorShoot;
    }

    public void setColorShoot(Color colorShoot) {
        this.colorShoot = colorShoot;
    }
}
