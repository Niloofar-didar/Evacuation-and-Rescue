package evacuation;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Stack;
import java.util.Timer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import com.anylogic.engine.connectivity.ResultSet;
import com.anylogic.engine.connectivity.Statement;
import com.anylogic.engine.elements.*;
import com.anylogic.engine.markup.Network;
import com.anylogic.engine.Position;
import com.anylogic.engine.markup.PedFlowStatistics;
import com.anylogic.engine.markup.DensityMap;


import static java.lang.Math.*;
import static com.anylogic.engine.UtilitiesArray.*;
import static com.anylogic.engine.UtilitiesCollection.*;
import static com.anylogic.engine.presentation.UtilitiesColor.*;
import static com.anylogic.engine.HyperArray.*;

import com.anylogic.engine.*;
import com.anylogic.engine.analysis.*;
import com.anylogic.engine.connectivity.*;
import com.anylogic.engine.database.*;
import com.anylogic.engine.gis.*;
import com.anylogic.engine.markup.*;
import com.anylogic.engine.presentation.*;

import com.anylogic.libraries.pedestrian.*;
import com.anylogic.libraries.processmodeling.*;

import com.mysema.query.Tuple;
import com.mysema.query.sql.SQLBindings;
import static evacuation.DBDescriptor.*;

import javax.swing.JApplet;


 


/**
 * There is a two-storey building in this model. On the first floor, of this 24 person office building, <br>
 * the workers work and socialize.  The restroom is also located on this floor.  <br>
 * Workers typical work day consists of eight hours. <br>
 * <br>
 * On the second floor there is a cafeteria, where workers and outside customers have lunch.<br>
 * (The number of outside customers usually depends what time of day it is – there will be more during <br>
 * lunch than in the morning for breakfast)<br>
 * <br>
 * There is only one stairway between the two floors and one or two exits from the first floor.<br>
 * <br>
 * When the fire alarm is activated everyone in the building will go to one of the exits.  <br>
 * Some may not react immediately and keep working while others may freeze or panic.  <br>
 * Some may also want to get back to their tables before exiting the building. <br>
 * <br>
 * The alarm will start at the specified time or by pressing the "Fire alarm" button in the simulation window.
 */
public class Simulation extends ExperimentSimulation<Main> {
  @AnyLogicInternalCodegenAPI
  public static String[] COMMAND_LINE_ARGUMENTS_xjal = new String[0];
  {
    setCommandLineArguments_xjal( COMMAND_LINE_ARGUMENTS_xjal );
  }
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Simulation.class );
  
  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }
  // Plain Variables
  public 
MonteCarlo 
 m = 
 ;
  public 
double 
 alarmTime = 
540 ;

  // View areas
  @Override
  @AnyLogicInternalCodegenAPI
  public void drawModelElements(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -90, 570,
        10, 0,
        "m", m, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -120, 80,
        10, 0,
        "alarmTime", alarmTime, false );
    }
}
  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onClickModelAt( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, -90, 570) ){
      _panel.addInspect( -90, 570, this, "m" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -120, 80) ){
      _panel.addInspect( -120, 80, this, "alarmTime" ); 
      return true;
    }
    return false;
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _editbox_Font = _button_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = new Font("SansSerif", 0, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _textHead_Font = new Font("SansSerif", 0, 28 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text2_Font = new Font("SansSerif", 0, 14 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text3_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text4_Font = _text1_Font;
  protected static final Color _rectangle9_Fill_Color = new Color( 0xFFE6EAEF, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _button = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _editbox = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle2 = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle9 = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _line53 = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _textHead = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _groupTitleBar = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _image = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _text2 = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _text3 = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _group = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _image2 = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _text4 = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _image1 = 15;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 16;
 

  /**
   * Top-level presentation group id
   */	 
  @AnyLogicInternalCodegenAPI
  protected static final int _presentation = 0;

  /**
   * Top-level icon group id
   */	 
  @AnyLogicInternalCodegenAPI
  protected static final int _icon = -1;
  

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _text1:
        if (true) {
          ShapeText self = this.text1;
          
 
        }
        break;
      case _rectangle2:
        if (true) {
          ShapeRectangle self = this.rectangle2;
          
 
        }
        break;
      case _rectangle9:
        if (true) {
          ShapeRectangle self = this.rectangle9;
          
 
        }
        break;
      case _line53:
        if (true) {
          ShapeLine self = this.line53;
          
 
        }
        break;
      case _textHead:
        if (true) {
          ShapeText self = this.textHead;
          
 
        }
        break;
      case _groupTitleBar:
        if (true) {
          ShapeGroup self = this.groupTitleBar;
          
 
        }
        break;
      case _image:
        if (true) {
          ShapeImage self = this.image;
          
 
        }
        break;
      case _text2:
        if (true) {
          ShapeText self = this.text2;
          
 
        }
        break;
      case _text3:
        if (true) {
          ShapeText self = this.text3;
          
 
        }
        break;
      case _group:
        if (true) {
          ShapeGroup self = this.group;
          
 
        }
        break;
      case _image2:
        if (true) {
          ShapeImage self = this.image2;
          
 
        }
        break;
      case _text4:
        if (true) {
          ShapeText self = this.text4;
          
 
        }
        break;
      case _image1:
        if (true) {
          ShapeImage self = this.image1;
          
 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void onShapeGroupDraw( int _shape, int index, Panel panel, Graphics2D graphics ) {
    switch( _shape ) {
      case _groupTitleBar:
          
 
        break;
      case _group:
          
 
        break;
      default:
        super.onShapeGroupDraw( _shape, index, panel, graphics );
        break;
    }
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index ) {
    switch( _shape ) {
      case _button: {
          ShapeButton self = this.button;
if ( getState() == IDLE )
	run();
getPresentation().setPresentable( getEngine().getRoot() ); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index );
        break;
    }
  }


  @Override
  @AnyLogicInternalCodegenAPI
  public void executeShapeControlAction( int _shape, int index, String value ) {
    switch( _shape ) {
      case _editbox: {
          ShapeTextField self = this.editbox;
 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index, value );
        break;
    }
  }
        
  @Override
  @AnyLogicInternalCodegenAPI
  public String getShapeControlDefaultValueString( int _shape, int index ) {
    switch(_shape) {
      case _editbox: return 
alarmTime 
;
      default: return super.getShapeControlDefaultValueString( _shape, index );
    }
  }
  
  // Stub function for code completion support (internal)
  @AnyLogicInternalCodegenAPI
  private void _stubForReplication_xjal() {
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
    {
      int _result_xjal = 
 
;
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _button_SetDynamicParams_xjal( ShapeButton shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
    shape.setText(
getState() == IDLE ?
	"Run the model and switch to Main view" :
	"Switch to Main view" 
);
 	}
  }
  
  protected ShapeButton button;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _editbox_SetDynamicParams_xjal( ShapeTextField shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setEnabled(
true 
);
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setFillColor(
 
);
    shape.setTextColor(
 
);
    shape.setFont(
 
);
 	}
  }
  
  protected ShapeTextField editbox;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text1_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle2_SetDynamicParams_xjal( ShapeRectangle shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeRectangle rectangle2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle9_SetDynamicParams_xjal( ShapeRectangle shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeRectangle rectangle9;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line53_SetDynamicParams_xjal( ShapeLine shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setDx(
 
);
    shape.setDy(
 
);
    shape.setDz(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeLine line53;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _textHead_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText textHead;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _groupTitleBar_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
-20 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotationY(
 
);
    shape.setRotationX(
 
);
    shape.setRotationZ(
 
);
 	}
  }
  
  protected ShapeGroup groupTitleBar;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _image_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setIndex(
 
);
 	}
  }
  
  protected ShapeImage image;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text2_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text3_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text3;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _group_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setRotationY(
 
);
    shape.setRotationX(
 
);
    shape.setRotationZ(
 
);
 	}
  }
  
  protected ShapeGroup group;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _image2_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setIndex(
 
);
 	}
  }
  
  protected ShapeImage image2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text4_SetDynamicParams_xjal( ShapeText shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setColor(
 
);
    shape.setText(
 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _image1_SetDynamicParams_xjal( ShapeImage shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setRotation(
 
);
    shape.setIndex(
 
);
 	}
  }
  
  protected ShapeImage image1;
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    button = new ShapeButton(
			Simulation.this, true, 80.0, 520.0, 
			280.0, 61.0,
            controlDefault, controlDefault, true,
            _button_Font, 
			"Run the model and switch to Main view" ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _button_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _button, 0 );
      }
    };

    editbox = new ShapeTextField(
			Simulation.this, true,260.0, 460.0, 
			100.0, 21.0,
            controlDefault, controlDefault, true, _editbox_Font ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _editbox_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void action(){
        executeShapeControlAction( _editbox, 0, value );
      }

      @Override
      public void setValueToDefault() {
		setText( getShapeControlDefaultValueString( _editbox, 0 ) );
      }
    };

    text1 = new ShapeText(
        SHAPE_DRAW_2D, true,80.0, 460.0, 0.0, 0.0, 
        navy,"Alarm time (minutes): ",
        _text1_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    rectangle2 = new ShapeRectangle(
       SHAPE_DRAW_2D, true,0.0, 20.0, 0.0, 0.0, 
            null, white,
			1100.0, 45.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _rectangle2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    rectangle9 = new ShapeRectangle(
       SHAPE_DRAW_2D, true,0.0, 60.0, 0.0, 0.0, 
            null, _rectangle9_Fill_Color,
			1100.0, 6.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _rectangle9_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line53 = new ShapeLine(
		SHAPE_DRAW_2D, true, 0.0, 60.0, 0.0, navy, 
 		1100.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line53_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    textHead = new ShapeText(
        SHAPE_DRAW_2D, true,12.0, 25.0, 0.0, 0.0, 
        navy,"Evacuation model",
        _textHead_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _textHead_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    image = new ShapeImage(
		Simulation.this, SHAPE_DRAW_2D, true, -43.0, -110.0, 0.0, 0.0, 
			172.0, 210.0, "/evacuation/", 
			new String[]{"people.PNG",}	 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _image_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text2 = new ShapeText(
        SHAPE_DRAW_2D, true,60.0, 100.0, 0.0, 0.0, 
        black,"Office worker",
        _text2_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text3 = new ShapeText(
        SHAPE_DRAW_2D, true,40.0, 100.0, 0.0, 0.0, 
        black,"Cafeteria customer",
        _text3_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    image2 = new ShapeImage(
		Simulation.this, SHAPE_DRAW_2D, true, 763.0, 80.0, 0.0, 0.0, 
			217.0, 288.0, "/evacuation/", 
			new String[]{"firealarm.jpg",}	 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _image2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text4 = new ShapeText(
        SHAPE_DRAW_2D, true,80.0, 110.0, 0.0, 0.0, 
        navy,"There is a two-storey building in this model. On the first floor, of this 24 person office building, \r\nthe workers work and socialize.  The restroom is also located on this floor.  \r\nWorkers typical work day consists of eight hours. \r\n\r\nOn the second floor there is a cafeteria, where workers and outside customers have lunch.\r\n(The number of outside customers usually depends what time of day it is – there will be more during \r\nlunch than in the morning for breakfast)\r\n\r\nThere is only one stairway between the two floors and one or two exits from the first floor.\r\n\r\nWhen the fire alarm is activated everyone in the building will go to one of the exits.  \r\nSome may not react immediately and keep working while others may freeze or panic.  \r\nSome may also want to get back to their tables before exiting the building. \r\n\r\nThe alarm will start at the specified time or by pressing the \"Fire alarm\" button in the simulation window.\r\n",
        _text4_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    image1 = new ShapeImage(
		Simulation.this, SHAPE_DRAW_2D, true, 8.0, 631.0, 0.0, 0.0, 
			302.0, 59.0, "/evacuation/", 
			new String[]{"anylogic_logo.png",}	 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _image1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {				
    groupTitleBar = new ShapeGroup( Simulation.this, SHAPE_DRAW_2D, true, 0.0, -20.0, 0.0, 0.0
	
	     ,rectangle2
	     ,rectangle9
	     ,line53
	     ,textHead ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _groupTitleBar_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _groupTitleBar, 0, panel, graphics );
      }
    };

    }
    {				
    group = new ShapeGroup( Simulation.this, SHAPE_DRAW_2D, true, 760.0, 530.0, 0.0, 0.0
	
	     ,image
	     ,text2
	     ,text3 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _group_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _group, 0, panel, graphics );
      }
    };

    }
  }


  protected ShapeTopLevelPresentationGroup presentation;
  protected ShapeModelElementsGroup icon; 

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeTopLevelPresentationGroup getPresentationShape() {
    return presentation;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public ShapeModelElementsGroup getModelElementsShape() {
    return icon;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Object getPersistentShape( int _shape ) {
    switch (_shape) {
      case _presentation: return presentation;
      case _icon: return icon;
      case _button: return button;
      case _editbox: return editbox;
      case _text1: return text1;
      case _rectangle2: return rectangle2;
      case _rectangle9: return rectangle9;
      case _line53: return line53;
      case _textHead: return textHead;
      case _groupTitleBar: return groupTitleBar;
      case _image: return image;
      case _text2: return text2;
      case _text3: return text3;
      case _group: return group;
      case _image2: return image2;
      case _text4: return text4;
      case _image1: return image1;
      default: return super.getPersistentShape( _shape ); 
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOfShape_xjal( Object _shape ) {
    try {
      if ( _shape == null ) return null;
      String _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, presentation, "presentation" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, icon, "icon" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, button, "button" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, editbox, "editbox" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text1, "text1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, rectangle2, "rectangle2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, rectangle9, "rectangle9" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line53, "line53" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, textHead, "textHead" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, groupTitleBar, "groupTitleBar" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, image, "image" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text2, "text2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text3, "text3" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, group, "group" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, image2, "image2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text4, "text4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, image1, "image1" ); if (_name_xjal != null) return _name_xjal;
    } catch (Exception e) {
      return null;
    }
    return super.getNameOfShape_xjal( _shape );
  }

  @Override
  public int getWindowWidth() {
    return 1270;
  }

  @Override
  public int getWindowHeight() {
    return 910;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void onDestroy_xjal() {
    super.onDestroy_xjal();
  }

  // Additional class code
 
  // End of additional class code

  /**
   * Applet class to run experiment as java applet
   */  
  @AnyLogicInternalCodegenAPI
  public static class Applet extends JApplet {

  @AnyLogicInternalCodegenAPI
    Simulation ex;

    @Override
    public void init() {
      ex = new Simulation();
      ex.setup( this );
    }

    @Override
    public void destroy() {
      ex.close();
    }

  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void initDefaultRandomNumberGenerator(Engine _e) {
    _e.setDefaultRandomGenerator( new java.util.Random() );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Main createRoot( Engine engine ) {
    // Create the root object
    return new Main( engine, null, null );
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void setupRootParameters( final Main self, boolean callOnChangeActions ) {
    final Main root = self; // for compatibility
    double alarmTime_xjal;
    alarmTime_xjal = 
alarmTime 
;
    if (callOnChangeActions) {
      self.set_alarmTime( alarmTime_xjal );
    } else {
      self.alarmTime = alarmTime_xjal;
    }
    double visitorArrivalMultiplier_xjal;
    visitorArrivalMultiplier_xjal = 
2 
;
    if (callOnChangeActions) {
      self.set_visitorArrivalMultiplier( visitorArrivalMultiplier_xjal );
    } else {
      self.visitorArrivalMultiplier = visitorArrivalMultiplier_xjal;
    }
    boolean addExit_xjal;
    addExit_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_addExit( addExit_xjal );
    } else {
      self.addExit = addExit_xjal;
    }
    double workerArrivalRate_xjal;
    workerArrivalRate_xjal = 
40 
;
    if (callOnChangeActions) {
      self.set_workerArrivalRate( workerArrivalRate_xjal );
    } else {
      self.workerArrivalRate = workerArrivalRate_xjal;
    }
    boolean addExit1_xjal;
    addExit1_xjal = 
true 
;
    if (callOnChangeActions) {
      self.set_addExit1( addExit1_xjal );
    } else {
      self.addExit1 = addExit1_xjal;
    }
    boolean active_dynamic_xjal;
    active_dynamic_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_active_dynamic( active_dynamic_xjal );
    } else {
      self.active_dynamic = active_dynamic_xjal;
    }
    TargetLine safe_exit_xjal;
    safe_exit_xjal = 
 
;
    if (callOnChangeActions) {
      self.set_safe_exit( safe_exit_xjal );
    } else {
      self.safe_exit = safe_exit_xjal;
    }
    double newvisitorArrivalRate_xjal;
    newvisitorArrivalRate_xjal = 
6 
;
    if (callOnChangeActions) {
      self.set_newvisitorArrivalRate( newvisitorArrivalRate_xjal );
    } else {
      self.newvisitorArrivalRate = newvisitorArrivalRate_xjal;
    }
    boolean active_predict_help_xjal;
    active_predict_help_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_active_predict_help( active_predict_help_xjal );
    } else {
      self.active_predict_help = active_predict_help_xjal;
    }
    MyAgent fire_center_xjal;
    fire_center_xjal = 
 
;
    if (callOnChangeActions) {
      self.set_fire_center( fire_center_xjal );
    } else {
      self.fire_center = fire_center_xjal;
    }
    double[] dis_from_fire_xjal;
    dis_from_fire_xjal = 
new double [218]//doors + sensors 
;
    if (callOnChangeActions) {
      self.set_dis_from_fire( dis_from_fire_xjal );
    } else {
      self.dis_from_fire = dis_from_fire_xjal;
    }
    double fire_speed_xjal;
    fire_speed_xjal = 
0.026
//22 first 
;
    if (callOnChangeActions) {
      self.set_fire_speed( fire_speed_xjal );
    } else {
      self.fire_speed = fire_speed_xjal;
    }
    double now_time_xjal;
    now_time_xjal = 
0 
;
    if (callOnChangeActions) {
      self.set_now_time( now_time_xjal );
    } else {
      self.now_time = now_time_xjal;
    }
    boolean dynamic_help_xjal;
    dynamic_help_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_dynamic_help( dynamic_help_xjal );
    } else {
      self.dynamic_help = dynamic_help_xjal;
    }
    MyAgent[] connectedag2_xjal;
    connectedag2_xjal = 
new MyAgent [218]//doors + sensors 
;
    if (callOnChangeActions) {
      self.set_connectedag2( connectedag2_xjal );
    } else {
      self.connectedag2 = connectedag2_xjal;
    }
    boolean active_safest_xjal;
    active_safest_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_active_safest( active_safest_xjal );
    } else {
      self.active_safest = active_safest_xjal;
    }
    boolean static_withdoor_sensor_xjal;
    static_withdoor_sensor_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_static_withdoor_sensor( static_withdoor_sensor_xjal );
    } else {
      self.static_withdoor_sensor = static_withdoor_sensor_xjal;
    }
    boolean explosion_xjal;
    explosion_xjal = 
false//to run fire alarm 1 time 
;
    if (callOnChangeActions) {
      self.set_explosion( explosion_xjal );
    } else {
      self.explosion = explosion_xjal;
    }
    MyAgent[] floor1_agents_xjal;
    floor1_agents_xjal = 
new MyAgent [200]//doors + sensors 
;
    if (callOnChangeActions) {
      self.set_floor1_agents( floor1_agents_xjal );
    } else {
      self.floor1_agents = floor1_agents_xjal;
    }
    MyAgent[] floor2_agents_xjal;
    floor2_agents_xjal = 
new MyAgent [200]//doors + sensors 
;
    if (callOnChangeActions) {
      self.set_floor2_agents( floor2_agents_xjal );
    } else {
      self.floor2_agents = floor2_agents_xjal;
    }
    boolean a1_xjal;
    a1_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_a1( a1_xjal );
    } else {
      self.a1 = a1_xjal;
    }
    boolean a2_xjal;
    a2_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_a2( a2_xjal );
    } else {
      self.a2 = a2_xjal;
    }
    boolean a3_xjal;
    a3_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_a3( a3_xjal );
    } else {
      self.a3 = a3_xjal;
    }
    boolean a4_xjal;
    a4_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_a4( a4_xjal );
    } else {
      self.a4 = a4_xjal;
    }
    int coffee_counter_xjal;
    coffee_counter_xjal = 
0 
;
    if (callOnChangeActions) {
      self.set_coffee_counter( coffee_counter_xjal );
    } else {
      self.coffee_counter = coffee_counter_xjal;
    }
    long total_beforealarm_xjal;
    total_beforealarm_xjal = 
1 
;
    if (callOnChangeActions) {
      self.set_total_beforealarm( total_beforealarm_xjal );
    } else {
      self.total_beforealarm = total_beforealarm_xjal;
    }
    boolean as1_xjal;
    as1_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_as1( as1_xjal );
    } else {
      self.as1 = as1_xjal;
    }
    boolean as3_2_xjal;
    as3_2_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_as3_2( as3_2_xjal );
    } else {
      self.as3_2 = as3_2_xjal;
    }
    boolean a3_4_xjal;
    a3_4_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_a3_4( a3_4_xjal );
    } else {
      self.a3_4 = a3_4_xjal;
    }
    boolean a1_1_xjal;
    a1_1_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_a1_1( a1_1_xjal );
    } else {
      self.a1_1 = a1_1_xjal;
    }
    boolean a3_2_xjal;
    a3_2_xjal = 
false 
;
    if (callOnChangeActions) {
      self.set_a3_2( a3_2_xjal );
    } else {
      self.a3_2 = a3_2_xjal;
    }
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void onBeforeSimulationRun( Main root ) {
    // Before simulation run code
    
 
  }


  /**
   * Engine setup
   */
  @Override
  @AnyLogicInternalCodegenAPI
  public void setupEngine(Engine engine) {
    engine.setATOL( 1.0E-5 );
    engine.setRTOL( 1.0E-5 );
    engine.setTTOL( 1.0E-5 );
    engine.setHTOL( 0.001 );
    engine.setSolverODE( Engine.SOLVER_ODE_EULER );
    engine.setSolverNAE( Engine.SOLVER_NAE_MODIFIED_NEWTON );
    engine.setSolverDAE( Engine.SOLVER_DAE_RK45_NEWTON );
    engine.setVMethods( 427029 );
    engine.setSimultaneousEventsSelectionMode( Engine.EVENT_SELECTION_LIFO );

    engine.setStartTime( 0.0 );
    engine.setTimeUnit( MINUTE );
    engine.setStartDate( toDate( 2012, JULY, 23, 8, 0, 0 ) );
    engine.setStopDate( toDate( 2012, JULY, 23, 22, 0, 0 ) );
    engine.setRealTimeMode( true );
    engine.setRealTimeScale( 1.0 );
  }

  /**
   * Experiment setup
   */
  @Override
  @AnyLogicInternalCodegenAPI
  public void setup( java.awt.Container container ) {
    setName( "Evacuation : Simulation" );
    Presentation _p = new Presentation( this, container instanceof JApplet ? Presentation.MODE_APPLET :
    	container != null ? Presentation.MODE_COMPONENT :
        Presentation.MODE_APPLICATION, container );

    // Static initialization of persistent elements
    _createPersistentElementsBP0_xjal();

    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation = new ShapeTopLevelPresentationGroup( Simulation.this, true, 0, 0, 0, 0 , text1, groupTitleBar, group, image2, text4, image1, button, editbox );
    icon = new ShapeModelElementsGroup( Simulation.this, getElementProperty( "evacuation.Simulation.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    // Setup presentation
    _p.start();
    _p.setMaximized( true );

    Panel _panel = _p.getPanel();
    ToolBar _tb = _p.getToolBar();
    StatusBar _sb = _p.getStatusBar();

    _p.setZoomAndPanningEnabled( false );
    _panel.setFrameManagementBalance( 2.0 );

    _sb.setSectionVisible( StatusBar.DATE, false );
    _sb.setSectionVisible( StatusBar.EPS, false );
    _sb.setSectionVisible( StatusBar.EXPERIMENT, false );
    _sb.setSectionVisible( StatusBar.FPS, false );
    _sb.setSectionVisible( StatusBar.MEMORY, true );
    _sb.setSectionVisible( StatusBar.SECONDS, false );
    _sb.setSectionVisible( StatusBar.SIMULATION, true );
    _sb.setSectionVisible( StatusBar.STATUS, true );
    _sb.setSectionVisible( StatusBar.STEP, false );
    _sb.setSectionVisible( StatusBar.TIME, true );
    _tb.setSectionVisible( ToolBar.ANIMATION, false );
    _tb.setSectionVisible( ToolBar.EXECUTION, true );
    _tb.setSectionVisible( ToolBar.FILE, false );
    _tb.setSectionVisible( ToolBar.NAVIGATION, true );
    _tb.setSectionVisible( ToolBar.TIME_SCALE, true );
    _tb.setSectionVisible( ToolBar.VIEW, false );
    editbox.setValueToDefault();
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onEngineFinished() {
    final Main root = (Main) getEngine().getRoot();
    // After simulation run code

 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void reset() {
    
 
  }

}
