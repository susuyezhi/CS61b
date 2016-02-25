public class NBody{
    public static String imageToDraw="./images/starfield.jpg";
     public static void main (String[] args){

    	double T,delta_t;
    	String filename;

    	T=Double.parseDouble(args[0]);
    	delta_t=Double.parseDouble(args[1]);
    	filename=args[2];

    	double radius=readRadius(filename);

    	Planet[] planets=readPlanets(filename);

    	double[] forcexArray=new double[planets.length];
    	double[] forceyArray=new double[planets.length];

    	StdDraw.setScale(-radius,radius);
    	StdDraw.clear();

    	for(double time=0;time<=T;time+=delta_t){
    		for(int i=0; i<planets.length;i++){
    			forcexArray[i]=planets[i].calcNetForceExertedByX(planets);
    			forceyArray[i]=planets[i].calcNetForceExertedByY(planets);

    		}
    		StdDraw.picture(0,0,imageToDraw);

    		for(int i=0; i<planets.length;i++){
    			planets[i].draw();
    			planets[i].update(delta_t,forcexArray[i],forceyArray[i]);

    		}
    		StdDraw.show(10);
    	}
    	StdOut.printf("%d\n", planets.length);
			StdOut.printf("%.2e\n", radius);
			for (int i = 0; i < planets.length; i++) {
				StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
   				planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);	
			}



    }



    public static double readRadius(String path){

    	In in =new In(path);
    	double radius=-1;
    	double num=0;
    	int line=0;

    	while(!in.isEmpty()){
    		line++;
    		if(line==1){
    			num=in.readDouble();
    			continue;

    		}
    		radius=in.readDouble();
    		break;
    	}

    	return radius;

    }

    public static Planet[] readPlanets(String path){
    	In in=new In(path);

    	int num=0;
    	double radius=0;
    	int line=0;

    	num=in.readInt();
    	Planet[] planetArray=new Planet [num];

    	radius=in.readDouble();

    	while(line<num){

    		double xxpos=in.readDouble();
    		double yypos=in.readDouble();
    		double xxvel=in.readDouble();
    		double yyvel=in.readDouble();
    		double mass=in.readDouble();
    		String imgFileName=in.readString();

    		planetArray[line++]=new Planet(xxpos,yypos,xxvel,yyvel,mass,imgFileName);
    	}
    	return planetArray;
    }


   
}