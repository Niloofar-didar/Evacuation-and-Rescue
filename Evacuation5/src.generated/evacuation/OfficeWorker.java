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

 

public class OfficeWorker extends evacuation.Visitor
        implements IPedestrian
{
  // Parameters

 
  public 
Attractor  table;

  /**
   * Returns default value for parameter <code>table</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Attractor _table_DefaultValue_xjal() {
    final OfficeWorker self = this;
    return 
null 
;
  }

  public void set_table( Attractor table ) {
    if (table == this.table) {
      return;
    }
    Attractor _oldValue_xjal = this.table;
    this.table = table;
    onChange_table_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter table.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_table()</code> method instead.
   */
  protected void onChange_table() {
    onChange_table_xjal( table );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_table_xjal( Attractor oldValue ) {

 
;  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    table = _table_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "table":
      if ( _callOnChange_xjal ) {
        set_table( (Attractor) _value_xjal );
      } else {
        table = (Attractor) _value_xjal;
      }
      return true;
    default:
      return super.setParameter( _name_xjal, _value_xjal, _callOnChange_xjal );
    }
  }

  @Override
  public <T> T getParameter(String _name_xjal) {
    Object _result_xjal;
    switch ( _name_xjal ) {
    case "table": _result_xjal = table; break;
    default: _result_xjal = super.getParameter( _name_xjal ); break;
    }
    return (T) _result_xjal;
  }

  @AnyLogicInternalCodegenAPI
  private static String[] _parameterNames_xjal;

  @Override
  public String[] getParameterNames() {
    String[] result = _parameterNames_xjal;
    if (result == null) {
      List<String> list = new ArrayList<>( Arrays.asList( super.getParameterNames() ) );
      list.add( "table" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

 
  public 
boolean 
 isSmoker;
 
  public 
double 
 worktime;
 
  public 
boolean 
 isHungry;
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( OfficeWorker.class );
  
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
  @AnyLogicInternalCodegenAPI
  protected static final Color[] _officeWorker_customColors_xjal = new Color[] {
    null, new Color( 0x6A5ACD, true ), null, null, null, 
  };
  @AnyLogicInternalCodegenAPI
  protected static final int _officeWorker = evacuation.Visitor._SHAPE_NEXT_ID_xjal + 1;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = evacuation.Visitor._SHAPE_NEXT_ID_xjal + 2;
 

  @AnyLogicInternalCodegenAPI
  public boolean isPublicPresentationDefined() {
    return super.isPublicPresentationDefined() || true;
  }

  @AnyLogicInternalCodegenAPI
  public boolean isEmbeddedAgentPresentationVisible( Agent _a ) {
    return super.isEmbeddedAgentPresentationVisible( _a );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _officeWorker:
        if (true) {
          Shape3DObject self = this.officeWorker;
          
 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
    
  // Stub function for code completion support (internal)
  @AnyLogicInternalCodegenAPI
  private void _stubForReplication_xjal() {
    {
      int _result_xjal = 
 
;
    }
  }

  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _officeWorker_SetDynamicParams_xjal( Shape3DObject shape ) {
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
    shape.setScale(
 
);
    shape.setRotation(
 
);
 	}
  }
  
  protected Shape3DObject officeWorker;
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    officeWorker = new Shape3DObject(
		OfficeWorker.this, SHAPE_DRAW_2D, true, 0.0, 0.0, 0.0, 0.0,
			1.25, false, "/evacuation/",
			"x3d/officeworker.x3d", OBJECT_3D_YZX_AXIS_ORDER, true, 0.0, 0.0,
			1.0, 1.0, 1423815949748L, _officeWorker_customColors_xjal ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _officeWorker_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
  }


  // Static initialization of persistent elements
  {
    _createPersistentElementsBP0_xjal();
  }

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
      case _officeWorker: return officeWorker;
      default: return super.getPersistentShape( _shape ); 
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOfShape_xjal( Object _shape ) {
    try {
      if ( _shape == null ) return null;
      String _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, officeWorker, "officeWorker" ); if (_name_xjal != null) return _name_xjal;
    } catch (Exception e) {
      return null;
    }
    return super.getNameOfShape_xjal( _shape );
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Parameters_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawParameter( _panel, _g, 50, 50, 10, 0, "table", table, 0 );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_PlainVariables_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 50, 100, 10, 0, "isSmoker", isSmoker, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 50, 200, 10, 0, "worktime", worktime, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 50, 150, 10, 0, "isHungry", isHungry, false );
    }
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void drawModelElements( Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
  	super.drawModelElements( _panel, _g, _publicOnly, true );
    drawModelElements_Parameters_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_PlainVariables_xjal( _panel, _g, _publicOnly, _isSuperClass );
  }


  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_Parameters_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 50, 50) ) {
      _panel.addInspect( 50, 50, this, "table" ); 
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_PlainVariables_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 50, 100) ) {
      _panel.addInspect( 50, 100, this, "isSmoker" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 50, 200) ) {
      _panel.addInspect( 50, 200, this, "worktime" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 50, 150) ) {
      _panel.addInspect( 50, 150, this, "isHungry" ); 
      return true;
    }
    return false;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onClickModelAt( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if ( onClickModelAt_Parameters_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
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
  public OfficeWorker( Engine engine, Agent owner, AgentList<? extends OfficeWorker> ownerPopulation ) {
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
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public OfficeWorker() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public OfficeWorker( Attractor table ) {
    markParametersAreSet();
    this.table = table;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_OfficeWorker_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation.initialize_xjal( false, false , officeWorker );
    icon.initialize_xjal( this.<ModelElementDescriptor[]>getElementProperty( "evacuation.OfficeWorker.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ), false, true  );
    icon.setIconOffsets( 0.0, 0.0 );
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( OfficeWorker.class );
  }

  @AnyLogicInternalCodegenAPI
  public void setupExt_xjal(AgentExtension _ext) {
    // Agent properties setup
    if ( _ext instanceof ExtAgentWithSpatialMetrics && _ext instanceof ExtWithSpaceType ) {
      double _value;
      _value = 
10 
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
  }
 
  @AnyLogicInternalCodegenAPI
  public void onStartup() {
    super.onStartup();
    
person.setVisible(false); 
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  public void setupPlainVariables_xjal() {
    super.setupPlainVariables_xjal();
    setupPlainVariables_OfficeWorker_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_OfficeWorker_xjal() {
    isSmoker = 
 
;
    worktime = 
 
;
    isHungry = 
true 
;
  }

  // User API -----------------------------------------------------
  @Override
  @AnyLogicInternalCodegenAPI
  public void onReceive( Object _msg_xjal, Agent _sender_xjal ) {
    super.onReceive( _msg_xjal, _sender_xjal );
    
Object  msg = (Object) _msg_xjal;
    Agent sender = _sender_xjal;
    
 
  }

  public AgentList<? extends OfficeWorker> getPopulation() {
    return (AgentList<? extends OfficeWorker>) super.getPopulation();
  }

  public List<? extends OfficeWorker> agentsInRange( double distance ) {
    return (List<? extends OfficeWorker>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(LoggingType loggingType) {
    return false;
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
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
