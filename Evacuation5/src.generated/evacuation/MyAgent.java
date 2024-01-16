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

import com.mysema.query.support.ListAccessVisitor;
import java.lang.reflect.Array;
import com.anylogic.libraries.processmodeling.Wait;
import com.mysema.query.types.Template.Element;
import java.lang.annotation.ElementType;
import jdk.nashorn.internal.objects.ArrayBufferView;
//import org.apache.poi.ss.formula.functions.Value;
import javafx.scene.Group;
import javafx.scene.effect.Light.Point; 

public class MyAgent extends Agent
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
    final MyAgent self = this;
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


 
  @AnyLogicCustomProposalType(AnyLogicCustomProposalType.Label.MINUTE)
  public 
double  waitTime1;

  /**
   * Returns default value for parameter <code>waitTime1</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _waitTime1_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
 
;
  }

  public double waitTime1( TimeUnits _units ) {
    return MINUTE.convertTo( waitTime1, _units );
  }

  public void set_waitTime1( double waitTime1, TimeUnits _units ) {
    set_waitTime1( _units.convertTo( waitTime1, MINUTE ) );
  }

  public void set_waitTime1( double waitTime1 ) {
    if (waitTime1 == this.waitTime1) {
      return;
    }
    double _oldValue_xjal = this.waitTime1;
    this.waitTime1 = waitTime1;
    onChange_waitTime1_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter waitTime1.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_waitTime1()</code> method instead.
   */
  protected void onChange_waitTime1() {
    onChange_waitTime1_xjal( waitTime1 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_waitTime1_xjal( double oldValue ) {

 
;  
  }

  
  /**
   * Internal method. Returns the units used in design-time for setting the code of this parameter (these units may be e.g. used for adaptation of dynamic parameter arguments)
   */
  @AnyLogicInternalCodegenAPI
  public TimeUnits getUnitsForCodeOf_waitTime1() {
    return MINUTE;
  }
  
  /**
   * Internal method. Returns the units of this parameter.
   */
  @AnyLogicInternalCodegenAPI
  public TimeUnits getUnitsOf_waitTime1() {
    return MINUTE;
  }

  /**
   * //sorted list of sensors with order near to center of fire
   */
 
  public 
MyAgent[]  connectedag1;

  /**
   * Returns default value for parameter <code>connectedag1</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public MyAgent[] _connectedag1_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
new MyAgent [main.myAgent.size()]//doors + sensors 
;
  }

  public void set_connectedag1( MyAgent[] connectedag1 ) {
    if (connectedag1 == this.connectedag1) {
      return;
    }
    MyAgent[] _oldValue_xjal = this.connectedag1;
    this.connectedag1 = connectedag1;
    onChange_connectedag1_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter connectedag1.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_connectedag1()</code> method instead.
   */
  protected void onChange_connectedag1() {
    onChange_connectedag1_xjal( connectedag1 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_connectedag1_xjal( MyAgent[] oldValue ) {

 
;  
  }


 
  public 
boolean  finished;

  /**
   * Returns default value for parameter <code>finished</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _finished_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
false 
;
  }

  public void set_finished( boolean finished ) {
    if (finished == this.finished) {
      return;
    }
    boolean _oldValue_xjal = this.finished;
    this.finished = finished;
    onChange_finished_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter finished.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_finished()</code> method instead.
   */
  protected void onChange_finished() {
    onChange_finished_xjal( finished );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_finished_xjal( boolean oldValue ) {

 
;  
  }


  /**
   * time of each sensor fire
   */
 
  public 
double  times;

  /**
   * Returns default value for parameter <code>times</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _times_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
time(MINUTE)-1 
;
  }

  public void set_times( double times ) {
    if (times == this.times) {
      return;
    }
    double _oldValue_xjal = this.times;
    this.times = times;
    onChange_times_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter times.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_times()</code> method instead.
   */
  protected void onChange_times() {
    onChange_times_xjal( times );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_times_xjal( double oldValue ) {

 
;  
  }


 
  public 
int  alldoor;

  /**
   * Returns default value for parameter <code>alldoor</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _alldoor_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
0 
;
  }

  public void set_alldoor( int alldoor ) {
    if (alldoor == this.alldoor) {
      return;
    }
    int _oldValue_xjal = this.alldoor;
    this.alldoor = alldoor;
    onChange_alldoor_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter alldoor.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_alldoor()</code> method instead.
   */
  protected void onChange_alldoor() {
    onChange_alldoor_xjal( alldoor );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_alldoor_xjal( int oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire<br>
   * for myagent
   */
 
  public 
double[]  dis_from_fire2;

  /**
   * Returns default value for parameter <code>dis_from_fire2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double[] _dis_from_fire2_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
new double [main.myAgent.size()]//doors + sensors 
;
  }

  public void set_dis_from_fire2( double[] dis_from_fire2 ) {
    if (dis_from_fire2 == this.dis_from_fire2) {
      return;
    }
    double[] _oldValue_xjal = this.dis_from_fire2;
    this.dis_from_fire2 = dis_from_fire2;
    onChange_dis_from_fire2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter dis_from_fire2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_dis_from_fire2()</code> method instead.
   */
  protected void onChange_dis_from_fire2() {
    onChange_dis_from_fire2_xjal( dis_from_fire2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_dis_from_fire2_xjal( double[] oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire<br>
   * for myagent
   */
 
  public 
double[]  time_to_fire;

  /**
   * Returns default value for parameter <code>time_to_fire</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double[] _time_to_fire_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
new double [main.myAgent.size()]//doors + sensors 
;
  }

  public void set_time_to_fire( double[] time_to_fire ) {
    if (time_to_fire == this.time_to_fire) {
      return;
    }
    double[] _oldValue_xjal = this.time_to_fire;
    this.time_to_fire = time_to_fire;
    onChange_time_to_fire_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter time_to_fire.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_time_to_fire()</code> method instead.
   */
  protected void onChange_time_to_fire() {
    onChange_time_to_fire_xjal( time_to_fire );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_time_to_fire_xjal( double[] oldValue ) {

 
;  
  }


 
  public 
ArrayList<TargetLine>  allexits;

  /**
   * Returns default value for parameter <code>allexits</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public ArrayList<TargetLine> _allexits_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
new ArrayList<TargetLine>() 
;
  }

  public void set_allexits( ArrayList<TargetLine> allexits ) {
    if (allexits == this.allexits) {
      return;
    }
    ArrayList<TargetLine> _oldValue_xjal = this.allexits;
    this.allexits = allexits;
    onChange_allexits_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter allexits.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_allexits()</code> method instead.
   */
  protected void onChange_allexits() {
    onChange_allexits_xjal( allexits );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_allexits_xjal( ArrayList<TargetLine> oldValue ) {

 
;  
  }


 
  @AnyLogicCustomProposalType(AnyLogicCustomProposalType.Label.SECOND)
  public 
double  waitTime2;

  /**
   * Returns default value for parameter <code>waitTime2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public double _waitTime2_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
0.01 
;
  }

  public double waitTime2( TimeUnits _units ) {
    return SECOND.convertTo( waitTime2, _units );
  }

  public void set_waitTime2( double waitTime2, TimeUnits _units ) {
    set_waitTime2( _units.convertTo( waitTime2, SECOND ) );
  }

  public void set_waitTime2( double waitTime2 ) {
    if (waitTime2 == this.waitTime2) {
      return;
    }
    double _oldValue_xjal = this.waitTime2;
    this.waitTime2 = waitTime2;
    onChange_waitTime2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter waitTime2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_waitTime2()</code> method instead.
   */
  protected void onChange_waitTime2() {
    onChange_waitTime2_xjal( waitTime2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_waitTime2_xjal( double oldValue ) {

 
;  
  }

  
  /**
   * Internal method. Returns the units used in design-time for setting the code of this parameter (these units may be e.g. used for adaptation of dynamic parameter arguments)
   */
  @AnyLogicInternalCodegenAPI
  public TimeUnits getUnitsForCodeOf_waitTime2() {
    return SECOND;
  }
  
  /**
   * Internal method. Returns the units of this parameter.
   */
  @AnyLogicInternalCodegenAPI
  public TimeUnits getUnitsOf_waitTime2() {
    return SECOND;
  }

 
  public 
int  name;

  /**
   * Returns default value for parameter <code>name</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _name_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
 
;
  }

  public void set_name( int name ) {
    if (name == this.name) {
      return;
    }
    int _oldValue_xjal = this.name;
    this.name = name;
    onChange_name_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter name.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_name()</code> method instead.
   */
  protected void onChange_name() {
    onChange_name_xjal( name );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_name_xjal( int oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire
   */
 
  public 
int  n1;

  /**
   * Returns default value for parameter <code>n1</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _n1_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
//doors + sensors 
;
  }

  public void set_n1( int n1 ) {
    if (n1 == this.n1) {
      return;
    }
    int _oldValue_xjal = this.n1;
    this.n1 = n1;
    onChange_n1_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter n1.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_n1()</code> method instead.
   */
  protected void onChange_n1() {
    onChange_n1_xjal( n1 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_n1_xjal( int oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire
   */
 
  public 
int  n2;

  /**
   * Returns default value for parameter <code>n2</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _n2_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
//doors + sensors 
;
  }

  public void set_n2( int n2 ) {
    if (n2 == this.n2) {
      return;
    }
    int _oldValue_xjal = this.n2;
    this.n2 = n2;
    onChange_n2_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter n2.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_n2()</code> method instead.
   */
  protected void onChange_n2() {
    onChange_n2_xjal( n2 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_n2_xjal( int oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire
   */
 
  public 
int  n3;

  /**
   * Returns default value for parameter <code>n3</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _n3_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
 
;
  }

  public void set_n3( int n3 ) {
    if (n3 == this.n3) {
      return;
    }
    int _oldValue_xjal = this.n3;
    this.n3 = n3;
    onChange_n3_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter n3.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_n3()</code> method instead.
   */
  protected void onChange_n3() {
    onChange_n3_xjal( n3 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_n3_xjal( int oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire
   */
 
  public 
int  n4;

  /**
   * Returns default value for parameter <code>n4</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public int _n4_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
//doors + sensors 
;
  }

  public void set_n4( int n4 ) {
    if (n4 == this.n4) {
      return;
    }
    int _oldValue_xjal = this.n4;
    this.n4 = n4;
    onChange_n4_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter n4.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_n4()</code> method instead.
   */
  protected void onChange_n4() {
    onChange_n4_xjal( n4 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_n4_xjal( int oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire
   */
 
  public 
MyAgent[]  s11;

  /**
   * Returns default value for parameter <code>s11</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public MyAgent[] _s11_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
new MyAgent [10]//doors + sensors 
;
  }

  public void set_s11( MyAgent[] s11 ) {
    if (s11 == this.s11) {
      return;
    }
    MyAgent[] _oldValue_xjal = this.s11;
    this.s11 = s11;
    onChange_s11_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter s11.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_s11()</code> method instead.
   */
  protected void onChange_s11() {
    onChange_s11_xjal( s11 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_s11_xjal( MyAgent[] oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire
   */
 
  public 
MyAgent[]  s12;

  /**
   * Returns default value for parameter <code>s12</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public MyAgent[] _s12_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
new MyAgent [10]//doors + sensors 
;
  }

  public void set_s12( MyAgent[] s12 ) {
    if (s12 == this.s12) {
      return;
    }
    MyAgent[] _oldValue_xjal = this.s12;
    this.s12 = s12;
    onChange_s12_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter s12.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_s12()</code> method instead.
   */
  protected void onChange_s12() {
    onChange_s12_xjal( s12 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_s12_xjal( MyAgent[] oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire
   */
 
  public 
MyAgent[]  s7;

  /**
   * Returns default value for parameter <code>s7</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public MyAgent[] _s7_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
new MyAgent [10]//doors + sensors 
;
  }

  public void set_s7( MyAgent[] s7 ) {
    if (s7 == this.s7) {
      return;
    }
    MyAgent[] _oldValue_xjal = this.s7;
    this.s7 = s7;
    onChange_s7_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter s7.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_s7()</code> method instead.
   */
  protected void onChange_s7() {
    onChange_s7_xjal( s7 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_s7_xjal( MyAgent[] oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire
   */
 
  public 
MyAgent[]  s10;

  /**
   * Returns default value for parameter <code>s10</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public MyAgent[] _s10_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
new MyAgent [10]//doors + sensors 
;
  }

  public void set_s10( MyAgent[] s10 ) {
    if (s10 == this.s10) {
      return;
    }
    MyAgent[] _oldValue_xjal = this.s10;
    this.s10 = s10;
    onChange_s10_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter s10.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_s10()</code> method instead.
   */
  protected void onChange_s10() {
    onChange_s10_xjal( s10 );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_s10_xjal( MyAgent[] oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire
   */
 
  public 
MyAgent[]  current;

  /**
   * Returns default value for parameter <code>current</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public MyAgent[] _current_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
new MyAgent [50]//doors + sensors 
;
  }

  public void set_current( MyAgent[] current ) {
    if (current == this.current) {
      return;
    }
    MyAgent[] _oldValue_xjal = this.current;
    this.current = current;
    onChange_current_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter current.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_current()</code> method instead.
   */
  protected void onChange_current() {
    onChange_current_xjal( current );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_current_xjal( MyAgent[] oldValue ) {

 
;  
  }


  /**
   * //sorted list of sensors with order near to center of fire
   */
 
  public 
boolean  check;

  /**
   * Returns default value for parameter <code>check</code>.
   * <i>This method should not be called by user</i>
   */
  @AnyLogicInternalCodegenAPI
  public boolean _check_DefaultValue_xjal() {
    final MyAgent self = this;
    return 
//doors + sensors 
;
  }

  public void set_check( boolean check ) {
    if (check == this.check) {
      return;
    }
    boolean _oldValue_xjal = this.check;
    this.check = check;
    onChange_check_xjal( _oldValue_xjal );
    onChange();
  }

  /**
   * Calls "On change" action for parameter check.<br>
   * Note that 'oldValue' in that action will be unavailable if this method is called by user
   * (current parameter value will be passed as 'oldValue').<br>
   * Please call <code>set_check()</code> method instead.
   */
  protected void onChange_check() {
    onChange_check_xjal( check );
  }

  @AnyLogicInternalCodegenAPI
  protected void onChange_check_xjal( boolean oldValue ) {

 
;  
  }


  @Override
  public void setParametersToDefaultValues() {
    super.setParametersToDefaultValues();
    exits = _exits_DefaultValue_xjal();
    waitTime1 = _waitTime1_DefaultValue_xjal();
    connectedag1 = _connectedag1_DefaultValue_xjal();
    finished = _finished_DefaultValue_xjal();
    times = _times_DefaultValue_xjal();
    alldoor = _alldoor_DefaultValue_xjal();
    dis_from_fire2 = _dis_from_fire2_DefaultValue_xjal();
    time_to_fire = _time_to_fire_DefaultValue_xjal();
    allexits = _allexits_DefaultValue_xjal();
    waitTime2 = _waitTime2_DefaultValue_xjal();
    name = _name_DefaultValue_xjal();
    n1 = _n1_DefaultValue_xjal();
    n2 = _n2_DefaultValue_xjal();
    n3 = _n3_DefaultValue_xjal();
    n4 = _n4_DefaultValue_xjal();
    s11 = _s11_DefaultValue_xjal();
    s12 = _s12_DefaultValue_xjal();
    s7 = _s7_DefaultValue_xjal();
    s10 = _s10_DefaultValue_xjal();
    current = _current_DefaultValue_xjal();
    check = _check_DefaultValue_xjal();
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
    case "waitTime1":
      if ( _callOnChange_xjal ) {
        set_waitTime1( ((Number) _value_xjal).doubleValue() );
      } else {
        waitTime1 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "connectedag1":
      if ( _callOnChange_xjal ) {
        set_connectedag1( (MyAgent[]) _value_xjal );
      } else {
        connectedag1 = (MyAgent[]) _value_xjal;
      }
      return true;
    case "finished":
      if ( _callOnChange_xjal ) {
        set_finished( (Boolean) _value_xjal );
      } else {
        finished = (Boolean) _value_xjal;
      }
      return true;
    case "times":
      if ( _callOnChange_xjal ) {
        set_times( ((Number) _value_xjal).doubleValue() );
      } else {
        times = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "alldoor":
      if ( _callOnChange_xjal ) {
        set_alldoor( ((Number) _value_xjal).intValue() );
      } else {
        alldoor = ((Number) _value_xjal).intValue();
      }
      return true;
    case "dis_from_fire2":
      if ( _callOnChange_xjal ) {
        set_dis_from_fire2( (double[]) _value_xjal );
      } else {
        dis_from_fire2 = (double[]) _value_xjal;
      }
      return true;
    case "time_to_fire":
      if ( _callOnChange_xjal ) {
        set_time_to_fire( (double[]) _value_xjal );
      } else {
        time_to_fire = (double[]) _value_xjal;
      }
      return true;
    case "allexits":
      if ( _callOnChange_xjal ) {
        set_allexits( (ArrayList<TargetLine>) _value_xjal );
      } else {
        allexits = (ArrayList<TargetLine>) _value_xjal;
      }
      return true;
    case "waitTime2":
      if ( _callOnChange_xjal ) {
        set_waitTime2( ((Number) _value_xjal).doubleValue() );
      } else {
        waitTime2 = ((Number) _value_xjal).doubleValue();
      }
      return true;
    case "name":
      if ( _callOnChange_xjal ) {
        set_name( ((Number) _value_xjal).intValue() );
      } else {
        name = ((Number) _value_xjal).intValue();
      }
      return true;
    case "n1":
      if ( _callOnChange_xjal ) {
        set_n1( ((Number) _value_xjal).intValue() );
      } else {
        n1 = ((Number) _value_xjal).intValue();
      }
      return true;
    case "n2":
      if ( _callOnChange_xjal ) {
        set_n2( ((Number) _value_xjal).intValue() );
      } else {
        n2 = ((Number) _value_xjal).intValue();
      }
      return true;
    case "n3":
      if ( _callOnChange_xjal ) {
        set_n3( ((Number) _value_xjal).intValue() );
      } else {
        n3 = ((Number) _value_xjal).intValue();
      }
      return true;
    case "n4":
      if ( _callOnChange_xjal ) {
        set_n4( ((Number) _value_xjal).intValue() );
      } else {
        n4 = ((Number) _value_xjal).intValue();
      }
      return true;
    case "s11":
      if ( _callOnChange_xjal ) {
        set_s11( (MyAgent[]) _value_xjal );
      } else {
        s11 = (MyAgent[]) _value_xjal;
      }
      return true;
    case "s12":
      if ( _callOnChange_xjal ) {
        set_s12( (MyAgent[]) _value_xjal );
      } else {
        s12 = (MyAgent[]) _value_xjal;
      }
      return true;
    case "s7":
      if ( _callOnChange_xjal ) {
        set_s7( (MyAgent[]) _value_xjal );
      } else {
        s7 = (MyAgent[]) _value_xjal;
      }
      return true;
    case "s10":
      if ( _callOnChange_xjal ) {
        set_s10( (MyAgent[]) _value_xjal );
      } else {
        s10 = (MyAgent[]) _value_xjal;
      }
      return true;
    case "current":
      if ( _callOnChange_xjal ) {
        set_current( (MyAgent[]) _value_xjal );
      } else {
        current = (MyAgent[]) _value_xjal;
      }
      return true;
    case "check":
      if ( _callOnChange_xjal ) {
        set_check( (Boolean) _value_xjal );
      } else {
        check = (Boolean) _value_xjal;
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
    case "waitTime1": _result_xjal = waitTime1; break;
    case "connectedag1": _result_xjal = connectedag1; break;
    case "finished": _result_xjal = finished; break;
    case "times": _result_xjal = times; break;
    case "alldoor": _result_xjal = alldoor; break;
    case "dis_from_fire2": _result_xjal = dis_from_fire2; break;
    case "time_to_fire": _result_xjal = time_to_fire; break;
    case "allexits": _result_xjal = allexits; break;
    case "waitTime2": _result_xjal = waitTime2; break;
    case "name": _result_xjal = name; break;
    case "n1": _result_xjal = n1; break;
    case "n2": _result_xjal = n2; break;
    case "n3": _result_xjal = n3; break;
    case "n4": _result_xjal = n4; break;
    case "s11": _result_xjal = s11; break;
    case "s12": _result_xjal = s12; break;
    case "s7": _result_xjal = s7; break;
    case "s10": _result_xjal = s10; break;
    case "current": _result_xjal = current; break;
    case "check": _result_xjal = check; break;
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
      list.add( "waitTime1" );
      list.add( "connectedag1" );
      list.add( "finished" );
      list.add( "times" );
      list.add( "alldoor" );
      list.add( "dis_from_fire2" );
      list.add( "time_to_fire" );
      list.add( "allexits" );
      list.add( "waitTime2" );
      list.add( "name" );
      list.add( "n1" );
      list.add( "n2" );
      list.add( "n3" );
      list.add( "n4" );
      list.add( "s11" );
      list.add( "s12" );
      list.add( "s7" );
      list.add( "s10" );
      list.add( "current" );
      list.add( "check" );
      result = list.toArray( new String[ list.size() ] );
      _parameterNames_xjal = result;
    }
    return result;
  }
  // Plain Variables

 
  public 
int 
 ind;
 
  public 
int 
 indx;
 
  public 
int 
 floor_num;
 
  public 
int 
 indxof_firstotherfloor;
 
  public 
int 
 indd;
 
  public 
int 
 counter;
  @AnyLogicInternalCodegenAPI
  private static Map<String, IElementDescriptor> elementDesciptors_xjal = createElementDescriptors( MyAgent.class );
  
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


  // Events

  public EventTimeout check_dead = new EventTimeout(this);

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( EventTimeout _e ) {
     if( _e == check_dead ) return "check_dead";
    return super.getNameOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public EventTimeout.Mode getModeOf( EventTimeout _e ) {
    if ( _e == check_dead ) return EVENT_TIMEOUT_MODE_CYCLIC;
    return super.getModeOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double getFirstOccurrenceTime( EventTimeout _e ) {
    double _t;
    if ( _e == check_dead ) {
      _t = 
60 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    return super.getFirstOccurrenceTime( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf( EventTimeout _e ) {
    double _t;
    if( _e == check_dead) {
      _t = 
1 
;
      _t = toModelTime( _t, SECOND );
      return _t;
    }
    return super.evaluateTimeoutOf( _e );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( EventTimeout _e ) {
    if ( _e == check_dead ) {
      EventTimeout self = _e;

//getClosestperson2();
//main.oval12.setPos(fire.getX()+40, ag.getY()+150);



if(main.alarm){

getClosestperson2();



//getClosestperson3(main.fire_center);


//}//if floor1
///////////////// for main dynamic route changes

if(main.active_dynamic) 
	for(int i=0;main.connectedag2[i]!=null;i++)//connecage2=== red sensors
	
	{
 		if( main.area1_2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.a1==false)
 		{main.a1=true;
 		for(Visitor ped : main.visitor)
 			 if(ped.inState(Visitor.alive)&&(ped.route==main.ex1 || ped.route==main.office))
 			{
 			//ped.changed_Route1=true;
			//main.evacuation.pedGoToExit1.cancel(ped);
			main.evacuation.pedGoToExit.cancel(ped);
			main.evacuation.pedGoToExit4.cancel(ped);
			if( ( (main.static_withdoor_sensor && (main.line20.getColor()==red || main.line21.getColor()==red) ) ||( main.active_dynamic && (( main.a1 && main.a2)||(!main.a1 && main.a2 && main.a4)) ) || (main.active_dynamic && main.a3) ||( isHelper(ped) && main.evacuation.helper_targetline[main.evacuation.helper.indexOf(ped)].getGround()==main.secondGround ) || ( ped.getColor()==green && main.evacuation.helper_targetline[indexOf(main.evacuation.helpee, ped)].getGround()==main.secondGround )) || (main.active_dynamic && main.coffee.contains(ped.getX(), ped.getY()) && main.a3_4==true && !(isHelper(ped)) &&!(ped.getColor()==green)) || !(main.active_dynamic==true) )
			main.evacuation.pedChangeGround.cancel(ped);
 			
 			}}
 
 		
 		if( main.area1_1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.a1_1==false)
 		main.a1_1=true;
 		
 		
 		if( main.area3.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.a3==false)
 		 {main.a3=true;
 			for(Visitor ped : main.visitor)
 			 if(ped.inState(Visitor.alive))
 			{
 			//ped.changed_Route1=true;
			//main.evacuation.pedGoToExit1.cancel(ped);
			//main.evacuation.pedGoToExit.cancel(ped);
			//main.evacuation.pedGoToExit4.cancel(ped);
				if( ( (main.static_withdoor_sensor && (main.line20.getColor()==red || main.line21.getColor()==red) ) ||( main.active_dynamic && (( main.a1 && main.a2)||(!main.a1 && main.a2 && main.a4)) ) || (main.active_dynamic && main.a3) ||( isHelper(ped) && main.evacuation.helper_targetline[main.evacuation.helper.indexOf(ped)].getGround()==main.secondGround ) || ( ped.getColor()==green && main.evacuation.helper_targetline[indexOf(main.evacuation.helpee, ped)].getGround()==main.secondGround )) || (main.active_dynamic && main.coffee.contains(ped.getX(), ped.getY()) && main.a3_4==true && !(isHelper(ped)) &&!(ped.getColor()==green)) || !(main.active_dynamic==true) )
			main.evacuation.pedChangeGround.cancel(ped);
 			
 			}}
 		 
 		 
 		 if (main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.a2==false )
 		  {main.a2=true;
 			for(Visitor ped : main.visitor)
 			 if(ped.inState(Visitor.alive)&&(ped.route==main.ex2 || ped.route==main.office1))
 			{
 			//ped.changed_Route1=true;
			main.evacuation.pedGoToExit1.cancel(ped);
			//main.evacuation.pedGoToExit.cancel(ped);
			main.evacuation.pedGoToExit4.cancel(ped);
				if( ( (main.static_withdoor_sensor && (main.line20.getColor()==red || main.line21.getColor()==red) ) ||( main.active_dynamic && (( main.a1 && main.a2)||(!main.a1 && main.a2 && main.a4)) ) || (main.active_dynamic && main.a3) ||( isHelper(ped) && main.evacuation.helper_targetline[main.evacuation.helper.indexOf(ped)].getGround()==main.secondGround ) || ( ped.getColor()==green && main.evacuation.helper_targetline[indexOf(main.evacuation.helpee, ped)].getGround()==main.secondGround )) || (main.active_dynamic && main.coffee.contains(ped.getX(), ped.getY()) && main.a3_4==true && !(isHelper(ped)) &&!(ped.getColor()==green)) || !(main.active_dynamic==true) )
		main.evacuation.pedChangeGround.cancel(ped);
 			
 			}}
 		 
 		  
 		  
 		  if (main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.a4==false   )
 		 {main.a4=true;
 			for(Visitor ped : main.visitor)
 			 if(ped.inState(Visitor.alive))
 			{
 			//ped.changed_Route1=true;
			main.evacuation.pedGoToExit1.cancel(ped);
			main.evacuation.pedGoToExit.cancel(ped);
			main.evacuation.pedGoToExit4.cancel(ped);
				if( ( (main.static_withdoor_sensor && (main.line20.getColor()==red || main.line21.getColor()==red) ) ||( main.active_dynamic && (( main.a1 && main.a2)||(!main.a1 && main.a2 && main.a4)) ) || (main.active_dynamic && main.a3) ||( isHelper(ped) && main.evacuation.helper_targetline[main.evacuation.helper.indexOf(ped)].getGround()==main.secondGround ) || ( ped.getColor()==green && main.evacuation.helper_targetline[indexOf(main.evacuation.helpee, ped)].getGround()==main.secondGround )) || (main.active_dynamic && main.coffee.contains(ped.getX(), ped.getY()) && main.a3_4==true && !(isHelper(ped)) &&!(ped.getColor()==green)) || !(main.active_dynamic==true) )
		main.evacuation.pedChangeGround.cancel(ped);
 			
 			}}
 			
 			if (main.s3_2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.as3_2==false   )
 		 {main.as3_2=true;
 			for(Visitor ped : main.visitor)
 			 if(ped.inState(Visitor.alive)&&(ped.route==main.office))
 			{
 			//ped.changed_Route1=true;
			main.evacuation.pedGoToExit1.cancel(ped);
			main.evacuation.pedGoToExit.cancel(ped);
			main.evacuation.pedGoToExit4.cancel(ped);
			//main.evacuation.pedChangeGround.cancel(ped);
 			
 			}}
 			
 				if (main.s1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.as1==false   )
 		 {main.as1=true;
 			for(Visitor ped : main.visitor)
 			 if(ped.inState(Visitor.alive)&&( ped.route==main.office1))
 			{
 			//ped.changed_Route1=true;
			main.evacuation.pedGoToExit1.cancel(ped);
			main.evacuation.pedGoToExit.cancel(ped);
			main.evacuation.pedGoToExit4.cancel(ped);
			//main.evacuation.pedChangeGround.cancel(ped);
 			
 			}}
 			
 			
 			if (main.area3_4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.a3_4==false   )
 		 {main.a3_4=true;
 			for(Visitor ped : main.visitor)
 			 if(ped.inState(Visitor.alive) && ped.getGround()==main.secondGround)
 			{
 			//ped.changed_Route1=true;
			
			main.evacuation.pedChangeGround.cancel(ped);
 			
 			}}
 			
 			
 				if (main.area3_2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) && main.a3_2==false   )
 		 {main.a3_2=true;
 			for(Visitor ped : main.visitor)
 			 if(ped.inState(Visitor.alive) && ped.getGround()==main.secondGround)
 			{
 			//ped.changed_Route1=true;
			
			main.evacuation.pedChangeGround.cancel(ped);
 			
 			}}
 			
 			
 			}//for
///////////////// for main dynamic route changes


 if(main.finish==true){
 
 finished=true;
 }
if(main.dead==main.evacuation.peopleinside)
main.finish=true;


if(main.explosion==false)
{main.firealarmfunc();
main.explosion=true;
}

}//alarm

 
;
      return;
    }
    super.executeActionOf( _e );
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
      enterState( Normal, true );
      return;
    }
    super.executeActionOf( _s );
  }

   // States of all statecharts
   
  public enum statechart_state implements IStatechartState<MyAgent, statechart_state> {
    Normal,
    Burning,
    burneddoor,
    doors,
    finalState;

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
    public Statechart<statechart_state> getStatechart( MyAgent _a ) {
      return _a.statechart;
    }
  }
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final statechart_state Normal = statechart_state.Normal;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final statechart_state Burning = statechart_state.Burning;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final statechart_state burneddoor = statechart_state.burneddoor;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final statechart_state doors = statechart_state.doors;
  @AnyLogicCustomProposalPriority(type = AnyLogicCustomProposalPriority.Type.STATIC_ELEMENT)
  public static final statechart_state finalState = statechart_state.finalState;


  @AnyLogicInternalCodegenAPI
  private void enterState( statechart_state _state, boolean _destination ) {
    switch( _state ) {
      case Normal:
  	    logToDBEnterState(statechart, _state);
        // (Simple state (not composite))
        statechart.setActiveState_xjal( Normal );
        {
 
;}
        Ignition.start();
        return;
      case Burning:
  	    logToDBEnterState(statechart, _state);
        // (Simple state (not composite))
        statechart.setActiveState_xjal( Burning );
        {


current[indd]=main.fire_center;
main.fire_center.oval.setFillColor(red);
main.fire_center.check=true;
indd++;
main.connectedag2[ind]=main.fire_center;
ind++;
waitTime1= (double)toLengthUnits(getDistance(current[indd-1].getX(), current[indd-1].getY(), main.myAgent.get(current[indd-1].n1).getX(), main.myAgent.get(current[indd-1].n1).getY()), METER) / (double)main.fire_speed;

for(MyAgent agg: main.myAgent)
	if(main.oval12.contains(agg.getX()+40,agg.getY()+150))
	{
	int i=get_area_sensor(agg);
	 int j=get_area_sensor(main.fire_center);
	 if(get_equality_area(i,j)==true && agg.check==false)
	{
		agg.oval.setFillColor(red);
		main.connectedag2[ind]=agg;
		ind++;
		agg.check=true;
		current[indd]=agg;
		indd++;
	}
	}
///



 
;}
        go.start();
        return;
      case burneddoor:
  	    logToDBEnterState(statechart, _state);
        // (Simple state (not composite))
        statechart.setActiveState_xjal( burneddoor );
        {



MyAgent ag= main.fire_center;
for (Visitor e : main.visitor  ){
 //for (Visitor e : agentsInRange(main.visitor,scale.toPixels(2,METER))  ){
  if(e!=null)
  if( get_agent_Grnd(ag)==e.getGround()&& get_area_visitor(e)==get_area_sensor(ag) && !(e.inState(Visitor.dead))){

	if(main.oval12.contains( e.getX(),  e.getY()))
	{
	
	
	
	if( !isHelper(e) && e.getColor()!=green ){
	e.ped_infire=true;
	
	if(getDistance(e.getX(),  e.getY(),main.oval12.getX(),main.oval12.getY())<50)
	e.dead_time=uniform(2, 4);
	else if(getDistance(e.getX(),  e.getY(), main.oval12.getX(),main.oval12.getY())<100)
	e.dead_time=uniform(4, 6);
	else
	e.dead_time=8;

	
	main.evacuation.pedGoToExit.cancel(e);
	main.evacuation.pedGoToExit1.cancel(e);
	main.evacuation.pedGoToExit2.cancel(e);
	main.evacuation.pedGoToExit4.cancel(e);
	main.evacuation.pedWindowWait.cancel(e);
	//main.evacuation.pedLongWait.free(e);
	main.evacuation.pedLongWait.cancel(e);
	if( (( main.static_withdoor_sensor && (main.line20.getColor()==red || main.line21.getColor()==red) ) ||( main.active_dynamic && (( main.a1 && main.a2)||(!main.a1 && main.a2 && main.a4)) ) || (main.active_dynamic && main.a3) ||( isHelper(e) && main.evacuation.helper_targetline[main.evacuation.helper.indexOf(e)].getGround()==main.secondGround ) || ( e.getColor()==green && main.evacuation.helper_targetline[indexOf(main.evacuation.helpee, e)].getGround()==main.secondGround )) || (main.active_dynamic && main.coffee.contains(e.getX(), e.getY()) && main.a3_4==true && !(isHelper(e)) &&!(e.getColor()==green) ) || !(main.active_dynamic==true)   )
	main.evacuation.pedChangeGround.cancel(e);
	main.evacuation.pedChangeGround2.cancel(e);
	}//not helper...
	else if(e.getComfortableSpeed(MPS)>0.5)
	e.setComfortableSpeed(e.getComfortableSpeed(MPS)/2, MPS);

	}//containsss
	
	else//not contains in fire
	e.setComfortableSpeed(uniform(0.54, 0.8), MPS);
	
		
	}//not dead
 

	}













for(MyAgent agg: main.myAgent)
	if(main.oval12.contains(agg.getX()+40,agg.getY()+150))
	{
	int i=get_area_sensor(agg);
	 int j=get_area_sensor(main.fire_center);
	 if(get_equality_area(i,j)==true && agg.check==false)
	{
		agg.oval.setFillColor(red);
		main.connectedag2[ind]=agg;
		ind++;
		agg.check=true;
		current[indd]=agg;
		indd++;
	}
	}//if1












//ind=indexOfMin(time_to_fire);
//main.radius=8;
//if(ind<main.myAgent.size()-1&& finished==false){

/*if(time_to_fire[ind]!=Double.POSITIVE_INFINITY&& finished==false){
	
	waitTime2=0.02;// in normal case
	main.now_time=time_to_fire[ind];
	if(time_to_fire[ind]==time_to_fire[ind+1])
	{
	connectedag1[ind].oval.setFillColor(red);
	
	connectedag1[ind+1].oval.setFillColor(red);
	main.connectedag2[ind]=connectedag1[ind];
	main.connectedag2[ind+1]=connectedag1[ind+1];
	//getClosestperson3(main.connectedag2[ind]);
	//getClosestperson3(main.connectedag2[ind+1]);
	
	//main.connectedag2[ind+1].sendToAllConnected("Crashed");
	
	time_to_fire[ind]=Double.POSITIVE_INFINITY;
	time_to_fire[ind+1]=Double.POSITIVE_INFINITY;
	ind=ind+2;
	
	
	}
	else{
	connectedag1[ind].oval.setFillColor(red);
	main.connectedag2[ind]=connectedag1[ind];
	//getClosestperson2();
	//getClosestperson3(main.connectedag2[ind]);
	time_to_fire[ind]=Double.POSITIVE_INFINITY;
	ind=ind+1;
	
		}
//explosion=false;		
waitTime1=time_to_fire[ind]-main.now_time;
	
//					
		}//if
*/


//for all in ground 2
if((main.line20.getColor()!=red &&main.myAgent.get(0).oval.getFillColor()==red )|| (main.line21.getColor()!=red &&main.myAgent.get(9).oval.getFillColor()==red))
 {	
 if(main.myAgent.get(0).oval.getFillColor()==red)//floor1 is burning to floor 2
 	{
 	main.oval13.setPos(main.myAgent.get(9).getX()+40, main.myAgent.get(9).getY()+150);
 	//main.myAgent.get(9).oval.setf
 	main.radius2=1;
 //	main.floor_num_main=2;
 	}
 else{
 	main.oval13.setPos(main.myAgent.get(0).getX()+40, main.myAgent.get(0).getY()+150);
 	main.radius2=1;
 	// main.floor_num_main=1;
 }	
 	
 	main.line20.setColor(red);
	main.line21.setColor(red);
	
if(main.static_withdoor_sensor)
	{
	for(Visitor ped : main.visitor)
			if(ped.inState(Visitor.alive))
			{ // all who wants to change ground => helper
		
				ped.changed_Route1=true;
				main.evacuation.pedChangeGround.cancel(ped);
			}			
		}
	
	/*
if(main.dynamic_help){
 		for(Visitor ped : main.visitor)
			if(ped.inState(Visitor.alive))
			{ // all who wants to change ground => helper
		
				ped.changed_Route1=true;
				main.evacuation.pedGoToStairs.cancelAll();
				main.evacuation.helpgotoped.cancelAll();
		
				main.evacuation.pedChangeGround1.cancelAll();
			}//if
						 
 
	}//if dynamic*/
 }
/*
if((main.line20.getColor()==red || main.line21.getColor()==red) && main.dynamic_help )

	for(Visitor ped : main.visitor)
			if(ped.inState(Visitor.alive))
			{ // all who wants to change ground => helper
		
				ped.changed_Route1=true;
				main.evacuation.pedGoToStairs.cancelAll();
				main.evacuation.helpgotoped.cancelAll();
		//main.evacuation.helpgotoped1.cancelAll();
				main.evacuation.pedChangeGround1.cancelAll();
			}
 
 */

//dooooooooooooooooooooors
if(main.myAgent.get(4).oval.getFillColor()==red &&main.line30.getColor()!=red)
{
main.line30.setColor(red);
alldoor++;
main.evacuation.exits.get(1).setColor(red);
for(Visitor ped : main.visitor)
		if(alldoor!=2 &&ped.inState(Visitor.alive) )
////@@ Dynamic:routechanged=true
			if(main.static_withdoor_sensor ){
			ped.changed_Route1=true;
			main.evacuation.pedGoToExit1.cancel(ped);
			main.evacuation.pedGoToExit.cancel(ped);}
				//if
}
//}


//if(main.connectedag2[ind-1]==main.myAgent.get(188)&&main.enter.getColor()!=red)
if(main.myAgent.get(49).oval.getFillColor()==red &&main.enter.getColor()!=red)

{
main.enter.setColor(red);
main.evacuation.exits.get(0).setColor(red);
alldoor++;

for(Visitor ped : main.visitor)
		if(alldoor!=2 &&ped.inState(Visitor.alive) )
////@@ Dynamic:routechanged=true
			if(main.static_withdoor_sensor ){
			ped.changed_Route1=true;
			main.evacuation.pedGoToExit1.cancel(ped);
			main.evacuation.pedGoToExit.cancel(ped);}


}
/*
if(alldoor==2)
{
for(Visitor ped : main.visitor)
ped.ped_infire=true;
main.evacuation.cancelall();
finished=true;
}
*/
//getClosestdoor();


 
 

 
//check for dynamic desician 





///////////////// for main dynamic route changes

 if(main.finish==true){
 
 finished=true;
 }
 


 
;}
        transition4.start();
        transition3.start();
        return;
      case doors:
  	    logToDBEnterState(statechart, _state);
        // (Simple state (not composite))
        statechart.setActiveState_xjal( doors );
        {


main.radius+=1;
// main.oval13.setPos(main.myAgent.get(17).getX()+40, main.myAgent.get(17).getY()+150);
 	
 if(main.oval13.getX()==main.myAgent.get(9).getX()+40||main.oval13.getX()==main.myAgent.get(0).getX()+40 )
 main.radius2+=1;

int old_index=indd;
for(int i=counter;i<old_index;i++)
	{ 
	if(current[i]!=null )
		{ //check 3 neighbors of each sensor
		//if(arrayContains(main.floor1_agents, current[i]))
		for(MyAgent ag: main.myAgent)
		
		{
		if(ag!=null&&ag.oval.getFillColor()!=red)
		{ 
				if(main.myAgent.get(current[i].n1).check==false && main.myAgent.get(current[i].n1)==ag)
					{
					ag.oval.setFillColor(red);
					main.connectedag2[ind]=ag;
					ind++;
					ag.check=true;
					current[indd]=ag;
					indd++;
					}
					
				else if(current[i].n2!=-1)
				 if(main.myAgent.get(current[i].n2).check==false &&main.myAgent.get(current[i].n2)==ag)	
					{
					ag.oval.setFillColor(red);
					main.connectedag2[ind]=ag;
					ind++;
					ag.check=true;
					current[indd]=ag;
					indd++;
					}
					
				else if(current[i].n3!=-1)
				 if(main.myAgent.get(current[i].n3).check==false &&main.myAgent.get(current[i].n3)==ag)
					{
					ag.oval.setFillColor(red);
					main.connectedag2[ind]=ag;
					ind++;
					ag.check=true;
					current[indd]=ag;
					indd++;
					}
					
					
				else if(current[i].n4!=-1)
				 if(main.myAgent.get(current[i].n4).check==false &&main.myAgent.get(current[i].n4)==ag)
					{
					ag.oval.setFillColor(red);
					main.connectedag2[ind]=ag;
					ind++;
					ag.check=true;
					current[indd]=ag;
					indd++;
					}
					
			}//if agent in oval
			
	//if(arrayContains(main.floor2_agents, current[i]))	
	//for(MyAgent ag: main.floor2_agents)

		
		}//for myagent
		
		
		
	}//for2
		}//if3


waitTime1= (double)toLengthUnits(getDistance(current[indd-1].getX(), current[indd-1].getY(), main.myAgent.get(current[indd-1].n1).getX(), main.myAgent.get(current[indd-1].n1).getY()), METER) / (double)main.fire_speed;

counter=old_index;


















//if(ind>=2){
//if(main.connectedag2[ind-2]==main.myAgent.get(0)&&main.line30.getColor()!=red)

/*if(main.myAgent.get(8).oval.getFillColor()==red &&main.line30.getColor()!=red)
{
main.line30.setColor(red);
alldoor++;
main.evacuation.exits.get(1).setColor(red);
for(Visitor ped : main.visitor)
		if(alldoor!=2 &&ped.inState(Visitor.alive) )
////@@ Dynamic:routechanged=true
			if(main.static_withdoor_sensor ){
			ped.changed_Route1=true;
			main.evacuation.pedGoToExit1.cancel(ped);
			main.evacuation.pedGoToExit.cancel(ped);}
				//if
}
//}


//if(main.connectedag2[ind-1]==main.myAgent.get(188)&&main.enter.getColor()!=red)
if(main.myAgent.get(188).oval.getFillColor()==red &&main.enter.getColor()!=red)

{
main.enter.setColor(red);
main.evacuation.exits.get(0).setColor(red);
alldoor++;

for(Visitor ped : main.visitor)
		if(alldoor!=2 &&ped.inState(Visitor.alive) )
////@@ Dynamic:routechanged=true
			if(main.static_withdoor_sensor ){
			ped.changed_Route1=true;
			main.evacuation.pedGoToExit1.cancel(ped);
			main.evacuation.pedGoToExit.cancel(ped);}


}

//getClosestdoor();


 
 
 if(main.finish==true){
 
 finished=true;
 }
 
 
main.radius+=1;
// main.oval13.setPos(main.myAgent.get(17).getX()+40, main.myAgent.get(17).getY()+150);
 	
 if(main.oval13.getX()==main.myAgent.get(17).getX()+40||main.oval13.getX()==main.myAgent.get(8).getX()+40 )
 main.radius2+=1;
 
//check for dynamic desician 
if(main.active_dynamic)
	for(int i=0;main.connectedag2[i]!=null;i++)//connecage2=== red sensors
 		if( main.area1.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)||main.area3.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) || main.area2.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150) || main.area4.contains(main.connectedag2[i].getX()+40,main.connectedag2[i].getY()+150)   )
 			
 			for(Visitor ped : main.visitor)
 			 if(ped.inState(Visitor.alive))
 			{
 			ped.changed_Route1=true;
			main.evacuation.pedGoToExit1.cancel(ped);
			main.evacuation.pedGoToExit.cancel(ped);
			main.evacuation.pedGoToExit4.cancel(ped);
			main.evacuation.pedChangeGround.cancel(ped);
 			
 			}
 */
 /*
if(alldoor==2)
{
for(Visitor ped : main.visitor)
ped.ped_infire=true;
main.evacuation.cancelall();
finished=true;
}
*/ 
;}
        transition1.start();
        transition2.start();
        return;
      case finalState:
  	    logToDBEnterState(statechart, _state);
        // (Final State)
        {
check_dead.suspend();
main.finish1=true;
main.evacuation.pedLongWait.cancelAll();
main.evacuation.cancelall(); 
;}
        statechart.setActiveState_xjal( finalState );
        statechart.onDestroy();
        return;
      default:
        return;
    }
  }

  @AnyLogicInternalCodegenAPI
  private void exitState( statechart_state _state, Transition _t, boolean _source ) {
    switch( _state ) {
      case Normal: 
  	    logToDBExitState(statechart, _state);
  	    logToDB(statechart, _t, _state);
      // (Simple state (not composite))
        if ( !_source || _t != Ignition) Ignition.cancel();
        {
 
;}
        return;
      case Burning: 
  	    logToDBExitState(statechart, _state);
  	    logToDB(statechart, _t, _state);
      // (Simple state (not composite))
        if ( !_source || _t != go) go.cancel();
        {
 
;}
        return;
      case burneddoor: 
  	    logToDBExitState(statechart, _state);
  	    logToDB(statechart, _t, _state);
      // (Simple state (not composite))
        if ( !_source || _t != transition4) transition4.cancel();
        if ( !_source || _t != transition3) transition3.cancel();
        {

 
;}
        return;
      case doors: 
  	    logToDBExitState(statechart, _state);
  	    logToDB(statechart, _t, _state);
      // (Simple state (not composite))
        if ( !_source || _t != transition1) transition1.cancel();
        if ( !_source || _t != transition2) transition2.cancel();
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
  
  public TransitionTimeout go = new TransitionTimeout( this );
  public TransitionTimeout transition4 = new TransitionTimeout( this );
  public TransitionTimeout transition1 = new TransitionTimeout( this );

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( TransitionTimeout _t ) {
    if ( _t == go ) return "go";
    if ( _t == transition4 ) return "transition4";
    if ( _t == transition1 ) return "transition1";
    return super.getNameOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Statechart getStatechartOf( TransitionTimeout _t ) { 
    if ( _t == go ) return statechart;
    if ( _t == transition4 ) return statechart;
    if ( _t == transition1 ) return statechart;
    return super.getStatechartOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean testGuardOf( TransitionTimeout _t ) {
    if ( _t == go ) return 
 
;
    if ( _t == transition4 ) return 
 
;
    if ( _t == transition1 ) return 
 
;
    return super.testGuardOf(  _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( TransitionTimeout _t ) {
    if ( _t == go ) {
      exitState( Burning, _t, true );
      {
 
;}
          enterState( burneddoor, true );
      return;
    }
    if ( _t == transition4 ) {
      exitState( burneddoor, _t, true );
      {
 
;}
          enterState( doors, true );
      return;
    }
    if ( _t == transition1 ) {
      exitState( doors, _t, true );
      {
//getClosestperson2() 
;}
          enterState( burneddoor, true );
      return;
    }
    super.executeActionOf( _t );
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public double evaluateTimeoutOf( TransitionTimeout _t ) {
    double _value;
    if ( _t == go ) {
      _value = 
0 
;
      _value = toModelTime( _value, SECOND );
      return _value;
    }
    if ( _t == transition4 ) {
      _value = 
waitTime1
 
;
      _value = toModelTime( _value, SECOND );
      return _value;
    }
    if ( _t == transition1 ) {
      _value = 
1 
;
      _value = toModelTime( _value, SECOND );
      return _value;
    }
    return super.evaluateTimeoutOf( _t );
  }

  public TransitionCondition transition2 = new TransitionCondition( this );
  public TransitionCondition transition3 = new TransitionCondition( this );

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( TransitionCondition _t ) {
    if ( _t == transition2 ) return "transition2";
    if ( _t == transition3 ) return "transition3";
    return super.getNameOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Statechart getStatechartOf( TransitionCondition _t ) { 
    if ( _t == transition2 ) return statechart;
    if ( _t == transition3 ) return statechart;
    return super.getStatechartOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean testGuardOf( TransitionCondition _t ) {
    if ( _t == transition2 ) return 
 
;
    if ( _t == transition3 ) return 
 
;
    return super.testGuardOf(  _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( TransitionCondition _t ) {
    if ( _t == transition2 ) {
      exitState( doors, _t, true );
      {
 
;}
          enterState( finalState, true );
      return;
    }
    if ( _t == transition3 ) {
      exitState( burneddoor, _t, true );
      {
 
;}
          enterState( finalState, true );
      return;
    }
    super.executeActionOf( _t );
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public boolean testConditionOf( TransitionCondition _t ) {
    if ( _t == transition2 ) return 
finished 
;
    if ( _t == transition3 ) return 
finished 
;
    return super.testConditionOf( _t );
  }


  public TransitionMessage Ignition = new TransitionMessage( this );

  @Override
  @AnyLogicInternalCodegenAPI
  public String getNameOf( TransitionMessage _t ) {
    if ( _t == Ignition ) return "Ignition";
    return super.getNameOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public Statechart getStatechartOf( TransitionMessage _t ) { 
    if ( _t == Ignition ) return statechart;
    return super.getStatechartOf( _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean testGuardOf( TransitionMessage _t ) {
    if ( _t == Ignition ) return 
 
;
    return super.testGuardOf(  _t );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public void executeActionOf( TransitionMessage _t, Object _msg ) {
    if ( _t == Ignition ) {
      exitState( Normal, _t, true );
      {
        String msg = (String) _msg;
 
;}
          enterState( Burning, true );
      return;
    }
    super.executeActionOf( _t, _msg );
  }
  @Override
  @AnyLogicInternalCodegenAPI
  public boolean testMessageOf( TransitionMessage _t, Object _msg ) {
    if ( _t == Ignition ) {
      if ( !(_msg instanceof String) )
        return false;
      
String 
msg = (String) _msg;
      Object _g = 
"Ignition" 
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

  // Functions

 
  
TargetLine 
 getsafestExit( MyAgent ag ) { 

//@ predicted dynamic
//returns farest exit from selected sensor
TargetLine result = null;
/*double dst=0 ;
TargetLine result = null;
for (TargetLine e : exits)
	if(getDistance(ag.getX(),ag.getY(), e.getX(), e.getY())>dst)
	{result = e;
	dst = getDistance(ag.getX(),ag.getY(), e.getX(), e.getY());
}*/

if(getDistance(ag.getX()+40,ag.getY()+150, main.line30.getX(), main.line30.getY())>getDistance(ag.getX()+40,ag.getY()+150, main.enter.getX(), main.enter.getY()))
result=main.line30;
else
result=main.enter;

return result; 
  }

  /**
   * inputs: ag = center of fire<br>
   * agent_array= arrays of agent to compute distance => floor 1 or floor 2
   */
 
  
MyAgent 
 getClosestagent( MyAgent ag, MyAgent [ ] agent_array ) { 

double dst = Double.POSITIVE_INFINITY;
MyAgent result = null;

for (MyAgent e : agent_array)
 if( e!=null&& e.getColor()!=blue ){
	if (getDistance(ag.getX(),ag.getY(), e.getX(), e.getY())< dst){
	result = e;
	dst = getDistance(ag.getX(),ag.getY(), e.getX(), e.getY());
	
}}
main.dis_from_fire[indx]=toLengthUnits(dst, METER);
dis_from_fire2[indx]=toLengthUnits(dst, METER);
time_to_fire[indx]=toLengthUnits(dst, METER)/main.fire_speed;
indx++;
return result;


//from indx=0 to indx = floor(i).size-1 for first fired floor
//from indx = floor(i).size to floor(i+1).size -1 for rest
//after one loop index =  floor(i).size
 
  }

 
  public 
String 
 toString(  ) { 

return
	"ind = " + ind + "\n" +
	"waitTime1 = " + waitTime1 + "\n" +
	"exits = " + exits + "\n" +
	//"connectedag = " + connectedag + "\n" +
	//"indx = " + indx + "\n" +
	"connectedag1 = " + connectedag1 + "\n" +
	"finished = " + finished; 
  }

 
  void getClosestdoor(  ) { 



//for(MyAgent ag:main.myAgent){

if(main.line20.getColor()!=red &&main.myAgent.get(8).oval.getFillColor()==red )
 main.line20.setColor(red);
if(main.line21.getColor()!=red &&main.myAgent.get(17).oval.getFillColor()==red )
 main.line21.setColor(red);
 	
	/*for(int i=0;main.connectedag2[i]!=null;i++)
	{ MyAgent ag=main.connectedag2[i];
	//ag.get
	double distance=getDistance(ag.getX(),ag.getY(), e.getX(), e.getY());
	if (distance< dst){
//@@@nfor dynamic inform second ground burning	
		e.setColor(red);
						}//if3 dst
	}*///for
	//}//if2
//for1

 
  }

  /**
   * death time:<br>
   * fire speed=1.3m/min <br>
   * 1-3min time to death after reach fire<br>
   * distance to fire center <3m =>  3m/1.3=2.5 <br>
   * 0m=> at least 1-3min <br>
   * => 2.5 +(1-3) = 5 =======> 2-5<br>
   * <br>
   * 3<<5 for 3 is 5min at least and for 5 is<br>
   * 5/1.3=3.8=4 => 4+(1-3) = 7<br>
   * <br>
   * 5<<10=>
   */
 
  void getClosestperson2(  ) { 

double dst = 80.0;
Ground grnd;

for(int i=0;main.connectedag2[i]!=null;i++)
{ MyAgent ag=main.connectedag2[i];
  grnd=get_agent_Grnd(ag);

 main.oval14.setPos(ag.getX()+40, ag.getY()+150);
 for (Visitor e : main.visitor  ){
 //for (Visitor e : agentsInRange(main.visitor,scale.toPixels(2,METER))  ){
  if(e!=null)
  if( e.getGround()== grnd && get_area_visitor(e)==get_area_sensor(ag) && !(e.inState(Visitor.dead))){

	if(main.oval14.contains( e.getX(),  e.getY()))
	{
	
		if( !isHelper(e) && e.getColor()!=green ){
		
			e.ped_infire=true;
			double dis= getDistance(e.getX(),  e.getY(), main.oval14.getX(),main.oval14.getY());
			double tt=(double)toLengthUnits(dis, METER)/(double)main.fire_speed;
			tt=(double)tt/(double)60;
			//e.dead_time=uniform(1, 3)+ tt;
			e.dead_time= tt+1;
			//e.dead_time+= 2;
			main.evacuation.pedGoToExit.cancel(e);
			main.evacuation.pedGoToExit1.cancel(e);
			main.evacuation.pedGoToExit2.cancel(e);
			main.evacuation.pedGoToExit4.cancel(e);
			main.evacuation.pedWindowWait.cancel(e);
			main.evacuation.pedLongWait.cancel(e);
			if( (( main.static_withdoor_sensor && (main.line20.getColor()==red || main.line21.getColor()==red) ) ||( main.active_dynamic && (( main.a1 && main.a2)||(!main.a1 && main.a2 && main.a4)) ) || (main.active_dynamic && main.a3) ||( isHelper(e) && main.evacuation.helper_targetline[main.evacuation.helper.indexOf(e)].getGround()==main.secondGround ) || ( e.getColor()==green && main.evacuation.helper_targetline[indexOf(main.evacuation.helpee, e)].getGround()==main.secondGround )) || (main.active_dynamic && main.coffee.contains(e.getX(), e.getY()) && main.a3_4==true && !(isHelper(e)) &&!(e.getColor()==green) ) || !(main.active_dynamic==true)   )
			main.evacuation.pedChangeGround.cancel(e);
			main.evacuation.pedChangeGround2.cancel(e);
			
			
		}//not helper...
		
		else if(e.getComfortableSpeed(MPS)>0.6)
		e.setComfortableSpeed(e.getComfortableSpeed(MPS)/2, MPS);

	}//containsss
	
	else if(e.getComfortableSpeed(MPS)<=0.5)//not contains in fire
	e.setComfortableSpeed(uniform(0.54, 0.8), MPS);
	
		
	}//not dead
 

	}//for visitor

}//for myagent


 
  }

 
  
Ground 
 get_agent_Grnd( MyAgent ag ) { 

Ground g=null;
if(main.rectangle1.contains(ag.getX()+40, ag.getY()+150))
g=main.firstGround;
else if(main.rectangle3.contains(ag.getX()+40, ag.getY()+150))
g=main.secondGround;


return g;
	
 
  }

 
  void getClosestperson3( MyAgent ag ) { 

if(ag!=null)
{
double dst = 80.0;
Ground grnd;

grnd=get_agent_Grnd(ag);
if(grnd==main.secondGround)
  dst=170;
  else
  dst=170;
 for (Visitor e : main.visitor){
 if(e!=null)
 {
 if( e.getGround()== grnd && !(e.inState(Visitor.dead))){

	if(main.oval12.contains( e.getX(),  e.getY()))
	{
	
	if( !isHelper(e) && e.getColor()!=green){
	e.ped_infire=true;
	main.evacuation.pedGoToExit.cancel(e);
	main.evacuation.pedGoToExit1.cancel(e);
	main.evacuation.pedGoToExit2.cancel(e);
	main.evacuation.pedGoToExit4.cancel(e);
	main.evacuation.pedWindowWait.cancel(e);
	//main.evacuation.pedLongWait.free(e);
	main.evacuation.pedLongWait.cancel(e);
	main.evacuation.pedChangeGround.cancel(e);
	main.evacuation.pedChangeGround2.cancel(e);
	}//not helper...
	else if(e.getComfortableSpeed(MPS)>0.5)
	e.setComfortableSpeed(e.getComfortableSpeed(MPS)/2, MPS);

	}//containsss
	
	else//not contains in fire
	e.setComfortableSpeed(uniform(0.54, 0.8), MPS);
	
		
	}//not dead
	
///////for oval 13 ///////
//############
if(main.oval13.getX()==main.myAgent.get(5).getX()+40)//oval13= 2 floor
{
if( e.getGround()== main.secondGround && !(e.inState(Visitor.dead))){
	if(main.oval13.contains( e.getX(),  e.getY()))
	{
	if( !isHelper(e) && e.getColor()!=green){
	e.ped_infire=true;
	main.evacuation.pedGoToExit.cancel(e);
	main.evacuation.pedGoToExit1.cancel(e);
	main.evacuation.pedGoToExit2.cancel(e);
	main.evacuation.pedWindowWait.cancel(e);
	main.evacuation.pedGoToExit4.cancel(e);;
	//main.evacuation.pedLongWait.free(e);
	main.evacuation.pedLongWait.cancel(e);
	main.evacuation.pedChangeGround.cancel(e);
	main.evacuation.pedChangeGround2.cancel(e);
	}//is not helper
	
	else if(e.getComfortableSpeed(MPS)>0.5)
	e.setComfortableSpeed(e.getComfortableSpeed(MPS)/2, MPS);

}//containssss
	
	else//not contains in fire
	e.setComfortableSpeed(uniform(0.54, 0.8), MPS);
	
	}//not dead

}//oval13

else if(main.oval13.getX()==main.myAgent.get(0).getX()+40 )//oval13= 1 floor
{
if( e.getGround()== main.firstGround && !(e.inState(Visitor.dead))){
	if(main.oval13.contains( e.getX(),  e.getY()))
	{
	if( !isHelper(e) && e.getColor()!=green){
	main.evacuation.pedGoToExit.cancel(e);
	main.evacuation.pedGoToExit1.cancel(e);
	main.evacuation.pedGoToExit2.cancel(e);
	main.evacuation.pedWindowWait.cancel(e);
	main.evacuation.pedGoToExit4.cancel(e);;
	//main.evacuation.pedLongWait.free(e);
	main.evacuation.pedLongWait.cancel(e);
	main.evacuation.pedChangeGround.cancel(e);
	main.evacuation.pedChangeGround2.cancel(e);
	}//not is helper
		
	else if(e.getComfortableSpeed(MPS)>0.5)
	e.setComfortableSpeed(e.getComfortableSpeed(MPS)/2, MPS);


	}//containssss	
	
	else//not contains in fire
	e.setComfortableSpeed(uniform(0.54, 0.8), MPS);
	
	}//not dead


}//oval13

}//if e!=null

}//for2

}//first if
 
  }

 
  
boolean 
 isHelper( Agent ped ) { 

return ped instanceof Help; 
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
g=332;
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
g=332;
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

 
  
boolean 
 get_equality_area( int sensor, int fire ) { 

boolean  g=false;


if(sensor==fire)
g=true;

else if( (sensor==888 && fire==12) || (sensor==666 && fire==12) ||(sensor==444 && fire==33) || (sensor==333 && fire==332) || (sensor==555 && fire==332) || (sensor==222 && fire==4) || (sensor==777 && fire==4)|| (sensor==5 && fire==32) )
g=true;

else if(  (sensor==332 && fire==12) || (sensor==12 && fire==332) || (sensor==331 && fire==332) || (sensor==332 && fire==331) )
g=true;

else if(  (sensor==111 && fire==331) || (sensor==331 && fire==111) || (sensor==11 && fire==12) || (sensor==12 && fire==11) )
g=true;

else if(sensor==111 && fire==2|| sensor==2 && fire==111|| (sensor==12 && fire==4) || (sensor==4 && fire==12) || (sensor==33 && fire==3) || (sensor==3 && fire==33) )
g=true;

else if(  (sensor==3 && fire==32) || (sensor==32 && fire==3) || (sensor==4 && fire==2) || (sensor==2 && fire==4) )
g=true;

return g;
	
 
  }
  // View areas
  @AnyLogicInternalCodegenAPI
  protected static final int _oval = 1;

  /** Internal constant, shouldn't be accessed by user */
  @AnyLogicInternalCodegenAPI
  protected static final int _SHAPE_NEXT_ID_xjal = 2;
 

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
      case _oval:
        if (true) {
          ShapeOval self = this.oval;
          
//@ predicted dynamic
main.block=true;
main.cafeteriaOpen=false;
main.safe_exit=getsafestExit(this);
main.fire_center=this;


//main.add_myAgent();
//main.myAgent.get(1).setXY(main.myAgent.get(0).getX()+120, main.myAgent.get(0).getY());

//double x=toLengthUnits(getDistance(main.myAgent.get(0).getX(), main.myAgent.get(0).getY(), main.myAgent.get(1).getX(), main.myAgent.get(1).getY()),METER);

main.oval12.setPos(this.getX()+40, this.getY()+150);

if(main.rectangle1.contains(this.getX()+40, this.getY()+150))
{floor_num=1;
main.floor_num_main=1;
}
else if(main.rectangle3.contains(this.getX()+40, this.getY()+150))
{floor_num=2;
main.floor_num_main=2;}


int k=0; int j=0;

for(MyAgent ag :main.myAgent){
	if(main.rectangle1.contains(ag.getX()+40, ag.getY()+150))
	{main.floor1_agents[k]=ag;
	k++;
	
	} 
	else if(main.rectangle3.contains(ag.getX()+40, ag.getY()+150))
	{main.floor2_agents[j]=ag;
	j++;
	
	}
}




statechart.receiveMessage("Ignition");

main.alarm=true;

 
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
  private void _oval_SetDynamicParams_xjal( ShapeOval shape ) {
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
    shape.setRotation(
 
);
    shape.setLineColor(
 
);
    shape.setFillColor(
 
);
    shape.setRadius(
 
);
    shape.setZHeight(
 
);
    shape.setScaleX(
 
);
    shape.setScaleY(
 
);
    shape.setScaleZ(
 
);
    shape.setLineWidth(
 
);
    shape.setLineStyle(
 
);
 	}
  }
  
  protected ShapeOval oval;
  @AnyLogicInternalCodegenAPI
  private void _createPersistentElementsBP0_xjal() {
    oval = new ShapeOval(
       SHAPE_DRAW_2D, true,0.0, 0.0, 0.0, 0.0, 
       null, black,
	   5.0, 5.0, 0.0, 1.0, LINE_STYLE_SOLID ) {
      @Override
      public void updateDynamicProperties(boolean publicOnly) {
        _oval_SetDynamicParams_xjal( this );
        super.updateDynamicProperties(publicOnly);
      }

      @Override
      @AnyLogicInternalCodegenAPI
      public boolean onClick( double clickx, double clicky ) {
        return onShapeClick( _oval, 0, clickx, clicky );
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
      case _oval: return oval;
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
      _name_xjal = checkNameOfShape_xjal( _shape, oval, "oval" ); if (_name_xjal != null) return _name_xjal;
    } catch (Exception e) {
      return null;
    }
    return super.getNameOfShape_xjal( _shape );
  }
  @AnyLogicInternalCodegenAPI
  protected static final int[] _Ignition_pointsX_xjal = {220, 230, };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _Ignition_pointsY_xjal = {90, 170, };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _go_pointsX_xjal = {260, 250, };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _go_pointsY_xjal = {240, 330, };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition4_pointsX_xjal = {190, 210, };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition4_pointsY_xjal = {400, 440, };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition1_pointsX_xjal = {250, 250, 240, };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition1_pointsY_xjal = {440, 420, 400, };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition2_pointsX_xjal = {240, 240, };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition2_pointsY_xjal = {470, 592, };

  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition3_pointsX_xjal = {170, 237, };
  @AnyLogicInternalCodegenAPI
  protected static final int[] _transition3_pointsY_xjal = {400, 592, };


  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Events_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawEvent( _panel, _g, 300, 600, 10, 0, "check_dead", check_dead );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Statecharts_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawState( _panel, _g, 180, 60, 100, 30, 10, 10, "Normal", GOLD, Normal, statechart );
    }
    if (!_publicOnly) {
      drawState( _panel, _g, 170, 170, 100, 70, 10, 10, "Burning", GOLD, Burning, statechart );
    }
    if (!_publicOnly) {
      drawState( _panel, _g, 160, 330, 120, 70, 10, 10, "burneddoor", GOLD, burneddoor, statechart );
    }
    if (!_publicOnly) {
      drawState( _panel, _g, 200, 440, 100, 30, 10, 10, "doors", GOLD, doors, statechart );
    }
    if (!_publicOnly) {
      drawFinalState( _panel, _g, 240, 600, 10, 0, null,  finalState, statechart );
    }
    if (!_publicOnly) {
      drawTransition(_panel, _g, _Ignition_pointsX_xjal, _Ignition_pointsY_xjal, 140, 110, "Ignition", Ignition, TransitionIcon.MESSAGE, 227, 149 );
    }
    if (!_publicOnly) {
      drawStatechartEntryPoint( _panel, _g, 230, 20, 230, 60, 205, 0, "statechart",  statechart );
    }
    if (!_publicOnly) {
      drawTransition(_panel, _g, _go_pointsX_xjal, _go_pointsY_xjal, 180, 260, "go", go, TransitionIcon.TIMEOUT, 257, 259 );
    }
    if (!_publicOnly) {
      drawTransition(_panel, _g, _transition1_pointsX_xjal, _transition1_pointsY_xjal, 260, 440, null, transition1, TransitionIcon.TIMEOUT, 250, 420 );
    }
    if (!_publicOnly) {
      drawTransition(_panel, _g, _transition2_pointsX_xjal, _transition2_pointsY_xjal, 250, 470, null, transition2, TransitionIcon.CONDITION, 240, 490 );
    }
    if (!_publicOnly) {
      drawTransition(_panel, _g, _transition4_pointsX_xjal, _transition4_pointsY_xjal, 200, 400, null, transition4, TransitionIcon.TIMEOUT, 203, 426 );
    }
    if (!_publicOnly) {
      drawTransition(_panel, _g, _transition3_pointsX_xjal, _transition3_pointsY_xjal, 180, 400, null, transition3, TransitionIcon.CONDITION, 189, 456 );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Parameters_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawParameter( _panel, _g, 450, 390, 10, 0, "exits", exits, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 450, 440, 15, 5, "waitTime1", waitTime1, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 450, 420, 10, 0, "connectedag1", connectedag1, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 450, 470, 10, 0, "finished", finished, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 570, 650, 15, 5, "times", times, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 450, 500, 10, 0, "alldoor", alldoor, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 440, 140, 20, 0, "dis_from_fire2", dis_from_fire2, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 440, 160, 20, 0, "time_to_fire", time_to_fire, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 480, 560, 10, 0, "allexits", allexits, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 460, 520, 15, 5, "waitTime2", waitTime2, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 300, 680, 15, 5, "name", name, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 180, 760, 10, 0, "n1", n1, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 150, 790, 10, 0, "n2", n2, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 220, 780, 10, 0, "n3", n3, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 230, 760, 10, 0, "n4", n4, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 320, 790, 10, 0, "s11", s11, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 280, 840, 10, 0, "s12", s12, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 140, 820, 10, 0, "s7", s7, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 180, 880, 10, 0, "s10", s10, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 150, 670, 10, 0, "current", current, 0 );
    }
    if (!_publicOnly) {
      drawParameter( _panel, _g, 70, 630, 10, 0, "check", check, 0 );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_PlainVariables_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 410, 570, 10, 0, "ind", ind, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 440, 110, 10, 0, "indx", indx, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 440, 70, 10, 0, "floor_num", floor_num, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 490, -10, 10, 0, "indxof_firstotherfloor", indxof_firstotherfloor, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 80, 570, 10, 0, "indd", indd, false );
    }
    if (!_publicOnly) {
      drawPlainVariable( _panel, _g, 30, 520, 10, 0, "counter", counter, false );
    }
  }

  @AnyLogicInternalCodegenAPI
  private void drawModelElements_Functions_xjal(Panel _panel, Graphics2D _g, boolean _publicOnly, boolean _isSuperClass ) {
    if (!_publicOnly) {
      drawFunction( _panel, _g, 450, 240, 10, 0, "getsafestExit");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 450, 210, 10, 0, "getClosestagent");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 450, 270, 10, 0, "toString");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 440, 300, 10, 0, "getClosestdoor");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 420, 330, 10, 0, "getClosestperson2");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 430, 180, 10, 0, "get_agent_Grnd");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 430, 360, 10, 0, "getClosestperson3");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 420, 690, 10, 0, "isHelper");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 620, 240, 10, 0, "get_area_sensor");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 650, 340, 10, 0, "get_area_visitor");
    }
    if (!_publicOnly) {
      drawFunction( _panel, _g, 640, 150, 10, 0, "get_equality_area");
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
    drawModelElements_Events_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_Statecharts_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_Parameters_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_PlainVariables_xjal( _panel, _g, _publicOnly, _isSuperClass );
    drawModelElements_Functions_xjal( _panel, _g, _publicOnly, _isSuperClass );
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
  private boolean onClickModelAt_Parameters_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 450, 390) ) {
      _panel.addInspect( 450, 390, this, "exits" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 450, 440) ) {
      _panel.addInspect( 450, 440, this, "waitTime1" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 450, 420) ) {
      _panel.addInspect( 450, 420, this, "connectedag1" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 450, 470) ) {
      _panel.addInspect( 450, 470, this, "finished" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 570, 650) ) {
      _panel.addInspect( 570, 650, this, "times" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 450, 500) ) {
      _panel.addInspect( 450, 500, this, "alldoor" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 440, 140) ) {
      _panel.addInspect( 440, 140, this, "dis_from_fire2" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 440, 160) ) {
      _panel.addInspect( 440, 160, this, "time_to_fire" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 480, 560) ) {
      _panel.addInspect( 480, 560, this, "allexits" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 460, 520) ) {
      _panel.addInspect( 460, 520, this, "waitTime2" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 300, 680) ) {
      _panel.addInspect( 300, 680, this, "name" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 180, 760) ) {
      _panel.addInspect( 180, 760, this, "n1" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 150, 790) ) {
      _panel.addInspect( 150, 790, this, "n2" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 220, 780) ) {
      _panel.addInspect( 220, 780, this, "n3" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 230, 760) ) {
      _panel.addInspect( 230, 760, this, "n4" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 320, 790) ) {
      _panel.addInspect( 320, 790, this, "s11" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 280, 840) ) {
      _panel.addInspect( 280, 840, this, "s12" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 140, 820) ) {
      _panel.addInspect( 140, 820, this, "s7" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 180, 880) ) {
      _panel.addInspect( 180, 880, this, "s10" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 150, 670) ) {
      _panel.addInspect( 150, 670, this, "current" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 70, 630) ) {
      _panel.addInspect( 70, 630, this, "check" ); 
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_PlainVariables_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 410, 570) ) {
      _panel.addInspect( 410, 570, this, "ind" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 440, 110) ) {
      _panel.addInspect( 440, 110, this, "indx" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 440, 70) ) {
      _panel.addInspect( 440, 70, this, "floor_num" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 490, -10) ) {
      _panel.addInspect( 490, -10, this, "indxof_firstotherfloor" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 80, 570) ) {
      _panel.addInspect( 80, 570, this, "indd" ); 
      return true;
    }
    if( !_publicOnly && modelElementContains(_x, _y, 30, 520) ) {
      _panel.addInspect( 30, 520, this, "counter" ); 
      return true;
    }
    return false;
  }

  @AnyLogicInternalCodegenAPI
  private boolean onClickModelAt_Events_xjal( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if( !_publicOnly && modelElementContains(_x, _y, 300, 600) ) {
      _panel.addInspect( 300, 600, this, "check_dead" ); 
      return true;
    }
    return false;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean onClickModelAt( Panel _panel, double _x, double _y, int _clickCount, boolean _publicOnly, boolean _isSuperClass ) {
    if ( onClickModelAt_AgentLinks_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_Parameters_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_PlainVariables_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
    if ( onClickModelAt_Events_xjal( _panel, _x, _y, _clickCount, _publicOnly, _isSuperClass ) ) { return true; }
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
  public MyAgent( Engine engine, Agent owner, AgentList<? extends MyAgent> ownerPopulation ) {
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
  public MyAgent() {
  }
  
  /**
   * Simple constructor. Please add created agent to some population by calling goToPopulation() function
   */
  public MyAgent( ArrayList<TargetLine> exits, double waitTime1, MyAgent[] connectedag1, boolean finished, double times, int alldoor, double[] dis_from_fire2, double[] time_to_fire, ArrayList<TargetLine> allexits, double waitTime2, int name, int n1, int n2, int n3, int n4, MyAgent[] s11, MyAgent[] s12, MyAgent[] s7, MyAgent[] s10, MyAgent[] current, boolean check ) {
    markParametersAreSet();
    this.exits = exits;
    this.waitTime1 = waitTime1;
    this.connectedag1 = connectedag1;
    this.finished = finished;
    this.times = times;
    this.alldoor = alldoor;
    this.dis_from_fire2 = dis_from_fire2;
    this.time_to_fire = time_to_fire;
    this.allexits = allexits;
    this.waitTime2 = waitTime2;
    this.name = name;
    this.n1 = n1;
    this.n2 = n2;
    this.n3 = n3;
    this.n4 = n4;
    this.s11 = s11;
    this.s12 = s12;
    this.s7 = s7;
    this.s10 = s10;
    this.current = current;
    this.check = check;
  }
  
  @Override
  @AnyLogicInternalCodegenAPI
  public void doCreate() {
    super.doCreate();
    // Assigning initial values for plain variables
    setupPlainVariables_MyAgent_xjal();
    // Dynamic initialization of persistent elements
    _createPersistentElementsAP0_xjal();
    presentation = new ShapeTopLevelPresentationGroup( MyAgent.this, true, 0, 0, 0, 0 , oval );
    icon = new ShapeModelElementsGroup( MyAgent.this, getElementProperty( "evacuation.MyAgent.icon", IElementDescriptor.MODEL_ELEMENT_DESCRIPTORS )  );
    icon.setIconOffsets( 0.0, 0.0 );
	 // Port connectors with non-replicated objects
    // Creating replicated embedded objects
    setupInitialConditions_xjal( MyAgent.class );
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
    check_dead.start();
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
    setupPlainVariables_MyAgent_xjal();
  }

  /**
   * Assigning initial values for plain variables<br>
   * <em>This method isn't designed to be called by user and may be removed in future releases.</em>
   */
  @AnyLogicInternalCodegenAPI
  private void setupPlainVariables_MyAgent_xjal() {
    ind = 
0 
;
    indx = 
0 
;
    floor_num = 
0 
;
    indxof_firstotherfloor = 
0 
;
    indd = 
0 
;
    counter = 
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
  protected static final Color _connections_LineColor = new Color( 0xACC0C0C0, true );
  @AnyLogicInternalCodegenAPI
  static LinkToAgentAnimationSettings _connections_commonAnimationSettings_xjal = new LinkToAgentAnimationSettingsImpl( true, _connections_LineColor, 1.0, LINE_STYLE_SOLID, ARROW_NONE, 0.0 );

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
    
 
    statechart.fireEvent( _msg_xjal );
    statechart.fireEvent( _msg_xjal );
  }



  @AnyLogicInternalCodegenAPI
  public void drawLinksToAgents(boolean _underAgents_xjal, LinkToAgentAnimator _animator_xjal) {
    super.drawLinksToAgents(_underAgents_xjal, _animator_xjal);
    if ( _underAgents_xjal ) {
      _animator_xjal.drawLink( this, connections, true, true );
    }
  }

  public AgentList<? extends MyAgent> getPopulation() {
    return (AgentList<? extends MyAgent>) super.getPopulation();
  }

  public List<? extends MyAgent> agentsInRange( double distance ) {
    return (List<? extends MyAgent>) super.agentsInRange( distance );
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(LoggingType loggingType) {
    return false;
  }

  @Override
  @AnyLogicInternalCodegenAPI
  public boolean isLoggingToDB(EventOriginator _e) {
    if ( _e == check_dead ) return false;
    return super.isLoggingToDB( _e );
  }

  // Reaction on changes -------------------------------------
  public void onChange() {
    super.onChange();
    statechart.onChange();
  }

  @AnyLogicInternalCodegenAPI
  public void onDestroy() {
    check_dead.onDestroy();
    statechart.onDestroy();
    // On destroy code
    
 
    super.onDestroy();
  }

  // Additional class code

 
  // End of additional class code


}
