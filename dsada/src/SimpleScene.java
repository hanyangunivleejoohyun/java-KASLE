package dsada;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.fixedfunc.GLLightingFunc;
import com.jogamp.opengl.fixedfunc.GLMatrixFunc;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.util.Animator;
import com.leapmotion.leap.Bone;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.FingerList;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Vector;

public class SimpleScene implements GLEventListener{

	private int w=444;//default if not fullscree
	private int h=268;
	
	public Controller c;
	
	public void init(GLAutoDrawable drawable) {
		GL gl=drawable.getGL();
		this.c=new Controller();	
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
	}

	public void dispose(GLAutoDrawable drawable) {
	}
	
	void renderCylinder(float x1, float y1, float z1, float x2,float y2, float z2, float radius,int subdivisions,GL gl,GLUquadric quadric)
	{
		float vx = x2-x1;
		float vy = y2-y1;
		float vz = z2-z1;

		GLU glu=new GLU();
		//handle the degenerate case of z1 == z2 with an approximation
		if(vz == 0)
			vz = .0001f;

		float v = (float) Math.sqrt( vx*vx + vy*vy + vz*vz );
		float ax = (float) (57.2957795*Math.acos( vz/v ));
		if ( vz < 0.0 )
			ax = -ax;
		float rx = -vy*vz;
		float ry = vx*vz;
		((GLMatrixFunc)gl).glPushMatrix();

		//draw the cylinder body
		((GLMatrixFunc)gl).glTranslatef( x1,y1,z1 );
		((GLMatrixFunc)gl).glRotatef(ax, rx, ry, 0.0f);
		glu.gluQuadricOrientation(quadric,glu.GLU_OUTSIDE);
		glu.gluCylinder(quadric, radius, radius, v, subdivisions, 1);

		//draw the first cap
		glu.gluQuadricOrientation(quadric,glu.GLU_INSIDE);
		glu.gluDisk( quadric, 0.0, radius, subdivisions, 1);
		((GLMatrixFunc)gl).glTranslatef( 0,0,v );

		//draw the second cap
		glu.gluQuadricOrientation(quadric,glu.GLU_OUTSIDE);
		glu.gluDisk( quadric, 0.0, radius, subdivisions, 1);
		((GLMatrixFunc)gl).glPopMatrix();
	}
	
	void renderCylinder_convenient(GL gl,Vector v1,Vector v2, float radius,int subdivisions)
	{
	//the same quadric can be re-used for drawing many cylinders
		GLU glu=new GLU();
		GLUquadric quadric=glu.gluNewQuadric();
		glu.gluQuadricNormals(quadric,GLU.GLU_SMOOTH);
		renderCylinder(v1.getX(),v1.getY(),v1.getZ(),v2.getX(),v2.getY(),v2.getZ(),radius,subdivisions,gl,quadric);
		glu.gluDeleteQuadric(quadric);
	}
	
	public void DrawFinger(GL4 gl,Finger f,Hand h)
	{
		GLMatrixFunc glm=((GLMatrixFunc) gl);
		GLU glu=new GLU();
		
		Bone tipBone=f.bone(Bone.Type.TYPE_DISTAL);
		Bone pipBone=f.bone(Bone.Type.TYPE_INTERMEDIATE);
		Bone dipBone=f.bone(Bone.Type.TYPE_PROXIMAL);
		Bone mcpBone=f.bone(Bone.Type.TYPE_METACARPAL);
		
		Vector tippos=tipBone.nextJoint().minus(h.palmPosition());
		Vector pippos=pipBone.nextJoint().minus(h.palmPosition());
		Vector dippos=dipBone.nextJoint().minus(h.palmPosition());
		Vector mcppos=mcpBone.nextJoint().minus(h.palmPosition());		
		Vector mcppos2=mcpBone.prevJoint().minus(h.palmPosition());
		Vector wrist=h.wristPosition().minus(h.palmPosition());
		
		doLighting((GL2)gl,1f,1f,1f);
		renderCylinder_convenient(gl,tippos,pippos,4f,20);
		renderCylinder_convenient(gl,pippos,dippos,4f,20);
		renderCylinder_convenient(gl,dippos,mcppos,4f,20);
		
		if(f.type()==Finger.Type.TYPE_THUMB) 
			renderCylinder_convenient(gl,mcppos2,mcppos,4f,20);
		else if(f.type()==Finger.Type.TYPE_INDEX) 
		{
			renderCylinder_convenient(gl,mcppos,h.fingers().fingerType(Finger.Type.TYPE_THUMB).get(0).bone(Bone.Type.TYPE_METACARPAL).prevJoint().minus(h.palmPosition()),4f,20);
			renderCylinder_convenient(gl,mcppos,h.fingers().fingerType(Finger.Type.TYPE_MIDDLE).get(0).bone(Bone.Type.TYPE_METACARPAL).nextJoint().minus(h.palmPosition()),4f,20);
		}
		else if(f.type()==Finger.Type.TYPE_MIDDLE) 
			renderCylinder_convenient(gl,mcppos,h.fingers().fingerType(Finger.Type.TYPE_RING).get(0).bone(Bone.Type.TYPE_METACARPAL).nextJoint().minus(h.palmPosition()),4f,20);
		else if(f.type()==Finger.Type.TYPE_RING) 
			renderCylinder_convenient(gl,mcppos,h.fingers().fingerType(Finger.Type.TYPE_PINKY).get(0).bone(Bone.Type.TYPE_METACARPAL).nextJoint().minus(h.palmPosition()),4f,20);
		else if(f.type()==Finger.Type.TYPE_PINKY) 
		{
			renderCylinder_convenient(gl,mcppos,mcppos2,4f,20);
			renderCylinder_convenient(gl,mcppos2,h.fingers().fingerType(Finger.Type.TYPE_THUMB).get(0).bone(Bone.Type.TYPE_METACARPAL).prevJoint().minus(h.palmPosition()),4f,20);
			doLighting((GL2)gl,1f,1f,0f);
			glm.glPushMatrix();
			glm.glTranslatef(mcppos2.getX(),mcppos2.getY(),mcppos2.getZ());
			glu.gluSphere(glu.gluNewQuadric(),6d,10,10);
			glm.glPopMatrix();
		}
		doLighting((GL2)gl,1f,1f,0f);
		glm.glPushMatrix();
		glm.glTranslatef(tippos.getX(),tippos.getY(),tippos.getZ());
		glu.gluSphere(glu.gluNewQuadric(),6d,10,10);
		glm.glPopMatrix();
		
		glm.glPushMatrix();
		glm.glTranslatef(pippos.getX(),pippos.getY(),pippos.getZ());
		glu.gluSphere(glu.gluNewQuadric(),6d,10,10);
		glm.glPopMatrix();
		
		glm.glPushMatrix();
		glm.glTranslatef(dippos.getX(),dippos.getY(),dippos.getZ());
		glu.gluSphere(glu.gluNewQuadric(),6d,10,10);
		glm.glPopMatrix();
		
		glm.glPushMatrix();
		glm.glTranslatef(mcppos.getX(),mcppos.getY(),mcppos.getZ());
		glu.gluSphere(glu.gluNewQuadric(),6d,10,10);
		glm.glPopMatrix();
		
	}
	
	public void DrawHand(GL4 gl,Hand h)
	{
		FingerList fl=h.fingers();
		Vector hpos=h.palmPosition();
		GLMatrixFunc glm=((GLMatrixFunc) gl);
		GLU glu=new GLU();
		
		glm.glPushMatrix();
		//glm.glMultMatrixf(h.basis().toArray4x4(),0);
		//glm.glTranslatef(hpos.getX(), hpos.getY(), hpos.getZ());
		glu.gluSphere(glu.gluNewQuadric(),6d,10,10);
		DrawFinger(gl,fl.fingerType(Finger.Type.TYPE_INDEX).get(0),h);
		DrawFinger(gl,fl.fingerType(Finger.Type.TYPE_MIDDLE).get(0),h);
		DrawFinger(gl,fl.fingerType(Finger.Type.TYPE_PINKY).get(0),h);
		DrawFinger(gl,fl.fingerType(Finger.Type.TYPE_RING).get(0),h);
		DrawFinger(gl,fl.fingerType(Finger.Type.TYPE_THUMB).get(0),h);
		glm.glPopMatrix();
	}

	private void doLighting( GL2 gl ,float a,float b,float c)
	 {
		 float lightpos[]=new float[4];
	     lightpos[0] = 50005;
	     lightpos[1] = 30000;
	     lightpos[2] = 50000;
	     lightpos[3] = 1;
	     gl.glEnable(GLLightingFunc.GL_LIGHTING);
	     gl.glEnable(GLLightingFunc.GL_LIGHT0);
	     
	     float[] noAmbient ={ a, b, c, 1f }; // low ambient light
	     float[] spec =    { 0.5f, 0.6f, 0.5f, 1f }; // low ambient light
	     float[] diffuse ={ 0.5f, 0.5f, 0.5f, 1f };
	     
	     gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_AMBIENT, noAmbient, 0);
	     //gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_SPECULAR, spec, 0);
	     //gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_DIFFUSE, diffuse, 0);
	     //gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_POSITION, lightpos, 0);
	 }
	
	public void display(GLAutoDrawable drawable) {
		GL4 gl=drawable.getGL().getGL4();
		GLU glu=new GLU();
		
		gl.glClear(GL.GL_COLOR_BUFFER_BIT|GL.GL_DEPTH_BUFFER_BIT);
		((GLMatrixFunc) gl).glLoadIdentity();
	
		glu.gluLookAt(0,0, 170, 0,0, 0, 0, 1, 0);	
		((GLMatrixFunc) gl).glPushMatrix();
		if(c.frame().hands().get(0).isValid())
		DrawHand(gl,c.frame().hands().get(0));
		((GLMatrixFunc) gl).glPopMatrix();
		gl.glFlush();
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GL gl=drawable.getGL();
		GLU glu=new GLU();
		
		gl.glViewport(0,0, w, h);
		((GLMatrixFunc) gl).glMatrixMode(GLMatrixFunc.GL_PROJECTION);  
		((GLMatrixFunc) gl).glLoadIdentity();
		glu.gluPerspective(80.0f, (float)1, 0.1f, 700f);
		((GLMatrixFunc) gl).glMatrixMode(GLMatrixFunc.GL_MODELVIEW);  
		((GLMatrixFunc) gl).glLoadIdentity();
	}
}