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

	Image heroImg[][]=new Image[4][3];//4������0��ʾleft,1��ʾright,2��ʾup,3��ʾdown
	
	/*
	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];
    */
	int x,y;

	int leftFlag,rightFlag,upFlag,downFlag;
	public MainCanvas(){
	    try
	    {   
			//currentImg=Image.createImage("/sayo10.png");//��ȡͼƬsayo10.png
            
            for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
            currentImg=heroImg[3][1];

            /*
            //��
			for(int i=0;i<heroLeftImg.length;i++){
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");//"sayo"+i+""2.png ������� sayo02.png sayo12.png sayo22.png
			}
            
			leftImg=Image.createImage("/sayo12.png");
			leftImg1=Image.createImage("/sayo02.png");
			leftImg2=Image.createImage("/sayo22.png");
			
            
			//��
			for(int i=0;i<heroRightImg.length;i++){
				heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
			}
			
			rightImg=Image.createImage("/sayo16.png");
			rightImg1=Image.createImage("/sayo06.png");
			rightImg2=Image.createImage("/sayo26.png");
			

            //��
			for(int i=0;i<heroUpImg.length;i++){
				heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			}
			
			upImg=Image.createImage("/sayo14.png");
			upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");
			

            //��
			for(int i=0;i<heroDownImg.length;i++){
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			}
			
			downImg=Image.createImage("/sayo10.png");
			downImg1=Image.createImage("/sayo00.png");
			downImg2=Image.createImage("/sayo20.png");
			*/
            

			x=120;
			y=100;
			leftFlag=1;         //�л�ͼƬ�Ŀ�������
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
			System.out.println("����");
			currentImg=heroImg[0][1];
			if(x>0)
			{x=x-3;}        //��hero�ƶ�,���Ҳ���hero����
			if(leftFlag==1){
				currentImg=heroImg[0][0];
				leftFlag++;
			}
			else{
				currentImg=heroImg[0][2];
			    leftFlag=1;
			}                  //��hero�߶�������Ȼ����ͼƬ�л�
		}
		if(action==RIGHT)
		{
			currentImg=heroImg[1][0];
			System.out.println("����");
			if(x<getWidth()-20)
			{x=x+3;}
			if(rightFlag==1){
				currentImg=heroImg[1][1];
				rightFlag++;
			}
			else{
				currentImg=heroImg[1][2];
			    rightFlag=1;
			}
		}
		if(action==UP)
		{
			currentImg=heroImg[2][1];
			System.out.println("����");
			if(y>0)
			{y=y-3;}
			if(upFlag==1){
				currentImg=heroImg[2][0];
				upFlag++;
			}
			else{
				currentImg=heroImg[2][2];
			    upFlag=1;
			}
		}
		if(action==DOWN)
		{
			currentImg=heroImg[3][1];
			System.out.println("����");
			if(y<getHeight()-20)
			{y=y+3;}
			if(downFlag==1){
				currentImg=heroImg[3][0];
				downFlag++;
			}
			else{
				currentImg=heroImg[3][2];
			    downFlag=1;
			}
		}
		repaint();       //����
	}
}