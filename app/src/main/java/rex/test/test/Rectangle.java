package rex.test.test;

/**
 * Created by Rex on 13-Feb-2018.
 */

public class Rectangle {
    Point m_TopLeft;
    Point m_BottomRight;

    public Rectangle(Point topLeft, Point bottomRight)
    {
        this.m_TopLeft = topLeft;
        this.m_BottomRight= bottomRight;
    }

    public Point getM_TopLeft()
    {
        return m_TopLeft;
    }

    public Point getM_BottomRight()
    {
        return m_BottomRight;
    }
    public void translate(Point newm_TopLeft)
    {
        int vecX= newm_TopLeft.getM_X() - m_TopLeft.getM_X();
        int vecY= newm_TopLeft.getM_Y() - m_TopLeft.getM_Y();

        m_TopLeft=newm_TopLeft;
        m_BottomRight = new Point(m_BottomRight.getM_X() + vecX,m_BottomRight.getM_Y() + vecY);
    }
}
