package fr.utbm.vi51.project.eurock.GUI.Graphics.Layout;
import fr.utbm.vi51.project.eurock.GUI.Graphics.IComponent;


/**
 * 
 */
public interface ILayout<C extends IComponent> {



    /**
     * @param AbstractComponent c 
     */
    public void addComponent(C c);

    /**
     * @param AbstractComponent c 
     * @param int x 
     * @param int y
     */
    public void moveComponent(C c, int x, int y);

    /**
     * @param AbstractComponent c
     */
    public void delete(C c);
    public void flush();

}