package com.mygdx.game.AppStates;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.Basics.AssetLoader;


public class PauseState extends State
{
    private StateManager m_sm;
    private Stage m_stage;
    private TextureAtlas m_icons;
    private Skin m_skin;
    private BitmapFont m_font;
    private ImageButton m_return, m_restart, m_mainMenu;
    private Table m_labelTable, m_buttonTable, m_rootTable;
    private Label m_header;

    private TextureRegion m_background;

    public PauseState(StateManager sm)
    {
        super(sm);
        m_sm = sm;

        Skin m_skin;
        Label.LabelStyle m_headerSkin;

        //Assets
        m_font = AssetLoader.slackeyfont;
        m_background = AssetLoader.black;
        m_skin = AssetLoader.buttonSkin;

        //Create stage
        m_stage = new Stage(new StretchViewport(m_config.m_worldW, m_config.m_worldH));

        //Tables
        m_labelTable = new Table();
        m_rootTable = new Table();
        m_buttonTable = new Table();

        //Labels
        m_headerSkin = new Label.LabelStyle(m_font, Color.WHITE);
        m_header = new Label("PAUSED", m_headerSkin);

        //Buttons
        m_return = new ImageButton(m_skin.getDrawable("play"));
        m_restart = new ImageButton(m_skin.getDrawable("restart"));
        m_mainMenu = new ImageButton(m_skin.getDrawable("home"));

        fillStage();
        setupClickListeners();
        Gdx.input.setInputProcessor(m_stage);
    }

    private void fillStage()
    {
        float buttonSize = 150f;
        float buttonPad = 10f;
        m_rootTable.setFillParent(true);

        m_header.setFontScale(0.7f);

        m_labelTable.add(m_header);

        m_buttonTable.add(m_restart).size(buttonSize).pad(buttonPad);
        m_buttonTable.add(m_return).size(buttonSize).pad(buttonPad);
        m_buttonTable.add(m_mainMenu).size(buttonSize).pad(buttonPad);

        m_rootTable.add(m_labelTable);
        m_rootTable.row();
        m_rootTable.add(m_buttonTable);

        m_stage.addActor(m_rootTable);
    }

    private void setupClickListeners()
    {
        m_return.addListener(new ChangeListener()
        {
            @Override
            public void changed(ChangeEvent event, Actor actor)
            {
                m_sm.pop();
            }
        });
        m_mainMenu.addListener(new ChangeListener()
        {
            @Override
            public void changed(ChangeEvent event, Actor actor)
            {
                m_sm.set(new MenuState(m_sm));
            }
        });
        m_restart.addListener(new ChangeListener()
        {
            @Override
            public void changed(ChangeEvent event, Actor actor)
            {
                m_sm.set(new PlayState(m_sm, m_config.getCurrentLevel()));
            }
        });
    }

    @Override
    public void update(float dt)
    {

    }

    @Override
    public void render(SpriteBatch sr)
    {
        Batch temp = m_stage.getBatch();
        temp.begin();
        temp.setColor(0, 0, 0, 0.5f);
        temp.draw(m_background, 0, 0);
        temp.end();
        m_stage.draw();
    }

    @Override
    public void handleInput()
    {

    }

    @Override
    public void dispose()
    {
        m_stage.dispose();
    }

    @Override
    public void resize(int width, int height)
    {
        
    }
}
