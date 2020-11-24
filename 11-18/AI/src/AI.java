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
	//Image  currentImg,downImg,downImg1,downImg2,leftImg,leftImg1,leftImg2,rightImg,rightImg1,rightImg2,upImg,upImg1,upImg2;
    Image currentImg;
	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];

	int x,y;

	int leftFlag,rightFlag,upFlag,downFlag;
	public MainCanvas(){
	    try
	    {   
			currentImg=Image.createImage("/sayo10.png");//获取图片sayo10.png

            
			for(int i=0;i<heroLeftImg.length;i++){
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");//"/sayo"+i+""2.png 输出等于 sayo02.png sayo12.png sayo22.png
				heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");//注意  "/sayo"一定不能少了“/”
				heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			}
            /*
			leftImg=Image.createImage("/sayo12.png");
			leftImg1=Image.createImage("/sayo02.png");
			leftImg2=Image.createImage("/sayo22.png");
			
			rightImg=Image.createImage("/sayo16.png");
			rightImg1=Image.createImage("/sayo06.png");
			rightImg2=Image.createImage("/sayo26.png");

			upImg=Image.createImage("/sayo14.png");
			upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");

			downImg=Image.createImage("/sayo10.png");
			downImg1=Image.createImage("/sayo00.png");
			downImg2=Image.createImage("/sayo20.png");
			*/


			x=120;
			y=100;
			leftFlag=1;         //切换图片的控制条件
			rightFlag=1;
			upFlag=1;
			downFlag=1;
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
			currentImg=heroLeftImg[1];
			if(x>0)
			{x=x-3;}        //让hero移动,并且不让hero出界
			if(leftFlag==1){
				currentImg=heroLeftImg[0];
				leftFlag++;
			}
			else{
				currentImg=heroLeftImg[2];
			    leftFlag=1;
			}                  //让hero走动更加自然，即图片切换
		}
		if(action==RIGHT)
		{
			currentImg=heroRightImg[1];
			System.out.println("向右");
			if(x<getWidth()-20)
			{x=x+3;}
			if(rightFlag==1){
				currentImg=heroRightImg[0];
				rightFlag++;
			}
			else{
				currentImg=heroRightImg[2];
			    rightFlag=1;
			}
		}
		if(action==UP)
		{
			currentImg=heroUpImg[1];
			System.out.println("向上");
			if(y>0)
			{y=y-3;}
			if(upFlag==1){
				currentImg=heroUpImg[0];
				upFlag++;
			}
			else{
				currentImg=heroUpImg[2];
			    upFlag=1;
			}
		}
		if(action==DOWN)
		{
			currentImg=heroDownImg[1];
			System.out.println("向下");
			if(y<getHeight()-20)
			{y=y+3;}
			if(downFlag==1){
				currentImg=heroDownImg[0];
				downFlag++;
			}
			else{
				currentImg=heroDownImg[2];
			    downFlag=1;
			}
		}
		repaint();       //更新
	}
}