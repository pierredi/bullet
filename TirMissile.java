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
    private double spin = 3 ;
    private boolean horaire = true;
    private boolean accelere = true;
    private double maxSpin=15;
    private double minSpin=1;
    private Color colorShoot;

    public void init(int posx, int posy, int nbBalles, double angle, int frequence, int direction,
                     boolean rotation, double minSpin, double maxSpin, Color couleur) {
        this.setPosX(posx);
        this.setPosY(posy);
        this.setAngle(angle);
        this.setNbBalles(nbBalles);
        this.setFrequence(frequence);
        this.setDirection(direction);
        this.setRotation(rotation);
        this.setColorShoot(couleur);
        this.setCompteur(0);
        this.setMinSpin(minSpin);
        this.setMaxSpin(maxSpin);
    }

    public void ajoutBalles(){
        double angleBase = angle / (nbBalles+1d);
        double angleInit = angleBase;
        for (int cpt = 0; cpt<nbBalles; cpt++){
            Bullet proj = new Bullet(this.posX,this.posY,6, direction + angleInit);
            balles.add(proj);
            angleInit +=angleBase;
        }
    }

    private void updateRotation(){
        if(horaire){
            setDirection(direction + spin);
        } else {
            setDirection(direction - spin);
        }
        if (accelere){
            setSpin(1.91d*spin);
        } else {
            setSpin(0.8d * spin);
        }
        if (spin > maxSpin){
            accelere=false;
        }
        if (spin < minSpin){
            accelere=true;
            horaire = !horaire;
        }
    }

    private boolean isAlive(Bullet balle){
        boolean result = true;
        if (balle.getPosx() <= 25 || balle.getPosx() >= 675 || balle.getPosy() <= 25 || balle.getPosy() >= 575){
            result = false;
        }
        return result;
    }

    public void affichage(Graphics g){
        for (Bullet projectile : this.getBalles()) {
            g.setColor(colorShoot);
            g.fillOval((int) projectile.getPosx(), (int) projectile.getPosy(), 8, 8);
        }
        this.update();
    }

    public void update(){
        compteur++;
        Iterator<Bullet> iter = balles.iterator();
        while(iter.hasNext()){
            Bullet courant = iter.next();
            courant.update();
            if (!isAlive(courant)){
                iter.remove();
            }
        }
        if(compteur%frequence==0){
            if(this.rotation){
                updateRotation();
            }
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

    public boolean isHoraire() {
        return horaire;
    }

    public void setHoraire(boolean horaire) {
        this.horaire = horaire;
    }

    public boolean isAccelere() {
        return accelere;
    }

    public void setAccelere(boolean accelere) {
        this.accelere = accelere;
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

    public Color getColorShoot() {
        return colorShoot;
    }

    public void setColorShoot(Color colorShoot) {
        this.colorShoot = colorShoot;
    }
}
