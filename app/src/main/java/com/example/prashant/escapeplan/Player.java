package com.example.prashant.escapeplan;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
<<<<<<< HEAD
import org.andengine.extension.physics.box2d.util.constants.PhysicsConstants;
=======
>>>>>>> f6f9f549ce7812406a6877db3a59086a367c4432
import org.andengine.opengl.vbo.VertexBufferObjectManager;

/**
 * Created by prashant on 28/12/14.
 */
public abstract class Player extends AnimatedSprite {
    private Body body;
    private boolean canRun = false;
    private int footContacts = 0;
<<<<<<< HEAD
    private float ybound;

=======
>>>>>>> f6f9f549ce7812406a6877db3a59086a367c4432
    public Player(float pX, float pY, VertexBufferObjectManager vbo, Camera camera, PhysicsWorld physicsWorld)
    {
        super(pX, pY, ResourcesManager.getInstance().player_region, vbo);
        createPhysics(camera, physicsWorld);
        camera.setChaseEntity(this);
    }
    public abstract void onDie();

    private void createPhysics(final Camera camera, PhysicsWorld physicsWorld)
    {
        body = PhysicsFactory.createBoxBody(physicsWorld, this, BodyDef.BodyType.DynamicBody, PhysicsFactory.createFixtureDef(0, 0, 0));

        body.setUserData("player");
        body.setFixedRotation(true);
<<<<<<< HEAD
        ybound=camera.getHeight();
=======
>>>>>>> f6f9f549ce7812406a6877db3a59086a367c4432

        physicsWorld.registerPhysicsConnector(new PhysicsConnector(this, body, true, false)
        {
            @Override
            public void onUpdate(float pSecondsElapsed)
            {
                super.onUpdate(pSecondsElapsed);
                camera.onUpdate(0.1f);

                if (getY() <= 0)
                {
                    onDie();
                }

                if (canRun)
                {
                    body.setLinearVelocity(new Vector2(5, body.getLinearVelocity().y));
                }
            }
        });
    }
    public void setRunning()
    {
        canRun = true;

        final long[] PLAYER_ANIMATE = new long[] { 100, 100, 100 };

        animate(PLAYER_ANIMATE, 0, 2, true);
    }
    public void jump()
    {
        if (footContacts < 1)
        {
            return;
        }
        body.setLinearVelocity(new Vector2(body.getLinearVelocity().x, 12));
    }

    public void increaseFootContacts()
    {
<<<<<<< HEAD

        footContacts++;


=======
        footContacts++;
>>>>>>> f6f9f549ce7812406a6877db3a59086a367c4432
    }

    public void decreaseFootContacts()
    {
        footContacts--;
    }


}
