import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image  currentImg,downImg,leftImg,rightImg,upImg;
	int x,y;
	public MainCanvas(){
	    try
	    {   
			currentImg=Image.createImage("/sayo10.png");
			downImg=Image.createImage("/sayo10.png");
            leftImg=Image.createImage("/sayo12.png");
			rightImg=Image.createImage("/sayo16.png");
			upImg=Image.createImage("/sayo14.png");
			x=120;
			y=100;
	    }
	    catch (IOException e)
	    {
			e.printStackTrace();
	    }
	
   }
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode)
	{
		int action=getGameAction(keyCode);

		if(action==LEFT)
		{
			System.out.println("向左");
			currentImg=leftImg;
			x=x-1;
		}
		if(action==RIGHT)
		{
			currentImg=rightImg;
			System.out.println("向右");
			x=x+1;
		}
		if(action==UP)
		{
			currentImg=upImg;
			System.out.println("向上");
			y=y-1;
		}
		if(action==DOWN)
		{
			currentImg=downImg;
			System.out.println("向下");
			y=y+1;
			
		}
		repaint();
	}
}