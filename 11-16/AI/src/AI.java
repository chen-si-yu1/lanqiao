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
	Image  currentImg,downImg,downImg1,downImg2,leftImg,leftImg1,leftImg2,rightImg,rightImg1,rightImg2,upImg,upImg1,upImg2;
	int x,y;
	int leftFlag;
	public MainCanvas(){
	    try
	    {   
			currentImg=Image.createImage("/sayo10.png");//获取图片sayo10.png

			downImg=Image.createImage("/sayo10.png");
			downImg1=Image.createImage("/sayo00.png");
			downImg2=Image.createImage("/sayo20.png");

            leftImg=Image.createImage("/sayo12.png");
			leftImg1=Image.createImage("/sayo02.png");
			leftImg2=Image.createImage("/sayo22.png");

			rightImg=Image.createImage("/sayo16.png");
			rightImg1=Image.createImage("/sayo06.png");
			rightImg2=Image.createImage("/sayo26.png");

			upImg=Image.createImage("/sayo14.png");
			upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");

			x=120;
			y=100;
			leftFlag=1;         //切换图片的控制条件
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
			if(x>0)
			{x=x-3;}          //让hero移动,并且不让hero出界
			if(leftFlag==1){
				currentImg=leftImg1;
				leftFlag++;
			}
			else{
				currentImg=leftImg2;
			    leftFlag=1;
			}                  //让hero走动更加自然，即图片切换
		}
		if(action==RIGHT)
		{
			currentImg=rightImg;
			System.out.println("向右");
			if(x<getWidth()-20)
			{x=x+3;}
			if(leftFlag==1){
				currentImg=rightImg1;
				leftFlag++;
			}
			else{
				currentImg=rightImg2;
			    leftFlag=1;
			}
		}
		if(action==UP)
		{
			currentImg=upImg;
			System.out.println("向上");
			if(y>0)
			{y=y-3;}
			if(leftFlag==1){
				currentImg=upImg1;
				leftFlag++;
			}
			else{
				currentImg=upImg2;
			    leftFlag=1;
			}
		}
		if(action==DOWN)
		{
			currentImg=downImg;
			System.out.println("向下");
			if(y<getHeight()-20)
			{y=y+3;}
			if(leftFlag==1){
				currentImg=downImg1;
				leftFlag++;
			}
			else{
				currentImg=downImg2;
			    leftFlag=1;
			}
		}
		repaint();       //更新
	}
}