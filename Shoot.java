import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by osboxes on 02/02/17.
 */
public class Shoot {

    private List<Bullet> balles = new ArrayList<>();

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

    public Shoot(int posx, int posy, int nbBalles, double angle, int frequence, int direction, boolean rotation) {
        this.posX=posx;
        this.posY=posy;
        this.angle = angle;
        this.nbBalles = nbBalles;
        this.frequence=frequence;
        this.direction = direction;
        this.rotation = rotation;
        this.compteur=0;
        ajoutBalles();
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

    public void testSpeed(){
        Bullet b1 = new Bullet(150,75,1,0);
        Bullet b2 = new Bullet(150,100,2,0);
        Bullet b3 = new Bullet(150,125,3,0);
        Bullet b4 = new Bullet(150,150,4,0);
        Bullet b5 = new Bullet(150,175,5,0);
        Bullet b6 = new Bullet(150,200,6,0);
        Bullet b7 = new Bullet(150,225,7,0);
        Bullet b8 = new Bullet(150,250,8,0);
        Bullet b9 = new Bullet(150,275,9,0);
        Bullet b10 = new Bullet(150,300,10,0);
        Bullet b11 = new Bullet(150,325,11,0);
        Bullet b12 = new Bullet(150,350,12,0);
        Bullet b13 = new Bullet(150,375,13,0);
        balles.add(b1);
        balles.add(b2);
        balles.add(b3);
        balles.add(b4);
        balles.add(b5);
        balles.add(b6);
        balles.add(b7);
        balles.add(b8);
        balles.add(b9);
        balles.add(b10);
        balles.add(b11);
        balles.add(b12);
        balles.add(b13);
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

    public void affichage(Graphics g){
        for (Bullet projectile : this.getBalles()) {
            g.setColor(Color.BLUE);
            g.fillOval((int) projectile.getPosx(), (int) projectile.getPosy(), 5, 5);
        }
        this.update();
    }

    private boolean isAlive(Bullet balle){
        boolean result = true;
        if (balle.getPosx() <= 25 || balle.getPosx() >= 675 || balle.getPosy() <= 25 || balle.getPosy() >= 575){
            result = false;
        }
        return result;
    }

    public List<Bullet> getBalles() {
        return balles;
    }

    public void setBalles(List<Bullet> balles) {
        this.balles = balles;
    }

    public int getNbBalles() {
        return nbBalles;
    }

    public void setNbBalles(int nbBalles) {
        this.nbBalles = nbBalles;
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

    public int getFrequence() {
        return frequence;
    }
    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
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

}
