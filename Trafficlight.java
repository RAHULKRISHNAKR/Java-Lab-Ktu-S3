/*
The algorithm is for a simple traffic light simulator. It creates three radio buttons, one for each color of the traffic light. The user can select a color to display on the traffic light. The algorithm also includes a paintComponent method that draws the traffic light on the screen.

The algorithm works as follows:

The algorithm first creates a new instance of the light class. This class contains all of the code for the traffic light.
The light constructor creates a new JPanel window and sets its properties.
The constructor then creates three radio buttons, one for each color of the traffic light.
The constructor then adds the radio buttons to the JPanel window.
The constructor then sets the visibility of the JPanel window to true.
The actionPerformed method is called whenever a radio button is selected.
The actionPerformed method first checks to see which radio button was selected.
If the red radio button was selected, the method sets the red_c variable to Color.red. The yellow_c and green_c variables are set to the background color of the JPanel window.
If the yellow radio button was selected, the method sets the yellow_c variable to Color.yellow. The red_c and green_c variables are set to the background color of the JPanel window.
If the green radio button was selected, the method sets the green_c variable to Color.green. The red_c and yellow_c variables are set to the background color of the JPanel window.
The repaint method is then called to redraw the traffic light.
The paintComponent method is called whenever the JPanel window needs to be redrawn.
The paintComponent method first draws three circles on the JPanel window, one for each color of the traffic light.
The method then sets the color of the circles to the values of the red_c, yellow_c, and green_c variables.
The method then fills the circles with color
*/import javax.swing.*;
 import java.awt.*; 
 import java.awt.event.*;
class light extends JPanel implements ActionListener
{
private JRadioButton r1; private JRadioButton r2; private JRadioButton r3;

private Color red_c; private Color yellow_c; private Color green_c;

public light()
{
setBounds(0,0,640,480);
r1 = new JRadioButton("Red");
r2 = new JRadioButton("Yellow"); r3 = new JRadioButton("Green");

r1.setSelected(true); // to get red selected as default red_c = Color.red;
yellow_c = getBackground(); green_c = getBackground();

ButtonGroup gp = new ButtonGroup();

gp.add(r1);
gp.add(r2);
gp.add(r3);

add(r1);
add(r2);
add(r3);

r1.addActionListener(this); r2.addActionListener(this); r3.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(r1.isSelected() == true)
{
red_c = Color.red;
yellow_c = getBackground(); green_c = getBackground();
}
else if(r2.isSelected() == true)
{
red_c = getBackground(); yellow_c = Color.yellow; green_c = getBackground();
}
else if(r3.isSelected() == true)
{
red_c = getBackground(); yellow_c = getBackground(); green_c = Color.green;
}
repaint();
}

public void paintComponent(Graphics g)
{
super.paintComponent(g); g.drawOval(50,50,50,50); g.drawOval(50,110,50,50); g.drawOval(50,170,50,50);

g.setColor(red_c); g.fillOval(50,50,50,50); g.setColor(yellow_c); g.fillOval(50,110,50,50); g.setColor(green_c); g.fillOval(50,170,50,50);
}
}
public class Trafficlight
{
public static void main(String args[])
{
JFrame f = new JFrame(); f.setVisible(true); f.setSize(640,480); f.setLayout(null);
light t = new light(); f.add(t);
}
}
