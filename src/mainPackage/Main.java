package mainPackage;
import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFW;

import engine.io.*;

public class Main implements Runnable{

public Thread game;
public static CustomWindow window;
public final static int width = 1280, height = 720;
	
	public void start() {
		game = new Thread(this, "game");
		game.start();
	}
	
	public void init() { //used to init
		//System.out.println("Initializing Game!");
		window = new CustomWindow(width,height,"Java Game v0.01");
		window.create();
	}
	
	public void run() {
		init();
		while (!window.shouldClose()) {
			update();
			render();
			if (Input.isKeyDown(GLFW.GLFW_KEY_ESCAPE)) return; //exit game if escape(Move to another script later 
		} 
	}
	
	private void update() {
		//System.out.println("Updating Game!");
		window.update();
		
		//input stuff
		if (Input.isMButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) System.out.println("X: " + Input.getMouseX() + ", Y: " + Input.getMouseY()); //Debug delete later 

	}
	
	private void render() {
		//System.out.println("Rendering Game!");
		window.swapBuffers();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (!glfwInit())
		{
			throw new IllegalStateException("Failed to initialize GLFW!");
		} else {
			System.out.println(org.lwjgl.Version.getVersion());
		}
		

		
		new Main().start(); //this starts the update 
	}

}
