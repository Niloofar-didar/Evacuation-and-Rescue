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

import jdk.nashorn.internal.objects.PrototypeObject;
import org.apache.tools.ant.types.resources.Intersect;
import java.awt.geom.Area;
//import com.anylogic.libraries.pedestrian.Messages.DelayType; 

public class Evacuation extends Agent
{
  // Parameters

 
  public 
ArrayList<TargetLine>  exits;

  /**
   * Returns default value for parameter <code>exits</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public ArrayList<TargetLine> _exits_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new ArrayList<TargetLine>() 
;
  }

  public void set_exits( ArrayList<TargetLine> exits ) {
    if (exits == this.exits) {
      return;
    }
    ArrayList<TargetLine> _oldValue_xjal = this.exits;
    this.exits = exits;
    onChange_exits_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter exits.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_exits()</code> method instead.
   */
  protected void onChange_exits() {
    onChange_exits_xjal( exits );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_exits_xjal( ArrayList<TargetLine> oldValue ) {

 
;  
  }


 
  public 
int  condition;

  /**
   * Returns default value for parameter <code>condition</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _condition_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
0 
;
  }

  public void set_condition( int condition ) {
    if (condition == this.condition) {
      return;
    }
    int _oldValue_xjal = this.condition;
    this.condition = condition;
    onChange_condition_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter condition.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_condition()</code> method instead.
   */
  protected void onChange_condition() {
    onChange_condition_xjal( condition );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_condition_xjal( int oldValue ) {

 
;  
  }


  /**
   * //list of sensors that are in red state 
   */
 
  public 
RectangularNode[]  route1;

  /**
   * Returns default value for parameter <code>route1</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public RectangularNode[] _route1_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new RectangularNode[13]
//new RectangularNode(main.s1,main.s3_1,main.s3_2,main.s3_3,main.s5,main.s4,main.s2,main.s6,main.s8,main.s7)//doors + sensors 
;
  }

  public void set_route1( RectangularNode[] route1 ) {
    if (route1 == this.route1) {
      return;
    }
    RectangularNode[] _oldValue_xjal = this.route1;
    this.route1 = route1;
    onChange_route1_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter route1.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_route1()</code> method instead.
   */
  protected void onChange_route1() {
    onChange_route1_xjal( route1 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_route1_xjal( RectangularNode[] oldValue ) {

 
;  
  }


  /**
   * //list of sensors that are in red state 
   */
 
  public 
Visitor[]  helpee;

  /**
   * Returns default value for parameter <code>helpee</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Visitor[] _helpee_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new Visitor [100]//doors + sensors 
;
  }

  public void set_helpee( Visitor[] helpee ) {
    if (helpee == this.helpee) {
      return;
    }
    Visitor[] _oldValue_xjal = this.helpee;
    this.helpee = helpee;
    onChange_helpee_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter helpee.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_helpee()</code> method instead.
   */
  protected void onChange_helpee() {
    onChange_helpee_xjal( helpee );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_helpee_xjal( Visitor[] oldValue ) {

 
;  
  }


  /**
   * //list of sensors that are in red state 
   */
 
  public 
ArrayList< Visitor>  helper;

  /**
   * Returns default value for parameter <code>helper</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public ArrayList< Visitor> _helper_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
//new  [100]//doors + sensors
new ArrayList< Visitor>(){{
}} 
;
  }

  public void set_helper( ArrayList< Visitor> helper ) {
    if (helper == this.helper) {
      return;
    }
    ArrayList< Visitor> _oldValue_xjal = this.helper;
    this.helper = helper;
    onChange_helper_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter helper.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_helper()</code> method instead.
   */
  protected void onChange_helper() {
    onChange_helper_xjal( helper );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_helper_xjal( ArrayList< Visitor> oldValue ) {

 
;  
  }


  /**
   * //list of sensors that are in red state 
   */
 
  public 
int  help_source;

  /**
   * Returns default value for parameter <code>help_source</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _help_source_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
0 
;
  }

  public void set_help_source( int help_source ) {
    if (help_source == this.help_source) {
      return;
    }
    int _oldValue_xjal = this.help_source;
    this.help_source = help_source;
    onChange_help_source_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter help_source.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_help_source()</code> method instead.
   */
  protected void onChange_help_source() {
    onChange_help_source_xjal( help_source );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_help_source_xjal( int oldValue ) {

 
;  
  }


  /**
   * distance= between helpee and its helper<br>
   * +2 = shortwait to be prepare carry him<br>
   * <br>
   * time_to_rescue = distance * (1/agent.getComfortableSpeed);	<br>
   * time_to_rescue+2.0;
   */
 
  public 
double[]  time_to_rescue;

  /**
   * Returns default value for parameter <code>time_to_rescue</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double[] _time_to_rescue_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new double [100]//doors + sensors 
;
  }

  public void set_time_to_rescue( double[] time_to_rescue ) {
    if (time_to_rescue == this.time_to_rescue) {
      return;
    }
    double[] _oldValue_xjal = this.time_to_rescue;
    this.time_to_rescue = time_to_rescue;
    onChange_time_to_rescue_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter time_to_rescue.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_time_to_rescue()</code> method instead.
   */
  protected void onChange_time_to_rescue() {
    onChange_time_to_rescue_xjal( time_to_rescue );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_time_to_rescue_xjal( double[] oldValue ) {

 
;  
  }


  /**
   * time for helpee that fire arrest him<br>
   * = 2*t1*index of closest sensor to helpee
   */
 
  public 
double[]  time_to_death;

  /**
   * Returns default value for parameter <code>time_to_death</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double[] _time_to_death_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new double [100]//doors + sensors 
;
  }

  public void set_time_to_death( double[] time_to_death ) {
    if (time_to_death == this.time_to_death) {
      return;
    }
    double[] _oldValue_xjal = this.time_to_death;
    this.time_to_death = time_to_death;
    onChange_time_to_death_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter time_to_death.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_time_to_death()</code> method instead.
   */
  protected void onChange_time_to_death() {
    onChange_time_to_death_xjal( time_to_death );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_time_to_death_xjal( double[] oldValue ) {

 
;  
  }


  /**
   * the time each helper start moving
   */
 
  public 
double[]  helper_start_time;

  /**
   * Returns default value for parameter <code>helper_start_time</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double[] _helper_start_time_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new double [100]//doors + sensors 
;
  }

  public void set_helper_start_time( double[] helper_start_time ) {
    if (helper_start_time == this.helper_start_time) {
      return;
    }
    double[] _oldValue_xjal = this.helper_start_time;
    this.helper_start_time = helper_start_time;
    onChange_helper_start_time_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter helper_start_time.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_helper_start_time()</code> method instead.
   */
  protected void onChange_helper_start_time() {
    onChange_helper_start_time_xjal( helper_start_time );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_helper_start_time_xjal( double[] oldValue ) {

 
;  
  }


  /**
   * the time each helper start moving
   */
 
  public 
TargetLine[]  helper_targetline;

  /**
   * Returns default value for parameter <code>helper_targetline</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public TargetLine[] _helper_targetline_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new TargetLine [100] 
;
  }

  public void set_helper_targetline( TargetLine[] helper_targetline ) {
    if (helper_targetline == this.helper_targetline) {
      return;
    }
    TargetLine[] _oldValue_xjal = this.helper_targetline;
    this.helper_targetline = helper_targetline;
    onChange_helper_targetline_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter helper_targetline.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_helper_targetline()</code> method instead.
   */
  protected void onChange_helper_targetline() {
    onChange_helper_targetline_xjal( helper_targetline );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_helper_targetline_xjal( TargetLine[] oldValue ) {

 
;  
  }


  /**
   * time last for each helper to start moving
   */
 
  public 
double[]  helper_wait;

  /**
   * Returns default value for parameter <code>helper_wait</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double[] _helper_wait_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new double [100]//doors + sensors 
;
  }

  public void set_helper_wait( double[] helper_wait ) {
    if (helper_wait == this.helper_wait) {
      return;
    }
    double[] _oldValue_xjal = this.helper_wait;
    this.helper_wait = helper_wait;
    onChange_helper_wait_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter helper_wait.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_helper_wait()</code> method instead.
   */
  protected void onChange_helper_wait() {
    onChange_helper_wait_xjal( helper_wait );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_helper_wait_xjal( double[] oldValue ) {

 
;  
  }


  /**
   * the time each helper start moving
   */
 
  public 
TargetLine  predicted_target;

  /**
   * Returns default value for parameter <code>predicted_target</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public TargetLine _predicted_target_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
 
;
  }

  public void set_predicted_target( TargetLine predicted_target ) {
    if (predicted_target == this.predicted_target) {
      return;
    }
    TargetLine _oldValue_xjal = this.predicted_target;
    this.predicted_target = predicted_target;
    onChange_predicted_target_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter predicted_target.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_predicted_target()</code> method instead.
   */
  protected void onChange_predicted_target() {
    onChange_predicted_target_xjal( predicted_target );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_predicted_target_xjal( TargetLine oldValue ) {

 
;  
  }


  /**
   * //list of sensors that are in red state 
   */
 
  public 
RectangularNode[]  route2;

  /**
   * Returns default value for parameter <code>route2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public RectangularNode[] _route2_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new RectangularNode[13]
//new RectangularNode(main.s1,main.s3_1,main.s3_2,main.s3_3,main.s5,main.s4,main.s2,main.s6,main.s8,main.s7)//doors + sensors 
;
  }

  public void set_route2( RectangularNode[] route2 ) {
    if (route2 == this.route2) {
      return;
    }
    RectangularNode[] _oldValue_xjal = this.route2;
    this.route2 = route2;
    onChange_route2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter route2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_route2()</code> method instead.
   */
  protected void onChange_route2() {
    onChange_route2_xjal( route2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_route2_xjal( RectangularNode[] oldValue ) {

 
;  
  }


  /**
   * //list of sensors that are in red state 
   */
 
  public 
RectangularNode[]  route3;

  /**
   * Returns default value for parameter <code>route3</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public RectangularNode[] _route3_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new RectangularNode[13]
//new RectangularNode(main.s1,main.s3_1,main.s3_2,main.s3_3,main.s5,main.s4,main.s2,main.s6,main.s8,main.s7)//doors + sensors 
;
  }

  public void set_route3( RectangularNode[] route3 ) {
    if (route3 == this.route3) {
      return;
    }
    RectangularNode[] _oldValue_xjal = this.route3;
    this.route3 = route3;
    onChange_route3_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter route3.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_route3()</code> method instead.
   */
  protected void onChange_route3() {
    onChange_route3_xjal( route3 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_route3_xjal( RectangularNode[] oldValue ) {

 
;  
  }


  /**
   * //list of sensors that are in red state 
   */
 
  public 
RectangularNode[]  route4;

  /**
   * Returns default value for parameter <code>route4</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public RectangularNode[] _route4_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new RectangularNode[13]
//new RectangularNode(main.s1,main.s3_1,main.s3_2,main.s3_3,main.s5,main.s4,main.s2,main.s6,main.s8,main.s7)//doors + sensors 
;
  }

  public void set_route4( RectangularNode[] route4 ) {
    if (route4 == this.route4) {
      return;
    }
    RectangularNode[] _oldValue_xjal = this.route4;
    this.route4 = route4;
    onChange_route4_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter route4.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_route4()</code> method instead.
   */
  protected void onChange_route4() {
    onChange_route4_xjal( route4 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_route4_xjal( RectangularNode[] oldValue ) {

 
;  
  }


  /**
   * //list of sensors that are in red state 
   */
 
  public 
RectangularNode[]  route5;

  /**
   * Returns default value for parameter <code>route5</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public RectangularNode[] _route5_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new RectangularNode[13]
//new RectangularNode(main.s1,main.s3_1,main.s3_2,main.s3_3,main.s5,main.s4,main.s2,main.s6,main.s8,main.s7)//doors + sensors 
;
  }

  public void set_route5( RectangularNode[] route5 ) {
    if (route5 == this.route5) {
      return;
    }
    RectangularNode[] _oldValue_xjal = this.route5;
    this.route5 = route5;
    onChange_route5_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter route5.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_route5()</code> method instead.
   */
  protected void onChange_route5() {
    onChange_route5_xjal( route5 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_route5_xjal( RectangularNode[] oldValue ) {

 
;  
  }


 
  public 
ArrayList<Pathway>  pathways;

  /**
   * Returns default value for parameter <code>pathways</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public ArrayList<Pathway> _pathways_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new ArrayList<Pathway>() 
;
  }

  public void set_pathways( ArrayList<Pathway> pathways ) {
    if (pathways == this.pathways) {
      return;
    }
    ArrayList<Pathway> _oldValue_xjal = this.pathways;
    this.pathways = pathways;
    onChange_pathways_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter pathways.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_pathways()</code> method instead.
   */
  protected void onChange_pathways() {
    onChange_pathways_xjal( pathways );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_pathways_xjal( ArrayList<Pathway> oldValue ) {

 
;  
  }


  /**
   * time last for each helper to start moving
   */
 
  public 
double[]  temp;

  /**
   * Returns default value for parameter <code>temp</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double[] _temp_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new double [100]//doors + sensors 
;
  }

  public void set_temp( double[] temp ) {
    if (temp == this.temp) {
      return;
    }
    double[] _oldValue_xjal = this.temp;
    this.temp = temp;
    onChange_temp_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter temp.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_temp()</code> method instead.
   */
  protected void onChange_temp() {
    onChange_temp_xjal( temp );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_temp_xjal( double[] oldValue ) {

 
;  
  }


  /**
   * //list of sensors that are in red state 
   */
 
  public 
Visitor[]  injured_helpee;

  /**
   * Returns default value for parameter <code>injured_helpee</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public Visitor[] _injured_helpee_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new Visitor [100]//doors + sensors 
;
  }

  public void set_injured_helpee( Visitor[] injured_helpee ) {
    if (injured_helpee == this.injured_helpee) {
      return;
    }
    Visitor[] _oldValue_xjal = this.injured_helpee;
    this.injured_helpee = injured_helpee;
    onChange_injured_helpee_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter injured_helpee.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_injured_helpee()</code> method instead.
   */
  protected void onChange_injured_helpee() {
    onChange_injured_helpee_xjal( injured_helpee );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_injured_helpee_xjal( Visitor[] oldValue ) {

 
;  
  }


 
  public 
TimeMeasureEnd  time_end;

  /**
   * Returns default value for parameter <code>time_end</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public TimeMeasureEnd _time_end_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
 
;
  }

  public void set_time_end( TimeMeasureEnd time_end ) {
    if (time_end == this.time_end) {
      return;
    }
    TimeMeasureEnd _oldValue_xjal = this.time_end;
    this.time_end = time_end;
    onChange_time_end_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter time_end.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_time_end()</code> method instead.
   */
  protected void onChange_time_end() {
    onChange_time_end_xjal( time_end );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_time_end_xjal( TimeMeasureEnd oldValue ) {

 
;  
  }


  /**
   * time last for each helper to start moving
   */
 
  public 
double[]  temp_dtime;

  /**
   * Returns default value for parameter <code>temp_dtime</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double[] _temp_dtime_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new double [100]//doors + sensors 
;
  }

  public void set_temp_dtime( double[] temp_dtime ) {
    if (temp_dtime == this.temp_dtime) {
      return;
    }
    double[] _oldValue_xjal = this.temp_dtime;
    this.temp_dtime = temp_dtime;
    onChange_temp_dtime_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter temp_dtime.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_temp_dtime()</code> method instead.
   */
  protected void onChange_temp_dtime() {
    onChange_temp_dtime_xjal( temp_dtime );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_temp_dtime_xjal( double[] oldValue ) {

 
;  
  }


  /**
   * distance= between helpee and its helper<br>
   * +2 = shortwait to be prepare carry him<br>
   * <br>
   * time_to_rescue = distance * (1/agent.getComfortableSpeed);	<br>
   * time_to_rescue+2.0;
   */
 
  public 
double[]  helper_recived;

  /**
   * Returns default value for parameter <code>helper_recived</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double[] _helper_recived_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new double [100]//doors + sensors 
;
  }

  public void set_helper_recived( double[] helper_recived ) {
    if (helper_recived == this.helper_recived) {
      return;
    }
    double[] _oldValue_xjal = this.helper_recived;
    this.helper_recived = helper_recived;
    onChange_helper_recived_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter helper_recived.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_helper_recived()</code> method instead.
   */
  protected void onChange_helper_recived() {
    onChange_helper_recived_xjal( helper_recived );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_helper_recived_xjal( double[] oldValue ) {

 
;  
  }


  /**
   * distance= between helpee and its helper<br>
   * +2 = shortwait to be prepare carry him<br>
   * <br>
   * time_to_rescue = distance * (1/agent.getComfortableSpeed);	<br>
   * time_to_rescue+2.0;
   */
 
  public 
double[]  helper_to_rescue;

  /**
   * Returns default value for parameter <code>helper_to_rescue</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double[] _helper_to_rescue_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new double [100]//doors + sensors 
;
  }

  public void set_helper_to_rescue( double[] helper_to_rescue ) {
    if (helper_to_rescue == this.helper_to_rescue) {
      return;
    }
    double[] _oldValue_xjal = this.helper_to_rescue;
    this.helper_to_rescue = helper_to_rescue;
    onChange_helper_to_rescue_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter helper_to_rescue.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_helper_to_rescue()</code> method instead.
   */
  protected void onChange_helper_to_rescue() {
    onChange_helper_to_rescue_xjal( helper_to_rescue );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_helper_to_rescue_xjal( double[] oldValue ) {

 
;  
  }


  /**
   * distance= between helpee and its helper<br>
   * +2 = shortwait to be prepare carry him<br>
   * <br>
   * time_to_rescue = distance * (1/agent.getComfortableSpeed);	<br>
   * time_to_rescue+2.0;
   */
 
  public 
double[]  helpee_predictdead;

  /**
   * Returns default value for parameter <code>helpee_predictdead</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double[] _helpee_predictdead_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new double [100]//doors + sensors 
;
  }

  public void set_helpee_predictdead( double[] helpee_predictdead ) {
    if (helpee_predictdead == this.helpee_predictdead) {
      return;
    }
    double[] _oldValue_xjal = this.helpee_predictdead;
    this.helpee_predictdead = helpee_predictdead;
    onChange_helpee_predictdead_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter helpee_predictdead.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_helpee_predictdead()</code> method instead.
   */
  protected void onChange_helpee_predictdead() {
    onChange_helpee_predictdead_xjal( helpee_predictdead );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_helpee_predictdead_xjal( double[] oldValue ) {

 
;  
  }


  /**
   * distance= between helpee and its helper<br>
   * +2 = shortwait to be prepare carry him<br>
   * <br>
   * time_to_rescue = distance * (1/agent.getComfortableSpeed);	<br>
   * time_to_rescue+2.0;
   */
 
  public 
double[]  helpee_realdead;

  /**
   * Returns default value for parameter <code>helpee_realdead</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double[] _helpee_realdead_DefaultValue_xjal() {
    final Evacuation self = this;
    return 
new double [100]//doors + sensors 
;
  }

  public void set_helpee_realdead( double[] helpee_realdead ) {
    if (helpee_realdead == this.helpee_realdead) {
      return;
    }
    double[] _oldValue_xjal = this.helpee_realdead;
    this.helpee_realdead = helpee_realdead;
    onChange_helpee_realdead_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter helpee_realdead.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_helpee_realdead()</code> method instead.
   */
  protected void onChange_helpee_realdead() {
    onChange_helpee_realdead_xjal( helpee_realdead );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_helpee_realdead_xjal( double[] oldValue ) {

 
;  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    exits = _exits_DefaultValue_xjal();
    condition = _condition_DefaultValue_xjal();
    route1 = _route1_DefaultValue_xjal();
    helpee = _helpee_DefaultValue_xjal();
    helper = _helper_DefaultValue_xjal();
    help_source = _help_source_DefaultValue_xjal();
    time_to_rescue = _time_to_rescue_DefaultValue_xjal();
    time_to_death = _time_to_death_DefaultValue_xjal();
    helper_start_time = _helper_start_time_DefaultValue_xjal();
    helper_targetline = _helper_targetline_DefaultValue_xjal();
    helper_wait = _helper_wait_DefaultValue_xjal();
    predicted_target = _predicted_target_DefaultValue_xjal();
    route2 = _route2_DefaultValue_xjal();
    route3 = _route3_DefaultValue_xjal();
    route4 = _route4_DefaultValue_xjal();
    route5 = _route5_DefaultValue_xjal();
    pathways = _pathways_DefaultValue_xjal();
    temp = _temp_DefaultValue_xjal();
    injured_helpee = _injured_helpee_DefaultValue_xjal();
    time_end = _time_end_DefaultValue_xjal();
    temp_dtime = _temp_dtime_DefaultValue_xjal();
    helper_recived = _helper_recived_DefaultValue_xjal();
    helper_to_rescue = _helper_to_rescue_DefaultValue_xjal();
    helpee_predictdead = _helpee_predictdead_DefaultValue_xjal();
    helpee_realdead = _helpee_realdead_DefaultValue_xjal();
  }

  @Override
  public boolean setParameter(String _name_xjal, Object _value_xjal, boolean _callOnChange_xjal) {
    switch ( _name_xjal ) {
    case "exits":
      if ( _callOnChange_xjal ) {
        set_exits( (ArrayList<TargetLine>) _value_xjal );
      } else {
        exits = (ArrayList<TargetLine>) _value_xjal;
      }
      return true;
    case "condition":
      if ( _callOnChange_xjal ) {
        set_condition( ((Number) _value_xjal).intValue() );
      } else {
        condition = ((Number) _value_xjal).intValue();
      }
      return true;
    case "route1":
      if ( _callOnChange_xjal ) {
        set_route1( (RectangularNode[]) _value_xjal );
      } else {
        route1 = (RectangularNode[]) _value_xjal;
      }
      return true;
    case "helpee":
      if ( _callOnChange_xjal ) {
        set_helpee( (Visitor[]) _value_xjal );
      } else {
        helpee = (Visitor[]) _value_xjal;
      }
      return true;
    case "helper":
      if ( _callOnChange_xjal ) {
        set_helper( (ArrayList< Visitor>) _value_xjal );
      } else {
        helper = (ArrayList< Visitor>) _value_xjal;
      }
      return true;
    case "help_source":
      if ( _callOnChange_xjal ) {
        set_help_source( ((Number) _value_xjal).intValue() );
      } else {
        help_source = ((Number) _value_xjal).intValue();
      }
      return true;
    case "time_to_rescue":
      if ( _callOnChange_xjal ) {
        set_time_to_rescue( (double[]) _value_xjal );
      } else {
        time_to_rescue = (double[]) _value_xjal;
      }
      return true;
    case "time_to_death":
      if ( _callOnChange_xjal ) {
        set_time_to_death( (double[]) _value_xjal );
      } else {
        time_to_death = (double[]) _value_xjal;
      }
      return true;
    case "helper_start_time":
      if ( _callOnChange_xjal ) {
        set_helper_start_time( (double[]) _value_xjal );
      } else {
        helper_start_time = (double[]) _value_xjal;
      }
      return true;
    case "helper_targetline":
      if ( _callOnChange_xjal ) {
        set_helper_targetline( (TargetLine[]) _value_xjal );
      } else {
        helper_targetline = (TargetLine[]) _value_xjal;
      }
      return true;
    case "helper_wait":
      if ( _callOnChange_xjal ) {
        set_helper_wait( (double[]) _value_xjal );
      } else {
        helper_wait = (double[]) _value_xjal;
      }
      return true;
    case "predicted_target":
      if ( _callOnChange_xjal ) {
        set_predicted_target( (TargetLine) _value_xjal );
      } else {
        predicted_target = (TargetLine) _value_xjal;
      }
      return true;
    case "route2":
      if ( _callOnChange_xjal ) {
        set_route2( (RectangularNode[]) _value_xjal );
      } else {
        route2 = (RectangularNode[]) _value_xjal;
      }
      return true;
    case "route3":
      if ( _callOnChange_xjal ) {
        set_route3( (RectangularNode[]) _value_xjal );
      } else {
        route3 = (RectangularNode[]) _value_xjal;
      }
      return true;
    case "route4":
      if ( _callOnChange_xjal ) {
        set_route4( (RectangularNode[]) _value_xjal );
      } else {
        route4 = (RectangularNode[]) _value_xjal;
      }
      return true;
    case "route5":
      if ( _callOnChange_xjal ) {
        set_route5( (RectangularNode[]) _value_xjal );
      } else {
        route5 = (RectangularNode[]) _value_xjal;
      }
      return true;
    case "pathways":
      if ( _callOnChange_xjal ) {
        set_pathways( (ArrayList<Pathway>) _value_xjal );
      } else {
        pathways = (ArrayList<Pathway>) _value_xjal;
      }
      return true;
    case "temp":
      if ( _callOnChange_xjal ) {
        set_temp( (double[]) _value_xjal );
      } else {
        temp = (double[]) _value_xjal;
      }
      return true;
    case "injured_helpee":
      if ( _callOnChange_xjal ) {
        set_injured_helpee( (Visitor[]) _value_xjal );
      } else {
        injured_helpee = (Visitor[]) _value_xjal;
      }
      return true;
    case "time_end":
      if ( _callOnChange_xjal ) {
        set_time_end( (TimeMeasureEnd) _value_xjal );
      } else {
        time_end = (TimeMeasureEnd) _value_xjal;
      }
      return true;
    case "temp_dtime":
      if ( _callOnChange_xjal ) {
        set_temp_dtime( (double[]) _value_xjal );
      } else {
        temp_dtime = (double[]) _value_xjal;
      }
      return true;
    case "helper_recived":
      if ( _callOnChange_xjal ) {
        set_helper_recived( (double[]) _value_xjal );
      } else {
        helper_recived = (double[]) _value_xjal;
      }
      return true;
    case "helper_to_rescue":
      if ( _callOnChange_xjal ) {
        set_helper_to_rescue( (double[]) _value_xjal );
      } else {
        helper_to_rescue = (double[]) _value_xjal;
      }
      return true;
    case "helpee_predictdead":
      if ( _callOnChange_xjal ) {
        set_helpee_predictdead( (double[]) _value_xjal );
      } else {
        helpee_predictdead = (double[]) _value_xjal;
      }
      return true;
    case "helpee_realdead":
      if ( _callOnChange_xjal ) {
        set_helpee_realdead( (double[]) _value_xjal );
      } else {
        helpee_realdead = (double[]) _value_xjal;
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
    case "exits": _result_xjal = exits; break;
    case "condition": _result_xjal = condition; break;
    case "route1": _result_xjal = route1; break;
    case "helpee": _result_xjal = helpee; break;
    case "helper": _result_xjal = helper; break;
    case "help_source": _result_xjal = help_source; break;
    case "time_to_rescue": _result_xjal = time_to_rescue; break;
    case "time_to_death": _result_xjal = time_to_death; break;
    case "helper_start_time": _result_xjal = helper_start_time; break;
    case "helper_targetline": _result_xjal = helper_targetline; break;
    case "helper_wait": _result_xjal = helper_wait; break;
    case "predicted_target": _result_xjal = predicted_target; break;
    case "route2": _result_xjal = route2; break;
    case "route3": _result_xjal = route3; break;
    case "route4": _result_xjal = route4; break;
    case "route5": _result_xjal = route5; break;
    case "pathways": _result_xjal = pathways; break;
    case "temp": _result_xjal = temp; break;
    case "injured_helpee": _result_xjal = injured_helpee; break;
    case "time_end": _result_xjal = time_end; break;
    case "temp_dtime": _result_xjal = temp_dtime; break;
    case "helper_recived": _result_xjal = helper_recived; break;
    case "helper_to_rescue": _result_xjal = helper_to_rescue; break;
    case "helpee_predictdead": _result_xjal = helpee_predictdead; break;
    case "helpee_realdead": _result_xjal = helpee_realdead; break;
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
      list.add( "exits" );
      list.add( "condition" );
      list.add( "route1" );
      list.add( "helpee" );
      list.add( "helper" );
      list.add( "help_source" );
      list.add( "time_to_rescue" );
      list.add( "time_to_death" );
      list.add( "helper_start_time" );
      list.add( "helper_targetline" );
      list.add( "helper_wait" );
      list.add( "predicted_target" );
      list.add( "route2" );
      list.add( "route3" );
      list.add( "route4" );
      list.add( "route5" );
      list.add( "pathways" );
      list.add( "temp" );
      list.add( "injured_helpee" );
      list.add( "time_end" );
      list.add( "temp_dtime" );
      list.add( "helper_recived" );
      list.add( "helper_to_rescue" );
      list.add( "helpee_predictdead" );
      list.add( "helpee_realdead" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

 
  public 
long 
 peopleinside;
 
  public 
int 
 ind;
 
  public 
int 
 ind2;
 
  public 
int 
 ind3;
 
  public 
int 
 indexofhelper;
 
  public 
long 
 people_helped;
 
  public 
long 
 people_helper;
 
  public 
int 
 wait_time;
 
  public 
Pathway 
 route;
 
  public 
int 
 injured_ind;
 
  public 
long 
 injured_people_helped;
 
  public 
int 
 helper_canceled;
 
  public 
boolean 
 firsthelper;
  /**
   * count of people inside and alive when helper arrives
   */
 
  public 
long 
 inside_alive;
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( Evacuation.class );
  
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

  // Embedded Objects

 
  public com.anylogic.libraries.pedestrian.PedGoTo<
Visitor 
> pedGoToExit1;
 
  public com.anylogic.libraries.pedestrian.PedGoTo<
Visitor 
> pedGoToExit;
 
  public com.anylogic.libraries.pedestrian.PedSink<
Visitor 
> pedSink;
 
  public com.anylogic.libraries.processmodeling.SelectOutput<
Visitor 
> selectOutput;
 
  public com.anylogic.libraries.processmodeling.TimeMeasureEnd<
Visitor 
> timeMeasureEnd;
 
  public com.anylogic.libraries.pedestrian.PedSelectOutput<
Visitor 
> pedSelectOutput1;
 
  public com.anylogic.libraries.pedestrian.PedWait<
Visitor 
> pedLongWait;
 
  public com.anylogic.libraries.pedestrian.PedChangeGround<
Visitor 
> pedChangeGround;
 
  public com.anylogic.libraries.processmodeling.SelectOutput<
Visitor 
> selectOutput3;
 
  public com.anylogic.libraries.pedestrian.PedWait<
Visitor 
> peddead;
 
  public com.anylogic.libraries.pedestrian.PedSelectOutput<
Visitor 
> pedSelectOutput2;
 
  public com.anylogic.libraries.processmodeling.SelectOutput<
Visitor 
> changeroute;
 
  public com.anylogic.libraries.pedestrian.PedGoTo<
Visitor 
> pedGoToExit2;
 
  public com.anylogic.libraries.pedestrian.PedGoTo<
Visitor 
> helpgotoped;
 
  public com.anylogic.libraries.pedestrian.PedSource<
Help 
> helpsource;
 
  public com.anylogic.libraries.pedestrian.PedWait<
Visitor 
> pedShortWait1;
 
  public com.anylogic.libraries.pedestrian.PedChangeGround<
Visitor 
> pedChangeGround1;
 
  public com.anylogic.libraries.pedestrian.PedGoTo<
Visitor 
> helpgotoped1;
 
  public com.anylogic.libraries.processmodeling.SelectOutput<
Visitor 
> selectOutput5;
 
  public com.anylogic.libraries.pedestrian.PedWait<
Visitor 
> pedShortWait;
 
  public com.anylogic.libraries.processmodeling.TimeMeasureStart<
Visitor 
> timeMeasureStart;
 
  public com.anylogic.libraries.pedestrian.PedWait<
Visitor 
> pedWindowWait;
 
  public com.anylogic.libraries.pedestrian.PedSelectOutput<
Visitor 
> pedSelectOutput3;
 
  public com.anylogic.libraries.pedestrian.PedGoTo<
Visitor 
> pedGoToExit4;
 
  public com.anylogic.libraries.pedestrian.PedSelectOutput<
Visitor 
> pedSelectOutput4;
 
  public com.anylogic.libraries.pedestrian.PedSelectOutput<
Visitor 
> pedSelectOutput5;
 
  public com.anylogic.libraries.pedestrian.PedChangeGround<
Visitor 
> pedChangeGround2;
 
  public com.anylogic.libraries.pedestrian.PedWait<
Visitor 
> helpsearch;
 
  public com.anylogic.libraries.pedestrian.PedSelectOutput<
Visitor 
> pedSelectOutput6;
 
  public com.anylogic.libraries.pedestrian.PedChangeGround<
Visitor 
> pedChangeGround3;
 
  public com.anylogic.libraries.pedestrian.PedWait<
Visitor 
> ped_realdead;
 
  public com.anylogic.libraries.pedestrian.PedGoTo<
Visitor 
> gotoped;
 
  public com.anylogic.libraries.processmodeling.TimeMeasureStart<
Visitor 
> timeMeasureStart1;
 
  public com.anylogic.libraries.pedestrian.PedSelectOutput<
Visitor 
> pedSelectOutput7;
 
  public com.anylogic.libraries.pedestrian.PedGoTo<
Visitor 
> pedGoToExit3;

  public String getNameOf( Agent ao ) {
    if ( ao == pedGoToExit1 ) return "pedGoToExit1";
    if ( ao == pedGoToExit ) return "pedGoToExit";
    if ( ao == pedSink ) return "pedSink";
    if ( ao == selectOutput ) return "selectOutput";
    if ( ao == timeMeasureEnd ) return "timeMeasureEnd";
    if ( ao == pedSelectOutput1 ) return "pedSelectOutput1";
    if ( ao == pedLongWait ) return "pedLongWait";
    if ( ao == pedChangeGround ) return "pedChangeGround";
    if ( ao == selectOutput3 ) return "selectOutput3";
    if ( ao == peddead ) return "peddead";
    if ( ao == pedSelectOutput2 ) return "pedSelectOutput2";
    if ( ao == changeroute ) return "changeroute";
    if ( ao == pedGoToExit2 ) return "pedGoToExit2";
    if ( ao == helpgotoped ) return "helpgotoped";
    if ( ao == helpsource ) return "helpsource";
    if ( ao == pedShortWait1 ) return "pedShortWait1";
    if ( ao == pedChangeGround1 ) return "pedChangeGround1";
    if ( ao == helpgotoped1 ) return "helpgotoped1";
    if ( ao == selectOutput5 ) return "selectOutput5";
    if ( ao == pedShortWait ) return "pedShortWait";
    if ( ao == timeMeasureStart ) return "timeMeasureStart";
    if ( ao == pedWindowWait ) return "pedWindowWait";
    if ( ao == pedSelectOutput3 ) return "pedSelectOutput3";
    if ( ao == pedGoToExit4 ) return "pedGoToExit4";
    if ( ao == pedSelectOutput4 ) return "pedSelectOutput4";
    if ( ao == pedSelectOutput5 ) return "pedSelectOutput5";
    if ( ao == pedChangeGround2 ) return "pedChangeGround2";
    if ( ao == helpsearch ) return "helpsearch";
    if ( ao == pedSelectOutput6 ) return "pedSelectOutput6";
    if ( ao == pedChangeGround3 ) return "pedChangeGround3";
    if ( ao == ped_realdead ) return "ped_realdead";
    if ( ao == gotoped ) return "gotoped";
    if ( ao == timeMeasureStart1 ) return "timeMeasureStart1";
    if ( ao == pedSelectOutput7 ) return "pedSelectOutput7";
    if ( ao == pedGoToExit3 ) return "pedGoToExit3";
    return super.getNameOf( ao );
  }

  public AgentAnimationSettings getAnimationSettingsOf( Agent ao ) {
    return super.getAnimationSettingsOf( ao );
  }


  public String getNameOf( AgentList<?> aolist ) {
    return super.getNameOf( aolist );
  }
  
  public AgentAnimationSettings getAnimationSettingsOf( AgentList<?> aolist ) {
    return super.getAnimationSettingsOf( aolist );
  }


  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedGoTo<Visitor> instantiate_pedGoToExit1_xjal() {
    com.anylogic.libraries.pedestrian.PedGoTo<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedGoTo<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _pedGoToExit1_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _pedGoToExit1_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _pedGoToExit1_locationY_xjal( this, ped );
      }
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _pedGoToExit1_locationArea_xjal( this, ped );
      }
      @Override
      public Pathway route( Visitor ped ) {
        return _pedGoToExit1_route_xjal( this, ped );
      }
      @Override
      public boolean walkInReverseDirection( Visitor ped ) {
        return _pedGoToExit1_walkInReverseDirection_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_reachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedGoToExit1_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedGoToExit1_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedGoToExit1_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedGoToExit1_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToExit1_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    setupParameters_pedGoToExit1_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToExit1_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    create_pedGoToExit1_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToExit1_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
    self.mode = 
self.MODE_REACH_TARGET 
;
    self.locationType = 
self.LOCATION_LINE 
;
    self.reachTolerance = 
10 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToExit1_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedGoTo<Visitor> instantiate_pedGoToExit_xjal() {
    com.anylogic.libraries.pedestrian.PedGoTo<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedGoTo<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _pedGoToExit_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _pedGoToExit_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _pedGoToExit_locationY_xjal( this, ped );
      }
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _pedGoToExit_locationArea_xjal( this, ped );
      }
      @Override
      public Pathway route( Visitor ped ) {
        return _pedGoToExit_route_xjal( this, ped );
      }
      @Override
      public boolean walkInReverseDirection( Visitor ped ) {
        return _pedGoToExit_walkInReverseDirection_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_reachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedGoToExit_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedGoToExit_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedGoToExit_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedGoToExit_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    setupParameters_pedGoToExit_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToExit_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    create_pedGoToExit_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
    self.mode = 
self.MODE_REACH_TARGET 
;
    self.locationType = 
self.LOCATION_LINE 
;
    self.reachTolerance = 
10 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToExit_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSink<Visitor> instantiate_pedSink_xjal() {
    com.anylogic.libraries.pedestrian.PedSink<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedSink<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public void onEnter( Visitor ped ) {
        _pedSink_onEnter_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSink_xjal( final com.anylogic.libraries.pedestrian.PedSink<Visitor> self ) {
    setupParameters_pedSink_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSink_xjal( com.anylogic.libraries.pedestrian.PedSink<Visitor> self ) {
    create_pedSink_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSink_xjal( final com.anylogic.libraries.pedestrian.PedSink<Visitor> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSink_xjal( com.anylogic.libraries.pedestrian.PedSink<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.SelectOutput<Visitor> instantiate_selectOutput_xjal() {
    com.anylogic.libraries.processmodeling.SelectOutput<Visitor> _result_xjal = new com.anylogic.libraries.processmodeling.SelectOutput<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition( Visitor agent ) {
        return _selectOutput_condition_xjal( this, agent );
      }
      @Override
      public double probability( Visitor agent ) {
        return _selectOutput_probability_xjal( this, agent );
      }
      @Override
      public void onEnter( Visitor agent ) {
        _selectOutput_onEnter_xjal( this, agent );
      }
      @Override
      public void onExitTrue( Visitor agent ) {
        _selectOutput_onExitTrue_xjal( this, agent );
      }
      @Override
      public void onExitFalse( Visitor agent ) {
        _selectOutput_onExitFalse_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self ) {
    setupParameters_selectOutput_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_selectOutput_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self ) {
    create_selectOutput_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, TableInput _t ) {
    self.conditionIsProbabilistic = 
false 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_selectOutput_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.TimeMeasureEnd<Visitor> instantiate_timeMeasureEnd_xjal() {
    com.anylogic.libraries.processmodeling.TimeMeasureEnd<Visitor> _result_xjal = new com.anylogic.libraries.processmodeling.TimeMeasureEnd<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public void onEnter( Visitor agent ) {
        _timeMeasureEnd_onEnter_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_timeMeasureEnd_xjal( final com.anylogic.libraries.processmodeling.TimeMeasureEnd<Visitor> self ) {
    setupParameters_timeMeasureEnd_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_timeMeasureEnd_xjal( com.anylogic.libraries.processmodeling.TimeMeasureEnd<Visitor> self ) {
    create_timeMeasureEnd_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_timeMeasureEnd_xjal( final com.anylogic.libraries.processmodeling.TimeMeasureEnd<Visitor> self, TableInput _t ) {
    self.startObjects = new com.anylogic.libraries.processmodeling.TimeMeasureStart[]
{timeMeasureStart,timeMeasureStart1}; 
;
    self.datasetCapacity = 
1000 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_timeMeasureEnd_xjal( com.anylogic.libraries.processmodeling.TimeMeasureEnd<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> instantiate_pedSelectOutput1_xjal() {
    com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition1( Visitor ped ) {
        return _pedSelectOutput1_condition1_xjal( this, ped );
      }
      @Override
      public boolean condition2( Visitor ped ) {
        return _pedSelectOutput1_condition2_xjal( this, ped );
      }
      @Override
      public boolean condition3( Visitor ped ) {
        return _pedSelectOutput1_condition3_xjal( this, ped );
      }
      @Override
      public boolean condition4( Visitor ped ) {
        return _pedSelectOutput1_condition4_xjal( this, ped );
      }
      @Override
      public double probability1( Visitor ped ) {
        return _pedSelectOutput1_probability1_xjal( this, ped );
      }
      @Override
      public double probability2( Visitor ped ) {
        return _pedSelectOutput1_probability2_xjal( this, ped );
      }
      @Override
      public double probability3( Visitor ped ) {
        return _pedSelectOutput1_probability3_xjal( this, ped );
      }
      @Override
      public double probability4( Visitor ped ) {
        return _pedSelectOutput1_probability4_xjal( this, ped );
      }
      @Override
      public double probability5( Visitor ped ) {
        return _pedSelectOutput1_probability5_xjal( this, ped );
      }
      @Override
      public int exitNumber( Visitor ped ) {
        return _pedSelectOutput1_exitNumber_xjal( this, ped );
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedSelectOutput1_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit1( Visitor ped ) {
        _pedSelectOutput1_onExit1_xjal( this, ped );
      }
      @Override
      public void onExit2( Visitor ped ) {
        _pedSelectOutput1_onExit2_xjal( this, ped );
      }
      @Override
      public void onExit3( Visitor ped ) {
        _pedSelectOutput1_onExit3_xjal( this, ped );
      }
      @Override
      public void onExit4( Visitor ped ) {
        _pedSelectOutput1_onExit4_xjal( this, ped );
      }
      @Override
      public void onExit5( Visitor ped ) {
        _pedSelectOutput1_onExit5_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self ) {
    setupParameters_pedSelectOutput1_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput1_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self ) {
    create_pedSelectOutput1_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, TableInput _t ) {
    self.type = 
self.TYPE_CONDITIONS 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput1_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedWait<Visitor> instantiate_pedLongWait_xjal() {
    com.anylogic.libraries.pedestrian.PedWait<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedWait<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _pedLongWait_locationArea_xjal( this, ped );
      }
      @Override
      public Attractor attractor( AreaNode areaNode, Visitor ped ) {
        return _pedLongWait_attractor_xjal( this, areaNode, ped );
      }
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _pedLongWait_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _pedLongWait_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _pedLongWait_locationY_xjal( this, ped );
      }
      @Override
      public double delayTimeout( Visitor ped ) {
        return _pedLongWait_delayTimeout_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTimeout() {
        return MINUTE;
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_targetReachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedLongWait_onEnter_xjal( this, ped );
      }
      @Override
      public void onBeginWait( Visitor ped ) {
        _pedLongWait_onBeginWait_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedLongWait_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedLongWait_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedLongWait_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedLongWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    setupParameters_pedLongWait_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedLongWait_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    create_pedLongWait_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedLongWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
    self.locationType = 
self.LOCATION_POINT 
;
    self.attractorChoice = 
self.ATTRACTOR_CHOICE_NONE 
;
    self.delayType = 
self.DELAY_MANUAL 
;
    self.delayStartsWhen = 
self.DELAY_STARTS_SINCE_BEGIN_WAIT 
;
    self.maximumCapacity = 
true 
;
    self.capacity = 
1 
;
    self.targetReachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedLongWait_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> instantiate_pedChangeGround_xjal() {
    com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedChangeGround<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine exitLine( Visitor ped ) {
        return _pedChangeGround_exitLine_xjal( this, ped );
      }
      @Override
      public TargetLine entryLine( Visitor ped ) {
        return _pedChangeGround_entryLine_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_reachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedChangeGround_onEnter_xjal( this, ped );
      }
      @Override
      public void onExitGround( Visitor ped, Ground ground ) {
        _pedChangeGround_onExitGround_xjal( this, ped, ground );
      }
      @Override
      public void onEnterGround( Visitor ped, Ground ground ) {
        _pedChangeGround_onEnterGround_xjal( this, ped, ground );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedChangeGround_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedChangeGround_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedChangeGround_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self ) {
    setupParameters_pedChangeGround_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedChangeGround_xjal( com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self ) {
    create_pedChangeGround_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedChangeGround_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, TableInput _t ) {
    self.reachTolerance = 
0.35 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedChangeGround_xjal( com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.SelectOutput<Visitor> instantiate_selectOutput3_xjal() {
    com.anylogic.libraries.processmodeling.SelectOutput<Visitor> _result_xjal = new com.anylogic.libraries.processmodeling.SelectOutput<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition( Visitor agent ) {
        return _selectOutput3_condition_xjal( this, agent );
      }
      @Override
      public double probability( Visitor agent ) {
        return _selectOutput3_probability_xjal( this, agent );
      }
      @Override
      public void onEnter( Visitor agent ) {
        _selectOutput3_onEnter_xjal( this, agent );
      }
      @Override
      public void onExitTrue( Visitor agent ) {
        _selectOutput3_onExitTrue_xjal( this, agent );
      }
      @Override
      public void onExitFalse( Visitor agent ) {
        _selectOutput3_onExitFalse_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput3_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self ) {
    setupParameters_selectOutput3_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_selectOutput3_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self ) {
    create_selectOutput3_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput3_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, TableInput _t ) {
    self.conditionIsProbabilistic = 
false 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_selectOutput3_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedWait<Visitor> instantiate_peddead_xjal() {
    com.anylogic.libraries.pedestrian.PedWait<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedWait<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _peddead_locationArea_xjal( this, ped );
      }
      @Override
      public Attractor attractor( AreaNode areaNode, Visitor ped ) {
        return _peddead_attractor_xjal( this, areaNode, ped );
      }
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _peddead_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _peddead_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _peddead_locationY_xjal( this, ped );
      }
      @Override
      public double delayTimeout( Visitor ped ) {
        return _peddead_delayTimeout_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTimeout() {
        return MINUTE;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _peddead_onEnter_xjal( this, ped );
      }
      @Override
      public void onBeginWait( Visitor ped ) {
        _peddead_onBeginWait_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _peddead_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _peddead_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _peddead_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_peddead_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    setupParameters_peddead_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_peddead_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    create_peddead_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_peddead_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
    self.locationType = 
self.LOCATION_POINT 
;
    self.attractorChoice = 
self.ATTRACTOR_CHOICE_NONE 
;
    self.delayType = 
self.DELAY_TIMEOUT 
;
    self.delayStartsWhen = 
self.DELAY_STARTS_SINCE_BEGIN_WAIT 
;
    self.maximumCapacity = 
true 
;
    self.capacity = 
1 
;
    self.targetReachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_peddead_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> instantiate_pedSelectOutput2_xjal() {
    com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition1( Visitor ped ) {
        return _pedSelectOutput2_condition1_xjal( this, ped );
      }
      @Override
      public boolean condition2( Visitor ped ) {
        return _pedSelectOutput2_condition2_xjal( this, ped );
      }
      @Override
      public boolean condition3( Visitor ped ) {
        return _pedSelectOutput2_condition3_xjal( this, ped );
      }
      @Override
      public boolean condition4( Visitor ped ) {
        return _pedSelectOutput2_condition4_xjal( this, ped );
      }
      @Override
      public double probability1( Visitor ped ) {
        return _pedSelectOutput2_probability1_xjal( this, ped );
      }
      @Override
      public double probability2( Visitor ped ) {
        return _pedSelectOutput2_probability2_xjal( this, ped );
      }
      @Override
      public double probability3( Visitor ped ) {
        return _pedSelectOutput2_probability3_xjal( this, ped );
      }
      @Override
      public double probability4( Visitor ped ) {
        return _pedSelectOutput2_probability4_xjal( this, ped );
      }
      @Override
      public double probability5( Visitor ped ) {
        return _pedSelectOutput2_probability5_xjal( this, ped );
      }
      @Override
      public int exitNumber( Visitor ped ) {
        return _pedSelectOutput2_exitNumber_xjal( this, ped );
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedSelectOutput2_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit1( Visitor ped ) {
        _pedSelectOutput2_onExit1_xjal( this, ped );
      }
      @Override
      public void onExit2( Visitor ped ) {
        _pedSelectOutput2_onExit2_xjal( this, ped );
      }
      @Override
      public void onExit3( Visitor ped ) {
        _pedSelectOutput2_onExit3_xjal( this, ped );
      }
      @Override
      public void onExit4( Visitor ped ) {
        _pedSelectOutput2_onExit4_xjal( this, ped );
      }
      @Override
      public void onExit5( Visitor ped ) {
        _pedSelectOutput2_onExit5_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self ) {
    setupParameters_pedSelectOutput2_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput2_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self ) {
    create_pedSelectOutput2_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, TableInput _t ) {
    self.type = 
self.TYPE_CONDITIONS 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput2_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.SelectOutput<Visitor> instantiate_changeroute_xjal() {
    com.anylogic.libraries.processmodeling.SelectOutput<Visitor> _result_xjal = new com.anylogic.libraries.processmodeling.SelectOutput<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition( Visitor agent ) {
        return _changeroute_condition_xjal( this, agent );
      }
      @Override
      public double probability( Visitor agent ) {
        return _changeroute_probability_xjal( this, agent );
      }
      @Override
      public void onEnter( Visitor agent ) {
        _changeroute_onEnter_xjal( this, agent );
      }
      @Override
      public void onExitTrue( Visitor agent ) {
        _changeroute_onExitTrue_xjal( this, agent );
      }
      @Override
      public void onExitFalse( Visitor agent ) {
        _changeroute_onExitFalse_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_changeroute_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self ) {
    setupParameters_changeroute_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_changeroute_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self ) {
    create_changeroute_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_changeroute_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, TableInput _t ) {
    self.conditionIsProbabilistic = 
false 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_changeroute_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedGoTo<Visitor> instantiate_pedGoToExit2_xjal() {
    com.anylogic.libraries.pedestrian.PedGoTo<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedGoTo<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _pedGoToExit2_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _pedGoToExit2_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _pedGoToExit2_locationY_xjal( this, ped );
      }
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _pedGoToExit2_locationArea_xjal( this, ped );
      }
      @Override
      public Pathway route( Visitor ped ) {
        return _pedGoToExit2_route_xjal( this, ped );
      }
      @Override
      public boolean walkInReverseDirection( Visitor ped ) {
        return _pedGoToExit2_walkInReverseDirection_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_reachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedGoToExit2_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedGoToExit2_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedGoToExit2_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedGoToExit2_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToExit2_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    setupParameters_pedGoToExit2_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToExit2_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    create_pedGoToExit2_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToExit2_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
    self.mode = 
self.MODE_FOLLOW_ROUTE 
;
    self.locationType = 
self.LOCATION_LINE 
;
    self.reachTolerance = 
10 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToExit2_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedGoTo<Visitor> instantiate_helpgotoped_xjal() {
    com.anylogic.libraries.pedestrian.PedGoTo<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedGoTo<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _helpgotoped_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _helpgotoped_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _helpgotoped_locationY_xjal( this, ped );
      }
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _helpgotoped_locationArea_xjal( this, ped );
      }
      @Override
      public Pathway route( Visitor ped ) {
        return _helpgotoped_route_xjal( this, ped );
      }
      @Override
      public boolean walkInReverseDirection( Visitor ped ) {
        return _helpgotoped_walkInReverseDirection_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_reachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _helpgotoped_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _helpgotoped_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _helpgotoped_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _helpgotoped_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_helpgotoped_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    setupParameters_helpgotoped_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_helpgotoped_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    create_helpgotoped_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_helpgotoped_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
    self.mode = 
self.MODE_REACH_TARGET 
;
    self.locationType = 
self.LOCATION_POINT 
;
    self.reachTolerance = 
0.35 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_helpgotoped_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSource<Help> instantiate_helpsource_xjal() {
    com.anylogic.libraries.pedestrian.PedSource<Help> _result_xjal = new com.anylogic.libraries.pedestrian.PedSource<Help>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine locationLine( Help ped ) {
        return _helpsource_locationLine_xjal( this, ped );
      }
      @Override
      public Ground ground( Help ped ) {
        return _helpsource_ground_xjal( this, ped );
      }
      @Override
      public double locationX( Help ped ) {
        return _helpsource_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Help ped ) {
        return _helpsource_locationY_xjal( this, ped );
      }
      @Override
      public AreaNode locationArea( Help ped ) {
        return _helpsource_locationArea_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public RateUnits getUnitsForCodeOf_rate() {
        return PER_MINUTE;
      }
      @Override
      public double interarrivalTime(  ) {
        return _helpsource_interarrivalTime_xjal( this );
      }
      @Override
      public double rateExpression( double baseRate ) {
        return _helpsource_rateExpression_xjal( this, baseRate );
      }
      @Override
      public Agent newPed(  ) {
        return _helpsource_newPed_xjal( this );
      }
      @Override
      public double comfortableSpeed( Help ped ) {
        return _helpsource_comfortableSpeed_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_comfortableSpeed() {
        return MPS;
      }
      @Override
      public double initialSpeed( Help ped ) {
        return _helpsource_initialSpeed_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public SpeedUnits getUnitsForCodeOf_initialSpeed() {
        return MPS;
      }
      @Override
      public double diameter( Help ped ) {
        return _helpsource_diameter_xjal( this, ped );
      }
      @Override
      public int groupSize( Help leader ) {
        return _helpsource_groupSize_xjal( this, leader );
      }
      @Override
      public double groupMemberInterarrivalTime(  ) {
        return _helpsource_groupMemberInterarrivalTime_xjal( this );
      }
      @Override
      public AgentList population( Help ped ) {
        return _helpsource_population_xjal( this, ped );
      }
      @Override
      public void onExit( Help ped ) {
        _helpsource_onExit_xjal( this, ped );
      }
      @Override
      public void onBeginGrouping( com.anylogic.libraries.pedestrian.PedGroup group, Help leader ) {
        _helpsource_onBeginGrouping_xjal( this, group, leader );
      }
      @Override
      public void onEndGrouping( com.anylogic.libraries.pedestrian.PedGroup group, Help leader ) {
        _helpsource_onEndGrouping_xjal( this, group, leader );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_helpsource_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self ) {
    setupParameters_helpsource_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_helpsource_xjal( com.anylogic.libraries.pedestrian.PedSource<Help> self ) {
    create_helpsource_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_helpsource_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, TableInput _t ) {
    self.locationType = 
self.LOCATION_LINE 
;
    self.arrivalType = 
self.MANUAL 
;
    self.rate = 
newvisitorArrivalRate 
;
    self.rate = PER_MINUTE.convertTo( self.rate, PER_HOUR );
    self.rateSchedule = 
visitorsArrivalRate 
;
    self.modifyRate = 
false 
;
    self.arrivalSchedule = 
visitorsArrivalRate 
;
    self.limitArrivals = 
true 
;
    self.maxArrivals = 
30 
;
    self.createGroups = 
false 
;
    self.groupFormation = 
self.GROUP_FORMATION_SWARM 
;
    self.serviceGroupBehavior = 
self.SGB_INDIVIDUAL_SERVING 
;
    self.solidCancelling = 
true 
;
    self.addToCustomPopulation = 
true 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_helpsource_xjal( com.anylogic.libraries.pedestrian.PedSource<Help> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedWait<Visitor> instantiate_pedShortWait1_xjal() {
    com.anylogic.libraries.pedestrian.PedWait<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedWait<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _pedShortWait1_locationArea_xjal( this, ped );
      }
      @Override
      public Attractor attractor( AreaNode areaNode, Visitor ped ) {
        return _pedShortWait1_attractor_xjal( this, areaNode, ped );
      }
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _pedShortWait1_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _pedShortWait1_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _pedShortWait1_locationY_xjal( this, ped );
      }
      @Override
      public double delayTimeout( Visitor ped ) {
        return _pedShortWait1_delayTimeout_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTimeout() {
        return SECOND;
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_targetReachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedShortWait1_onEnter_xjal( this, ped );
      }
      @Override
      public void onBeginWait( Visitor ped ) {
        _pedShortWait1_onBeginWait_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedShortWait1_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedShortWait1_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedShortWait1_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedShortWait1_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    setupParameters_pedShortWait1_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedShortWait1_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    create_pedShortWait1_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedShortWait1_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
    self.locationType = 
self.LOCATION_POINT 
;
    self.attractorChoice = 
self.ATTRACTOR_CHOICE_NONE 
;
    self.delayType = 
self.DELAY_TIMEOUT 
;
    self.delayStartsWhen = 
self.DELAY_STARTS_SINCE_BEGIN_WAIT 
;
    self.maximumCapacity = 
true 
;
    self.capacity = 
1 
;
    self.targetReachTolerance = 
0.11 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedShortWait1_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> instantiate_pedChangeGround1_xjal() {
    com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedChangeGround<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine exitLine( Visitor ped ) {
        return _pedChangeGround1_exitLine_xjal( this, ped );
      }
      @Override
      public TargetLine entryLine( Visitor ped ) {
        return _pedChangeGround1_entryLine_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_reachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedChangeGround1_onEnter_xjal( this, ped );
      }
      @Override
      public void onExitGround( Visitor ped, Ground ground ) {
        _pedChangeGround1_onExitGround_xjal( this, ped, ground );
      }
      @Override
      public void onEnterGround( Visitor ped, Ground ground ) {
        _pedChangeGround1_onEnterGround_xjal( this, ped, ground );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedChangeGround1_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedChangeGround1_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedChangeGround1_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self ) {
    setupParameters_pedChangeGround1_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedChangeGround1_xjal( com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self ) {
    create_pedChangeGround1_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedChangeGround1_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, TableInput _t ) {
    self.reachTolerance = 
0.4 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedChangeGround1_xjal( com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedGoTo<Visitor> instantiate_helpgotoped1_xjal() {
    com.anylogic.libraries.pedestrian.PedGoTo<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedGoTo<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _helpgotoped1_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _helpgotoped1_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _helpgotoped1_locationY_xjal( this, ped );
      }
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _helpgotoped1_locationArea_xjal( this, ped );
      }
      @Override
      public Pathway route( Visitor ped ) {
        return _helpgotoped1_route_xjal( this, ped );
      }
      @Override
      public boolean walkInReverseDirection( Visitor ped ) {
        return _helpgotoped1_walkInReverseDirection_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_reachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _helpgotoped1_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _helpgotoped1_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _helpgotoped1_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _helpgotoped1_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_helpgotoped1_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    setupParameters_helpgotoped1_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_helpgotoped1_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    create_helpgotoped1_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_helpgotoped1_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
    self.mode = 
self.MODE_REACH_TARGET 
;
    self.locationType = 
self.LOCATION_POINT 
;
    self.reachTolerance = 
0.35 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_helpgotoped1_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.SelectOutput<Visitor> instantiate_selectOutput5_xjal() {
    com.anylogic.libraries.processmodeling.SelectOutput<Visitor> _result_xjal = new com.anylogic.libraries.processmodeling.SelectOutput<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition( Visitor agent ) {
        return _selectOutput5_condition_xjal( this, agent );
      }
      @Override
      public double probability( Visitor agent ) {
        return _selectOutput5_probability_xjal( this, agent );
      }
      @Override
      public void onEnter( Visitor agent ) {
        _selectOutput5_onEnter_xjal( this, agent );
      }
      @Override
      public void onExitTrue( Visitor agent ) {
        _selectOutput5_onExitTrue_xjal( this, agent );
      }
      @Override
      public void onExitFalse( Visitor agent ) {
        _selectOutput5_onExitFalse_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput5_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self ) {
    setupParameters_selectOutput5_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_selectOutput5_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self ) {
    create_selectOutput5_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_selectOutput5_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, TableInput _t ) {
    self.conditionIsProbabilistic = 
false 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_selectOutput5_xjal( com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedWait<Visitor> instantiate_pedShortWait_xjal() {
    com.anylogic.libraries.pedestrian.PedWait<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedWait<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _pedShortWait_locationArea_xjal( this, ped );
      }
      @Override
      public Attractor attractor( AreaNode areaNode, Visitor ped ) {
        return _pedShortWait_attractor_xjal( this, areaNode, ped );
      }
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _pedShortWait_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _pedShortWait_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _pedShortWait_locationY_xjal( this, ped );
      }
      @Override
      public double delayTimeout( Visitor ped ) {
        return _pedShortWait_delayTimeout_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTimeout() {
        return MINUTE;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedShortWait_onEnter_xjal( this, ped );
      }
      @Override
      public void onBeginWait( Visitor ped ) {
        _pedShortWait_onBeginWait_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedShortWait_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedShortWait_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedShortWait_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedShortWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    setupParameters_pedShortWait_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedShortWait_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    create_pedShortWait_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedShortWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
    self.locationType = 
self.LOCATION_LINE 
;
    self.attractorChoice = 
self.ATTRACTOR_CHOICE_NONE 
;
    self.delayType = 
self.DELAY_TIMEOUT 
;
    self.delayStartsWhen = 
self.DELAY_STARTS_SINCE_BEGIN_WAIT 
;
    self.maximumCapacity = 
true 
;
    self.capacity = 
1 
;
    self.targetReachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedShortWait_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor> instantiate_timeMeasureStart_xjal() {
    com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor> _result_xjal = new com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public void onEnter( Visitor agent ) {
        _timeMeasureStart_onEnter_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_timeMeasureStart_xjal( final com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor> self ) {
    setupParameters_timeMeasureStart_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_timeMeasureStart_xjal( com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor> self ) {
    create_timeMeasureStart_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_timeMeasureStart_xjal( final com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_timeMeasureStart_xjal( com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedWait<Visitor> instantiate_pedWindowWait_xjal() {
    com.anylogic.libraries.pedestrian.PedWait<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedWait<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _pedWindowWait_locationArea_xjal( this, ped );
      }
      @Override
      public Attractor attractor( AreaNode areaNode, Visitor ped ) {
        return _pedWindowWait_attractor_xjal( this, areaNode, ped );
      }
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _pedWindowWait_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _pedWindowWait_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _pedWindowWait_locationY_xjal( this, ped );
      }
      @Override
      public double delayTimeout( Visitor ped ) {
        return _pedWindowWait_delayTimeout_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTimeout() {
        return MINUTE;
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_targetReachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedWindowWait_onEnter_xjal( this, ped );
      }
      @Override
      public void onBeginWait( Visitor ped ) {
        _pedWindowWait_onBeginWait_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedWindowWait_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedWindowWait_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedWindowWait_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedWindowWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    setupParameters_pedWindowWait_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedWindowWait_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    create_pedWindowWait_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedWindowWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
    self.locationType = 
self.LOCATION_LINE 
;
    self.attractorChoice = 
self.ATTRACTOR_CHOICE_NONE 
;
    self.delayType = 
self.DELAY_TIMEOUT 
;
    self.delayStartsWhen = 
self.DELAY_STARTS_SINCE_BEGIN_WAIT 
;
    self.maximumCapacity = 
true 
;
    self.capacity = 
1 
;
    self.targetReachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedWindowWait_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> instantiate_pedSelectOutput3_xjal() {
    com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition1( Visitor ped ) {
        return _pedSelectOutput3_condition1_xjal( this, ped );
      }
      @Override
      public boolean condition2( Visitor ped ) {
        return _pedSelectOutput3_condition2_xjal( this, ped );
      }
      @Override
      public boolean condition3( Visitor ped ) {
        return _pedSelectOutput3_condition3_xjal( this, ped );
      }
      @Override
      public boolean condition4( Visitor ped ) {
        return _pedSelectOutput3_condition4_xjal( this, ped );
      }
      @Override
      public double probability1( Visitor ped ) {
        return _pedSelectOutput3_probability1_xjal( this, ped );
      }
      @Override
      public double probability2( Visitor ped ) {
        return _pedSelectOutput3_probability2_xjal( this, ped );
      }
      @Override
      public double probability3( Visitor ped ) {
        return _pedSelectOutput3_probability3_xjal( this, ped );
      }
      @Override
      public double probability4( Visitor ped ) {
        return _pedSelectOutput3_probability4_xjal( this, ped );
      }
      @Override
      public double probability5( Visitor ped ) {
        return _pedSelectOutput3_probability5_xjal( this, ped );
      }
      @Override
      public int exitNumber( Visitor ped ) {
        return _pedSelectOutput3_exitNumber_xjal( this, ped );
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedSelectOutput3_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit1( Visitor ped ) {
        _pedSelectOutput3_onExit1_xjal( this, ped );
      }
      @Override
      public void onExit2( Visitor ped ) {
        _pedSelectOutput3_onExit2_xjal( this, ped );
      }
      @Override
      public void onExit3( Visitor ped ) {
        _pedSelectOutput3_onExit3_xjal( this, ped );
      }
      @Override
      public void onExit4( Visitor ped ) {
        _pedSelectOutput3_onExit4_xjal( this, ped );
      }
      @Override
      public void onExit5( Visitor ped ) {
        _pedSelectOutput3_onExit5_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self ) {
    setupParameters_pedSelectOutput3_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput3_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self ) {
    create_pedSelectOutput3_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, TableInput _t ) {
    self.type = 
self.TYPE_CONDITIONS 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput3_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedGoTo<Visitor> instantiate_pedGoToExit4_xjal() {
    com.anylogic.libraries.pedestrian.PedGoTo<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedGoTo<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _pedGoToExit4_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _pedGoToExit4_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _pedGoToExit4_locationY_xjal( this, ped );
      }
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _pedGoToExit4_locationArea_xjal( this, ped );
      }
      @Override
      public Pathway route( Visitor ped ) {
        return _pedGoToExit4_route_xjal( this, ped );
      }
      @Override
      public boolean walkInReverseDirection( Visitor ped ) {
        return _pedGoToExit4_walkInReverseDirection_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_reachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedGoToExit4_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedGoToExit4_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedGoToExit4_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedGoToExit4_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToExit4_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    setupParameters_pedGoToExit4_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToExit4_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    create_pedGoToExit4_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToExit4_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
    self.mode = 
self.MODE_FOLLOW_ROUTE 
;
    self.locationType = 
self.LOCATION_LINE 
;
    self.reachTolerance = 
10 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToExit4_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> instantiate_pedSelectOutput4_xjal() {
    com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition1( Visitor ped ) {
        return _pedSelectOutput4_condition1_xjal( this, ped );
      }
      @Override
      public boolean condition2( Visitor ped ) {
        return _pedSelectOutput4_condition2_xjal( this, ped );
      }
      @Override
      public boolean condition3( Visitor ped ) {
        return _pedSelectOutput4_condition3_xjal( this, ped );
      }
      @Override
      public boolean condition4( Visitor ped ) {
        return _pedSelectOutput4_condition4_xjal( this, ped );
      }
      @Override
      public double probability1( Visitor ped ) {
        return _pedSelectOutput4_probability1_xjal( this, ped );
      }
      @Override
      public double probability2( Visitor ped ) {
        return _pedSelectOutput4_probability2_xjal( this, ped );
      }
      @Override
      public double probability3( Visitor ped ) {
        return _pedSelectOutput4_probability3_xjal( this, ped );
      }
      @Override
      public double probability4( Visitor ped ) {
        return _pedSelectOutput4_probability4_xjal( this, ped );
      }
      @Override
      public double probability5( Visitor ped ) {
        return _pedSelectOutput4_probability5_xjal( this, ped );
      }
      @Override
      public int exitNumber( Visitor ped ) {
        return _pedSelectOutput4_exitNumber_xjal( this, ped );
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedSelectOutput4_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit1( Visitor ped ) {
        _pedSelectOutput4_onExit1_xjal( this, ped );
      }
      @Override
      public void onExit2( Visitor ped ) {
        _pedSelectOutput4_onExit2_xjal( this, ped );
      }
      @Override
      public void onExit3( Visitor ped ) {
        _pedSelectOutput4_onExit3_xjal( this, ped );
      }
      @Override
      public void onExit4( Visitor ped ) {
        _pedSelectOutput4_onExit4_xjal( this, ped );
      }
      @Override
      public void onExit5( Visitor ped ) {
        _pedSelectOutput4_onExit5_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self ) {
    setupParameters_pedSelectOutput4_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput4_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self ) {
    create_pedSelectOutput4_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, TableInput _t ) {
    self.type = 
self.TYPE_CONDITIONS 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput4_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> instantiate_pedSelectOutput5_xjal() {
    com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition1( Visitor ped ) {
        return _pedSelectOutput5_condition1_xjal( this, ped );
      }
      @Override
      public boolean condition2( Visitor ped ) {
        return _pedSelectOutput5_condition2_xjal( this, ped );
      }
      @Override
      public boolean condition3( Visitor ped ) {
        return _pedSelectOutput5_condition3_xjal( this, ped );
      }
      @Override
      public boolean condition4( Visitor ped ) {
        return _pedSelectOutput5_condition4_xjal( this, ped );
      }
      @Override
      public double probability1( Visitor ped ) {
        return _pedSelectOutput5_probability1_xjal( this, ped );
      }
      @Override
      public double probability2( Visitor ped ) {
        return _pedSelectOutput5_probability2_xjal( this, ped );
      }
      @Override
      public double probability3( Visitor ped ) {
        return _pedSelectOutput5_probability3_xjal( this, ped );
      }
      @Override
      public double probability4( Visitor ped ) {
        return _pedSelectOutput5_probability4_xjal( this, ped );
      }
      @Override
      public double probability5( Visitor ped ) {
        return _pedSelectOutput5_probability5_xjal( this, ped );
      }
      @Override
      public int exitNumber( Visitor ped ) {
        return _pedSelectOutput5_exitNumber_xjal( this, ped );
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedSelectOutput5_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit1( Visitor ped ) {
        _pedSelectOutput5_onExit1_xjal( this, ped );
      }
      @Override
      public void onExit2( Visitor ped ) {
        _pedSelectOutput5_onExit2_xjal( this, ped );
      }
      @Override
      public void onExit3( Visitor ped ) {
        _pedSelectOutput5_onExit3_xjal( this, ped );
      }
      @Override
      public void onExit4( Visitor ped ) {
        _pedSelectOutput5_onExit4_xjal( this, ped );
      }
      @Override
      public void onExit5( Visitor ped ) {
        _pedSelectOutput5_onExit5_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self ) {
    setupParameters_pedSelectOutput5_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput5_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self ) {
    create_pedSelectOutput5_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, TableInput _t ) {
    self.type = 
self.TYPE_CONDITIONS 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput5_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> instantiate_pedChangeGround2_xjal() {
    com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedChangeGround<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine exitLine( Visitor ped ) {
        return _pedChangeGround2_exitLine_xjal( this, ped );
      }
      @Override
      public TargetLine entryLine( Visitor ped ) {
        return _pedChangeGround2_entryLine_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_reachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedChangeGround2_onEnter_xjal( this, ped );
      }
      @Override
      public void onExitGround( Visitor ped, Ground ground ) {
        _pedChangeGround2_onExitGround_xjal( this, ped, ground );
      }
      @Override
      public void onEnterGround( Visitor ped, Ground ground ) {
        _pedChangeGround2_onEnterGround_xjal( this, ped, ground );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedChangeGround2_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedChangeGround2_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedChangeGround2_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self ) {
    setupParameters_pedChangeGround2_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedChangeGround2_xjal( com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self ) {
    create_pedChangeGround2_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedChangeGround2_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, TableInput _t ) {
    self.reachTolerance = 
0.35 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedChangeGround2_xjal( com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedWait<Visitor> instantiate_helpsearch_xjal() {
    com.anylogic.libraries.pedestrian.PedWait<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedWait<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _helpsearch_locationArea_xjal( this, ped );
      }
      @Override
      public Attractor attractor( AreaNode areaNode, Visitor ped ) {
        return _helpsearch_attractor_xjal( this, areaNode, ped );
      }
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _helpsearch_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _helpsearch_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _helpsearch_locationY_xjal( this, ped );
      }
      @Override
      public double delayTimeout( Visitor ped ) {
        return _helpsearch_delayTimeout_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTimeout() {
        return SECOND;
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_targetReachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _helpsearch_onEnter_xjal( this, ped );
      }
      @Override
      public void onBeginWait( Visitor ped ) {
        _helpsearch_onBeginWait_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _helpsearch_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _helpsearch_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _helpsearch_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_helpsearch_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    setupParameters_helpsearch_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_helpsearch_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    create_helpsearch_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_helpsearch_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
    self.locationType = 
self.LOCATION_POINT 
;
    self.attractorChoice = 
self.ATTRACTOR_CHOICE_NONE 
;
    self.delayType = 
self.DELAY_TIMEOUT 
;
    self.delayStartsWhen = 
self.DELAY_STARTS_SINCE_BEGIN_WAIT 
;
    self.maximumCapacity = 
true 
;
    self.capacity = 
1 
;
    self.targetReachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_helpsearch_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> instantiate_pedSelectOutput6_xjal() {
    com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition1( Visitor ped ) {
        return _pedSelectOutput6_condition1_xjal( this, ped );
      }
      @Override
      public boolean condition2( Visitor ped ) {
        return _pedSelectOutput6_condition2_xjal( this, ped );
      }
      @Override
      public boolean condition3( Visitor ped ) {
        return _pedSelectOutput6_condition3_xjal( this, ped );
      }
      @Override
      public boolean condition4( Visitor ped ) {
        return _pedSelectOutput6_condition4_xjal( this, ped );
      }
      @Override
      public double probability1( Visitor ped ) {
        return _pedSelectOutput6_probability1_xjal( this, ped );
      }
      @Override
      public double probability2( Visitor ped ) {
        return _pedSelectOutput6_probability2_xjal( this, ped );
      }
      @Override
      public double probability3( Visitor ped ) {
        return _pedSelectOutput6_probability3_xjal( this, ped );
      }
      @Override
      public double probability4( Visitor ped ) {
        return _pedSelectOutput6_probability4_xjal( this, ped );
      }
      @Override
      public double probability5( Visitor ped ) {
        return _pedSelectOutput6_probability5_xjal( this, ped );
      }
      @Override
      public int exitNumber( Visitor ped ) {
        return _pedSelectOutput6_exitNumber_xjal( this, ped );
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedSelectOutput6_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit1( Visitor ped ) {
        _pedSelectOutput6_onExit1_xjal( this, ped );
      }
      @Override
      public void onExit2( Visitor ped ) {
        _pedSelectOutput6_onExit2_xjal( this, ped );
      }
      @Override
      public void onExit3( Visitor ped ) {
        _pedSelectOutput6_onExit3_xjal( this, ped );
      }
      @Override
      public void onExit4( Visitor ped ) {
        _pedSelectOutput6_onExit4_xjal( this, ped );
      }
      @Override
      public void onExit5( Visitor ped ) {
        _pedSelectOutput6_onExit5_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput6_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self ) {
    setupParameters_pedSelectOutput6_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput6_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self ) {
    create_pedSelectOutput6_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput6_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, TableInput _t ) {
    self.type = 
self.TYPE_CONDITIONS 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput6_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> instantiate_pedChangeGround3_xjal() {
    com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedChangeGround<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine exitLine( Visitor ped ) {
        return _pedChangeGround3_exitLine_xjal( this, ped );
      }
      @Override
      public TargetLine entryLine( Visitor ped ) {
        return _pedChangeGround3_entryLine_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_reachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedChangeGround3_onEnter_xjal( this, ped );
      }
      @Override
      public void onExitGround( Visitor ped, Ground ground ) {
        _pedChangeGround3_onExitGround_xjal( this, ped, ground );
      }
      @Override
      public void onEnterGround( Visitor ped, Ground ground ) {
        _pedChangeGround3_onEnterGround_xjal( this, ped, ground );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedChangeGround3_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedChangeGround3_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedChangeGround3_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self ) {
    setupParameters_pedChangeGround3_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedChangeGround3_xjal( com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self ) {
    create_pedChangeGround3_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedChangeGround3_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, TableInput _t ) {
    self.reachTolerance = 
0.4 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedChangeGround3_xjal( com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedWait<Visitor> instantiate_ped_realdead_xjal() {
    com.anylogic.libraries.pedestrian.PedWait<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedWait<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _ped_realdead_locationArea_xjal( this, ped );
      }
      @Override
      public Attractor attractor( AreaNode areaNode, Visitor ped ) {
        return _ped_realdead_attractor_xjal( this, areaNode, ped );
      }
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _ped_realdead_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _ped_realdead_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _ped_realdead_locationY_xjal( this, ped );
      }
      @Override
      public double delayTimeout( Visitor ped ) {
        return _ped_realdead_delayTimeout_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public TimeUnits getUnitsForCodeOf_delayTimeout() {
        return MINUTE;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _ped_realdead_onEnter_xjal( this, ped );
      }
      @Override
      public void onBeginWait( Visitor ped ) {
        _ped_realdead_onBeginWait_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _ped_realdead_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _ped_realdead_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _ped_realdead_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_ped_realdead_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    setupParameters_ped_realdead_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_ped_realdead_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self ) {
    create_ped_realdead_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_ped_realdead_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
    self.locationType = 
self.LOCATION_POINT 
;
    self.attractorChoice = 
self.ATTRACTOR_CHOICE_NONE 
;
    self.delayType = 
self.DELAY_MANUAL 
;
    self.delayStartsWhen = 
self.DELAY_STARTS_SINCE_BEGIN_WAIT 
;
    self.maximumCapacity = 
true 
;
    self.capacity = 
1 
;
    self.targetReachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_ped_realdead_xjal( com.anylogic.libraries.pedestrian.PedWait<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedGoTo<Visitor> instantiate_gotoped_xjal() {
    com.anylogic.libraries.pedestrian.PedGoTo<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedGoTo<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _gotoped_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _gotoped_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _gotoped_locationY_xjal( this, ped );
      }
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _gotoped_locationArea_xjal( this, ped );
      }
      @Override
      public Pathway route( Visitor ped ) {
        return _gotoped_route_xjal( this, ped );
      }
      @Override
      public boolean walkInReverseDirection( Visitor ped ) {
        return _gotoped_walkInReverseDirection_xjal( this, ped );
      }
      @Override
      public void onEnter( Visitor ped ) {
        _gotoped_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _gotoped_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _gotoped_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _gotoped_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_gotoped_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    setupParameters_gotoped_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_gotoped_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    create_gotoped_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_gotoped_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
    self.mode = 
self.MODE_REACH_TARGET 
;
    self.locationType = 
self.LOCATION_POINT 
;
    self.reachTolerance = 
0.25 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_gotoped_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor> instantiate_timeMeasureStart1_xjal() {
    com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor> _result_xjal = new com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public void onEnter( Visitor agent ) {
        _timeMeasureStart1_onEnter_xjal( this, agent );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_timeMeasureStart1_xjal( final com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor> self ) {
    setupParameters_timeMeasureStart1_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_timeMeasureStart1_xjal( com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor> self ) {
    create_timeMeasureStart1_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_timeMeasureStart1_xjal( final com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor> self, TableInput _t ) {
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_timeMeasureStart1_xjal( com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> instantiate_pedSelectOutput7_xjal() {
    com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public boolean condition1( Visitor ped ) {
        return _pedSelectOutput7_condition1_xjal( this, ped );
      }
      @Override
      public boolean condition2( Visitor ped ) {
        return _pedSelectOutput7_condition2_xjal( this, ped );
      }
      @Override
      public boolean condition3( Visitor ped ) {
        return _pedSelectOutput7_condition3_xjal( this, ped );
      }
      @Override
      public boolean condition4( Visitor ped ) {
        return _pedSelectOutput7_condition4_xjal( this, ped );
      }
      @Override
      public double probability1( Visitor ped ) {
        return _pedSelectOutput7_probability1_xjal( this, ped );
      }
      @Override
      public double probability2( Visitor ped ) {
        return _pedSelectOutput7_probability2_xjal( this, ped );
      }
      @Override
      public double probability3( Visitor ped ) {
        return _pedSelectOutput7_probability3_xjal( this, ped );
      }
      @Override
      public double probability4( Visitor ped ) {
        return _pedSelectOutput7_probability4_xjal( this, ped );
      }
      @Override
      public double probability5( Visitor ped ) {
        return _pedSelectOutput7_probability5_xjal( this, ped );
      }
      @Override
      public int exitNumber( Visitor ped ) {
        return _pedSelectOutput7_exitNumber_xjal( this, ped );
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedSelectOutput7_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit1( Visitor ped ) {
        _pedSelectOutput7_onExit1_xjal( this, ped );
      }
      @Override
      public void onExit2( Visitor ped ) {
        _pedSelectOutput7_onExit2_xjal( this, ped );
      }
      @Override
      public void onExit3( Visitor ped ) {
        _pedSelectOutput7_onExit3_xjal( this, ped );
      }
      @Override
      public void onExit4( Visitor ped ) {
        _pedSelectOutput7_onExit4_xjal( this, ped );
      }
      @Override
      public void onExit5( Visitor ped ) {
        _pedSelectOutput7_onExit5_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput7_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self ) {
    setupParameters_pedSelectOutput7_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput7_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self ) {
    create_pedSelectOutput7_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedSelectOutput7_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, TableInput _t ) {
    self.type = 
self.TYPE_CONDITIONS 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedSelectOutput7_xjal( com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }
  /**
   * Creates an embedded object instance<br>
   * <i>This method should not be called by user</i>
   */
  protected com.anylogic.libraries.pedestrian.PedGoTo<Visitor> instantiate_pedGoToExit3_xjal() {
    com.anylogic.libraries.pedestrian.PedGoTo<Visitor> _result_xjal = new com.anylogic.libraries.pedestrian.PedGoTo<Visitor>( getEngine(), this, null ) {
      // Additional class code

 
      // End of additional class code
      @Override
      public TargetLine locationLine( Visitor ped ) {
        return _pedGoToExit3_locationLine_xjal( this, ped );
      }
      @Override
      public double locationX( Visitor ped ) {
        return _pedGoToExit3_locationX_xjal( this, ped );
      }
      @Override
      public double locationY( Visitor ped ) {
        return _pedGoToExit3_locationY_xjal( this, ped );
      }
      @Override
      public AreaNode locationArea( Visitor ped ) {
        return _pedGoToExit3_locationArea_xjal( this, ped );
      }
      @Override
      public Pathway route( Visitor ped ) {
        return _pedGoToExit3_route_xjal( this, ped );
      }
      @Override
      public boolean walkInReverseDirection( Visitor ped ) {
        return _pedGoToExit3_walkInReverseDirection_xjal( this, ped );
      }

      @AnyLogicInternalCodegenAPI
      public LengthUnits getUnitsForCodeOf_reachTolerance() {
        return METER;
      }
      @Override
      public void onEnter( Visitor ped ) {
        _pedGoToExit3_onEnter_xjal( this, ped );
      }
      @Override
      public void onExit( Visitor ped ) {
        _pedGoToExit3_onExit_xjal( this, ped );
      }
      @Override
      public void onCancel( Visitor ped ) {
        _pedGoToExit3_onCancel_xjal( this, ped );
      }
      @Override
      public void onRemove( Visitor ped ) {
        _pedGoToExit3_onRemove_xjal( this, ped );
      }
	};
    
    return _result_xjal;
  }

  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToExit3_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    setupParameters_pedGoToExit3_xjal( self, null );
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToExit3_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self ) {
    create_pedGoToExit3_xjal(self, null );
  }


  /**
   * Setups parameters of an embedded object instance<br>
   * This method should not be called by user
   */
  private void setupParameters_pedGoToExit3_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
    self.mode = 
self.MODE_REACH_TARGET 
;
    self.locationType = 
self.LOCATION_LINE 
;
    self.reachTolerance = 
10 
;
  }

  /**
   * Setups an embedded object instance<br>
   * This method should not be called by user
   */
  @AnyLogicInternalCodegenAPI
  private void create_pedGoToExit3_xjal( com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, TableInput _t ) {
	double _initial_speed = 
10 
;
	self.setSpeed(_initial_speed, MPS);
	IRouteProvider _v1_xjal = 
 ;
	self.setRouteProvider( _v1_xjal );
    self.create();

  }

  private TargetLine _pedGoToExit1_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
exits.get(1) 
;
    return _value;
  }
  private double _pedGoToExit1_locationX_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private double _pedGoToExit1_locationY_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private AreaNode _pedGoToExit1_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private Pathway _pedGoToExit1_route_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    Pathway _value;
    _value = 
 
;
    return _value;
  }
  private boolean _pedGoToExit1_walkInReverseDirection_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
false 
;
    return _value;
  }
  private void _pedGoToExit1_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
//if(exits.get(1).getColor()==red)
//pedGoToExit.cancel(ped);
//ped.setSpeed(2.0); 
;
  }
  private void _pedGoToExit1_onExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToExit1_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToExit1_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private TargetLine _pedGoToExit_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
exits.get(0) 
;
    return _value;
  }
  private double _pedGoToExit_locationX_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private double _pedGoToExit_locationY_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private AreaNode _pedGoToExit_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private Pathway _pedGoToExit_route_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    Pathway _value;
    _value = 
 
;
    return _value;
  }
  private boolean _pedGoToExit_walkInReverseDirection_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
false 
;
    return _value;
  }
  private void _pedGoToExit_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
//if(exits.get(0).getColor()==red)
//pedGoToExit.cancel(ped);
//ped.setSpeed(2.0); 
;
  }
  private void _pedGoToExit_onExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToExit_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToExit_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSink_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedSink<Visitor> self, Visitor ped ) {
    
/*if(peddead.countPeds()==peopleinside-1)
{main.finish=true;

}*/

double s=main.getsuccess_rate();
long dead=peddead.in.count();
if(main.dead==peopleinside-1|| main.dead==peopleinside)
{main.finish=true;
}
int i=indexOf(helpee, ped);
if(i!=-1){
people_helped++;

}

int j=helper.indexOf(ped);
if(j!=-1){
helper_wait[j]=Double.POSITIVE_INFINITY;
people_helper++;
	}
	
int k=indexOf(injured_helpee, ped);
if(k!=-1){
injured_people_helped++;
}

 
;
  }
  private boolean _selectOutput_condition_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    boolean _value;
    _value = 
//location_x[ind].
agent.getGround().equals(main.secondGround) 
;
    return _value;
  }
  private double _selectOutput_probability_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    double _value;
    _value = 
0.5 
;
    return _value;
  }
  private void _selectOutput_onEnter_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private void _selectOutput_onExitTrue_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private void _selectOutput_onExitFalse_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
/*for(int i=0;main.connectedag2[i]!=null;i++)//connecage2=== red sensors
	if(   ( main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) )|| ( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && !(main.workArea.contains(agent.getX(), agent.getY())) )   )
	{condition=1;
	break;}

for(int i=0;main.connectedag2[i]!=null;i++)//connecage2=== red sensors
{

if(  main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)&& !(main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) )
{//=> 2= goto ex2 => line30
 predicted_target=main.line30;
 condition=2;
 break;
 //true
}

else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.workArea.contains(agent.getX(), agent.getY()) )//if
{//=> 2= goto ex2 => line30
 predicted_target=main.enter;
  condition=2;
  break;
 //true
}
else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& (main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && !(main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)))
{//5= main.enter;
predicted_target=main.enter;
 condition=2;
 break;
//true
}

else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& !(main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) &&  !(main.workArea.contains(agent.getX(), agent.getY()))    )
{//7 main.line30
predicted_target=main.line30;
 condition=2;
 break;
//true
}


}


for(int i=0;main.connectedag2[i]!=null;i++)//connecage2=== red sensors
 if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& !(main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) &&  main.workArea.contains(agent.getX(), agent.getY())    )
{condition=3;
break;}*/ 
;
  }
  private void _timeMeasureEnd_onEnter_xjal( final com.anylogic.libraries.processmodeling.TimeMeasureEnd<Visitor> self, Visitor agent ) {
    


//timeMeasureEnd.dataset.add((double)agent.getId()); 
;
  }
  private boolean _pedSelectOutput1_condition1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 


//s3//(main.area3_5.contains(ped.getX(), ped.getY()) || main.s4.contains(ped.getX(), ped.getY()) )&& main.ten_percent>=1 
 //s4(main.coffee.contains(ped.getX(), ped.getY()) )
//s2
( main.s1.contains(ped.getX(), ped.getY()) )&& main.ten_percent>=1  
;
    return _value;
  }
  private boolean _pedSelectOutput1_condition2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
//s6//main.area3_5.contains(ped.getX(), ped.getY())||main.area3.contains(ped.getX(), ped.getY())||main.area3_2.contains(ped.getX(), ped.getY())
//s3main.s4.contains(ped.getX(), ped.getY())||main.s3_3.contains(ped.getX(), ped.getY())||main.s3_2.contains(ped.getX(), ped.getY())||main.s3_5.contains(ped.getX(), ped.getY())
//s4main.area4.contains(ped.getX(), ped.getY())
//s2
main.s1.contains(ped.getX(), ped.getY())||main.area4_1.contains(ped.getX(), ped.getY())||main.s3_2.contains(ped.getX(), ped.getY()) 
;
    return _value;
  }
  private boolean _pedSelectOutput1_condition3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
//(getDistance(ped.getX(), ped.getY(), main.fire_center.getX(), main.fire_center.getY())<150 && ped.getGround()== get_agent_Grnd(main.fire_center))
randomTrue(0.5)

//ped.getGround().equals(main.secondGround)&& main.line20.getColor()!=red && main.line21.getColor()!=red 
;
    return _value;
  }
  private boolean _pedSelectOutput1_condition4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
false 
;
    return _value;
  }
  private double _pedSelectOutput1_probability1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput1_probability2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput1_probability3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput1_probability4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput1_probability5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private int _pedSelectOutput1_exitNumber_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    int _value;
    _value = 
uniform_discr( 1, 5 ) 
;
    return _value;
  }
  private void _pedSelectOutput1_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
ped.setComfortableSpeed(1.5*ped.getComfortableSpeed(), MPS);



//ped.setDesiredSpeed(2*ped.getDesiredSpeed());
//ped.setSpeed(2*ped.getSpeed()); 
;
  }
  private void _pedSelectOutput1_onExit1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
//if(get_area_visitor(ped)==get_area_sensor(main.fire_center))
//if(ped.getGround()== get_agent_Grnd(main.fire_center))
if(ped.getGround()== main.firstGround)
	{ped.dead_time= (double)toLengthUnits(getDistance(ped.getX(), ped.getY(), main.fire_center.getX(), main.fire_center.getY()), METER) / (double)main.fire_speed;
	ped.dead_time=(double)ped.dead_time/(double)60;
	//if(get_area_visitor(ped)!=get_area_sensor(main.fire_center))
	ped.dead_time+=1.3;
	//helpee_predictdead[indexOf(helpee, ped)]= (ped.dead_time*60);
	}
	
	ped.notinjured=true;
	inject_helper2(ped);
	main.ten_percent--;
	
	
 
;
  }
  private void _pedSelectOutput1_onExit2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
//if(ped.getGround()== get_agent_Grnd(main.fire_center))
if(ped.getGround()== main.firstGround)
{ped.dead_time= (double)toLengthUnits(getDistance(ped.getX(), ped.getY(), main.fire_center.getX(), main.fire_center.getY()), METER) / (double)main.fire_speed;
ped.dead_time=(double)ped.dead_time/(double)60;
	ped.dead_time+=1.3;
	}
ped.notinjured=true;
inject_helper2(ped);

 
;
  }
  private void _pedSelectOutput1_onExit3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput1_onExit4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput1_onExit5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private AreaNode _pedLongWait_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private Attractor _pedLongWait_attractor_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, AreaNode areaNode, Visitor ped ) {
    Attractor _value;
    _value = 
self.getRandomAttractor(areaNode) 
;
    return _value;
  }
  private TargetLine _pedLongWait_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
 
;
    return _value;
  }
  private double _pedLongWait_locationX_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.getX() 
;
    return _value;
  }
  private double _pedLongWait_locationY_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.getY() 
;
    return _value;
  }
  private double _pedLongWait_delayTimeout_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
triangular(1,2,5) 
;
    _value = MINUTE.convertTo( _value, SECOND );
    return _value;
  }
  private void _pedLongWait_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    

//priorities
double t=time(SECOND);//now time
if(helpee_predictdead[indexOf(helpee,ped)]==0)
helpee_predictdead[indexOf(helpee,ped)]= t;

 
;
  }
  private void _pedLongWait_onBeginWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
ped.statechart.receiveMessage("wait");

allocate_helper(ped);

/*
if(main.active_predict_help){//for dynamic help+ priorities

///for more heurisitic dynamic help

	if( helper.get(indexOf(helpee, ped)).helpis_inside==false && ped.dead_time!=infinity && ped.notinjured==true)
	{
	for(int j=0;j<100;j++)
	temp[j]=helper_wait[j];
	
	int x=indexOfMin(temp);//data first is 0
	while(temp[x]==0 && x<99)
	{temp[x]=Double.POSITIVE_INFINITY;
	x++;
	}
	temp[99]=Double.POSITIVE_INFINITY;
	
	int i=indexOfMin(temp);
	
	//the condition to switch helper is that helpee doesnt die according to new helper
	if(temp[i]!=infinity)
	while( ( helpee[i].notinjured==false || helper.get(i).priority_accept==true|| helpee[i].dead_time<helpee[indexOf(helpee, ped)].dead_time || temp[i]>helper_wait[indexOf(helpee, ped)] || helper.get(i).helpis_inside==true || helper_targetline[i]!= helper_targetline[indexOf(helpee, ped)]) )
	{
	temp[i]=Double.POSITIVE_INFINITY;//next min
	 i=indexOfMin(temp);
	}
	
	//this ped should be helpee of i helper and helpee[i] should be helpee of helper[ped]
	Visitor helpeee= ped;
		//the condition to switch helper is that helpee doesnt die according to new helper
	if(ped!=helpee[i])
	{
	    if(helper.get(i).priority_accept==false ){
		helpee[indexOf(helpee, ped)]=helpee[i];
		helpee[i]=helpeee;
		helper.get(i).priority_accept=true;
		}
	}//	//in may be itself!!! time1==time2
	
	
	
	}//main condition if=> helper inside!=true


}//dynamic help


//for set priorities
*/
 
;
  }
  private void _pedLongWait_onExit_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedLongWait_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedLongWait_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private TargetLine _pedChangeGround_exitLine_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
main.line21 
;
    return _value;
  }
  private TargetLine _pedChangeGround_entryLine_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
main.line20 
;
    return _value;
  }
  private void _pedChangeGround_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedChangeGround_onExitGround_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped, Ground ground ) {
    
 
;
  }
  private void _pedChangeGround_onEnterGround_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped, Ground ground ) {
    
 
;
  }
  private void _pedChangeGround_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedChangeGround_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private boolean _selectOutput3_condition_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    boolean _value;
    _value = 

getClosestExit(agent).equals(exits.get(0)) 
;
    return _value;
  }
  private double _selectOutput3_probability_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    double _value;
    _value = 
0.5 
;
    return _value;
  }
  private void _selectOutput3_onEnter_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
/*if(main.enter.getColor()==red)
exits.remove(main.enter);
if(main.line30.getColor()==red)
exits.remove(main.line30)*/ 
;
  }
  private void _selectOutput3_onExitTrue_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private void _selectOutput3_onExitFalse_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private AreaNode _peddead_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
findArea(ped) 
;
    return _value;
  }
  private Attractor _peddead_attractor_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, AreaNode areaNode, Visitor ped ) {
    Attractor _value;
    _value = 
self.getRandomAttractor(areaNode) 
;
    return _value;
  }
  private TargetLine _peddead_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
 
;
    return _value;
  }
  private double _peddead_locationX_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.getX() 
;
    return _value;
  }
  private double _peddead_locationY_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.getY() 
;
    return _value;
  }
  private double _peddead_delayTimeout_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.dead_time 
;
    _value = MINUTE.convertTo( _value, SECOND );
    return _value;
  }
  private void _peddead_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
ped.statechart.receiveMessage("Crashed");

double t=time(SECOND);
helpee_predictdead[indexOf(helpee,ped)]= t;


main.injured++;
injured_helpee[injured_ind]=ped;
injured_ind++;

 
;
  }
  private void _peddead_onBeginWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
allocate_helper1(ped); 
;
  }
  private void _peddead_onExit_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
//@dynamic help

int i=indexOf(helpee, ped);
/*
if(main.dynamic_help==true){
	if(i!=-1){
	helper.get(i).changed_Route1=true;

//pedGoToStairs.cancel(helper.get(i));
	helpgotoped.cancel(helper.get(i));
	helpgotoped1.cancel(helper.get(i));
	pedChangeGround1.cancel(helper.get(i));
	pedShortWait.cancel(helper.get(i));
	}
	}

*/
double t=time(SECOND);
helpee_realdead[i]=t;


 
;
  }
  private void _peddead_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _peddead_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private boolean _pedSelectOutput2_condition1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
//@predicted part + dynamic
!(isHelper(ped)) &&!(ped.getColor()==green) && main.active_dynamic==true &&( (main.as3_2 && (main.s4.contains(ped.getX(), ped.getY())||main.s3_3.contains(ped.getX(), ped.getY())|| main.s5.contains(ped.getX(), ped.getY())))|| (main.a4 && main.a1 && (main.s6.contains(ped.getX(), ped.getY()) )  ) ||(main.a4 && main.s2.contains(ped.getX(), ped.getY())) ||(main.a1_1 && main.a1 && main.s8.contains(ped.getX(), ped.getY()))  )
//exits.get(0).getColor()!=red &&exits.get(1).getColor()!=red && 
;
    return _value;
  }
  private boolean _pedSelectOutput2_condition2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
main.active_dynamic==true
//exits.get(0).getColor()!=red &&exits.get(1).getColor()!=red && main.active_predict!=true 
;
    return _value;
  }
  private boolean _pedSelectOutput2_condition3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
//static : safest
main.static_withdoor_sensor==true || static_route_forhelperhelpee1(ped)==true
//exits.get(0).getColor()!=red &&exits.get(1).getColor()==red 
;
    return _value;
  }
  private boolean _pedSelectOutput2_condition4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
//static : closest
main.active_safest==true && select_area_safest(ped)==true
//exits.get(0).getColor()==red &&exits.get(1).getColor()!=red 
;
    return _value;
  }
  private double _pedSelectOutput2_probability1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput2_probability2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput2_probability3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput2_probability4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput2_probability5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private int _pedSelectOutput2_exitNumber_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    int _value;
    _value = 
uniform_discr( 1, 5 ) 
;
    return _value;
  }
  private void _pedSelectOutput2_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
/*for(int i=0;main.connectedag2[i]!=null;i++)//connecage2=== red sensors
	if(   ( main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) )|| ( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && !(main.workArea.contains(ped.getX(), ped.getY())) )   )
	{condition=1;
	break;}

for(int i=0;main.connectedag2[i]!=null;i++)//connecage2=== red sensors
{

if(  main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)&& !(main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) )
{//=> 2= goto ex2 => line30
 predicted_target=main.line30;
 condition=2;
 break;
 //true
}

else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.workArea.contains(ped.getX(), ped.getY()) )//if
{//=> 2= goto ex2 => line30
 predicted_target=main.enter;
  condition=2;
  break;
 //true
}
else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& (main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && !(main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)))
{//5= main.enter;
predicted_target=main.enter;
 condition=2;
 break;
//true
}

else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& !(main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) &&  !(main.workArea.contains(ped.getX(), ped.getY()))    )
{//7 main.line30
predicted_target=main.line30;
 condition=2;
 break;
//true
}


}


for(int i=0;main.connectedag2[i]!=null;i++)//connecage2=== red sensors
 if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& !(main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) &&  main.workArea.contains(ped.getX(), ped.getY())    )
{condition=3;
break;}*/ 
;
  }
  private void _pedSelectOutput2_onExit1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
if(get_area_visitor(ped)==get_area_sensor(main.fire_center))
{ped.dead_time= (double)toLengthUnits(getDistance(ped.getX(), ped.getY(), main.fire_center.getX(), main.fire_center.getY()), METER) / (double)main.fire_speed;
ped.dead_time=(double)ped.dead_time/(double)60;}
ped.notinjured=true;
inject_helper2(ped);
/*for(int i=0;main.connectedag2[i]!=null;i++)//connecage2=== red sensors
{

if(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)&&main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))
{//1= all routes in floor1 closed=> change ground

}
else if(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)&& !(main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)))
{//=> 2= goto ex2 => line30
 predicted_target=main.line30;
}

else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& (main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && (main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)))
{//=> 3= main.enter;
if(main.workArea.contains(ped.getX(), ped.getY()))
 predicted_target=main.enter;
else //4 = change ground 
///
}

else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& (main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && !(main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)))
{//5= main.enter;
predicted_target=main.enter;
 
}


else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& !(main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && (main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)))
{//=> 6= closest
if(main.workArea.contains(ped.getX(), ped.getY()))
 //closest
else //7= main.line30;
predicted_target=main.line30;
}

else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& !(main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && !(main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)))
{//=> 8= closest

 //

}
*/
/*double t_center_enter=toLengthUnits(getDistance(main.fire_center.getX(),main.fire_center.getY(),main.myAgent.get(188).getX(), main.myAgent.get(188).getY()),METER)/main.fire_speed;
t_center_enter+=main.alarmBegining;//real time of fire to exit
t_center_enter-=time(SECOND);//duration from now on

double t_center_line30=toLengthUnits(getDistance(main.fire_center.getX(),main.fire_center.getY(),main.myAgent.get(0).getX(), main.myAgent.get(0).getY()),METER)/main.fire_speed;
t_center_line30+=main.alarmBegining;//real time of fire to exit
t_center_line30-=time(SECOND);//duration from now on

double t_pedtoline30,t_pedtoenter;
if(ped.getGround()==main.firstGround)
{
t_pedtoline30=getDistance(ped.getX(),ped.getY(),main.line30.getX(), main.line30.getY())/ped.getComfortableSpeed(MPS);
t_pedtoenter=getDistance(ped.getX(),ped.getY(),main.enter.getX(), main.enter.getY())/ped.getComfortableSpeed(MPS);
}
else{
t_pedtoline30=getDistance(ped.getX(),ped.getY(),main.line21.getX(), main.line21.getY())/ped.getComfortableSpeed(MPS);
t_pedtoline30+=getDistance(main.line20.getX(),main.line20.getY(),main.line30.getX(), main.line30.getY())/ped.getComfortableSpeed(MPS);

t_pedtoenter=getDistance(ped.getX(),ped.getY(),main.line21.getX(), main.line21.getY())/ped.getComfortableSpeed(MPS);
t_pedtoenter+=getDistance(main.line20.getX(),main.line20.getY(),main.enter.getX(), main.enter.getY())/ped.getComfortableSpeed(MPS);
}
//4cases: 

if(t_pedtoline30<t_center_line30 && t_pedtoenter<t_center_enter)//choose nearest
{
 if(t_pedtoenter<t_pedtoline30)
  predicted_target=main.enter;
 else
  predicted_target=main.line30;
}

else if(t_pedtoline30<t_center_line30 && t_pedtoenter>t_center_enter)
 predicted_target=main.line30;
else
 predicted_target=main.enter;*/
//main.area1.
//if(main.oval12.)
 
;
  }
  private void _pedSelectOutput2_onExit2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput2_onExit3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput2_onExit4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput2_onExit5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private boolean _changeroute_condition_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    boolean _value;
    _value = 
//false
//agent.changed_Route1 &&
 !(agent.ped_infire) 
;
    return _value;
  }
  private double _changeroute_probability_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    double _value;
    _value = 
0.5 
;
    return _value;
  }
  private void _changeroute_onEnter_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private void _changeroute_onExitTrue_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private void _changeroute_onExitFalse_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
inject_helper2(agent);
//helpee_predictdead[indexOf(helpee, ped)]= (ped.dead_time*60);
 
;
  }
  private TargetLine _pedGoToExit2_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
main.safe_exit 
;
    return _value;
  }
  private double _pedGoToExit2_locationX_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private double _pedGoToExit2_locationY_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private AreaNode _pedGoToExit2_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private Pathway _pedGoToExit2_route_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    Pathway _value;
    _value = 
ped.route 
;
    return _value;
  }
  private boolean _pedGoToExit2_walkInReverseDirection_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
false 
;
    return _value;
  }
  private void _pedGoToExit2_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
//if(exits.get(0).getColor()==red)
//pedGoToExit.cancel(ped);
//ped.spe
 
;
  }
  private void _pedGoToExit2_onExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToExit2_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToExit2_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private TargetLine _helpgotoped_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
line20 
;
    return _value;
  }
  private double _helpgotoped_locationX_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
//location_x[ind3];
helpee[helper.indexOf(ped)].getX() 
;
    return _value;
  }
  private double _helpgotoped_locationY_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
//location_y[ind3];
helpee[helper.indexOf(ped)].getY() 
;
    return _value;
  }
  private AreaNode _helpgotoped_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
main.cafeteria 
;
    return _value;
  }
  private Pathway _helpgotoped_route_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    Pathway _value;
    _value = 
 
;
    return _value;
  }
  private boolean _helpgotoped_walkInReverseDirection_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
false 
;
    return _value;
  }
  private void _helpgotoped_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _helpgotoped_onExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _helpgotoped_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _helpgotoped_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private TargetLine _helpsource_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, Help ped ) {
    TargetLine _value;
    _value = 
helper_targetline[ind3];
ind3++;
//enter 
;
    return _value;
  }
  private Ground _helpsource_ground_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, Help ped ) {
    Ground _value;
    _value = 
pedGroundFirst 
;
    return _value;
  }
  private double _helpsource_locationX_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, Help ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private double _helpsource_locationY_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, Help ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private AreaNode _helpsource_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, Help ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private double _helpsource_interarrivalTime_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self ) {
    double _value;
    _value = 
exponential(3.6) 
;
    return _value;
  }
  private double _helpsource_rateExpression_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, double baseRate ) {
    double _value;
    _value = 
baseRate * visitorArrivalMultiplier  
;
    return _value;
  }
  private Agent _helpsource_newPed_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self ) {
    Agent _value;
    _value = 
new evacuation.Help() 
;
    return _value;
  }
  private double _helpsource_comfortableSpeed_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, Help ped ) {
    double _value;
    _value = 
//uniform(0.85, 1.2)
1 
;
    return _value;
  }
  private double _helpsource_initialSpeed_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, Help ped ) {
    double _value;
    _value = 
ped.getComfortableSpeed() 
;
    return _value;
  }
  private double _helpsource_diameter_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, Help ped ) {
    double _value;
    _value = 
uniform(0.4, 0.5) 
;
    return _value;
  }
  private int _helpsource_groupSize_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, Help leader ) {
    int _value;
    _value = 
uniform_discr(2, 3) 
;
    return _value;
  }
  private double _helpsource_groupMemberInterarrivalTime_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self ) {
    double _value;
    _value = 
exponential(3) 
;
    return _value;
  }
  private AgentList _helpsource_population_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, Help ped ) {
    AgentList _value;
    _value = 
main.visitor 
;
    return _value;
  }
  private void _helpsource_onExit_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, Help ped ) {
    
helper.add(ind2, ped);
help_source++;
///for blind search to define areas
if(helper_targetline[helper.indexOf(ped)]==main.enter)
{
	if(randomTrue(0.35))
	ped.finalroute=route3;
	else if(randomTrue(0.35))
		ped.finalroute=route4;
	else
	ped.finalroute=route5;
	
}

else if(helper_targetline[helper.indexOf(ped)]==main.line30)
{
	if(randomTrue(0.35))
	ped.finalroute=route1;
	else if(randomTrue(0.35))
	ped.finalroute=route2;
	else
	ped.finalroute=route5;
	
}
////////for blind search

double t=time(SECOND);
helper_start_time[ind2]=t;
indexofhelper=helper.indexOf(ped);



double distance;
if(helpee[indexofhelper].getGround()==main.firstGround)//helpee&helper on first ground
	distance=getDistance(helper_targetline[indexofhelper].getX(),helper_targetline[indexofhelper].getY(),helpee[indexofhelper].getX(), helpee[indexofhelper].getY());
else//helpee in second ground but helper may be on first or second ground
	{
	if(helper_targetline[indexofhelper]==main.window)
	distance=getDistance(helper_targetline[indexofhelper].getX(),helper_targetline[indexofhelper].getY(),helpee[indexofhelper].getX(), helpee[indexofhelper].getY());
	else
	{distance=getDistance(helper_targetline[indexofhelper].getX(),helper_targetline[indexofhelper].getY(),main.line20.getX(), main.line20.getY());
	distance+=getDistance(main.line21.getX(),main.line21.getY(),helpee[indexofhelper].getX(),helpee[indexofhelper].getY());
	}}
double meter_helpee_helper=toLengthUnits(distance, METER);
time_to_rescue[indexofhelper] =  meter_helpee_helper/ped.getComfortableSpeed(MPS);	
//time_to_rescue[ind2]+=5.0;//for last shortwait
time_to_rescue[indexofhelper]+=helper_wait[indexofhelper]*60;//for first shortwait
time_to_rescue[indexofhelper]+=helper_start_time[indexofhelper];//time of start waiting
		
helper_to_rescue[indexofhelper]=time_to_rescue[indexofhelper];
		
		

/*
if(main.active_predict_help){
double distance;
if(helpee[indexofhelper].getGround()==main.firstGround)//helpee&helper on first ground
	distance=getDistance(helper_targetline[indexofhelper].getX(),helper_targetline[indexofhelper].getY(),helpee[indexofhelper].getX(), helpee[indexofhelper].getY());
else//helpee in second ground but helper may be on first or second ground
	{
	if(helper_targetline[indexofhelper]==main.window)
	distance=getDistance(helper_targetline[indexofhelper].getX(),helper_targetline[indexofhelper].getY(),main.line20.getX(), main.line20.getY());
	else
	{distance=getDistance(helper_targetline[indexofhelper].getX(),helper_targetline[indexofhelper].getY(),main.line20.getX(), main.line20.getY());
	distance+=getDistance(main.line21.getX(),main.line21.getY(),helpee[indexofhelper].getX(),helpee[indexofhelper].getY());
	}}
double meter_helpee_helper=toLengthUnits(distance, METER);
time_to_rescue[ind2] =  meter_helpee_helper/ped.getComfortableSpeed(MPS);	
time_to_rescue[ind2]+=5.0;//for last shortwait
time_to_rescue[ind2]+=helper_wait[indexofhelper];//for first shortwait
//time_to_rescue[ind2]+=600;//for first shortwait
if((helpee[indexofhelper].getGround()==main.firstGround && main.floor_num_main==1) ||(helpee[indexofhelper].getGround()==main.secondGround && main.floor_num_main==2) )
	{
	double dis_helpee_fire=getDistance(main.fire_center.getX(),main.fire_center.getY(),helpee[indexofhelper].getX(), helpee[indexofhelper].getY());
	time_to_death[ind2]=(toLengthUnits(dis_helpee_fire, METER))/main.fire_speed;
	}
	
else//means that center of fire and helpee ground differs
{	MyAgent mg;
	if(helpee[indexofhelper].getGround()==main.firstGround && main.floor_num_main==2)
	{mg=main.myAgent.get(8);
	double dis_helpee_fire=getDistance(mg.getX(),mg.getY(),helpee[indexofhelper].getX(), helpee[indexofhelper].getY());
	dis_helpee_fire=toLengthUnits(dis_helpee_fire, METER);
	dis_helpee_fire+=main.dis_from_fire[99];//99= index of first sensor in floor 1 that fires and that is s 8
	time_to_death[ind2]=dis_helpee_fire/main.fire_speed;
	}
	if(helpee[indexofhelper].getGround()==main.secondGround && main.floor_num_main==1) 
	{mg=main.myAgent.get(17);
	double dis_helpee_fire=getDistance(mg.getX(),mg.getY(),helpee[indexofhelper].getX(), helpee[indexofhelper].getY());
	dis_helpee_fire=toLengthUnits(dis_helpee_fire, METER);
	dis_helpee_fire+=main.dis_from_fire[119];
	time_to_death[ind2]=dis_helpee_fire/main.fire_speed;
	}
}//else

}
*/
ind2++;
 
///pedShortWait.free(ped);*/ 
;
  }
  private void _helpsource_onBeginGrouping_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, com.anylogic.libraries.pedestrian.PedGroup group, Help leader ) {
    
 
;
  }
  private void _helpsource_onEndGrouping_xjal( final com.anylogic.libraries.pedestrian.PedSource<Help> self, com.anylogic.libraries.pedestrian.PedGroup group, Help leader ) {
    
 
;
  }
  private AreaNode _pedShortWait1_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
findArea(ped) 
;
    return _value;
  }
  private Attractor _pedShortWait1_attractor_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, AreaNode areaNode, Visitor ped ) {
    Attractor _value;
    _value = 
self.getRandomAttractor(areaNode) 
;
    return _value;
  }
  private TargetLine _pedShortWait1_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
 
;
    return _value;
  }
  private double _pedShortWait1_locationX_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.getX() 
;
    return _value;
  }
  private double _pedShortWait1_locationY_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.getY() 
;
    return _value;
  }
  private double _pedShortWait1_delayTimeout_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0 
;
    return _value;
  }
  private void _pedShortWait1_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
double t=time(SECOND);
helper_recived[helper.indexOf(ped)]=t;
indexofhelper=helper.indexOf(ped);
helpee[indexofhelper].setColor(green);
helpee[indexofhelper].ped_infire=false;
//if(peddead.contains(helpee[indexofhelper]))
peddead.cancel(helpee[indexofhelper]);
pedLongWait.cancel(helpee[indexofhelper]);

//peddead.set_delayType(DelayType Delay_);
//peddead.create_DelayEvent(5,MINUTE , helpee[indexofhelper]) 
;
  }
  private void _pedShortWait1_onBeginWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    



/*indexofhelper=helper.indexOf(ped);
helpee[indexofhelper].setColor(green);
helpee[indexofhelper].ped_infire=false;
//if(peddead.contains(helpee[indexofhelper]))
peddead.cancel(helpee[indexofhelper]);

pedLongWait.cancel(helpee[indexofhelper]);*/ 
;
  }
  private void _pedShortWait1_onExit_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    

//helper_recieved_time[indexofhelper]=time(SECOND)-helper_start_time[indexofhelper];
//
 
;
  }
  private void _pedShortWait1_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedShortWait1_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private TargetLine _pedChangeGround1_exitLine_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
main.line20 
;
    return _value;
  }
  private TargetLine _pedChangeGround1_entryLine_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
main.line21
//line21 
;
    return _value;
  }
  private void _pedChangeGround1_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedChangeGround1_onExitGround_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped, Ground ground ) {
    
 
;
  }
  private void _pedChangeGround1_onEnterGround_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped, Ground ground ) {
    
 
;
  }
  private void _pedChangeGround1_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
/*for (Visitor e : main.visitor)
 	if(e!=null&& !isHelper(e) && !e.inState(Visitor.dead))
 	{//check for each helpee to have only one helper
	if(get_area_visitor1(ped).contains(e.getX(), e.getY()))
	helpee[helper.indexOf(ped)]=e;
	*/ 
;
  }
  private void _pedChangeGround1_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private TargetLine _helpgotoped1_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
line20 
;
    return _value;
  }
  private double _helpgotoped1_locationX_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
//location_x[ind2-1];
helpee[helper.indexOf(ped)].getX()
 
;
    return _value;
  }
  private double _helpgotoped1_locationY_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
//location_y[ind2-1];
helpee[helper.indexOf(ped)].getY() 
;
    return _value;
  }
  private AreaNode _helpgotoped1_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private Pathway _helpgotoped1_route_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    Pathway _value;
    _value = 
 
;
    return _value;
  }
  private boolean _helpgotoped1_walkInReverseDirection_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
false 
;
    return _value;
  }
  private void _helpgotoped1_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    

indexofhelper=helper.indexOf(ped);
 
;
  }
  private void _helpgotoped1_onExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _helpgotoped1_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _helpgotoped1_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private boolean _selectOutput5_condition_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    boolean _value;
    _value = 
!(agent.ped_infire)
//&& main.finish1==false 
;
    return _value;
  }
  private double _selectOutput5_probability_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    double _value;
    _value = 
0.5 
;
    return _value;
  }
  private void _selectOutput5_onEnter_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private void _selectOutput5_onExitTrue_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
int i=indexOf(helpee, agent);
if(i!=-1)
//{
//helper.get(i).setComfortableSpeed(helper.get(i).getComfortableSpeed()/2);
agent.setComfortableSpeed(helper.get(i).getComfortableSpeed());

//} 
;
  }
  private void _selectOutput5_onExitFalse_xjal( final com.anylogic.libraries.processmodeling.SelectOutput<Visitor> self, Visitor agent ) {
    
 
;
  }
  private AreaNode _pedShortWait_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
findArea(ped) 
;
    return _value;
  }
  private Attractor _pedShortWait_attractor_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, AreaNode areaNode, Visitor ped ) {
    Attractor _value;
    _value = 
self.getRandomAttractor(areaNode) 
;
    return _value;
  }
  private TargetLine _pedShortWait_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
helper_targetline[helper.indexOf(ped)] 
;
    return _value;
  }
  private double _pedShortWait_locationX_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.getX() 
;
    return _value;
  }
  private double _pedShortWait_locationY_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.getY() 
;
    return _value;
  }
  private double _pedShortWait_delayTimeout_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
helper_wait[helper.indexOf(ped)] 
;
    _value = MINUTE.convertTo( _value, SECOND );
    return _value;
  }
  private void _pedShortWait_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedShortWait_onBeginWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedShortWait_onExit_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
//ped.setComfortableSpeed(2*ped.getComfortableSpeed(), MPS);

/*
ped.helpis_inside=true;
///for more heurisitic dynamic help
for (Visitor v: main.visitor)
	if(v.inState(Visitor.injured) &&helper.get(indexOf(helpee, v)).helpis_inside==false)
	{
	Visitor helpeee= v;
	helpee[indexOf(helpee, v)]=helpee[helper.indexOf(ped)];
	helpee[helper.indexOf(ped)]=helpeee;
	//helper of injured man that not in
	
	break;
	}
*/

//for (Visitor v : main.visitor  ){
//if(helpee_predictdead[indexOf(helpee, ped)]==0)

helpee_predictdead[helper.indexOf(ped)]+= (helpee[helper.indexOf(ped)].dead_time*60);
// (ped.dead_time*60);

//} 
;
  }
  private void _pedShortWait_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
helpee_predictdead[helper.indexOf(ped)]+= (helpee[helper.indexOf(ped)].dead_time*60);

int i=helper.indexOf(ped);
Visitor v=helpee[i];
helpee[i]=null;
helper_wait[i]=Double.POSITIVE_INFINITY;

//inject_helper(v,helper_targetline[i]);
helper_canceled++;
//if(peddead.in.count()==peopleinside)
//main.finish=true; 
;
  }
  private void _pedShortWait_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _timeMeasureStart_onEnter_xjal( final com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor> self, Visitor agent ) {
    
 
;
  }
  private AreaNode _pedWindowWait_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private Attractor _pedWindowWait_attractor_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, AreaNode areaNode, Visitor ped ) {
    Attractor _value;
    _value = 
self.getRandomAttractor(areaNode) 
;
    return _value;
  }
  private TargetLine _pedWindowWait_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
main.window 
;
    return _value;
  }
  private double _pedWindowWait_locationX_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.getX() 
;
    return _value;
  }
  private double _pedWindowWait_locationY_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.getY() 
;
    return _value;
  }
  private double _pedWindowWait_delayTimeout_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
uniform(7, 12) 
;
    _value = MINUTE.convertTo( _value, SECOND );
    return _value;
  }
  private void _pedWindowWait_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    

//location_x[ind]=ped.getX();
//location_y[ind]=ped.getY();

//@ help source part
//if(help_source!=0){


//} 
;
  }
  private void _pedWindowWait_onBeginWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedWindowWait_onExit_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
//@dynamic help
 
;
  }
  private void _pedWindowWait_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedWindowWait_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private boolean _pedSelectOutput3_condition1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
//helpee[helper.indexOf(ped)].getGround()==main.secondGround && (main.line20.getColor()==red || main.line21.getColor()==red || main.myAgent.get(7).oval.getFillColor()==red || main.myAgent.get(6).oval.getFillColor()==red ||main.myAgent.get(5).oval.getFillColor()==red ||main.myAgent.get(4).oval.getFillColor()==red ||main.myAgent.get(3).oval.getFillColor()==red ||main.myAgent.get(2).oval.getFillColor()==red ||main.myAgent.get(1).oval.getFillColor()==red ||main.myAgent.get(0).oval.getFillColor()==red) && helper_targetline[helper.indexOf(ped)]!=main.window 
//helper first and helpee second but cant go
//helper && helpee on second ground
main.dynamic_help==true&& helper_targetline[helper.indexOf(ped)].getGround()==main.secondGround && helpee[helper.indexOf(ped)].getGround()==main.secondGround 
;
    return _value;
  }
  private boolean _pedSelectOutput3_condition2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
main.dynamic_help==true&&helper_targetline[helper.indexOf(ped)].getGround()==main.firstGround && helpee[helper.indexOf(ped)].getGround()==main.secondGround
//helpee[helper.indexOf(ped)].getGround()==main.secondGround && helper_targetline[helper.indexOf(ped)]!=main.window 
//helper in first && helpee in second  
;
    return _value;
  }
  private boolean _pedSelectOutput3_condition3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
//helpee && helper in first
main.dynamic_help==true&&helper_targetline[helper.indexOf(ped)].getGround()==main.firstGround && helpee[helper.indexOf(ped)].getGround()==main.firstGround
//
//helpee[helper.indexOf(ped)].getGround()==main.firstGround&& helper_targetline[helper.indexOf(ped)]!=main.window  
;
    return _value;
  }
  private boolean _pedSelectOutput3_condition4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 

main.dynamic_help==false
//helpee[helper.indexOf(ped)].getGround()==main.secondGround && helper_targetline[helper.indexOf(ped)]==main.window  
;
    return _value;
  }
  private double _pedSelectOutput3_probability1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput3_probability2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput3_probability3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput3_probability4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput3_probability5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private int _pedSelectOutput3_exitNumber_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    int _value;
    _value = 
uniform_discr( 1, 5 ) 
;
    return _value;
  }
  private void _pedSelectOutput3_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
ped.helpis_inside=true;
if(firsthelper==false)
{
inside_alive=pedLongWait.in.count()-main.dead;
firsthelper=true;
} 
;
  }
  private void _pedSelectOutput3_onExit1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
//int i=helper.indexOf(ped);
//Visitor v=helpee[i];
//helpee[i]=null;
//inject_helper(v,helper_targetline[i]);

 
;
  }
  private void _pedSelectOutput3_onExit2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput3_onExit3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput3_onExit4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput3_onExit5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
//means that ground is second and line20 or 21 is in fire 
;
  }
  private TargetLine _pedGoToExit4_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
predicted_target 
;
    return _value;
  }
  private double _pedGoToExit4_locationX_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private double _pedGoToExit4_locationY_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private AreaNode _pedGoToExit4_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private Pathway _pedGoToExit4_route_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    Pathway _value;
    _value = 
ped.route 
;
    return _value;
  }
  private boolean _pedGoToExit4_walkInReverseDirection_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
false 
;
    return _value;
  }
  private void _pedGoToExit4_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
//if(exits.get(0).getColor()==red)
//pedGoToExit.cancel(ped);
//ped.spe 
;
  }
  private void _pedGoToExit4_onExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToExit4_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToExit4_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private boolean _pedSelectOutput4_condition1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
static_route_forhelperhelpee1(ped)==true 
;
    return _value;
  }
  private boolean _pedSelectOutput4_condition2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
select_area_safest(ped)==true&&exits.get(0).getColor()!=red &&exits.get(1).getColor()!=red 
;
    return _value;
  }
  private boolean _pedSelectOutput4_condition3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
exits.get(0).getColor()!=red &&exits.get(1).getColor()==red 
;
    return _value;
  }
  private boolean _pedSelectOutput4_condition4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
exits.get(0).getColor()==red &&exits.get(1).getColor()!=red 
;
    return _value;
  }
  private double _pedSelectOutput4_probability1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput4_probability2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput4_probability3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput4_probability4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput4_probability5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private int _pedSelectOutput4_exitNumber_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    int _value;
    _value = 
uniform_discr( 1, 5 ) 
;
    return _value;
  }
  private void _pedSelectOutput4_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput4_onExit1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput4_onExit2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput4_onExit3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput4_onExit4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput4_onExit5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private boolean _pedSelectOutput5_condition1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 

route_forhelperhelpee(ped)
//for(int i=0;main.connectedag2[i]!=null;i++)//connecage2=== red sensors
	//if(   ( main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) )|| ( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && !(main.workArea.contains(ped.getX(), ped.getY())) )   )

//all routes in floor1 closed=> change ground


 
;
    return _value;
  }
  private boolean _pedSelectOutput5_condition2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
//=> 1&&4
 select_area(ped)==1
/*for(int i=0;main.connectedag2[i]!=null;i++)//connecage2=== red sensors
{

if(  main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)&& !(main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) )
{//=> 2= goto ex2 => line30
 predicted_target=main.line30;
 //true
}

else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.workArea.contains(ped.getX(), ped.getY()) )//if
{//=> 2= goto ex2 => line30
 predicted_target=main.enter;
 //true
}
else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& (main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && !(main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)))
{//5= main.enter;
predicted_target=main.enter;
//true
}

else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& !(main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) &&  !(main.workArea.contains(ped.getX(), ped.getY()))    )
{//7 main.line30
predicted_target=main.line30;
//true
}


}*/ 
;
    return _value;
  }
  private boolean _pedSelectOutput5_condition3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
//2&&3&&5&&7
  select_area(ped)==2
/*for(int i=0;main.connectedag2[i]!=null;i++)//connecage2=== red sensors
 if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& !(main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) &&  main.workArea.contains(ped.getX(), ped.getY())    )
*/
 
;
    return _value;
  }
  private boolean _pedSelectOutput5_condition4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
 //8
  select_area(ped)==3 
;
    return _value;
  }
  private double _pedSelectOutput5_probability1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput5_probability2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput5_probability3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput5_probability4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput5_probability5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private int _pedSelectOutput5_exitNumber_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    int _value;
    _value = 
uniform_discr( 1, 5 ) 
;
    return _value;
  }
  private void _pedSelectOutput5_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput5_onExit1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput5_onExit2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput5_onExit3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput5_onExit4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput5_onExit5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
//else means that area 1,2,4, is ok and area 3 is on fire 
;
  }
  private TargetLine _pedChangeGround2_exitLine_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
main.line20 
;
    return _value;
  }
  private TargetLine _pedChangeGround2_entryLine_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
main.line21 
;
    return _value;
  }
  private void _pedChangeGround2_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedChangeGround2_onExitGround_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped, Ground ground ) {
    
 
;
  }
  private void _pedChangeGround2_onEnterGround_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped, Ground ground ) {
    
 
;
  }
  private void _pedChangeGround2_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedChangeGround2_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private AreaNode _helpsearch_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
//route1[ped.ind4] 
;
    return _value;
  }
  private Attractor _helpsearch_attractor_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, AreaNode areaNode, Visitor ped ) {
    Attractor _value;
    _value = 
self.getRandomAttractor(areaNode) 
;
    return _value;
  }
  private TargetLine _helpsearch_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
 
;
    return _value;
  }
  private double _helpsearch_locationX_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.getX() 
;
    return _value;
  }
  private double _helpsearch_locationY_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.getY() 
;
    return _value;
  }
  private double _helpsearch_delayTimeout_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
60 
;
    return _value;
  }
  private void _helpsearch_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
for (Visitor e : main.visitor)
 if(e!=null&& !isHelper(e) && !e.inState(Visitor.dead))
 {//check for each helpee to have only one helper
	int i=indexOf(helpee, e);
	//check for helpee
 	if(i==-1 &&ped.finalroute[ped.ind4].contains(e.getX(), e.getY()))
 	{helpee[helper.indexOf(ped)]=e;
 	break;
 	} 
 }

 ped.ind4++;
  
;
  }
  private void _helpsearch_onBeginWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _helpsearch_onExit_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _helpsearch_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _helpsearch_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private boolean _pedSelectOutput6_condition1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
ped.ind4==13 || (ped.finalroute==route5 &&helpee[helper.indexOf(ped)]==null &&ped.ind4==3) 
;
    return _value;
  }
  private boolean _pedSelectOutput6_condition2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
helpee[helper.indexOf(ped)]!= null
 
;
    return _value;
  }
  private boolean _pedSelectOutput6_condition3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
ped.finalroute==route5 && ped.getGround()==main.firstGround 
;
    return _value;
  }
  private boolean _pedSelectOutput6_condition4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
helpee[helper.indexOf(ped)]==null 
;
    return _value;
  }
  private double _pedSelectOutput6_probability1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput6_probability2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput6_probability3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput6_probability4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput6_probability5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private int _pedSelectOutput6_exitNumber_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    int _value;
    _value = 
uniform_discr( 1, 5 ) 
;
    return _value;
  }
  private void _pedSelectOutput6_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput6_onExit1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
//int i=helper.indexOf(ped);
//Visitor v=helpee[i];
//helpee[i]=null;
//inject_helper(v,helper_targetline[i]);

 
;
  }
  private void _pedSelectOutput6_onExit2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput6_onExit3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput6_onExit4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
//ped.ind4++; 
;
  }
  private void _pedSelectOutput6_onExit5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
//means that ground is second and line20 or 21 is in fire 
;
  }
  private TargetLine _pedChangeGround3_exitLine_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
main.line20 
;
    return _value;
  }
  private TargetLine _pedChangeGround3_entryLine_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
main.line21
//line21 
;
    return _value;
  }
  private void _pedChangeGround3_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedChangeGround3_onExitGround_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped, Ground ground ) {
    
 
;
  }
  private void _pedChangeGround3_onEnterGround_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped, Ground ground ) {
    
 
;
  }
  private void _pedChangeGround3_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedChangeGround3_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedChangeGround<Visitor> self, Visitor ped ) {
    
 
;
  }
  private AreaNode _ped_realdead_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
findArea(ped) 
;
    return _value;
  }
  private Attractor _ped_realdead_attractor_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, AreaNode areaNode, Visitor ped ) {
    Attractor _value;
    _value = 
self.getRandomAttractor(areaNode) 
;
    return _value;
  }
  private TargetLine _ped_realdead_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
 
;
    return _value;
  }
  private double _ped_realdead_locationX_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.getX() 
;
    return _value;
  }
  private double _ped_realdead_locationY_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
ped.getY() 
;
    return _value;
  }
  private double _ped_realdead_delayTimeout_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
uniform(2,5) 
;
    _value = MINUTE.convertTo( _value, SECOND );
    return _value;
  }
  private void _ped_realdead_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
main.dead++;
ped.statechart.receiveMessage("dead");
if(main.dead==peopleinside)
main.finish=true;

//if(peddead.in.count()==peopleinside)
//main.finish=true; 
;
  }
  private void _ped_realdead_onBeginWait_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _ped_realdead_onExit_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _ped_realdead_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _ped_realdead_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedWait<Visitor> self, Visitor ped ) {
    
 
;
  }
  private TargetLine _gotoped_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
line20 
;
    return _value;
  }
  private double _gotoped_locationX_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
//location_x[ind2-1];
ped.finalroute[ped.ind4].getCenter().getX() 
;
    return _value;
  }
  private double _gotoped_locationY_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
//location_y[ind2-1];
ped.finalroute[ped.ind4].getCenter().getY() 
;
    return _value;
  }
  private AreaNode _gotoped_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private Pathway _gotoped_route_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    Pathway _value;
    _value = 
 
;
    return _value;
  }
  private boolean _gotoped_walkInReverseDirection_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
false 
;
    return _value;
  }
  private void _gotoped_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _gotoped_onExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _gotoped_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _gotoped_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _timeMeasureStart1_onEnter_xjal( final com.anylogic.libraries.processmodeling.TimeMeasureStart<Visitor> self, Visitor agent ) {
    
 
;
  }
  private boolean _pedSelectOutput7_condition1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
 (main.active_dynamic && main.coffee.contains(ped.getX(), ped.getY()) &&( main.a3_4==true|| main.a3_2==true) && !(isHelper(ped)) &&!(ped.getColor()==green))
  
;
    return _value;
  }
  private boolean _pedSelectOutput7_condition2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
 ( main.static_withdoor_sensor && (main.line20.getColor()==red || main.line21.getColor()==red) ) ||( main.active_dynamic && (( main.a1 && main.a2)||(!main.a1 && main.a2 && main.a4)) ) || (main.active_dynamic && main.a3) ||( isHelper(ped) && helper_targetline[helper.indexOf(ped)].getGround()==main.secondGround ) || ( ped.getColor()==green && helper_targetline[indexOf(helpee, ped)].getGround()==main.secondGround )  
//ped.getGround().equals(main.firstGround) 
;
    return _value;
  }
  private boolean _pedSelectOutput7_condition3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
true 
;
    return _value;
  }
  private boolean _pedSelectOutput7_condition4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
false 
;
    return _value;
  }
  private double _pedSelectOutput7_probability1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput7_probability2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput7_probability3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput7_probability4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private double _pedSelectOutput7_probability5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
0.2 
;
    return _value;
  }
  private int _pedSelectOutput7_exitNumber_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    int _value;
    _value = 
uniform_discr( 1, 5 ) 
;
    return _value;
  }
  private void _pedSelectOutput7_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput7_onExit1_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
if(ped.getGround()== get_agent_Grnd(main.fire_center))
{ped.dead_time= (double)toLengthUnits(getDistance(ped.getX(), ped.getY(), main.fire_center.getX(), main.fire_center.getY()), METER) / (double)main.fire_speed;
ped.dead_time=(double)ped.dead_time/(double)60;
	ped.dead_time+=1.3;}
ped.notinjured=true;
inject_helper2(ped); 
;
  }
  private void _pedSelectOutput7_onExit2_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput7_onExit3_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedSelectOutput7_onExit4_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
//ped.setSpeed(2*ped.getSpeed());
//ped.setSpeed(uniform(0.5, 1)); 
;
  }
  private void _pedSelectOutput7_onExit5_xjal( final com.anylogic.libraries.pedestrian.PedSelectOutput<Visitor> self, Visitor ped ) {
    
//ped.setComfortableSpeed(ped.getComfortableSpeed()*2);
 
;
  }
  private TargetLine _pedGoToExit3_locationLine_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    TargetLine _value;
    _value = 
ped.target 
;
    return _value;
  }
  private double _pedGoToExit3_locationX_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private double _pedGoToExit3_locationY_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    double _value;
    _value = 
 
;
    return _value;
  }
  private AreaNode _pedGoToExit3_locationArea_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    AreaNode _value;
    _value = 
 
;
    return _value;
  }
  private Pathway _pedGoToExit3_route_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    Pathway _value;
    _value = 
ped.route 
;
    return _value;
  }
  private boolean _pedGoToExit3_walkInReverseDirection_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    boolean _value;
    _value = 
false 
;
    return _value;
  }
  private void _pedGoToExit3_onEnter_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
//if(exits.get(0).getColor()==red)
//pedGoToExit.cancel(ped);
//ped.spe
 
;
  }
  private void _pedGoToExit3_onExit_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToExit3_onCancel_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  private void _pedGoToExit3_onRemove_xjal( final com.anylogic.libraries.pedestrian.PedGoTo<Visitor> self, Visitor ped ) {
    
 
;
  }
  // Functions

 
  
TargetLine 
 getClosestExit( Visitor ped ) { 

double dst = Double.POSITIVE_INFINITY;
TargetLine result = null;
for (TargetLine e : exits)
	{if(ped.getGround().equals(main.secondGround))
	{result=main.line30;}
	//return line30;
	else if (getDistance(ped.getX(),ped.getY(), e.getX(), e.getY())< dst){
	result = e;
	dst = getDistance(ped.getX(),ped.getY(), e.getX(), e.getY());
		}}
return result; 
  }

 
  
boolean 
 isWorker( Agent ped ) { 

return ped instanceof OfficeWorker; 
  }

 
  void cancelall(  ) { 

//for()
pedGoToExit.cancelAll();
pedGoToExit1.cancelAll();
pedGoToExit2.cancelAll();
main.evacuation.pedWindowWait.cancelAll();
pedGoToExit4.cancelAll();
pedChangeGround2.cancelAll();
pedChangeGround.cancelAll();
pedLongWait.cancelAll();

pedShortWait.cancelAll();
helpgotoped.cancelAll();
helpgotoped1.cancelAll();
//pedGoToStairs.cancelAll();
pedWindowWait.cancelAll();
pedChangeGround1.cancelAll(); 
  }

 
  
int 
 select_area( Visitor ped ) { 


if(   ( main.a1 && main.area2.contains(ped.getX(), ped.getY()) ) ||( main.a1 && main.a2)|| ( !main.a1 && main.a2 && main.a4 && (main.area2.contains(ped.getX(), ped.getY()) ) )   )
	{condition=1;
	}


else if(  main.a1 && !main.a2 && !main.a4)

{///=> 2= goto ex2 => line30
 predicted_target=main.line30;
 condition=2;
 if(main.workArea.contains(ped.getX(), ped.getY()))
 ped.route=main.office1;
 else if(main.area1_2.contains(ped.getX(), ped.getY())||main.s8.contains(ped.getX(), ped.getY())||main.area1_1.contains(ped.getX(), ped.getY()) )
 {
 condition=4;
 }
 else
 ped.route=main.ex2;
 //break;
 //true
}

else if(  main.a1 && !main.a2 &&  main.a4)

{///=> 2= goto ex2 => line30
 predicted_target=main.line30;
 condition=2;
 if(main.workArea.contains(ped.getX(), ped.getY()))
 ped.route=main.office1;
 else if(main.area1_2.contains(ped.getX(), ped.getY())||main.s6.contains(ped.getX(), ped.getY())||main.s8.contains(ped.getX(), ped.getY())||main.area1_1.contains(ped.getX(), ped.getY()) )
 {
 condition=4;
 }
 else
 ped.route=main.ex2;
 //break;
 //true
}

else if( !main.a1 && main.a2 && main.a4 )//if
{//=> 2= goto ex2 => line30
 predicted_target=main.enter;
  condition=2;
  ped.route=main.office;
  //break;
 //true
}
//else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& (main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && !(main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)))
else if( !main.a1 && main.a2 && !main.a4)
{//5= main.enter;
predicted_target=main.enter;
 condition=2;
ped.route=main.office;

 //break;
//true
}

//else if( !(main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150))&& !(main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)) && main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) &&  !(main.workArea.contains(ped.getX(), ped.getY()))    )
else if( !main.a1 && !main.a2 && main.a4 &&  (main.area2.contains(ped.getX(), ped.getY()))    )

{//7 main.line30
predicted_target=main.line30;
 condition=2;
 ped.route=main.ex2;
 //break;
//true
}

else if(!main.a1 && !main.a2 && !main.a4 && main.as1 &&  main.workArea.contains(ped.getX(), ped.getY())    )

{	if (main.s1.contains(ped.getX(), ped.getY()))
	{predicted_target=main.enter;
 	condition=2;
 	ped.route=main.ex1;}
 	else{
predicted_target=main.enter;
 condition=2;
ped.route=main.office;}
 
}

else if( !main.a1 && !main.a2 && !main.a4 && main.as3_2 &&  main.workArea.contains(ped.getX(), ped.getY())    )

{
predicted_target=main.line30;
 condition=2;
 if(main.s4.contains(ped.getX(), ped.getY()))
 ped.route=main.office;
 else
 ped.route=main.office1;
}


//for(int i=0;main.connectedag2[i]!=null;i++)//connecage2=== red sensors
else if( !main.a1 && !main.a2 && main.a4     )
{condition=3;
//break;
}

//compute which route is expected to burn first
/*
else if(!main.a1 && !main.a2 && !main.a4 && !main.as3_2 && !main.as1)
{
	double dst = Double.POSITIVE_INFINITY;
	Pathway result = null;
	if(main.floor_num_main==1)
	{
	for (Pathway e : pathways)
	{
	
		if(getDistanceFromPointToSegment(e.getSegment(1).getStartX(), e.getSegment(1).getStartY(), e.getSegment(3).getEndX(), e.getSegment(3).getEndY(),main.fire_center.getX(),main.fire_center.getY())< dst)
		{result = e;
		dst = getDistanceFromPointToSegment(e.getSegment(1).getStartX(), e.getSegment(1).getStartY(), e.getSegment(3).getEndX(), e.getSegment(3).getEndY(),main.fire_center.getX(),main.fire_center.getY());
			}
		}//for the result is ready
		condition=2;
		if(result==main.ex1||result==main.office)//ex1 is closet to fire
	 		if(main.workArea.contains(ped.getX(), ped.getY()) )
			ped.route=main.office1;
			else
			ped.route=main.ex2;
			
		else 	
			if(main.workArea.contains(ped.getX(), ped.getY()) )
			ped.route=main.office;
			else
			ped.route=main.ex1;
			
		}
		
		
		
		//if
	else
	condition=4;
	


}
*/

else 
condition=4;

return condition;
 
  }

 
  
boolean 
 isHelper( Agent ped ) { 

return ped instanceof Help; 
  }

 
  
boolean 
 route_forhelperhelpee( Visitor ped ) { 

//if(main.dynamic_help){

	if(isHelper(ped) || ped.getColor()==green )
	{
		if(isHelper(ped))
		{
		
		if(select_area(ped)==2)
		return true;
		else
		{
			predicted_target=helper_targetline[helper.indexOf(ped)];
			if(predicted_target==main.line30 )
			ped.route=main.ex2;
			else if(main.workArea.contains(ped.getX(), ped.getY()))
			ped.route=main.office;
			else
			ped.route=main.ex1;
			return true;
			}//condition=!2
		}///helper
		
		else //its helpee
		{
		
		if(select_area(ped)==2)
		return true;
		else
		{
		predicted_target=helper_targetline[indexOf(helpee, ped)];
		if(predicted_target==main.line30 )
			ped.route=main.ex2;
			else if(main.workArea.contains(ped.getX(), ped.getY()))
			ped.route=main.office;
			else
			ped.route=main.ex1;
			return true;
			
		
		}//condition !=2
		}//is helpee
		
		
		
		
	}//is helper or helpee
	
	
	
	
	else 
	return false;
	//}//dynamic help
/*
else{
	if(isHelper(ped) || ped.getColor()==green ){
		if(main.safe_exit==main.line30)
		route=main.ex2;
		else if(main.workArea.contains(ped.getX(), ped.getY()))
		route=main.office;
		else
		route=main.ex1;
	return true;
		}//is helper
	else
	return false;
	
}//not dynamic help*/ 
  }

 
  
Ground 
 get_agent_Grnd( MyAgent ag ) { 

Ground g=null;
if(main.rectangle1.contains(ag.getX(), ag.getY()))
g=main.firstGround;
else if(main.rectangle3.contains(ag.getX(), ag.getY()))
g=main.secondGround;


return g;
	
 
  }

 
  
int 
 get_area_sensor( MyAgent ag ) { 

int g=0;
if(main.area1_1.contains(ag.getX()+40, ag.getY()+150))
g=11;
else if(main.area1_2.contains(ag.getX()+40, ag.getY()+150))
g=12;
else if(main.area2.contains(ag.getX()+40, ag.getY()+150))
g=2;
else if(main.area3.contains(ag.getX()+40, ag.getY()+150))
g=3;
else if(main.area3_2.contains(ag.getX()+40, ag.getY()+150))
g=32;
else if(main.coffee.contains(ag.getX()+40, ag.getY()+150))
g=5;
else if(main.area3_3.contains(ag.getX()+40, ag.getY()+150))
g=33;
else if(main.area4.contains(ag.getX()+40, ag.getY()+150))
g=4;

else if(main.s1.contains(ag.getX()+40, ag.getY()+150))
g=111;
else if(main.s2.contains(ag.getX()+40, ag.getY()+150))
g=222;
else if(main.s3_1.contains(ag.getX()+40, ag.getY()+150))
g=331;
else if(main.s3_2.contains(ag.getX()+40, ag.getY()+150))
g=331;
else if(main.s3_3.contains(ag.getX()+40, ag.getY()+150))
g=333;
else if(main.s4.contains(ag.getX()+40, ag.getY()+150))
g=444;
else if(main.s5.contains(ag.getX()+40, ag.getY()+150))
g=555;
else if(main.s6.contains(ag.getX()+40, ag.getY()+150))
g=666;
else if(main.s7.contains(ag.getX()+40, ag.getY()+150))
g=777;//area4
else if(main.s8.contains(ag.getX()+40, ag.getY()+150))
g=888;//a1_2

return g;
	
 
  }

 
  
int 
 get_area_visitor( Visitor ag ) { 

int g=0;
if(main.area1_1.contains(ag.getX(), ag.getY()))
g=11;
else if(main.area1_2.contains(ag.getX(), ag.getY()))
g=12;
else if(main.area2.contains(ag.getX(), ag.getY()))
g=2;
else if(main.area3.contains(ag.getX(), ag.getY()))
g=3;
else if(main.area3_2.contains(ag.getX(), ag.getY()))
g=32;
else if(main.coffee.contains(ag.getX(), ag.getY()))
g=5;
else if(main.area3_3.contains(ag.getX(), ag.getY()))
g=33;
else if(main.area4.contains(ag.getX(), ag.getY()))
g=4;

else if(main.s1.contains(ag.getX(), ag.getY()))
g=111;
else if(main.s2.contains(ag.getX(), ag.getY()))
g=222;
else if(main.s3_1.contains(ag.getX(), ag.getY()))
g=331;
else if(main.s3_2.contains(ag.getX(), ag.getY()))
g=331;
else if(main.s3_3.contains(ag.getX(), ag.getY()))
g=333;
else if(main.s4.contains(ag.getX(), ag.getY()))
g=444;
else if(main.s5.contains(ag.getX(), ag.getY()))
g=555;
else if(main.s6.contains(ag.getX(), ag.getY()))
g=666;
else if(main.s7.contains(ag.getX(), ag.getY()))
g=777;//area4
else if(main.s8.contains(ag.getX(), ag.getY()))
g=888;//a1_2

return g; 
  }

 
  void inject_helper2( Visitor ped ) { 

if(main.dynamic_help){

if(ped.getGround().equals(main.secondGround)){


	if(main.static_withdoor_sensor){
		if(main.line20.getColor()==red || main.line21.getColor()==red  )
		helper_targetline[ind]=main.window;
		else
		helper_targetline[ind]=main.line30;
	}
	else if(main.active_dynamic)//closest & safest
	{
		if(main.a3 || (main.a4 && main.a2))
		helper_targetline[ind]=main.window;
		
		else if( (!main.a1 && !main.a2) || (main.a1 && !main.a2))
		helper_targetline[ind]=main.line30;
		
		else if( !main.a1 && main.a2 && !main.a4)
		helper_targetline[ind]=main.enter;
	
	}
	else//only closest
	helper_targetline[ind]=main.line30;
	
	
	
}
else{ // first ground 

	if(main.active_dynamic)//closest & safest
	 {
	 if( !main.a1 && !main.a2 )//closest
	 	if(getDistance(ped.getX(),ped.getY(), main.enter.getX(), main.enter.getY())>getDistance(ped.getX(),ped.getY(), main.line30.getX(), main.line30.getY()))
		helper_targetline[ind]=main.line30;
		else
		helper_targetline[ind]=main.enter;
	
	 else if(!main.a1 && main.a2)
		 helper_targetline[ind]=main.enter;
		 
	 else if(main.a1 && !main.a2)
	 	helper_targetline[ind]=main.line30;
	 else // all areas fire dont help
		helper_targetline[ind]=null;
		 
	 }
	 
	 
	else if(!main.a1 || !main.a2 || !main.a4 ){//only closest not active dynamic
	if(getDistance(ped.getX(),ped.getY(), main.enter.getX(), main.enter.getY())>getDistance(ped.getX(),ped.getY(), main.line30.getX(), main.line30.getY()))
	helper_targetline[ind]=main.line30;
	else
	helper_targetline[ind]=main.enter;
	}
}




//@ help source part
//if(help_source!=0){

if(!(ped.inState(ped.dead))|| helper_targetline[ind]!=null)
{
helpee[ind]=ped;
helpsource.inject(1);

//helper_wait[ind]=uniform(7, 10);
ind++;
//help_source--;
}
}
//for inject helper
 
  }

  /**
   * //for trapped
   */
 
  void allocate_helper( Visitor v ) { 


if(main.active_predict_help){//for dynamic help+ priorities

///for more heurisitic dynamic help
//from all that not injured

if( v.dead_time!=infinity ){//number of not injured that we change helper
	//double[] temp=new double[100];
	for(int j=0;j<100;j++) temp[j]=helper_wait[j]; int x=indexOfMin(temp);//data first is 0
	/*while(temp[x]==0 && x<99){temp[x]=Double.POSITIVE_INFINITY;x++;}temp[99]=Double.POSITIVE_INFINITY;*/
	//temp
	int u=help_source;
	while( u<99){temp[u]=Double.POSITIVE_INFINITY;u++;}temp[99]=Double.POSITIVE_INFINITY;
	//temp
	
	for(int j=0;helpee[j]!=null;j++)
	temp_dtime[j]=helpee[j].dead_time;
	int xx=indexOfMin(temp_dtime);//data first is 0
	while(temp_dtime[xx]==0 && xx<99){temp_dtime[xx]=Double.POSITIVE_INFINITY;xx++;}temp_dtime[99]=Double.POSITIVE_INFINITY;
	//temp_dtime
	
	int j=indexOfMin(temp_dtime);
	
	if(temp_dtime[j]!=infinity) //check priority_accept_injure because maybe we have cheked ped
	while(helper.get(j).helpis_inside==true||helpee[j].inState(Visitor.injured) || helpee[j].priority_accept_injure==true ||helpee[j].priority_accept==true  )
	{
	temp_dtime[j]=Double.POSITIVE_INFINITY;//next min
	 j=indexOfMin(temp_dtime);
	 if(temp_dtime[j]==infinity)
	 break;
	}
if(temp_dtime[j]!=infinity){	
	Visitor ped=helpee[j];
double t=time(SECOND);//now time
double timetodead= t+ (ped.dead_time*60);
	//[j] is the index of min helpee dead time
	
	int i=indexOfMin(temp);
	//the condition to switch helper is that helpee doesnt die according to new helper
	if(temp[i]!=infinity)
	while(( helper.get(i).priority_accept_injure==true|| helper.get(i).priority_accept==true|| helper.get(i).helpis_inside==true || helper_targetline[i].getGround()
	!= helper_targetline[indexOf(helpee, ped)].getGround()) )
	{
	temp[i]=Double.POSITIVE_INFINITY;//next min
	 i=indexOfMin(temp);
	  if(temp[i]==infinity)
	 break;
	}
	//[i] is the index of min helper
if(temp[i]!=infinity){
	//this ped should be helpee of i helper and helpee[i] should be helpee of helper[ped]
	Visitor helpeee= ped;
		//the condition to switch helper is that helpee doesnt die according to new helper
	


double distance;
		if(ped.getGround()==main.firstGround)//helpee&helper on first ground
		distance=getDistance(helper_targetline[i].getX(),helper_targetline[i].getY(),ped.getX(), ped.getY());
		else//helpee in second ground but helper may be on first or second ground
		{
		if(helper_targetline[i]==main.window)
		distance=getDistance(helper_targetline[i].getX(),helper_targetline[i].getY(),ped.getX(), ped.getY());
		else
		{distance=getDistance(helper_targetline[i].getX(),helper_targetline[i].getY(),main.line20.getX(), main.line20.getY());
		distance+=getDistance(main.line21.getX(),main.line21.getY(),ped.getX(),ped.getY());
		}}
	
		double meter_helpee_helper=toLengthUnits(distance, METER);
		time_to_rescue[i] =  meter_helpee_helper/(helper.get(i).getComfortableSpeed(MPS));	
	//	time_to_rescue[i]+=5.0;//for last shortwait
//helperwait is to minute

		time_to_rescue[i]+= helper_wait[i]*60;//for first shortwait
		time_to_rescue[i]+=helper_start_time[i];//time of start waiting
		//helper_to_rescue[i]=time_to_rescue[i];
		



	    if(time_to_rescue[i]<timetodead &&helper.get(i).priority_accept==false ){
	   		 if(ped!=helpee[i])
			{
			helpee[indexOf(helpee, ped)]=helpee[i];
			helpee[i]=helpeee;
			helper.get(i).priority_accept=true;
			ped.priority_accept=true;
			}
			else{
			helper.get(i).priority_accept=true;
			ped.priority_accept=true;
			}//else
		}//time ok
		
		else
		ped.priority_accept=true;
	

	//	//in may be itself!!! time1==time2
	
	
	
	}//temp_deadt!=infinity
	}//temp!=infinity

}//v.injure
}//dynamic 



/*if(main.active_predict_help){//for dynamic help+ priorities



	int u=help_source;
	while( u<99){temp[u]=Double.POSITIVE_INFINITY;u++;}temp[99]=Double.POSITIVE_INFINITY;
	//temp
	
	for(int j=0;helpee[j]!=null;j++)
	temp_dtime[j]=helpee[j].dead_time;
	int xx=indexOfMin(temp_dtime);//data first is 0
	while(temp_dtime[xx]==0 && xx<99){temp_dtime[xx]=Double.POSITIVE_INFINITY;xx++;}temp_dtime[99]=Double.POSITIVE_INFINITY;
	//temp_dtime
	
	int j=indexOfMin(temp_dtime);
	
	if(temp_dtime[j]!=infinity) 
	while(helper.get(j).helpis_inside==true || temp_dtime[j]==infinity || helpee[j].notinjured==false || helpee[j].priority_accept==true  )
	{
	temp_dtime[j]=Double.POSITIVE_INFINITY;//next min
	 j=indexOfMin(temp_dtime);
	}
if(temp_dtime[j]!=infinity){	
	Visitor ped=helpee[j];
	//[j] is the index of min helpee dead time
	
	int i=indexOfMin(temp);
	//the condition to switch helper is that helpee doesnt die according to new helper
	if(temp[i]!=infinity)
	while(( helpee[i].notinjured==false ||temp[i]==infinity|| helper.get(i).priority_accept==true|| helpee[i].dead_time<helpee[indexOf(helpee, ped)].dead_time || temp[i]>helper_wait[indexOf(helpee, ped)] || helper.get(i).helpis_inside==true || helper_targetline[i].getGround()
	!= helper_targetline[indexOf(helpee, ped)].getGround()) )
	{
	temp[i]=Double.POSITIVE_INFINITY;//next min
	 i=indexOfMin(temp);
	}
	//[i] is the index of min helper
if(temp[i]!=infinity){
	//this ped should be helpee of i helper and helpee[i] should be helpee of helper[ped]
	Visitor helpeee= ped;
		//the condition to switch helper is that helpee doesnt die according to new helper
	if(ped!=helpee[i])
	{
	    if(helper.get(i).priority_accept==false ){
		helpee[indexOf(helpee, ped)]=helpee[i];
		helpee[i]=helpeee;
		helper.get(i).priority_accept=true;
		ped.priority_accept=true;
	
	}
	}//	//in may be itself!!! time1==time2
	else{
	helper.get(i).priority_accept=true;
	ped.priority_accept=true;
	}//else
	
	
	}//temp_deadt!=infinity
	}//temp!=infinity

}//v.injure
}//dynamic help*/



 
  }

  /**
   * //for injured priorities
   */
 
  void allocate_helper1( Visitor v ) { 



if(main.active_predict_help){//for dynamic help+ priorities

///for more heurisitic dynamic help
//from all that not injured

if( v.dead_time!=infinity ){//number of not injured that we change helper
	//double[] temp=new double[100];
	for(int j=0;j<100;j++) temp[j]=helper_wait[j]; int x=indexOfMin(temp);//data first is 0
	/*while(temp[x]==0 && x<99){temp[x]=Double.POSITIVE_INFINITY;x++;}temp[99]=Double.POSITIVE_INFINITY;*/
	//temp
	int u=help_source;
	while( u<99){temp[u]=Double.POSITIVE_INFINITY;u++;}temp[99]=Double.POSITIVE_INFINITY;
	//temp
	
	for(int j=0;j<helper.size();j++)
		if(helpee[j]!=null)
		temp_dtime[j]=helpee[j].dead_time;
		else
		temp_dtime[j]=Double.POSITIVE_INFINITY;
	
	int xx=indexOfMin(temp_dtime);//data first is 0
	while(temp_dtime[xx]==0 && xx<99){temp_dtime[xx]=Double.POSITIVE_INFINITY;xx++;}temp_dtime[99]=Double.POSITIVE_INFINITY;
	//temp_dtime
	
	int j=indexOfMin(temp_dtime);
	
	if(temp_dtime[j]!=infinity) 
	while( helpee[j].priority_accept_injure==true  )
	{
	temp_dtime[j]=Double.POSITIVE_INFINITY;//next min
	 j=indexOfMin(temp_dtime);
	  if(temp_dtime[j]==infinity)
	 break;
	
	}
if(temp_dtime[j]!=infinity && helper.get(j).helpis_inside==false){	
	Visitor ped=helpee[j];
double t=time(SECOND);//now time
	double timetodead= t+ (ped.dead_time*60);
	//[j] is the index of min helpee dead time
	
	int i=indexOfMin(temp);
	//the condition to switch helper is that helpee doesnt die according to new helper
	if(temp[i]!=infinity)
	while((  helper.get(i).priority_accept_injure==true|| helper.get(i).helpis_inside==true || helper_targetline[i].getGround()
	!= helper_targetline[indexOf(helpee, ped)].getGround()) )
	{
	temp[i]=Double.POSITIVE_INFINITY;//next min
	 i=indexOfMin(temp);
	  if(temp[i]==infinity)
	 break;
	}
	//[i] is the index of min helper
if(temp[i]!=infinity){
	//this ped should be helpee of i helper and helpee[i] should be helpee of helper[ped]
	Visitor helpeee= ped;
		//the condition to switch helper is that helpee doesnt die according to new helper
	

double distance;
		if(ped.getGround()==main.firstGround)//helpee&helper on first ground
		distance=getDistance(helper_targetline[i].getX(),helper_targetline[i].getY(),ped.getX(), ped.getY());
		else//helpee in second ground but helper may be on first or second ground
		{
		if(helper_targetline[i]==main.window)
		distance=getDistance(helper_targetline[i].getX(),helper_targetline[i].getY(),ped.getX(), ped.getY());
		else
		{distance=getDistance(helper_targetline[i].getX(),helper_targetline[i].getY(),main.line20.getX(), main.line20.getY());
		distance+=getDistance(main.line21.getX(),main.line21.getY(),ped.getX(),ped.getY());
		}}
	
		double meter_helpee_helper=toLengthUnits(distance, METER);
		time_to_rescue[i] =  meter_helpee_helper/(helper.get(i).getComfortableSpeed(MPS));	
	//	time_to_rescue[i]+=5.0;//for last shortwait
//helperwait is to minute
		time_to_rescue[i]+= helper_wait[i]*60;//for first shortwait
		time_to_rescue[i]+=helper_start_time[i];//time of start waiting
		//helper_to_rescue[i]=time_to_rescue[i];
		



	    if(time_to_rescue[i]<timetodead &&helper.get(i).priority_accept_injure==false ){
	    	if(ped!=helpee[i])
			{
			helpee[indexOf(helpee, ped)]=helpee[i];
			helpee[i]=helpeee;
			helper.get(i).priority_accept_injure=true;
			ped.priority_accept_injure=true;
			}//itself
			else{
			helper.get(i).priority_accept_injure=true;
			ped.priority_accept_injure=true;
	}//else
		}
		
		else
		ped.priority_accept_injure=true;
	

	//	//in may be itself!!! time1==time2
	
	
	
	}//temp!=infinity
	
	}//tempdtime!=infinity
else//temp_deadt==infinity or helper is inside
	{helpee[j].priority_accept_injure=true;
	helper.get(j).priority_accept_injure=true;
	}
	
	
}//v.injure
}//dynamic 



/*if(main.active_predict_help){//for dynamic help+ priorities



	int u=help_source;
	while( u<99){temp[u]=Double.POSITIVE_INFINITY;u++;}temp[99]=Double.POSITIVE_INFINITY;
	//temp
	
	for(int j=0;helpee[j]!=null;j++)
	temp_dtime[j]=helpee[j].dead_time;
	int xx=indexOfMin(temp_dtime);//data first is 0
	while(temp_dtime[xx]==0 && xx<99){temp_dtime[xx]=Double.POSITIVE_INFINITY;xx++;}temp_dtime[99]=Double.POSITIVE_INFINITY;
	//temp_dtime
	
	int j=indexOfMin(temp_dtime);
	
	if(temp_dtime[j]!=infinity) 
	while(helper.get(j).helpis_inside==true || temp_dtime[j]==infinity || helpee[j].notinjured==false || helpee[j].priority_accept==true  )
	{
	temp_dtime[j]=Double.POSITIVE_INFINITY;//next min
	 j=indexOfMin(temp_dtime);
	}
if(temp_dtime[j]!=infinity){	
	Visitor ped=helpee[j];
	//[j] is the index of min helpee dead time
	
	int i=indexOfMin(temp);
	//the condition to switch helper is that helpee doesnt die according to new helper
	if(temp[i]!=infinity)
	while(( helpee[i].notinjured==false ||temp[i]==infinity|| helper.get(i).priority_accept==true|| helpee[i].dead_time<helpee[indexOf(helpee, ped)].dead_time || temp[i]>helper_wait[indexOf(helpee, ped)] || helper.get(i).helpis_inside==true || helper_targetline[i].getGround()
	!= helper_targetline[indexOf(helpee, ped)].getGround()) )
	{
	temp[i]=Double.POSITIVE_INFINITY;//next min
	 i=indexOfMin(temp);
	}
	//[i] is the index of min helper
if(temp[i]!=infinity){
	//this ped should be helpee of i helper and helpee[i] should be helpee of helper[ped]
	Visitor helpeee= ped;
		//the condition to switch helper is that helpee doesnt die according to new helper
	if(ped!=helpee[i])
	{
	    if(helper.get(i).priority_accept==false ){
		helpee[indexOf(helpee, ped)]=helpee[i];
		helpee[i]=helpeee;
		helper.get(i).priority_accept=true;
		ped.priority_accept=true;
	
	}
	}//	//in may be itself!!! time1==time2
	else{
	helper.get(i).priority_accept=true;
	ped.priority_accept=true;
	}//else
	
	
	}//temp_deadt!=infinity
	}//temp!=infinity

}//v.injure
}//dynamic help*/












/*
if(main.active_predict_help){//for dynamic help+ priorities

///for more heurisitic dynamic help
//from all that not injured

if(v.notinjured==false && v.dead_time!=infinity ){//number of not injured that we change helper
//double[] temp=new double[100];
	for(int j=0;j<100;j++) temp[j]=helper_wait_copy1[j]; int x=indexOfMin(temp);//data first is 0
	
	
	int u=help_source;
	while( u<99){temp[u]=Double.POSITIVE_INFINITY;u++;}temp[99]=Double.POSITIVE_INFINITY;
	
	for(int j=0;helpee[j]!=null;j++)
	temp_dtime[j]=helpee[j].dead_time;
	int xx=indexOfMin(temp_dtime);//data first is 0
	while(temp_dtime[xx]==0 && xx<99){temp_dtime[xx]=Double.POSITIVE_INFINITY;xx++;}temp_dtime[99]=Double.POSITIVE_INFINITY;
	//temp_dtime
	
	int j=indexOfMin(temp_dtime);
	
	if(temp_dtime[j]!=infinity) 
	while(helper.get(j).helpis_inside==true || temp_dtime[j]==infinity || helpee[j].notinjured==true || helpee[j].priority_accept_injure==true  )
	{
	temp_dtime[j]=Double.POSITIVE_INFINITY;//next min
	 j=indexOfMin(temp_dtime);
	}
if(temp_dtime[j]!=infinity){	
	Visitor ped=helpee[j];
	double t=time(SECOND);//now time
	double timetodead= t+ (ped.dead_time*60);
	
	//[j] is the index of min helpee dead time
	
	int i=indexOfMin(temp);
	//the condition to switch helper is that helpee doesnt die according to new helper
	if(temp[i]!=infinity)
	while( ( temp[i]==infinity|| helper.get(i).priority_accept_injure==true|| helpee[i].dead_time<helpee[indexOf(helpee, ped)].dead_time || temp[i]>helper_wait[indexOf(helpee, ped)] || helper.get(i).helpis_inside==true || helper_targetline[i].getGround()!= helper_targetline[indexOf(helpee, ped)].getGround()  ) )
	{
	temp[i]=Double.POSITIVE_INFINITY;//next min
	 i=indexOfMin(temp);
	}
	//[i] is the index of min helper
if(temp[i]!=infinity){
	//this ped should be helpee of i helper and helpee[i] should be helpee of helper[ped]
	Visitor helpeee= ped;
		//the condition to switch helper is that helpee doesnt die according to new helper
	if(ped!=helpee[i])
	{
	
	///check when new helper=>helper[i] arrives, helpee=> helpeee or ped is alive or not
		double distance;
		if(ped.getGround()==main.firstGround)//helpee&helper on first ground
		distance=getDistance(helper_targetline[i].getX(),helper_targetline[i].getY(),ped.getX(), ped.getY());
		else//helpee in second ground but helper may be on first or second ground
		{
		if(helper_targetline[i]==main.window)
		distance=getDistance(helper_targetline[i].getX(),helper_targetline[i].getY(),ped.getX(), ped.getY());
		else
		{distance=getDistance(helper_targetline[i].getX(),helper_targetline[i].getY(),main.line20.getX(), main.line20.getY());
		distance+=getDistance(main.line21.getX(),main.line21.getY(),ped.getX(),ped.getY());
		}}
	
		double meter_helpee_helper=toLengthUnits(distance, METER);
		time_to_rescue[i] =  meter_helpee_helper/(helper.get(i).getComfortableSpeed(MPS));	
	//	time_to_rescue[i]+=5.0;//for last shortwait
//helperwait is to minute
		time_to_rescue[i]+= helper_wait[i]*60;//for first shortwait
		time_to_rescue[i]+=helper_start_time[i];//time of start waiting
		
		
		
	    if(time_to_rescue[i]<timetodead &&helper.get(i).priority_accept_injure==false ){
		helpee[indexOf(helpee, ped)]=helpee[i];
		helpee[i]=helpeee;
		helper.get(i).priority_accept_injure=true;
		ped.priority_accept_injure=true;
				}//rescue<dead
		else
		ped.priority_accept_injure=true;
				
				
	}//	//in may be itself!!! time1==time2
	else{
	helper.get(i).priority_accept_injure=true;
	ped.priority_accept_injure=true;
	}//else
	
	
	}//temp_deadt!=infinity
	}//temp!=infinity

}//v.injure
}//dynamic help*/ 
  }

 
  
RectangularNode 
 get_area_visitor1( Visitor ag ) { 

RectangularNode g=null;
if(main.area1_1.contains(ag.getX(), ag.getY()))
g=main.area1_1;
else if(main.area1_2.contains(ag.getX(), ag.getY()))
g=main.area1_2;
else if(main.area2.contains(ag.getX(), ag.getY()))
g=main.area2;
else if(main.area3.contains(ag.getX(), ag.getY()))
g=main.area3;
else if(main.area3_2.contains(ag.getX(), ag.getY()))
g=main.area3_2;
else if(main.coffee.contains(ag.getX(), ag.getY()))
g=main.coffee;
else if(main.area3_3.contains(ag.getX(), ag.getY()))
g=main.area3_3;
else if(main.area4.contains(ag.getX(), ag.getY()))
g=main.area4;

else if(main.s1.contains(ag.getX(), ag.getY()))
g=main.s1;
else if(main.s2.contains(ag.getX(), ag.getY()))
g=main.s2;
else if(main.s3_1.contains(ag.getX(), ag.getY()))
g=main.s3_1;
else if(main.s3_2.contains(ag.getX(), ag.getY()))
g=main.s3_2;
else if(main.s3_3.contains(ag.getX(), ag.getY()))
g=main.s3_3;
else if(main.s4.contains(ag.getX(), ag.getY()))
g=main.s4;
else if(main.s5.contains(ag.getX(), ag.getY()))
g=main.s5;
else if(main.s6.contains(ag.getX(), ag.getY()))
g=main.s6;
else if(main.s7.contains(ag.getX(), ag.getY()))
g=main.s7;//area4
else if(main.s8.contains(ag.getX(), ag.getY()))
g=main.s8;//a1_2

return g; 
  }

 
  
boolean 
 select_area_safest( Visitor ped ) { 

if(main.area1_1.contains(ped.getX(),ped.getY()))
ped.route=main.out;
else{
if(main.safe_exit==main.enter){
if(main.workArea.contains(ped.getX(),ped.getY()))
ped.route=main.office;
else
ped.route=main.ex1;
}
else
{
if(main.workArea.contains(ped.getX(),ped.getY()))
ped.route=main.office1;
else
ped.route=main.ex2;
}

}

return true;
 
  }

 
  
boolean 
 static_route_forhelperhelpee1( Visitor ped ) { 

//if(main.dynamic_help){

	if(isHelper(ped) || ped.getColor()==green )
	{
		if(isHelper(ped))
		{
		
			predicted_target=helper_targetline[helper.indexOf(ped)];
			if(predicted_target==main.line30 )
			ped.target=main.line30;
			else
			ped.target=main.enter;
			return true;
			
		}///helper
		
		else //its helpee
		{
		
		predicted_target=helper_targetline[indexOf(helpee, ped)];
		if(predicted_target==main.line30 )
			ped.target=main.line30;
			else
			ped.target=main.enter;
			return true;
		}//is helpee
		
		
		
		
	}//is helper or helpee
	
	
	
	
	else 
	return false;
	//}//dynamic help
/*
else{
	if(isHelper(ped) || ped.getColor()==green ){
		if(main.safe_exit==main.line30)
		route=main.ex2;
		else if(main.workArea.contains(ped.getX(), ped.getY()))
		route=main.office;
		else
		route=main.ex1;
	return true;
		}//is helper
	else
	return false;
	
}//not dynamic help*/ 
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
  protected static final Font _text17_Font = new Font("SansSerif", 1, 12 );
  @AnyLogicInternalCodegenAPI
  protected static final int _rectangle = 1;
  @AnyLogicInternalCodegenAPI
  protected static final int _image = 2;
  @AnyLogicInternalCodegenAPI
  protected static final int _line87 = 3;
  @AnyLogicInternalCodegenAPI
  protected static final int _text17 = 4;
  @AnyLogicInternalCodegenAPI
  protected static final int _chart = 5;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 6;
 

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
  

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onShapeClick( int _shape, int index, double clickx, double clicky ){
    switch( _shape ){
      case _rectangle:
        if (true) {
          ShapeRectangle self = this.rectangle;
          
return true; 
        }
        break;
      case _image:
        if (true) {
          ShapeImage self = this.image;
          
 
        }
        break;
      case _line87:
        if (true) {
          ShapeLine self = this.line87;
          
 
        }
        break;
      case _text17:
        if (true) {
          ShapeText self = this.text17;
          
 
        }
        break;
      default: return super.onShapeClick( _shape, index, clickx, clicky );
 	}
 	return false;
  }
   
  @Override
  @AnyLogicInternalCodegenAPI
  public void onSelectionChanged_xjal( int _shape, int index, int[] selectedIndices, boolean programmatically ) {
    switch( _shape ) {
      case _chart: {
        Histogram self = this.chart;
        
 
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
      case _chart: {
        Histogram self = this.chart;
        
 
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
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
1 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
;
    }
    {
      int _result_xjal = 
100 
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
  private void _chart_SetDynamicParams_xjal( Histogram shape ) {
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
  
  protected Histogram chart;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _rectangle_SetDynamicParams_xjal( ShapeRectangle shape ) {
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
  
  protected ShapeRectangle rectangle;
  
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
  private void _line87_SetDynamicParams_xjal( ShapeLine shape ) {
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
  
  protected ShapeLine line87;
  
  /**
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  private void _text17_SetDynamicParams_xjal( ShapeText shape ) {
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
  
  protected ShapeText text17;
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    rectangle = new ShapeRectangle(
       SHAPE_DRAW_2D, true,40.0, 20.0, 0.0, 0.0, 
            black, white,
			40.0, 40.0, 10.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _rectangle_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _rectangle, 0, clickx, clicky );
      }
    };

    image = new ShapeImage(
		Evacuation.this, SHAPE_DRAW_2D, true, 40.0, 20.0, 0.0, 0.0, 
			40.0, 40.0, "/evacuation/", 
			new String[]{"icon.png",}	 ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _image_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    line87 = new ShapeLine(
		SHAPE_DRAW_2D, false, 930.0, 150.0, 0.0, black, 
 		120.0,	0.0, 0.0, 1.0, 10.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _line87_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    text17 = new ShapeText(
        SHAPE_DRAW_2D, false,930.0, 130.0, 0.0, 0.0, 
        navy,"Exits",
        _text17_Font, ALIGNMENT_LEFT ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _text17_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

  }

  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsAP0_xjal() {
    {
    HistogramData _item;
    List<HistogramData> _items = new ArrayList<HistogramData>( 1 );
    _item = 
timeMeasureEnd.distribution
//timeMeasureEnd.dataset 
;
    _items.add( _item ); 
    List<String> _titles = new ArrayList<String>( 1 );
    _titles.add( "Duration of the evacuation" );
    List<Histogram.Appearance> _appearances = new ArrayList<Histogram.Appearance>( 1 );
    _appearances.add( new Histogram.Appearance( oliveDrab, gold, oliveDrab, slateBlue, 1, mediumOrchid ) );
    chart = new Histogram(
		    Evacuation.this, true, -540.0, -110.0, 
			370.0, 300.0,
            null, null,
            40.0, 20.0,
			310.0, 190.0, white, black, black,
            60.0, Chart.SOUTH,
            Chart.GRID_DEFAULT, Chart.GRID_DEFAULT,
            darkGray, darkGray, 
            true, false, false, 0.8,
            _items, _titles, _appearances ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _chart_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }
    };

    }
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
      case _chart: return chart;
      case _rectangle: return rectangle;
      case _image: return image;
      case _line87: return line87;
      case _text17: return text17;
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
      _name_xjal = checkNameOfShape_xjal( _shape, chart, "chart" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, rectangle, "rectangle" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, image, "image" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, line87, "line87" ); if (_name_xjal != null) return _name_xjal;
      _name_xjal = checkNameOfShape_xjal( _shape, text17, "text17" ); if (_name_xjal != null) return _name_xjal;
    } catch (Exception e) {
      return null;
    }
    return super.getNameOfShape_xjal( _shape );
  }
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector16_pointsX_xjal = {
    650,  740, 750, 800 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector16_pointsY_xjal = {
    340,350, 350, 340 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector15_pointsX_xjal = {
    610,  470 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector15_pointsY_xjal = {
    430,430 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector7_pointsX_xjal = {
    810,  870 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector7_pointsY_xjal = {
    340,340 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector6_pointsX_xjal = {
    130,  370 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector6_pointsY_xjal = {
    240,210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector5_pointsX_xjal = {
    650,  800, 800 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector5_pointsY_xjal = {
    430,430, 340 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector_pointsX_xjal = {
    40,  -10, 20 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector_pointsY_xjal = {
    40,120, 130 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector14_pointsX_xjal = {
    480,  610 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector14_pointsY_xjal = {
    420,340 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector1_pointsX_xjal = {
    130,  370 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector1_pointsY_xjal = {
    200,210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector9_pointsX_xjal = {
    130,  170 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector9_pointsY_xjal = {
    160,50 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector11_pointsX_xjal = {
    360,  480 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector11_pointsY_xjal = {
    130,140 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector21_pointsX_xjal = {
    510,  330 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector21_pointsY_xjal = {
    150,450 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector23_pointsX_xjal = {
    640,  640, 350, 330 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector23_pointsY_xjal = {
    350,500, 500, 450 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector24_pointsX_xjal = {
    640,  580, 350, 330 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector24_pointsY_xjal = {
    440,500, 500, 450 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector3_pointsX_xjal = {
    520,  510, 380 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector3_pointsY_xjal = {
    140,200, 300 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector22_pointsX_xjal = {
    380,  380 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector22_pointsY_xjal = {
    300,220 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector27_pointsX_xjal = {
    710,  800 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector27_pointsY_xjal = {
    270,340 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector28_pointsX_xjal = {
    700,  690, 350, 330 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector28_pointsY_xjal = {
    280,500, 500, 450 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector29_pointsX_xjal = {
    400,  670 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector29_pointsY_xjal = {
    360,270 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector17_pointsX_xjal = {
    350,  370 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector17_pointsY_xjal = {
    450,210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector12_pointsX_xjal = {
    340,  180, 170 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector12_pointsY_xjal = {
    460,460, 50 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector19_pointsX_xjal = {
    210,  210 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector19_pointsY_xjal = {
    220,330 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector25_pointsX_xjal = {
    200,  200, 200 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector25_pointsY_xjal = {
    60,60, 210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector62_pointsX_xjal = {
    220,  370 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector62_pointsY_xjal = {
    210,210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector65_pointsX_xjal = {
    30,  70, 61 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector65_pointsY_xjal = {
    950,950, 810 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector4_pointsX_xjal = {
    -310,  -260 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector4_pointsY_xjal = {
    790,790 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector8_pointsX_xjal = {
    -320,  -250, 820, 870 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector8_pointsY_xjal = {
    800,1070, 970, 340 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector34_pointsX_xjal = {
    101,  341 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector34_pointsY_xjal = {
    810,810 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector44_pointsX_xjal = {
    221,  131 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector44_pointsY_xjal = {
    710,710 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector50_pointsX_xjal = {
    330,  381 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector50_pointsY_xjal = {
    450,810 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector33_pointsX_xjal = {
    261,  341 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector33_pointsY_xjal = {
    710,810 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector10_pointsX_xjal = {
    30,  110 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector10_pointsY_xjal = {
    130,160 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector52_pointsX_xjal = {
    -350,  -410 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector52_pointsY_xjal = {
    790,790 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector40_pointsX_xjal = {
    340,  350, 390 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector40_pointsY_xjal = {
    90,180, 210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector42_pointsX_xjal = {
    360,  420 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector42_pointsY_xjal = {
    110,50 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector43_pointsX_xjal = {
    460,  790, 800 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector43_pointsY_xjal = {
    50,50, 340 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector53_pointsX_xjal = {
    780,  800 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector53_pointsY_xjal = {
    170,340 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector35_pointsX_xjal = {
    -150,  61 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector35_pointsY_xjal = {
    800,810 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector20_pointsX_xjal = {
    400,  460 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector20_pointsY_xjal = {
    380,420 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector49_pointsX_xjal = {
    490,  610 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector49_pointsY_xjal = {
    350,430 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector55_pointsX_xjal = {
    490,  610 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector55_pointsY_xjal = {
    330,340 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector18_pointsX_xjal = {
    400,  470 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector18_pointsY_xjal = {
    340,290 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector2_pointsX_xjal = {
    490,  670 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector2_pointsY_xjal = {
    310,270 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector56_pointsX_xjal = {
    680,  830 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector56_pointsY_xjal = {
    140,-30 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector57_pointsX_xjal = {
    870,  890, 520, 420 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector57_pointsY_xjal = {
    -30,-160, -120, 50 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector51_pointsX_xjal = {
    680,  740 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector51_pointsY_xjal = {
    160,170 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector59_pointsX_xjal = {
    680,  460 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector59_pointsY_xjal = {
    180,420 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector60_pointsX_xjal = {
    400,  660 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector60_pointsY_xjal = {
    320,120 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector61_pointsX_xjal = {
    770,  760, 350, 330 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector61_pointsY_xjal = {
    180,510, 500, 450 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector58_pointsX_xjal = {
    680,  740 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector58_pointsY_xjal = {
    120,170 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector67_pointsX_xjal = {
    680,  460 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector67_pointsY_xjal = {
    200,420 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector68_pointsX_xjal = {
    450,  330 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector68_pointsY_xjal = {
    60,450 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector69_pointsX_xjal = {
    860,  850, 350, 330 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector69_pointsY_xjal = {
    -20,510, 500, 450 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector32_pointsX_xjal = {
    -150,  1, 41, 91 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector32_pointsY_xjal = {
    820,710, 710, 710 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector45_pointsX_xjal = {
    -150,  61 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector45_pointsY_xjal = {
    840,810 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector46_pointsX_xjal = {
    -60,  10 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector46_pointsY_xjal = {
    970,930 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector66_pointsX_xjal = {
    30,  30, -200, -200 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector66_pointsY_xjal = {
    990,1140, 1140, 960 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector13_pointsX_xjal = {
    30,  370 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector13_pointsY_xjal = {
    930,210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector31_pointsX_xjal = {
    30,  110 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector31_pointsY_xjal = {
    970,950 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector39_pointsX_xjal = {
    150,  150, -200, -200 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector39_pointsY_xjal = {
    950,1040, 1040, 960 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector47_pointsX_xjal = {
    130,  170 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector47_pointsY_xjal = {
    180,50 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector48_pointsX_xjal = {
    250,  110 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector48_pointsY_xjal = {
    330,460 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector54_pointsX_xjal = {
    240,  200 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector54_pointsY_xjal = {
    340,210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector26_pointsX_xjal = {
    -160,  -100 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector26_pointsY_xjal = {
    960,970 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector41_pointsX_xjal = {
    -250,  -170 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector41_pointsY_xjal = {
    790,800 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector63_pointsX_xjal = {
    360,  170 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector63_pointsY_xjal = {
    90,50 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector70_pointsX_xjal = {
    360,  480 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector70_pointsY_xjal = {
    170,140 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector71_pointsX_xjal = {
    490,  830 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector71_pointsY_xjal = {
    370,-30 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector72_pointsX_xjal = {
    -150,  10 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector72_pointsY_xjal = {
    860,930 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector30_pointsX_xjal = {
    251,  370 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector30_pointsY_xjal = {
    720,210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector64_pointsX_xjal = {
    91,  370 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector64_pointsY_xjal = {
    820,210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector73_pointsX_xjal = {
    121,  370 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector73_pointsY_xjal = {
    720,210 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector36_pointsX_xjal = {
    400,  170 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector36_pointsY_xjal = {
    300,50 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector37_pointsX_xjal = {
    540,  490 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector37_pointsY_xjal = {
    240,290 };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector38_pointsX_xjal = {
    580,  800 };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _connector38_pointsY_xjal = {
    240,340 };


  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Ports_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if ( _isSuperClass && _publicOnly ) { return; }
      drawPort( _panel, _g, 40, 40, 10, 0, null, port );
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Parameters_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawParameter( _panel, _g, 950, 170, 10, 0, "exits", exits, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 920, 40, 10, 0, "condition", condition, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -510, 410, 10, 0, "route1", route1, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -429, 580, 10, 0, "helpee", helpee, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -429, 610, 10, 0, "helper", helper, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -429, 530, 10, 0, "help_source", help_source, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -589, 560, 10, 0, "time_to_rescue", time_to_rescue, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -599, 590, 9, 0, "time_to_death", time_to_death, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -430, 670, 10, 0, "helper_start_time", helper_start_time, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -309, 500, 10, 0, "helper_targetline", helper_targetline, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -140, 460, 10, 0, "helper_wait", helper_wait, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 890, 470, 10, 0, "predicted_target", predicted_target, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -420, 340, 10, 0, "route2", route2, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -380, 400, 10, 0, "route3", route3, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -480, 300, 10, 0, "route4", route4, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -300, 340, 10, 0, "route5", route5, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 1100, 140, 10, 0, "pathways", pathways, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -120, 360, 10, 0, "temp", temp, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -420, 460, 10, 0, "injured_helpee", injured_helpee, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 1040, 390, 10, 0, "time_end", time_end, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -110, 390, 10, 0, "temp_dtime", temp_dtime, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -620, 460, 10, 0, "helper_recived", helper_recived, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -620, 490, 10, 0, "helper_to_rescue", helper_to_rescue, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -800, 450, 10, 0, "helpee_predictdead", helpee_predictdead, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, -800, 470, 10, 0, "helpee_realdead", helpee_realdead, 0 );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_PlainVariables_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 950, 240, 10, 0, "peopleinside", peopleinside, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -169, 590, 10, 0, "ind", ind, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -169, 610, 15, 0, "ind2", ind2, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -169, 630, 15, 0, "ind3", ind3, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -430, 640, 15, 0, "indexofhelper", indexofhelper, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 960, 300, 10, 0, "people_helped", people_helped, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 970, 350, 10, 0, "people_helper", people_helper, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -290, 550, 10, 0, "wait_time", wait_time, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 1070, 70, 10, 0, "route", route, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -280, 460, 10, 0, "injured_ind", injured_ind, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 960, 320, 10, 0, "injured_people_helped", injured_people_helped, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -440, 700, 10, 0, "helper_canceled", helper_canceled, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -620, 700, 10, 0, "firsthelper", firsthelper, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, -620, 730, 10, 0, "inside_alive", inside_alive, false );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Functions_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawFunction( _panel, _g, 950, 190, 10, 0, "getClosestExit");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 950, 210, 10, 0, "isWorker");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 920, 100, 10, 0, "cancelall");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 920, 520, 10, 0, "select_area");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 970, 650, 10, 0, "isHelper");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 920, 580, 10, 0, "route_forhelperhelpee");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, -130, 240, 10, 0, "get_agent_Grnd");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, -66, 276, 10, 0, "get_area_sensor");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, -70, 300, 10, 0, "get_area_visitor");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 780, 680, 10, 0, "inject_helper2");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 780, 620, 10, 0, "allocate_helper");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 610, 570, 10, 0, "allocate_helper1");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, -70, 320, 10, 0, "get_area_visitor1");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 560, 660, 10, 0, "select_area_safest");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 790, 550, 10, 0, "static_route_forhelperhelpee1");
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_EmbeddeObjects_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    // Embedded object "pedGoToExit1"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 310 , 730 , 285, -265, "pedGoToExit1", this.pedGoToExit1 );
    }
    // Embedded object "pedGoToExit"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 310 , 640 , 285, -330, "pedGoToExit", this.pedGoToExit );
    }
    // Embedded object "pedSink"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 720 , 540 , 140, -225, "pedSink", this.pedSink );
    }
    // Embedded object "selectOutput"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 310 , 160 , 26, 37, null, this.selectOutput );
    }
    // Embedded object "timeMeasureEnd"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 750 , 290 , -9, 23, null, this.timeMeasureEnd );
    }
    // Embedded object "pedSelectOutput1"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -100 , 610 , 165, -464, null, this.pedSelectOutput1 );
    }
    // Embedded object "pedLongWait"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -80 , 300 , 220, -265, "pedLongWait", this.pedLongWait );
    }
    // Embedded object "pedChangeGround"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 180 , 440 , 270, -330, "pedChangeGround", this.pedChangeGround );
    }
    // Embedded object "selectOutput3"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 400 , 370 , 26, 37, null, this.selectOutput3 );
    }
    // Embedded object "peddead"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -40 , 580 , 235, -280, "peddead", this.peddead );
    }
    // Embedded object "pedSelectOutput2"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 170 , 750 , 165, -464, null, this.pedSelectOutput2 );
    }
    // Embedded object "changeroute"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 270 , 400 , 26, 37, null, this.changeroute );
    }
    // Embedded object "pedGoToExit2"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 370 , 570 , 285, -330, "pedGoToExit2", this.pedGoToExit2 );
    }
    // Embedded object "helpgotoped"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -79 , 1010 , 285, -330, "helpgotoped", this.helpgotoped );
    }
    // Embedded object "helpsource"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -610 , 1090 , 155, -330, "helpsource", this.helpsource );
    }
    // Embedded object "pedShortWait1"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 91 , 1060 , 235, -280, "pedShortWait1", this.pedShortWait1 );
    }
    // Embedded object "pedChangeGround1"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -209 , 1010 , 270, -330, "pedChangeGround1", this.pedChangeGround1 );
    }
    // Embedded object "helpgotoped1"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -239 , 1110 , 285, -330, "helpgotoped1", this.helpgotoped1 );
    }
    // Embedded object "selectOutput5"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 140 , 160 , 26, 37, null, this.selectOutput5 );
    }
    // Embedded object "pedShortWait"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -600 , 1040 , 235, -280, "pedShortWait", this.pedShortWait );
    }
    // Embedded object "timeMeasureStart"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -30 , 80 , 8, 23, null, this.timeMeasureStart );
    }
    // Embedded object "pedWindowWait"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 170 , 300 , 220, -265, "pedWindowWait", this.pedWindowWait );
    }
    // Embedded object "pedSelectOutput3"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -380 , 1250 , 165, -464, null, this.pedSelectOutput3 );
    }
    // Embedded object "pedGoToExit4"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 440 , 470 , 285, -330, "pedGoToExit4", this.pedGoToExit4 );
    }
    // Embedded object "pedSelectOutput4"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 260 , 740 , 165, -464, null, this.pedSelectOutput4 );
    }
    // Embedded object "pedSelectOutput5"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 450 , 570 , 165, -464, null, this.pedSelectOutput5 );
    }
    // Embedded object "pedChangeGround2"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 530 , 270 , 270, -330, "pedChangeGround2", this.pedChangeGround2 );
    }
    // Embedded object "helpsearch"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -350 , 1220 , 235, -280, "helpsearch", this.helpsearch );
    }
    // Embedded object "pedSelectOutput6"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -200 , 1380 , 165, -464, null, this.pedSelectOutput6 );
    }
    // Embedded object "pedChangeGround3"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -190 , 1250 , 270, -330, "pedChangeGround3", this.pedChangeGround3 );
    }
    // Embedded object "ped_realdead"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -140 , 710 , 235, -280, "ped_realdead", this.ped_realdead );
    }
    // Embedded object "gotoped"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -500 , 1260 , 285, -330, "gotoped", this.gotoped );
    }
    // Embedded object "timeMeasureStart1"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, -310 , 740 , 8, 23, null, this.timeMeasureStart1 );
    }
    // Embedded object "pedSelectOutput7"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 130 , 540 , 165, -464, null, this.pedSelectOutput7 );
    }
    // Embedded object "pedGoToExit3"
    if (!_publicOnly) {
	  drawEmbeddedObjectModel( _panel, _g, 240 , 540 , 285, -330, "pedGoToExit3", this.pedGoToExit3 );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Connectors_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector16_pointsX_xjal, _connector16_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector15_pointsX_xjal, _connector15_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector7_pointsX_xjal, _connector7_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector6_pointsX_xjal, _connector6_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector5_pointsX_xjal, _connector5_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector_pointsX_xjal, _connector_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector14_pointsX_xjal, _connector14_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector1_pointsX_xjal, _connector1_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector9_pointsX_xjal, _connector9_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector11_pointsX_xjal, _connector11_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector21_pointsX_xjal, _connector21_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector23_pointsX_xjal, _connector23_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector24_pointsX_xjal, _connector24_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector3_pointsX_xjal, _connector3_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector22_pointsX_xjal, _connector22_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector27_pointsX_xjal, _connector27_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector28_pointsX_xjal, _connector28_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector29_pointsX_xjal, _connector29_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector17_pointsX_xjal, _connector17_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector12_pointsX_xjal, _connector12_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector19_pointsX_xjal, _connector19_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector25_pointsX_xjal, _connector25_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector62_pointsX_xjal, _connector62_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector65_pointsX_xjal, _connector65_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector4_pointsX_xjal, _connector4_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector8_pointsX_xjal, _connector8_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector34_pointsX_xjal, _connector34_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector44_pointsX_xjal, _connector44_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector50_pointsX_xjal, _connector50_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector33_pointsX_xjal, _connector33_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector10_pointsX_xjal, _connector10_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector52_pointsX_xjal, _connector52_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector40_pointsX_xjal, _connector40_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector42_pointsX_xjal, _connector42_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector43_pointsX_xjal, _connector43_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector53_pointsX_xjal, _connector53_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector35_pointsX_xjal, _connector35_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector20_pointsX_xjal, _connector20_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector49_pointsX_xjal, _connector49_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector55_pointsX_xjal, _connector55_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector18_pointsX_xjal, _connector18_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector2_pointsX_xjal, _connector2_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector56_pointsX_xjal, _connector56_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector57_pointsX_xjal, _connector57_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector51_pointsX_xjal, _connector51_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector59_pointsX_xjal, _connector59_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector60_pointsX_xjal, _connector60_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector61_pointsX_xjal, _connector61_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector58_pointsX_xjal, _connector58_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector67_pointsX_xjal, _connector67_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector68_pointsX_xjal, _connector68_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector69_pointsX_xjal, _connector69_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector32_pointsX_xjal, _connector32_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector45_pointsX_xjal, _connector45_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector46_pointsX_xjal, _connector46_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector66_pointsX_xjal, _connector66_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector13_pointsX_xjal, _connector13_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector31_pointsX_xjal, _connector31_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector39_pointsX_xjal, _connector39_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector47_pointsX_xjal, _connector47_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector48_pointsX_xjal, _connector48_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector54_pointsX_xjal, _connector54_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector26_pointsX_xjal, _connector26_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector41_pointsX_xjal, _connector41_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector63_pointsX_xjal, _connector63_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector70_pointsX_xjal, _connector70_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector71_pointsX_xjal, _connector71_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector72_pointsX_xjal, _connector72_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector30_pointsX_xjal, _connector30_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector64_pointsX_xjal, _connector64_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector73_pointsX_xjal, _connector73_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector36_pointsX_xjal, _connector36_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector37_pointsX_xjal, _connector37_pointsY_xjal, false );
      }
    if (!_publicOnly) {
      drawConnector( _panel, _g, _connector38_pointsX_xjal, _connector38_pointsY_xjal, false );
      }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_AgentLinks_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (_publicOnly) { return; }
      drawLinkToContainer( _panel, _g, -329, 1100, -10, 20, "main", main );
      drawLinkToAgent( _panel, _g, -70, -60, 10, 0, "connections", true, connections );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void drawModelElements( Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
  	super.drawModelElements( _panel, _g, _publicOnly, true );
    drawModelElements_Ports_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_Parameters_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_PlainVariables_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_Functions_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_EmbeddeObjects_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_Connectors_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_AgentLinks_xjal( _panel, _g, _publicOnly, _isSuperClass );
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_EmbeddedObjects_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if ( pedGoToExit1.onClickIconAt( _x - 310, _y - 730, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedGoToExit1" );
      } else {
        _panel.addInspect( _x, _y, this, "pedGoToExit1" );
      }
      return true;
    }
    if ( pedGoToExit.onClickIconAt( _x - 310, _y - 640, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedGoToExit" );
      } else {
        _panel.addInspect( _x, _y, this, "pedGoToExit" );
      }
      return true;
    }
    if ( pedSink.onClickIconAt( _x - 720, _y - 540, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedSink" );
      } else {
        _panel.addInspect( _x, _y, this, "pedSink" );
      }
      return true;
    }
    if ( selectOutput.onClickIconAt( _x - 310, _y - 160, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "selectOutput" );
      } else {
        _panel.addInspect( _x, _y, this, "selectOutput" );
      }
      return true;
    }
    if ( timeMeasureEnd.onClickIconAt( _x - 750, _y - 290, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "timeMeasureEnd" );
      } else {
        _panel.addInspect( _x, _y, this, "timeMeasureEnd" );
      }
      return true;
    }
    if ( pedSelectOutput1.onClickIconAt( _x - -100, _y - 610, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedSelectOutput1" );
      } else {
        _panel.addInspect( _x, _y, this, "pedSelectOutput1" );
      }
      return true;
    }
    if ( pedLongWait.onClickIconAt( _x - -80, _y - 300, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedLongWait" );
      } else {
        _panel.addInspect( _x, _y, this, "pedLongWait" );
      }
      return true;
    }
    if ( pedChangeGround.onClickIconAt( _x - 180, _y - 440, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedChangeGround" );
      } else {
        _panel.addInspect( _x, _y, this, "pedChangeGround" );
      }
      return true;
    }
    if ( selectOutput3.onClickIconAt( _x - 400, _y - 370, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "selectOutput3" );
      } else {
        _panel.addInspect( _x, _y, this, "selectOutput3" );
      }
      return true;
    }
    if ( peddead.onClickIconAt( _x - -40, _y - 580, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "peddead" );
      } else {
        _panel.addInspect( _x, _y, this, "peddead" );
      }
      return true;
    }
    if ( pedSelectOutput2.onClickIconAt( _x - 170, _y - 750, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedSelectOutput2" );
      } else {
        _panel.addInspect( _x, _y, this, "pedSelectOutput2" );
      }
      return true;
    }
    if ( changeroute.onClickIconAt( _x - 270, _y - 400, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "changeroute" );
      } else {
        _panel.addInspect( _x, _y, this, "changeroute" );
      }
      return true;
    }
    if ( pedGoToExit2.onClickIconAt( _x - 370, _y - 570, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedGoToExit2" );
      } else {
        _panel.addInspect( _x, _y, this, "pedGoToExit2" );
      }
      return true;
    }
    if ( helpgotoped.onClickIconAt( _x - -79, _y - 1010, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "helpgotoped" );
      } else {
        _panel.addInspect( _x, _y, this, "helpgotoped" );
      }
      return true;
    }
    if ( helpsource.onClickIconAt( _x - -610, _y - 1090, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "helpsource" );
      } else {
        _panel.addInspect( _x, _y, this, "helpsource" );
      }
      return true;
    }
    if ( pedShortWait1.onClickIconAt( _x - 91, _y - 1060, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedShortWait1" );
      } else {
        _panel.addInspect( _x, _y, this, "pedShortWait1" );
      }
      return true;
    }
    if ( pedChangeGround1.onClickIconAt( _x - -209, _y - 1010, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedChangeGround1" );
      } else {
        _panel.addInspect( _x, _y, this, "pedChangeGround1" );
      }
      return true;
    }
    if ( helpgotoped1.onClickIconAt( _x - -239, _y - 1110, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "helpgotoped1" );
      } else {
        _panel.addInspect( _x, _y, this, "helpgotoped1" );
      }
      return true;
    }
    if ( selectOutput5.onClickIconAt( _x - 140, _y - 160, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "selectOutput5" );
      } else {
        _panel.addInspect( _x, _y, this, "selectOutput5" );
      }
      return true;
    }
    if ( pedShortWait.onClickIconAt( _x - -600, _y - 1040, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedShortWait" );
      } else {
        _panel.addInspect( _x, _y, this, "pedShortWait" );
      }
      return true;
    }
    if ( timeMeasureStart.onClickIconAt( _x - -30, _y - 80, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "timeMeasureStart" );
      } else {
        _panel.addInspect( _x, _y, this, "timeMeasureStart" );
      }
      return true;
    }
    if ( pedWindowWait.onClickIconAt( _x - 170, _y - 300, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedWindowWait" );
      } else {
        _panel.addInspect( _x, _y, this, "pedWindowWait" );
      }
      return true;
    }
    if ( pedSelectOutput3.onClickIconAt( _x - -380, _y - 1250, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedSelectOutput3" );
      } else {
        _panel.addInspect( _x, _y, this, "pedSelectOutput3" );
      }
      return true;
    }
    if ( pedGoToExit4.onClickIconAt( _x - 440, _y - 470, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedGoToExit4" );
      } else {
        _panel.addInspect( _x, _y, this, "pedGoToExit4" );
      }
      return true;
    }
    if ( pedSelectOutput4.onClickIconAt( _x - 260, _y - 740, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedSelectOutput4" );
      } else {
        _panel.addInspect( _x, _y, this, "pedSelectOutput4" );
      }
      return true;
    }
    if ( pedSelectOutput5.onClickIconAt( _x - 450, _y - 570, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedSelectOutput5" );
      } else {
        _panel.addInspect( _x, _y, this, "pedSelectOutput5" );
      }
      return true;
    }
    if ( pedChangeGround2.onClickIconAt( _x - 530, _y - 270, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedChangeGround2" );
      } else {
        _panel.addInspect( _x, _y, this, "pedChangeGround2" );
      }
      return true;
    }
    if ( helpsearch.onClickIconAt( _x - -350, _y - 1220, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "helpsearch" );
      } else {
        _panel.addInspect( _x, _y, this, "helpsearch" );
      }
      return true;
    }
    if ( pedSelectOutput6.onClickIconAt( _x - -200, _y - 1380, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedSelectOutput6" );
      } else {
        _panel.addInspect( _x, _y, this, "pedSelectOutput6" );
      }
      return true;
    }
    if ( pedChangeGround3.onClickIconAt( _x - -190, _y - 1250, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedChangeGround3" );
      } else {
        _panel.addInspect( _x, _y, this, "pedChangeGround3" );
      }
      return true;
    }
    if ( ped_realdead.onClickIconAt( _x - -140, _y - 710, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "ped_realdead" );
      } else {
        _panel.addInspect( _x, _y, this, "ped_realdead" );
      }
      return true;
    }
    if ( gotoped.onClickIconAt( _x - -500, _y - 1260, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "gotoped" );
      } else {
        _panel.addInspect( _x, _y, this, "gotoped" );
      }
      return true;
    }
    if ( timeMeasureStart1.onClickIconAt( _x - -310, _y - 740, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "timeMeasureStart1" );
      } else {
        _panel.addInspect( _x, _y, this, "timeMeasureStart1" );
      }
      return true;
    }
    if ( pedSelectOutput7.onClickIconAt( _x - 130, _y - 540, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedSelectOutput7" );
      } else {
        _panel.addInspect( _x, _y, this, "pedSelectOutput7" );
      }
      return true;
    }
    if ( pedGoToExit3.onClickIconAt( _x - 240, _y - 540, true ) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( _x, _y, this, "pedGoToExit3" );
      } else {
        _panel.addInspect( _x, _y, this, "pedGoToExit3" );
      }
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_AgentLinks_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if ( modelElementContains(_x, _y, -329, 1100) ) {
      if ( _clickCount == 2 ) {
        _panel.browseAgent_xjal( -329, 1100, this, "main" );
      } else {
        _panel.addInspect( -329, 1100, this, "main" );
      }
      return true;
    }
    if ( modelElementContains(_x, _y, -70, -60) ) {
        _panel.addInspect_xjal( -70, -60, this, "connections", Panel.INSPECT_CONNECTIONS_xjal );
      return true;
    }
    return false;
  }


  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_Parameters_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 950, 170) ) {
      _panel.addInspect( 950, 170, this, "exits" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 920, 40) ) {
      _panel.addInspect( 920, 40, this, "condition" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -510, 410) ) {
      _panel.addInspect( -510, 410, this, "route1" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -429, 580) ) {
      _panel.addInspect( -429, 580, this, "helpee" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -429, 610) ) {
      _panel.addInspect( -429, 610, this, "helper" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -429, 530) ) {
      _panel.addInspect( -429, 530, this, "help_source" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -589, 560) ) {
      _panel.addInspect( -589, 560, this, "time_to_rescue" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -599, 590) ) {
      _panel.addInspect( -599, 590, this, "time_to_death" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -430, 670) ) {
      _panel.addInspect( -430, 670, this, "helper_start_time" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -309, 500) ) {
      _panel.addInspect( -309, 500, this, "helper_targetline" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -140, 460) ) {
      _panel.addInspect( -140, 460, this, "helper_wait" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 890, 470) ) {
      _panel.addInspect( 890, 470, this, "predicted_target" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -420, 340) ) {
      _panel.addInspect( -420, 340, this, "route2" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -380, 400) ) {
      _panel.addInspect( -380, 400, this, "route3" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -480, 300) ) {
      _panel.addInspect( -480, 300, this, "route4" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -300, 340) ) {
      _panel.addInspect( -300, 340, this, "route5" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 1100, 140) ) {
      _panel.addInspect( 1100, 140, this, "pathways" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -120, 360) ) {
      _panel.addInspect( -120, 360, this, "temp" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -420, 460) ) {
      _panel.addInspect( -420, 460, this, "injured_helpee" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 1040, 390) ) {
      _panel.addInspect( 1040, 390, this, "time_end" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -110, 390) ) {
      _panel.addInspect( -110, 390, this, "temp_dtime" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -620, 460) ) {
      _panel.addInspect( -620, 460, this, "helper_recived" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -620, 490) ) {
      _panel.addInspect( -620, 490, this, "helper_to_rescue" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -800, 450) ) {
      _panel.addInspect( -800, 450, this, "helpee_predictdead" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -800, 470) ) {
      _panel.addInspect( -800, 470, this, "helpee_realdead" ); 
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_PlainVariables_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 950, 240) ) {
      _panel.addInspect( 950, 240, this, "peopleinside" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -169, 590) ) {
      _panel.addInspect( -169, 590, this, "ind" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -169, 610) ) {
      _panel.addInspect( -169, 610, this, "ind2" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -169, 630) ) {
      _panel.addInspect( -169, 630, this, "ind3" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -430, 640) ) {
      _panel.addInspect( -430, 640, this, "indexofhelper" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 960, 300) ) {
      _panel.addInspect( 960, 300, this, "people_helped" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 970, 350) ) {
      _panel.addInspect( 970, 350, this, "people_helper" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -290, 550) ) {
      _panel.addInspect( -290, 550, this, "wait_time" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 1070, 70) ) {
      _panel.addInspect( 1070, 70, this, "route" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -280, 460) ) {
      _panel.addInspect( -280, 460, this, "injured_ind" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 960, 320) ) {
      _panel.addInspect( 960, 320, this, "injured_people_helped" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -440, 700) ) {
      _panel.addInspect( -440, 700, this, "helper_canceled" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -620, 700) ) {
      _panel.addInspect( -620, 700, this, "firsthelper" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, -620, 730) ) {
      _panel.addInspect( -620, 730, this, "inside_alive" ); 
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_Ports_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if ( _isSuperClass && _publicOnly ) { return false; }
    if( modelElementContains(_x, _y, 40, 40) ) {
      _panel.addInspect( 40, 40, this, "port" ); 
      return true;
    }
    return false;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onClickModelAt( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if ( onClickModelAt_EmbeddedObjects_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_AgentLinks_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_Parameters_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_PlainVariables_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_Ports_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    return super.onClickModelAt( _panel, _x, _y, _clickCount, _publicOnly, true );
  }



  // Ports

  public Port< 
Object 
, 
Object > port = new Port< Object, Object >( this );

  @AnyLogicInternalCodegenAPI
  public String getNameOf( Port<?, ?> _p ) {
    if( _p == this.port ) return "port";
    return super.getNameOf( _p ); 
  }

  @AnyLogicInternalCodegenAPI
  public boolean executeOnSendActionOf( Port<?, ?> _p, Object _msg ) {
    if( _p == this.port ) {
      Port< Object, Object > self = this.port;
      Object msg = (Object) _msg;

 
    }
    return super.executeOnSendActionOf( _p, _msg );
  }

  @AnyLogicInternalCodegenAPI
  public boolean executeOnReceiveActionOf( Port<?, ?> _p, Object _msg ) {
    if( _p == this.port ) {
      Port< Object, Object > self = this.port;
      Object msg = (Object) _msg;
      
 
    }
    return super.executeOnReceiveActionOf( _p, _msg );
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
  public Evacuation( Engine engine, Agent owner, AgentList<? extends Evacuation> ownerPopulation ) {
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
    pedGoToExit1 = instantiate_pedGoToExit1_xjal();
    pedGoToExit = instantiate_pedGoToExit_xjal();
    pedSink = instantiate_pedSink_xjal();
    selectOutput = instantiate_selectOutput_xjal();
    timeMeasureEnd = instantiate_timeMeasureEnd_xjal();
    pedSelectOutput1 = instantiate_pedSelectOutput1_xjal();
    pedLongWait = instantiate_pedLongWait_xjal();
    pedChangeGround = instantiate_pedChangeGround_xjal();
    selectOutput3 = instantiate_selectOutput3_xjal();
    peddead = instantiate_peddead_xjal();
    pedSelectOutput2 = instantiate_pedSelectOutput2_xjal();
    changeroute = instantiate_changeroute_xjal();
    pedGoToExit2 = instantiate_pedGoToExit2_xjal();
    helpgotoped = instantiate_helpgotoped_xjal();
    helpsource = instantiate_helpsource_xjal();
    pedShortWait1 = instantiate_pedShortWait1_xjal();
    pedChangeGround1 = instantiate_pedChangeGround1_xjal();
    helpgotoped1 = instantiate_helpgotoped1_xjal();
    selectOutput5 = instantiate_selectOutput5_xjal();
    pedShortWait = instantiate_pedShortWait_xjal();
    timeMeasureStart = instantiate_timeMeasureStart_xjal();
    pedWindowWait = instantiate_pedWindowWait_xjal();
    pedSelectOutput3 = instantiate_pedSelectOutput3_xjal();
    pedGoToExit4 = instantiate_pedGoToExit4_xjal();
    pedSelectOutput4 = instantiate_pedSelectOutput4_xjal();
    pedSelectOutput5 = instantiate_pedSelectOutput5_xjal();
    pedChangeGround2 = instantiate_pedChangeGround2_xjal();
    helpsearch = instantiate_helpsearch_xjal();
    pedSelectOutput6 = instantiate_pedSelectOutput6_xjal();
    pedChangeGround3 = instantiate_pedChangeGround3_xjal();
    ped_realdead = instantiate_ped_realdead_xjal();
    gotoped = instantiate_gotoped_xjal();
    timeMeasureStart1 = instantiate_timeMeasureStart1_xjal();
    pedSelectOutput7 = instantiate_pedSelectOutput7_xjal();
    pedGoToExit3 = instantiate_pedGoToExit3_xjal();
    setupReferences_xjal();
  }
  
  @AnyLogicInternalCodegenAPI
  private void setupReferences_xjal() {
    main = get_Main();
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Evacuation() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public Evacuation( ArrayList<TargetLine> exits, int condition, RectangularNode[] route1, Visitor[] helpee, ArrayList< Visitor> helper, int help_source, double[] time_to_rescue, double[] time_to_death, double[] helper_start_time, TargetLine[] helper_targetline, double[] helper_wait, TargetLine predicted_target, RectangularNode[] route2, RectangularNode[] route3, RectangularNode[] route4, RectangularNode[] route5, ArrayList<Pathway> pathways, double[] temp, Visitor[] injured_helpee, TimeMeasureEnd time_end, double[] temp_dtime, double[] helper_recived, double[] helper_to_rescue, double[] helpee_predictdead, double[] helpee_realdead ) {
    markParametersAreSet();
    this.exits = exits;
    this.condition = condition;
    this.route1 = route1;
    this.helpee = helpee;
    this.helper = helper;
    this.help_source = help_source;
    this.time_to_rescue = time_to_rescue;
    this.time_to_death = time_to_death;
    this.helper_start_time = helper_start_time;
    this.helper_targetline = helper_targetline;
    this.helper_wait = helper_wait;
    this.predicted_target = predicted_target;
    this.route2 = route2;
    this.route3 = route3;
    this.route4 = route4;
    this.route5 = route5;
    this.pathways = pathways;
    this.temp = temp;
    this.injured_helpee = injured_helpee;
    this.time_end = time_end;
    this.temp_dtime = temp_dtime;
    this.helper_recived = helper_recived;
    this.helper_to_rescue = helper_to_rescue;
    this.helpee_predictdead = helpee_predictdead;
    this.helpee_realdead = helpee_realdead;
  }
  
  /**
   * Creating embedded object instances
   */
  @AnyLogicInternalCodegenAPI
  private void instantiatePopulations_xjal() {
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Creating embedded object instances
    instantiatePopulations_xjal();
    // Assigning initial values for plain variables
    setupPlainVariables_Evacuation_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation = new ShapeTopLevelPresentationGroup( Evacuation.this, true, 0, 0, 0, 0 , line87, text17, chart );
    // Creating embedded object instances
    instantiatePopulations_xjal();
    icon = new ShapeModelElementsGroup( Evacuation.this, getElementProperty( "evacuation.Evacuation.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS ) , rectangle, image );
    icon.setIconOffsets( 40.0, 20.0 );
    // Creating non-replicated embedded objects
    setupParameters_pedGoToExit1_xjal( pedGoToExit1 );
    create_pedGoToExit1_xjal( pedGoToExit1 );
    setupParameters_pedGoToExit_xjal( pedGoToExit );
    create_pedGoToExit_xjal( pedGoToExit );
    setupParameters_pedSink_xjal( pedSink );
    create_pedSink_xjal( pedSink );
    setupParameters_selectOutput_xjal( selectOutput );
    create_selectOutput_xjal( selectOutput );
    setupParameters_timeMeasureEnd_xjal( timeMeasureEnd );
    create_timeMeasureEnd_xjal( timeMeasureEnd );
    setupParameters_pedSelectOutput1_xjal( pedSelectOutput1 );
    create_pedSelectOutput1_xjal( pedSelectOutput1 );
    setupParameters_pedLongWait_xjal( pedLongWait );
    create_pedLongWait_xjal( pedLongWait );
    setupParameters_pedChangeGround_xjal( pedChangeGround );
    create_pedChangeGround_xjal( pedChangeGround );
    setupParameters_selectOutput3_xjal( selectOutput3 );
    create_selectOutput3_xjal( selectOutput3 );
    setupParameters_peddead_xjal( peddead );
    create_peddead_xjal( peddead );
    setupParameters_pedSelectOutput2_xjal( pedSelectOutput2 );
    create_pedSelectOutput2_xjal( pedSelectOutput2 );
    setupParameters_changeroute_xjal( changeroute );
    create_changeroute_xjal( changeroute );
    setupParameters_pedGoToExit2_xjal( pedGoToExit2 );
    create_pedGoToExit2_xjal( pedGoToExit2 );
    setupParameters_helpgotoped_xjal( helpgotoped );
    create_helpgotoped_xjal( helpgotoped );
    setupParameters_helpsource_xjal( helpsource );
    create_helpsource_xjal( helpsource );
    setupParameters_pedShortWait1_xjal( pedShortWait1 );
    create_pedShortWait1_xjal( pedShortWait1 );
    setupParameters_pedChangeGround1_xjal( pedChangeGround1 );
    create_pedChangeGround1_xjal( pedChangeGround1 );
    setupParameters_helpgotoped1_xjal( helpgotoped1 );
    create_helpgotoped1_xjal( helpgotoped1 );
    setupParameters_selectOutput5_xjal( selectOutput5 );
    create_selectOutput5_xjal( selectOutput5 );
    setupParameters_pedShortWait_xjal( pedShortWait );
    create_pedShortWait_xjal( pedShortWait );
    setupParameters_timeMeasureStart_xjal( timeMeasureStart );
    create_timeMeasureStart_xjal( timeMeasureStart );
    setupParameters_pedWindowWait_xjal( pedWindowWait );
    create_pedWindowWait_xjal( pedWindowWait );
    setupParameters_pedSelectOutput3_xjal( pedSelectOutput3 );
    create_pedSelectOutput3_xjal( pedSelectOutput3 );
    setupParameters_pedGoToExit4_xjal( pedGoToExit4 );
    create_pedGoToExit4_xjal( pedGoToExit4 );
    setupParameters_pedSelectOutput4_xjal( pedSelectOutput4 );
    create_pedSelectOutput4_xjal( pedSelectOutput4 );
    setupParameters_pedSelectOutput5_xjal( pedSelectOutput5 );
    create_pedSelectOutput5_xjal( pedSelectOutput5 );
    setupParameters_pedChangeGround2_xjal( pedChangeGround2 );
    create_pedChangeGround2_xjal( pedChangeGround2 );
    setupParameters_helpsearch_xjal( helpsearch );
    create_helpsearch_xjal( helpsearch );
    setupParameters_pedSelectOutput6_xjal( pedSelectOutput6 );
    create_pedSelectOutput6_xjal( pedSelectOutput6 );
    setupParameters_pedChangeGround3_xjal( pedChangeGround3 );
    create_pedChangeGround3_xjal( pedChangeGround3 );
    setupParameters_ped_realdead_xjal( ped_realdead );
    create_ped_realdead_xjal( ped_realdead );
    setupParameters_gotoped_xjal( gotoped );
    create_gotoped_xjal( gotoped );
    setupParameters_timeMeasureStart1_xjal( timeMeasureStart1 );
    create_timeMeasureStart1_xjal( timeMeasureStart1 );
    setupParameters_pedSelectOutput7_xjal( pedSelectOutput7 );
    create_pedSelectOutput7_xjal( pedSelectOutput7 );
    setupParameters_pedGoToExit3_xjal( pedGoToExit3 );
    create_pedGoToExit3_xjal( pedGoToExit3 );
	 // Port connectors with non-replicated objects
    pedGoToExit.out.connect( timeMeasureEnd.in ); // connector16
    pedGoToExit1.in.connect( selectOutput3.outF ); // connector15
    timeMeasureEnd.out.connect( pedSink.in ); // connector7
    pedSelectOutput1.out5.connect( selectOutput.in ); // connector6
    pedGoToExit1.out.connect( timeMeasureEnd.in ); // connector5
    port.map( timeMeasureStart.in ); // connector
    selectOutput3.outT.connect( pedGoToExit.in ); // connector14
    pedSelectOutput1.out3.connect( selectOutput.in ); // connector1
    pedSelectOutput1.out1.connect( pedLongWait.in ); // connector9
    pedSelectOutput7.out3.connect( pedChangeGround.in ); // connector11
    pedChangeGround.ccl.connect( changeroute.in ); // connector21
    pedGoToExit.ccl.connect( changeroute.in ); // connector23
    pedGoToExit1.ccl.connect( changeroute.in ); // connector24
    pedChangeGround.out.connect( pedSelectOutput2.in ); // connector3
    pedSelectOutput2.in.connect( selectOutput.outF ); // connector22
    pedGoToExit2.out.connect( timeMeasureEnd.in ); // connector27
    pedGoToExit2.ccl.connect( changeroute.in ); // connector28
    pedSelectOutput2.out4.connect( pedGoToExit2.in ); // connector29
    changeroute.outT.connect( selectOutput.in ); // connector17
    changeroute.outF.connect( pedLongWait.in ); // connector12
    selectOutput5.outF.connect( peddead.in ); // connector19
    pedLongWait.ccl.connect( selectOutput5.in ); // connector25
    selectOutput5.outT.connect( selectOutput.in ); // connector62
    pedSelectOutput6.out2.connect( helpgotoped1.in ); // connector65
    pedShortWait.out.connect( timeMeasureStart1.in ); // connector4
    pedShortWait.ccl.connect( pedSink.in ); // connector8
    helpgotoped1.out.connect( pedShortWait1.in ); // connector34
    helpgotoped.in.connect( pedChangeGround1.out ); // connector44
    changeroute.in.connect( pedShortWait1.out ); // connector50
    helpgotoped.out.connect( pedShortWait1.in ); // connector33
    timeMeasureStart.out.connect( pedSelectOutput1.in ); // connector10
    pedShortWait.in.connect( helpsource.out ); // connector52
    pedSelectOutput7.in.connect( selectOutput.outT ); // connector40
    pedSelectOutput7.out2.connect( pedWindowWait.in ); // connector42
    pedWindowWait.out.connect( timeMeasureEnd.in ); // connector43
    pedGoToExit4.out.connect( timeMeasureEnd.in ); // connector53
    pedSelectOutput3.out1.connect( helpgotoped1.in ); // connector35
    pedSelectOutput2.out5.connect( selectOutput3.in ); // connector20
    pedSelectOutput4.out4.connect( pedGoToExit1.in ); // connector49
    pedSelectOutput4.out3.connect( pedGoToExit.in ); // connector55
    pedSelectOutput2.out3.connect( pedSelectOutput4.in ); // connector18
    pedSelectOutput4.out2.connect( pedGoToExit2.in ); // connector2
    pedSelectOutput5.out2.connect( pedChangeGround2.in ); // connector56
    pedChangeGround2.out.connect( pedWindowWait.in ); // connector57
    pedSelectOutput5.out3.connect( pedGoToExit4.in ); // connector51
    pedSelectOutput5.out4.connect( selectOutput3.in ); // connector59
    pedSelectOutput2.out2.connect( pedSelectOutput5.in ); // connector60
    pedGoToExit4.ccl.connect( changeroute.in ); // connector61
    pedSelectOutput5.out1.connect( pedGoToExit4.in ); // connector58
    pedSelectOutput5.out5.connect( selectOutput3.in ); // connector67
    pedWindowWait.ccl.connect( changeroute.in ); // connector68
    pedChangeGround2.ccl.connect( changeroute.in ); // connector69
    pedSelectOutput3.out2.connect( pedChangeGround1.in ); // connector32
    pedSelectOutput3.out3.connect( helpgotoped1.in ); // connector45
    helpsearch.out.connect( pedSelectOutput6.in ); // connector46
    pedSelectOutput6.out4.connect( gotoped.in ); // connector66
    pedSelectOutput6.out1.connect( selectOutput.in ); // connector13
    pedSelectOutput6.out3.connect( pedChangeGround3.in ); // connector31
    pedChangeGround3.out.connect( gotoped.in ); // connector39
    pedSelectOutput1.out2.connect( pedLongWait.in ); // connector47
    peddead.out.connect( ped_realdead.in ); // connector48
    peddead.ccl.connect( selectOutput5.in ); // connector54
    gotoped.out.connect( helpsearch.in ); // connector26
    timeMeasureStart1.out.connect( pedSelectOutput3.in ); // connector41
    pedSelectOutput7.out1.connect( pedLongWait.in ); // connector63
    pedSelectOutput7.out5.connect( pedChangeGround.in ); // connector70
    pedSelectOutput4.out5.connect( pedChangeGround2.in ); // connector71
    pedSelectOutput3.out4.connect( pedSelectOutput6.in ); // connector72
    helpgotoped.ccl.connect( selectOutput.in ); // connector30
    helpgotoped1.ccl.connect( selectOutput.in ); // connector64
    pedChangeGround1.ccl.connect( selectOutput.in ); // connector73
    pedSelectOutput2.out1.connect( pedLongWait.in ); // connector36
    pedGoToExit3.in.connect( pedSelectOutput4.out1 ); // connector37
    pedGoToExit3.out.connect( timeMeasureEnd.in ); // connector38
    // Creating replicated embedded objects
    setupInitialConditions_xjal( Evacuation.class );
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
    pedGoToExit1.start();
    pedGoToExit.start();
    pedSink.start();
    selectOutput.start();
    timeMeasureEnd.start();
    pedSelectOutput1.start();
    pedLongWait.start();
    pedChangeGround.start();
    selectOutput3.start();
    peddead.start();
    pedSelectOutput2.start();
    changeroute.start();
    pedGoToExit2.start();
    helpgotoped.start();
    helpsource.start();
    pedShortWait1.start();
    pedChangeGround1.start();
    helpgotoped1.start();
    selectOutput5.start();
    pedShortWait.start();
    timeMeasureStart.start();
    pedWindowWait.start();
    pedSelectOutput3.start();
    pedGoToExit4.start();
    pedSelectOutput4.start();
    pedSelectOutput5.start();
    pedChangeGround2.start();
    helpsearch.start();
    pedSelectOutput6.start();
    pedChangeGround3.start();
    ped_realdead.start();
    gotoped.start();
    timeMeasureStart1.start();
    pedSelectOutput7.start();
    pedGoToExit3.start();
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
    setupPlainVariables_Evacuation_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_Evacuation_xjal() {
    peopleinside = 
//main.getPeopleInsideCount(); 
;
    ind = 
0 
;
    ind2 = 
0 
;
    ind3 = 
0 
;
    indexofhelper = 
0 
;
    people_helped = 
0 
;
    people_helper = 
0 
;
    wait_time = 
10 
;
    route = 
//main.getPeopleInsideCount(); 
;
    injured_ind = 
0 
;
    injured_people_helped = 
0 
;
    helper_canceled = 
0 
;
    firsthelper = 
false 
;
    inside_alive = 
0 
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
    
 
  }



  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public List<Object> getEmbeddedObjects() {
    List<Object> list = super.getEmbeddedObjects();
    if (list == null) {
      list = new LinkedList<Object>();
    }
    list.add( pedGoToExit1 );
    list.add( pedGoToExit );
    list.add( pedSink );
    list.add( selectOutput );
    list.add( timeMeasureEnd );
    list.add( pedSelectOutput1 );
    list.add( pedLongWait );
    list.add( pedChangeGround );
    list.add( selectOutput3 );
    list.add( peddead );
    list.add( pedSelectOutput2 );
    list.add( changeroute );
    list.add( pedGoToExit2 );
    list.add( helpgotoped );
    list.add( helpsource );
    list.add( pedShortWait1 );
    list.add( pedChangeGround1 );
    list.add( helpgotoped1 );
    list.add( selectOutput5 );
    list.add( pedShortWait );
    list.add( timeMeasureStart );
    list.add( pedWindowWait );
    list.add( pedSelectOutput3 );
    list.add( pedGoToExit4 );
    list.add( pedSelectOutput4 );
    list.add( pedSelectOutput5 );
    list.add( pedChangeGround2 );
    list.add( helpsearch );
    list.add( pedSelectOutput6 );
    list.add( pedChangeGround3 );
    list.add( ped_realdead );
    list.add( gotoped );
    list.add( timeMeasureStart1 );
    list.add( pedSelectOutput7 );
    list.add( pedGoToExit3 );
    return list;
  }

  public AgentList<? extends Evacuation> getPopulation() {
    return (AgentList<? extends Evacuation>) super.getPopulation();
  }

  public List<? extends Evacuation> agentsInRange( double distance ) {
    return (List<? extends Evacuation>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(LoggingType loggingType) {
    return false;
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    port.onDestroy();
    pedGoToExit1.onDestroy();
    pedGoToExit.onDestroy();
    pedSink.onDestroy();
    selectOutput.onDestroy();
    timeMeasureEnd.onDestroy();
    pedSelectOutput1.onDestroy();
    pedLongWait.onDestroy();
    pedChangeGround.onDestroy();
    selectOutput3.onDestroy();
    peddead.onDestroy();
    pedSelectOutput2.onDestroy();
    changeroute.onDestroy();
    pedGoToExit2.onDestroy();
    helpgotoped.onDestroy();
    helpsource.onDestroy();
    pedShortWait1.onDestroy();
    pedChangeGround1.onDestroy();
    helpgotoped1.onDestroy();
    selectOutput5.onDestroy();
    pedShortWait.onDestroy();
    timeMeasureStart.onDestroy();
    pedWindowWait.onDestroy();
    pedSelectOutput3.onDestroy();
    pedGoToExit4.onDestroy();
    pedSelectOutput4.onDestroy();
    pedSelectOutput5.onDestroy();
    pedChangeGround2.onDestroy();
    helpsearch.onDestroy();
    pedSelectOutput6.onDestroy();
    pedChangeGround3.onDestroy();
    ped_realdead.onDestroy();
    gotoped.onDestroy();
    timeMeasureStart1.onDestroy();
    pedSelectOutput7.onDestroy();
    pedGoToExit3.onDestroy();
    // On destroy code
    
 
    super.onDestroy();
  }

  @AnyLogicInternalCodegenAPI
  @Override
  public void doFinish() {
    pedGoToExit1.doFinish();
    super.doFinish();
    pedGoToExit.doFinish();
    super.doFinish();
    pedSink.doFinish();
    super.doFinish();
    selectOutput.doFinish();
    super.doFinish();
    timeMeasureEnd.doFinish();
    super.doFinish();
    pedSelectOutput1.doFinish();
    super.doFinish();
    pedLongWait.doFinish();
    super.doFinish();
    pedChangeGround.doFinish();
    super.doFinish();
    selectOutput3.doFinish();
    super.doFinish();
    peddead.doFinish();
    super.doFinish();
    pedSelectOutput2.doFinish();
    super.doFinish();
    changeroute.doFinish();
    super.doFinish();
    pedGoToExit2.doFinish();
    super.doFinish();
    helpgotoped.doFinish();
    super.doFinish();
    helpsource.doFinish();
    super.doFinish();
    pedShortWait1.doFinish();
    super.doFinish();
    pedChangeGround1.doFinish();
    super.doFinish();
    helpgotoped1.doFinish();
    super.doFinish();
    selectOutput5.doFinish();
    super.doFinish();
    pedShortWait.doFinish();
    super.doFinish();
    timeMeasureStart.doFinish();
    super.doFinish();
    pedWindowWait.doFinish();
    super.doFinish();
    pedSelectOutput3.doFinish();
    super.doFinish();
    pedGoToExit4.doFinish();
    super.doFinish();
    pedSelectOutput4.doFinish();
    super.doFinish();
    pedSelectOutput5.doFinish();
    super.doFinish();
    pedChangeGround2.doFinish();
    super.doFinish();
    helpsearch.doFinish();
    super.doFinish();
    pedSelectOutput6.doFinish();
    super.doFinish();
    pedChangeGround3.doFinish();
    super.doFinish();
    ped_realdead.doFinish();
    super.doFinish();
    gotoped.doFinish();
    super.doFinish();
    timeMeasureStart1.doFinish();
    super.doFinish();
    pedSelectOutput7.doFinish();
    super.doFinish();
    pedGoToExit3.doFinish();
    super.doFinish();
  }

  // Additional class code

 
  // End of additional class code


}
