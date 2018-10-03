package ru.yarikbur.utils;

import ru.yarikbur.obj.Obj;
import ru.yarikbur.obj.World;

public class Gravity {
	
	static final float g = 9.81523f;
	static float t = 0;
	
	public static void attraction() {
		for(Obj obj : World.getObj()) {
			if(obj.getAttraction()) {
				gravity(obj);
			}
		}
	}
	
	private static void gravity(Obj obj) {
		time();
		allFall(obj);
		if(contact(obj))
			bounce(obj);
		else
			fall(obj);
		System.out.println("Obj ID[" + obj.getId() +"]: Speed[" + obj.getSpeed()[0] + ", " + obj.getSpeed()[1] + "]" + 
			" Coordinates: [" + obj.getCoordinates()[0] + ", " + obj.getCoordinates()[1] + "]");
	}
	
	private static void time() {
		t = (Timer.getMiliLast()/1000f) + Timer.getSec() + (Timer.getMin()*60f) + (Timer.getHou()*60f*60f);
	}
	
	private static boolean contact(Obj obj) {
		for(Obj objs : World.getObj()) {
			if(objs.getId()!=obj.getId() && !objs.getAttraction()) {
				if((obj.getCoordinates()[1]-obj.getSize()[1])-(objs.getCoordinates()[1]+objs.getSize()[1]) <= 0) {
					return true;
				} else
					return false;
			}
		}
		return false;
	}
	
	private static void allFall(Obj obj) {
		for(Obj objs : World.getObj()) {
			if(objs.getId() != obj.getId()) {
				obj.setCoordinates(Vertex.vertex2d(obj.getCoordinates()[0]-obj.getSpeed()[0], obj.getCoordinates()[1]+obj.getSpeed()[1]));
			}
		}
	}
	
	private static void fall(Obj obj) {
		float speed = ((-g*obj.getWeight())/10)*t*t;
		obj.setSpeed(Vertex.vertex2d(obj.getSpeed()[0], speed));
	}
	
	private static void bounce(Obj obj) {
		float speedV0 = -(obj.getSpeed()[1]);
		float speed = speedV0-g*t;
		speed = 0;
		
		obj.setSpeed(Vertex.vertex2d(obj.getSpeed()[0], speed));
	}
}
