public class Planet{
	public double xxPos = 0;
	public double yyPos = 0;
	public double xxVel = 0;
	public double yyVel = 0;
	public double mass = 0;
	public String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		double dist;
		dist=Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos)+(yyPos-p.yyPos)*(yyPos-p.yyPos));
		return dist;
	}

	public double calcForceExertedBy(Planet p){
		double dist=this.calcDistance(p);
		double G=6.67*Math.pow(10,-11);
		double F=G*mass*p.mass/Math.pow(dist,2);
		return F;
	}

	public double calcForceExertedByX(Planet p){
		double F=this.calcForceExertedBy(p);
		double dist=this.calcDistance(p);
		double Fx=F*(p.xxPos-xxPos)/dist;
		return Fx;
	}

	public double calcForceExertedByY(Planet p){
		double F=this.calcForceExertedBy(p);
		double dist=this.calcDistance(p);
		double Fy=F*(p.yyPos-yyPos)/dist;
		return Fy;

	}

	
	public double calcNetForceExertedByX(Planet[] p){
		double FxNet = 0;
		double fx = 0;
		for(int i=0; i<p.length; i++){
			if(this.equals(p[i])){
				continue;
			}
		
			fx = this.calcForceExertedByX(p[i]);
			FxNet += fx;
		
		}

		return FxNet;
	}

	public double calcNetForceExertedByY(Planet[] p){
		double FyNet = 0;
		double fy = 0;
		for(int i=0; i<p.length; i++){
			if(this.equals(p[i])){
				continue;
			}
			fy = this.calcForceExertedByY(p[i]);
			FyNet += fy;
		}

		return FyNet;
	}
	public void update(double dt, double fX, double fY){
		double accX=fX/mass;
		double accY=fY/mass;
		xxVel=xxVel+dt*accX;
		 yyVel=yyVel+dt*accY;
		 xxPos=xxPos+dt*xxVel;
		 yyPos=yyPos+dt*yyVel;
	}
	public void draw(){
		String imgPath = "./images/";
		imgPath += imgFileName;

		StdDraw.picture(xxPos, yyPos, imgPath);
	}
}

