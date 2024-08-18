package _05_Pixel_Art;

import java.io.Serializable;

public class SaveState implements Serializable{
	private int windowWidth;
    private int windowHeight;
    private int rows;
    private int cols;
    private Pixel[][] pixels;
	
	public SaveState(int w, int h, int r, int c, Pixel[][] pixels) {
		this.windowWidth = w;
		this.windowHeight = h;
		this.rows = r;
		this.cols = c;
		this.pixels = pixels;
		
		
		
		
	}
	
	public int getWindowHeight() {
		
		return this.windowHeight;
	}public int getWindowWidth() {
		
		return this.windowWidth;
	}public int getRows() {
		
		return this.rows;
	}public int getCols() {
		
		return this.cols;
	}
	public Pixel[][] getPixels(){
		
		return this.pixels;
	}
}
