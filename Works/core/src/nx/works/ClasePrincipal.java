package nx.works;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.glass.events.KeyEvent;

public class ClasePrincipal extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img[] = new Texture[32], image[][] = new Texture[5][32];
	Texture cloud[] = new Texture[2];
	Texture castle;
	Texture man[] = new Texture[6];
	int ex1=0, ex2=300;
	
	@Override
	public void create () {
		
		batch = new SpriteBatch();
		cloud[0] = new Texture("cloud.png");
		cloud[1] = new Texture("cloud.png");
		castle = new Texture("castle.png");
		for (int i = 0; i <5; i++){
			man[i] = new Texture("1.png");
			for (int j = 0; j <32; j++){
				if (i==0)
					img[j] = new Texture("monte.png");
				image[i][j] = new Texture("base.png");
			}
		}
	}

	@Override
	public void render () {
		int x=0, y=0;
		int ex=20, ey = 10;
		Gdx.gl.glClearColor(0, 150, 255, 100);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for (int i = 0; i <5; i++){
			for (int j = 0; j <32; j++){
				if (i==0)
					batch.draw(img[j], x, 50);
				batch.draw(image[i][j], x, y);
				x+=ex;
			}
			x=0;
			y+=ey;
		}
		batch.draw(cloud[0], ex1, 400, 150, 50);
		batch.draw(cloud[1], ex2, 250, 150, 50);
		batch.draw(castle, 455, 50, 200, 200);
		batch.end();
		
		if (ex1>600)
			ex1=0;
		else
			ex1++;
		
		if (ex2>600)
			ex2=0;
		else
			ex2++;
		
	}
	
}
