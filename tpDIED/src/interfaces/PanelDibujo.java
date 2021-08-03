package interfaces;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;

import dominio.Estacion;
import estructuras.Grafo;
import estructuras.Ruta;
import estructuras.Vertice;

public class PanelDibujo extends JPanel {
 
 
 private ArrayList<Integer> xvs;
 private ArrayList<Integer> yvs;

private List<Ruta<Estacion>> agrafos;
private List<Estacion> vgrafos;
private Color Color;
 int indice=0;

 

public PanelDibujo(){
  vgrafos=new ArrayList<>();
  setAgrafos(new ArrayList<>());
  xvs=new ArrayList<Integer>();
  yvs=new ArrayList<Integer>();
  setDoubleBuffered(true);
 }
 
 public void paintComponent(Graphics grafico){
	 Integer x=270;
	 Integer y=0;
	 if(vgrafos.size()>5) {
	 y = 16*vgrafos.size();}
	 else {
	 y=60*vgrafos.size();
	 }
	 Integer ancho=50;
	 Integer alto=50;
  super.paintComponents(grafico);
  Graphics2D g=(Graphics2D)grafico;
  if(vgrafos.size()!=0){
   g.setColor(Color.WHITE);
   g.fillRect(0, 0, getWidth(), getHeight());
   g.setColor(Color.BLACK);
   int radio=0;
   if(vgrafos.size()>5) {
   radio = 16*vgrafos.size();}
   else {
	   radio=60*vgrafos.size();
   }
   float angulo = 360/10;
   angulo = (float) Math.toRadians(angulo);
   for(int i=indice;i<vgrafos.size();i++){
    int xv=(int)(x+radio*Math.cos(i * angulo));
    int yv=(int) (y- radio * Math.sin(i * angulo));
    xvs.add(xv);
    yvs.add(yv);
    indice++;
   }
  }
  ArrayList<Integer> indexi=new ArrayList<Integer>();
  ArrayList<Integer> indexj=new ArrayList<Integer>();
  for(int i=0;i<vgrafos.size();i++){
   for(int j=0;j<vgrafos.size();j++){
    g.setStroke(new BasicStroke(2));
  
    
  g.setColor(Color);
  
   
  
  if(Grafo.getInstance().rutaEntreDosEstaciones(new Vertice(vgrafos.get(i)), new Vertice(vgrafos.get(j)))!=null) {
	  g.drawLine(xvs.get(i)+15,yvs.get(i)+15,xvs.get(j)+15,yvs.get(j)+15);
  }
	  
	  g.setColor(Color.WHITE);
    g.fillOval(xvs.get(i), yvs.get(i), ancho, alto);
    g.setColor(Color.BLACK);
    g.drawOval(xvs.get(i),yvs.get(i), ancho, alto);
    g.drawString(""+vgrafos.get(i), xvs.get(i)+((ancho/2)-20), yvs.get(i)+((alto/2)+3));
    g.setColor(Color.WHITE);
    g.fillOval(xvs.get(j), yvs.get(j), ancho, alto);
    g.setColor(Color.BLACK);
    g.drawOval(xvs.get(j),yvs.get(j), ancho, alto);
    
  g.drawString(""+vgrafos.get(j), xvs.get(j)+((ancho/2)-20), yvs.get(j)+((alto/2)+3));
   }
  }
 /* for(int w=0;w<vgrafosaux.size();w++) {
  for(int i=0;i<vgrafos.size();i++){
	   for(int j=0;j<vgrafos.size();j++){
		  
			   System.out.printf(" "+vgrafos.get(j),vgrafos.get(i),vgrafosaux.get(w)+"//////");
			   if(vgrafosaux.size()!=0 && vgrafos.get(j)==vgrafos.get(i) && vgrafos.get(j)==vgrafosaux.get(w)) {
			  
	   g.setColor(Color);
		    g.drawLine(xvs.get(i)+22,yvs.get(i)+22,xvs.get(j)+22,yvs.get(j)+22);
		   }
	   }
	   
 }} */
 }
 
  
 public List<Estacion> getVgrafos() {
  return vgrafos;
 }
 public void setVgrafos(List<Estacion> vertices) {
  this.vgrafos = vertices;
 }

public void setColor(List<Ruta<Estacion>> verticeaux, Color c) {
	this.Color=c;
	this.agrafos=verticeaux;
}

public List<Ruta<Estacion>> getAgrafos() {
	return agrafos;
}

public void setAgrafos(List<Ruta<Estacion>> agrafos) {
	this.agrafos = agrafos;
}
}