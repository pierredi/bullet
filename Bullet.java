/**
 * Created by osboxes on 30/01/17.
 */
public class Bullet {

    private double speed;
    private double posx;
    private double posy;
    private double direction;
    private boolean alive;

    public Bullet (int x, int y, double speed, double direction){
        this.posx=x;
        this.posy=y;
        this.speed = speed;
        this.direction = direction;
        this.alive = true;
    }

    public void update(){
        setPosx((getPosx()+ speed * Math.cos(Math.toRadians(direction))));
        setPosy((getPosy()+ speed * Math.sin(Math.toRadians(direction))));
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getPosx() {
        return posx;
    }

    public void setPosx(double posx) {
        this.posx = posx;
    }

    public double getPosy() {
        return posy;
    }

    public void setPosy(double posy) {
        this.posy = posy;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
