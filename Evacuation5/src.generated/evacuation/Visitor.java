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

import java.awt.geom.Arc2D;

import com.vividsolutions.jts.geom.impl.PackedCoordinateSequence.Double; 

public class Visitor extends Agent
        implements IPedestrian
{
  // Parameters
  // Plain Variables

 
  public 
double 
 leftped_y;
 
  public 
double 
 leftped_x;
 
  public 
boolean 
 changed_Route;
 
  public 
boolean 
 ped_infire;
 
  public 
boolean 
 changed_Route1;
 
  public 
int 
 ind4;
 
  public 
RectangularNode[] 
 finalroute;
 
  public 
Pathway 
 route;
 
  public 
double 
 dead_time;
 
  public 
boolean 
 helpis_inside;
 
  public 
boolean 
 priority_accept;
 
  public 
boolean 
 notinjured;
 
  public 
boolean 
 priority_accept_injure;
 
  public 
TargetLine 
 target;
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Visitor.class );
  
  @AnyLogicInternalCodegenAPI
  @Override
  public Map<String, IElementDescriptor> getElementDesciptors() {
    return elementDesciptors_xjal;
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final Scale scale = new Scale( 10.0 );

  @Override
  public Scale getScale() {
    return scale;
  }



	


  // Statecharts
  public Statechart<statechart_state> statechart = new Statechart<>( this, (short)2 );

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( Statechart _s ) {
    if(_s == this.statechart) return "statechart";
    return super.getNameOf( _s );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( Statechart _s ) {
    if( _s == this.statechart ) {
       
 
;
      enterState( alive, true );
      return;
    }
    super.executeActionOf( _s );
  }

   // States of all statecharts
   
  public enum statechart_state implements IStatechartState<Visitor, statechart_state> {
    alive,
    injured,
    dead,
    wait;

    @AnyLogicInternalCodegenAPI
    private Collection<statechart_state> _simpleStatesDeep_xjal;

    @AnyLogicInternalCodegenAPI
    private Set<statechart_state> _fullState_xjal;

    @AnyLogicInternalCodegenAPI
    private Set<statechart_state> _statesInside_xjal;

    @Override
    @AnyLogicInternalCodegenAPI
    public Collection<statechart_state> getSimpleStatesDeep() {
      Collection<statechart_state> result = _simpleStatesDeep_xjal;
      if (result == null) {
        _simpleStatesDeep_xjal = result = calculateAllSimpleStatesDeep();
      }
      return result;
    }
    
    @Override
    public Set<statechart_state> getFullState() {
      Set<statechart_state> result = _fullState_xjal;
      if (result == null) {
        _fullState_xjal = result = calculateFullState();
      }
      return result;
    }
    
    @Override
    @AnyLogicInternalCodegenAPI
    public Set<statechart_state> getStatesInside() {
      Set<statechart_state> result = _statesInside_xjal;
      if (result == null) {
        _statesInside_xjal = result = calculateStatesInside();
      }
      return result;
    }

    @Override
    @AnyLogicInternalCodegenAPI
    public Statechart<statechart_state> getStatechart( Visitor _a ) {
      return _a.statechart;
    }
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final statechart_state alive = statechart_state.alive;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final statechart_state injured = statechart_state.injured;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final statechart_state dead = statechart_state.dead;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final statechart_state wait = statechart_state.wait;


  @AnyLogicInternalCodegenAPI
  private void enterState( statechart_state _state, boolean _destination ) {
    switch( _state ) {
      case alive:
  	    logToDBEnterState(statechart, _state);
        // (Simple state (not composite))
        statechart.setActiveState_xjal( alive );
        {
 
;}
        injure.start();
        waiting.start();
        return;
      case injured:
  	    logToDBEnterState(statechart, _state);
        // (Simple state (not composite))
        statechart.setActiveState_xjal( injured );
        {
 
;}
        death.start();
        return;
      case dead:
  	    logToDBEnterState(statechart, _state);
        // (Simple state (not composite))
        statechart.setActiveState_xjal( dead );
        {

main.evacuation.pedGoToExit.cancel(this);
	main.evacuation.pedChangeGround.cancel(this);
	main.evacuation.pedGoToExit1.cancel(this);
	main.evacuation.pedGoToExit2.cancel(this);
	main.evacuation.pedLongWait.free(this);
	
	main.evacuation.pedShortWait.cancel(this);
	main.evacuation.helpgotoped.cancel(this);
	main.evacuation.helpgotoped1.cancel(this);
	main.evacuation.pedShortWait1.cancel(this);
	main.evacuation.pedChangeGround1.cancel(this);
	//main.evacuation.pedGoToStairs.cancel(this);
	main.evacuation.pedWindowWait.cancel(this); 
;}
        return;
      case wait:
  	    logToDBEnterState(statechart, _state);
        // (Simple state (not composite))
        statechart.setActiveState_xjal( wait );
        {
 
;}
        injure2.start();
        return;
      default:
        return;
    }
  }

  @AnyLogicInternalCodegenAPI
  private void exitState( statechart_state _state, Transition _t, boolean _source ) {
    switch( _state ) {
      case alive: 
  	    logToDBExitState(statechart, _state);
  	    logToDB(statechart, _t, _state);
      // (Simple state (not composite))
        if ( !_source || _t != injure) injure.cancel();
        if ( !_source || _t != waiting) waiting.cancel();
        {
 
;}
        return;
      case injured: 
  	    logToDBExitState(statechart, _state);
  	    logToDB(statechart, _t, _state);
      // (Simple state (not composite))
        if ( !_source || _t != death) death.cancel();
        {
 
;}
        return;
      case dead: 
  	    logToDBExitState(statechart, _state);
  	    logToDB(statechart, _t, _state);
      // (Simple state (not composite))
        {
 
;}
        return;
      case wait: 
  	    logToDBExitState(statechart, _state);
  	    logToDB(statechart, _t, _state);
      // (Simple state (not composite))
        if ( !_source || _t != injure2) injure2.cancel();
        {
 
;}
        return;
      default:
        return;
    }
  }

  @AnyLogicInternalCodegenAPI
  private void exitInnerStates( statechart_state _destination ) {
    statechart_state _state = statechart.getActiveSimpleState();
    while( _state != _destination ) {
			exitState( _state, null, false );
			_state = _state.getContainerState();
		}
	}
  



  public TransitionMessage injure = new TransitionMessage( this );
  public TransitionMessage death = new TransitionMessage( this );
  public TransitionMessage waiting = new TransitionMessage( this );
  public TransitionMessage injure2 = new TransitionMessage( this );

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( TransitionMessage _t ) {
    if ( _t == injure ) return "injure";
    if ( _t == death ) return "death";
    if ( _t == waiting ) return "waiting";
    if ( _t == injure2 ) return "injure2";
    return super.getNameOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Statechart getStatechartOf( TransitionMessage _t ) { 
    if ( _t == injure ) return statechart;
    if ( _t == death ) return statechart;
    if ( _t == waiting ) return statechart;
    if ( _t == injure2 ) return statechart;
    return super.getStatechartOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean testGuardOf( TransitionMessage _t ) {
    if ( _t == injure ) return 
 
;
    if ( _t == death ) return 
 
;
    if ( _t == waiting ) return 
 
;
    if ( _t == injure2 ) return 
 
;
    return super.testGuardOf(  _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( TransitionMessage _t, Object _msg ) {
    if ( _t == injure ) {
      exitState( alive, _t, true );
      {
        Object msg = (Object) _msg;
 
;}
          enterState( injured, true );
      return;
    }
    if ( _t == death ) {
      exitState( injured, _t, true );
      {
        Object msg = (Object) _msg;
 
;}
          enterState( dead, true );
      return;
    }
    if ( _t == waiting ) {
      exitState( alive, _t, true );
      {
        Object msg = (Object) _msg;
 
;}
          enterState( wait, true );
      return;
    }
    if ( _t == injure2 ) {
      exitState( wait, _t, true );
      {
        Object msg = (Object) _msg;
 
;}
          enterState( injured, true );
      return;
    }
    super.executeActionOf( _t, _msg );
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public boolean testMessageOf( TransitionMessage _t, Object _msg ) {
    if ( _t == injure ) {
      
Object 
msg = (Object) _msg;
      Object _g = 
"Crashed" 
;
      return msg.equals( _g );
    }
    if ( _t == death ) {
      
Object 
msg = (Object) _msg;
      Object _g = 
"dead" 
;
      return msg.equals( _g );
    }
    if ( _t == waiting ) {
      
Object 
msg = (Object) _msg;
      Object _g = 
"wait" 
;
      return msg.equals( _g );
    }
    if ( _t == injure2 ) {
      
Object 
msg = (Object) _msg;
      Object _g = 
"Crashed" 
;
      return msg.equals( _g );
    }
    return super.testMessageOf( _t, _msg );
  }
  // Stub function for code completion support (internal)
  @AnyLogicInternalCodegenAPI
  private void _stubForCodeCompletion_xjal(){
    {double _t = 
0 
;}
    {double _t = 
1 
;}
    class _Stub_Implements_xjal implements 
  {}
    class _Stub_Extends_xjal extends 
  {}
  }

  // View areas
  public ViewArea _origin_VA = new ViewArea( this, "[Origin]", 0, 0, 1270.0, 910.0 );
  @Override
  @AnyLogicInternalCodegenAPI
  public int getViewAreas(Map<String, ViewArea> _output) {
    if ( _output != null ) {
      _output.put( "_origin_VA", this._origin_VA );
    }
    return 1 + super.getViewAreas( _output );
  }
  @AnyLogicInternalCodegenAPI
  protected static final Color[] _person_customColors_xjal = new Color[] {
    null, lime, null, null, null, null, 
  };
  protected static final Color _polyline4_Fill_Color = new Color( 0x5CFF0000, true );
  protected static final Color _polyline5_Fill_Color = new Color( 0x5CFFD700, true );
  protected static final Color _polyline6_Fill_Color = new Color( 0x5C00FF00, true );
  @AnyLogicInternalCodegenAPI
  protected static final int _person = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline4 = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _citizenLying = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _citizenDead = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline5 = 5;
  @AnyLogicInternalCodegenAPI
  protected static final int _citizenLying1 = 6;
  @AnyLogicInternalCodegenAPI
  protected static final int _citizenDead1 = 7;
  @AnyLogicInternalCodegenAPI
  protected static final int _polyline6 = 8;
  @AnyLogicInternalCodegenAPI
  protected static final int _citizenLying2 = 9;
  @AnyLogicInternalCodegenAPI
  protected static final int _citizenDead2 = 10;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 11;
 

  /**
   * Top-level presentation group id
   */	 
  @AnyLogicInternalCodegenAPI
  protected static final int _presentation = 0;

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }
  /**
   * Top-level icon group id
   */	 
  @AnyLogicInternalCodegenAPI
  protected static final int _icon = -1;
  
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline4_pointsDX_xjal() {
    return new double[] { 0.0, -2.641, 0.0, -1.322, 1.322, 2.643, 3.964, 6.607, 7.928, 7.928, 10.571, 11.893, 9.25, 10.571, 9.25, 6.607, 6.607, 3.964, 1.322,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline4_pointsDY_xjal() {
    return new double[] { 0.0, -1.285, -2.571, -5.141, -7.713, -8.998, -10.283, -8.998, -8.998, -7.713, -6.427, -3.857, -1.285, 1.286, 2.572, 2.572, 6.427, 5.142, 3.857,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline4_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline5_pointsDX_xjal() {
    return new double[] { 0.0, -2.54, 0.0, -1.271, 1.271, 2.541, 3.812, 6.353, 7.623, 7.623, 10.164, 11.435, 8.893, 10.164, 8.893, 6.353, 6.353, 3.812, 1.271,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline5_pointsDY_xjal() {
    return new double[] { 0.0, -1.201, -2.401, -4.802, -7.204, -8.405, -9.605, -8.405, -8.405, -7.204, -6.003, -3.602, -1.201, 1.201, 2.402, 2.402, 6.003, 4.803, 3.603,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline5_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline6_pointsDX_xjal() {
    return new double[] { 0.0, -2.54, 0.0, -1.271, 1.271, 2.541, 3.812, 6.353, 7.623, 7.623, 10.164, 11.435, 8.893, 10.164, 8.893, 6.353, 6.353, 3.812, 1.271,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline6_pointsDY_xjal() {
    return new double[] { 0.0, -1.201, -2.401, -4.802, -7.204, -8.405, -9.605, -8.405, -8.405, -7.204, -6.003, -3.602, -1.201, 1.201, 2.402, 2.402, 6.003, 4.803, 3.603,  };
  }
  @AnyLogicInternalCodegenAPI
  protected static final double[] _polyline6_pointsDZ_xjal() {
    return new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,  };
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _person:
        if (true) {
          Shape3DObject self = this.person;
          
 
        }
        break;
      case _polyline4:
        if (true) {
          ShapePolyLine self = this.polyline4;
          
 
        }
        break;
      case _citizenLying:
        if (true) {
          Shape3DObject self = this.citizenLying;
          
 
        }
        break;
      case _citizenDead:
        if (true) {
          ShapeGroup self = this.citizenDead;
          
 
        }
        break;
      case _polyline5:
        if (true) {
          ShapePolyLine self = this.polyline5;
          
 
        }
        break;
      case _citizenLying1:
        if (true) {
          Shape3DObject self = this.citizenLying1;
          
 
        }
        break;
      case _citizenDead1:
        if (true) {
          ShapeGroup self = this.citizenDead1;
          
 
        }
        break;
      case _polyline6:
        if (true) {
          ShapePolyLine self = this.polyline6;
          
 
        }
        break;
      case _citizenLying2:
        if (true) {
          Shape3DObject self = this.citizenLying2;
          
 
        }
        break;
      case _citizenDead2:
        if (true) {
          ShapeGroup self = this.citizenDead2;
          
 
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
      case _citizenDead:
          
 
        break;
      case _citizenDead1:
          
 
        break;
      case _citizenDead2:
          
 
        break;
      default:
        super.onShapeGroupDraw( _shape, index, panel, graphics );
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
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _person_SetDynamicParams_xjal( Shape3DObject shape ) {
    boolean _visible = 
inState(alive)||inState(wait) 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScale(
 
);
    shape.setRotation(
 
);
 	}
  }
  
  protected Shape3DObject person;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline4_SetDynamicParams_xjal( ShapePolyLine shape ) {
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
    shape.setZHeight(
0.2 
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
  
  protected ShapePolyLine polyline4;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _citizenLying_SetDynamicParams_xjal( Shape3DObject shape ) {
    boolean _visible = 
!inState(wait) 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScale(
 
);
    shape.setRotation(
 
);
 	}
  }
  
  protected Shape3DObject citizenLying;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _citizenDead_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
inState(dead)
 
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
  
  protected ShapeGroup citizenDead;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline5_SetDynamicParams_xjal( ShapePolyLine shape ) {
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
    shape.setZHeight(
0.2 
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
  
  protected ShapePolyLine polyline5;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _citizenLying1_SetDynamicParams_xjal( Shape3DObject shape ) {
    boolean _visible = 
!inState(wait) 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScale(
 
);
    shape.setRotation(
 
);
 	}
  }
  
  protected Shape3DObject citizenLying1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _citizenDead1_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
inState(injured)
 
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
  
  protected ShapeGroup citizenDead1;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _polyline6_SetDynamicParams_xjal( ShapePolyLine shape ) {
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
    shape.setZHeight(
0.2 
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
  
  protected ShapePolyLine polyline6;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _citizenLying2_SetDynamicParams_xjal( Shape3DObject shape ) {
    boolean _visible = 
!inState(wait) 
;
    shape.setVisible( _visible );
 	if ( _visible ) {
    shape.setX(
 
);
    shape.setY(
 
);
    shape.setZ(
 
);
    shape.setScale(
 
);
    shape.setRotation(
 
);
 	}
  }
  
  protected Shape3DObject citizenLying2;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _citizenDead2_SetDynamicParams_xjal( ShapeGroup shape ) {
    boolean _visible = 
inState(wait)
 
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
  
  protected ShapeGroup citizenDead2;
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    person = new Shape3DObject(
		Visitor.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0,
			1.0, false, "/evacuation/",
			"x3d/person4.x3d", OBJECT_3D_YZX_AXIS_ORDER, true, 0.0, 0.0,
			1.0, 1.0, 1423819119482L, _person_customColors_xjal ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _person_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    polyline4 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -3.963, 0.0, 0.0, null, _polyline4_Fill_Color,
            19, _polyline4_pointsDX_xjal(), _polyline4_pointsDY_xjal(), _polyline4_pointsDZ_xjal(), true, 1.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline4_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    citizenLying = new Shape3DObject(
		Visitor.this, SHAPE_DRAW_2D3D, true, 1.322, 7.713, 2.0, 0.0,
			0.5, false, "/evacuation/",
			"x3d/officeworker.x3d", OBJECT_3D_XYZ_AXIS_ORDER, false, 0.0, 0.0,
			1.0, 1.0, null ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _citizenLying_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    citizenLying.setVisible( false );
    polyline5 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -3.812, 0.0, 0.0, null, _polyline5_Fill_Color,
            19, _polyline5_pointsDX_xjal(), _polyline5_pointsDY_xjal(), _polyline5_pointsDZ_xjal(), true, 1.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline5_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    citizenLying1 = new Shape3DObject(
		Visitor.this, SHAPE_DRAW_2D3D, true, 1.271, 7.204, 2.0, 0.0,
			0.5, false, "/evacuation/",
			"x3d/officeworker.x3d", OBJECT_3D_XYZ_AXIS_ORDER, false, 0.0, 0.0,
			1.0, 1.0, null ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _citizenLying1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    citizenLying1.setVisible( false );
    polyline6 = new ShapePolyLine(
		SHAPE_DRAW_2D3D, true, -3.812, 0.0, 0.0, null, _polyline6_Fill_Color,
            19, _polyline6_pointsDX_xjal(), _polyline6_pointsDY_xjal(), _polyline6_pointsDZ_xjal(), true, 1.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _polyline6_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    citizenLying2 = new Shape3DObject(
		Visitor.this, SHAPE_DRAW_2D3D, true, 1.271, 7.204, 2.0, 0.0,
			0.5, false, "/evacuation/",
			"x3d/officeworker.x3d", OBJECT_3D_XYZ_AXIS_ORDER, false, 0.0, 0.0,
			1.0, 1.0, null ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _citizenLying2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    citizenLying2.setVisible( false );
  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {				
    citizenDead = new ShapeGroup( Visitor.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     ,polyline4
	     ,citizenLying ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _citizenDead_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _citizenDead, 0, panel, graphics );
      }
    };

    }
    citizenDead.setVisible( false );
    {				
    citizenDead1 = new ShapeGroup( Visitor.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     ,polyline5
	     ,citizenLying1 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _citizenDead1_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _citizenDead1, 0, panel, graphics );
      }
    };

    }
    citizenDead1.setVisible( false );
    {				
    citizenDead2 = new ShapeGroup( Visitor.this, SHAPE_DRAW_2D3D, true, 0.0, 0.0, 0.0, 0.0
	
	     ,polyline6
	     ,citizenLying2 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _citizenDead2_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public void onDraw( Panel panel, Graphics2D graphics ) {
        onShapeGroupDraw( _citizenDead2, 0, panel, graphics );
      }
    };

    }
    citizenDead2.setVisible( false );
  }


  // Static initialization of persistent elements
  {
    _createPersistentElementsBP0_xjal();
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
      case _person: return person;
      case _polyline4: return polyline4;
      case _citizenLying: return citizenLying;
      case _citizenDead: return citizenDead;
      case _polyline5: return polyline5;
      case _citizenLying1: return citizenLying1;
      case _citizenDead1: return citizenDead1;
      case _polyline6: return polyline6;
      case _citizenLying2: return citizenLying2;
      case _citizenDead2: return citizenDead2;
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
      _name_xjal = checkNameOfShape_xjal( _shape, person, "person" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline4, "polyline4" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, citizenLying, "citizenLying" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, citizenDead, "citizenDead" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline5, "polyline5" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, citizenLying1, "citizenLying1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, citizenDead1, "citizenDead1" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, polyline6, "polyline6" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, citizenLying2, "citizenLying2" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, citizenDead2, "citizenDead2" ); if (_name_xjal != null) return _name_xjal;
    } catch (Exception e) {
      return null;
    }
    return super.getNameOfShape_xjal( _shape );
  }
  @AnyLogicInternalCodegenAPI
  protected static final int[] _injure_pointsX_xjal = {200, 180, };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _injure_pointsY_xjal = {90, 430, };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _death_pointsX_xjal = {130, 100, };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _death_pointsY_xjal = {430, 320, };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _waiting_pointsX_xjal = {280, 290, };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _waiting_pointsY_xjal = {90, 290, };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _injure2_pointsX_xjal = {270, 210, };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _injure2_pointsY_xjal = {310, 440, };


  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Statecharts_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawState( _panel, _g, 190, 60, 100, 30, 10, 15, "alive", GOLD, alive, statechart );
    }
    if (!_publicOnly) {
      drawState( _panel, _g, 50, 290, 100, 30, 35, 15, "dead", GOLD, dead, statechart );
    }
    if (!_publicOnly) {
      drawState( _panel, _g, 270, 290, 100, 30, 10, 10, "wait", GOLD, wait, statechart );
    }
    if (!_publicOnly) {
      drawState( _panel, _g, 110, 430, 100, 30, 35, 15, "injured", GOLD, injured, statechart );
    }
    if (!_publicOnly) {
      drawTransition(_panel, _g, _injure_pointsX_xjal, _injure_pointsY_xjal, 130, 195, "injure", injure, TransitionIcon.MESSAGE, 194, 183 );
    }
    if (!_publicOnly) {
      drawStatechartEntryPoint( _panel, _g, 240, 20, 240, 60, 250, 20, "statechart",  statechart );
    }
    if (!_publicOnly) {
      drawTransition(_panel, _g, _waiting_pointsX_xjal, _waiting_pointsY_xjal, 260, 185, "waiting", waiting, TransitionIcon.MESSAGE, 284, 183 );
    }
    if (!_publicOnly) {
      drawTransition(_panel, _g, _injure2_pointsX_xjal, _injure2_pointsY_xjal, 220, 355, "injure2", injure2, TransitionIcon.MESSAGE, 230, 395 );
    }
    if (!_publicOnly) {
      drawTransition(_panel, _g, _death_pointsX_xjal, _death_pointsY_xjal, 60, 395, "death", death, TransitionIcon.MESSAGE, 105, 339 );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_PlainVariables_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 425, 296, 10, 0, "leftped_y", leftped_y, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 410, 350, 10, 0, "leftped_x", leftped_x, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 370, 90, 10, 0, "changed_Route", changed_Route, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 371, 135, 10, 0, "ped_infire", ped_infire, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 390, 220, 10, 0, "changed_Route1", changed_Route1, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 580, 170, 15, 0, "ind4", ind4, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 310, 420, 10, 0, "finalroute", finalroute, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 680, 210, 10, 0, "route", route, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 450, 460, 10, 0, "dead_time", dead_time, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 210, 560, 10, 0, "helpis_inside", helpis_inside, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 440, 550, 15, 0, "priority_accept", priority_accept, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 301, 318, 10, 0, "notinjured", notinjured, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 310, 500, 15, 0, "priority_accept_injure", priority_accept_injure, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 610, 310, 10, 0, "target", target, false );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_AgentLinks_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (_publicOnly) { return; }
      drawLinkToContainer( _panel, _g, 50, -100, 10, 0, "main", main );
      drawLinkToAgent( _panel, _g, 50, -50, 15, 0, "connections", true, connections );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void drawModelElements( Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
  	super.drawModelElements( _panel, _g, _publicOnly, true );
    drawModelElements_Statecharts_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_PlainVariables_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_AgentLinks_xjal( _panel, _g, _publicOnly, _isSuperClass );
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_AgentLinks_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if ( modelElementContains(_x, _y, 50, -100) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( 50, -100, this, "main" );
      } else {
        _panel.addInspect( 50, -100, this, "main" );
      }
      return true;
    }
    if ( modelElementContains(_x, _y, 50, -50) ) {
        _panel.addInspect_xjal( 50, -50, this, "connections", Panel.INSPECT_CONNECTIONS_xjal );
      return true;
    }
    return false;
  }


  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_PlainVariables_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 425, 296) ) {
      _panel.addInspect( 425, 296, this, "leftped_y" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 410, 350) ) {
      _panel.addInspect( 410, 350, this, "leftped_x" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 370, 90) ) {
      _panel.addInspect( 370, 90, this, "changed_Route" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 371, 135) ) {
      _panel.addInspect( 371, 135, this, "ped_infire" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 390, 220) ) {
      _panel.addInspect( 390, 220, this, "changed_Route1" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 580, 170) ) {
      _panel.addInspect( 580, 170, this, "ind4" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 310, 420) ) {
      _panel.addInspect( 310, 420, this, "finalroute" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 680, 210) ) {
      _panel.addInspect( 680, 210, this, "route" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 450, 460) ) {
      _panel.addInspect( 450, 460, this, "dead_time" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 210, 560) ) {
      _panel.addInspect( 210, 560, this, "helpis_inside" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 440, 550) ) {
      _panel.addInspect( 440, 550, this, "priority_accept" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 301, 318) ) {
      _panel.addInspect( 301, 318, this, "notinjured" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 310, 500) ) {
      _panel.addInspect( 310, 500, this, "priority_accept_injure" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 610, 310) ) {
      _panel.addInspect( 610, 310, this, "target" ); 
      return true;
    }
    return false;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onClickModelAt( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if ( onClickModelAt_AgentLinks_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_PlainVariables_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    return super.onClickModelAt( _panel, _x, _y, _clickCount, _publicOnly, true );
  }



  @Override
  @AnyLogicInternalCodegenAPI
  public void onArrival() {
    super.onArrival();
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onStep() {
    super.onStep();
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onBeforeStep() {
    super.onBeforeStep();
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onEnterFlowchartBlock(Agent oldBlock, Agent block) {
    super.onEnterFlowchartBlock( oldBlock, block );
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onExitFlowchartBlock(Agent block) {
    super.onExitFlowchartBlock(block);
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onSeizeResource(Agent unit) {
    super.onSeizeResource(unit);
    
 
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void onReleaseResource(Agent unit) {
    super.onReleaseResource(unit);
    
 
  }

  /**
   * Constructor
   */
  public Visitor( Engine engine, Agent owner, AgentList<? extends Visitor> ownerPopulation ) {
    super( engine, owner, ownerPopulation );
    instantiateBaseStructureThis_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void onOwnerChanged_xjal() {
    super.onOwnerChanged_xjal();
    setupReferences_xjal();
  }

  @AnyLogicInternalCodegenAPI
  public void instantiateBaseStructure_xjal() {
    super.instantiateBaseStructure_xjal();
    instantiateBaseStructureThis_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void instantiateBaseStructureThis_xjal() {
    setupReferences_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
    main = get_Main();
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Visitor() {
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_Visitor_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation = new ShapeTopLevelPresentationGroup( Visitor.this, true, 0, 0, 0, 0 , person, citizenDead, citizenDead1, citizenDead2 );
    icon = new ShapeModelElementsGroup( Visitor.this, getElementProperty( "evacuation.Visitor.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( Visitor.class );
  }

  @AnyLogicInternalCodegenAPI
  public void setupExt_xjal(AgentExtension _ext) {
    // Agent properties setup
    if ( _ext instanceof ExtAgentWithSpatialMetrics && _ext instanceof ExtWithSpaceType ) {
      double _value;
      _value = 
uniform(0.85, 1.2) 
;
      ((ExtAgentWithSpatialMetrics) _ext).setSpeed( _value, MPS );
    }
    if ( _ext instanceof ExtAgentWithSpatialMetrics ) {
      ExtAgentWithSpatialMetrics _e = (ExtAgentWithSpatialMetrics) _ext;
      _e.setAutomaticHorizontalRotation( true );
    }
    if ( _ext instanceof ExtAgentContinuous ) {
      ExtAgentContinuous _e = (ExtAgentContinuous) _ext;
      _e.setAutomaticVerticalRotation( false );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doStart() {
    super.doStart();
    statechart.start();
  }
 
  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();
    
 
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    setupPlainVariables_Visitor_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Visitor_xjal() {
    leftped_y = 
 
;
    leftped_x = 
 
;
    changed_Route = 
false 
;
    ped_infire = 
false 
;
    changed_Route1 = 
false 
;
    ind4 = 
0 
;
    finalroute = 
new RectangularNode[13] 
;
    route = 
//main.getPeopleInsideCount(); 
;
    dead_time = 
infinity 
;
    helpis_inside = 
false 
;
    priority_accept = 
false 
;
    notinjured = 
false 
;
    priority_accept_injure = 
false 
;
    target = 
//main.getPeopleInsideCount(); 
;
  }

  // User API -----------------------------------------------------
  public Main get_Main() {
    {
      Agent owner = getOwner();
      if ( owner instanceof Main ) return (Main) owner;
    }
    return null;
  }

  /**
   * Read-only variable. <em>Shouldn't be modified by user.</em>
   */
  @AnyLogicCustomSerialization(AnyLogicCustomSerializationMode.REFERENCE)
  public transient evacuation.Main main;

  @AnyLogicInternalCodegenAPI
  static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( false, black, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

  public LinkToAgentCollection<Agent, Agent> connections = new LinkToAgentStandardImpl<Agent, Agent>(this, _connections_commonAnimationSettings_xjal);
  @Override
  public LinkToAgentCollection<? extends Agent, ? extends Agent> getLinkToAgentStandard_xjal() {
    return connections;
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public void onReceive( Object _msg_xjal, Agent _sender_xjal ) {
    super.onReceive( _msg_xjal, _sender_xjal );
    
Object  msg = (Object) _msg_xjal;
    Agent sender = _sender_xjal;
    

	main.evacuation.pedGoToExit.cancel(this);
	main.evacuation.pedChangeGround.cancel(this);
	main.evacuation.pedGoToExit1.cancel(this);
	main.evacuation.pedGoToExit2.cancel(this);
	main.evacuation.pedLongWait.free(this);

	main.evacuation.pedShortWait.cancel(this);
	main.evacuation.helpgotoped.cancel(this);
	main.evacuation.helpgotoped1.cancel(this);
	main.evacuation.pedShortWait1.cancel(this);
	main.evacuation.pedChangeGround1.cancel(this);
	//main.evacuation.pedGoToStairs.cancel(this);
	main.evacuation.pedWindowWait.cancel(this); 
    statechart.fireEvent( _msg_xjal );
  }



  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public AgentList<? extends Visitor> getPopulation() {
    return (AgentList<? extends Visitor>) super.getPopulation();
  }

  public List<? extends Visitor> agentsInRange( double distance ) {
    return (List<? extends Visitor>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(LoggingType loggingType) {
    return false;
  }

  // Reaction on changes -------------------------------------
  public void onChange() {
    super.onChange();
    statechart.onChange();
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    statechart.onDestroy();
    // On destroy code
    
 
    super.onDestroy();
  }

  // Additional class code

 
  // End of additional class code


  public int getId() {
    return super.getId();
  }

  public com.anylogic.libraries.pedestrian.PedSettings getSettings() {
  	return ext(com.anylogic.libraries.pedestrian.PedExtension.class).getSettings();
  }

  public Ground getGround() {
    return ext(com.anylogic.libraries.pedestrian.PedExtension.class).getGround();
  }

  public com.anylogic.libraries.pedestrian.PedGroup getGroup() {
    return ext(com.anylogic.libraries.pedestrian.PedExtension.class).getGroup();
  }

  @AnyLogicCustomProposalType(AnyLogicCustomProposalType.Label.METER)
  public double getDiameter() {
    return ext(com.anylogic.libraries.pedestrian.PedExtension.class).getDiameter();
  }
  
  public double getDiameter(LengthUnits units) {
    return ext(com.anylogic.libraries.pedestrian.PedExtension.class).getDiameter(units);
  }

  public void setDiameter(double diameter) {
    ext(com.anylogic.libraries.pedestrian.PedExtension.class).setDiameter(diameter);
  }
  
  public void setDiameter(double diameter, LengthUnits units) {
    ext(com.anylogic.libraries.pedestrian.PedExtension.class).setDiameter(diameter, units);
  }
  
  @AnyLogicCustomProposalType(AnyLogicCustomProposalType.Label.METER)
  public double getRadius() {
    return ext(com.anylogic.libraries.pedestrian.PedExtension.class).getRadius();
  }
  
  public double getRadius(LengthUnits units) {
    return ext(com.anylogic.libraries.pedestrian.PedExtension.class).getRadius(units);
  }

  public void setRadius(double radius) {
    ext(com.anylogic.libraries.pedestrian.PedExtension.class).setRadius(radius);
  }
  
  public void setRadius(double radius, LengthUnits units) {
    ext(com.anylogic.libraries.pedestrian.PedExtension.class).setRadius(radius, units);
  }

  @AnyLogicCustomProposalType(AnyLogicCustomProposalType.Label.MPS)
  public double getComfortableSpeed() {
    return ext(com.anylogic.libraries.pedestrian.PedExtension.class).getComfortableSpeed();
  }
  
  public double getComfortableSpeed(SpeedUnits units) {
    return ext(com.anylogic.libraries.pedestrian.PedExtension.class).getComfortableSpeed(units);
  }

  public void setComfortableSpeed(double comfortableSpeed) {
    ext(com.anylogic.libraries.pedestrian.PedExtension.class).setComfortableSpeed(comfortableSpeed);
  }
  
  public void setComfortableSpeed(double comfortableSpeed, SpeedUnits units) {
    ext(com.anylogic.libraries.pedestrian.PedExtension.class).setComfortableSpeed(comfortableSpeed, units);
  }

}
