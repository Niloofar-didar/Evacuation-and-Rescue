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


 


public class MonteCarlo extends ExperimentParamVariation<Main> {
  @AnyLogicInternalCodegenAPI
  public static String[] COMMAND_LINE_ARGUMENTS_xjal = new String[0];
  {
    setCommandLineArguments_xjal( COMMAND_LINE_ARGUMENTS_xjal );
  }
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( MonteCarlo.class );
  
  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }
  // Plain Variables
  public 
int 
 page = 
1 ;

  // Analysis Data Elements
  public HistogramSimpleData histogram0_data = new HistogramSimpleData( 20, 
0 
, 
15 
, false, false, 0.1, 0.1, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( HistogramData _d ) {
      if ( getNumberOfCompletedIterations() == _lastUpdateX ) { return; }
      _d.add( _histogram0_data_Value() );
      _lastUpdateX = getNumberOfCompletedIterations();
    }
  } );
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _histogram0_data_Value() {
    return 
 
;
  }
  
  public HistogramSimpleData histogram1_data = new HistogramSimpleData( 20, 
0 
, 
15 
, false, false, 0.1, 0.1, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( HistogramData _d ) {
      if ( getNumberOfCompletedIterations() == _lastUpdateX ) { return; }
      _d.add( _histogram1_data_Value() );
      _lastUpdateX = getNumberOfCompletedIterations();
    }
  } );
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _histogram1_data_Value() {
    return 
 
;
  }
  
  @AnyLogicInternalCodegenAPI
  protected static double[] _histogram2d0_data_envelopes = new double[] {0.25, 0.5, 0.75, };
  public Histogram2DData histogram2d0_data = new Histogram2DData( 8, 
0 
, 
480 
, 20, 
0 
, 
10 
, _histogram2d0_data_envelopes, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( Histogram2DData _d ) {
      if ( getNumberOfCompletedIterations() == _lastUpdateX ) { return; }
      _d.add( _histogram2d0_data_XValue(), _histogram2d0_data_YValue() );
      _lastUpdateX = getNumberOfCompletedIterations();
    }
  } );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _histogram2d0_data_XValue() {
    return 
 
;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _histogram2d0_data_YValue() {
    return 
 
;
  }
  
  @AnyLogicInternalCodegenAPI
  protected static double[] _histogram2d1_data_envelopes = new double[] {0.25, 0.5, 0.75, };
  public Histogram2DData histogram2d1_data = new Histogram2DData( 8, 
0 
, 
480 
, 20, 
0 
, 
10 
, _histogram2d1_data_envelopes, new DataUpdater_xjal() {
    double _lastUpdateX = Double.NaN;
    @Override
    public void update( Histogram2DData _d ) {
      if ( getNumberOfCompletedIterations() == _lastUpdateX ) { return; }
      _d.add( _histogram2d1_data_XValue(), _histogram2d1_data_YValue() );
      _lastUpdateX = getNumberOfCompletedIterations();
    }
  } );

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _histogram2d1_data_XValue() {
    return 
 
;
  }

  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private double _histogram2d1_data_YValue() {
    return 
 
;
  }
  
  // View areas
  @Override
  @AnyLogicInternalCodegenAPI
  public void drawModelElements(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -120, 60,
        10, 0,
        "page", page, false );
    }
    if (!_publicOnly) {
      drawHistogramData( _panel, _g, -320, 220, 15, 0, "histogram0_data", histogram0_data );
    }
    if (!_publicOnly) {
      drawHistogramData( _panel, _g, -320, 540, 15, 0, "histogram1_data", histogram1_data );
    }
}
  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onClickModelAt( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, -120, 60) ){
      _panel.addInspect( -120, 60, this, "page" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -320, 220) ){
      _panel.addInspect( -320, 220, this, "histogram0_data" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -320, 540) ){
      _panel.addInspect( -320, 540, this, "histogram1_data" ); 
      return true;
    }
    return false;
  }
  @AnyLogicInternalCodegenAPI
  protected static final Font _button_Font = new Font("Dialog", 0, 11 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text_Font = new Font("Serif", 1, 28 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text1_Font = new Font("Serif", 2, 16 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text2_Font = new Font("SansSerif", 0, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text3_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text4_Font = new Font("SansSerif", 1, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final Font _text5_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text6_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text7_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text8_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text9_Font = _text4_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text12_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text13_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text10_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final Font _text11_Font = _text2_Font;
  @AnyLogicInternalCodegenAPI
  protected static final int _button = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _text = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _text1 = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _text2 = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _text3 = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _text4 = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _line = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _text5 = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _text6 = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _text7 = 10;
  @AnyLogicInternalCodegenAPI
  protected static final int _text8 = 11;
  @AnyLogicInternalCodegenAPI
  protected static final int _text9 = 12;
  @AnyLogicInternalCodegenAPI
  protected static final int _line1 = 13;
  @AnyLogicInternalCodegenAPI
  protected static final int _text12 = 14;
  @AnyLogicInternalCodegenAPI
  protected static final int _text13 = 15;
  @AnyLogicInternalCodegenAPI
  protected static final int _groupSec = 16;
  @AnyLogicInternalCodegenAPI
  protected static final int _text10 = 17;
  @AnyLogicInternalCodegenAPI
  protected static final int _text11 = 18;
  @AnyLogicInternalCodegenAPI
  protected static final int _groupFir = 19;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline = 20;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline1 = 21;
  @AnyLogicInternalCodegenAPI
  protected static final int _image1 = 22;
  @AnyLogicInternalCodegenAPI
  protected static final int _histogram2d0 = 23;
  @AnyLogicInternalCodegenAPI
  protected static final int _histogram2d1 = 24;
  @AnyLogicInternalCodegenAPI
  protected static final int _histogram0 = 25;
  @AnyLogicInternalCodegenAPI
  protected static final int _histogram1 = 26;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 27;
 

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
  
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_pointsDX_xjal() {
    return new double[] { 0.0, 0.0, 40.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_pointsDY_xjal() {
    return new double[] { 0.0, 40.0, 20.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline1_pointsDX_xjal() {
    return new double[] { 0.0, 0.0, -40.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline1_pointsDY_xjal() {
    return new double[] { 0.0, 40.0, 20.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline1_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0,  };
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _text:
        if (true) {
          ShapeText self = this.text;
          
 
        }
        break;
      case _text1:
        if (true) {
          ShapeText self = this.text1;
          
 
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
      case _text4:
        if (true) {
          ShapeText self = this.text4;
          
 
        }
        break;
      case _line:
        if (true) {
          ShapeLine self = this.line;
          
 
        }
        break;
      case _text5:
        if (true) {
          ShapeText self = this.text5;
          
 
        }
        break;
      case _text6:
        if (true) {
          ShapeText self = this.text6;
          
 
        }
        break;
      case _text7:
        if (true) {
          ShapeText self = this.text7;
          
 
        }
        break;
      case _text8:
        if (true) {
          ShapeText self = this.text8;
          
 
        }
        break;
      case _text9:
        if (true) {
          ShapeText self = this.text9;
          
 
        }
        break;
      case _line1:
        if (true) {
          ShapeLine self = this.line1;
          
 
        }
        break;
      case _text12:
        if (true) {
          ShapeText self = this.text12;
          
 
        }
        break;
      case _text13:
        if (true) {
          ShapeText self = this.text13;
          
 
        }
        break;
      case _groupSec:
        if (true) {
          ShapeGroup self = this.groupSec;
          
 
        }
        break;
      case _text10:
        if (true) {
          ShapeText self = this.text10;
          
 
        }
        break;
      case _text11:
        if (true) {
          ShapeText self = this.text11;
          
 
        }
        break;
      case _groupFir:
        if (true) {
          ShapeGroup self = this.groupFir;
          
 
        }
        break;
      case _polyline:
        if (true) {
          ShapePolyLine self = this.polyline;
          
page++; 
        }
        break;
      case _polyline1:
        if (true) {
          ShapePolyLine self = this.polyline1;
          
page--; 
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
      case _groupSec:
          
 
        break;
      case _groupFir:
          
 
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
run(); 
;}
        break;
      default:
        super.executeShapeControlAction( _shape, index );
        break;
    }
  }
 
  @Override
  @AnyLogicInternalCodegenAPI
  public void onSelectionChanged_xjal( int _shape, int index, int[] selectedIndices, boolean programmatically ) {
    switch( _shape ) {
      case _histogram2d0: {
        Histogram2D self = this.histogram2d0;
        
 
;}
        break;
      case _histogram2d1: {
        Histogram2D self = this.histogram2d1;
        
 
;}
        break;
      case _histogram0: {
        Histogram self = this.histogram0;
        
 
;}
        break;
      case _histogram1: {
        Histogram self = this.histogram1;
        
 
;}
        break;
      default:
        super.onSelectionChanged_xjal( _shape, index, selectedIndices, programmatically );
        break;
    }
  }

 
  @Override
  @AnyLogicInternalCodegenAPI
  public void onItemRemoved_xjal( int _shape, int index, int removedIndex, boolean programmatically ) {
    switch( _shape ) {
      case _histogram2d0: {
        Histogram2D self = this.histogram2d0;
        
 
;}
        break;
      case _histogram2d1: {
        Histogram2D self = this.histogram2d1;
        
 
;}
        break;
      case _histogram0: {
        Histogram self = this.histogram0;
        
 
;}
        break;
      case _histogram1: {
        Histogram self = this.histogram1;
        
 
;}
        break;
      default:
        super.onItemRemoved_xjal( _shape, index, removedIndex, programmatically );
        break;
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
getState() == IDLE 
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
 
);
 	}
  }
  
  protected ShapeButton button;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _histogram2d0_SetDynamicParams_xjal( Histogram2D shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
 	}
  }
  
  protected Histogram2D histogram2d0;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _histogram2d1_SetDynamicParams_xjal( Histogram2D shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
 	}
  }
  
  protected Histogram2D histogram2d1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _histogram0_SetDynamicParams_xjal( Histogram shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
 	}
  }
  
  protected Histogram histogram0;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _histogram1_SetDynamicParams_xjal( Histogram shape ) {
    boolean _visible = 
 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setWidth(
 
);
    shape.setHeight(
 
);
 	}
  }
  
  protected Histogram histogram1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text_SetDynamicParams_xjal( ShapeText shape ) {
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
  
  protected ShapeText text;
  
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
getCurrentIteration() 
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
  private void _line_SetDynamicParams_xjal( ShapeLine shape ) {
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
  
  protected ShapeLine line;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text5_SetDynamicParams_xjal( ShapeText shape ) {
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
  
  protected ShapeText text5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text6_SetDynamicParams_xjal( ShapeText shape ) {
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
format( alarmTime ) 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text7_SetDynamicParams_xjal( ShapeText shape ) {
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
  
  protected ShapeText text7;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text8_SetDynamicParams_xjal( ShapeText shape ) {
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
format( addExit ) 
);
    shape.setFont(
 
);
    shape.setAlignment(
 
);
 	}
  }
  
  protected ShapeText text8;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text9_SetDynamicParams_xjal( ShapeText shape ) {
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
  
  protected ShapeText text9;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _line1_SetDynamicParams_xjal( ShapeLine shape ) {
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
  
  protected ShapeLine line1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text12_SetDynamicParams_xjal( ShapeText shape ) {
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
  
  protected ShapeText text12;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text13_SetDynamicParams_xjal( ShapeText shape ) {
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
  
  protected ShapeText text13;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _groupSec_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
page == 2  
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
280 
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
  
  protected ShapeGroup groupSec;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text10_SetDynamicParams_xjal( ShapeText shape ) {
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
  
  protected ShapeText text10;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text11_SetDynamicParams_xjal( ShapeText shape ) {
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
  
  protected ShapeText text11;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _groupFir_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
page == 1  
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
  
  protected ShapeGroup groupFir;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline_SetDynamicParams_xjal( ShapePolyLine shape ) {
    boolean _visible = 
page == 1  
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
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
    shape.setNPoints(
 
);
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDx( indexPt, 
 
);
     }
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDy( indexPt, 
 
);
    }
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDz( indexPt, 
 
);
    }
 	}
  }
  
  protected ShapePolyLine polyline;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline1_SetDynamicParams_xjal( ShapePolyLine shape ) {
    boolean _visible = 
page == 2  
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
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
    shape.setNPoints(
 
);
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDx( indexPt, 
 
);
     }
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDy( indexPt, 
 
);
    }
    for (int indexPt = 0; indexPt < shape.getNPoints(); indexPt++) {
      shape.setPointDz( indexPt, 
 
);
    }
 	}
  }
  
  protected ShapePolyLine polyline1;
  
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
			MonteCarlo.this, true, 20.0, 80.0, 
			100.0, 30.0,
            controlDefault, controlDefault, true,
            _button_Font, 
			"Run" ) {
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

    text = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 20.0, 0.0, 0.0, 
        black,"Evacuation : Monte Carlo",
        _text_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text1 = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 50.0, 0.0, 0.0, 
        black,"Monte Carlo Experiment",
        _text1_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text2 = new ShapeText(
        SHAPE_DRAW_2D, true,400.0, 90.0, 0.0, 0.0, 
        black,"Number of runs:",
        _text2_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text3 = new ShapeText(
        SHAPE_DRAW_2D, true,620.0, 90.0, 0.0, 0.0, 
        darkSlateBlue,"?",
        _text3_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text3_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text4 = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 120.0, 0.0, 0.0, 
        black,"Varied Parameters",
        _text4_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line = new ShapeLine(
		SHAPE_DRAW_2D, true, 130.0, 130.0, 0.0, black, 
 		650.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text5 = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 140.0, 0.0, 0.0, 
        black,"alarmTime",
        _text5_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text6 = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 140.0, 0.0, 0.0, 
        darkSlateBlue,"?",
        _text6_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text6_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text7 = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 160.0, 0.0, 0.0, 
        black,"addExit",
        _text7_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text7_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text8 = new ShapeText(
        SHAPE_DRAW_2D, true,240.0, 160.0, 0.0, 0.0, 
        darkSlateBlue,"?",
        _text8_Font, ALIGNMENT_RIGHT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text8_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text9 = new ShapeText(
        SHAPE_DRAW_2D, true,20.0, 180.0, 0.0, 0.0, 
        black,"Charts",
        _text9_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text9_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line1 = new ShapeLine(
		SHAPE_DRAW_2D, true, 70.0, 190.0, 0.0, black, 
 		710.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text12 = new ShapeText(
        SHAPE_DRAW_2D, true,-257.0, -216.0, 0.0, 0.0, 
        darkBlue,"Duration of the evacuation on alarm time (2 exits)",
        _text12_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text12_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text13 = new ShapeText(
        SHAPE_DRAW_2D, true,-257.0, 0.0, 0.0, 0.0, 
        darkBlue,"Duration of the evacuation on alarm time (1 exit)",
        _text13_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text13_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text10 = new ShapeText(
        SHAPE_DRAW_2D, true,-257.0, -216.0, 0.0, 0.0, 
        darkBlue,"Total duration of the evacuation (2 exits)",
        _text10_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text10_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text11 = new ShapeText(
        SHAPE_DRAW_2D, true,-257.0, 0.0, 0.0, 0.0, 
        darkBlue,"Total duration of the evacuation (1 exit)",
        _text11_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text11_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline = new ShapePolyLine(
		SHAPE_DRAW_2D, true, 740.0, 640.0, 0.0, black, white,
            4, _polyline_pointsDX_xjal(), _polyline_pointsDY_xjal(), _polyline_pointsDZ_xjal(), false, 10.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _polyline, 0, clickx, clicky );
      }
    };

    polyline1 = new ShapePolyLine(
		SHAPE_DRAW_2D, true, 720.0, 640.0, 0.0, black, white,
            4, _polyline1_pointsDX_xjal(), _polyline1_pointsDY_xjal(), _polyline1_pointsDZ_xjal(), false, 10.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _polyline1, 0, clickx, clicky );
      }
    };

    image1 = new ShapeImage(
		MonteCarlo.this, SHAPE_DRAW_2D, true, 10.0, 631.0, 0.0, 0.0, 
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
    Histogram2DData _item;
    List<Histogram2DData> _items = new ArrayList<Histogram2DData>( 1 );
    _item = 
histogram2d0_data 
;
    _items.add( _item );
    List<String> _titles = new ArrayList<String>( 1 );
    _titles.add( "Duration of the evacuation on alarm time (2 exits)" );
    List<Histogram2D.Appearance> _appearances = new ArrayList<Histogram2D.Appearance>( 1 );
    _appearances.add( new Histogram2D.Appearance( navy ) );
    histogram2d0 = new Histogram2D(
		    MonteCarlo.this, true, -257.0, -216.0, 
			759.0, 203.0,
            null, null,
            80.0, 20.0,
			659.0, 163.0, white, black, black,
            30.0, Chart.NONE,
            Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, false,
            _items, _titles, _appearances ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _histogram2d0_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    }
    {
    Histogram2DData _item;
    List<Histogram2DData> _items = new ArrayList<Histogram2DData>( 1 );
    _item = 
histogram2d1_data 
;
    _items.add( _item );
    List<String> _titles = new ArrayList<String>( 1 );
    _titles.add( "Evacuation time (1 exit)" );
    List<Histogram2D.Appearance> _appearances = new ArrayList<Histogram2D.Appearance>( 1 );
    _appearances.add( new Histogram2D.Appearance( navy ) );
    histogram2d1 = new Histogram2D(
		    MonteCarlo.this, true, -257.0, 0.0, 
			759.0, 203.0,
            null, null,
            80.0, 20.0,
			659.0, 163.0, white, black, black,
            30.0, Chart.NONE,
            Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, false,
            _items, _titles, _appearances ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _histogram2d1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    }
    {
    HistogramData _item;
    List<HistogramData> _items = new ArrayList<HistogramData>( 1 );
    _item = 
histogram0_data 
;
    _items.add( _item ); 
    List<String> _titles = new ArrayList<String>( 1 );
    _titles.add( "Total Evacuation time (2 exits)" );
    List<Histogram.Appearance> _appearances = new ArrayList<Histogram.Appearance>( 1 );
    _appearances.add( new Histogram.Appearance( navy, cyan, blue, black, 1, navy ) );
    histogram0 = new Histogram(
		    MonteCarlo.this, true, -257.0, -216.0, 
			759.0, 203.0,
            null, null,
            80.0, 20.0,
			659.0, 163.0, white, black, black,
            30.0, Chart.NONE,
            Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, 
            true, false, true, 0.8,
            _items, _titles, _appearances ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _histogram0_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    }
    {
    HistogramData _item;
    List<HistogramData> _items = new ArrayList<HistogramData>( 1 );
    _item = 
histogram1_data 
;
    _items.add( _item ); 
    List<String> _titles = new ArrayList<String>( 1 );
    _titles.add( "Total Evacuation time (1 exit)" );
    List<Histogram.Appearance> _appearances = new ArrayList<Histogram.Appearance>( 1 );
    _appearances.add( new Histogram.Appearance( navy, cyan, blue, black, 1, navy ) );
    histogram1 = new Histogram(
		    MonteCarlo.this, true, -257.0, 0.0, 
			759.0, 203.0,
            null, null,
            80.0, 20.0,
			659.0, 163.0, white, black, black,
            30.0, Chart.NONE,
            Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, 
            true, false, true, 0.8,
            _items, _titles, _appearances ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _histogram1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    }
    {				
    groupSec = new ShapeGroup( MonteCarlo.this, SHAPE_DRAW_2D, true, 1260.0, 420.0, 0.0, 0.0
	
	     ,text12
	     ,text13
	     ,histogram2d0
	     ,histogram2d1 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _groupSec_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _groupSec, 0, panel, graphics );
      }
    };

    }
    {				
    groupFir = new ShapeGroup( MonteCarlo.this, SHAPE_DRAW_2D, true, 280.0, 420.0, 0.0, 0.0
	
	     ,text10
	     ,text11
	     ,histogram0
	     ,histogram1 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _groupFir_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _groupFir, 0, panel, graphics );
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
      case _histogram2d0: return histogram2d0;
      case _histogram2d1: return histogram2d1;
      case _histogram0: return histogram0;
      case _histogram1: return histogram1;
      case _text: return text;
      case _text1: return text1;
      case _text2: return text2;
      case _text3: return text3;
      case _text4: return text4;
      case _line: return line;
      case _text5: return text5;
      case _text6: return text6;
      case _text7: return text7;
      case _text8: return text8;
      case _text9: return text9;
      case _line1: return line1;
      case _text12: return text12;
      case _text13: return text13;
      case _groupSec: return groupSec;
      case _text10: return text10;
      case _text11: return text11;
      case _groupFir: return groupFir;
      case _polyline: return polyline;
      case _polyline1: return polyline1;
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
      _name_xjal = checkNameOfShape_xjal( _shape, histogram2d0, "histogram2d0" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, histogram2d1, "histogram2d1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, histogram0, "histogram0" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, histogram1, "histogram1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text, "text" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text1, "text1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text2, "text2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text3, "text3" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text4, "text4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line, "line" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text5, "text5" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text6, "text6" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text7, "text7" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text8, "text8" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text9, "text9" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line1, "line1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text12, "text12" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text13, "text13" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, groupSec, "groupSec" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text10, "text10" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text11, "text11" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, groupFir, "groupFir" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline, "polyline" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline1, "polyline1" ); if (_name_xjal != null) return _name_xjal;
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
  // Analysis Data Elements
    histogram0_data.destroyUpdater_xjal();
    histogram1_data.destroyUpdater_xjal();
    histogram2d0_data.destroyUpdater_xjal();
    histogram2d1_data.destroyUpdater_xjal();
    logToDB( histogram0_data, "histogram0_data" );
    logToDB( histogram1_data, "histogram1_data" );
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
    MonteCarlo ex;

    @Override
    public void init() {
      ex = new MonteCarlo();
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

  // Parameter values (read-only)
  public double alarmTime;
  public double visitorArrivalMultiplier;
  public boolean addExit;
  public double workerArrivalRate;
  public boolean addExit1;
  public boolean active_dynamic;
  public TargetLine safe_exit;
  public double newvisitorArrivalRate;
  public boolean active_predict_help;
  public MyAgent fire_center;
  public double[] dis_from_fire;
  public double fire_speed;
  public double now_time;
  public boolean dynamic_help;
  public MyAgent[] connectedag2;
  public boolean active_safest;
  public boolean static_withdoor_sensor;
  public boolean explosion;
  public MyAgent[] floor1_agents;
  public MyAgent[] floor2_agents;
  public boolean a1;
  public boolean a2;
  public boolean a3;
  public boolean a4;
  public int coffee_counter;
  public long total_beforealarm;
  public boolean as1;
  public boolean as3_2;
  public boolean a3_4;
  public boolean a1_1;
  public boolean a3_2;

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
  }

  /**
   * Experiment setup
   */
  @Override
  @AnyLogicInternalCodegenAPI
  public void setup( java.awt.Container container ) {
    setName( "Evacuation : MonteCarlo" );
    Presentation _p = new Presentation( this, container instanceof JApplet ? Presentation.MODE_APPLET :
    	container != null ? Presentation.MODE_COMPONENT :
        Presentation.MODE_APPLICATION, container );

    // Static initialization of persistent elements
    _createPersistentElementsBP0_xjal();

    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation = new ShapeTopLevelPresentationGroup( MonteCarlo.this, true, 0, 0, 0, 0 , text, text1, text2, text3, text4, line, text5, text6, text7, text8, text9, line1, groupSec, groupFir, polyline, polyline1, image1, button );
    icon = new ShapeModelElementsGroup( MonteCarlo.this, getElementProperty( "evacuation.MonteCarlo.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    // Setup presentation
    _p.start();

    Panel _panel = _p.getPanel();
    ToolBar _tb = _p.getToolBar();
    StatusBar _sb = _p.getStatusBar();

    _p.setZoomAndPanningEnabled( false );
    _panel.setFrameManagementBalance( 2.0 );

    _sb.setSectionVisible( StatusBar.EPS, false );
    _sb.setSectionVisible( StatusBar.EXPERIMENT, true );
    _sb.setSectionVisible( StatusBar.FPS, false );
    _sb.setSectionVisible( StatusBar.MEMORY, true );
    _sb.setSectionVisible( StatusBar.SECONDS, true );
    _sb.setSectionVisible( StatusBar.SIMULATION, true );
    _sb.setSectionVisible( StatusBar.STATUS, true );
    _tb.setSectionVisible( ToolBar.ANIMATION, false );
    _tb.setSectionVisible( ToolBar.EXECUTION, true );
    _tb.setSectionVisible( ToolBar.FILE, false );
    _tb.setSectionEnabled( ToolBar.NAVIGATION, false );
    _tb.setSectionVisible( ToolBar.NAVIGATION, false );
    _tb.setSectionEnabled( ToolBar.TIME_SCALE, false );
    _tb.setSectionVisible( ToolBar.TIME_SCALE, false );
    _tb.setSectionVisible( ToolBar.VIEW, false );
    
 
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public Main createRoot( Engine engine ) {
    // Create the root object
    return new Main( engine, null, null );
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void onBeforeSimulationRun(Main root) {
    alarmTime = root.alarmTime;
    visitorArrivalMultiplier = root.visitorArrivalMultiplier;
    addExit = root.addExit;
    workerArrivalRate = root.workerArrivalRate;
    addExit1 = root.addExit1;
    active_dynamic = root.active_dynamic;
    safe_exit = root.safe_exit;
    newvisitorArrivalRate = root.newvisitorArrivalRate;
    active_predict_help = root.active_predict_help;
    fire_center = root.fire_center;
    dis_from_fire = root.dis_from_fire;
    fire_speed = root.fire_speed;
    now_time = root.now_time;
    dynamic_help = root.dynamic_help;
    connectedag2 = root.connectedag2;
    active_safest = root.active_safest;
    static_withdoor_sensor = root.static_withdoor_sensor;
    explosion = root.explosion;
    floor1_agents = root.floor1_agents;
    floor2_agents = root.floor2_agents;
    a1 = root.a1;
    a2 = root.a2;
    a3 = root.a3;
    a4 = root.a4;
    coffee_counter = root.coffee_counter;
    total_beforealarm = root.total_beforealarm;
    as1 = root.as1;
    as3_2 = root.as3_2;
    a3_4 = root.a3_4;
    a1_1 = root.a1_1;
    a3_2 = root.a3_2;
    
 
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void onEngineFinished() {
    final Main root = (Main) getEngine().getRoot();
    // After simulation run code
    
if (root.addExit) {
	histogram0_data.add( root.alarmEnding - root.alarmBegining );
	{
		DataSet ds = root.evacuation.timeMeasureEnd.dataset;
		for (int i = 0, n = ds.size(); i < n; i++) {
			histogram2d0_data.add( ds.getX(i), ds.getY(i) );
		}
	}
}
else {
	histogram1_data.add( root.alarmEnding - root.alarmBegining );

	{
		DataSet ds = root.evacuation.timeMeasureEnd.dataset;
		for (int i = 0, n = ds.size(); i < n; i++) {
			histogram2d1_data.add( ds.getX(i), ds.getY(i) );
		}
	}
} 
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void onAfterIteration() {
    // After iteration code
    
 
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void onAfterExperiment() {
    // After experiment code
        
 
  }

  

  @Override
  @AnyLogicInternalCodegenAPI
  public void reset() {
    // Before each experiment run code
    
 

    // Replications setup
    setUseReplications( false );
  }
  
  @Override
  public int getMaximumIterations() {
    return 100;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void setupRootParameters( final Main self, int index, boolean callOnChangeActions ) {
    final Main root = self; // for compatibility
    double alarmTime_xjal;
    alarmTime_xjal = 
uniform(0,8*hour()) 
;
    if (callOnChangeActions) {
      self.set_alarmTime( alarmTime_xjal );
    } else {
      self.alarmTime = alarmTime_xjal;
    }
    boolean addExit_xjal;
    addExit_xjal = 
randomTrue(0.5) 
;
    if (callOnChangeActions) {
      self.set_addExit( addExit_xjal );
    } else {
      self.addExit = addExit_xjal;
    }
    double visitorArrivalMultiplier_xjal;
    visitorArrivalMultiplier_xjal = self._visitorArrivalMultiplier_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_visitorArrivalMultiplier( visitorArrivalMultiplier_xjal );
    } else {
      self.visitorArrivalMultiplier = visitorArrivalMultiplier_xjal;
    }
    double workerArrivalRate_xjal;
    workerArrivalRate_xjal = self._workerArrivalRate_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_workerArrivalRate( workerArrivalRate_xjal );
    } else {
      self.workerArrivalRate = workerArrivalRate_xjal;
    }
    boolean addExit1_xjal;
    addExit1_xjal = self._addExit1_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_addExit1( addExit1_xjal );
    } else {
      self.addExit1 = addExit1_xjal;
    }
    boolean active_dynamic_xjal;
    active_dynamic_xjal = self._active_dynamic_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_active_dynamic( active_dynamic_xjal );
    } else {
      self.active_dynamic = active_dynamic_xjal;
    }
    TargetLine safe_exit_xjal;
    safe_exit_xjal = self._safe_exit_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_safe_exit( safe_exit_xjal );
    } else {
      self.safe_exit = safe_exit_xjal;
    }
    double newvisitorArrivalRate_xjal;
    newvisitorArrivalRate_xjal = self._newvisitorArrivalRate_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_newvisitorArrivalRate( newvisitorArrivalRate_xjal );
    } else {
      self.newvisitorArrivalRate = newvisitorArrivalRate_xjal;
    }
    boolean active_predict_help_xjal;
    active_predict_help_xjal = self._active_predict_help_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_active_predict_help( active_predict_help_xjal );
    } else {
      self.active_predict_help = active_predict_help_xjal;
    }
    MyAgent fire_center_xjal;
    fire_center_xjal = self._fire_center_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_fire_center( fire_center_xjal );
    } else {
      self.fire_center = fire_center_xjal;
    }
    double[] dis_from_fire_xjal;
    dis_from_fire_xjal = self._dis_from_fire_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_dis_from_fire( dis_from_fire_xjal );
    } else {
      self.dis_from_fire = dis_from_fire_xjal;
    }
    double fire_speed_xjal;
    fire_speed_xjal = self._fire_speed_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_fire_speed( fire_speed_xjal );
    } else {
      self.fire_speed = fire_speed_xjal;
    }
    double now_time_xjal;
    now_time_xjal = self._now_time_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_now_time( now_time_xjal );
    } else {
      self.now_time = now_time_xjal;
    }
    boolean dynamic_help_xjal;
    dynamic_help_xjal = self._dynamic_help_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_dynamic_help( dynamic_help_xjal );
    } else {
      self.dynamic_help = dynamic_help_xjal;
    }
    MyAgent[] connectedag2_xjal;
    connectedag2_xjal = self._connectedag2_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_connectedag2( connectedag2_xjal );
    } else {
      self.connectedag2 = connectedag2_xjal;
    }
    boolean active_safest_xjal;
    active_safest_xjal = self._active_safest_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_active_safest( active_safest_xjal );
    } else {
      self.active_safest = active_safest_xjal;
    }
    boolean static_withdoor_sensor_xjal;
    static_withdoor_sensor_xjal = self._static_withdoor_sensor_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_static_withdoor_sensor( static_withdoor_sensor_xjal );
    } else {
      self.static_withdoor_sensor = static_withdoor_sensor_xjal;
    }
    boolean explosion_xjal;
    explosion_xjal = self._explosion_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_explosion( explosion_xjal );
    } else {
      self.explosion = explosion_xjal;
    }
    MyAgent[] floor1_agents_xjal;
    floor1_agents_xjal = self._floor1_agents_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_floor1_agents( floor1_agents_xjal );
    } else {
      self.floor1_agents = floor1_agents_xjal;
    }
    MyAgent[] floor2_agents_xjal;
    floor2_agents_xjal = self._floor2_agents_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_floor2_agents( floor2_agents_xjal );
    } else {
      self.floor2_agents = floor2_agents_xjal;
    }
    boolean a1_xjal;
    a1_xjal = self._a1_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_a1( a1_xjal );
    } else {
      self.a1 = a1_xjal;
    }
    boolean a2_xjal;
    a2_xjal = self._a2_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_a2( a2_xjal );
    } else {
      self.a2 = a2_xjal;
    }
    boolean a3_xjal;
    a3_xjal = self._a3_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_a3( a3_xjal );
    } else {
      self.a3 = a3_xjal;
    }
    boolean a4_xjal;
    a4_xjal = self._a4_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_a4( a4_xjal );
    } else {
      self.a4 = a4_xjal;
    }
    int coffee_counter_xjal;
    coffee_counter_xjal = self._coffee_counter_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_coffee_counter( coffee_counter_xjal );
    } else {
      self.coffee_counter = coffee_counter_xjal;
    }
    long total_beforealarm_xjal;
    total_beforealarm_xjal = self._total_beforealarm_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_total_beforealarm( total_beforealarm_xjal );
    } else {
      self.total_beforealarm = total_beforealarm_xjal;
    }
    boolean as1_xjal;
    as1_xjal = self._as1_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_as1( as1_xjal );
    } else {
      self.as1 = as1_xjal;
    }
    boolean as3_2_xjal;
    as3_2_xjal = self._as3_2_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_as3_2( as3_2_xjal );
    } else {
      self.as3_2 = as3_2_xjal;
    }
    boolean a3_4_xjal;
    a3_4_xjal = self._a3_4_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_a3_4( a3_4_xjal );
    } else {
      self.a3_4 = a3_4_xjal;
    }
    boolean a1_1_xjal;
    a1_1_xjal = self._a1_1_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_a1_1( a1_1_xjal );
    } else {
      self.a1_1 = a1_1_xjal;
    }
    boolean a3_2_xjal;
    a3_2_xjal = self._a3_2_DefaultValue_xjal();
    if (callOnChangeActions) {
      self.set_a3_2( a3_2_xjal );
    } else {
      self.a3_2 = a3_2_xjal;
    }
  }
  
}
