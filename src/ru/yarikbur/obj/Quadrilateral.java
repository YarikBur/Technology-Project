package ru.yarikbur.obj;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Quadrilateral extends Properties{
	public Quadrilateral(float[] coordinates, float[] size, float weight, boolean attraction, float bounce, float color) {
		this.setSize(size);
		this.setCoordinates(coordinates);
		this.setWeight(weight);
		this.setAttraction(attraction);
		this.setColor(color);
	}
	
	public void render() {
		glBegin(GL_QUADS);
			glColor3f((this.getColor()/255), (this.getColor()/255), (this.getColor()/255));
			glVertex2f(this.getCoordinates()[0], this.getCoordinates()[1]);
			glVertex2f(this.getCoordinates()[0], this.getCoordinates()[1]+this.getSize()[1]);
			glVertex2f(this.getCoordinates()[0]+this.getSize()[0], this.getCoordinates()[1]+this.getSize()[1]);
			glVertex2f(this.getCoordinates()[0]+this.getSize()[0], this.getCoordinates()[1]);
		glEnd();
	}
}
